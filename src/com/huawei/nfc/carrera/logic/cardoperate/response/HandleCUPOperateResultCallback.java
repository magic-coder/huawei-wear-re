package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface HandleCUPOperateResultCallback {
    public static final int OPERATE_RESULT_FAILED = -99;
    public static final int OPERATE_RESULT_SUCCESS = 0;

    void operateResultCallback(int i);
}
