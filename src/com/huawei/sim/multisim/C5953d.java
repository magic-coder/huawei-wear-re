package com.huawei.sim.multisim;

import com.huawei.p190v.C2538c;
import com.huawei.sim.esim.p504a.C5899a;

/* compiled from: MultiSimConfigActivity */
class C5953d implements Runnable {
    final /* synthetic */ C5952c f20526a;

    C5953d(C5952c c5952c) {
        this.f20526a = c5952c;
    }

    public void run() {
        C2538c.b("MultiSimConfigActivity", new Object[]{"bt reconnect"});
        C5899a.m27106a(this.f20526a.f20525a);
    }
}
