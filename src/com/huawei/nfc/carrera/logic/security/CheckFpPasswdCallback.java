package com.huawei.nfc.carrera.logic.security;

public interface CheckFpPasswdCallback {
    public static final int CHECK_RESULT_FAILED_FREEZE = 14;
    public static final int CHECK_RESULT_FAILED_NOT_MATCH = 12;
    public static final int CHECK_RESULT_FAILED_USER_CANCELED = 13;
    public static final int CHECK_RESULT_SUCCESS = 10;
    public static final int CHECK_STATUS_INPUTTING = 2;
    public static final int CHECK_STATUS_INPUT_COMPLETE = 3;
    public static final int CHECK_STATUS_WATIING_INPUT = 1;

    void onCheckResult(int i);

    void onChecking(int i);
}
