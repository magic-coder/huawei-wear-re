package com.huawei.sim.esim.view;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EsimConformBTFailActivity */
class C5942s implements IBaseResponseCallback {
    final /* synthetic */ EsimConformBTFailActivity f20457a;

    C5942s(EsimConformBTFailActivity esimConformBTFailActivity) {
        this.f20457a = esimConformBTFailActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("ConformReportActivity", new Object[]{"the error_code " + i});
    }
}
