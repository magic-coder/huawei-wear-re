package com.huawei.nfc.carrera.logic.cardoperate.bus.callback;

import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import java.util.List;

public interface QueryRecordsListCallback extends TrafficCardBaseCallback {
    public static final int RESULT_FAILED_TRAFFIC_CARD_RECORDS_READ_FAILED = 1501;

    void queryRecordsListCallback(int i, int i2, List<RecordInfo> list);
}
