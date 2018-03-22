package com.huawei.hwversionmgr.utils.service;

import com.huawei.hwversionmgr.p079a.C1066a;
import com.huawei.hwversionmgr.utils.p083a.C1075b;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateService */
class C1087g extends C1075b {
    final /* synthetic */ UpdateService f2205a;

    C1087g(UpdateService updateService) {
        this.f2205a = updateService;
    }

    public void mo2350a(C1066a c1066a) {
    }

    public void mo2349a(int i) {
        C2538c.m12680e("UpdateService", "doDownloadFailed: statusCode = " + i);
        this.f2205a.m4623a(25);
    }

    public void mo2351b(C1066a c1066a) {
        C2538c.m12677c("UpdateService", "autoDownloadSuccess: band path: " + c1066a.f2096e);
        this.f2205a.f2189n.m4515b(r0);
        this.f2205a.f2189n.m4520e(this.f2205a.f2178c);
        this.f2205a.m4623a(26);
    }
}
