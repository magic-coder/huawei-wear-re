package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginPayAdapterImpl */
class C4487h implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16659a;

    C4487h(C4481b c4481b) {
        this.f16659a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16659a.f16651t = (String) obj;
        } else {
            this.f16659a.f16651t = null;
        }
        this.f16659a.m21484a("getWalletAbility", C4481b.f16615F);
    }
}
