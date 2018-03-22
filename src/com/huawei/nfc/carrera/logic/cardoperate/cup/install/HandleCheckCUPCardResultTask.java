package com.huawei.nfc.carrera.logic.cardoperate.cup.install;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.CheckCUPCardCallback;

public class HandleCheckCUPCardResultTask implements Runnable {
    private Handler excuteHandler;
    private CheckCUPCardCallback mCallback;

    public HandleCheckCUPCardResultTask(CheckCUPCardCallback checkCUPCardCallback, Handler handler) {
        this.mCallback = checkCUPCardCallback;
        this.excuteHandler = handler;
    }

    public void notifyCheckFinished() {
        this.excuteHandler.post(this);
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.checkFinished();
        }
    }
}
