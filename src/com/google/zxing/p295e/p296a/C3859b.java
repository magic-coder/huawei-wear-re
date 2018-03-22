package com.google.zxing.p295e.p296a;

/* compiled from: DataCharacter */
public class C3859b {
    private final int f14901a;
    private final int f14902b;

    public C3859b(int i, int i2) {
        this.f14901a = i;
        this.f14902b = i2;
    }

    public final int m19219a() {
        return this.f14901a;
    }

    public final int m19220b() {
        return this.f14902b;
    }

    public final String toString() {
        return this.f14901a + "(" + this.f14902b + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3859b)) {
            return false;
        }
        C3859b c3859b = (C3859b) obj;
        if (this.f14901a == c3859b.f14901a && this.f14902b == c3859b.f14902b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f14901a ^ this.f14902b;
    }
}
