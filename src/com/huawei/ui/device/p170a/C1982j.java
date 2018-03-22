package com.huawei.ui.device.p170a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: CompatibilityInteractor */
class C1982j implements IBaseResponseCallback {
    final /* synthetic */ C1981i f6925a;

    C1982j(C1981i c1981i) {
        this.f6925a = c1981i;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("CompatibilityInteractor", "unbindDeviceList Enter callback err_code:" + i);
        this.f6925a.f6920b.removeMessages(101, this.f6925a.f6919a);
        if (Math.abs(System.currentTimeMillis() - this.f6925a.f6921c) > this.f6925a.f6922d) {
            C2538c.m12677c("CompatibilityInteractor", "getDeviceListFromWear outtime:" + Math.abs(System.currentTimeMillis() - this.f6925a.f6921c));
            return;
        }
        this.f6925a.f6919a.onResponse(i, obj);
    }
}
