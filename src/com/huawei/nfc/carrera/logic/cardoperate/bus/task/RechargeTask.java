package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RechargeResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class RechargeTask extends TrafficCardBaseTask {
    private TrafficOrder mOrder;
    private RechargeResultHandler mResultHandler;

    public RechargeTask(Context context, SPIOperatorManager sPIOperatorManager, String str, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler) {
        super(context, sPIOperatorManager, str);
        this.mOrder = trafficOrder;
        this.mResultHandler = rechargeResultHandler;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.recharge(issuerInfoItem, this.mOrder, this.mResultHandler);
    }
}
