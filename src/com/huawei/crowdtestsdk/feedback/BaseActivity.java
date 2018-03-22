package com.huawei.crowdtestsdk.feedback;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.feedback.ui.TitleBarLayout;
import com.huawei.crowdtestsdk.utils.ActivityManagerUtils;
import com.huawei.uploadlog.p188c.C2511g;

public abstract class BaseActivity extends FragmentActivity {
    protected TitleBarLayout mTitleBarLayout;

    protected abstract void initLayout();

    protected abstract void initView();

    protected abstract void setTitle();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2511g.m12481b("BETACLUB_SDK", "[BaseActivity.onCreate]onCreate called!");
        requestWindowFeature(1);
        SdkConstants.setStatusBarColor(this, null);
        ActivityManagerUtils.getInstance().addActivity(this);
        initLayout();
        initView();
        setTitle();
    }

    protected void onDestroy() {
        super.onDestroy();
        ActivityManagerUtils.getInstance().removeActivity(this);
        C2511g.m12481b("BETACLUB_SDK", "[BaseActivity.onDestroy]onDestroy called!");
    }

    public void hideInputMethod() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getApplicationWindowToken(), 0);
    }

    public void setTitleImageAndText(int i, String str) {
        if (this.mTitleBarLayout != null) {
            this.mTitleBarLayout.getTitleImage().setImageResource(i);
            this.mTitleBarLayout.getTitleText().setText(str);
        }
    }

    protected void initTitleBar(int i, int i2) {
        if (this.mTitleBarLayout != null) {
            this.mTitleBarLayout.setTitleImage(i);
            this.mTitleBarLayout.setTitleText(i2);
        }
    }
}
