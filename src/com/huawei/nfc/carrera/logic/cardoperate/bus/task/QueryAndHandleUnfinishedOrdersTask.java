package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryAndHandleUnfinishedOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class QueryAndHandleUnfinishedOrdersTask extends TrafficCardBaseTask {
    private int mBussnessType;
    private QueryAndHandleUnfinishedOrderResultHandler mResultHandler;

    public QueryAndHandleUnfinishedOrdersTask(Context context, SPIOperatorManager sPIOperatorManager, String str, int i, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler) {
        super(context, sPIOperatorManager, str);
        this.mResultHandler = queryAndHandleUnfinishedOrderResultHandler;
        this.mBussnessType = i;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.queryAndHandleUnfinfishedOrders(issuerInfoItem, this.mBussnessType, this.mResultHandler);
    }
}
