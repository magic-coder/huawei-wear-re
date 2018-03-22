package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryOfflineTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OfflineTrafficCardInfo;

public class QueryOfflineTrafficCardInfoResultHandler {
    private QueryOfflineTrafficCardInfoCallback callback;
    private Handler resultHandler;

    class Task implements Runnable {
        private OfflineTrafficCardInfo info;
        private int resultCode;

        public Task(int i, OfflineTrafficCardInfo offlineTrafficCardInfo) {
            this.resultCode = i;
            this.info = offlineTrafficCardInfo;
        }

        public void run() {
            if (QueryOfflineTrafficCardInfoResultHandler.this.callback != null) {
                QueryOfflineTrafficCardInfoResultHandler.this.callback.queryOfflineTrafficCardInfoCallback(this.resultCode, this.info);
            }
        }
    }

    public QueryOfflineTrafficCardInfoResultHandler(Handler handler, QueryOfflineTrafficCardInfoCallback queryOfflineTrafficCardInfoCallback) {
        this.callback = queryOfflineTrafficCardInfoCallback;
        this.resultHandler = handler;
    }

    public void handleResult(int i, OfflineTrafficCardInfo offlineTrafficCardInfo) {
        this.resultHandler.post(new Task(i, offlineTrafficCardInfo));
    }
}
