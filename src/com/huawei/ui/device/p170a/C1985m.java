package com.huawei.ui.device.p170a;

import com.huawei.datatype.HealthSupportModel;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: CompatibilityInteractor */
class C1985m implements Runnable {
    final /* synthetic */ IBaseResponseCallback f6931a;
    final /* synthetic */ C1975c f6932b;

    C1985m(C1975c c1975c, IBaseResponseCallback iBaseResponseCallback) {
        this.f6932b = c1975c;
        this.f6931a = iBaseResponseCallback;
    }

    public void run() {
        C2538c.m12677c("CompatibilityInteractor", "getCommonData timeout");
        this.f6931a.onResponse(0, new HealthSupportModel());
    }
}
