package com.google.analytics.p268a.p270b;

import com.google.tagmanager.p271a.p272a.C3633a;

/* compiled from: Serving */
public final class C3634b extends C3633a {
    public static final C3634b[] f13965a = new C3634b[0];
    public int f13966b = 1;
    public int f13967c = 0;
    public int f13968d = 0;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3634b)) {
            return false;
        }
        C3634b c3634b = (C3634b) obj;
        if (this.f13966b == c3634b.f13966b && this.f13967c == c3634b.f13967c && this.f13968d == c3634b.f13968d) {
            if (this.s == null) {
                if (c3634b.s == null) {
                    return true;
                }
            } else if (this.s.equals(c3634b.s)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.s == null ? 0 : this.s.hashCode()) + ((((((this.f13966b + 527) * 31) + this.f13967c) * 31) + this.f13968d) * 31);
    }
}
