package com.huawei.sim.esim.view;

import com.huawei.sim.esim.p504a.C5899a;
import com.huawei.p190v.C2538c;

/* compiled from: EsimActivationActivity */
class C5935l implements Runnable {
    final /* synthetic */ C5934k f20448a;

    C5935l(C5934k c5934k) {
        this.f20448a = c5934k;
    }

    public void run() {
        C2538c.b("EsimActivationActivity", new Object[]{"bt reconnect"});
        C5899a.m27106a(this.f20448a.f20447a);
    }
}
