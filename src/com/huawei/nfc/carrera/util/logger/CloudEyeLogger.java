package com.huawei.nfc.carrera.util.logger;

import com.huawei.nfc.carrera.util.LogX;
import java.util.HashMap;

public class CloudEyeLogger implements LoggerConstant {
    public static final String FAIL_CODE = "fail_code";
    public static final String FAIL_DESC = "fail_desc";
    private static final String ISSUER_ID = "issuerId";
    private static HashMap<String, String> msgTable = new HashMap();
    private int eventId;
    private HashMap<String, String> extraInfo = new HashMap();
    private String failCode;
    private boolean isNeedProguard = false;
    private boolean isNeedUploadLogFile = false;
    private int resultCode;
    private String resultDesc;

    static {
        msgTable.put("1200", LoggerConstant.RESULT_DESC_QUERY_ISSUE_MONEY_FAIL);
        msgTable.put("1300", LoggerConstant.RESULT_DESC_APPLY_ISSUE_ORDER_FAIL);
        msgTable.put("1400", LoggerConstant.RESULT_DESC_PAY_FAIL);
        msgTable.put("1101", LoggerConstant.RESULT_DESC_CREATE_SSD_FAIL);
        msgTable.put("1102", LoggerConstant.RESULT_DESC_ISSUE_CARD_FAIL);
        msgTable.put("1104", LoggerConstant.RESULT_DESC_UPDATE_APPLET_FAIL);
        msgTable.put(LoggerConstant.RESULT_CODE_ISSUE_CARD_OTHER_FAIL, LoggerConstant.RESULT_DESC_ISSUE_CARD_OTHER_FAIL);
        msgTable.put("1501", LoggerConstant.RESULT_DESC_APPLY_RECHARGE_ORDER);
        msgTable.put("1502", LoggerConstant.RESULT_DESC_RECHARGE);
        msgTable.put("3101", LoggerConstant.RESULT_DESC_UNIONPAY_ADDON_DOWNLOAD_FAIL);
        msgTable.put("3102", LoggerConstant.RESULT_DESC_CREATE_AMSD_FAIL);
        msgTable.put("3103", LoggerConstant.RESULT_DESC_INIT_UNIONPAY_ADDON_FAILED);
        msgTable.put("3104", LoggerConstant.RESULT_DESC_IDENTIFY_CARD_NUM_FAILED);
        msgTable.put("3105", LoggerConstant.RESULT_DESC_APPLY_CARD_FAILED);
        msgTable.put("3106", LoggerConstant.RESULT_DESC_WAITING_LOAD_CAP_START_TIMEOUT);
        msgTable.put("3107", LoggerConstant.RESULT_DESC_LOAD_CAP_FAILED);
        msgTable.put("3108", LoggerConstant.RESULT_DESC_UPDATE_PERSONALIZED_INFO_INTO_TA_FAILED);
        msgTable.put("3109", "active card failed");
        msgTable.put("3110", LoggerConstant.RESULT_DESC_SET_FINGER_PRINT_PWD_FAILED);
        msgTable.put("3201", LoggerConstant.RESULT_DESC_DELETE_BANK_CARD_FAILED);
        msgTable.put(LoggerConstant.RESULT_CODE_APPLY_TRANSFER_OUT_FAIL, LoggerConstant.RESULT_DESC_APPLY_TRANSFER_OUT_FAIL);
        msgTable.put("2101", LoggerConstant.RESULT_DESC_TRANSFER_OUT_APPLY_ORDER_FAIL);
        msgTable.put("2102", LoggerConstant.RESULT_DESC_TRANSFER_OUT_FAIL);
        msgTable.put("2103", LoggerConstant.RESULT_DESC_TRANSFER_OUT_REPORT_STATUS_FAIL);
        msgTable.put("2104", LoggerConstant.RESULT_DESC_TRANSFER_OUT_SYNC_ESE_INFO_FAIL);
        msgTable.put("2105", LoggerConstant.RESULT_DESC_TRANSFER_OUT_DELETE_SSD_FAIL);
        msgTable.put(LoggerConstant.RESULT_CODE_TRANSFER_OUT_OTHER_FAIL, LoggerConstant.RESULT_DESC_TRANSFER_OUT_OTHER_FAIL);
        msgTable.put(LoggerConstant.RESULT_CODE_AGREE_TRANSFER_IN_FAIL, LoggerConstant.RESULT_DESC_AGREE_TRANSFER_IN_FAIL);
        msgTable.put("2201", LoggerConstant.RESULT_DESC_TRANSFER_IN_CREATE_DMSD_FAIL);
        msgTable.put("2202", LoggerConstant.RESULT_DESC_TRANSFER_IN_APPLY_ORDER_FAIL);
        msgTable.put("2203", LoggerConstant.RESULT_DESC_TRANSFER_IN_FAIL);
        msgTable.put("2204", LoggerConstant.RESULT_DESC_TRANSFER_IN_REPORT_STATUS_FAIL);
        msgTable.put("2207", LoggerConstant.RESULT_DESC_TRANSFER_IN_QUERY_MOVE_CODE_FAIL);
        msgTable.put(LoggerConstant.RESULT_CODE_TRANSFER_IN_OTHER_FAIL, LoggerConstant.RESULT_DESC_TRANSFER_IN_OTHER_FAIL);
        msgTable.put("2205", LoggerConstant.RESULT_DESC_TRANSFER_IN_RECHARGE_APPLY_ORDER_FAIL);
        msgTable.put("2206", LoggerConstant.RESULT_DESC_TRANSFER_IN_RECHARGE_FAIL);
    }

