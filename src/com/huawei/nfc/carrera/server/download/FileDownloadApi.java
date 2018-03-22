package com.huawei.nfc.carrera.server.download;

import com.huawei.nfc.carrera.logic.filedownload.DownLoadListener;
import java.io.File;

public interface FileDownloadApi {
    public static final int DOWNLOAD_CANCEL = -5;
    public static final int DOWNLOAD_RESULT_FAIL_FILENOTFOUNDEXCEPTION = -4;
    public static final int DOWNLOAD_RESULT_FAIL_IOEXCEPTION = -3;
    public static final int DOWNLOAD_RESULT_FAIL_NO_NETWORK = -1;
    public static final int DOWNLOAD_RESULT_FAIL_OTHER_ERRORS = -99;
    public static final int DOWNLOAD_RESULT_FAIL_PARAMS_ILLEGAL = -2;
    public static final int DOWNLOAD_RESULT_SUCCESS = 0;

    int download(String str, File file);

    int download(String str, File file, DownLoadListener downLoadListener);
}
