package com.huawei.p510u;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: HWLinkLossAlarmManager */
class C5979b implements IBaseResponseCallback {
    final /* synthetic */ C5978a f20582a;

    C5979b(C5978a c5978a) {
        this.f20582a = c5978a;
    }

    public void onResponse(int i, Object obj) {
        this.f20582a.m27404a((byte[]) obj);
    }
}
