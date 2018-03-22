package com.huawei.nfc.carrera.logic.filedownload.unionpay.listener;

public interface UnionpayInfoCallback {
    void failed(int i, String str);

    void success(String str, String str2);
}
