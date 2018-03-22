package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryTrafficCardBalanceCallback;

public class QueryTrafficCardBalanceResultHandler {
    private QueryTrafficCardBalanceCallback callback;
    private Handler resultHandler;

    class Task implements Runnable {
        private double balance;
        private int resultCode;

        public Task(int i, double d) {
            this.resultCode = i;
            this.balance = d;
        }

        public void run() {
            if (QueryTrafficCardBalanceResultHandler.this.callback != null) {
                QueryTrafficCardBalanceResultHandler.this.callback.queryTrafficCardBalance(this.resultCode, this.balance);
            }
        }
    }

    public QueryTrafficCardBalanceResultHandler(Handler handler, QueryTrafficCardBalanceCallback queryTrafficCardBalanceCallback) {
        this.callback = queryTrafficCardBalanceCallback;
        this.resultHandler = handler;
    }

    public void handleResult(int i, double d) {
        this.resultHandler.post(new Task(i, d));
    }
}
