package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import java.util.ArrayList;
import java.util.Iterator;

public class ClearAllNullifiedCardTask implements Runnable {
    private final Context mContext;

    public ClearAllNullifiedCardTask(Context context) {
        this.mContext = context;
    }

    public void run() {
        ArrayList cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (cardList != null && cardList.size() > 0) {
            Iterator it = cardList.iterator();
            while (it.hasNext()) {
                TACardInfo tACardInfo = (TACardInfo) it.next();
                if (tACardInfo.getCardStatus() == 3) {
                    CardLostManager.getInstance(this.mContext).clearNullifiedCardLocalInfo(tACardInfo.getAid());
                }
            }
        }
    }
}
