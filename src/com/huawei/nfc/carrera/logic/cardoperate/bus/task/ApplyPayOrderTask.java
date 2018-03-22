package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class ApplyPayOrderTask extends TrafficCardBaseTask {
    private double amount;
    private String mProductCode;
    private ApplyPayOrderResultHandler mResultHandler;
    private int orderType;
    private int payType;

    public ApplyPayOrderTask(Context context, SPIOperatorManager sPIOperatorManager, String str, double d, int i, int i2, String str2, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        super(context, sPIOperatorManager, str);
        this.amount = d;
        this.orderType = i;
        this.payType = i2;
        this.mResultHandler = applyPayOrderResultHandler;
        this.mProductCode = str2;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.applyPayOrder(issuerInfoItem, this.amount, this.orderType, this.payType, this.mProductCode, this.mResultHandler);
    }
}
