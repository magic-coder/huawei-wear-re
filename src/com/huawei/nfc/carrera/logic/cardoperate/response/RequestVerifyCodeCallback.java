package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface RequestVerifyCodeCallback {
    public static final int REQUEST_RESULT_FAILED_CARD_NULLIFIED = -4;
    public static final int REQUEST_RESULT_FAILED_CONNECTION_UNAVAILABLE = -3;
    public static final int REQUEST_RESULT_FAILED_CONN_UNAVAILABLE = -6;
    public static final int REQUEST_RESULT_FAILED_CONTACT_BANK = -9;
    public static final int REQUEST_RESULT_FAILED_CONTACT_BANK_CALLING_CENTER = -8;
    public static final int REQUEST_RESULT_FAILED_EXCEED_TIMES = -1;
    public static final int REQUEST_RESULT_FAILED_NO_NETWORK = -2;
    public static final int REQUEST_RESULT_FAILED_OTHER_ERRORS = -99;
    public static final int REQUEST_RESULT_FAILED_PERSONLIZING_CARD_ERR = -7;
    public static final int REQUEST_RESULT_REPEAT_ACTIVATION = -5;
    public static final int REQUEST_RESULT_SUCCESS = 0;

    void requestResultCallback(int i, String str);
}
