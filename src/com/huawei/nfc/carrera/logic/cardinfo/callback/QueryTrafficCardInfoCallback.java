package com.huawei.nfc.carrera.logic.cardinfo.callback;

import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;

public interface QueryTrafficCardInfoCallback extends BaseCallback {
    void queryTrafficCardInfoCallback(int i, TrafficCardInfo trafficCardInfo);
}
