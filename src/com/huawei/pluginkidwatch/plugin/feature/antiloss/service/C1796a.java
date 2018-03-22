package com.huawei.pluginkidwatch.plugin.feature.antiloss.service;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;

/* compiled from: KidWatchService */
class C1796a implements C1647c {
    final /* synthetic */ KidWatchService f4954a;

    C1796a(KidWatchService kidWatchService) {
        this.f4954a = kidWatchService;
    }

    public void mo2560a(int i) {
        C2538c.m12674b("KidWatchService", "onDataReceived state = " + i);
        this.f4954a.m8571a(i);
    }
}
