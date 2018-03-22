package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import java.util.List;

/* compiled from: PluginPayAdapterImpl */
class C4485f implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16657a;

    C4485f(C4481b c4481b) {
        this.f16657a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i != 0) {
            this.f16657a.f16646o = null;
        } else if (obj instanceof List) {
            this.f16657a.f16646o = (List) obj;
        }
        this.f16657a.m21484a("obtainCardList", C4481b.f16610A);
    }
}
