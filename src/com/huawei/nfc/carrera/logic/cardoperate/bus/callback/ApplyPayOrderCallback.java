package com.huawei.nfc.carrera.logic.cardoperate.bus.callback;

import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;

public interface ApplyPayOrderCallback extends TrafficCardBaseCallback {
    public static final int RETURN_FAILED_APPLY_ORDER_INNER_ERROR = 1099;
    public static final int RETURN_FAILED_BALANCE_IS_MINUS = 1003;
    public static final int RETURN_FAILED_BALANCE_REACH_LIMIT = 1001;
    public static final int RETURN_FAILED_CARD_AFTER_EXPIRE_DATE_ERROR = 1005;
    public static final int RETURN_FAILED_CARD_BEFORE_ENABLE_DATE_ERROR = 1004;
    public static final int RETURN_FAILED_CARD_DATE_ERROR = 1006;
    public static final int RETURN_FAILED_CARD_RECHARGE_AMOUNT_ILLEGAL_ERROR = 1007;
    public static final int RETURN_FAILED_CITYCODE_ILLEGAL = 1008;
    public static final int RETURN_FAILED_NO_ENOUGH_CARD_RESOURCE = 1009;
    public static final int RETURN_FAILED_OVER_DAILY_RECHARGE_COUNT_LIMIT = 1029;
    public static final int RETURN_FAILED_OVER_DAILY_RECHARGE_LIMIT = 1028;
    public static final int RETURN_FAILED_SP_SERVICE_STOPPED = 1010;
    public static final int RETURN_FAILED_UNFINISHED_ORDERS_EXIST = 1002;

    void applyPayOrderCallback(int i, TrafficOrder trafficOrder);
}
