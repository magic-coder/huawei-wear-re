package com.huawei.multisimservice;

import com.huawei.multisimservice.model.C1120a;
import com.huawei.multisimservice.model.SimInfo;
import com.huawei.p190v.C2538c;
import com.huawei.p192w.C2546c;
import java.util.List;

/* compiled from: MultiSimService */
class C1197j extends C1189b {
    final /* synthetic */ MultiSimService f2616a;

    C1197j(MultiSimService multiSimService) {
        this.f2616a = multiSimService;
    }

    public void mo2365a(C1120a c1120a) {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim registerCallback ");
        this.f2616a.f2608b = c1120a;
    }

    public void mo2368b(C1120a c1120a) {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim unRegisterCallback ");
        this.f2616a.f2608b = null;
        C2546c.m12702a().m12746b(c1120a);
    }

    public void mo2363a() {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim getAttachedDeviceMultiSimInfo ");
        this.f2616a.m5306a();
    }

    public void mo2366a(String str) {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim downloadESimProfile");
        C2538c.m12674b("MultiSimService", "activationCode=", str);
        C2538c.m12677c("MultiSimService", "downloadESimProfile with app:", this.f2616a.f2609c);
        C2546c a = C2546c.m12702a();
        if (a == null) {
            C2538c.m12680e("MultiSimService", "downloadESimProfile  get HWMultiSimMgr null");
            return;
        }
        a.m12751c(this.f2616a.f2609c);
        if (a.m12749b(this.f2616a.f2609c)) {
            a.m12737a(str);
        }
    }

    public void mo2364a(int i, String str) {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim multiSimStatusNotifyRequest ");
        C2538c.m12674b("MultiSimService", " multiSimStatus=", Integer.valueOf(i), " MSISDN=", str);
        C2546c.m12702a().m12732a(i, str);
    }

    public void mo2367a(List<SimInfo> list) {
        C2538c.m12677c("MultiSimService", "IAttachedDeviceMultiSim deleteESimProfile ");
        C2538c.m12674b("MultiSimService", "profileInfoList ", list);
        C2546c.m12702a().m12741a((List) list);
    }
}
