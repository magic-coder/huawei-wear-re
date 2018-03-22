package com.huawei.nfc.carrera.logic.filedownload;

public interface DownLoadListener {
    void downLoadConnected(long j);

    void downProgress(int i, long j, String str);
}
