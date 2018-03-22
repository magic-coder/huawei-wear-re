package com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.RequestVerifyCodeCallback;

public class HandleVerifyCodeResultTask implements Runnable {
    private RequestVerifyCodeCallback mCallback;
    private Handler mExcuteHandler;
    private String phoneNum;
    private int resultCode;

    public HandleVerifyCodeResultTask(Handler handler, RequestVerifyCodeCallback requestVerifyCodeCallback) {
        this.mExcuteHandler = handler;
        this.mCallback = requestVerifyCodeCallback;
    }

    public void notifyRequestResult(int i, String str) {
        this.resultCode = i;
        this.phoneNum = str;
        this.mExcuteHandler.post(this);
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.requestResultCallback(this.resultCode, this.phoneNum);
        }
    }
}
