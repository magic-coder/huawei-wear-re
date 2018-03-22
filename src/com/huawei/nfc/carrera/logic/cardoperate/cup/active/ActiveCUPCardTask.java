package com.huawei.nfc.carrera.logic.cardoperate.cup.active;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.HandleActiveCardResultTask;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.request.VerifiyCUPRequest;
import com.huawei.nfc.carrera.server.card.response.ActiveCUPCardResponse;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public class ActiveCUPCardTask implements Runnable {
    private final Context mContext;
    private final String mRefId;
    private final HandleActiveCardResultTask mResultTask;
    private final CardServerApi mServerApi;
    private final String mVerifyCode;

    class SetCardDefaultCallbackImpl implements SetCardDefaultCallback {
        SetCardDefaultCallbackImpl() {
        }

        public void setResultCallback(int i) {
            LogX.i("ActiveCUPCardTask, set default card success");
        }
    }

    public ActiveCUPCardTask(Context context, CardServerApi cardServerApi, String str, String str2, HandleActiveCardResultTask handleActiveCardResultTask) {
        this.mContext = context;
        this.mServerApi = cardServerApi;
        this.mRefId = str;
        this.mVerifyCode = str2;
        this.mResultTask = handleActiveCardResultTask;
    }

    public void run() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.d("prepare before active, card download err.");
            this.mResultTask.notifyActiveResult(-7);
        } else if (2 == card.cardStatus || 95 == card.cardStatus || 96 == card.cardStatus || 93 == card.cardStatus) {
            LogX.d("prepare before active, card download err.");
            this.mResultTask.notifyActiveResult(0);
        } else {
            this.mResultTask.notifyActiveResult(doActivityCUPCard());
        }
    }

    private int doActivityCUPCard() {
        VerifiyCUPRequest verifiyCUPRequest = new VerifiyCUPRequest();
        verifiyCUPRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
        verifiyCUPRequest.setRsaKeyIndex(-1);
        verifiyCUPRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        verifiyCUPRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        verifiyCUPRequest.setCardRefId(this.mRefId);
        verifiyCUPRequest.setOptValue(this.mVerifyCode);
        CardServerBaseResponse verifyOnCUP = this.mServerApi.verifyOnCUP(verifiyCUPRequest);
        if (verifyOnCUP == null) {
            Map hashMap = new HashMap();
            String str = "response is null";
            hashMap.put(CloudEyeLogger.FAIL_CODE, str);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_ACTIVE_CARD_ERR, hashMap, str, false, false);
            return -99;
        }
        switch (verifyOnCUP.returnCode) {
            case -4:
                Map hashMap2 = new HashMap();
                String str2 = "ActiveCUPCardTask doActivityCUPCard server overload 503";
                hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_OVERLOAD_ERR, hashMap2, str2, true, false);
                return -6;
            case -2:
                return -6;
            case -1:
                return -1;
            case 0:
            case 1613:
            case 3613:
                if (updateCardStatus()) {
                    return 0;
                }
                return -99;
            case 1342:
            case 1343:
            case 3343:
                updataTaInfoToDelete();
                return -9;
            case ActiveCUPCardResponse.RESULT_CODE_VERIFY_CODE_UNMATCH /*3612*/:
                return -4;
            case ActiveCUPCardResponse.RESULT_CODE_VERIFY_EFFICACY /*3614*/:
                return -3;
            default:
                reprotFailReason(verifyOnCUP);
                return -99;
        }
    }

    private void reprotFailReason(CardServerBaseResponse cardServerBaseResponse) {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.e("active failed, but no ta info.");
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(cardServerBaseResponse.returnCode));
        hashMap.put("issuerId", card.issuerId);
        hashMap.put("productId", card.productId);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_ACTIVE_CARD_ERR, hashMap, "active card err", true, false);
    }

    private void updataTaInfoToDelete() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.e("active failed, but no ta info.");
        } else if (updateCardStatus(this.mRefId, 3)) {
            CardInfoManager.getInstance(this.mContext).refreshCardList();
            CardLostManager.getInstance(this.mContext).clearNullifiedCardLocalInfo(card.getAid());
        }
    }

    private boolean updateCardStatus() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.e("active success, but no ta info.");
            return false;
        }
        int i;
        switch (card.cardStatus) {
            case 1:
                i = 2;
                break;
            case 2:
                return true;
            case 94:
                i = 93;
                break;
            case 97:
                i = 95;
                break;
            case 98:
                i = 96;
                break;
            default:
                return false;
        }
        String curCardName = getCurCardName(card.issuerId);
        LogX.i("update card status available: cardName" + curCardName);
        LogX.i("update card status available: isUpdateNameSucess" + updateCardName(this.mRefId, curCardName));
        boolean updateCardStatus = updateCardStatus(this.mRefId, i);
        LogX.d("update card status available: " + updateCardStatus);
        if (updateCardStatus) {
            if (card.cardStatus != i) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
            }
            if (2 == i) {
                CardInfoManager.getInstance(this.mContext).setCardDefault(card.dpanDigest, new SetCardDefaultCallbackImpl());
                CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(card.aid, null, getCurCardName(card.issuerId), card.fpanFour, card.issuerId, card.cardGroupType);
                reportBiCardStatus(this.mRefId, card.productId, card.aid, card.issuerId, card.cardType);
            }
        }
        return updateCardStatus;
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }

    private boolean updateCardStatus(String str, int i) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(str, i);
            return true;
        } catch (Throwable e) {
            LogX.e("update card status after active card, WalletTaCardNotExistException: " + Log.getStackTraceString(e));
            return false;
        } catch (Throwable e2) {
            LogX.e("update card status after active card, WalletTaSystemErrorException: " + Log.getStackTraceString(e2));
            return false;
        }
    }

    private boolean updateCardName(String str, String str2) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardName(str, str2);
            return true;
        } catch (Throwable e) {
            LogX.e("update card status after active card, WalletTaCardNotExistException: " + Log.getStackTraceString(e));
            return false;
        } catch (Throwable e2) {
            LogX.e("update card status after active card, WalletTaSystemErrorException: " + Log.getStackTraceString(e2));
            return false;
        }
    }

    private void reportBiCardStatus(String str, String str2, String str3, String str4, int i) {
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(str2);
        if (cacheCardProductInfoItem == null) {
            NfcHianalyticsUtil.onReportForCardOpened(this.mContext, str3, "", str4, i);
        } else {
            NfcHianalyticsUtil.onReportForCardOpened(this.mContext, str3, cacheCardProductInfoItem.getProductName(), str4, i);
        }
    }
}
