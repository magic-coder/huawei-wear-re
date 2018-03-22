package com.huawei.nfc.carrera.logic.cardoperate.cup.nullify;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.citic.HandleNullifyCardResultTask;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.request.NullifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.NullifyCardResponse;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public class NullifyCupCardTask implements Runnable {
    private final Context mContext;
    private final String mRefID;
    private final HandleNullifyCardResultTask mResultTask;
    private final CardServerApi mServerApi;

    public NullifyCupCardTask(Context context, CardServerApi cardServerApi, String str, HandleNullifyCardResultTask handleNullifyCardResultTask) {
        this.mContext = context;
        this.mServerApi = cardServerApi;
        this.mRefID = str;
        this.mResultTask = handleNullifyCardResultTask;
    }

    public void run() {
        LogX.d("nullify card, refId: " + this.mRefID);
        NullifyCardResponse nullifyCUPCard = nullifyCUPCard();
        LogX.i("nullify cup card result: " + nullifyCUPCard.returnCode);
        int checkNullifyCardResponse = checkNullifyCardResponse(nullifyCUPCard);
        cleanDownlaodInfo();
        handleResult(checkNullifyCardResponse);
    }

    private void cleanDownlaodInfo() {
        if (NFCPreferences.getInstance(this.mContext).getString(this.mRefID, null) != null) {
            NFCPreferences.getInstance(this.mContext).remove(this.mRefID);
        }
    }

    private boolean updateTaCardInfo() {
        boolean z = false;
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefID);
        if (card == null) {
            return false;
        }
        if (3 == card.cardStatus) {
            return true;
        }
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(this.mRefID, 3);
            z = true;
        } catch (WalletTaCardNotExistException e) {
            LogX.d("TaCardInfo allready deleted! Refid = " + this.mRefID, true);
        } catch (Throwable e2) {
            LogX.e("NullifyCupCardTask TaCardInfo err! Refid = " + this.mRefID, e2, true);
        }
        if (!z) {
            return z;
        }
        CardInfoManager.getInstance(this.mContext).refreshCardList();
        CardLostManager.getInstance(this.mContext).clearNullifiedCardLocalInfo(card.getAid());
        return z;
    }

    private NullifyCardResponse nullifyCUPCard() {
        String queryCplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        if (StringUtil.isEmpty(queryCplc, true)) {
            NullifyCardResponse nullifyCardResponse = new NullifyCardResponse();
            nullifyCardResponse.returnCode = -10;
            return nullifyCardResponse;
        }
        NullifyCUPCardRequest nullifyCUPCardRequest = new NullifyCUPCardRequest();
        nullifyCUPCardRequest.cplc = queryCplc;
        nullifyCUPCardRequest.setRsaKeyIndex(-1);
        nullifyCUPCardRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        nullifyCUPCardRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        nullifyCUPCardRequest.cardRefId = this.mRefID;
        return this.mServerApi.nullifyCUPCard(nullifyCUPCardRequest);
    }

    private int checkNullifyCardResponse(NullifyCardResponse nullifyCardResponse) {
        boolean z = false;
        if (nullifyCardResponse == null) {
            LogX.e("checkNullifyCardResponse, response is illegal.");
            return -99;
        }
        LogX.i("nullify cup card return code: " + nullifyCardResponse.returnCode);
        switch (nullifyCardResponse.returnCode) {
            case -10:
                z = true;
                break;
            case -4:
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "NullifyCupCardTask checkNullifyCardResponse server overload 503");
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_NULLIFY_CARD_ERR, hashMap, "nullify card err", true, false);
                z = true;
                break;
            case -2:
                z = true;
                break;
            case -1:
                z = true;
                break;
            case 0:
            case 1343:
            case 3343:
                boolean updateTaCardInfo = updateTaCardInfo();
                LogX.d("===123===isUpdateSuccess" + updateTaCardInfo);
                if (!updateTaCardInfo) {
                    z = true;
                    break;
                }
                break;
            case 1342:
                doTaDelete();
                break;
            default:
                reprotFailReason(nullifyCardResponse.returnCode);
                z = true;
                break;
        }
        return z;
    }

    private void reprotFailReason(int i) {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefID);
        if (card != null) {
            Map hashMap = new HashMap();
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
            hashMap.put("issuerID", card.issuerId);
            hashMap.put("productID", card.productId);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_NULLIFY_CARD_ERR, hashMap, "nullify card err", true, false);
        }
    }

    private void doTaDelete() {
        try {
            WalletTaManager.getInstance(this.mContext).removeCard(this.mRefID);
        } catch (WalletTaCardNotExistException e) {
            LogX.i("TaInfo has been allready deleted.");
        } catch (Throwable e2) {
            LogX.e("Delete TaInfo Err.", e2);
        }
    }

    private void handleResult(int i) {
        if (this.mResultTask != null) {
            this.mResultTask.notifyNullifyResult(i);
        }
    }
}
