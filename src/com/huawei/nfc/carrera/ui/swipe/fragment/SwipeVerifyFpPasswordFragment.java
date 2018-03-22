package com.huawei.nfc.carrera.ui.swipe.fragment;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.view.View;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.ui.verifypassword.fragment.VerifyFpPasswordFragment;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFingerPrintResultListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import java.util.HashMap;
import java.util.Map;

public class SwipeVerifyFpPasswordFragment extends VerifyFpPasswordFragment {
    private Context mContext;
    Handler mHandler = new C56671();

    class C56671 extends Handler {
        C56671() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                if (-4 == message.arg1) {
                    SwipeVerifyFpPasswordFragment.this.verifyTipView.setText(SwipeVerifyFpPasswordFragment.this.mContext.getString(R.string.nfc_swipe_fingerprint_system_disabled));
                } else if (-3 == message.arg1) {
                    SwipeVerifyFpPasswordFragment.this.showToast(R.string.nfc_swipe_fingerprint_connect_failed);
                } else if (-1 == message.arg1) {
                    SwipeVerifyFpPasswordFragment.this.verifyTipView.setText(SwipeVerifyFpPasswordFragment.this.mContext.getString(R.string.nfc_swipe_fingerprint_no_fp_psw));
                } else if (1 == message.arg1) {
                    SwipeVerifyFpPasswordFragment.this.verifyTipView.setText(SwipeVerifyFpPasswordFragment.this.mContext.getString(R.string.nfc_swipe_verify_fingerprint_tip));
                }
                SwipeVerifyFpPasswordFragment.this.verifyTipView.setVisibility(0);
            }
        }
    }

    public SwipeVerifyFpPasswordFragment(boolean z, VerifyFingerPrintResultListener verifyFingerPrintResultListener, Context context) {
        super(z, verifyFingerPrintResultListener);
        this.mContext = context;
    }

    protected boolean isFingerprintUseful() {
        boolean isScreenOn = ((PowerManager) this.mContext.getApplicationContext().getSystemService("power")).isScreenOn();
        LogX.d("SwipeVerifyFpPasswordFragment visibleStateChanged, foreground: " + this.isCurFragmentForeground + " ,hasFocus: " + this.isCurActivtyHasFocus + " ,isScreenOn: " + isScreenOn);
        return this.isCurFragmentForeground && this.isCurActivtyHasFocus && isScreenOn;
    }

    public void onResume() {
        super.onResume();
        LogX.i("SwipeVerifyFpPasswordFragment, onResume.");
        LogX.i("SwipeVerifyFpPasswordFragment, isHidden:" + isHidden());
        if (!isHidden()) {
            this.isCurFragmentForeground = true;
            visibleStateChanged();
        }
    }

    public void onPause() {
        super.onPause();
        LogX.i("SwipeVerifyFpPasswordFragment,onPause.");
        if (!isHidden()) {
            this.isCurFragmentForeground = false;
            visibleStateChanged();
        }
    }

    protected boolean checkFingerPrint() {
        boolean z = false;
        int checkValidFpPassword = this.fpVerifier.checkValidFpPassword();
        Message obtainMessage = this.mHandler.obtainMessage(1);
        if (-4 == checkValidFpPassword) {
            obtainMessage.arg1 = -4;
        } else if (-3 == checkValidFpPassword) {
            obtainMessage.arg1 = -3;
        } else if (-1 == checkValidFpPassword || -2 == checkValidFpPassword) {
            obtainMessage.arg1 = -1;
        } else if (1 == checkValidFpPassword) {
            obtainMessage.arg1 = 1;
            z = true;
        } else {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "NullifyVerifyFpPasswordFragment check fp psw error.");
            dealError(hashMap);
        }
        obtainMessage.sendToTarget();
        return z;
    }

    protected void initAnimation(View view) {
        super.initAnimation(view);
        this.verifyWaitView.setImageResource(R.drawable.nfc_swipe_fingerprint_anim_emui11);
        this.verifyingAnimView.setImageResource(R.anim.nfc_swipe_fingerprint_anim_emui);
        this.animationDrawable = (AnimationDrawable) this.verifyingAnimView.getDrawable();
    }

    private void dealError(Map<String, String> map) {
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_SCANPAY_JUMP_ALIPAY_FAIL, map, (String) map.get(ShowBindBusResultActivity.FAIL_REASON_KEY), false, false);
    }
}
