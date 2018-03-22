package com.huawei.nfc.openapi;

import java.util.Map;

public interface HwNFCOpenApi {
    public static final String OPERATOR_TYPE_CREATE_SSD = "createSSD";
    public static final String OPERATOR_TYPE_DELETE_SSD = "deleteSSD";
    public static final String OPERATOR_TYPE_SYNC_ESE = "SynESE";
    public static final int RETURN_ACCOUNT_NOT_LOGIN = 7;
    public static final int RETURN_FAILED_CONN_UNAVAILABLE = 4;
    public static final int RETURN_FAILED_NO_NETWORK = 3;
    public static final int RETURN_FAILED_UNKNOWN_ERROR = -99;
    public static final int RETURN_INVALID_CALLER_SIGN = 2;
    public static final int RETURN_INVALID_PARAMS = 1;
    public static final int RETURN_NFC_CLOSE = 6;
    public static final int RETURN_NFC_REACH_CARD_CNT_LIMIT = 8;
    public static final int RETURN_NO_READ_PHONE_STATE_PERMISSION = 9;
    public static final int RETURN_SUCCESS = 0;
    public static final int RETURN_TSM_ERROR = 5;

    int createSSD(String str, String str2, String str3, String str4, String str5);

    int deleteSSD(String str, String str2, String str3, String str4, String str5);

    int eSEInfoSync(String str, String str2, String str3, String str4);

    String getCplc(String str);

    String getCplcForTransit(String str);

    String issueCard(String str, Map<String, String> map);
}
