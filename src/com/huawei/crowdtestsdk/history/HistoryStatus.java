package com.huawei.crowdtestsdk.history;

import com.huawei.androidcommon.utils.StringUtils;

public class HistoryStatus {
    public static final String HISTORY_STATUS_COLLECTING_CODE = "0";
    public static final String HISTORY_STATUS_COMPRESSING_CODE = "1";
    public static final String HISTORY_STATUS_DRAFT_CODE = "4";
    public static final String HISTORY_STATUS_PAUSED_CODE = "5";
    public static final String HISTORY_STATUS_SENDING_CODE = "2";
    public static final String HISTORY_STATUS_SEND_FAIL_CODE = "-1";
    public static final String HISTORY_STATUS_SEND_SUCCESS_CODE = "3";

    public static boolean isSentSuccessState(String str) {
        if (StringUtils.isNullOrEmpty(str) || !str.equalsIgnoreCase("3")) {
            return false;
        }
        return true;
    }

    public static boolean isSentFailState(String str) {
        if (StringUtils.isNullOrEmpty(str) || !str.equalsIgnoreCase("-1")) {
            return false;
        }
        return true;
    }
}
