package com.huawei.nfc.carrera.logic.cardoperate.bus.callback;

import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseCallback;

public interface QueryTrafficCardBalanceCallback extends TrafficCardBaseCallback {
    void queryTrafficCardBalance(int i, double d);
}
