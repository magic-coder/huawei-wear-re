package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface CUPOperationListener {
    public static final int OPERATE_RESULT_DEAL = -98;
    public static final int OPERATE_RESULT_FAILED = -99;
    public static final int OPERATE_RESULT_FAILED_DATA_OUT_OF_USE = -1;
    public static final int OPERATE_RESULT_SUCCESS = 0;

    void operateFinished(int i);

    void operateStart();
}
