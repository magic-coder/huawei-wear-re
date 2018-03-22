package com.huawei.nfc.carrera.logic.cardoperate.citic.acvite;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteAppletTsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.ESEInfoManagerApi;
import com.huawei.nfc.carrera.logic.spi.citic.request.ActivateCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.CardServerBaseRequest;
import com.huawei.nfc.carrera.server.card.response.SignDataResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

public abstract class ActiveBaseCardTask implements Runnable {
    protected Context mContext;
    private final String mRefId;
    private final HandleActiveCardResultTask mResultTask;
    private final String mVerifyCode;

    class SetCardDefaultCallbackImpl implements SetCardDefaultCallback {
        SetCardDefaultCallbackImpl() {
        }

        public void setResultCallback(int i) {
            LogX.i("ActveBaseCardTask,set default card success");
        }
    }

    protected abstract String getBankRsaIndex();

    protected abstract String getVerifyToken();

    protected abstract void reportCardOpenedAvailableStatus(TACardInfo tACardInfo);

    protected abstract ActivateOrNullifyCardResponse requestBankActivateCard(ActivateCardRequest activateCardRequest);

    protected abstract void setVerifyToken(String str);

    public ActiveBaseCardTask(Context context, String str, String str2, HandleActiveCardResultTask handleActiveCardResultTask) {
        this.mContext = context;
        this.mRefId = str;
        this.mVerifyCode = str2;
        this.mResultTask = handleActiveCardResultTask;
    }

