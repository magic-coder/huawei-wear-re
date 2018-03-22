package com.fenda.hwbracelet.p263f;

import android.content.Context;
import com.fenda.p255a.p256a.C3569e;
import com.huawei.p190v.C2538c;

/* compiled from: XbService */
class C3610f implements Runnable {
    final /* synthetic */ Context f13846a;
    final /* synthetic */ C3609e f13847b;

    C3610f(C3609e c3609e, Context context) {
        this.f13847b = c3609e;
        this.f13846a = context;
    }

    public void run() {
        try {
            C3569e.m17917a(this.f13846a);
            C3569e.m17917a(this.f13846a).m17923d();
        } catch (Exception e) {
            C2538c.e("XbService", new Object[]{"XbService enter error:" + e.getMessage()});
        }
    }
}
