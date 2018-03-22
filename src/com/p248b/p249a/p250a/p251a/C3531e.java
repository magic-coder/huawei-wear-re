package com.p248b.p249a.p250a.p251a;

/* compiled from: GaiaCommand */
public class C3531e {
    private int f13319a = 32766;
    private int f13320b = 0;
    private byte[] f13321c = null;

    C3531e(byte[] bArr, int i) {
        m17650b(bArr, i);
    }

    private int m17649a(byte[] bArr, int i) {
        try {
            return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    private void m17650b(byte[] bArr, int i) {
        int i2 = i - 8;
        if ((bArr[2] & 1) != 0) {
            i2--;
        }
        this.f13319a = m17649a(bArr, 4);
        this.f13320b = m17649a(bArr, 6);
        if (i2 > 0) {
            this.f13321c = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f13321c[i3] = bArr[i3 + 8];
            }
        }
    }

    public boolean m17651a() {
        return (this.f13320b & 32768) != 0;
    }

    public boolean m17654b() {
        return this.f13319a == 10;
    }

    public boolean m17652a(int i) {
        return m17654b() && this.f13320b == i;
    }

    public C3529c m17656c() {
        if (this.f13321c == null || this.f13321c.length == 0 || !m17652a(16387)) {
            return null;
        }
        return C3529c.m17647a(this.f13321c[0]);
    }

    public C3530d m17657d() {
        if (this.f13321c == null || this.f13321c.length == 0) {
            return null;
        }
        return C3530d.m17648a(this.f13321c[0]);
    }

    public byte[] m17658e() {
        return this.f13321c;
    }

    public byte m17653b(int i) {
        try {
            return this.f13321c[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            return (byte) 0;
        }
    }

    public byte m17659f() {
        return m17653b(1);
    }

    public int m17655c(int i) {
        return m17649a(this.f13321c, i);
    }

    public int m17660g() {
        return this.f13319a;
    }

    public int m17661h() {
        return this.f13320b & 32767;
    }

    public int m17662i() {
        return this.f13320b;
    }
}
