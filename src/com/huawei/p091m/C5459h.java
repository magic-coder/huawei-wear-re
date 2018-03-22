package com.huawei.p091m;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

/* compiled from: HwCoreSleepMgr */
class C5459h implements IDeviceDFXBaseResponseCallback {
    final /* synthetic */ IBaseResponseCallback f19305a;
    final /* synthetic */ d f19306b;

    C5459h(d dVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19306b = dVar;
        this.f19305a = iBaseResponseCallback;
    }

    public void onSuccess(int i, String str) {
        C2538c.c("HwCoreSleepMgr", new Object[]{"on Success() suc_code = ", Integer.valueOf(i), ",suc_msg = ", str});
        if (this.f19305a != null) {
            this.f19305a.onResponse(0, null);
        }
    }

    public void onFailure(int i, String str) {
        C2538c.c("HwCoreSleepMgr", new Object[]{"onFailure() err_code = ", Integer.valueOf(i), ",err_msg = ", str});
        d.a(this.f19306b);
        d.b(this.f19306b);
        d.a(this.f19306b, false);
        if (this.f19305a != null) {
            this.f19305a.onResponse(i, null);
        }
    }
}
