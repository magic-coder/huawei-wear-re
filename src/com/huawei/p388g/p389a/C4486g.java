package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginPayAdapterImpl */
class C4486g implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16658a;

    C4486g(C4481b c4481b) {
        this.f16658a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16658a.f16642k = true;
        } else {
            this.f16658a.f16642k = false;
        }
        this.f16658a.m21484a("deleteCard", C4481b.f16614E);
    }
}