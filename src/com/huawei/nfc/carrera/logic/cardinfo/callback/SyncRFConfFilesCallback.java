package com.huawei.nfc.carrera.logic.cardinfo.callback;

public interface SyncRFConfFilesCallback {
    public static final int SYNC_RFCONF_RESULT_CODE_DOWNLOAD_SUCCESS = 1;
    public static final int SYNC_RFCONF_RESULT_CODE_FAILED = 3;
    public static final int SYNC_RFCONF_RESULT_CODE_FILE_EXISTS = 0;
    public static final int SYNC_RFCONF_RESULT_CODE_NO_DATA_TO_REFRESH = 2;

    void syncRFConfFilesResult(String str, int i);
}
