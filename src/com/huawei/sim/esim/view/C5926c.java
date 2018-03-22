package com.huawei.sim.esim.view;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: ConformActivity */
class C5926c implements IBaseResponseCallback {
    final /* synthetic */ ConformActivity f20437a;

    C5926c(ConformActivity conformActivity) {
        this.f20437a = conformActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("ConformActivity", new Object[]{"authBaseResponseCallback err_code " + i});
        this.f20437a.f20305o.post(new C5927d(this, i, obj));
    }
}
