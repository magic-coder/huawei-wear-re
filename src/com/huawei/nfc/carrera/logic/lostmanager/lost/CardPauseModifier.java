package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class CardPauseModifier extends CardStatusBaseModifier {
    public CardPauseModifier(String str, Context context) {
        super(str, context);
    }

    protected boolean modifyCardStatusInESE(String str, Context context) {
        return true;
    }

    protected boolean modifyLocalCardInfo(String str, Context context, int i) {
        boolean z = true;
        if (1 == i || 2 == i) {
            LogX.i("modifyLocalCardInfo, the card cur status is " + i);
            if (1 == i) {
                try {
                    WalletTaManager.getInstance(context).updateCardStatus(str, 92);
                } catch (WalletTaCardNotExistException e) {
                    LogX.d("modifyLocalCardInfo, lock card in ta failed, WalletTaCardNotExistException");
                    z = false;
                } catch (WalletTaSystemErrorException e2) {
                    LogX.d("modifyLocalCardInfo, lock card in ta failed, WalletTaSystemErrorException");
                    z = false;
                }
            }
            if (2 == i) {
                WalletTaManager.getInstance(context).updateCardStatus(str, 99);
            }
            if (z) {
                CardInfoManager.getInstance(context).refreshCardList();
            }
        } else {
            LogX.i("modifyLocalCardInfo, the card is not installed.");
        }
        return z;
    }

    protected void reportCardStatus(String str, String str2, Context context) {
        CardLostManager.getInstance(context).reportCardLockedStatus(str, str2);
    }

    protected boolean isNeedModifyESEStatus() {
        return false;
    }
}
