package com.huawei.nfc.carrera.ui.verifypassword.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.nfc.carrera.logic.security.CheckFpPasswdCallback;
import com.huawei.nfc.carrera.logic.security.FpPasswordVerifier;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyChangeToPayPwdListener;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFingerPrintResultListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.wallet.R;

public abstract class VerifyFpPasswordFragment extends Fragment implements CheckFpPasswdCallback {
    public static final String BUNDLE_KEY_HAS_FOCUS = "has_focus";
    private static final int HANDLER_EVENT_ONLOGIN_ERRO = 202;
    private static final int HANDLER_EVENT_UPDATE_FINGER_TIMES = 203;
    private static final int HANDLER_EVENT_UPDATE_TIME_VIEW = 201;
    private static final int IMAGE_ALPHA = 76;
    private static final int IMAGE_ALPHA_NORMAL = 255;
    private static final int UPDATE_TIME_OUT = 1;
    private static final int VERIFY_ALLOW_MAX_TIMES = 4;
    protected AnimationDrawable animationDrawable;
    private Runnable checkFingerPrintRunnable;
    private int endIndex;
    protected FpPasswordVerifier fpVerifier;
    public boolean isCurActivtyHasFocus = false;
    protected boolean isCurFragmentForeground = false;
    private boolean isFpReleased = false;
    private Handler mHandler = new C56815();
    private int startIndex;
    private TextView usePasswordTextView;
    private VerifyChangeToPayPwdListener usePayPwdListener;
    private int verifyAllowTimes = 4;
    private VerifyFingerPrintResultListener verifyFpListener;
    protected TextView verifyTipView;
    protected ImageView verifyWaitView;
    protected ImageView verifyingAnimView;

    class C56771 implements OnClickListener {
        C56771() {
        }

        public void onClick(View view) {
            VerifyFpPasswordFragment.this.usePayPwdClick();
        }
    }

    class C56782 implements Runnable {
        C56782() {
        }

        public void run() {
            VerifyFpPasswordFragment.this.animationDrawable.stop();
            VerifyFpPasswordFragment.this.verifyWaitView.setVisibility(0);
            VerifyFpPasswordFragment.this.verifyingAnimView.setVisibility(8);
        }
    }

    class C56793 implements Runnable {
        C56793() {
        }

        public void run() {
            VerifyFpPasswordFragment.this.openFpVerifer();
        }
    }

    class C56804 extends Thread {
        C56804() {
        }

        public void run() {
            if (VerifyFpPasswordFragment.this.fpVerifier == null) {
                VerifyFpPasswordFragment.this.fpVerifier = new FpPasswordVerifier(VerifyFpPasswordFragment.this.getActivity());
            }
            if (VerifyFpPasswordFragment.this.checkFingerPrint()) {
                if (VerifyFpPasswordFragment.this.fpVerifier == null) {
                    VerifyFpPasswordFragment.this.fpVerifier = new FpPasswordVerifier(VerifyFpPasswordFragment.this.getActivity());
                }
                VerifyFpPasswordFragment.this.fpVerifier.startCheckFpPassword(VerifyFpPasswordFragment.this);
                LogX.i("fpVerifier is started");
            }
        }
    }

