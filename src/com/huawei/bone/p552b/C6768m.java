package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6768m implements IBaseResponseCallback {
    final /* synthetic */ C6767l f23192a;

    C6768m(C6767l c6767l) {
        this.f23192a = c6767l;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 7"});
        this.f23192a.f23191c.f23188b.m30102p();
    }
}
