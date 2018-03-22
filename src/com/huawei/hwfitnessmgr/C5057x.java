package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class C5057x implements IBaseResponseCallback {
    final /* synthetic */ q f18268a;

    C5057x(q qVar) {
        this.f18268a = qVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"procDeviceDataReport syncTotal onResponse err_code = " + i});
        if (i == 0) {
            C2538c.c("HWFitnessMgr", new Object[]{"get detail "});
            this.f18268a.b(new C5058y(this));
        }
    }
}
