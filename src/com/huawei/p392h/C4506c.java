package com.huawei.p392h;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: HWAddressBookManager */
class C4506c implements IBaseResponseCallback {
    final /* synthetic */ C4504a f16689a;

    C4506c(C4504a c4504a) {
        this.f16689a = c4504a;
    }

    public void onResponse(int i, Object obj) {
        this.f16689a.m21573a((byte[]) obj);
    }
}
