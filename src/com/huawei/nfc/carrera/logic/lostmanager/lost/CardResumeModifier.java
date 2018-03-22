package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class CardResumeModifier extends CardStatusBaseModifier {
    public CardResumeModifier(String str, Context context) {
        super(str, context);
    }

    protected boolean modifyCardStatusInESE(String str, Context context) {
        return true;
    }

    protected boolean modifyLocalCardInfo(String str, Context context, int i) {
        boolean z = true;
        if (92 == i || 99 == i) {
            if (92 == i) {
                try {
                    WalletTaManager.getInstance(context).updateCardStatus(str, 1);
                } catch (WalletTaCardNotExistException e) {
                    LogX.d("modifyLocalCardInfo, unlock card in ta failed, WalletTaCardNotExistException");
                    z = false;
                } catch (WalletTaSystemErrorException e2) {
                    LogX.d("modifyLocalCardInfo, unlock card in ta failed, WalletTaSystemErrorException");
                    z = false;
                }
            }
            if (99 == i) {
                WalletTaManager.getInstance(context).updateCardStatus(str, 2);
            }
            if (z) {
                CardInfoManager.getInstance(context).refreshCardList();
            }
        } else {
            LogX.i("modifyLocalCardInfo, the card is not locked.");
        }
        return z;
    }

    protected void reportCardStatus(String str, String str2, Context context) {
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(context).getCardInfoByAid(str);
        CardInfoDBManager cardInfoDBManager = new CardInfoDBManager(context);
        if (cardInfoByAid != null) {
            IssuerInfoItem queryIssuerInfoById = cardInfoDBManager.queryIssuerInfoById(cardInfoByAid.issuerId);
            if (queryIssuerInfoById != null) {
                String name = queryIssuerInfoById.getName();
                CardLostManager.getInstance(context).reportCardOpenedAvailableStatus(str, str2, name, cardInfoByAid.getFpanFour(), cardInfoByAid.getIssuerId(), cardInfoByAid.getCardGroupType());
            }
        }
    }

    protected boolean isNeedModifyESEStatus() {
        return false;
    }
}
