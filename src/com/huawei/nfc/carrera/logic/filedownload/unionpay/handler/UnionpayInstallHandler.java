package com.huawei.nfc.carrera.logic.filedownload.unionpay.handler;

import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.UnionpayInstallCallBack;
import com.huawei.nfc.carrera.util.LogX;

public class UnionpayInstallHandler extends Handler {
    public static final int SING_UNEQUAL = -1;
    private String WRONG_SIGN_TIP = "wrong signature";
    private UnionpayInstallCallBack callback;

    public UnionpayInstallHandler(UnionpayInstallCallBack unionpayInstallCallBack) {
        this.callback = unionpayInstallCallBack;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.callback == null) {
            LogX.e("install callback is null ，you need excute registeListeners()  method  before download() method");
            return;
        }
        switch (message.what) {
            case -2001:
                this.callback.installFailed(-2001, null);
                return;
            case -1:
                this.callback.installFailed(-1, this.WRONG_SIGN_TIP);
                return;
            case 1:
                this.callback.installSuccess();
                return;
            default:
                this.callback.installFailed(message.what, null);
                return;
        }
    }

    public void sendWrongSignMessage() {
        sendEmptyMessage(-1);
    }

    public void sendFailedMessage() {
        sendEmptyMessage(-2001);
    }

    public void unregisterListener() {
        this.callback = null;
    }
}
