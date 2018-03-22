package com.huawei.pluginkidwatch.plugin.feature.antiloss.service;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;

/* compiled from: KidWatchServiceInteractor */
class C1801f implements C1620b {
    final /* synthetic */ C1799d f4963a;

    C1801f(C1799d c1799d) {
        this.f4963a = c1799d;
    }

    public void mo2555a(Object obj) {
        C2538c.m12674b("KidWatchService", "onRangeOutTimeoutProcess runnableRangeOutTimeout setDeviceLinkLoss sucess!!!!");
        this.f4963a.f4957a.m8301h();
        this.f4963a.m8595h();
    }

    public void mo2554a(int i, String str) {
        C2538c.m12674b("KidWatchService", "onRangeOutTimeoutProcess runnableRangeOutTimeout setDeviceLinkLoss onFailure!!!!");
        this.f4963a.f4957a.m8301h();
        this.f4963a.m8595h();
    }
}
