package com.huawei.nfc.carrera.logic.cardoperate.cup.install;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushServiceManager;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicPathConfig;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.HandleInstallCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.logic.spi.unionpay.response.CUPEncryptResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaBadParammeterException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardAlreadyExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNumReachMaxException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.model.CipheredCardInfo;
import com.huawei.nfc.carrera.server.card.model.RiskInfo;
import com.huawei.nfc.carrera.server.card.request.ApplyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.request.NullifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.ApplyUPCardResponse;
import com.huawei.nfc.carrera.server.card.response.NullifyCardResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.utils.SHA_256;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Map;

public class InstallCupCardTask extends DownloadObserver implements Runnable {
    private static final String ENCRYPT_INFO_SEPARATOR = "|";
    private static final String TAG = "InstallCupCardTask";
    private final CUPService cupServiceApi;
    private final OpenCardInfo inputCardInfo;
    private final CardServerApi mServerApi;

    public InstallCupCardTask(Context context, CardServerApi cardServerApi, CUPService cUPService, OpenCardInfo openCardInfo, HandleInstallCardResultTask handleInstallCardResultTask, CUPCardOperator cUPCardOperator) {
        super(context, handleInstallCardResultTask, cUPCardOperator, cardServerApi);
        this.mServerApi = cardServerApi;
        this.cupServiceApi = cUPService;
        this.inputCardInfo = openCardInfo;
    }

    public void run() {
        String inputInfoStr = getInputInfoStr();
        if (StringUtil.isEmpty(inputInfoStr, true)) {
            LogX.e("input info illegal.");
            handleResult(-99, null, null);
            return;
        }
        CUPEncryptResponse encryptCardInfo = this.cupServiceApi.encryptCardInfo(inputInfoStr);
        int checkEncrytedResponseCode = checkEncrytedResponseCode(encryptCardInfo);
        if (checkEncrytedResponseCode != 0) {
            LogX.d("encrypt info failed.");
            handleResult(checkEncrytedResponseCode, null, null);
        } else if (StringUtil.isEmpty(encryptCardInfo.encrytedStr, true)) {
            LogX.e("encrypt response illegal.");
            handleResult(-99, null, null);
        } else {
            NFCPushServiceManager.getInstance(this.mContext).getPushToken();
            CipheredCardInfo cipheredCardInfo = new CipheredCardInfo(encryptCardInfo.encrytedStr, this.inputCardInfo.getPwd());
            RiskInfo riskInfo = new RiskInfo(this.mContext, this.inputCardInfo.getCaptureMethod(), this.inputCardInfo.getLocation());
            ApplyCUPCardRequest applyCUPCardRequest = new ApplyCUPCardRequest();
            applyCUPCardRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
            applyCUPCardRequest.setRsaKeyIndex(-1);
            applyCUPCardRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
            applyCUPCardRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
            applyCUPCardRequest.setCardInfor(cipheredCardInfo);
            applyCUPCardRequest.setRiskInfo(riskInfo);
            ApplyUPCardResponse applyCUPCard = this.mServerApi.applyCUPCard(applyCUPCardRequest);
            int checkApplyCardResponse = checkApplyCardResponse(applyCUPCard);
            LogX.i("===123===leibinsheng 申卡结果apply cup card apply result: " + checkApplyCardResponse);
            if (checkApplyCardResponse != 0) {
                handleResult(checkApplyCardResponse, null, null);
                return;
            }
            if (applyCUPCard.virtualCardMetadata == null || StringUtil.isEmpty(applyCUPCard.virtualCardMetadata.virtualCardRefId, true) || StringUtil.isEmpty(applyCUPCard.virtualCardMetadata.virtualCardNum, true) || applyCUPCard.cardMetadata == null || StringUtil.isEmpty(applyCUPCard.cardMetadata.getCardProductId(), true)) {
                checkApplyCardResponse = true;
            } else {
                checkApplyCardResponse = 0;
            }
            if (checkApplyCardResponse != 0) {
                LogX.e("apply cup card, virtual card info illegal.");
                handleResult(-99, null, null);
                return;
            }
            inputInfoStr = applyCUPCard.virtualCardMetadata.virtualCardRefId;
            String cardProductId = applyCUPCard.cardMetadata.getCardProductId();
            if (isCardDownload(applyCUPCard.virtualCardMetadata.virtualCardRefId)) {
                LogX.i("The card already download, return success.");
                handleResult(0, cardProductId, inputInfoStr);
                return;
            }
            C2538c.b(TAG, new Object[]{"InstallCupCardTask CardEvent DOWNLOAD bank cardEvent START_LOCK"});
            WalletTaManager.getInstance(this.mContext).cardEvent(inputInfoStr, 2);
            int addCardIntoTa = addCardIntoTa(applyCUPCard);
            LogX.i("===123===leibinsheng 添加到TA结果 add cup card into ta result: " + addCardIntoTa);
            if (addCardIntoTa != 0) {
                handleResult(addCardIntoTa, null, null);
                return;
            }
            LogX.i("===123===leibinsheng进入绑定 observeDownloadResult");
            observeDownloadResult(inputInfoStr, cardProductId);
        }
    }

