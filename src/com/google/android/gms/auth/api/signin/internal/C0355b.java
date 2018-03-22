package com.google.android.gms.auth.api.signin.internal;

public class C0355b {
    static int f242a = 31;
    private int f243b = 1;

    public int m294a() {
        return this.f243b;
    }

    public C0355b m295a(Object obj) {
        this.f243b = (obj == null ? 0 : obj.hashCode()) + (this.f243b * f242a);
        return this;
    }

    public C0355b m296a(boolean z) {
        this.f243b = (z ? 1 : 0) + (this.f243b * f242a);
        return this;
    }
}
