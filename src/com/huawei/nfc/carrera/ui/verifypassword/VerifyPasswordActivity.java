package com.huawei.nfc.carrera.ui.verifypassword;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import com.huawei.nfc.carrera.ui.verifypassword.fragment.UsePayPasswordFragment;
import com.huawei.nfc.carrera.ui.verifypassword.fragment.VerifyFpPasswordFragment;
import com.huawei.nfc.carrera.ui.verifypassword.fragment.VerifyFpPwdFailedFragment;
import com.huawei.nfc.carrera.ui.verifypassword.listener.UserPayPasswordListener;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyChangeToPayPwdListener;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFingerPrintResultListener;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFinggerPrintReSwipeListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.ui.baseactivity.BaseActivity;
import com.huawei.wallet.R;
import java.util.List;

public abstract class VerifyPasswordActivity extends BaseActivity implements UserPayPasswordListener, VerifyChangeToPayPwdListener, VerifyFingerPrintResultListener, VerifyFinggerPrintReSwipeListener {
    private static final String FRAGMENT_TAG_VERIFY_FP = "verify_fingerprint_password";
    private static final String FRAGMENT_TAG_VERIFY_FP_FAILED = "verify_fp_failed";
    private static final String FRAGMENT_TAG_VERIFY_PASSWORD = "verify_password";
    private static final String TYPE_PID_DESKTOP = "com.huawei.wallet";
    private ViewGroup container;
    protected boolean hasFocusTag = false;
    private UsePayPasswordFragment usePayPasswordFragment;
    VerifyFpPasswordFragment verifyFpPswFragment;
    private VerifyFpPwdFailedFragment verifyFpPwdFailedFragment;

    protected abstract VerifyFpPasswordFragment getVerifyFpPasswordFragment(boolean z, VerifyFingerPrintResultListener verifyFingerPrintResultListener);

    protected abstract void toNextStep();

    public void setContainer(ViewGroup viewGroup) {
        this.container = viewGroup;
    }

    protected void initVerifyFpView() {
        if (this.verifyFpPswFragment == null) {
            this.verifyFpPswFragment = getVerifyFpPasswordFragment(this.hasFocusTag, this);
        }
        this.verifyFpPswFragment.setUsePasswordListener(this);
        addOrShowFragment(getSupportFragmentManager().getFragments(), this.verifyFpPswFragment, FRAGMENT_TAG_VERIFY_FP);
    }

    public void onWindowFocusChanged(boolean z) {
        LogX.m5465d("VerifyPasswordActivity onWindowFocusChanged hasFocus: " + z);
        this.hasFocusTag = z;
        if (this.verifyFpPswFragment != null) {
            this.verifyFpPswFragment.onWindowFocusChanged(this.hasFocusTag);
        }
    }

    @SuppressLint({"NewApi"})
    public void addOrShowFragment(List<Fragment> list, Fragment fragment, String str) {
        LogX.m5475i("addOrShowFragment  BEGIN");
        if (isFinishing() || isDestroyed()) {
            LogX.m5475i("VerifyPasswordActivity is destoryed , no need deal fragment");
            return;
        }
        hideFragments(list);
        FragmentTransaction beginTransaction;
        if (list != null && fragment.isAdded()) {
            beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            beginTransaction.show(fragment).commitAllowingStateLoss();
            LogX.m5475i("VerifyPasswordActivity show fragment id is:  " + fragment.getTag());
        } else if (this.container != null) {
            beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            beginTransaction.add(this.container.getId(), fragment, str).commitAllowingStateLoss();
            LogX.m5475i("VerifyPasswordActivity add fragment id is:  " + fragment.getTag());
        } else {
            LogX.m5475i("container is null");
        }
        LogX.m5475i("addOrShowFragment  END");
    }

    protected void hideFragments(List<Fragment> list) {
        if (list != null) {
            for (Fragment fragment : list) {
                if (fragment != null) {
                    FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    beginTransaction.hide(fragment).commitAllowingStateLoss();
                }
            }
        }
    }

    public void verifyResult(boolean z) {
        LogX.m5475i("verify success: " + z);
        if (z) {
            toNextStep();
        } else {
            showVerifyFpPwdFailedFragment();
        }
    }

    private void showVerifyFpPwdFailedFragment() {
        if (this.verifyFpPwdFailedFragment == null) {
            this.verifyFpPwdFailedFragment = new VerifyFpPwdFailedFragment(this, this);
        }
        addOrShowFragment(getSupportFragmentManager().getFragments(), this.verifyFpPwdFailedFragment, FRAGMENT_TAG_VERIFY_FP_FAILED);
    }

    public void usePayPassword() {
        LogX.m5465d("UsePayPasswordFragment .");
        this.usePayPasswordFragment = new UsePayPasswordFragment(this);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, this.usePayPasswordFragment, FRAGMENT_TAG_VERIFY_PASSWORD).commitAllowingStateLoss();
        pauseFragments();
    }

    public void getPayPassword(String str) {
    }

    private void pauseFragments() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.onPause();
                }
            }
        }
    }
}
