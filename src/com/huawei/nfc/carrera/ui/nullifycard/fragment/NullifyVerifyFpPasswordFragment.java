package com.huawei.nfc.carrera.ui.nullifycard.fragment;

import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.ui.verifypassword.fragment.VerifyFpPasswordFragment;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFingerPrintResultListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;

public class NullifyVerifyFpPasswordFragment extends VerifyFpPasswordFragment {
    Handler mHandler = new C56641();

    class C56641 extends Handler {
        C56641() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                NullifyVerifyFpPasswordFragment.this.verifyTipView.setVisibility(0);
                if (-4 == message.arg1) {
                    NullifyVerifyFpPasswordFragment.this.verifyTipView.setText(NullifyVerifyFpPasswordFragment.this.getActivity().getString(R.string.nfc_swipe_fingerprint_system_disabled));
                } else if (-3 == message.arg1) {
                    NullifyVerifyFpPasswordFragment.this.showToast(R.string.nfc_swipe_fingerprint_connect_failed);
                } else if (-1 == message.arg1) {
                    NullifyVerifyFpPasswordFragment.this.verifyTipView.setText(NullifyVerifyFpPasswordFragment.this.getActivity().getString(R.string.nfc_swipe_fingerprint_no_fp_psw));
                } else if (1 == message.arg1) {
                    NullifyVerifyFpPasswordFragment.this.verifyTipView.setText(NullifyVerifyFpPasswordFragment.this.getActivity().getString(R.string.nfc_swipe_verify_fingerprint_tip));
                }
            }
        }
    }

    public NullifyVerifyFpPasswordFragment(boolean z, VerifyFingerPrintResultListener verifyFingerPrintResultListener) {
        super(z, verifyFingerPrintResultListener);
    }

    protected boolean isFingerprintUseful() {
        LogX.d("NullifyVerifyFpPasswordFragment visibleStateChanged, foreground: " + this.isCurFragmentForeground + " ,hasFocus: " + this.isCurActivtyHasFocus);
        return this.isCurFragmentForeground && this.isCurActivtyHasFocus;
    }

    public void onResume() {
        super.onResume();
        LogX.i("NullifyVerifyFpPasswordFragment, onResume.");
        this.isCurFragmentForeground = true;
        visibleStateChanged();
    }

    public void onPause() {
        super.onPause();
        LogX.i("NullifyVerifyFpPasswordFragment, onPause.");
        this.isCurFragmentForeground = false;
        visibleStateChanged();
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
            LogX.e("NullifyVerifyFpPasswordFragment check fp psw error.");
        }
        obtainMessage.sendToTarget();
        return z;
    }
}
