package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginPayAdapterImpl */
class C4499t implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16672a;

    C4499t(C4481b c4481b) {
        this.f16672a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16672a.f16643l = true;
        } else {
            this.f16672a.f16643l = false;
        }
        this.f16672a.m21484a("addBusCard", C4481b.f16626w);
    }
}
