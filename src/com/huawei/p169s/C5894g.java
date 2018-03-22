package com.huawei.p169s;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwlocationmgr.p457b.C5315a;
import com.huawei.s.b;
import com.huawei.p190v.C2538c;

/* compiled from: HWGPSLocationManager */
class C5894g implements IBaseResponseCallback {
    final /* synthetic */ b f20188a;

    C5894g(b bVar) {
        this.f20188a = bVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("HWGPSLocationManager", new Object[]{"setGPSParameterCallback onResponse " + i});
        if (i != 100000) {
            C5315a.m25697a(b.c(this.f20188a)).m25700b(this.f20188a.d);
        }
    }
}
