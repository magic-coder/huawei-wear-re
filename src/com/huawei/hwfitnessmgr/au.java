package com.huawei.hwfitnessmgr;

import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwfitnessmgr.deviceadapter.C5017d;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class au implements Runnable {
    final /* synthetic */ q f18164a;

    private au(q qVar) {
        this.f18164a = qVar;
    }

    public void run() {
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"setDeviceHRZoneConf enter "});
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"setDeviceHRZoneConf isDatalogin:" + w.a(a.a(q.d(this.f18164a)).c())});
        if (w.a(a.a(q.d(this.f18164a)).c())) {
            DeviceCapability a = C0973a.a.a();
            if (a == null) {
                C2538c.e("HWFitnessMgr", new Object[]{"setDeviceHRZoneConf deviceCapability is null"});
            } else if (a.isSupportHRZone()) {
                C2538c.b("HWFitnessMgr", new Object[]{"setDeviceHRZoneConf hrZoneConf = ", this.f18164a.k()});
                C5017d.m24149a(r0);
            } else {
                C2538c.c("HWFitnessMgr", new Object[]{"setDeviceHRZoneConf is not support"});
            }
        }
    }
}
