package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryOfflineTrafficCardInfoResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class QueryTrafficCardBalanceTask extends TrafficCardBaseTask {
    private int data;
    private QueryOfflineTrafficCardInfoResultHandler mResultHandler;

    public QueryTrafficCardBalanceTask(Context context, SPIOperatorManager sPIOperatorManager, String str, int i, QueryOfflineTrafficCardInfoResultHandler queryOfflineTrafficCardInfoResultHandler) {
        super(context, sPIOperatorManager, str);
        this.mResultHandler = queryOfflineTrafficCardInfoResultHandler;
        this.data = i;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        trafficCardOperator.queryOfflineCardInfo(issuerInfoItem, this.data, this.mResultHandler);
    }
}
