package com.huawei.bone.application;

import android.content.Context;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import com.huawei.hwappdfxmgr.p053b.C0952a;
import com.huawei.hwappdfxmgr.p054d.C0953a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C1025h;
import com.huawei.hwservicesmgr.p076a.C1045q;
import com.huawei.p111o.C1210c;
import com.huawei.p190v.C2538c;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class WearApplication extends BaseApplication {
    public void onCreate() {
        super.onCreate();
        C2538c.m12674b("WearApplication", " onCreate, BuildConfig.CRASH_LOG_UPLOAD = true, is huawei emui = " + C0977d.m3534a());
        C1210c.m5493b();
        if ("debug".equals("release") || "Test".equals("release")) {
            m2637a();
        }
        if ("release".equals("release") || "beta".equals("release")) {
            C2538c.m12674b("WearApplication", " Enter else s");
        } else {
            m2636f();
        }
        if (!C0977d.m3534a()) {
            C0952a.m3323a().m3329a((Context) this);
        }
        C0953a.m3330a();
        if (C1025h.m4003a() || !C0977d.m3554e()) {
            C2538c.m12674b("WearApplication", "start to bind PhoneService.");
            C1045q.m4405a(getApplicationContext());
            return;
        }
        C2538c.m12674b("WearApplication", "do not have device so do not need start PhoneService.");
    }

    private void m2636f() {
        StrictMode.setThreadPolicy(new Builder().detectAll().penaltyLog().build());
        StrictMode.setVmPolicy(new VmPolicy.Builder().detectAll().penaltyLog().build());
    }

    protected RefWatcher m2637a() {
        return LeakCanary.refWatcher(this).listenerServiceClass(LeakUploadService.class).buildAndInstall();
    }
}
