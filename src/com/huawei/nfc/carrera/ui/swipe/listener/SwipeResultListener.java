package com.huawei.nfc.carrera.ui.swipe.listener;

public interface SwipeResultListener {
    public static final int SWIPE_RESULT_DONE = 0;
    public static final int SWIPE_RESULT_FAILED = 2;
    public static final int SWIPE_RESULT_TIMEOUT = 1;

    void swipeResult(int i);
}
