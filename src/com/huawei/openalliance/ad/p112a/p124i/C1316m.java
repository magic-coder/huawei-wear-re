package com.huawei.openalliance.ad.p112a.p124i;

import com.huawei.openalliance.ad.p112a.p124i.p126a.C1299f;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

class C1316m implements C1299f {
    final /* synthetic */ C1311h f2850a;
    final /* synthetic */ C1315l f2851b;

    C1316m(C1315l c1315l, C1311h c1311h) {
        this.f2851b = c1315l;
        this.f2850a = c1311h;
    }

    public void mo2448a() {
        this.f2850a.setVisibility(0);
    }

    public void mo2449a(int i) {
        C1336d.m5886b("SplashView", "show frame: ", String.valueOf(i));
    }

    public void mo2450b() {
        C1336d.m5886b("SplashView", "show finished");
        if (this.f2851b.f2846e != null) {
            this.f2851b.f2846e.mo2440d();
        }
    }
}
