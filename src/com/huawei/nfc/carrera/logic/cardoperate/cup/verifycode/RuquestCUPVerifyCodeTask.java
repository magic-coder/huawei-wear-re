package com.huawei.nfc.carrera.logic.cardoperate.cup.verifycode;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.HandleVerifyCodeResultTask;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.request.ApplyCUPVerificationRequest;
import com.huawei.nfc.carrera.server.card.response.ApplyVerificationResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public class RuquestCUPVerifyCodeTask implements Runnable {
    private final Context mContext;
    private final String mRefId;
    private final HandleVerifyCodeResultTask mResultTask;
    private final CardServerApi mServerApi;

    public RuquestCUPVerifyCodeTask(Context context, CardServerApi cardServerApi, String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask) {
        this.mContext = context;
        this.mServerApi = cardServerApi;
        this.mRefId = str;
        this.mResultTask = handleVerifyCodeResultTask;
    }

    public void run() {
        int i = 0;
        if (checkTaCardStatus()) {
            ApplyCUPVerificationRequest applyCUPVerificationRequest = new ApplyCUPVerificationRequest();
            applyCUPVerificationRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
            applyCUPVerificationRequest.setRsaKeyIndex(-1);
            applyCUPVerificationRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
            applyCUPVerificationRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
            applyCUPVerificationRequest.setCardRefId(this.mRefId);
            ApplyVerificationResponse applyCUPVerification = this.mServerApi.applyCUPVerification(applyCUPVerificationRequest);
            if (applyCUPVerification == null) {
                LogX.e("request cup verify code, response is illegal.");
                this.mResultTask.notifyRequestResult(-99, null);
                return;
            }
            LogX.e("request cup verify code, response response.returnCode : " + applyCUPVerification.returnCode);
            switch (applyCUPVerification.returnCode) {
                case -4:
                    Map hashMap = new HashMap();
                    hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "RuquestCUPVerifyCodeTask server overload 503");
                    LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_REQUEST_SMS_ERR, hashMap, "request sms err", true, false);
                    i = -3;
                    break;
                case -2:
                case ApplyVerificationResponse.RESULT_CODE_BANK_SERVICE_UNREACHABLE /*3105*/:
                    i = -3;
                    break;
                case -1:
                    i = -2;
                    break;
                case 0:
                    LogX.d("request cup verify code, expire time: " + applyCUPVerification.expiry + ",curTime: " + applyCUPVerification.currTime);
                    break;
                case 1342:
                case 1343:
                case 3343:
                    updateTAInfoToDelete();
                    i = -4;
                    break;
                case 1613:
                case 3613:
                    updateTAInfo();
                    i = -5;
                    break;
                case 3603:
                    i = -1;
                    break;
                default:
                    reportFailReason(applyCUPVerification);
                    i = -99;
                    break;
            }
            this.mResultTask.notifyRequestResult(i, null);
        }
    }

    private void reportFailReason(ApplyVerificationResponse applyVerificationResponse) {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.e("request cup verify code failed, ta is null");
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(applyVerificationResponse.returnCode));
        hashMap.put("issuerId", card.issuerId);
        hashMap.put("productId", card.productId);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_REQUEST_SMS_ERR, hashMap, "request sms err", true, false);
    }

    private boolean checkTaCardStatus() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            this.mResultTask.notifyRequestResult(-7, null);
            return false;
        }
        int i = card.cardStatus;
        if (2 == card.cardStatus || 95 == card.cardStatus || 96 == card.cardStatus) {
            this.mResultTask.notifyRequestResult(-5, null);
            return false;
        } else if (i == 97 || i == 98 || i == 1) {
            return true;
        } else {
            this.mResultTask.notifyRequestResult(-7, null);
            return false;
        }
    }

    private void updateTAInfoToDelete() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.d("updateTAInfo, but ta info is not existed.");
            return;
        }
        doTaStatusUpdate(card, 3);
        CardLostManager.getInstance(this.mContext).clearNullifiedCardLocalInfo(card.getAid());
    }

    private void updateTAInfo() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.d("updateTAInfo, but ta info is not existed.");
            return;
        }
        int i;
        LogX.d("exsited card status: " + card.cardStatus);
        if (98 == card.cardStatus) {
            i = 96;
        } else if (97 == card.cardStatus) {
            i = 95;
        } else if (1 == card.cardStatus) {
            i = 2;
        } else {
            return;
        }
        doTaStatusUpdate(card, i);
    }

    private void doTaStatusUpdate(TACardInfo tACardInfo, int i) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(this.mRefId, i);
            if (tACardInfo.cardStatus != i) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
            }
            if (2 == i) {
                CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(tACardInfo.aid, null, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour, tACardInfo.issuerId, tACardInfo.cardGroupType);
            }
        } catch (Throwable e) {
            LogX.e("updateCardStatus err : ", e);
        }
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }
}
