package com.huawei.pluginkidwatch.common.ui.view;

import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;

/* compiled from: AsyncImageLoader */
class C1568d implements Runnable {
    final /* synthetic */ Bitmap f3871a;
    final /* synthetic */ C1567c f3872b;

    C1568d(C1567c c1567c, Bitmap bitmap) {
        this.f3872b = c1567c;
        this.f3871a = bitmap;
    }

    public void run() {
        if (this.f3872b.f3869c != null) {
            C2538c.m12674b("AsyncImageLoader", "==============AAA5");
            this.f3872b.f3869c.mo2545a(this.f3871a);
        }
    }
}
