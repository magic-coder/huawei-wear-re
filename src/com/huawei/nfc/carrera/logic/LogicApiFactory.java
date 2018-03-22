package com.huawei.nfc.carrera.logic;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.CardOperateLogic;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManagerApi;

public final class LogicApiFactory {
    private LogicApiFactory() {
    }

    public static CardInfoManagerApi createCardManager(Context context) {
        return CardInfoManager.getInstance(context);
    }

    public static CardOperateLogicApi createCardOperateApi(Context context) {
        return CardOperateLogic.getInstance(context);
    }

    public static CardLostManagerApi createCardLostManagerApi(Context context) {
        return CardLostManager.getInstance(context);
    }
}
