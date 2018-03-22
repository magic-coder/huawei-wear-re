package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class as implements IBaseResponseCallback {
    final /* synthetic */ C2217a f8062a;

    as(C2217a c2217a) {
        this.f8062a = c2217a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "onResume syncFitnessTodayData onResponse err_code = " + i + ", objData = " + obj);
    }
}
