package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.ApplyPayOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;

public class ApplyPayOrderResultHandler {
    private ApplyPayOrderCallback mCallback;
    private Handler mUIHandler;

    class Task implements Runnable {
        TrafficOrder order;
        int resultCode;

        public Task(int i, TrafficOrder trafficOrder) {
            this.resultCode = i;
            this.order = trafficOrder;
        }

        public void run() {
            ApplyPayOrderResultHandler.this.mCallback.applyPayOrderCallback(this.resultCode, this.order);
        }
    }

    public ApplyPayOrderResultHandler(Handler handler, ApplyPayOrderCallback applyPayOrderCallback) {
        this.mUIHandler = handler;
        this.mCallback = applyPayOrderCallback;
    }

    public void handleResult(int i, TrafficOrder trafficOrder) {
        this.mUIHandler.post(new Task(i, trafficOrder));
    }
}
