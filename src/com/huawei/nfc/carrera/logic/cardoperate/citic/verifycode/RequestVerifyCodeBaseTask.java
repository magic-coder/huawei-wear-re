package com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteAppletTsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.ESEInfoManagerApi;
import com.huawei.nfc.carrera.logic.spi.citic.request.SmsCodeRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.SmsCodeResponse;
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

public abstract class RequestVerifyCodeBaseTask implements Runnable {
    public static final int REQUEST_VERIFY_CODE_TYPE_ACTIVE = 1;
    public static final int REQUEST_VERIFY_CODE_TYPE_NULLIFY = 2;
    protected Context mContext;
    private final String mRefId;
    private final int mRequestVerifyCodeType;
    private final HandleVerifyCodeResultTask mResultTask;

    protected abstract String getBankSignRsaIndex();

    protected abstract String getVerifyToken();

    protected abstract void reportCardOpenedAvailableStatus(TACardInfo tACardInfo);

    protected abstract SmsCodeResponse requestBankGetActiveSmsCode(SmsCodeRequest smsCodeRequest);

    protected abstract SmsCodeResponse requestBankGetNullifySmsCode(SmsCodeRequest smsCodeRequest);

    protected abstract void setVerifyToken(String str);

    public RequestVerifyCodeBaseTask(Context context, String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask, int i) {
        this.mContext = context;
        this.mRefId = str;
        this.mResultTask = handleVerifyCodeResultTask;
        this.mRequestVerifyCodeType = i;
    }

    public void run() {
        SmsCodeRequest smsCodeRequest = new SmsCodeRequest();
        smsCodeRequest.setVerifyToken(getVerifyToken());
        String[] verifySign = getVerifySign(this.mRequestVerifyCodeType);
        if (verifySign == null || 2 != verifySign.length) {
            LogX.d("no sign info queried, request sms code failed.");
            handleResult(-99, null);
            return;
        }
        smsCodeRequest.setWalletSignature(verifySign[0]);
        smsCodeRequest.setTimeStamp(verifySign[1]);
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.e("request verify code, but the product not existed in TA, refId: " + this.mRefId);
            handleResult(-99, null);
            return;
        }
        smsCodeRequest.setAid(card.aid);
        ESEInfoManagerApi createESEInfoManagerApi = ESEApiFactory.createESEInfoManagerApi(this.mContext);
        smsCodeRequest.setCplc(createESEInfoManagerApi.queryCplc());
        smsCodeRequest.setdPan(createESEInfoManagerApi.queryCardNum(card.aid));
        SmsCodeResponse requestBankSmsCode = requestBankSmsCode(smsCodeRequest);
        if (requestBankSmsCode == null) {
            LogX.d("request sms code, empty response.");
            handleResult(-99, null);
            return;
        }
        LogX.d("request sms code, result code: " + requestBankSmsCode.getResultCode());
        handleRequestVerifyCodeResult(smsCodeRequest, card, requestBankSmsCode);
    }

    private void handleRequestVerifyCodeResult(SmsCodeRequest smsCodeRequest, TACardInfo tACardInfo, SmsCodeResponse smsCodeResponse) {
        switch (smsCodeResponse.getResultCode()) {
            case SmsCodeResponse.RESULT_CODE_GETSMS_CONTACT_BANK /*-24*/:
                handleResult(-9, null);
                return;
            case SmsCodeResponse.RESULT_CODE_GETSMS_CARD_ACTIVATED /*-23*/:
                if (updateCardStatusAvailable(this.mRefId)) {
                    if (2 != tACardInfo.cardStatus) {
                        CardInfoManager.getInstance(this.mContext).refreshCardList();
                    }
                    reportCardOpenedByBI(tACardInfo.aid, tACardInfo.productId, tACardInfo.issuerId, tACardInfo.cardType);
                    reportCardOpenedAvailableStatus(tACardInfo);
                }
                handleResult(-5, null);
                return;
            case SmsCodeResponse.RESULT_CODE_GETSMS_CARD_NULLIFIED /*-22*/:
                cleanLocalData(this.mRefId, tACardInfo, smsCodeRequest.getWalletSignature(), smsCodeRequest.getTimeStamp());
                return;
            case SmsCodeResponse.RESULT_CODE_GETSMS_EXCEED_LIMIT /*-21*/:
                handleResult(-1, null);
                return;
            case -8:
                handleResult(-8, null);
                return;
            case -5:
                handleResult(-2, null);
                return;
            case -4:
                handleResult(-3, null);
                return;
            case 0:
                if (!StringUtil.isEmpty(smsCodeResponse.getToken(), true)) {
                    setVerifyToken(smsCodeResponse.getToken());
                }
                handleResult(0, smsCodeResponse.phone);
                return;
            default:
                handleResult(-99, null);
                return;
        }
    }

    private SmsCodeResponse requestBankSmsCode(SmsCodeRequest smsCodeRequest) {
        if (1 == this.mRequestVerifyCodeType) {
            return requestBankGetActiveSmsCode(smsCodeRequest);
        }
        if (2 == this.mRequestVerifyCodeType) {
            return requestBankGetNullifySmsCode(smsCodeRequest);
        }
        LogX.e("illegal request type.");
        return null;
    }

    private void handleResult(int i, String str) {
        this.mResultTask.notifyRequestResult(i, str);
    }

    private String[] getVerifySign(int i) {
        SignDataResponse querySignDataForActivation;
        CardServerBaseRequest cardServerBaseRequest = new CardServerBaseRequest();
        cardServerBaseRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardServerBaseRequest.setRsaKeyIndex(-1);
        cardServerBaseRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        if (1 == i) {
            querySignDataForActivation = ServerServiceFactory.createCardServerApi(this.mContext).querySignDataForActivation(cardServerBaseRequest);
        } else if (2 == i) {
            querySignDataForActivation = ServerServiceFactory.createCardServerApi(this.mContext).querySignDataForNullify(cardServerBaseRequest);
        } else {
            LogX.e("getVerifySign, request type illegal.");
            querySignDataForActivation = null;
        }
        if (querySignDataForActivation == null || querySignDataForActivation.returnCode != 0) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "build request failed, tag : " + i);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_BUILD_REQUEST_ERR, hashMap, null, false, false);
            return null;
        }
        return new String[]{querySignDataForActivation.sign, querySignDataForActivation.time};
    }

    private void cleanLocalData(String str, TACardInfo tACardInfo, String str2, String str3) {
        boolean updateTACardNullified = updateTACardNullified(str);
        int excute = new DeleteAppletTsmOperator(this.mContext, tACardInfo.aid, null, null, getBankSignRsaIndex()).excute();
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
                handleResult(-4, null);
                return;
            }
            LogX.d("delete card in local, but update ta status failed.");
            handleResult(-99, null);
        } else if (-1 == excute || -2 == excute) {
            handleResult(-2, null);
        } else {
            handleResult(-99, null);
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
}
