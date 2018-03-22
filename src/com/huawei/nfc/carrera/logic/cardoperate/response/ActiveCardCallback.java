package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface ActiveCardCallback {
    public static final int ACTIVE_RESULT_FAILED_AUTH_CODE_EFFICACY = -3;
    public static final int ACTIVE_RESULT_FAILED_AUTH_CODE_UNMATCH = -4;
    public static final int ACTIVE_RESULT_FAILED_CARD_NULLIFIED = -9;
    public static final int ACTIVE_RESULT_FAILED_CONNECT_ERROR = -2;
    public static final int ACTIVE_RESULT_FAILED_CONN_UNAVAILABLE = -6;
    public static final int ACTIVE_RESULT_FAILED_CONTACT_BANK_CALLING_CENTER = -8;
    public static final int ACTIVE_RESULT_FAILED_NOT_SUPPORT = -5;
    public static final int ACTIVE_RESULT_FAILED_NO_NETWORK = -1;
    public static final int ACTIVE_RESULT_FAILED_OTHER_ERRORS = -99;
    public static final int ACTIVE_RESULT_FAILED_PERSONLIZING_CARD_ERR = -7;
    public static final int ACTIVE_RESULT_SUCCESS = 0;

    void activeResultCallback(int i);
}
