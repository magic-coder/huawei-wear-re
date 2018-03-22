package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PluginPayAdapterImpl */
class C4497r implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16670a;

    C4497r(C4481b c4481b) {
        this.f16670a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"closeChannel SUCCESS"});
            return;
        }
        C2538c.b("PluginPayAdapterImpl", new Object[]{"closeChannel FAIL"});
    }
}
