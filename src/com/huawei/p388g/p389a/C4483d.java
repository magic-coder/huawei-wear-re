package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginPayAdapterImpl */
class C4483d implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16655a;

    C4483d(C4481b c4481b) {
        this.f16655a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16655a.f16640i = true;
        } else {
            this.f16655a.f16640i = false;
        }
        this.f16655a.m21484a("addCard2Watch", C4481b.f16628y);
    }
}
