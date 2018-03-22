package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PluginPayAdapterImpl */
class C4498s implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16671a;

    C4498s(C4481b c4481b) {
        this.f16671a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16671a.f16649r = (String) obj;
            C2538c.c("PluginPayAdapterImpl", new Object[]{"btcInfoResponse = " + this.f16671a.f16649r});
        } else {
            this.f16671a.f16649r = null;
        }
        this.f16671a.m21484a("getBTCInfoResponse", C4481b.f16612C);
    }
}
