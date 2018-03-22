package com.huawei.nfc.carrera.ui.verifypassword.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyChangeToPayPwdListener;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFinggerPrintReSwipeListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.wallet.R;

public class VerifyFpPwdFailedFragment extends Fragment {
    private static final int HANDLER_EVENT_ONLOGIN_ERRO = 1;
    private static final int HANDLER_TAG_COUNT_DOWN = 0;
    private static final int IMAGE_ALPHA = 76;
    private static final int TOTAL_TIME_SEC = 30;
    private TextView decriptionView;
    private ImageView failedImageView;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new C56832();
    private int remainTime = 30;
    private VerifyFinggerPrintReSwipeListener reswipeListener;
    private VerifyChangeToPayPwdListener usePayPwdListener;
    private TextView usePayPwdTipView;

    class C56821 implements OnClickListener {
        C56821() {
        }

        public void onClick(View view) {
            VerifyFpPwdFailedFragment.this.usePayPwdClick();
        }
    }

    class C56832 extends Handler {
        C56832() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (1 == message.what) {
                ToastManager.show(VerifyFpPwdFailedFragment.this.getActivity(), VerifyFpPwdFailedFragment.this.getActivity().getResources().getString(R.string.nfc_scanpay_no_login));
                return;
            }
            VerifyFpPwdFailedFragment.this.remainTime = VerifyFpPwdFailedFragment.this.remainTime - 1;
            if (VerifyFpPwdFailedFragment.this.remainTime < 1) {
                VerifyFpPwdFailedFragment.this.stopTimer();
                VerifyFpPwdFailedFragment.this.initToOrginal();
                VerifyFpPwdFailedFragment.this.reswipeListener.reSwipeFingerPrint(true);
                return;
            }
            VerifyFpPwdFailedFragment.this.countDown();
        }
    }

    public VerifyFpPwdFailedFragment(VerifyChangeToPayPwdListener verifyChangeToPayPwdListener, VerifyFinggerPrintReSwipeListener verifyFinggerPrintReSwipeListener) {
        this.usePayPwdListener = verifyChangeToPayPwdListener;
        this.reswipeListener = verifyFinggerPrintReSwipeListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogX.i("VerifyFpPwdFailedFragment, onCreateView.");
        View inflate = layoutInflater.inflate(R.layout.nfc_swipe_fragment_verify_fp_failed, viewGroup, false);
        initViews(inflate);
        if (!getActivity().getString(R.string.nfc_swipe_title).equals((String) getActivity().getTitle())) {
            initOldFPView();
        }
        return inflate;
    }

    private void initViews(View view) {
        this.usePayPwdTipView = (TextView) view.findViewById(R.id.swipe_pay_input_pwd);
        this.decriptionView = (TextView) view.findViewById(R.id.text_description_view);
        this.decriptionView.setTextColor(getActivity().getResources().getColor(R.color.finger_tips_txt_color));
        this.decriptionView.setText(getActivity().getString(R.string.nfc_swipe_fingerprint_freeze_text, new Object[]{Integer.valueOf(this.remainTime)}));
        this.usePayPwdTipView.setOnClickListener(new C56821());
        this.failedImageView = (ImageView) view.findViewById(R.id.verify_wait_view);
        this.failedImageView.setAlpha(76);
        this.mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void usePayPwdClick() {
    }

    private void initOldFPView() {
        this.failedImageView.setLayoutParams(new LayoutParams(-2, -2));
        this.failedImageView.setImageResource(R.drawable.nfc_swipe_fingerprint_default);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!isHidden() && 30 == this.remainTime) {
            this.decriptionView.setText(getActivity().getString(R.string.nfc_swipe_fingerprint_freeze_text, new Object[]{Integer.valueOf(this.remainTime)}));
            this.mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    }

    private void initToOrginal() {
        this.remainTime = 30;
    }

    public void stopTimer() {
        this.mHandler.removeMessages(0);
    }

    private void countDown() {
        this.decriptionView.setText(getActivity().getString(R.string.nfc_swipe_fingerprint_freeze_text, new Object[]{Integer.valueOf(this.remainTime)}));
        this.mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    public void onDestroyView() {
        super.onDestroyView();
        stopTimer();
    }
}
