package com.google.analytics.p268a.p270b;

import com.google.analytics.p273b.p274a.p275a.C3644b;
import com.google.tagmanager.p271a.p272a.C3633a;
import java.util.Arrays;

/* compiled from: Serving */
public final class C3637e extends C3633a {
    public static final C3637e[] f13981a = new C3637e[0];
    public C3644b[] f13982b = C3644b.f14025a;
    public C3644b[] f13983c = C3644b.f14025a;
    public C3636d[] f13984d = C3636d.f13975a;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3637e)) {
            return false;
        }
        C3637e c3637e = (C3637e) obj;
        if (Arrays.equals(this.f13982b, c3637e.f13982b) && Arrays.equals(this.f13983c, c3637e.f13983c) && Arrays.equals(this.f13984d, c3637e.f13984d)) {
            if (this.s == null) {
                if (c3637e.s == null) {
                    return true;
                }
            } else if (this.s.equals(c3637e.s)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        if (this.f13982b == null) {
            i = 527;
        } else {
            i = 17;
            for (i2 = 0; i2 < this.f13982b.length; i2++) {
                i = (this.f13982b[i2] == null ? 0 : this.f13982b[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13983c == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13983c.length; i2++) {
                i = (this.f13983c[i2] == null ? 0 : this.f13983c[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13984d == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13984d.length; i2++) {
                i = (this.f13984d[i2] == null ? 0 : this.f13984d[i2].hashCode()) + (i * 31);
            }
        }
        i2 = i * 31;
        if (this.s != null) {
            i3 = this.s.hashCode();
        }
        return i2 + i3;
    }
}
