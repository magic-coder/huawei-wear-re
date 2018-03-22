package com.huawei.pay.ui.baseactivity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.ag.d;
import com.huawei.ag.e;
import com.huawei.ag.f;
import com.huawei.cp3.widget.a.a.b;
import com.huawei.pay.d.a.a;
import com.huawei.pay.p130e.p131c.C1368a;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.wallet.logic.bi.AppStartHianalytics;

public class BaseActivity extends com.huawei.ui.commonui.base.BaseActivity {
    private static final int DISPLAY_HW_NO_SPLIT_LINE = 32768;
    private static final int EMUI4_DEFAULT_COLOR = -986896;
    public static final int HANDLER_PAY_VERIFY_ERROR = 6;
    public static final int HANDLER_PAY_VERIFY_SUCCESS = 5;
    private static final int HANDLER_QUERY_BALANCE_FAIL = 4;
    private static final int HANDLER_QUERY_BALANCE_SUCCESS = 3;
    private static final int HANDLER_WALLET_NEWAUTH_ERROR = 2;
    private static final int HANDLER_WALLET_NEWAUTH_SUCCESS = 1;
    private boolean hasLeftHomeView = false;
    protected boolean isReportUseTimeByBI = true;
    protected ActionBar mActionBar;
    public Context mContext;
    protected LinearLayout parentBodyLinearLayout;
    protected b progressDialog;
    private int statusBarTransparentFlag = -1;
    private CustomTitleBar titleBar;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        a.a().a(this);
        this.mContext = getApplicationContext();
        initVerHorSwitch();
        initParentView();
    }

    protected void onResume() {
        super.onResume();
        if (this.isReportUseTimeByBI) {
            AppStartHianalytics.a(this);
        } else {
            C1368a.m6087a("StartLifeServiceBaseActivity: need not report BI", false);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.isReportUseTimeByBI) {
            AppStartHianalytics.a();
        } else {
            C1368a.m6087a("StartLifeServiceBaseActivity: need not report BI", false);
        }
    }

    protected void onDestroy() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
        super.onDestroy();
    }

    private void initParentView() {
        super.setContentView(f.huaweipay_base_main_layout);
        this.titleBar = (CustomTitleBar) findViewById(e.third_party_title_bar);
        this.parentBodyLinearLayout = (LinearLayout) findViewById(e.base_main_body_linearlayout);
    }

    public final void setContentView(int i) {
        if (this.parentBodyLinearLayout != null) {
            this.parentBodyLinearLayout.removeAllViews();
            LayoutInflater.from(this).inflate(i, this.parentBodyLinearLayout);
            this.parentBodyLinearLayout.setVisibility(0);
            return;
        }
        super.setContentView(i);
    }

    public final void setContentView(View view) {
        if (this.parentBodyLinearLayout != null) {
            this.parentBodyLinearLayout.removeAllViews();
            this.parentBodyLinearLayout.addView(view);
            this.parentBodyLinearLayout.setVisibility(0);
            return;
        }
        super.setContentView(view);
    }

    protected final void showHead(int i) {
        showHead(getString(i));
    }

    protected final void showHead(CharSequence charSequence) {
        this.titleBar.setTitleText(charSequence.toString());
    }

    public void setTitle(int i) {
        setTitle(getString(i));
    }

    public void setTitle(String str) {
        this.titleBar.setTitleText(str);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            onHomeRetrunArrowClick();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onHomeRetrunArrowClick() {
        finish();
    }

    public void showToast(int i) {
        ToastManager.show(this, i);
    }

    public void showToast(String str) {
        ToastManager.show(this, str);
    }

    public void showDialogFragment(DialogFragment dialogFragment, String str) {
        try {
            if (!isFinishing()) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
                beginTransaction.add((Fragment) dialogFragment, str);
                beginTransaction.commitAllowingStateLoss();
            }
        } catch (IllegalStateException e) {
            C1368a.m6089b("IllegalStateException", false);
            onError();
        }
    }

    public void showDialogFragment(DialogFragment dialogFragment) {
        showDialogFragment(dialogFragment, "alertdialog");
    }

    protected void onAlertDialogPositiveClick(int i) {
    }

    protected void onAlertDialogNegativeClick(int i) {
    }

    protected void onAlertDialogKeyBack(int i) {
    }

    protected void onError() {
    }

    protected void onPayPassVerifySuccess(String str, boolean z) {
        C1368a.m6089b("pay password verify success.", false);
    }

    @TargetApi(23)
    public final void changeActionBarUpIcon2White() {
        if (VERSION.SDK_INT >= 23) {
            ImageView imageView = (ImageView) findViewById(Resources.getSystem().getIdentifier("up", "id", "android"));
            if (imageView != null) {
                imageView.setForeground(getResources().getDrawable(d.cp3_actionbar_home_icon_white));
                imageView.setImageDrawable(getResources().getDrawable(d.cp3_actionbar_home_icon_white));
            }
        }
    }

    private final void initVerHorSwitch() {
        if (getResources().getBoolean(com.huawei.ag.b.IsSupportOrientation)) {
            setRequestedOrientation(3);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public boolean isNeedInitVerHorSwitchByParent() {
        return true;
    }
}
