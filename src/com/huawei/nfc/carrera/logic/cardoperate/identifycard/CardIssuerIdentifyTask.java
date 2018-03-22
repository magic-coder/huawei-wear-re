package com.huawei.nfc.carrera.logic.cardoperate.identifycard;

import android.content.Context;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushServiceManager;
import com.huawei.nfc.carrera.logic.cardoperate.cup.identifycard.IdentifyCardResult;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;
import java.util.Iterator;

public class CardIssuerIdentifyTask implements Runnable {
    private final String mCardNum;
    private final Context mContext;
    private final SPIOperatorManager mOperatorManager;
    private final HandleIdentifyIssuerResultTask mResultHandleTask;

    public CardIssuerIdentifyTask(Context context, String str, SPIOperatorManager sPIOperatorManager, HandleIdentifyIssuerResultTask handleIdentifyIssuerResultTask) {
        this.mContext = context;
        this.mCardNum = str;
        this.mOperatorManager = sPIOperatorManager;
        this.mResultHandleTask = handleIdentifyIssuerResultTask;
    }

    public void run() {
        int i;
        NFCPushServiceManager.getInstance(this.mContext).getPushToken();
        IdentifyCardResult indentifyCUPCard = this.mOperatorManager.getCUPOperator().indentifyCUPCard(this.mCardNum);
        LogX.i("===123===identifyResult.false resultCode= " + indentifyCUPCard.getResultCode());
        switch (indentifyCUPCard.getResultCode()) {
            case -5:
                i = -6;
                break;
            case -4:
                i = -2;
                break;
            case -3:
                i = -5;
                break;
            case -2:
                i = -4;
                break;
            case -1:
                i = -3;
                break;
            case 0:
                i = 1;
                break;
            default:
                i = -99;
                break;
        }
        if (1 == i) {
            i = getIfCardAdded(this.mCardNum, indentifyCUPCard);
        }
        this.mResultHandleTask.notifyIdentifyResult(i, indentifyCUPCard.getIssuerId(), indentifyCUPCard.getBankCardType(), 13);
    }

    private int getIfCardAdded(String str, IdentifyCardResult identifyCardResult) {
        ArrayList cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (cardList != null) {
            Iterator it = cardList.iterator();
            while (it.hasNext()) {
                TACardInfo tACardInfo = (TACardInfo) it.next();
                String substring = str.substring(str.length() - 4, str.length());
                if (tACardInfo.issuerId.equals(identifyCardResult.getIssuerId()) && identifyCardResult.getBankCardType() == tACardInfo.cardType && tACardInfo.fpanFour.equals(substring)) {
                    switch (tACardInfo.cardStatus) {
                        case 1:
                        case 2:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 97:
                        case 98:
                        case 99:
                            return -9;
                        default:
                            LogX.i("card status is valid, can be added");
                            break;
                    }
                }
            }
        }
        return 1;
    }
}
