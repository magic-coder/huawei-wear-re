package com.huawei.nfc.carrera.logic.spi.fm.request;

public class FMBaseRequest {
    public static final int BITMAP_ALL_INFO = 7;
    public static final int BITMAP_BALANCE = 2;
    public static final int BITMAP_CARD_NUMBER_AND_APP_NUMBER = 1;
    public static final int BITMAP_MOC = 16;
    public static final int BITMAP_TRADE_RECORDS = 4;
    public static final int BITMAP_VALID_TIME = 32;
    public static final int BUSINESS_ORDER_TYPE_ISSUE = 2;
    public static final int BUSINESS_ORDER_TYPE_RECHARGE = 1;
    public static final int CARD_APP_TYPE_LNT = 2;
    public static final int CARD_APP_TYPE_SH = 1;
    public static final int CARD_MODE_WX = 8;
    public static final int FM_MODE_WX = 9;
    public static final byte HANDLE_FLAG_DOWNLOAD_CAP = (byte) 81;
    public static final byte HANDLE_FLAG_DOWNLOAD_CAP_INSTALL_AND_PERSONALIZE = (byte) 1;
    public static final byte HANDLE_FLAG_INSTALL_AND_PERSONALIZE = (byte) 2;
    public static final int ISSUE_ACT_MODE_HW = 70;
    public static final int ISSUE_MODE_HW = 89;
    public static final int ORDER_STATUS_APPLY_FOR_REFUND = 6;
    public static final int ORDER_STATUS_DUBIOUS = 12;
    public static final int ORDER_STATUS_ERROR = 99;
    public static final int ORDER_STATUS_FAILURE = 4;
    public static final int ORDER_STATUS_HAS_PAIED = 2;
    public static final int ORDER_STATUS_HAS_REFUNDED = 7;
    public static final int ORDER_STATUS_INVALID = 13;
    public static final int ORDER_STATUS_NOT_EXIST = 0;
    public static final int ORDER_STATUS_PAY_FAILURE = 9;
    public static final int ORDER_STATUS_RECHARGING = 11;
    public static final int ORDER_STATUS_REFUND_FAILURE = 8;
    public static final int ORDER_STATUS_SUCCESS = 3;
    public static final int ORDER_STATUS_UNKNOWN = 5;
    public static final int QUERY_SCOPE_10 = 10;
    public static final int RECHARGE_MODE_HW = 69;
}
