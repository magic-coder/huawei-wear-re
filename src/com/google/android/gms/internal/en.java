package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class en implements Cloneable {
    private el<?, ?> f753a;
    private Object f754b;
    private List<es> f755c = new ArrayList();

    en() {
    }

    private byte[] m1421c() throws IOException {
        byte[] bArr = new byte[m1422a()];
        m1423a(ei.m1349a(bArr));
        return bArr;
    }

    int m1422a() {
        if (this.f754b != null) {
            return this.f753a.m1404a(this.f754b);
        }
        int i = 0;
        for (es a : this.f755c) {
            i = a.m1446a() + i;
        }
        return i;
    }

    void m1423a(ei eiVar) throws IOException {
        if (this.f754b != null) {
            this.f753a.m1405a(this.f754b, eiVar);
            return;
        }
        for (es a : this.f755c) {
            a.m1447a(eiVar);
        }
    }

    void m1424a(es esVar) {
        this.f755c.add(esVar);
    }

    public final en m1425b() {
        en enVar = new en();
        try {
            enVar.f753a = this.f753a;
            if (this.f755c == null) {
                enVar.f755c = null;
            } else {
                enVar.f755c.addAll(this.f755c);
            }
            if (this.f754b != null) {
                if (this.f754b instanceof eq) {
                    enVar.f754b = (eq) ((eq) this.f754b).clone();
                } else if (this.f754b instanceof byte[]) {
                    enVar.f754b = ((byte[]) this.f754b).clone();
                } else if (this.f754b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f754b;
                    r4 = new byte[bArr.length][];
                    enVar.f754b = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.f754b instanceof boolean[]) {
                    enVar.f754b = ((boolean[]) this.f754b).clone();
                } else if (this.f754b instanceof int[]) {
                    enVar.f754b = ((int[]) this.f754b).clone();
                } else if (this.f754b instanceof long[]) {
                    enVar.f754b = ((long[]) this.f754b).clone();
                } else if (this.f754b instanceof float[]) {
                    enVar.f754b = ((float[]) this.f754b).clone();
                } else if (this.f754b instanceof double[]) {
                    enVar.f754b = ((double[]) this.f754b).clone();
                } else if (this.f754b instanceof eq[]) {
                    eq[] eqVarArr = (eq[]) this.f754b;
                    r4 = new eq[eqVarArr.length];
                    enVar.f754b = r4;
                    for (r2 = 0; r2 < eqVarArr.length; r2++) {
                        r4[r2] = (eq) eqVarArr[r2].clone();
                    }
                }
            }
            return enVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m1425b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof en)) {
            return false;
        }
        en enVar = (en) obj;
        if (this.f754b != null && enVar.f754b != null) {
            return this.f753a == enVar.f753a ? !this.f753a.f745b.isArray() ? this.f754b.equals(enVar.f754b) : this.f754b instanceof byte[] ? Arrays.equals((byte[]) this.f754b, (byte[]) enVar.f754b) : this.f754b instanceof int[] ? Arrays.equals((int[]) this.f754b, (int[]) enVar.f754b) : this.f754b instanceof long[] ? Arrays.equals((long[]) this.f754b, (long[]) enVar.f754b) : this.f754b instanceof float[] ? Arrays.equals((float[]) this.f754b, (float[]) enVar.f754b) : this.f754b instanceof double[] ? Arrays.equals((double[]) this.f754b, (double[]) enVar.f754b) : this.f754b instanceof boolean[] ? Arrays.equals((boolean[]) this.f754b, (boolean[]) enVar.f754b) : Arrays.deepEquals((Object[]) this.f754b, (Object[]) enVar.f754b) : false;
        } else {
            if (this.f755c != null && enVar.f755c != null) {
                return this.f755c.equals(enVar.f755c);
            }
            try {
                return Arrays.equals(m1421c(), enVar.m1421c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m1421c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
