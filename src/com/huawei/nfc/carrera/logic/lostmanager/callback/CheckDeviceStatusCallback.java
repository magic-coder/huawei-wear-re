package com.huawei.nfc.carrera.logic.lostmanager.callback;

public interface CheckDeviceStatusCallback {
    public static final int RETURN_FAILED = -1;
    public static final int RETURN_SUCCESS = 0;

    void checkDeviceStatusCallback(String str);
}
