package com.huawei.pluginkidwatch.common.entity.p143c;

import android.content.Context;
import com.huawei.p190v.C2538c;

/* compiled from: TmidUtil */
class C1451f extends Thread {
    final /* synthetic */ Context f3334a;
    final /* synthetic */ C1450e f3335b;

    C1451f(C1450e c1450e, Context context) {
        this.f3335b = c1450e;
        this.f3334a = context;
    }

    public void run() {
        C2538c.m12674b("TmidUtil", "=========Enter uploadTMID run===");
        this.f3335b.f3333b = 10;
        this.f3335b.m6686a(this.f3334a);
    }
}
