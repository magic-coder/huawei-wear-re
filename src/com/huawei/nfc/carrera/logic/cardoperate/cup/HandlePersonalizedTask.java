package com.huawei.nfc.carrera.logic.cardoperate.cup;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.CardOperateListener;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;

public class HandlePersonalizedTask implements Runnable {
    private static final String TAG = "HandlePersonalizedTask";
    private final String mAid;
    private final Context mContext;
    private final CardOperateListener mListener;
    private final String mRefId;
    private final HandlePersonalizedResultTask mResultTask;
    private final String taskCplc;

    class SetCardDefaultCallbackImpl implements SetCardDefaultCallback {
        SetCardDefaultCallbackImpl() {
        }

        public void setResultCallback(int i) {
            LogX.i("HandlePersonalizedTask,set default card success");
        }
    }

    public HandlePersonalizedTask(Context context, String str, String str2, String str3, HandlePersonalizedResultTask handlePersonalizedResultTask, CardOperateListener cardOperateListener) {
        this.mContext = context;
        this.taskCplc = str;
        this.mRefId = str2;
        this.mAid = str3;
        this.mResultTask = handlePersonalizedResultTask;
        this.mListener = cardOperateListener;
    }

    public void run() {
        LogX.d("===123=== HandlePersonalizedTask run");
        if (this.taskCplc.equals(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc())) {
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
            if (card == null) {
                LogX.e("personalized, but card not exsited in ta.");
                this.mResultTask.notifyHandleResult(-1);
                return;
            }
            int i = card.cardStatus;
            switch (i) {
                case 93:
                case 95:
                case 96:
                    card.cardStatus = 2;
                    break;
                case 94:
                case 97:
                case 98:
                    card.cardStatus = 1;
                    break;
                default:
                    this.mResultTask.notifyHandleResult(0);
                    return;
            }
            boolean updateTaCardInfoForCUP = WalletTaManager.getInstance(this.mContext).updateTaCardInfoForCUP(this.mRefId, this.mAid, card.cardStatus);
            LogX.d("===TA==HandlePersonalizedTask isUpdateCardSuccess=" + updateTaCardInfoForCUP);
            C2538c.b(TAG, new Object[]{" CardEvent PERSONALIZED bank cardEvent END_LOCK"});
            WalletTaManager.getInstance(this.mContext).cardEvent(this.mRefId, 3);
            if (updateTaCardInfoForCUP) {
                if (this.mListener != null) {
                    this.mListener.operateFinished(CUPCardOperator.OPERATE_EVENT_DOWNLOAD, this.mRefId, 0);
                }
                if (i != card.cardStatus) {
                    LogX.d("card status changed, refresh card list now.");
                    CardInfoManager.getInstance(this.mContext).refreshCardList();
                }
                if (1 == card.cardStatus) {
                    CardLostManager.getInstance(this.mContext).reportCardOpenedNotActiveStatus(this.mAid, null, getCurCardName(card.issuerId), card.fpanFour);
                } else if (2 == card.cardStatus) {
                    CardInfoManager.getInstance(this.mContext).setCardDefault(card.dpanDigest, new SetCardDefaultCallbackImpl());
                    CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(this.mAid, null, getCurCardName(card.issuerId), card.fpanFour, card.issuerId, card.cardGroupType);
                    reportBI(card.productId, card.issuerId, card.cardType);
                }
                NFCPreferences.getInstance(this.mContext).remove(this.mRefId);
                this.mResultTask.notifyHandleResult(0);
                return;
            }
            this.mResultTask.notifyHandleResult(-1);
            return;
        }
        LogX.e("personalized, but cplc not match.");
        this.mResultTask.notifyHandleResult(-1);
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }

    private void reportBI(String str, String str2, int i) {
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(str);
        if (cacheCardProductInfoItem == null) {
            NfcHianalyticsUtil.onReportForCardOpened(this.mContext, this.mAid, "", str2, i);
        } else {
            NfcHianalyticsUtil.onReportForCardOpened(this.mContext, this.mAid, cacheCardProductInfoItem.getProductName(), str2, i);
        }
    }
}
