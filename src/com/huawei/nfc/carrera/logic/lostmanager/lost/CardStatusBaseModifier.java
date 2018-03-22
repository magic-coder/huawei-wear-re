package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public abstract class CardStatusBaseModifier {
    private final String mAid;
    private final Context mContext;

    protected abstract boolean isNeedModifyESEStatus();

    protected abstract boolean modifyCardStatusInESE(String str, Context context);

    protected abstract boolean modifyLocalCardInfo(String str, Context context, int i);

    protected abstract void reportCardStatus(String str, String str2, Context context);

    public CardStatusBaseModifier(String str, Context context) {
        this.mContext = context;
        this.mAid = str;
    }

    boolean modifyLocalCardStatus(boolean z) {
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(this.mAid);
        if (cardInfoByAid == null) {
            LogX.e("modifyLocalCardStatus, no ta info.");
            return false;
        }
        LogX.e("modifyLocalCardStatus, (isNeedModifyESEStatus()");
        if (isNeedModifyESEStatus() && !modifyCardStatusInESE(this.mAid, this.mContext)) {
            LogX.d("modifyCardStatusInESE, modify card status in ese failed.");
            return false;
        } else if (modifyLocalCardInfo(cardInfoByAid.dpanDigest, this.mContext, cardInfoByAid.cardStatus)) {
            IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(cardInfoByAid.getIssuerId());
            int mode = cacheIssuerInfoItem == null ? -1 : cacheIssuerInfoItem.getMode();
            if (mode == -1) {
                LogX.e("reportCardStatus, mode unsupported.");
                return false;
            }
            if (z) {
                if (12 == mode) {
                    LogX.d("need notify, cmb card, refId: " + cardInfoByAid.dpanDigest);
                    CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(cardInfoByAid.aid, cardInfoByAid.dpanDigest, z);
                } else {
                    CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(cardInfoByAid.aid, null, z);
                }
            } else if (12 == mode) {
                LogX.d("cmb card, refId: " + cardInfoByAid.dpanDigest);
                reportCardStatus(cardInfoByAid.aid, cardInfoByAid.dpanDigest, this.mContext);
            } else {
                reportCardStatus(cardInfoByAid.aid, null, this.mContext);
            }
            return true;
        } else {
            LogX.d("modifyLocalCardStatus, update local card info failed.");
            return false;
        }
    }
}
