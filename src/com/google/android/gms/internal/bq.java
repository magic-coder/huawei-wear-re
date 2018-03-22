package com.google.android.gms.internal;

public final class bq<L> {
    private final L f625a;
    private final String f626b;

    bq(L l, String str) {
        this.f625a = l;
        this.f626b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bq)) {
            return false;
        }
        bq bqVar = (bq) obj;
        return this.f625a == bqVar.f625a && this.f626b.equals(bqVar.f626b);
    }

    public int hashCode() {
        return (System.identityHashCode(this.f625a) * 31) + this.f626b.hashCode();
    }
}
