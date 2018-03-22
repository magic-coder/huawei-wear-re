package com.huawei.nfc.carrera.logic.cardoperate.init;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.InitEseResultCallback;
import com.huawei.nfc.carrera.util.LogX;

public class HandleInitEseResultTask implements Runnable {
    private InitEseResultCallback mCallback;
    private Handler mHandler;
    private int resultIdentifyCode;

    public HandleInitEseResultTask(Handler handler, InitEseResultCallback initEseResultCallback) {
        this.mHandler = handler;
        this.mCallback = initEseResultCallback;
    }

    public void notifyInitEseResult(int i) {
        LogX.i("notifyInitEseResult, resultCode: " + i);
        this.resultIdentifyCode = i;
        this.mHandler.post(this);
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.initEseResult(this.resultIdentifyCode);
        }
    }
}
