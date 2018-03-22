package com.huawei.uploadlog.p188c;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/* compiled from: AppContext */
public final class C2506b {
    private static C2506b f8982b = new C2506b();
    private Context f8983a;
    private Application f8984c = null;
    private boolean f8985d = false;
    private Handler f8986e = null;

    private C2506b() {
    }

    public static C2506b m12452a() {
        return f8982b;
    }

    public Context m12454b() {
        return this.f8983a;
    }

    public void m12453a(Application application) {
        if (application != null) {
            this.f8984c = application;
        }
    }

    public Application m12455c() {
        return this.f8984c;
    }
}
