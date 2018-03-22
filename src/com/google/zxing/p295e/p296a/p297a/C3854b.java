package com.google.zxing.p295e.p296a.p297a;

import com.google.zxing.p295e.p296a.C3859b;
import com.google.zxing.p295e.p296a.C3860c;

/* compiled from: ExpandedPair */
final class C3854b {
    private final boolean f14878a;
    private final C3859b f14879b;
    private final C3859b f14880c;
    private final C3860c f14881d;

    C3854b(C3859b c3859b, C3859b c3859b2, C3860c c3860c, boolean z) {
        this.f14879b = c3859b;
        this.f14880c = c3859b2;
        this.f14881d = c3860c;
        this.f14878a = z;
    }

    C3859b m19175a() {
        return this.f14879b;
    }

    C3859b m19176b() {
        return this.f14880c;
    }

    C3860c m19177c() {
        return this.f14881d;
    }

    public boolean m19178d() {
        return this.f14880c == null;
    }

    public String toString() {
        return "[ " + this.f14879b + " , " + this.f14880c + " : " + (this.f14881d == null ? "null" : Integer.valueOf(this.f14881d.m19221a())) + " ]";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3854b)) {
            return false;
        }
        C3854b c3854b = (C3854b) obj;
        if (C3854b.m19174a(this.f14879b, c3854b.f14879b) && C3854b.m19174a(this.f14880c, c3854b.f14880c) && C3854b.m19174a(this.f14881d, c3854b.f14881d)) {
            return true;
        }
        return false;
    }

    private static boolean m19174a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    public int hashCode() {
        return (C3854b.m19173a(this.f14879b) ^ C3854b.m19173a(this.f14880c)) ^ C3854b.m19173a(this.f14881d);
    }

    private static int m19173a(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }
}
