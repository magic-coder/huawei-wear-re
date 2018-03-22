package com.huawei.hwversionmgr.utils.service;

import com.huawei.hwversionmgr.p079a.C1070g;
import com.huawei.hwversionmgr.utils.p083a.C1076c;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: UpdateService */
class C1086f extends C1076c {
    final /* synthetic */ UpdateService f2204a;

    C1086f(UpdateService updateService) {
        this.f2204a = updateService;
    }

    public void mo2347a() {
        C2538c.m12680e("UpdateService", "mBandPullChangeLogHandler pullChangeLogFailed");
        if (this.f2204a.f2187l == 1) {
            this.f2204a.m4623a(8);
        }
        if (this.f2204a.f2187l == 3) {
            this.f2204a.m4624a(31, -1);
        }
    }

    public void mo2348a(List<C1070g> list) {
        C2538c.m12677c("UpdateService", "mBandPullChangeLogHandler pullChangeLogSuccess");
        this.f2204a.f2188m = this.f2204a.f2187l;
        String str = "";
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str = ((str + ((C1070g) list.get(i)).m4503a()) + '\n') + ((C1070g) list.get(i)).m4505b();
                C2538c.m12677c("UpdateService", "mBandPullChangeLogHandler pullChangeLogSuccess() i = " + i + ", Title = " + ((C1070g) list.get(i)).m4503a() + ", Content=" + ((C1070g) list.get(i)).m4505b());
            }
            if (this.f2204a.f2187l == 1) {
                C2538c.m12680e("UpdateService", "BAND_AUTO_UPDATE()");
                this.f2204a.m4627a(7, this.f2204a.f2179d, this.f2204a.f2180e, str, this.f2204a.f2183h, this.f2204a.f2181f);
            }
            if (this.f2204a.f2187l == 3) {
                C2538c.m12680e("UpdateService", "BAND_MANUAL_UPDATE()");
                this.f2204a.m4625a(32, 0, str, this.f2204a.f2183h, this.f2204a.f2181f);
            }
            C2538c.m12677c("UpdateService", "mBandPullChangeLogHandler pullChangeLogSuccess() strFeatures = " + str);
            return;
        }
        C2538c.m12680e("UpdateService", "mBandPullChangeLogHandler pullChangeLogSuccess() feature is null");
    }
}
