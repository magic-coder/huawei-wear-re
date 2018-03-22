package com.huawei.p085j;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.j.a;
import com.huawei.p190v.C2538c;

/* compiled from: HWWearableManager */
class C5404b implements IBaseResponseCallback {
    final /* synthetic */ a f19220a;

    C5404b(a aVar) {
        this.f19220a = aVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWWearableManager", new Object[]{"Wearable manager receive data = " + C0973a.a((byte[]) obj)});
        a.a(this.f19220a, r7);
    }
}
