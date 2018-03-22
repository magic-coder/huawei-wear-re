package com.huawei.multisimservice;

import com.huawei.multisimservice.model.C1200d;
import com.huawei.p190v.C2538c;
import com.huawei.p192w.C2546c;

/* compiled from: MultiSimService */
class C1198k extends C1192e {
    final /* synthetic */ MultiSimService f2617a;

    C1198k(MultiSimService multiSimService) {
        this.f2617a = multiSimService;
    }

    public void mo2371a(C1200d c1200d) {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim registerCallback ");
        this.f2617a.f2607a = c1200d;
    }

    public void mo2373b(C1200d c1200d) {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim unRegisterCallback ");
        this.f2617a.f2607a = null;
        C2546c.m12702a().m12747b(c1200d);
    }

    public void mo2370a() {
        C2538c.m12677c("MultiSimService", "IOpenMultiSim.IAttachedDeviceMultiSim getAttachedDeviceMultiSimInfo ");
        this.f2617a.m5306a();
    }

    public void mo2372a(String str) {
        C2538c.m12677c("MultiSimService", "IOpenMultiSim.IAttachedDeviceMultiSim downloadESimProfile");
        C2538c.m12674b("MultiSimService", "activationCode=", str);
        C2538c.m12677c("MultiSimService", "downloadESimProfile with app:", this.f2617a.f2609c);
        C2546c a = C2546c.m12702a();
        if (a == null) {
            C2538c.m12680e("MultiSimService", "downloadESimProfile  get HWMultiSimMgr null");
            return;
        }
        a.m12751c(this.f2617a.f2609c);
        if (a.m12749b(this.f2617a.f2609c)) {
            a.m12737a(str);
        }
    }
}
