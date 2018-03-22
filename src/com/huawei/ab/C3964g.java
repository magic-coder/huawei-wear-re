package com.huawei.ab;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.p190v.C2538c;

/* compiled from: HWUserInfoMgr */
class C3964g implements C3961b {
    final /* synthetic */ C3957a f15193a;
    final /* synthetic */ C3956a f15194b;

    C3964g(C3956a c3956a, C3957a c3957a) {
        this.f15194b = c3956a;
        this.f15193a = c3957a;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"setUserInfoToHiHealth onSuccess"});
        this.f15193a.mo4330a(null, null, true);
    }

    public void mo4332b(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"setUserInfoToHiHealth onFailure"});
        this.f15193a.mo4330a(null, null, true);
    }
}
