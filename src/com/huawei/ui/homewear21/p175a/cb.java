package com.huawei.ui.homewear21.p175a;

import com.huawei.hwdatamigrate.hihealth.f.a;
import com.huawei.hwdatamigrate.hihealth.f.o;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class cb implements Runnable {
    final /* synthetic */ C2217a f8104a;

    private cb(C2217a c2217a) {
        this.f8104a = c2217a;
    }

    public void run() {
        C2538c.m12674b("HomeFragment", "startMigrateWear20Data ");
        a a = o.a(this.f8104a.f7992A, null);
        if (a != null && !a.a()) {
            a.b();
        }
    }
}
