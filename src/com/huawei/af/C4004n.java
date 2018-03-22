package com.huawei.af;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: HWCombineMigrateMgr */
class C4004n implements Runnable {
    final /* synthetic */ IBaseResponseCallback f15277a;
    final /* synthetic */ C3991a f15278b;

    C4004n(C3991a c3991a, IBaseResponseCallback iBaseResponseCallback) {
        this.f15278b = c3991a;
        this.f15277a = iBaseResponseCallback;
    }

    public void run() {
        String a = this.f15278b.m19757a("custom.wear_common_setting");
        if (a != null) {
            this.f15277a.onResponse(0, this.f15278b.m19753b(a));
        }
        this.f15277a.onResponse(100001, null);
    }
}
