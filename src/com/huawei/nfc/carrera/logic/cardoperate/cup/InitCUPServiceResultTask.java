package com.huawei.nfc.carrera.logic.cardoperate.cup;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.InitCUPCardOperatorCallback;

public class InitCUPServiceResultTask {
    InitCUPCardOperatorCallback callback;
    private Handler operateResultHandler;

    class Task implements Runnable {
        private int resultCode;

        public Task(int i) {
            this.resultCode = i;
        }

        public void run() {
            if (InitCUPServiceResultTask.this.callback != null) {
                InitCUPServiceResultTask.this.callback.initCUPCardOperatorResult(this.resultCode);
            }
        }
    }

    public InitCUPServiceResultTask(Handler handler, InitCUPCardOperatorCallback initCUPCardOperatorCallback) {
        this.callback = initCUPCardOperatorCallback;
        this.operateResultHandler = handler;
    }

    public void handleResult(int i) {
        this.operateResultHandler.post(new Task(i));
    }
}
