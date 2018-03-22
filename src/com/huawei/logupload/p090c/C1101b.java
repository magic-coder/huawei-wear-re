package com.huawei.logupload.p090c;

import android.app.Application;
import android.os.Handler;

/* compiled from: AppContext */
public final class C1101b {
    private static C1101b f2270a = new C1101b();
    private Application f2271b = null;
    private boolean f2272c = false;
    private Handler f2273d = null;

    private C1101b() {
    }

    public static C1101b m4858a() {
        return f2270a;
    }

    public void m4859a(Application application) {
        if (application != null) {
            this.f2271b = application;
        }
    }

    public Application m4860b() {
        return this.f2271b;
    }
}
