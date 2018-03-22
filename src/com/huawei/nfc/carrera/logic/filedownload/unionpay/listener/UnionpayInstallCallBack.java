package com.huawei.nfc.carrera.logic.filedownload.unionpay.listener;

public interface UnionpayInstallCallBack {
    void installFailed(int i, String str);

    void installSuccess();
}
