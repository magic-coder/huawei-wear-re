package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryRecordsListResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class QueryRecordsListTask extends TrafficCardBaseTask {
    private int mPriorType;
    private QueryRecordsListResultHandler mResultHandler;

    public QueryRecordsListTask(Context context, SPIOperatorManager sPIOperatorManager, String str, int i, QueryRecordsListResultHandler queryRecordsListResultHandler) {
        super(context, sPIOperatorManager, str);
        this.mPriorType = i;
        this.mResultHandler = queryRecordsListResultHandler;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.queryRecords(issuerInfoItem, this.mPriorType, this.mResultHandler);
    }
}
