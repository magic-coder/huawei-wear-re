package com.huawei.nfc.carrera.ui.bindcard;

public interface ShownBindSuccessEndListener {
    public static final int BIND_FAIL_CONTACT_TO_SERVER = 4;
    public static final int BIND_FAIL_CONTACT_TO_UNIONPAY = 6;
    public static final int BIND_FAIL_DELETE_CARD_REBIND = 5;
    public static final int BIND_FAIL_DO_NOTHIND = 1;
    public static final int BIND_FAIL_REBIND = 3;
    public static final int BIND_FAIL_REINPUT_CARD_INFO = 2;
    public static final int BIND_SUCCESS = 0;

    void bindSuccess(int i);
}
