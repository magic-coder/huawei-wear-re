package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class CUPCardModifier {
    private final String mAction;
    private final Context mContext;
    private final String mRefId;

    public CUPCardModifier(Context context, String str, String str2) {
        this.mContext = context;
        this.mRefId = str;
        this.mAction = str2;
    }

    public boolean modify() {
        boolean z = false;
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
        if (card == null) {
            LogX.d("modify, taCardInfo not exsited.");
            return false;
        }
        LogX.i("modify, and cur card status: " + card.cardStatus);
        LogX.i("modify, and cur card mAction: " + this.mAction);
        if ("2".equals(this.mAction) || "1".equals(this.mAction)) {
            if (2 == card.cardStatus) {
                z = updateTaCardInfo(99);
            } else if (1 == card.cardStatus) {
                z = updateTaCardInfo(92);
            }
            LogX.i("modify, isModifySuccess = " + z);
            if (!z) {
                return z;
            }
            CardInfoManager.getInstance(this.mContext).refreshCardList();
            CardLostManager.getInstance(this.mContext).reportCardLockedStatus(card.aid, null);
            return z;
        } else if ("5".equals(this.mAction)) {
            LogX.i("modify, isModifySuccess 清理nullified卡片");
            return new HandleCUPCardNullifiedTask(this.mContext, this.mRefId).modifyCUPCard();
        } else if (!"00".equals(this.mAction)) {
            return false;
        } else {
            boolean updateTaCardInfo = 99 == card.cardStatus ? updateTaCardInfo(2) : 92 == card.cardStatus ? updateTaCardInfo(1) : false;
            LogX.i("modify, isModifySuccess = " + updateTaCardInfo);
            if (updateTaCardInfo) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
                CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(card.aid, null, getCurCardName(card.issuerId), card.fpanFour, card.issuerId, card.cardGroupType);
            }
            return updateTaCardInfo;
        }
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }

    private boolean updateTaCardInfo(int i) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(this.mRefId, i);
            return true;
        } catch (WalletTaCardNotExistException e) {
            LogX.e("updateTaCardInfo, but ta info not existed.");
            return false;
        } catch (WalletTaSystemErrorException e2) {
            LogX.e("updateTaCardInfo, ta system error.");
            return false;
        }
    }
}
