package com.huawei.sim.esim.view;

import com.huawei.p190v.C2538c;
import com.huawei.sim.esim.p504a.C5899a;

/* compiled from: EsimProfileAcitvity */
class C5949z implements Runnable {
    final /* synthetic */ C5948y f20464a;

    C5949z(C5948y c5948y) {
        this.f20464a = c5948y;
    }

    public void run() {
        C2538c.b("EsimProfileAcitvity", new Object[]{"bt reconnect"});
        C5899a.m27106a(this.f20464a.f20463a);
    }
}
