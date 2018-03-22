package com.huawei.nfc.carrera.logic.swipe.listener;

public interface SwipePerformStateListener {
    public static final int SWIPE_STATE_DONE = 0;
    public static final int SWIPE_STATE_TIMEOUT = -1;

    void swipePrepare(boolean z);

    void swipeState(int i);
}
