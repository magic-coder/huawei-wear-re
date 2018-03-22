package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.C0502h;

abstract class bu<T> extends C0532a {
    private C0502h<T> f957a;

    public bu(C0502h<T> c0502h) {
        this.f957a = c0502h;
    }

    public void m1943a(T t) {
        C0502h c0502h = this.f957a;
        if (c0502h != null) {
            c0502h.mo1881a((Object) t);
            this.f957a = null;
        }
    }
}
