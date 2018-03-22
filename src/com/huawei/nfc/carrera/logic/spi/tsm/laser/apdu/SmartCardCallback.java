package com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu;

public interface SmartCardCallback {
    void onOperFailure(int i, String str);

    void onOperSuccess(int i, String str);
}
