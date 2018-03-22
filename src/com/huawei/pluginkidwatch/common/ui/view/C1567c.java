package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: AsyncImageLoader */
class C1567c implements Runnable {
    final /* synthetic */ String f3867a;
    final /* synthetic */ Context f3868b;
    final /* synthetic */ C1569i f3869c;
    final /* synthetic */ C1565a f3870d;

    C1567c(C1565a c1565a, String str, Context context, C1569i c1569i) {
        this.f3870d = c1565a;
        this.f3867a = str;
        this.f3868b = context;
        this.f3869c = c1569i;
    }

    public void run() {
        try {
            C2538c.m12674b("AsyncImageLoader", "==============AAA4");
            Bitmap a = this.f3870d.m7214a(this.f3867a);
            if (a != null) {
                C1565a.f3825a.put(this.f3867a, new WeakReference(a));
                ac.m7223a(this.f3868b, this.f3867a, a);
                this.f3870d.f3827c.post(new C1568d(this, a));
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
