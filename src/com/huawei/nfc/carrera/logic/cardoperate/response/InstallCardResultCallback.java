package com.huawei.nfc.carrera.logic.cardoperate.response;

public interface InstallCardResultCallback {
    public static final int INSTALL_RESULT_CODE_APPLYCARD_EXCEED_LIMIT = -7;
    public static final int INSTALL_RESULT_CODE_CARDNUM_ASSOCIATED_OVERRUN = -16;
    public static final int INSTALL_RESULT_CODE_CARD_APPLYED = -8;
    public static final int INSTALL_RESULT_CODE_CONTACT_BANK = -18;
    public static final int INSTALL_RESULT_CODE_CUSTOMER_NO_PERMISSION = -17;
    public static final int INSTALL_RESULT_CODE_ERROR_ACCOUNT_INFO_INVALID = -12;
    public static final int INSTALL_RESULT_CODE_ERROR_CARD_STATUS = -10;
    public static final int INSTALL_RESULT_CODE_ERROR_CONTACT_BANK_CALLING_CENTER = -14;
    public static final int INSTALL_RESULT_CODE_ERROR_INPUT_INFO = -9;
    public static final int INSTALL_RESULT_CODE_ERROR_NO_APPLICATION_PERMISSION = -11;
    public static final int INSTALL_RESULT_CODE_ERROR_NO_PHONE = -13;
    public static final int INSTALL_RESULT_CODE_FAILED_CONN_ERROR = -4;
    public static final int INSTALL_RESULT_CODE_FAILED_CUP_NOT_INSTALLED = -5;
    public static final int INSTALL_RESULT_CODE_FAILED_NOT_SUPPORTED = -2;
    public static final int INSTALL_RESULT_CODE_FAILED_NO_NETWORK = -3;
    public static final int INSTALL_RESULT_CODE_FAILED_OTHER_ERRORS = -99;
    public static final int INSTALL_RESULT_CODE_FAILED_PARAMS_ILLEGAL = -1;
    public static final int INSTALL_RESULT_CODE_FAILED_REACH_BANK_LIMIT = -15;
    public static final int INSTALL_RESULT_CODE_FAILED_REACH_LIMIT = -6;
    public static final int INSTALL_RESULT_CODE_ON_RISK = -20;
    public static final int INSTALL_RESULT_CODE_OPERATION_DATA_OUT_OF_USE = -19;
    public static final int INSTALL_RESULT_CODE_SUCCESS = 0;

    void installResultCallback(int i, String str, String str2);
}
