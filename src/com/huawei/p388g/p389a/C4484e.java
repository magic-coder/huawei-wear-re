package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginPayAdapterImpl */
class C4484e implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16656a;

    C4484e(C4481b c4481b) {
        this.f16656a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16656a.f16641j = true;
        } else {
            this.f16656a.f16641j = false;
        }
        this.f16656a.m21484a("updateCardInfo", C4481b.f16629z);
    }
}
