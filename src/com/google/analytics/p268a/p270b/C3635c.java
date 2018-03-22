package com.google.analytics.p268a.p270b;

import com.google.tagmanager.p271a.p272a.C3633a;
import com.google.tagmanager.p271a.p272a.C3674d;
import java.util.Arrays;

/* compiled from: Serving */
public final class C3635c extends C3633a {
    public static final C3635c[] f13969a = new C3635c[0];
    public int[] f13970b = C3674d.f14229e;
    public int f13971c = 0;
    public int f13972d = 0;
    public boolean f13973e = false;
    public boolean f13974f = false;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3635c)) {
            return false;
        }
        C3635c c3635c = (C3635c) obj;
        if (Arrays.equals(this.f13970b, c3635c.f13970b) && this.f13971c == c3635c.f13971c && this.f13972d == c3635c.f13972d && this.f13973e == c3635c.f13973e && this.f13974f == c3635c.f13974f) {
            if (this.s == null) {
                if (c3635c.s == null) {
                    return true;
                }
            } else if (this.s.equals(c3635c.s)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f13970b == null) {
            i = 527;
        } else {
            i = 17;
            for (int i5 : this.f13970b) {
                i = (i * 31) + i5;
            }
        }
        i = ((((i * 31) + this.f13971c) * 31) + this.f13972d) * 31;
        if (this.f13973e) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        i2 = (i2 + i) * 31;
        if (!this.f13974f) {
            i3 = 2;
        }
        i2 = (i2 + i3) * 31;
        if (this.s != null) {
            i4 = this.s.hashCode();
        }
        return i2 + i4;
    }
}
