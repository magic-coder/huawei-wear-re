package com.huawei.p390z;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: HWPayManager */
class C6185b implements IBaseResponseCallback {
    final /* synthetic */ C6184a f21702a;

    C6185b(C6184a c6184a) {
        this.f21702a = c6184a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWPayManager", new Object[]{"Pay manager receive data = " + C0973a.a((byte[]) obj)});
        this.f21702a.m28633a(r7);
    }
}
