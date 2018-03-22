package com.huawei.phoneserviceuni.common.p494c.p495a;

import android.app.Application;
import android.content.Context;

/* compiled from: AppContext */
public final class C5761a {
    private static C5761a f19541a = new C5761a();
    private Application f19542b = null;
    private Context f19543c = null;
    private boolean f19544d = false;

    private C5761a() {
    }

    public static C5761a m26451a() {
        return f19541a;
    }

    public Application m26453b() {
        return this.f19542b;
    }

    public void m26452a(Context context) {
        this.f19543c = context;
    }

    public Context m26454c() {
        return this.f19543c;
    }
}
