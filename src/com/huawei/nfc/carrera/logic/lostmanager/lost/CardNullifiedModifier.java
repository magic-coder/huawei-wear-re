package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess.UninstallTrafficCardSAOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.uninstall.DeleteTrafficCardSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteAppletTsmOperator;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteSSDTsmOperator;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.SynESETsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class CardNullifiedModifier extends CardStatusBaseModifier {
    public CardNullifiedModifier(String str, Context context) {
        super(str, context);
    }

    protected boolean modifyCardStatusInESE(String str, Context context) {
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(context).getCardInfoByAid(str);
        if (cardInfoByAid == null) {
            return true;
        }
        IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(context).cacheIssuerInfoItem(cardInfoByAid.getIssuerId());
        if (cacheIssuerInfoItem == null) {
            return false;
        }
        int mode = cacheIssuerInfoItem.getMode();
        if (mode == 0) {
            return false;
        }
        int excute;
        if (mode == 14) {
            mode = new SynESETsmOperator(context, str, cacheIssuerInfoItem.getIssuerId()).excute();
            LogX.i("synESETsmOperator result is :" + mode);
            if (mode != 0) {
                return false;
            }
            excute = new DeleteSSDTsmOperator(context, str, cacheIssuerInfoItem.getIssuerId(), true).excute();
            LogX.i("DeleteSSDTsmOperator result is :" + excute);
            if (excute != 0) {
                return false;
            }
            return true;
        } else if (mode == 22) {
            return new DeleteTrafficCardSNBOperator(context, str).uninstall();
        } else {
            if (mode == 20) {
                return new UninstallTrafficCardSAOperator(context, cacheIssuerInfoItem, null).uninstall();
            }
            excute = new DeleteAppletTsmOperator(context, str, cacheIssuerInfoItem.getIssuerId()).excute();
            LogX.d("modifyCardStatusInESE, excute tsm delete, result: " + excute);
            if (excute != 0) {
                return false;
            }
            return true;
        }
    }

    protected boolean modifyLocalCardInfo(String str, Context context, int i) {
        boolean z = true;
        try {
            WalletTaManager.getInstance(context).removeCard(str);
        } catch (WalletTaCardNotExistException e) {
            LogX.d("modifyLocalCardInfo, remove card in ta, WalletTaCardNotExistException");
        } catch (WalletTaSystemErrorException e2) {
            LogX.d("modifyLocalCardInfo, remove card in ta, WalletTaSystemErrorException");
            z = false;
        }
        if (z) {
            CardInfoManager.getInstance(context).refreshCardList();
        }
        return z;
    }

    protected void reportCardStatus(String str, String str2, Context context) {
        CardLostManager.getInstance(context).reportCardDeletedStatus(str, str2);
    }

    protected boolean isNeedModifyESEStatus() {
        return true;
    }
}
