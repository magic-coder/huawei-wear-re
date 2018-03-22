package com.huawei.nfc.carrera.logic.cardoperate.citic;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.NullifyCardResultCallback;

public class HandleNullifyCardResultTask implements Runnable {
    private Handler mExcuteHandler;
    private NullifyCardResultCallback mResultCallback;
    private int resultCode;

    public HandleNullifyCardResultTask(Handler handler, NullifyCardResultCallback nullifyCardResultCallback) {
        this.mExcuteHandler = handler;
        this.mResultCallback = nullifyCardResultCallback;
    }

    public void notifyNullifyResult(int i) {
        this.resultCode = i;
        this.mExcuteHandler.post(this);
    }

    public void run() {
        if (this.mResultCallback != null) {
            this.mResultCallback.nullifyResultCallback(this.resultCode);
        }
    }
}
