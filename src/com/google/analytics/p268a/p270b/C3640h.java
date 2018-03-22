package com.google.analytics.p268a.p270b;

import com.google.tagmanager.p271a.p272a.C3633a;
import com.google.tagmanager.p271a.p272a.C3674d;
import java.util.Arrays;

/* compiled from: Serving */
public final class C3640h extends C3633a {
    public static final C3640h[] f14006a = new C3640h[0];
    public int[] f14007b = C3674d.f14229e;
    public int[] f14008c = C3674d.f14229e;
    public int[] f14009d = C3674d.f14229e;
    public int[] f14010e = C3674d.f14229e;
    public int[] f14011f = C3674d.f14229e;
    public int[] f14012g = C3674d.f14229e;
    public int[] f14013h = C3674d.f14229e;
    public int[] f14014i = C3674d.f14229e;
    public int[] f14015j = C3674d.f14229e;
    public int[] f14016k = C3674d.f14229e;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3640h)) {
            return false;
        }
        C3640h c3640h = (C3640h) obj;
        if (Arrays.equals(this.f14007b, c3640h.f14007b) && Arrays.equals(this.f14008c, c3640h.f14008c) && Arrays.equals(this.f14009d, c3640h.f14009d) && Arrays.equals(this.f14010e, c3640h.f14010e) && Arrays.equals(this.f14011f, c3640h.f14011f) && Arrays.equals(this.f14012g, c3640h.f14012g) && Arrays.equals(this.f14013h, c3640h.f14013h) && Arrays.equals(this.f14014i, c3640h.f14014i) && Arrays.equals(this.f14015j, c3640h.f14015j) && Arrays.equals(this.f14016k, c3640h.f14016k)) {
            if (this.s == null) {
                if (c3640h.s == null) {
                    return true;
                }
            } else if (this.s.equals(c3640h.s)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (this.f14007b == null) {
            i = 527;
        } else {
            i = 17;
            for (int i3 : this.f14007b) {
                i = (i * 31) + i3;
            }
        }
        if (this.f14008c == null) {
            i *= 31;
        } else {
            for (int i32 : this.f14008c) {
                i = (i * 31) + i32;
            }
        }
        if (this.f14009d == null) {
            i *= 31;
        } else {
            for (int i322 : this.f14009d) {
                i = (i * 31) + i322;
            }
        }
        if (this.f14010e == null) {
            i *= 31;
        } else {
            for (int i3222 : this.f14010e) {
                i = (i * 31) + i3222;
            }
        }
        if (this.f14011f == null) {
            i *= 31;
        } else {
            for (int i32222 : this.f14011f) {
                i = (i * 31) + i32222;
            }
        }
        if (this.f14012g == null) {
            i *= 31;
        } else {
            for (int i322222 : this.f14012g) {
                i = (i * 31) + i322222;
            }
        }
        if (this.f14013h == null) {
            i *= 31;
        } else {
            for (int i3222222 : this.f14013h) {
                i = (i * 31) + i3222222;
            }
        }
        if (this.f14014i == null) {
            i *= 31;
        } else {
            for (int i32222222 : this.f14014i) {
                i = (i * 31) + i32222222;
            }
        }
        if (this.f14015j == null) {
            i *= 31;
        } else {
            for (int i322222222 : this.f14015j) {
                i = (i * 31) + i322222222;
            }
        }
        if (this.f14016k == null) {
            i *= 31;
        } else {
            for (int i3222222222 : this.f14016k) {
                i = (i * 31) + i3222222222;
            }
        }
        int i4 = i * 31;
        if (this.s != null) {
            i2 = this.s.hashCode();
        }
        return i4 + i2;
    }
}
