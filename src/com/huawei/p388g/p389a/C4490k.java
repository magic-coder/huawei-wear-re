package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PluginPayAdapterImpl */
class C4490k implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16662a;

    C4490k(C4481b c4481b) {
        this.f16662a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        this.f16662a.f16645n = ((Integer) obj).intValue();
        C2538c.c("PluginPayAdapterImpl", new Object[]{"sendAccount = " + this.f16662a.f16645n});
        this.f16662a.m21484a("sendAccount", C4481b.f16619J);
    }
}
