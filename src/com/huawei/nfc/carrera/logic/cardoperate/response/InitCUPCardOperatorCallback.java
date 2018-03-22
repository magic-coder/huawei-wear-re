package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface InitCUPCardOperatorCallback {
    public static final int FAILED_CANNOT_BIND_CUP_SERVICE = -5;
    public static final int FAILED_CUP_TSM_SERVICE_UNREACHABLE = -3;
    public static final int FAILED_UNKNOWN_ERRORS = -99;
    public static final int SUCCESS = 0;

    void initCUPCardOperatorResult(int i);
}
