package com.huawei.nfc.carrera.logic.cardoperate.cup;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.HandleCUPPersonalizedResultCallback;

public class HandlePersonalizedResultTask implements Runnable {
    private Handler excuteHandler;
    private HandleCUPPersonalizedResultCallback mCallback;
    private int resultCode;

    public HandlePersonalizedResultTask(HandleCUPPersonalizedResultCallback handleCUPPersonalizedResultCallback, Handler handler) {
        this.mCallback = handleCUPPersonalizedResultCallback;
        this.excuteHandler = handler;
    }

    public void notifyHandleResult(int i) {
        this.resultCode = i;
        this.excuteHandler.post(this);
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.handleResultCallback(this.resultCode);
        }
    }
}
