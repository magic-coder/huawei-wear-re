package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class C5056w implements IBaseResponseCallback {
    final /* synthetic */ q f18267a;

    C5056w(q qVar) {
        this.f18267a = qVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"procDeviceDataReport syncDetail onResponse err_code = " + i});
    }
}
