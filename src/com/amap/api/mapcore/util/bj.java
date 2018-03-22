package com.amap.api.mapcore.util;

/* compiled from: ShortArray */
public class bj {
    public short[] f11499a;
    public int f11500b;
    public boolean f11501c;

    public bj() {
        this(true, 16);
    }

    public bj(boolean z, int i) {
        this.f11501c = z;
        this.f11499a = new short[i];
    }

    public void m15633a(short s) {
        short[] sArr = this.f11499a;
        if (this.f11500b == sArr.length) {
            sArr = m15636d(Math.max(8, (int) (((float) this.f11500b) * 1.75f)));
        }
        int i = this.f11500b;
        this.f11500b = i + 1;
        sArr[i] = s;
    }

    public short m15631a(int i) {
        if (i < this.f11500b) {
            return this.f11499a[i];
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f11500b);
    }

    public short m15634b(int i) {
        if (i >= this.f11500b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f11500b);
        }
        Object obj = this.f11499a;
        short s = obj[i];
        this.f11500b--;
        if (this.f11501c) {
            System.arraycopy(obj, i + 1, obj, i, this.f11500b - i);
        } else {
            obj[i] = obj[this.f11500b];
        }
        return s;
    }

    public void m15632a() {
        this.f11500b = 0;
    }

    public short[] m15635c(int i) {
        int i2 = this.f11500b + i;
        if (i2 > this.f11499a.length) {
            m15636d(Math.max(8, i2));
        }
        return this.f11499a;
    }

    protected short[] m15636d(int i) {
        Object obj = new short[i];
        System.arraycopy(this.f11499a, 0, obj, 0, Math.min(this.f11500b, obj.length));
        this.f11499a = obj;
        return obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bj)) {
            return false;
        }
        bj bjVar = (bj) obj;
        int i = this.f11500b;
        if (i != bjVar.f11500b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f11499a[i2] != bjVar.f11499a[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.f11500b == 0) {
            return "[]";
        }
        short[] sArr = this.f11499a;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(sArr[0]);
        for (int i = 1; i < this.f11500b; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(sArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
