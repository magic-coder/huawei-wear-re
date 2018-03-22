package com.huawei.ui.commonui.base;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.application.C0975b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.r.a.b;
import com.huawei.ui.main.stories.account.interactor.WeChat;

public class BaseActivity extends AppCompatActivity {
    public static final String CLEAN_ACTIVITY = "com.huawei.commonui.CLEAN_ACTIVITY";
    private static final String TAG = BaseActivity.class.getSimpleName();
    private static c mBIAnalyticsUtil = null;
    private static b mGoogleAnalyticsUtil = null;
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver mBroadcast = new a(this);
    private IntentFilter mIntentFilter;

    public void setContentView(int i) {
        super.setContentView(i);
        setStatusBar();
    }

    protected void setStatusBar() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (mBIAnalyticsUtil == null) {
            mBIAnalyticsUtil = c.a();
        }
        if (mGoogleAnalyticsUtil == null && C0975b.WEAR == BaseApplication.m2633c()) {
            mGoogleAnalyticsUtil = b.b();
        }
        this.mIntentFilter = new IntentFilter();
        this.mIntentFilter.addAction(CLEAN_ACTIVITY);
        this.localBroadcastManager = LocalBroadcastManager.getInstance(this);
        if (this.localBroadcastManager != null) {
            this.localBroadcastManager.registerReceiver(this.mBroadcast, this.mIntentFilter);
        }
        loadApplicationTheme();
    }

    private void loadApplicationTheme() {
        if (getApplicationContext().getTheme() == null) {
            C2538c.m12680e(TAG, "loadApplicationTheme() if (theme == null)");
            return;
        }
        try {
            int identifier;
            if (BaseApplication.m2633c() == C0975b.HEALTH) {
                identifier = getResources().getIdentifier("HealthTheme", "style", WeChat.HEALTH_PACKAGE_NAME);
            } else {
                identifier = getResources().getIdentifier("WearTheme", "style", "com.huawei.bone");
            }
            if (identifier == 0) {
                C2538c.m12677c(TAG, "onCreate if (themeId == 0)");
                return;
            }
            C2538c.m12677c(TAG, "onCreate if (themeId == 0) ELSE themeId=" + identifier);
            setTheme(identifier);
        } catch (Exception e) {
            C2538c.m12680e(TAG, "catch (Exception e)" + e.getMessage());
        }
    }

    protected void onResume() {
        super.onResume();
        initSystemBar();
        if (mBIAnalyticsUtil != null) {
            mBIAnalyticsUtil.b(this);
        }
    }

    protected void onPause() {
        super.onPause();
        if (mBIAnalyticsUtil != null) {
            mBIAnalyticsUtil.c(this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.localBroadcastManager.unregisterReceiver(this.mBroadcast);
        if (mBIAnalyticsUtil != null) {
            mBIAnalyticsUtil.a(this);
        }
    }

    protected void onStart() {
        super.onStart();
        if (mGoogleAnalyticsUtil != null) {
            mGoogleAnalyticsUtil.c(this);
        }
    }

    protected void onStop() {
        super.onStop();
        if (mGoogleAnalyticsUtil != null) {
            mGoogleAnalyticsUtil.d(this);
        }
    }

    protected void initSystemBar() {
        if (BaseApplication.m2633c() == C0975b.WEAR && VERSION.SDK_INT >= 19) {
            if (VERSION.SDK_INT > 23) {
                getWindow().setNavigationBarColor(0);
                getWindow().setStatusBarColor(0);
            } else {
                getWindow().setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS, HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            }
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
        if (BaseApplication.m2633c() == C0975b.HEALTH && VERSION.SDK_INT >= 19) {
            if (VERSION.SDK_INT >= 21) {
                getWindow().setStatusBarColor(0);
            }
            if (VERSION.SDK_INT > 23) {
                getWindow().setNavigationBarColor(0);
            }
            getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }
}
