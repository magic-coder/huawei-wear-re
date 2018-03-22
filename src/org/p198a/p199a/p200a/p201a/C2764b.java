package org.p198a.p199a.p200a.p201a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

/* compiled from: BaseNCodec */
public abstract class C2764b {
    private final int f9162a;
    protected final byte f9163b = TagName.CARD_APP_VERSION;
    protected final int f9164c;
    protected byte[] f9165d;
    protected int f9166e;
    protected boolean f9167f;
    protected int f9168g;
    protected int f9169h;
    private final int f9170i;
    private final int f9171j;
    private int f9172k;

    abstract void mo3195a(byte[] bArr, int i, int i2);

    protected abstract boolean mo3196a(byte b);

    abstract void mo3197b(byte[] bArr, int i, int i2);

    protected C2764b(int i, int i2, int i3, int i4) {
        this.f9162a = i;
        this.f9170i = i2;
        int i5 = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.f9164c = i5;
        this.f9171j = i4;
    }

    int m12855a() {
        return this.f9165d != null ? this.f9166e - this.f9172k : 0;
    }

    protected int m12859b() {
        return 8192;
    }

    private void m12853c() {
        if (this.f9165d == null) {
            this.f9165d = new byte[m12859b()];
            this.f9166e = 0;
            this.f9172k = 0;
            return;
        }
        Object obj = new byte[(this.f9165d.length * 2)];
        System.arraycopy(this.f9165d, 0, obj, 0, this.f9165d.length);
        this.f9165d = obj;
    }

    protected void m12856a(int i) {
        if (this.f9165d == null || this.f9165d.length < this.f9166e + i) {
            m12853c();
        }
    }

    int m12863c(byte[] bArr, int i, int i2) {
        if (this.f9165d == null) {
            return this.f9167f ? -1 : 0;
        } else {
            int min = Math.min(m12855a(), i2);
            System.arraycopy(this.f9165d, this.f9172k, bArr, i, min);
            this.f9172k += min;
            if (this.f9172k < this.f9166e) {
                return min;
            }
            this.f9165d = null;
            return min;
        }
    }

    private void m12854d() {
        this.f9165d = null;
        this.f9166e = 0;
        this.f9172k = 0;
        this.f9168g = 0;
        this.f9169h = 0;
        this.f9167f = false;
    }

    public byte[] m12861b(String str) {
        return m12862b(C2766c.m12878a(str));
    }

    public byte[] m12862b(byte[] bArr) {
        m12854d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo3197b(bArr, 0, bArr.length);
        mo3197b(bArr, 0, -1);
        bArr = new byte[this.f9166e];
        m12863c(bArr, 0, bArr.length);
        return bArr;
    }

    public byte[] m12864c(byte[] bArr) {
        m12854d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo3195a(bArr, 0, bArr.length);
        mo3195a(bArr, 0, -1);
        bArr = new byte[(this.f9166e - this.f9172k)];
        m12863c(bArr, 0, bArr.length);
        return bArr;
    }

    protected boolean m12865d(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (TagName.CARD_APP_VERSION == b || mo3196a(b)) {
                return true;
            }
        }
        return false;
    }

    public long m12866e(byte[] bArr) {
        long length = ((long) (((bArr.length + this.f9162a) - 1) / this.f9162a)) * ((long) this.f9170i);
        if (this.f9164c > 0) {
            return length + ((((((long) this.f9164c) + length) - 1) / ((long) this.f9164c)) * ((long) this.f9171j));
        }
        return length;
    }
}
