package com.huawei.hwcommonmodel.application;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.huawei.feedback.logic.CrashHandler;
import com.huawei.p190v.C2538c;

public class BaseApplication extends Application {
    private static final String f1200b = BaseApplication.class.getSimpleName();
    private static Context f1201c;
    private static C0975b f1202d = C0975b.WEAR;
    private static int f1203e;
    ActivityLifecycleCallbacks f1204a = new C0974a(this);

    static /* synthetic */ int m2634d() {
        int i = f1203e;
        f1203e = i + 1;
        return i;
    }

    static /* synthetic */ int m2635e() {
        int i = f1203e;
        f1203e = i - 1;
        return i;
    }

    public void onCreate() {
        super.onCreate();
        m2631a(getApplicationContext());
        new CrashHandler().init(getApplicationContext());
        C2538c.m12659a((Context) this, getPackageName());
        C2538c.m12677c(f1200b, "BaseApplication onCreate.");
        registerActivityLifecycleCallbacks(this.f1204a);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public static Context m2632b() {
        return f1201c;
    }

    public static void m2631a(Context context) {
        if (context != null) {
            f1201c = context;
        }
    }

    public static C0975b m2633c() {
        if (f1201c == null) {
            C2538c.m12680e(f1200b, "Context is null for getAppType = ", f1202d);
            return f1202d;
        }
        if (C0975b.WEAR.m3521a().equals(f1201c.getPackageName())) {
            f1202d = C0975b.WEAR;
        } else {
            f1202d = C0975b.HEALTH;
        }
        C2538c.m12677c(f1200b, "getAppType = ", f1202d);
        C2538c.m12677c(f1200b, "getAppType.getName() = ", f1202d.m3521a());
        return f1202d;
    }
}
