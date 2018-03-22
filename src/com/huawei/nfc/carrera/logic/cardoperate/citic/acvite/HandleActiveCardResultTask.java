package com.huawei.nfc.carrera.logic.cardoperate.citic.acvite;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.ActiveCardCallback;

public class HandleActiveCardResultTask implements Runnable {
    private ActiveCardCallback mCallback;
    private Handler mExcuteHandler;
    private int resultCode;

    public HandleActiveCardResultTask(Handler handler, ActiveCardCallback activeCardCallback) {
        this.mExcuteHandler = handler;
        this.mCallback = activeCardCallback;
    }

    public void notifyActiveResult(int i) {
        this.resultCode = i;
        this.mExcuteHandler.post(this);
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.activeResultCallback(this.resultCode);
        }
    }
}
