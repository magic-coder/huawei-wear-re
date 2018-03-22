package com.huawei.ui.homewear21.p175a;

import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwdatamigrate.a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class C2239w implements Runnable {
    final /* synthetic */ C2217a f8155a;

    C2239w(C2217a c2217a) {
        this.f8155a = c2217a;
    }

    public void run() {
        a a = a.a(this.f8155a.f7992A);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "normalStatus = " + a.a());
        if (!a.a()) {
            this.f8155a.ae();
        }
        boolean a2 = C0970w.m3488a(C1093a.m4739a(this.f8155a.f7992A).m4750c());
        C2538c.m12661a("MainUI", 0, "HomeFragment", "isDatalogin = " + a2 + ", healthStatus = " + a.b());
        if (!a2 || r0) {
            this.f8155a.bu.sendEmptyMessage(16);
        } else {
            this.f8155a.af();
        }
        this.f8155a.aY = false;
    }
}
