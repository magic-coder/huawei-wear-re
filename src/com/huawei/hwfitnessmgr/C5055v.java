package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class C5055v implements IBaseResponseCallback {
    final /* synthetic */ q f18266a;

    C5055v(q qVar) {
        this.f18266a = qVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"procDeviceDataReport syncTotal onResponse err_code = " + i});
    }
}
