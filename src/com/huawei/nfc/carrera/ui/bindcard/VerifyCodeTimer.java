package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.huawei.wallet.R;

public class VerifyCodeTimer extends Handler {
    private static final int HANDLER_TAG_COUNT_DOWN = 0;
    private static final int TOTAL_TIME_SEC = 120;
    private final TextView getVerifyCodeButton;
    private final Context mContext;
    private final TextView mVerifyTip;
    private int remainTime = TOTAL_TIME_SEC;

    public VerifyCodeTimer(Context context, TextView textView, TextView textView2) {
        this.mContext = context;
        this.getVerifyCodeButton = textView;
        this.mVerifyTip = textView2;
    }

    public void startTimer() {
        this.getVerifyCodeButton.setClickable(false);
        this.remainTime = TOTAL_TIME_SEC;
        countDown();
    }

    public void stopTimer() {
        this.mVerifyTip.setText(R.string.nfc_verify_phone_tip);
        this.getVerifyCodeButton.setText(R.string.nfc_get_verify_code);
        this.getVerifyCodeButton.setTextColor(this.mContext.getResources().getColor(R.color.button_text_color));
        this.getVerifyCodeButton.setClickable(true);
        removeMessages(0);
    }

    private void countDown() {
        this.getVerifyCodeButton.setText(this.mContext.getString(R.string.nfc_count_down_seconds, new Object[]{Integer.valueOf(this.remainTime)}));
        this.getVerifyCodeButton.setTextColor(this.mContext.getResources().getColor(R.color.button_text_color));
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
