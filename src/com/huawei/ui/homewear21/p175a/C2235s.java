package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class C2235s implements IBaseResponseCallback {
    final /* synthetic */ C2234r f8149a;

    C2235s(C2234r c2234r) {
        this.f8149a = c2234r;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "err_code:" + i + "  objData:" + obj);
        if (i == 0) {
            this.f8149a.f8148a.m11502d(((Integer) obj).intValue());
        }
    }
}
