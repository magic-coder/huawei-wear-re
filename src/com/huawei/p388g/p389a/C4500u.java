package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginPayAdapterImpl */
class C4500u implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16673a;

    C4500u(C4481b c4481b) {
        this.f16673a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16673a.f16639h = true;
        } else {
            this.f16673a.f16639h = false;
        }
        this.f16673a.m21484a("notifyAfterTransferFile", C4481b.f16627x);
    }
}
