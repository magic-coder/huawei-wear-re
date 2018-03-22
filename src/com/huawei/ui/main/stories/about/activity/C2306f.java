package com.huawei.ui.main.stories.about.activity;

import com.huawei.hwcommonmodel.d.b;
import com.huawei.p190v.C2538c;

/* compiled from: AboutActivity */
class C2306f implements Runnable {
    final /* synthetic */ C2305e f8367a;

    C2306f(C2305e c2305e) {
        this.f8367a = c2305e;
    }

    public void run() {
        C2538c.m12674b("AboutActivity", "hasPermissionNeeded =" + b.a(this.f8367a.f8366a.f8308a, AboutActivity.f8299H));
        if (b.a(this.f8367a.f8366a.f8308a, AboutActivity.f8299H)) {
            C2538c.m12674b("AboutActivity", "PERMISSIONS_NEEDED if (!hasPermissionNeeded) ELSE");
            this.f8367a.f8366a.m11790j();
            return;
        }
        this.f8367a.f8366a.requestPermissions(AboutActivity.f8299H, 1);
    }
}