    private String getInputInfoStr() {
        LogX.e("enter getInputInfoStr");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.inputCardInfo.getCardNum()).append(ENCRYPT_INFO_SEPARATOR);
        if (this.inputCardInfo.getCardType() == 2) {
            stringBuilder.append(this.inputCardInfo.getPhone());
        } else if (this.inputCardInfo.getCardType() == 3) {
            stringBuilder.append(this.inputCardInfo.getDate()).append(ENCRYPT_INFO_SEPARATOR).append(this.inputCardInfo.getCvv2()).append(ENCRYPT_INFO_SEPARATOR).append(this.inputCardInfo.getPhone());
        } else {
            LogX.e("getInputInfoStr, illegal card type.");
            return null;
        }
        return stringBuilder.toString();
    }

    private int checkEncrytedResponseCode(CUPEncryptResponse cUPEncryptResponse) {
        LogX.i("encrypt response code: " + cUPEncryptResponse.responseCode);
        if (cUPEncryptResponse.responseCode == 0) {
            return 0;
        }
        if (-3 == cUPEncryptResponse.responseCode) {
            return -4;
        }
        if (-1 == cUPEncryptResponse.responseCode) {
            return -5;
        }
        return -99;
    }

    private int checkApplyCardResponse(ApplyUPCardResponse applyUPCardResponse) {
        boolean z = false;
        if (applyUPCardResponse == null) {
            LogX.e("checkApplyCardResponse, response is illegal.");
            return -99;
        }
        LogX.e("===123===checkApplyCardResponse response = " + applyUPCardResponse.returnCode);
        switch (applyUPCardResponse.returnCode) {
            case -4:
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "InstallCupCardTask server overload 503");
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_OVERLOAD_ERR, hashMap, "checkApplyCardResponse retrun code server overload", false, false);
                z = true;
                break;
            case -2:
                z = true;
                break;
            case -1:
                z = true;
                break;
            case 0:
                break;
            case ApplyUPCardResponse.ERR_APPLY_EXCEED_LIMIT1 /*1309*/:
            case 3603:
            case 3605:
                z = true;
                break;
            case ApplyUPCardResponse.ERR_ALREADY_ASSOCIATED_CARD /*1317*/:
            case ApplyUPCardResponse.ERR_ALREADY_ASSOCIATED_CARD2 /*3317*/:
                z = true;
                break;
            case ApplyUPCardResponse.ERR_ON_RISK /*1901*/:
                z = true;
                break;
            case ApplyUPCardResponse.ERR_INFORMATION_CHECK_FAILED /*3601*/:
            case ApplyUPCardResponse.ERR_INFORMATION_CHECK_FAILED2 /*3602*/:
                z = true;
                break;
            case ApplyUPCardResponse.ERR_NO_APPLICATION_PERMISSION /*3608*/:
                z = true;
                break;
            case 3609:
                z = true;
                break;
            case ApplyUPCardResponse.ERR_NO_PHONE /*3610*/:
                z = true;
                break;
            default:
                Map hashMap2 = new HashMap();
                hashMap2.put(CloudEyeLogger.FAIL_CODE, String.valueOf(applyUPCardResponse.returnCode));
                hashMap2.put("issuerID", String.valueOf(this.inputCardInfo.getIssuerId()));
                hashMap2.put(Constant.KEY_CARD_TYPE, String.valueOf(this.inputCardInfo.getCardType()));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_APPLE_CARD_ERR, hashMap2, "apply card err", true, false);
                z = true;
                break;
        }
        return z;
    }

    private int addCardIntoTa(ApplyUPCardResponse applyUPCardResponse) {
        if (applyUPCardResponse.virtualCardMetadata == null || StringUtil.isEmpty(applyUPCardResponse.virtualCardMetadata.virtualCardRefId, true) || StringUtil.isEmpty(applyUPCardResponse.virtualCardMetadata.virtualCardNum, true)) {
            LogX.d("addCardIntoTa virtualCardMetadata response illegal.");
            return -99;
        }
        String str = applyUPCardResponse.virtualCardMetadata.virtualCardRefId;
        if (WalletTaManager.getInstance(this.mContext).getCard(str) != null) {
            LogX.i("apply cup card, but the card existed in ta.refId: " + str);
            return 0;
        } else if (applyUPCardResponse.cardMetadata == null || StringUtil.isEmpty(applyUPCardResponse.cardMetadata.getCardProductId(), true)) {
            LogX.d("addCardIntoTa cardMetadata response illegal.");
            return -99;
        } else {
            TACardInfo tACardInfo = new TACardInfo();
            tACardInfo.aid = "" + System.currentTimeMillis();
            tACardInfo.cardGroupType = 1;
            tACardInfo.fpanDigest = SHA_256.m28475a(this.inputCardInfo.getCardNum(), null);
            tACardInfo.fpanFour = getCardNumEndFour(this.inputCardInfo.getCardNum());
            tACardInfo.dpanDigest = applyUPCardResponse.virtualCardMetadata.virtualCardRefId;
            tACardInfo.dpanFour = getCardNumEndFour(applyUPCardResponse.virtualCardMetadata.virtualCardNum);
            tACardInfo.cardType = this.inputCardInfo.getCardType();
            tACardInfo.issuerId = this.inputCardInfo.getIssuerId();
            tACardInfo.productId = applyUPCardResponse.cardMetadata.getCardProductId();
            tACardInfo.background_file_name = tACardInfo.productId + CardPicPathConfig.WALLET_CARD_ICON_STORAGE_NAME;
            tACardInfo.cardStatus = 98;
            try {
                WalletTaManager.getInstance(this.mContext).addCard(tACardInfo);
                return 0;
            } catch (WalletTaCardAlreadyExistException e) {
                LogX.e("addCardIntoTa, card already exist");
                return -99;
            } catch (WalletTaCardNumReachMaxException e2) {
                LogX.e("addCardIntoTa, reach max exception");
                return -6;
            } catch (WalletTaBadParammeterException e3) {
                LogX.e("addCardIntoTa, bad param exception");
                return -4;
            } catch (WalletTaSystemErrorException e4) {
                LogX.e("addCardIntoTa, bad param exception");
                return -99;
            }
        }
    }

    private String getCardNumEndFour(String str) {
        return str.substring(str.length() - 4);
    }

    void cleanUnstartedData(String str) {
        LogX.d("===123====cleanUnstartedData");
        Map hashMap = new HashMap();
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "InstallCupCardTask, does not receive download push!");
        hashMap.put("refID", str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_UNRECEIVE_UP_DOWNLOAD_PUSH, hashMap, null, false, false);
        NullifyCUPCardRequest nullifyCUPCardRequest = new NullifyCUPCardRequest();
        nullifyCUPCardRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        nullifyCUPCardRequest.setRsaKeyIndex(-1);
        nullifyCUPCardRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        nullifyCUPCardRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        nullifyCUPCardRequest.cardRefId = str;
        NullifyCardResponse nullifyCUPCard = this.mServerApi.nullifyCUPCard(nullifyCUPCardRequest);
        if (nullifyCUPCard != null && nullifyCUPCard.returnCode == 0) {
            LogX.d("===123===服务器删除  response.returnCode = " + nullifyCUPCard.returnCode);
            try {
                WalletTaManager.getInstance(this.mContext).removeCard(str);
                LogX.d("===123===removeCard");
            } catch (WalletTaCardNotExistException e) {
                LogX.e("cleanUnstartedData WalletTaCardNotExistException");
            } catch (WalletTaSystemErrorException e2) {
                LogX.e("cleanUnstartedData WalletTaSystemErrorException");
            }
        }
    }
}
