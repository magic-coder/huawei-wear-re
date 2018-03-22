package com.google.zxing.p299f.p300a.p301a;

/* compiled from: ModulusGF */
public final class C3882b {
    public static final C3882b f14980a = new C3882b(929, 3);
    private final int[] f14981b;
    private final int[] f14982c;
    private final C3883c f14983d;
    private final C3883c f14984e;
    private final int f14985f;

    private C3882b(int i, int i2) {
        int i3;
        this.f14985f = i;
        this.f14981b = new int[i];
        this.f14982c = new int[i];
        int i4 = 1;
        for (i3 = 0; i3 < i; i3++) {
            this.f14981b[i3] = i4;
            i4 = (i4 * i2) % i;
        }
        for (i3 = 0; i3 < i - 1; i3++) {
            this.f14982c[this.f14981b[i3]] = i3;
        }
        this.f14983d = new C3883c(this, new int[1]);
        this.f14984e = new C3883c(this, new int[]{1});
    }

    C3883c m19319a() {
        return this.f14983d;
    }

    C3883c m19323b() {
        return this.f14984e;
    }

    C3883c m19320a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f14983d;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C3883c(this, iArr);
        }
    }

    int m19322b(int i, int i2) {
        return (i + i2) % this.f14985f;
    }

    int m19326c(int i, int i2) {
        return ((this.f14985f + i) - i2) % this.f14985f;
    }

    int m19318a(int i) {
        return this.f14981b[i];
    }

    int m19321b(int i) {
        if (i != 0) {
            return this.f14982c[i];
        }
        throw new IllegalArgumentException();
    }

    int m19325c(int i) {
        if (i != 0) {
            return this.f14981b[(this.f14985f - this.f14982c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int m19327d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f14981b[(this.f14982c[i] + this.f14982c[i2]) % (this.f14985f - 1)];
    }

    int m19324c() {
        return this.f14985f;
    }
}
