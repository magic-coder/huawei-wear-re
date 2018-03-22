package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ad implements IBaseResponseCallback {
    final /* synthetic */ IBaseResponseCallback f18143a;
    final /* synthetic */ q f18144b;

    ad(q qVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f18144b = qVar;
        this.f18143a = iBaseResponseCallback;
    }

    public void onResponse(int i, Object obj) {
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{" today total finish nedd detail err_code:", Integer.valueOf(i)});
        this.f18144b.a.execute(new ax(this.f18144b, this.f18143a));
    }
}
