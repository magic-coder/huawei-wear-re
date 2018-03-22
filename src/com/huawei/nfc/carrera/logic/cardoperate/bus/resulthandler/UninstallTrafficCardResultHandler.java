package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.UninstallTrafficCardCallback;

public class UninstallTrafficCardResultHandler {
    private UninstallTrafficCardCallback callback;
    private Handler operateResultHandler;

    class Task implements Runnable {
        private int resultCode;

        public Task(int i) {
            this.resultCode = i;
        }

        public void run() {
            if (UninstallTrafficCardResultHandler.this.callback != null) {
                UninstallTrafficCardResultHandler.this.callback.uninstallTrafficCardCallback(this.resultCode);
            }
        }
    }

    public UninstallTrafficCardResultHandler(Handler handler, UninstallTrafficCardCallback uninstallTrafficCardCallback) {
        this.callback = uninstallTrafficCardCallback;
        this.operateResultHandler = handler;
    }

    public void handleResult(int i) {
        this.operateResultHandler.post(new Task(i));
    }
}
