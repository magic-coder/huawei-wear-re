package com.google.zxing.p299f.p300a.p301a;

import com.google.zxing.C3832d;

/* compiled from: ErrorCorrection */
public final class C3881a {
    private final C3882b f14979a = C3882b.f14980a;

    public int m19317a(int[] iArr, int i, int[] iArr2) throws C3832d {
        C3883c c3883c = new C3883c(this.f14979a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        for (int i3 = i; i3 > 0; i3--) {
            int b = c3883c.m19332b(this.f14979a.m19318a(i3));
            iArr3[i - i3] = b;
            if (b != 0) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        C3883c b2 = this.f14979a.m19323b();
        C3883c c3883c2 = b2;
        for (int b3 : iArr2) {
            b3 = this.f14979a.m19318a((iArr.length - 1) - b3);
            c3883c2 = c3883c2.m19337c(new C3883c(this.f14979a, new int[]{this.f14979a.m19326c(0, b3), 1}));
        }
        C3883c[] a = m19316a(this.f14979a.m19320a(i, 1), new C3883c(this.f14979a, iArr3), i);
        c3883c2 = a[0];
        b2 = a[1];
        int[] a2 = m19314a(c3883c2);
        int[] a3 = m19315a(b2, c3883c2, a2);
        for (i2 = 0; i2 < a2.length; i2++) {
            int length = (iArr.length - 1) - this.f14979a.m19321b(a2[i2]);
            if (length < 0) {
                throw C3832d.m19108a();
            }
            iArr[length] = this.f14979a.m19326c(iArr[length], a3[i2]);
        }
        return a2.length;
    }

    private C3883c[] m19316a(C3883c c3883c, C3883c c3883c2, int i) throws C3832d {
        if (c3883c.m19328a() >= c3883c2.m19328a()) {
            C3883c c3883c3 = c3883c2;
            c3883c2 = c3883c;
            c3883c = c3883c3;
        }
        C3883c a = this.f14979a.m19319a();
        C3883c b = this.f14979a.m19323b();
        while (c3883c.m19328a() >= i / 2) {
            if (c3883c.m19334b()) {
                throw C3832d.m19108a();
            }
            C3883c a2 = this.f14979a.m19319a();
            int c = this.f14979a.m19325c(c3883c.m19329a(c3883c.m19328a()));
            C3883c c3883c4 = a2;
            a2 = c3883c2;
            while (a2.m19328a() >= c3883c.m19328a() && !a2.m19334b()) {
                int a3 = a2.m19328a() - c3883c.m19328a();
                int d = this.f14979a.m19327d(a2.m19329a(a2.m19328a()), c);
                c3883c4 = c3883c4.m19331a(this.f14979a.m19320a(a3, d));
                a2 = a2.m19333b(c3883c.m19330a(a3, d));
            }
            c3883c2 = c3883c;
            c3883c = a2;
            c3883c3 = b;
            b = c3883c4.m19337c(b).m19333b(a).m19335c();
            a = c3883c3;
        }
        int a4 = b.m19329a(0);
        if (a4 == 0) {
            throw C3832d.m19108a();
        }
        a4 = this.f14979a.m19325c(a4);
        b = b.m19336c(a4);
        a = c3883c.m19336c(a4);
        return new C3883c[]{b, a};
    }

    private int[] m19314a(C3883c c3883c) throws C3832d {
        int a = c3883c.m19328a();
        int[] iArr = new int[a];
        int i = 0;
        for (int i2 = 1; i2 < this.f14979a.m19324c() && i < a; i2++) {
            if (c3883c.m19332b(i2) == 0) {
                iArr[i] = this.f14979a.m19325c(i2);
                i++;
            }
        }
        if (i == a) {
            return iArr;
        }
        throw C3832d.m19108a();
    }

    private int[] m19315a(C3883c c3883c, C3883c c3883c2, int[] iArr) {
        int i;
        int a = c3883c2.m19328a();
        int[] iArr2 = new int[a];
        for (i = 1; i <= a; i++) {
            iArr2[a - i] = this.f14979a.m19327d(i, c3883c2.m19329a(i));
        }
        C3883c c3883c3 = new C3883c(this.f14979a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (i = 0; i < length; i++) {
            int c = this.f14979a.m19325c(iArr[i]);
            iArr3[i] = this.f14979a.m19327d(this.f14979a.m19326c(0, c3883c.m19332b(c)), this.f14979a.m19325c(c3883c3.m19332b(c)));
        }
        return iArr3;
    }
}
