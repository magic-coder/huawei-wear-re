package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface CardTypeIdentifyCallback {
    public static final int IDENTIFY_RESULT_FAILED_CANNOT_BIND_CUP_SERVICE = -6;
    public static final int IDENTIFY_RESULT_FAILED_CARD_APPLIED = -9;
    public static final int IDENTIFY_RESULT_FAILED_CONN_EXCEPTION = -5;
    public static final int IDENTIFY_RESULT_FAILED_CONN_TSM_SERVICE_EXCEPTION = -7;
    public static final int IDENTIFY_RESULT_FAILED_ERROR_CARD_NUM = -1;
    public static final int IDENTIFY_RESULT_FAILED_NOT_INSTALLED = -3;
    public static final int IDENTIFY_RESULT_FAILED_NO_NETWORK = -4;
    public static final int IDENTIFY_RESULT_FAILED_OTHER_ERRORS = -99;
    public static final int IDENTIFY_RESULT_FAILED_QUERYCPLC_ERRO = -8;
    public static final int IDENTIFY_RESULT_FAILED_SAME_BANK_TYPE_CARD_ADDED = -10;
    public static final int IDENTIFY_RESULT_FAILED_UNSUPPORTED = -2;
    public static final int IDENTIFY_RESULT_SUCCESS = 1;
    public static final int IDENTIFY_RESULT_SUCCESS_NEED_UPGRADE = 0;

    void identifyResult(int i, String str, int i2, int i3);
}
