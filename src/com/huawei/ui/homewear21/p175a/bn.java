package com.huawei.ui.homewear21.p175a;

import com.huawei.hihealth.p036a.C0824b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bn implements Runnable {
    final /* synthetic */ C2217a f8086a;

    bn(C2217a c2217a) {
        this.f8086a = c2217a;
    }

    public void run() {
        if (this.f8086a.getActivity() == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support getActivity() is null , return");
            return;
        }
        this.f8086a.bd = C0824b.m2914a(BaseApplication.m2632b()).m2912b();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support mHiHealthVersionCode = " + this.f8086a.bd);
        this.f8086a.bu.sendEmptyMessage(26);
    }
}