    public void run() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.e("active, but the product not existed in TA, refId: " + this.mRefId);
            this.mResultTask.notifyActiveResult(-99);
            return;
        }
        ActivateCardRequest buildActiveCardRequest = buildActiveCardRequest(card.aid);
        if (buildActiveCardRequest == null) {
            LogX.e("active, active request is illegal.");
            this.mResultTask.notifyActiveResult(-99);
            return;
        }
        ActivateOrNullifyCardResponse requestBankActivateCard = requestBankActivateCard(buildActiveCardRequest);
        if (requestBankActivateCard == null) {
            LogX.e("active, active response is illegal.");
            this.mResultTask.notifyActiveResult(-99);
            return;
        }
        LogX.d("active card response code: " + requestBankActivateCard.getResultCode());
        this.mResultTask.notifyActiveResult(handleRequestBackActivteResult(card, requestBankActivateCard));
    }

    private int handleRequestBackActivteResult(TACardInfo tACardInfo, ActivateOrNullifyCardResponse activateOrNullifyCardResponse) {
        switch (activateOrNullifyCardResponse.getResultCode()) {
            case ActivateOrNullifyCardResponse.RESULT_CODE_DEL_APP /*-34*/:
                return cleanLocalData(this.mRefId, tACardInfo, null, null);
            case ActivateOrNullifyCardResponse.RESULT_CODE_AUTH_CODE_UNMATCH /*-33*/:
                return -4;
            case ActivateOrNullifyCardResponse.RESULT_CODE_AUTH_CODE_EFFICACY /*-32*/:
                return -3;
            case -8:
                return -8;
            case -5:
                return -1;
            case -4:
                return -2;
            case 0:
                handleActivateSuccess(tACardInfo, activateOrNullifyCardResponse);
                return 0;
            default:
                return -99;
        }
    }

    private void handleActivateSuccess(TACardInfo tACardInfo, ActivateOrNullifyCardResponse activateOrNullifyCardResponse) {
        if (!StringUtil.isEmpty(activateOrNullifyCardResponse.getToken(), true)) {
            setVerifyToken(activateOrNullifyCardResponse.getToken());
        }
        if (updateCardStatusAvailable(this.mRefId)) {
            if (2 != tACardInfo.cardStatus) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
                CardInfoManager.getInstance(this.mContext).setCardDefault(tACardInfo.dpanDigest, new SetCardDefaultCallbackImpl());
            }
            reportCardOpenedByBI(tACardInfo.aid, tACardInfo.productId, tACardInfo.issuerId, tACardInfo.cardType);
            reportCardOpenedAvailableStatus(tACardInfo);
        }
    }

    private ActivateCardRequest buildActiveCardRequest(String str) {
        ActivateCardRequest activateCardRequest = new ActivateCardRequest();
        String verifyToken = getVerifyToken();
        if (StringUtil.isEmpty(verifyToken, true)) {
            String[] activeVerifySign = getActiveVerifySign();
            if (activeVerifySign == null || 2 != activeVerifySign.length) {
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "build active request failed");
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_BUILD_REQUEST_ERR, hashMap, null, false, false);
                return null;
            }
            activateCardRequest.setWalletSignature(activeVerifySign[0]);
            activateCardRequest.setTimeStamp(activeVerifySign[1]);
        } else {
            activateCardRequest.setVerifyToken(verifyToken);
        }
        activateCardRequest.setAid(str);
        activateCardRequest.setSmsCode(this.mVerifyCode);
        ESEInfoManagerApi createESEInfoManagerApi = ESEApiFactory.createESEInfoManagerApi(this.mContext);
        activateCardRequest.setCplc(createESEInfoManagerApi.queryCplc());
        activateCardRequest.setdPan(createESEInfoManagerApi.queryCardNum(str));
        return activateCardRequest;
    }

    private String[] getActiveVerifySign() {
        CardServerBaseRequest cardServerBaseRequest = new CardServerBaseRequest();
        cardServerBaseRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardServerBaseRequest.setRsaKeyIndex(-1);
        cardServerBaseRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        SignDataResponse querySignDataForActivation = ServerServiceFactory.createCardServerApi(this.mContext).querySignDataForActivation(cardServerBaseRequest);
        if (querySignDataForActivation == null || querySignDataForActivation.returnCode != 0) {
            return null;
        }
        return new String[]{querySignDataForActivation.sign, querySignDataForActivation.time};
    }

    private boolean updateCardStatusAvailable(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 2);
            return true;
        } catch (Throwable e) {
            LogX.e("update card status after active card, WalletTaCardNotExistException: " + Log.getStackTraceString(e));
            return false;
        } catch (Throwable e2) {
            LogX.e("update card status after active card, WalletTaSystemErrorException: " + Log.getStackTraceString(e2));
            return false;
        }
    }

    private void reportCardOpenedByBI(String str, String str2, String str3, int i) {
        LogX.d("udpate card status into db after active card.");
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(str2);
        NfcHianalyticsUtil.onReportForCardOpened(this.mContext, str, cacheCardProductInfoItem == null ? "" : cacheCardProductInfoItem.getProductName(), str3, i);
    }

    private int cleanLocalData(String str, TACardInfo tACardInfo, String str2, String str3) {
        boolean updateTACardNullified = updateTACardNullified(str);
        int excute = new DeleteAppletTsmOperator(this.mContext, tACardInfo.aid, null, null, getBankRsaIndex()).excute();
        LogX.d("excute tsm delete applet, result: " + excute);
        if (excute == 0) {
            LogX.d("card nullified in server and deleted, clean local data now.");
            try {
                WalletTaManager.getInstance(this.mContext).removeCard(str);
            } catch (WalletTaException e) {
                LogX.e("deleteCard failed. getCode==" + e.getCode());
            }
            if (updateTACardNullified) {
                if (3 != tACardInfo.cardStatus) {
                    CardInfoManager.getInstance(this.mContext).refreshCardList();
                }
                LogX.d("delete card in local and update ta status to nullified success.");
                return -9;
            }
            LogX.d("delete card in local, but update ta status failed.");
            return -99;
        } else if (-1 == excute || -2 == excute) {
            return -1;
        } else {
            return -99;
        }
    }

    private boolean updateTACardNullified(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 3);
            return true;
        } catch (WalletTaCardNotExistException e) {
            LogX.e("updateTACardStatus, WalletTaCardNotExistException");
            return false;
        } catch (WalletTaSystemErrorException e2) {
            LogX.e("updateTACardStatus, WalletTaSystemErrorException");
            return false;
        }
    }
}
