package com.huawei.hwappdfxmgr.p056f;

import android.app.Application;
import android.os.Handler;

/* compiled from: AppContext */
public final class C0955a {
    private static C0955a f1559a = new C0955a();
    private Application f1560b = null;
    private boolean f1561c = false;
    private Handler f1562d = null;

    private C0955a() {
    }

    public static C0955a m3339a() {
        return f1559a;
    }

    public void m3340a(Application application) {
        if (application != null) {
            this.f1560b = application;
        }
    }
}
