package com.huawei.pluginkidwatch.common.ui.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;

public abstract class KidWatchBaseActivity extends Activity {
    private static Context f3521b = null;
    private static c f3522c = null;
    protected boolean f3523a = true;
    private BroadcastReceiver f3524d = new C1511a(this);

    protected abstract void mo2517a();

    public static void m6985a(Context context) {
        f3521b = context;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (f3522c == null) {
            f3522c = c.a();
        }
        m6985a(getApplicationContext());
        mo2518d();
        mo2517a();
    }

    protected void onStart() {
        super.onStart();
        C2538c.m12674b("KidWatchBaseActivity", "onStart()");
    }

    protected void onStop() {
        super.onStop();
        C2538c.m12674b("KidWatchBaseActivity", "onStop()");
        this.f3523a = m6990b();
    }

    protected void onPause() {
        super.onPause();
        if (f3522c != null) {
            f3522c.c(this);
        }
    }

    protected void onResume() {
        super.onResume();
        if (f3522c != null) {
            f3522c.b(this);
        }
    }

    private void mo2518d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("golbal_finish_all_kidwatch_activity");
        intentFilter.addAction("com.huawei.plugin.account.logout");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this);
        if (instance != null && this.f3524d != null) {
            instance.registerReceiver(this.f3524d, intentFilter);
        }
    }

    private void mo2519e() {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this);
        if (instance != null && this.f3524d != null) {
            instance.unregisterReceiver(this.f3524d);
        }
    }

    public void onBackClick(View view) {
        onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12674b("KidWatchBaseActivity", "============= KidWatchBaseActivity onDestroy ");
        mo2519e();
        if (f3522c != null) {
            f3522c.a(this);
        }
    }

    public boolean m6990b() {
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(getApplicationInfo().processName)) {
                return true;
            }
        }
        return false;
    }
}
