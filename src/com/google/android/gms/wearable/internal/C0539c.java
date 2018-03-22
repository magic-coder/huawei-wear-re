package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.C0424f;

public final class C0539c extends ak {
    private final Object f975a = new Object();
    private C0540d f976b;
    private di f977c;

    public void mo1952a(int i, int i2) {
        synchronized (this.f975a) {
            C0540d c0540d = this.f976b;
            di diVar = new di(i, i2);
            this.f977c = diVar;
        }
        if (c0540d != null) {
            c0540d.mo2019a(diVar);
        }
    }

    public void m2015a(C0540d c0540d) {
        synchronized (this.f975a) {
            this.f976b = (C0540d) C0424f.m649a((Object) c0540d);
            di diVar = this.f977c;
        }
        if (diVar != null) {
            c0540d.mo2019a(diVar);
        }
    }
}
