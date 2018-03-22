package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;

public class RechargeResultHandler {
    private RechargeCallback mCallback;
    private Handler mUIHandler;

    class Task implements Runnable {
        String code;
        int platformCode;
        int resultCode;

        public Task(int i) {
            this.resultCode = i;
        }

        public void run() {
            RechargeResultHandler.this.mCallback.rechargeCallback(this.resultCode);
        }
    }

    public RechargeResultHandler(Handler handler, RechargeCallback rechargeCallback) {
        this.mUIHandler = handler;
        this.mCallback = rechargeCallback;
    }

    public void handleResult(int i) {
        this.mUIHandler.post(new Task(i));
    }
}
