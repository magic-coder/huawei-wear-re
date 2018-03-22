package com.google.zxing;

/* compiled from: LuminanceSource */
public abstract class C3824g {
    private final int f14837a;
    private final int f14838b;

    public abstract byte[] mo4316a();

    public abstract byte[] mo4317a(int i, byte[] bArr);

    protected C3824g(int i, int i2) {
        this.f14837a = i;
        this.f14838b = i2;
    }

    public final int m19082b() {
        return this.f14837a;
    }

    public final int m19083c() {
        return this.f14838b;
    }

    public boolean m19084d() {
        return false;
    }

    public C3824g m19085e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        byte[] bArr = new byte[this.f14837a];
        StringBuilder stringBuilder = new StringBuilder(this.f14838b * (this.f14837a + 1));
        byte[] bArr2 = bArr;
        for (int i = 0; i < this.f14838b; i++) {
            bArr2 = mo4317a(i, bArr2);
            for (int i2 = 0; i2 < this.f14837a; i2++) {
                char c;
                int i3 = bArr2[i2] & 255;
                if (i3 < 64) {
                    c = '#';
                } else if (i3 < 128) {
                    c = '+';
                } else if (i3 < 192) {
                    c = '.';
                } else {
                    c = ' ';
                }
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
