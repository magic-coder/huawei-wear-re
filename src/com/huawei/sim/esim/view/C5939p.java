package com.huawei.sim.esim.view;

import com.huawei.sim.esim.p504a.C5899a;
import com.huawei.p190v.C2538c;

/* compiled from: EsimConformBTFailActivity */
class C5939p implements Runnable {
    final /* synthetic */ C5938o f20452a;

    C5939p(C5938o c5938o) {
        this.f20452a = c5938o;
    }

    public void run() {
        C2538c.b("ConformReportActivity", new Object[]{"bt reconnect"});
        C5899a.m27106a(this.f20452a.f20451a);
    }
}
