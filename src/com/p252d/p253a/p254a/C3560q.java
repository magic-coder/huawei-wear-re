package com.p252d.p253a.p254a;

import java.lang.ref.WeakReference;

/* compiled from: RequestHandle */
public class C3560q {
    private final WeakReference<C3548f> f13568a;

    public C3560q(C3548f c3548f) {
        this.f13568a = new WeakReference(c3548f);
    }

    public boolean m17886a() {
        C3548f c3548f = (C3548f) this.f13568a.get();
        return c3548f == null || c3548f.m17824b();
    }

    public boolean m17887b() {
        C3548f c3548f = (C3548f) this.f13568a.get();
        return c3548f == null || c3548f.m17822a();
    }

    public boolean m17888c() {
        boolean z = m17887b() || m17886a();
        if (z) {
            this.f13568a.clear();
        }
        return z;
    }
}