    public static CloudEyeLogger build(int i) {
        return new CloudEyeLogger(i);
    }

    public static CloudEyeLogger build(int i, String str) {
        return new CloudEyeLogger(i, str);
    }

    public static CloudEyeLogger build(int i, String str, String str2) {
        return new CloudEyeLogger(i, str, str2);
    }

    private CloudEyeLogger(int i) {
        this.eventId = i;
    }

    private CloudEyeLogger(int i, String str) {
        this.eventId = i;
        this.extraInfo.put("issuerId", str);
    }

    private CloudEyeLogger(int i, String str, String str2) {
        this.eventId = i;
        this.failCode = str;
        this.extraInfo.put("issuerId", str2);
    }

    public CloudEyeLogger setNeedUploadLogFile(boolean z) {
        this.isNeedUploadLogFile = z;
        return this;
    }

    public CloudEyeLogger setIsNeedProguard(boolean z) {
        this.isNeedProguard = z;
        return this;
    }

    public CloudEyeLogger setFailCode(String str) {
        this.failCode = str;
        return this;
    }

    public CloudEyeLogger setResultCode(int i) {
        this.resultCode = i;
        return this;
    }

    public CloudEyeLogger setResultDesc(String str) {
        this.resultDesc = str;
        return this;
    }

    public CloudEyeLogger appendExtraInfo(String str, int i) {
        return appendExtraInfo(str, String.valueOf(i));
    }

    public CloudEyeLogger appendExtraInfo(String str, String str2) {
        if (FAIL_CODE.equals(str)) {
            this.failCode = str2;
        } else {
            this.extraInfo.put(str, str2);
        }
        return this;
    }

    public void upload() {
        this.extraInfo.put(FAIL_CODE, this.failCode);
        String msg = getMsg(this.failCode, this.resultCode, this.resultDesc);
        this.extraInfo.put("fail_desc", msg);
        LogX.e(this.eventId, this.extraInfo, msg, this.isNeedUploadLogFile, this.isNeedProguard);
        this.extraInfo.clear();
    }

    private String getMsg(String str, int i, String str2) {
        return ((String) msgTable.get(str)) + ", result code = " + i + ", result desc = " + str2;
    }
}
