package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface HandleCUPPersonalizedResultCallback {
    public static final int HANDLE_RESULT_CODE_FAILED = -1;
    public static final int HANDLE_RESULT_CODE_SUCCESS = 0;

    void handleResultCallback(int i);
}