    class C56815 extends Handler {
        C56815() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (201 == message.what) {
                if (message.obj != null) {
                    int intValue = ((Integer) message.obj).intValue();
                    LogX.i("update freezen time is :" + intValue);
                    VerifyFpPasswordFragment.this.verifyTipView.setText(VerifyFpPasswordFragment.this.getString(R.string.nfc_swipe_fingerprint_freeze_text, new Object[]{Integer.valueOf(intValue)}));
                    VerifyFpPasswordFragment.this.usePasswordTextView.setVisibility(0);
                    VerifyFpPasswordFragment.this.verifyWaitView.setAlpha(76);
                    VerifyFpPasswordFragment.this.verifyTipView.setTextColor(VerifyFpPasswordFragment.this.getActivity().getResources().getColor(R.color.finger_tips_txt_color));
                    intValue--;
                    if (intValue >= 0) {
                        VerifyFpPasswordFragment.this.mHandler.sendMessageDelayed(VerifyFpPasswordFragment.this.mHandler.obtainMessage(201, Integer.valueOf(intValue)), 1000);
                        return;
                    }
                    VerifyFpPasswordFragment.this.fpVerifier.resetSpErrorNum(true);
                    VerifyFpPasswordFragment.this.verifyTipView.setText(R.string.nfc_swipe_verify_fingerprint_tip);
                    VerifyFpPasswordFragment.this.startUseFingerprint();
                    VerifyFpPasswordFragment.this.usePasswordTextView.setVisibility(8);
                    VerifyFpPasswordFragment.this.verifyWaitView.setAlpha(255);
                }
            } else if (202 == message.what) {
                ToastManager.show(VerifyFpPasswordFragment.this.getActivity(), VerifyFpPasswordFragment.this.getActivity().getResources().getString(R.string.nfc_scanpay_no_login));
            } else if (203 == message.what) {
                VerifyFpPasswordFragment.this.refreshVerifyPromptText();
            }
        }
    }

    protected abstract boolean checkFingerPrint();

    protected abstract boolean isFingerprintUseful();

    public VerifyFpPasswordFragment(boolean z, VerifyFingerPrintResultListener verifyFingerPrintResultListener) {
        this.isCurActivtyHasFocus = z;
        this.verifyFpListener = verifyFingerPrintResultListener;
        this.verifyTipView = null;
        this.verifyWaitView = null;
        this.verifyingAnimView = null;
        this.usePasswordTextView = null;
        this.animationDrawable = null;
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        LogX.i("VerifyFpPasswordFragment is hidden:  " + isHidden());
        if (!isHidden()) {
            LogX.i("VerifyFpPasswordFragment is isFpReleased:  " + this.isFpReleased);
            if (this.isFpReleased) {
                initToOrginal();
                openFpVerifer();
                this.isFpReleased = false;
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z && !this.isFpReleased) {
            stopUseFingerprint();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogX.i("VerifyFpPasswordFragment, onCreate.");
    }

    @SuppressLint({"ResourceAsColor"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogX.i("VerifyFpPasswordFragment, onCreateView.");
        View inflate = layoutInflater.inflate(R.layout.nfc_swipe_fragment_waiting_fingerprint, viewGroup, false);
        this.verifyWaitView = (ImageView) inflate.findViewById(R.id.verify_wait_view);
        this.verifyTipView = (TextView) inflate.findViewById(R.id.text_description_view);
        this.verifyingAnimView = (ImageView) inflate.findViewById(R.id.verifying_anim_view);
        initAnimation(inflate);
        this.usePasswordTextView = (TextView) inflate.findViewById(R.id.text_userpassword);
        this.usePasswordTextView.setOnClickListener(new C56771());
        if (getActivity().getString(R.string.nfc_swipe_title).equals((String) getActivity().getTitle())) {
            this.verifyTipView.setTextColor(-1);
        } else {
            initOldFPView();
        }
        return inflate;
    }

    private void usePayPwdClick() {
    }

    protected void initAnimation(View view) {
        this.animationDrawable = (AnimationDrawable) this.verifyingAnimView.getDrawable();
    }

    public void setUsePasswordListener(VerifyChangeToPayPwdListener verifyChangeToPayPwdListener) {
        this.usePayPwdListener = verifyChangeToPayPwdListener;
    }

    private void initToOrginal() {
        this.verifyWaitView.setImageResource(R.drawable.nfc_swipe_fingerprint_anim_emui11);
        this.verifyWaitView.setVisibility(0);
        this.verifyingAnimView.setVisibility(8);
        this.verifyTipView.setVisibility(8);
        this.verifyAllowTimes = 4;
        this.usePasswordTextView.setVisibility(8);
    }

    private void startIdentifyingAnimation() {
        int i = (this.verifyWaitView == null || this.verifyingAnimView == null || this.animationDrawable == null) ? 1 : 0;
        if (i != 0) {
            LogX.e("startIdentifyingAnimation, but the view to show is illegal.");
            return;
        }
        this.verifyWaitView.setVisibility(8);
        this.verifyingAnimView.setVisibility(0);
        this.animationDrawable.start();
        this.mHandler.postDelayed(new C56782(), (long) ((this.animationDrawable.getDuration(0) * this.animationDrawable.getNumberOfFrames()) + 100));
    }

    private void refreshVerifyPromptText() {
        if (this.verifyTipView == null) {
            LogX.e("refreshVerifyPromptText, but verify tip view is illegal.");
            return;
        }
        Object string = getString(R.string.nfc_swipe_verifying_text, new Object[]{Integer.valueOf(this.verifyAllowTimes)});
        CharSequence spannableString = new SpannableString(string);
        setColorChangeIndex(string);
        spannableString.setSpan(new ForegroundColorSpan(getActivity().getResources().getColor(R.color.pwd_error_tip_color)), this.startIndex, this.endIndex, 33);
        this.verifyTipView.setText(spannableString);
        this.usePasswordTextView.setVisibility(0);
    }

    public void onStart() {
        super.onStart();
        LogX.i("VerifyFpPasswordFragment, onStart.");
    }

    public void onStop() {
        super.onStop();
        LogX.i("VerifyFpPasswordFragment, onStop.");
    }

    public void onDestroy() {
        super.onDestroy();
        LogX.i("VerifyFpPasswordFragment, onDestroy.");
    }

    public void onDetach() {
        super.onDetach();
        LogX.i("VerifyFpPasswordFragment, onDetach.");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LogX.i("VerifyFpPasswordFragment, onAttach.");
    }

    public void onDestroyView() {
        super.onDestroyView();
        LogX.i("VerifyFpPasswordFragment, onDestroyView.");
        this.mHandler.removeMessages(201);
    }

    public void onWindowFocusChanged(boolean z) {
        LogX.d("VerifyFpPasswordFragment, onWindowFocusChanged, from: " + this.isCurActivtyHasFocus + " to: " + z);
        this.isCurActivtyHasFocus = z;
        visibleStateChanged();
    }

    protected void visibleStateChanged() {
        if (isFingerprintUseful()) {
            startUseFingerprint();
        } else {
            stopUseFingerprint();
        }
    }

    public void startUseFingerprint() {
        if (this.checkFingerPrintRunnable == null) {
            this.checkFingerPrintRunnable = new C56793();
        }
        LogX.i("openFpVerifer action ");
        this.isFpReleased = false;
        this.mHandler.postDelayed(this.checkFingerPrintRunnable, 300);
    }

    private void openFpVerifer() {
        LogX.i("check isSupportNFCSwipe");
        if (NfcUtil.isSupportNFCSwipe(getActivity())) {
            new C56804().start();
            return;
        }
        LogX.i("don't support nfc swipe, don't need to open fpVerifier");
        this.isFpReleased = true;
    }

    private void stopUseFingerprint() {
        if (this.checkFingerPrintRunnable != null) {
            this.mHandler.removeCallbacks(this.checkFingerPrintRunnable);
        }
        if (this.fpVerifier != null) {
            LogX.d("release fp verifier now.");
            this.fpVerifier.release();
            this.fpVerifier = null;
        }
        this.isFpReleased = true;
        LogX.i("fpVerifier is stoped");
    }

    protected void showToast(int i) {
        ToastManager.show(getActivity(), i);
    }

    public void onChecking(int i) {
        LogX.d("onChecking(), and checking status: " + i);
        if (2 == i) {
            startIdentifyingAnimation();
        }
    }

    public void onCheckResult(int i) {
        LogX.d("onCheckResult, and check result: " + i);
        if (10 == i) {
            LogX.d("verify success, release fp verifier now.");
            if (this.verifyWaitView != null) {
                this.verifyWaitView.setImageResource(R.drawable.nfc_swipe_fingerprint_anim_emui01);
            }
            if (this.verifyFpListener != null) {
                this.verifyFpListener.verifyResult(true);
            }
            this.fpVerifier.release();
            this.fpVerifier = null;
            this.isFpReleased = true;
        } else if (14 == i) {
            updateFpFreezeTimeView();
        } else if (12 == i) {
            updateFpFailedNumView();
        }
    }

    private void updateFpFreezeTimeView() {
        if (this.fpVerifier != null) {
            int failedTime = (int) (this.fpVerifier.getFailedTime() / 1000);
            LogX.i("updateFpFreezeTimeView getFailedTime : " + failedTime, false);
            if (failedTime > 0) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(201, Integer.valueOf(failedTime + 1)));
            }
        }
    }

    private void updateFpFailedNumView() {
        if (this.fpVerifier != null) {
            int failedNum = this.fpVerifier.getFailedNum();
            if (failedNum >= 0) {
                LogX.d("updateFpFailedNumView getFailedNum : " + failedNum, false);
                this.verifyAllowTimes = failedNum;
            } else {
                this.verifyAllowTimes--;
            }
            if (this.verifyAllowTimes < 1) {
                LogX.d("verify failed, release fp verifier now.");
                if (this.verifyFpListener != null) {
                    this.verifyFpListener.verifyResult(false);
                }
                this.fpVerifier.release();
                this.fpVerifier = null;
                this.isFpReleased = true;
            }
            this.mHandler.sendEmptyMessage(203);
        }
    }

    private void initOldFPView() {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.verifyWaitView.setLayoutParams(layoutParams);
        this.verifyWaitView.setImageResource(R.drawable.nfc_swipe_fingerprint_default);
        this.verifyingAnimView.setLayoutParams(layoutParams);
        this.verifyingAnimView.setImageResource(R.anim.nfc_swipe_fingerprint_anim);
        this.animationDrawable = (AnimationDrawable) this.verifyingAnimView.getDrawable();
    }

    private void setColorChangeIndex(String str) {
        String language = getActivity().getResources().getConfiguration().locale.getLanguage();
        LogX.d("VerifyFpPasswordFragment setColorChangeIndex country: " + language);
        int length = str.length();
        if (language.equals(PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH)) {
            this.startIndex = length - 3;
            this.endIndex = length - 2;
            return;
        }
        this.startIndex = length - 2;
        this.endIndex = length;
    }
}
