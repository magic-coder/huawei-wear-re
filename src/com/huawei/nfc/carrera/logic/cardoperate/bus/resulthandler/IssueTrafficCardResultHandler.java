package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;

public class IssueTrafficCardResultHandler implements TrafficCardBaseResultHandler {
    private IssueTrafficCardCallback mCallback;
    private Handler mUIHandler;

    class Task implements Runnable {
        int resultCode;

        public Task(int i) {
            this.resultCode = i;
        }

        public void run() {
            IssueTrafficCardResultHandler.this.mCallback.issueTrafficCardCallback(this.resultCode);
        }
    }

    public IssueTrafficCardResultHandler(Handler handler, IssueTrafficCardCallback issueTrafficCardCallback) {
        this.mUIHandler = handler;
        this.mCallback = issueTrafficCardCallback;
    }

    public void handleResult(int i) {
        this.mUIHandler.post(new Task(i));
    }
}
