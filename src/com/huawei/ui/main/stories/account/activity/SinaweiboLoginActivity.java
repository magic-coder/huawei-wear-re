package com.huawei.ui.main.stories.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.ui.main.stories.account.interactor.C2331j;
import com.huawei.ui.main.stories.account.interactor.C2364o;

public class SinaweiboLoginActivity extends Activity {
    private C2364o f8463a = null;
    private C2331j f8464b = new C2336a(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8463a = new C2364o(this, this.f8464b);
        this.f8463a.m11980a();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f8463a != null) {
            this.f8463a.m11981a(i, i2, intent);
        }
    }
}
