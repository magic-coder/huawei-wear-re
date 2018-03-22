package com.huawei.feedback.ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.phoneserviceuni.common.d.a;
import com.huawei.phoneserviceuni.common.d.f;

public class BaseActivity extends Activity {
    private boolean f16430a = true;

    protected void onCreate(Bundle bundle) {
        super.setTheme(f.e(this));
        if (a.h()) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        f.a(this, findViewById(16908290), m21281a());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f.a(this, findViewById(16908290), m21281a());
    }

    public boolean m21281a() {
        return this.f16430a;
    }

    public void m21280a(boolean z) {
        this.f16430a = z;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
