package com.huawei.nfc.carrera.logic.cardoperate.citic.install;

public interface InstallPrepareTaskListener {
    public static final int INSTALL_RESULT_CODE_FAILED_REACH_BANK_LIMIT = -15;
    public static final int TASK_RESULT_FAILED_APPLYAID_EXCEED_LIMIT = -7;
    public static final int TASK_RESULT_FAILED_CONNECT_ERROR = -4;
    public static final int TASK_RESULT_FAILED_CONTACT_BANK_CALLING_CENTER = -14;
    public static final int TASK_RESULT_FAILED_NO_NETWORK = -3;
    public static final int TASK_RESULT_FAILED_OTHER_ERRORS = -99;
    public static final int TASK_RESULT_SUCCESS = 0;

    void prepareAidApplied(String str);

    void prepareFaskFinished(int i);

    void prepareTaskQueqing();

    void prepareTaskStart();
}
