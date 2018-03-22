package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class C5058y implements IBaseResponseCallback {
    final /* synthetic */ C5057x f18269a;

    C5058y(C5057x c5057x) {
        this.f18269a = c5057x;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"procDeviceDataReport syncDetail onResponse err_code = " + i});
    }
}
