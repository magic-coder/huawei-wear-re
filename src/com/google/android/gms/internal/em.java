package com.google.android.gms.internal;

public final class em implements Cloneable {
    private static final en f748a = new en();
    private boolean f749b;
    private int[] f750c;
    private en[] f751d;
    private int f752e;

    em() {
        this(10);
    }

    em(int i) {
        this.f749b = false;
        int c = m1412c(i);
        this.f750c = new int[c];
        this.f751d = new en[c];
        this.f752e = 0;
    }

    private boolean m1410a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean m1411a(en[] enVarArr, en[] enVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!enVarArr[i2].equals(enVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int m1412c(int i) {
        return m1413d(i * 4) / 4;
    }

    private int m1413d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int m1414e(int i) {
        int i2 = 0;
        int i3 = this.f752e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f750c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    int m1415a() {
        return this.f752e;
    }

    en m1416a(int i) {
        int e = m1414e(i);
        return (e < 0 || this.f751d[e] == f748a) ? null : this.f751d[e];
    }

    void m1417a(int i, en enVar) {
        int e = m1414e(i);
        if (e >= 0) {
            this.f751d[e] = enVar;
            return;
        }
        e ^= -1;
        if (e >= this.f752e || this.f751d[e] != f748a) {
            if (this.f752e >= this.f750c.length) {
                int c = m1412c(this.f752e + 1);
                Object obj = new int[c];
                Object obj2 = new en[c];
                System.arraycopy(this.f750c, 0, obj, 0, this.f750c.length);
                System.arraycopy(this.f751d, 0, obj2, 0, this.f751d.length);
                this.f750c = obj;
                this.f751d = obj2;
            }
            if (this.f752e - e != 0) {
                System.arraycopy(this.f750c, e, this.f750c, e + 1, this.f752e - e);
                System.arraycopy(this.f751d, e, this.f751d, e + 1, this.f752e - e);
            }
            this.f750c[e] = i;
            this.f751d[e] = enVar;
            this.f752e++;
            return;
        }
        this.f750c[e] = i;
        this.f751d[e] = enVar;
    }

    en m1418b(int i) {
        return this.f751d[i];
    }

    public boolean m1419b() {
        return m1415a() == 0;
    }

    public final em m1420c() {
        int a = m1415a();
        em emVar = new em(a);
        System.arraycopy(this.f750c, 0, emVar.f750c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f751d[i] != null) {
                emVar.f751d[i] = (en) this.f751d[i].clone();
            }
        }
        emVar.f752e = a;
        return emVar;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m1420c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof em)) {
            return false;
        }
        em emVar = (em) obj;
        return m1415a() != emVar.m1415a() ? false : m1410a(this.f750c, emVar.f750c, this.f752e) && m1411a(this.f751d, emVar.f751d, this.f752e);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f752e; i2++) {
            i = (((i * 31) + this.f750c[i2]) * 31) + this.f751d[i2].hashCode();
        }
        return i;
    }
}
