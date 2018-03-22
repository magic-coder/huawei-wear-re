package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RefundResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class RefundTask extends TrafficCardBaseTask {
    private TrafficOrder mOrder;
    private RefundResultHandler mResultHandler;

    public RefundTask(Context context, SPIOperatorManager sPIOperatorManager, String str, TrafficOrder trafficOrder, RefundResultHandler refundResultHandler) {
        super(context, sPIOperatorManager, str);
        this.mOrder = trafficOrder;
        this.mResultHandler = refundResultHandler;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.refund(issuerInfoItem, this.mOrder, this.mResultHandler);
    }
}
