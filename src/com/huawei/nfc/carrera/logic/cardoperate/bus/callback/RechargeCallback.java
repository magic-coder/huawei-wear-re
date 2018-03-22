package com.huawei.nfc.carrera.logic.cardoperate.bus.callback;

import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseCallback;

public interface RechargeCallback extends TrafficCardBaseCallback {
    public static final int RETURN_RECHARGE_FAILED = 1301;
    public static final int RETURN_RECHARGE_FAILED_REFUNDABLE = 1304;
    public static final int RETURN_RECHARGE_FAILED_REFUNDABLE_RETRYABLE = 1303;
    public static final int RETURN_RECHARGE_FAILED_RETRYABLE = 1302;
    public static final int RETURN_RECHARGE_INNER_FAILED = 1399;
    public static final int RETURN_RECHARGE_REACH_LIMIT_REFUNDABLE = 1305;

    void rechargeCallback(int i);
}
