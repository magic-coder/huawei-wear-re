package com.huawei.nfc.carrera.logic.cardoperate.bus;

public interface TrafficCardBaseCallback {
    public static final int RETURN_FAILED_CARD_BALANCE_ERROR = 23;
    public static final int RETURN_FAILED_CARD_DATE_ERROR = 29;
    public static final int RETURN_FAILED_CARD_DISABLED = 21;
    public static final int RETURN_FAILED_CARD_ENABLE_DATE_ERROR = 26;
    public static final int RETURN_FAILED_CARD_IN_BLACKLIST = 22;
    public static final int RETURN_FAILED_CARD_OVERDRAFT_ERROR = 24;
    public static final int RETURN_FAILED_CONN_UNAVAILABLE = 25;
    public static final int RETURN_FAILED_CPLC_IS_NULL = 13;
    public static final int RETURN_FAILED_INNER_ERROR = 99;
    public static final int RETURN_FAILED_NFC_CLOSED = 12;
    public static final int RETURN_FAILED_NO_NETWORK = 11;
    public static final int RETURN_FAILED_PARAM_ERROR = 10;
    public static final int RETURN_FAILED_PURSE_ERROR = 27;
    public static final int RETURN_FAILED_READ_ESE_FAILED = 20;
    public static final int RETURN_FAILED_ST_CHECK_FAILED = 14;
    public static final int RETURN_FAILED_THE_CARD_HAS_A_DATE_ERROR = 28;
    public static final int RETURN_SUCCESS = 0;
    public static final int RETURN_UNSUPPORTED = 1;
}
