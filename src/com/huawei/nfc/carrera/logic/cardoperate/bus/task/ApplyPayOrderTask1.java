package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class ApplyPayOrderTask1 extends TrafficCardBaseTask {
    private ApplyOrderInfo applyOrderInfo;
    private ApplyPayOrderResultHandler mResultHandler;

    public ApplyPayOrderTask1(Context context, SPIOperatorManager sPIOperatorManager, String str, ApplyOrderInfo applyOrderInfo, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        super(context, sPIOperatorManager, str);
        this.applyOrderInfo = applyOrderInfo;
        this.mResultHandler = applyPayOrderResultHandler;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.applyPayOrder(issuerInfoItem, this.applyOrderInfo, this.mResultHandler);
    }
}
