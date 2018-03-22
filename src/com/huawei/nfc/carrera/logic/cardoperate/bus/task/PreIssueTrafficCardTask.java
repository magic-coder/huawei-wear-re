package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class PreIssueTrafficCardTask extends TrafficCardBaseTask {
    public PreIssueTrafficCardTask(Context context, String str, SPIOperatorManager sPIOperatorManager) {
        super(context, sPIOperatorManager, str);
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.preIssueTrafficCard(issuerInfoItem);
    }
}
