package com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu;

public interface MyTSMOperatorResponse {
    void onOperFailure(int i, String str);

    void onOperSuccess(String str);
}
