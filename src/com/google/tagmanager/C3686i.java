package com.google.tagmanager;

import java.util.Arrays;

/* compiled from: DataLayer */
final class C3686i {
    public final String f14340a;
    public final Object f14341b;

    C3686i(String str, Object obj) {
        this.f14340a = str;
        this.f14341b = obj;
    }

    public String toString() {
        return "Key: " + this.f14340a + " value: " + this.f14341b.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f14340a.hashCode()), Integer.valueOf(this.f14341b.hashCode())});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3686i)) {
            return false;
        }
        C3686i c3686i = (C3686i) obj;
        if (this.f14340a.equals(c3686i.f14340a) && this.f14341b.equals(c3686i.f14341b)) {
            return true;
        }
        return false;
    }
}
