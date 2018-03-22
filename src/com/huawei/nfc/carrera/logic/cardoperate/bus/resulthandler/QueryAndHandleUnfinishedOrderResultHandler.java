package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;

public class QueryAndHandleUnfinishedOrderResultHandler {
    private QueryAndHandleUnfinishedOrderCallback mCallback;
    private Handler resultHandler;

    class Task implements Runnable {
        private OrderHandleResultInfo mInfo;
        private int mResultCode;
        private int mResultType;

        public Task(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
            this.mResultCode = i;
            this.mResultType = i2;
            this.mInfo = orderHandleResultInfo;
        }

        public void run() {
            if (QueryAndHandleUnfinishedOrderResultHandler.this.mCallback != null) {
                QueryAndHandleUnfinishedOrderResultHandler.this.mCallback.queryAndHandleUnfinishedOrderCallback(this.mResultCode, this.mResultType, this.mInfo);
            }
        }
    }

    public QueryAndHandleUnfinishedOrderResultHandler(Handler handler, QueryAndHandleUnfinishedOrderCallback queryAndHandleUnfinishedOrderCallback) {
        this.resultHandler = handler;
        this.mCallback = queryAndHandleUnfinishedOrderCallback;
    }

    public void handleResult(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        this.resultHandler.post(new Task(i, i2, orderHandleResultInfo));
    }
}
