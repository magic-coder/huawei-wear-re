package com.huawei.hwdatamigrate.common.p408a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

/* compiled from: BaseNCodec */
public abstract class C4795b {
    private final int f17720a;
    protected final int f17721b;
    private final int f17722c;
    private final int f17723d;

    abstract void mo4562a(byte[] bArr, int i, int i2, C4797c c4797c);

    protected abstract boolean mo4563a(byte b);

    abstract void mo4564b(byte[] bArr, int i, int i2, C4797c c4797c);

    protected C4795b(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        this.f17720a = i;
        this.f17722c = i2;
        if (i3 <= 0 || i4 <= 0) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        if (i5 != 0) {
            i6 = (i3 / i2) * i2;
        }
        this.f17721b = i6;
        this.f17723d = i4;
    }

    int m22953a(C4797c c4797c) {
        return c4797c.f17735c != null ? c4797c.f17736d - c4797c.f17737e : 0;
    }

    protected int m22952a() {
        return 8192;
    }

    private byte[] m22951b(C4797c c4797c) {
        if (c4797c.f17735c == null) {
            c4797c.f17735c = new byte[m22952a()];
            c4797c.f17736d = 0;
            c4797c.f17737e = 0;
        } else {
            Object obj = new byte[(c4797c.f17735c.length * 2)];
            System.arraycopy(c4797c.f17735c, 0, obj, 0, c4797c.f17735c.length);
            c4797c.f17735c = obj;
        }
        return c4797c.f17735c;
    }

    protected byte[] m22956a(int i, C4797c c4797c) {
        if (c4797c.f17735c == null || c4797c.f17735c.length < c4797c.f17736d + i) {
            return m22951b(c4797c);
        }
        return c4797c.f17735c;
    }

    int m22959c(byte[] bArr, int i, int i2, C4797c c4797c) {
        if (c4797c.f17735c == null) {
            return c4797c.f17738f ? -1 : 0;
        } else {
            int min = Math.min(m22953a(c4797c), i2);
            System.arraycopy(c4797c.f17735c, c4797c.f17737e, bArr, i, min);
            c4797c.f17737e += min;
            if (c4797c.f17737e < c4797c.f17736d) {
                return min;
            }
            c4797c.f17735c = null;
            return min;
        }
    }

    public byte[] m22958b(String str) {
        return m22960d(C4798d.m22978a(str));
    }

    public byte[] m22960d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C4797c c4797c = new C4797c();
        mo4564b(bArr, 0, bArr.length, c4797c);
        mo4564b(bArr, 0, -1, c4797c);
        bArr = new byte[c4797c.f17736d];
        m22959c(bArr, 0, bArr.length, c4797c);
        return bArr;
    }

    public byte[] m22961e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C4797c c4797c = new C4797c();
        mo4562a(bArr, 0, bArr.length, c4797c);
        mo4562a(bArr, 0, -1, c4797c);
        bArr = new byte[(c4797c.f17736d - c4797c.f17737e)];
        m22959c(bArr, 0, bArr.length, c4797c);
        return bArr;
    }

    protected boolean m22962f(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (TagName.CARD_APP_VERSION == b || mo4563a(b)) {
                return true;
            }
        }
        return false;
    }

    public long m22963g(byte[] bArr) {
        long length = ((long) (((bArr.length + this.f17720a) - 1) / this.f17720a)) * ((long) this.f17722c);
        if (this.f17721b > 0) {
            return length + ((((((long) this.f17721b) + length) - 1) / ((long) this.f17721b)) * ((long) this.f17723d));
        }
        return length;
    }
}
