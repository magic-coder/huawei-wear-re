package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.UninstallTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class UninstallTrafficCardTask extends TrafficCardBaseTask {
    private UninstallTrafficCardResultHandler mResultHandler;

    public UninstallTrafficCardTask(Context context, SPIOperatorManager sPIOperatorManager, String str, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler) {
        super(context, sPIOperatorManager, str);
        this.mResultHandler = uninstallTrafficCardResultHandler;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.uninstallTrafficCard(issuerInfoItem, this.mResultHandler);
    }
}
