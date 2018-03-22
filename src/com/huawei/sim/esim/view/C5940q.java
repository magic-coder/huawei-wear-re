package com.huawei.sim.esim.view;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EsimConformBTFailActivity */
class C5940q implements IBaseResponseCallback {
    final /* synthetic */ EsimConformBTFailActivity f20453a;

    C5940q(EsimConformBTFailActivity esimConformBTFailActivity) {
        this.f20453a = esimConformBTFailActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("ConformReportActivity", new Object[]{"err_code " + i});
        this.f20453a.f20341u.post(new C5941r(this, i, obj));
    }
}
