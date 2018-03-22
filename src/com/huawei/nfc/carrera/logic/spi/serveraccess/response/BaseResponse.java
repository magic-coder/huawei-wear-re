package com.huawei.nfc.carrera.logic.spi.serveraccess.response;

public class BaseResponse {
    public static final int RESULT_CODE_APPLY_APDU_ABNORMAL_APDU_RESULT = 6002;
    public static final int RESULT_CODE_APPLY_APDU_INVALID_TRANSCATION = 6001;
    public static final int RESULT_CODE_APPLY_APDU_KEY_ERROR = 6004;
    public static final int RESULT_CODE_APPLY_APDU_NO_SE_SPACE = 6003;
    public static final int RESULT_CODE_APPLY_ORDER_HAS_APPLET = 1006;
    public static final int RESULT_CODE_APPLY_ORDER_HAS_UNFINISHED_ORDER = 1004;
    public static final int RESULT_CODE_APPLY_ORDER_LIMITED_CARD_RESOURCE = 1003;
    public static final int RESULT_CODE_APPLY_ORDER_NO_CARD_RESOURCE = 1001;
    public static final int RESULT_CODE_APPLY_ORDER_OVER_DAILY_RECHARGE_COUNT_LIMIT = 1008;
    public static final int RESULT_CODE_APPLY_ORDER_OVER_DAILY_RECHARGE_LIMIT = 1007;
    public static final int RESULT_CODE_APPLY_ORDER_SP_SERVER_UNAVAILABLE = 1009;
    public static final int RESULT_CODE_APPLY_ORDER_UNSUPPORTED_CITY = 1002;
    public static final int RESULT_CODE_APPLY_ORDER_UNSUPPORTED_DEVICE = 1005;
    public static final int RESULT_CODE_DELETE_NO_APPLET = 5002;
    public static final int RESULT_CODE_DELETE_SP_SERVER_ERROR = 5001;
    public static final int RESULT_CODE_DOWNLOAD_INSTALL_CAP_ABNORMAL_ORDER = 2002;
    public static final int RESULT_CODE_DOWNLOAD_INSTALL_CAP_INVALID_ORDER = 2001;
    public static final int RESULT_CODE_DOWNLOAD_INSTALL_CAP_NO_SSD = 2003;
    public static final int RESULT_CODE_DOWNLOAD_INSTALL_CAP_SP_SERVER_ERROR = 2004;
    public static final int RESULT_CODE_INVALID_PARAM = 1;
    public static final int RESULT_CODE_INVALID_ST = 4;
    public static final int RESULT_CODE_NO_NETWORK = 2;
    public static final int RESULT_CODE_NO_SERVICE = 3;
    public static final int RESULT_CODE_OTHER_ERROR = -99;
    public static final int RESULT_CODE_PERSONALIZE_ABNORMAL_ORDER = 3002;
    public static final int RESULT_CODE_PERSONALIZE_INVALID_ORDER = 3001;
    public static final int RESULT_CODE_PERSONALIZE_NO_APPLET = 3004;
    public static final int RESULT_CODE_PERSONALIZE_SP_SERVER_ERROR = 3003;
    public static final int RESULT_CODE_QUERY_AMOUNT_UNSUPPORTED_CITY = 9001;
    public static final int RESULT_CODE_QUERY_AMOUNT_UNSUPPORTED_DEVICE = 9002;
    public static final int RESULT_CODE_QUERY_ORDER_INVALID_ORDER = 8001;
    public static final int RESULT_CODE_RECHARGE_ABNORMAL_APPLET = 4004;
    public static final int RESULT_CODE_RECHARGE_ABNORMAL_ORDER = 4002;
    public static final int RESULT_CODE_RECHARGE_INVALID_ORDER = 4001;
    public static final int RESULT_CODE_RECHARGE_SP_SERVER_ERROR = 4003;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String RESULT_DESC_INVALID_PARAM = "client check, invalid param";
    protected int resultCode = -99;
    protected String resultDesc = null;

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultDesc(String str) {
        this.resultDesc = str;
    }
}
