package com.amap.api.mapcore.util;

/* compiled from: IntArray */
public class be {
    public int[] f11494a;
    public int f11495b;
    public boolean f11496c;

    public be() {
        this(true, 16);
    }

    public be(boolean z, int i) {
        this.f11496c = z;
        this.f11494a = new int[i];
    }

    public void m15623a(int i) {
        int[] iArr = this.f11494a;
        if (this.f11495b == iArr.length) {
            iArr = m15626d(Math.max(8, (int) (((float) this.f11495b) * 1.75f)));
        }
        int i2 = this.f11495b;
        this.f11495b = i2 + 1;
        iArr[i2] = i;
    }

    public int m15624b(int i) {
        if (i >= this.f11495b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f11495b);
        }
        Object obj = this.f11494a;
        int i2 = obj[i];
        this.f11495b--;
        if (this.f11496c) {
            System.arraycopy(obj, i + 1, obj, i, this.f11495b - i);
        } else {
            obj[i] = obj[this.f11495b];
        }
        return i2;
    }

    public void m15622a() {
        this.f11495b = 0;
    }

    public int[] m15625c(int i) {
        int i2 = this.f11495b + i;
        if (i2 > this.f11494a.length) {
            m15626d(Math.max(8, i2));
        }
        return this.f11494a;
    }

    protected int[] m15626d(int i) {
        Object obj = new int[i];
        System.arraycopy(this.f11494a, 0, obj, 0, Math.min(this.f11495b, obj.length));
        this.f11494a = obj;
        return obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        int i = this.f11495b;
        if (i != beVar.f11495b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f11494a[i2] != beVar.f11494a[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.f11495b == 0) {
            return "[]";
        }
        int[] iArr = this.f11494a;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(iArr[0]);
        for (int i = 1; i < this.f11495b; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(iArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
