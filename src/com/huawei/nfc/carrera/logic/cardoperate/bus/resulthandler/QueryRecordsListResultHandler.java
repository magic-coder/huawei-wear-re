package com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryRecordsListCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import java.util.List;

public class QueryRecordsListResultHandler {
    private QueryRecordsListCallback callback;
    private Handler resultHandler;

    class Task implements Runnable {
        private List<RecordInfo> records;
        private int recordsType;
        private int resultCode;

        public Task(int i, int i2, List<RecordInfo> list) {
            this.resultCode = i2;
            this.recordsType = i;
            this.records = list;
        }

        public void run() {
            if (QueryRecordsListResultHandler.this.callback != null) {
                QueryRecordsListResultHandler.this.callback.queryRecordsListCallback(this.recordsType, this.resultCode, this.records);
            }
        }
    }

    public QueryRecordsListResultHandler(Handler handler, QueryRecordsListCallback queryRecordsListCallback) {
        this.callback = queryRecordsListCallback;
        this.resultHandler = handler;
    }

    public void handleResult(int i, int i2, List<RecordInfo> list) {
        this.resultHandler.post(new Task(i, i2, list));
    }
}
