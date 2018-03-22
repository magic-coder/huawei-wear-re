package com.huawei.p392h;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWAddressBookManager */
class C4508e implements IBaseResponseCallback {
    final /* synthetic */ C4504a f16691a;

    C4508e(C4504a c4504a) {
        this.f16691a = c4504a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWAddressBookManager", new Object[]{"autoSendCommend response: " + obj});
    }
}
