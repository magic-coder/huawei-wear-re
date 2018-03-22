package com.huawei.nfc.carrera.logic.filedownload.unionpay.listener;

public interface DownLoadCallback {
    void downLoadConnected(long j);

    void downLoadFailed(int i);

    void downLoadSuccess(String str);

    void downProgress(int i, long j);
}
