package com.huawei.pluginkidwatch.common.ui.view;

import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: AsyncImageLoader */
class C1566b implements Runnable {
    final /* synthetic */ C1569i f3864a;
    final /* synthetic */ WeakReference f3865b;
    final /* synthetic */ C1565a f3866c;

    C1566b(C1565a c1565a, C1569i c1569i, WeakReference weakReference) {
        this.f3866c = c1565a;
        this.f3864a = c1569i;
        this.f3865b = weakReference;
    }

    public void run() {
        if (this.f3864a != null) {
            this.f3864a.mo2545a((Bitmap) this.f3865b.get());
            C2538c.m12674b("AsyncImageLoader", "==============从缓存中找到图片");
        }
    }
}
