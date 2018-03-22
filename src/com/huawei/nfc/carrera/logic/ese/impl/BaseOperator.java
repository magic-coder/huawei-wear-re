package com.huawei.nfc.carrera.logic.ese.impl;

import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryTradeRecordsResponse;
import org.simalliance.openmobileapi.C6649a;

public abstract class BaseOperator {
    public static final String COMMON_CHECKER = ".*9000$";
    public static final String COMMON_CHECKER1 = ".*(9000|61..)$";

    protected abstract int getCardStatus(C6649a c6649a);

    protected abstract QueryTradeRecordsResponse queryTradeRecordsApdu(C6649a c6649a);

    protected abstract QueryCardInfoResponse queryTrafficCardInfo(C6649a c6649a, int i);
}
