package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PluginPayAdapterImpl */
class C4488i implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16660a;

    C4488i(C4481b c4481b) {
        this.f16660a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16660a.f16647p = ((Integer) obj).intValue();
            C2538c.c("PluginPayAdapterImpl", new Object[]{"mLockscreenStatus = " + this.f16660a.f16647p});
        } else {
            this.f16660a.f16647p = -1;
        }
        this.f16660a.m21484a("getLockscreenStatus", C4481b.f16616G);
    }
}
