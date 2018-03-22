package com.huawei.nfc.carrera.logic.cardinfo.callback;

public interface RefreshLocalIconCallback {
    public static final int REFRESH_RESULT_CODE_CREATE_DIR_FAIL = -2;
    public static final int REFRESH_RESULT_CODE_CREATE_FILE_FAIL = -3;
    public static final int REFRESH_RESULT_CODE_NO_NEED = 0;
    public static final int REFRESH_RESULT_CODE_REFRESH_FAIL = -1;
    public static final int REFRESH_RESULT_CODE_REFRESH_SUCCESS = 1;
    public static final int REFRESH_RESULT_CODE_WRITE_STORAGE_FAIL = -4;

    void refreshPicResult(int i);
}
