package com.google.zxing.p278b.p281b;

/* compiled from: ReedSolomonDecoder */
public final class C3715c {
    private final C3713a f14434a;

    public C3715c(C3713a c3713a) {
        this.f14434a = c3713a;
    }

    public void m18709a(int[] iArr, int i) throws C3716d {
        int i2 = 0;
        C3714b c3714b = new C3714b(this.f14434a, iArr);
        int[] iArr2 = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            int b = c3714b.m18702b(this.f14434a.m18689a(this.f14434a.m18697d() + i4));
            iArr2[(iArr2.length - 1) - i4] = b;
            if (b != 0) {
                i3 = 0;
            }
        }
        if (i3 == 0) {
            C3714b[] a = m18708a(this.f14434a.m18691a(i, 1), new C3714b(this.f14434a, iArr2), i);
            C3714b c3714b2 = a[0];
            C3714b c3714b3 = a[1];
            int[] a2 = m18706a(c3714b2);
            int[] a3 = m18707a(c3714b3, a2);
            while (i2 < a2.length) {
                int length = (iArr.length - 1) - this.f14434a.m18692b(a2[i2]);
                if (length < 0) {
                    throw new C3716d("Bad error location");
                }
                iArr[length] = C3713a.m18686b(iArr[length], a3[i2]);
                i2++;
            }
        }
    }

    private C3714b[] m18708a(C3714b c3714b, C3714b c3714b2, int i) throws C3716d {
        if (c3714b.m18698a() >= c3714b2.m18698a()) {
            C3714b c3714b3 = c3714b2;
            c3714b2 = c3714b;
            c3714b = c3714b3;
        }
        C3714b a = this.f14434a.m18690a();
        C3714b b = this.f14434a.m18693b();
        while (c3714b.m18698a() >= i / 2) {
            if (c3714b.m18704b()) {
                throw new C3716d("r_{i-1} was zero");
            }
            C3714b a2 = this.f14434a.m18690a();
            int c = this.f14434a.m18695c(c3714b.m18699a(c3714b.m18698a()));
            C3714b c3714b4 = a2;
            a2 = c3714b2;
            while (a2.m18698a() >= c3714b.m18698a() && !a2.m18704b()) {
                int a3 = a2.m18698a() - c3714b.m18698a();
                int c2 = this.f14434a.m18696c(a2.m18699a(a2.m18698a()), c);
                c3714b4 = c3714b4.m18701a(this.f14434a.m18691a(a3, c2));
                a2 = a2.m18701a(c3714b.m18700a(a3, c2));
            }
            a = c3714b4.m18703b(b).m18701a(a);
            if (a2.m18698a() >= c3714b.m18698a()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            c3714b2 = c3714b;
            c3714b = a2;
            c3714b3 = b;
            b = a;
            a = c3714b3;
        }
        int a4 = b.m18699a(0);
        if (a4 == 0) {
            throw new C3716d("sigmaTilde(0) was zero");
        }
        a4 = this.f14434a.m18695c(a4);
        b = b.m18705c(a4);
        a = c3714b.m18705c(a4);
        return new C3714b[]{b, a};
    }

    private int[] m18706a(C3714b c3714b) throws C3716d {
        int i = 0;
        int i2 = 1;
        int a = c3714b.m18698a();
        if (a == 1) {
            return new int[]{c3714b.m18699a(1)};
        }
        int[] iArr = new int[a];
        while (i2 < this.f14434a.m18694c() && i < a) {
            if (c3714b.m18702b(i2) == 0) {
                iArr[i] = this.f14434a.m18695c(i2);
                i++;
            }
            i2++;
        }
        if (i == a) {
            return iArr;
        }
        throw new C3716d("Error locator degree does not match number of roots");
    }

    private int[] m18707a(C3714b c3714b, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f14434a.m18695c(iArr[i]);
            int i2 = 1;
            int i3 = 0;
            while (i3 < length) {
                int c2;
                if (i != i3) {
                    c2 = this.f14434a.m18696c(iArr[i3], c);
                    c2 = this.f14434a.m18696c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                } else {
                    c2 = i2;
                }
                i3++;
                i2 = c2;
            }
            iArr2[i] = this.f14434a.m18696c(c3714b.m18702b(c), this.f14434a.m18695c(i2));
            if (this.f14434a.m18697d() != 0) {
                iArr2[i] = this.f14434a.m18696c(iArr2[i], c);
            }
        }
        return iArr2;
    }
}
