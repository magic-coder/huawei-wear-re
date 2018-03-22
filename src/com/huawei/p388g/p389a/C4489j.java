package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PluginPayAdapterImpl */
class C4489j implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16661a;

    C4489j(C4481b c4481b) {
        this.f16661a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16661a.f16644m = true;
            C2538c.c("PluginPayAdapterImpl", new Object[]{"mOpenPageResponse = " + this.f16661a.f16644m});
        } else {
            this.f16661a.f16644m = false;
        }
        this.f16661a.m21484a("notificationOpenPageOfBand", C4481b.f16617H);
    }
}
