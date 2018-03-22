package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class C2240x implements IBaseResponseCallback {
    final /* synthetic */ C2217a f8156a;

    C2240x(C2217a c2217a) {
        this.f8156a = c2217a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "startHealthMigrateData fitness data migrate complete ");
        this.f8156a.f7999H.m11993c(true);
        this.f8156a.bu.sendEmptyMessage(1017);
    }
}
