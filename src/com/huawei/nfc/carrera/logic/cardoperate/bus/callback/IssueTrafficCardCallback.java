package com.huawei.nfc.carrera.logic.cardoperate.bus.callback;

import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardBaseCallback;

public interface IssueTrafficCardCallback extends TrafficCardBaseCallback {
    public static final int RETURN_FAILED_ADD_TA_CARD_FAILED = 1106;
    public static final int RETURN_FAILED_CARD_CNT_REACH_LIMIT = 1101;
    public static final int RETURN_FAILED_CITYCODE_ILLEGAL = 1103;
    public static final int RETURN_FAILED_ISSUE_CARD_INNER_ERROR = 1199;
    public static final int RETURN_FAILED_READ_CARDNUM_FAILED = 1105;
    public static final int RETURN_FAILED_REPEAT_ISSUERCARD = 1102;
    public static final int RETURN_FAILED_SSD_INSTALL_FAILED = 1104;

    void issueTrafficCardCallback(int i);
}
