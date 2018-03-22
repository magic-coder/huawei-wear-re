package com.huawei.ad.p314b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWWeatherMgr */
class C3986b implements IBaseResponseCallback {
    final /* synthetic */ C3985a f15238a;

    C3986b(C3985a c3985a) {
        this.f15238a = c3985a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            C2538c.c("HWWeatherMgr", new Object[]{"operationResult setUserPrivacy success privacy id = 5"});
            return;
        }
        C2538c.e("HWWeatherMgr", new Object[]{"operationResult setUserPrivacy failure privacy id = 5"});
    }
}
