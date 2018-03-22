package com.huawei.nfc.carrera.logic.wxpay;

public interface WXPayCallback {
    void onWXPayCancel();

    void onWXPayFail(int i);

    void onWXPaySuccess();
}
