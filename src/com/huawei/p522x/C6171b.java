package com.huawei.p522x;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: HWOneLevelMenuManager */
class C6171b implements IBaseResponseCallback {
    final /* synthetic */ C6170a f21632a;

    C6171b(C6170a c6170a) {
        this.f21632a = c6170a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWOneLevelMenuManager", new Object[]{"OneLevelMenu manager receive data = " + C0973a.a((byte[]) obj)});
        this.f21632a.m28555a(r7);
    }
}
