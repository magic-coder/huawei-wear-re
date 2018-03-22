package com.huawei.nfc.carrera.logic.cardoperate.bus.callback;

import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;

public interface QueryAndHandleUnfinishedOrderCallback extends TrafficCardBaseCallback {
    public static final int RESULT_FAILED_UNFINISHED_ORDERS_AMOUNT_LIMITED = 1201;
    public static final int RESULT_TYPE_EXISTS_UNFINISHED_ORDERS = 10001;
    public static final int RESULT_TYPE_HANDLED_UNFINISHED_ORDERS = 10002;
    public static final int RESULT_TYPE_NO_UNFINISHED_ORDERS = 10000;

    void queryAndHandleUnfinishedOrderCallback(int i, int i2, OrderHandleResultInfo orderHandleResultInfo);
}
