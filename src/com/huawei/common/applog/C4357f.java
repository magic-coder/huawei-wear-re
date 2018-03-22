package com.huawei.common.applog;

import android.content.Context;
import com.huawei.common.applog.p380a.C4346b;

/* compiled from: ReportEventManager */
final class C4357f implements Runnable {
    final /* synthetic */ Context f16192a;
    final /* synthetic */ boolean f16193b;

    C4357f(Context context, boolean z) {
        this.f16192a = context;
        this.f16193b = z;
    }

    public void run() {
        new C4346b().m20896a(this.f16192a, this.f16193b, true);
    }
}
