package com.huawei.nfc.carrera.ui.swipe.listener;

import java.util.List;

public interface QueryPaymentListener {
    public static final int ACCOUNT_LOGIN_STATUS_NOT_LOGIN = 1;
    public static final int QUERY_PAYMENT_FAILED_ERROR = -2;

    void getOpenPayAppMsg(List<String> list, int i);

    void queryFailed(int i);
}
