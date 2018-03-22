package com.huawei.p111o.p478b;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

/* compiled from: BaseNCodec */
public abstract class C5698e {
    private final int f19428a;
    protected final int f19429b;
    private final int f19430c;
    private final int f19431d;

    abstract void mo5085a(byte[] bArr, int i, int i2, C5700f c5700f);

    protected abstract boolean mo5086a(byte b);

    abstract void mo5087b(byte[] bArr, int i, int i2, C5700f c5700f);

    protected C5698e(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        this.f19428a = i;
        this.f19430c = i2;
        if (i3 <= 0 || i4 <= 0) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        if (i5 != 0) {
            i6 = (i3 / i2) * i2;
        }
        this.f19429b = i6;
        this.f19431d = i4;
    }

    int m26292a(C5700f c5700f) {
        return c5700f.f19443b != null ? c5700f.f19444c - c5700f.f19445d : 0;
    }

    protected int m26291a() {
        return 8192;
    }

    private byte[] m26290b(C5700f c5700f) {
        if (c5700f.f19443b == null) {
            c5700f.f19443b = new byte[m26291a()];
            c5700f.f19444c = 0;
            c5700f.f19445d = 0;
        } else {
            Object obj = new byte[(c5700f.f19443b.length * 2)];
            System.arraycopy(c5700f.f19443b, 0, obj, 0, c5700f.f19443b.length);
            c5700f.f19443b = obj;
        }
        return c5700f.f19443b;
    }

    protected byte[] m26295a(int i, C5700f c5700f) {
        if (c5700f.f19443b == null || c5700f.f19443b.length < c5700f.f19444c + i) {
            return m26290b(c5700f);
        }
        return c5700f.f19443b;
    }

    int m26298c(byte[] bArr, int i, int i2, C5700f c5700f) {
        if (c5700f.f19443b == null) {
            return c5700f.f19446e ? -1 : 0;
        } else {
            int min = Math.min(m26292a(c5700f), i2);
            System.arraycopy(c5700f.f19443b, c5700f.f19445d, bArr, i, min);
            c5700f.f19445d += min;
            if (c5700f.f19445d < c5700f.f19444c) {
                return min;
            }
            c5700f.f19443b = null;
            return min;
        }
    }

    public byte[] m26297b(String str) {
        return m26299c(C5703i.m26315a(str));
    }

    public byte[] m26299c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C5700f c5700f = new C5700f();
        mo5087b(bArr, 0, bArr.length, c5700f);
        mo5087b(bArr, 0, -1, c5700f);
        bArr = new byte[c5700f.f19444c];
        m26298c(bArr, 0, bArr.length, c5700f);
        return bArr;
    }

    public byte[] m26300d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C5700f c5700f = new C5700f();
        mo5085a(bArr, 0, bArr.length, c5700f);
        mo5085a(bArr, 0, -1, c5700f);
        bArr = new byte[(c5700f.f19444c - c5700f.f19445d)];
        m26298c(bArr, 0, bArr.length, c5700f);
        return bArr;
    }

    protected boolean m26301e(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (TagName.CARD_APP_VERSION == b || mo5086a(b)) {
                return true;
            }
        }
        return false;
    }

    public long m26302f(byte[] bArr) {
        long length = ((long) (((bArr.length + this.f19428a) - 1) / this.f19428a)) * ((long) this.f19430c);
        if (this.f19429b > 0) {
            return length + ((((((long) this.f19429b) + length) - 1) / ((long) this.f19429b)) * ((long) this.f19431d));
        }
        return length;
    }
}
