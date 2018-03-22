package com.huawei.pluginkidwatch.home;

import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;

/* compiled from: HomeActivity */
class bh implements Runnable {
    final /* synthetic */ HomeActivity f4272a;

    bh(HomeActivity homeActivity) {
        this.f4272a = homeActivity;
    }

    public void run() {
        Bitmap a = this.f4272a.ac.m7218a(this.f4272a.f4109F, C1462f.m6748k().f3098r);
        if (a == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============Download head image, PortraitUrl:" + C1462f.m6748k().f3098r);
            a = this.f4272a.ac.m7219a(this.f4272a.f4109F, C1462f.m6748k().f3098r, this.f4272a.f4131c);
        }
        if (a != null) {
            this.f4272a.m7573c(a);
        }
    }
}
