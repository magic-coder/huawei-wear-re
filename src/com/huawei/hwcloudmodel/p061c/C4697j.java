package com.huawei.hwcloudmodel.p061c;

import com.huawei.hwcloudmodel.callback.C3957a;

/* compiled from: HWCloudUtils */
class C4697j implements Runnable {
    final /* synthetic */ double f17133a;
    final /* synthetic */ double f17134b;
    final /* synthetic */ C3957a f17135c;
    final /* synthetic */ C4689d f17136d;

    C4697j(C4689d c4689d, double d, double d2, C3957a c3957a) {
        this.f17136d = c4689d;
        this.f17133a = d;
        this.f17134b = d2;
        this.f17135c = c3957a;
    }

    public void run() {
        C4688c a = this.f17136d.m22463a(this.f17133a, this.f17134b);
        if (a == null || a.m22445a() == -99 || a.m22451d() == -99 || a.m22449c() == -99) {
            this.f17135c.mo4330a(null, null, false);
        } else {
            this.f17135c.mo4330a(a, null, true);
        }
    }
}
