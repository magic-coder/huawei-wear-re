package com.huawei.multisimsdk.multidevicemanager.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import com.huawei.multisimsdk.multidevicemanager.f;
import com.huawei.multisimsdk.multidevicemanager.g;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1179d;

public class BaseActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(f.multi_sim);
        }
        if (C1179d.f2590a.equals(getApplication().getPackageName())) {
            setTheme(g.Dark);
        }
    }
}
