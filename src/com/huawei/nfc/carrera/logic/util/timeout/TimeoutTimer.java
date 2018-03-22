package com.huawei.nfc.carrera.logic.util.timeout;

import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.util.LogX;

public class TimeoutTimer extends Handler {
    private static final int TIMEOUT_HANDLER_TAG = 0;
    private TimeoutListener mListener;
    private int mTimeout;

    public TimeoutTimer(int i, TimeoutListener timeoutListener) {
        this.mTimeout = i;
        this.mListener = timeoutListener;
    }

    public void startTimer() {
        removeMessages(0);
        sendEmptyMessageDelayed(0, (long) this.mTimeout);
    }

    public void stopTimer() {
        removeMessages(0);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            LogX.d("timeout");
            if (this.mListener != null) {
                this.mListener.timeout();
            }
            removeMessages(0);
            return;
        }
        LogX.d("timeout timer, ignore msg.");
    }
}
