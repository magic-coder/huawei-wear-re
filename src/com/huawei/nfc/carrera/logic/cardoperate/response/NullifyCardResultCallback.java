package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface NullifyCardResultCallback {
    public static final int NULLIFY_CARD_RESULT_FAILED_CODE_EFFICACY = -6;
    public static final int NULLIFY_CARD_RESULT_FAILED_CODE_UNMATCH = -5;
    public static final int NULLIFY_CARD_RESULT_FAILED_CONNECT_ERROR = -4;
    public static final int NULLIFY_CARD_RESULT_FAILED_CONTACT_BANK_CALLING_CENTER = -7;
    public static final int NULLIFY_CARD_RESULT_FAILED_NETWORK_UNAVAILABLE = -3;
    public static final int NULLIFY_CARD_RESULT_FAILED_NOT_SUPPORTED = -2;
    public static final int NULLIFY_CARD_RESULT_FAILED_OTHER_ERROR = -99;
    public static final int NULLIFY_CARD_RESULT_FAILED_PARAMS_ILLEGAL = -1;
    public static final int NULLIFY_CARD_RESULT_FAILED_QUERY_CPLC_ERRO = -8;
    public static final int NULLIFY_CARD_RESULT_SUCCESS = 0;

    void nullifyResultCallback(int i);
}
