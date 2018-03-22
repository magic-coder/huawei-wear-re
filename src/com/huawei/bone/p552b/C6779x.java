package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6779x implements IBaseResponseCallback {
    final /* synthetic */ C6778w f23207a;

    C6779x(C6778w c6778w) {
        this.f23207a = c6778w;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 10"});
        this.f23207a.f23206c.m30102p();
    }
}
