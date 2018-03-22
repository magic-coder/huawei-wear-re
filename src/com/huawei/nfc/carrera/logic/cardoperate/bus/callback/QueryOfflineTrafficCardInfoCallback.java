package com.huawei.nfc.carrera.logic.cardoperate.bus.callback;

import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OfflineTrafficCardInfo;

public interface QueryOfflineTrafficCardInfoCallback extends TrafficCardBaseCallback {
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_AMOUNT_ABNORMAL = 1403;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_DATE_FORMAT_ERROR = 1406;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_ENABLE_DATE_ABNORMAL = 1404;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_OUT_OF_EXPIRE_DATE = 1405;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_OVERDRAFT_AMOUNT_ABNORMAL = 1402;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED = 1408;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_READ_FAILED = 1499;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_STATUS_ABNORMAL = 1401;
    public static final int RESULT_FAILED_TRAFFIC_CARD_INFO_VERIFY_PIN_FAILED = 1407;

    void queryOfflineTrafficCardInfoCallback(int i, OfflineTrafficCardInfo offlineTrafficCardInfo);
}
