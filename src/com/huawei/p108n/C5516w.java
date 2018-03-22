package com.huawei.p108n;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5516w implements IBaseResponseCallback {
    final /* synthetic */ c f19424a;

    C5516w(c cVar) {
        this.f19424a = cVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWDeviceConfigManager", new Object[]{"autoSendCommend response: " + obj});
    }
}
