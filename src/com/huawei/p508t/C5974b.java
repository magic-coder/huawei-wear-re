package com.huawei.p508t;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: HWHealthDataManager */
class C5974b implements C3961b {
    final /* synthetic */ IBaseResponseCallback f20558a;
    final /* synthetic */ C5973a f20559b;

    C5974b(C5973a c5973a, IBaseResponseCallback iBaseResponseCallback) {
        this.f20559b = c5973a;
        this.f20558a = iBaseResponseCallback;
    }

    public void mo4331a(int i, Object obj) {
        this.f20558a.onResponse(0, null);
    }

    public void mo4332b(int i, Object obj) {
        this.f20558a.onResponse(100001, null);
    }
}
