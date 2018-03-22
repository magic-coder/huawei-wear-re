package com.google.analytics.p268a.p270b;

import com.google.tagmanager.p271a.p272a.C3633a;

/* compiled from: Serving */
public final class C3638f extends C3633a {
    public static final C3638f[] f13985a = new C3638f[0];
    public int f13986b = 0;
    public int f13987c = 0;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3638f)) {
            return false;
        }
        C3638f c3638f = (C3638f) obj;
        if (this.f13986b == c3638f.f13986b && this.f13987c == c3638f.f13987c) {
            if (this.s == null) {
                if (c3638f.s == null) {
                    return true;
                }
            } else if (this.s.equals(c3638f.s)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.s == null ? 0 : this.s.hashCode()) + ((((this.f13986b + 527) * 31) + this.f13987c) * 31);
    }
}
