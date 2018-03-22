package com.huawei.p388g.p389a;

import com.huawei.p190v.C2538c;

/* compiled from: PluginPayAdapterImpl */
class C4493n implements Runnable {
    final /* synthetic */ C4481b f16666a;

    C4493n(C4481b c4481b) {
        this.f16666a = c4481b;
    }

    public void run() {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"Enter  batteryRunnable"});
        if (C4481b.f16623d != null) {
            C4481b.f16623d.b(new C4494o(this));
            return;
        }
        C2538c.b("PluginPayAdapterImpl", new Object[]{"batteryRunnable deviceManager is null"});
    }
}
