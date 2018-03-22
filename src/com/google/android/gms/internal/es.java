package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class es {
    final int f759a;
    final byte[] f760b;

    es(int i, byte[] bArr) {
        this.f759a = i;
        this.f760b = bArr;
    }

    int m1446a() {
        return (ei.m1372h(this.f759a) + 0) + this.f760b.length;
    }

    void m1447a(ei eiVar) throws IOException {
        eiVar.m1402g(this.f759a);
        eiVar.m1398d(this.f760b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof es)) {
            return false;
        }
        es esVar = (es) obj;
        return this.f759a == esVar.f759a && Arrays.equals(this.f760b, esVar.f760b);
    }

    public int hashCode() {
        return ((this.f759a + 527) * 31) + Arrays.hashCode(this.f760b);
    }
}
