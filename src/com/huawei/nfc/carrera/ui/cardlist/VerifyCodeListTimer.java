package com.huawei.nfc.carrera.ui.cardlist;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.huawei.wallet.R;

public class VerifyCodeListTimer extends Handler {
    private static final int HANDLER_TAG_COUNT_DOWN = 0;
    private static final int TOTAL_TIME_SEC = 120;
    private TextView getVerifyCodeButton;
    private Context mContext;
    private int remainTime = TOTAL_TIME_SEC;

    public VerifyCodeListTimer(Context context, TextView textView) {
        this.mContext = context;
        this.getVerifyCodeButton = textView;
    }

    public void startTimer() {
        this.getVerifyCodeButton.setClickable(false);
        this.remainTime = TOTAL_TIME_SEC;
        countDown();
    }

    public void stopTimer() {
        this.getVerifyCodeButton.setText(R.string.nfc_get_verify_code);
        this.getVerifyCodeButton.setClickable(true);
        removeMessages(0);
    }

    private void countDown() {
        this.getVerifyCodeButton.setText(this.mContext.getString(R.string.nfc_get_verify_code) + this.mContext.getString(R.string.nfc_count_down_seconds, new Object[]{Integer.valueOf(this.remainTime)}));
        sendEmptyMessageDelayed(0, 1000);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.remainTime--;
        if (this.remainTime < 1) {
            stopTimer();
        } else {
            countDown();
        }
    }
}
