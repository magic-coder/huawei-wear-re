package com.huawei.sim.esim.view;

import com.huawei.sim.esim.p504a.C5899a;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileBTFailActivity */
class ag implements Runnable {
    final /* synthetic */ af f20428a;

    ag(af afVar) {
        this.f20428a = afVar;
    }

    public void run() {
        C2538c.b("EsimProfileBTFailActivity", new Object[]{"bt reconnect"});
        C5899a.m27106a(this.f20428a.f20427a);
    }
}
