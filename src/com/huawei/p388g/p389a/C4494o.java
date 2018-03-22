package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PluginPayAdapterImpl */
class C4494o implements IBaseResponseCallback {
    final /* synthetic */ C4493n f16667a;

    C4494o(C4493n c4493n) {
        this.f16667a = c4493n;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"err_code:" + i + "  objData:" + obj});
        if (i == 0) {
            int intValue = ((Integer) obj).intValue();
            C2538c.b("PluginPayAdapterImpl", new Object[]{"Enter  batteryRunnable value:" + intValue});
        }
    }
}
