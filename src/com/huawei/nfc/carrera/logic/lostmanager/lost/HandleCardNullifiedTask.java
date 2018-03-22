package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class HandleCardNullifiedTask implements Runnable {
    private final String mAid;
    private final Context mContext;

    public HandleCardNullifiedTask(Context context, String str) {
        this.mContext = context;
        this.mAid = str;
    }

    public void run() {
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(this.mAid);
        if (cardInfoByAid == null) {
            LogX.w("HandleCardNullifiedTask, taCardInfo not existed.");
            return;
        }
        IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(cardInfoByAid.issuerId);
        if (cacheIssuerInfoItem == null) {
            LogX.w("HandleCardNullifiedTask, issuer info not existed.");
        } else if (isCUPCard(cacheIssuerInfoItem.getMode(), cardInfoByAid.getAid())) {
            LogX.i("handle cup card nullified.");
            new HandleCUPCardNullifiedTask(this.mContext, cardInfoByAid.getDpanDigest()).modifyCUPCard();
        } else {
            LogX.i("handle common bank card nullified.");
            new CardNullifiedModifier(this.mAid, this.mContext).modifyLocalCardStatus(false);
        }
    }

    private boolean isCUPCard(int i, String str) {
        if (13 == i || (11 == i && !Constant.CITIC_CARD_AID.equals(str))) {
            return true;
        }
        return false;
    }
}
