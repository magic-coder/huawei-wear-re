package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwfitnessmgr.deviceadapter.C5017d;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class av implements Runnable {
    final /* synthetic */ q f18165a;
    private IBaseResponseCallback f18166b;
    private boolean f18167c;

    public av(q qVar, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        this.f18165a = qVar;
        this.f18166b = iBaseResponseCallback;
        this.f18167c = z;
    }

    public void run() {
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"setHeartZoneConfig enter " + this.f18165a.k()});
        C2538c.c("HWFitnessMgr", new Object[]{"setHeartZoneConfig isDatalogin:" + w.a(a.a(q.d(this.f18165a)).c())});
        if (w.a(a.a(q.d(this.f18165a)).c())) {
            DeviceCapability a = C0973a.a.a();
            if (a == null) {
                C2538c.e("HWFitnessMgr", new Object[]{"setHeartZoneConfig deviceCapability is null"});
            } else if (a.isSupportHRZone()) {
                if (this.f18167c) {
                    q.a(this.f18165a, 19, this.f18166b);
                } else {
                    this.f18166b.onResponse(0, null);
                }
                C5017d.m24149a(r0);
            } else {
                C2538c.c("HWFitnessMgr", new Object[]{"setHeartZoneConfig is not support"});
            }
        }
    }
}
