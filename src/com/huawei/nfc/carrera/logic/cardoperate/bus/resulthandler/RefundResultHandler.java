package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RefundCallback;

public class RefundResultHandler {
    private RefundCallback callback;
    private Handler resultHandler;

    class Task implements Runnable {
        private int resultCode;

        public Task(int i) {
            this.resultCode = i;
        }

        public void run() {
            if (RefundResultHandler.this.callback != null) {
                RefundResultHandler.this.callback.refundCallback(this.resultCode);
            }
        }
    }

    public RefundResultHandler(Handler handler, RefundCallback refundCallback) {
        this.callback = refundCallback;
        this.resultHandler = handler;
    }

    public void handleResult(int i) {
        this.resultHandler.post(new Task(i));
    }
}
