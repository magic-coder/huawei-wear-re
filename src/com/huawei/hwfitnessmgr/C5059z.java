package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class C5059z implements IBaseResponseCallback {
    final /* synthetic */ q f18270a;

    C5059z(q qVar) {
        this.f18270a = qVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"procDeviceDataReport sync core sleep onResponse err_code = " + i});
    }
}
