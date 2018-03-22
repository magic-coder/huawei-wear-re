package com.huawei.hwversionmgr.utils.service;

import com.huawei.hwversionmgr.p079a.C1070g;
import com.huawei.hwversionmgr.utils.p083a.C1076c;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: UpdateService */
class C1085e extends C1076c {
    final /* synthetic */ UpdateService f2203a;

    C1085e(UpdateService updateService) {
        this.f2203a = updateService;
    }

    public void mo2347a() {
        C2538c.m12680e("UpdateService", "pullChangeLogFailed");
        if (this.f2203a.f2186k == 0) {
            this.f2203a.m4623a(6);
        }
        if (this.f2203a.f2186k == 2) {
            this.f2203a.m4624a(31, -1);
        }
    }

    public void mo2348a(List<C1070g> list) {
        C2538c.m12677c("UpdateService", "pullChangeLogSuccess");
        this.f2203a.f2188m = this.f2203a.f2186k;
        String str = "";
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str = ((str + ((C1070g) list.get(i)).m4503a()) + '\n') + ((C1070g) list.get(i)).m4505b();
                C2538c.m12677c("UpdateService", "pullChangeLogSuccess() i = " + i + ", Title = " + ((C1070g) list.get(i)).m4503a() + ", Content=" + ((C1070g) list.get(i)).m4505b());
            }
            if (this.f2203a.f2186k == 0) {
                C2538c.m12680e("UpdateService", "APP_AUTO_UPDATE()");
                this.f2203a.m4627a(5, this.f2203a.f2179d, this.f2203a.f2180e, str, this.f2203a.f2182g, 0);
            }
            if (this.f2203a.f2186k == 2) {
                C2538c.m12680e("UpdateService", "APP_MANUAL_UPDATE()");
                this.f2203a.m4625a(32, 0, str, this.f2203a.f2182g, 0);
            }
            C2538c.m12677c("UpdateService", "pullChangeLogSuccess() strFeatures = " + str);
            return;
        }
        C2538c.m12680e("UpdateService", "pullChangeLogSuccess() feature is null");
    }
}
