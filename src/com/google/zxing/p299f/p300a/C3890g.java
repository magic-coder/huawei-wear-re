package com.google.zxing.p299f.p300a;

import java.util.Formatter;

/* compiled from: DetectionResult */
final class C3890g {
    private final C3884a f15019a;
    private final C3891h[] f15020b = new C3891h[(this.f15022d + 2)];
    private C3886c f15021c;
    private final int f15022d;

    C3890g(C3884a c3884a, C3886c c3886c) {
        this.f15019a = c3884a;
        this.f15022d = c3884a.m19338a();
        this.f15021c = c3886c;
    }

    C3891h[] m19387a() {
        m19377a(this.f15020b[0]);
        m19377a(this.f15020b[this.f15022d + 1]);
        int i = 928;
        while (true) {
            int f = m19379f();
            if (f > 0 && f < r0) {
                i = f;
            }
        }
        return this.f15020b;
    }

    private void m19377a(C3891h c3891h) {
        if (c3891h != null) {
            ((C3892i) c3891h).m19399a(this.f15019a);
        }
    }

    private int m19379f() {
        int g = m19380g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.f15022d + 1; i++) {
            C3887d[] b = this.f15020b[i].m19396b();
            int i2 = 0;
            while (i2 < b.length) {
                if (!(b[i2] == null || b[i2].m19357a())) {
                    m19376a(i, i2, b);
                }
                i2++;
            }
        }
        return g;
    }

    private int m19380g() {
        m19381h();
        return m19383j() + m19382i();
    }

    private void m19381h() {
        int i = 0;
        if (this.f15020b[0] != null && this.f15020b[this.f15022d + 1] != null) {
            C3887d[] b = this.f15020b[0].m19396b();
            C3887d[] b2 = this.f15020b[this.f15022d + 1].m19396b();
            while (i < b.length) {
                if (!(b[i] == null || b2[i] == null || b[i].m19366h() != b2[i].m19366h())) {
                    for (int i2 = 1; i2 <= this.f15022d; i2++) {
                        C3887d c3887d = this.f15020b[i2].m19396b()[i];
                        if (c3887d != null) {
                            c3887d.m19360b(b[i].m19366h());
                            if (!c3887d.m19357a()) {
                                this.f15020b[i2].m19396b()[i] = null;
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    private int m19382i() {
        if (this.f15020b[this.f15022d + 1] == null) {
            return 0;
        }
        C3887d[] b = this.f15020b[this.f15022d + 1].m19396b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].m19366h();
                int i3 = i;
                i = 0;
                for (int i4 = this.f15022d + 1; i4 > 0 && i < 2; i4--) {
                    C3887d c3887d = this.f15020b[i4].m19396b()[i2];
                    if (c3887d != null) {
                        i = C3890g.m19375a(h, i, c3887d);
                        if (!c3887d.m19357a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private int m19383j() {
        if (this.f15020b[0] == null) {
            return 0;
        }
        C3887d[] b = this.f15020b[0].m19396b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].m19366h();
                int i3 = i;
                int i4 = 0;
                for (i = 1; i < this.f15022d + 1 && i4 < 2; i++) {
                    C3887d c3887d = this.f15020b[i].m19396b()[i2];
                    if (c3887d != null) {
                        i4 = C3890g.m19375a(h, i4, c3887d);
                        if (!c3887d.m19357a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private static int m19375a(int i, int i2, C3887d c3887d) {
        if (c3887d == null || c3887d.m19357a()) {
            return i2;
        }
        if (!c3887d.m19358a(i)) {
            return i2 + 1;
        }
        c3887d.m19360b(i);
        return 0;
    }

    private void m19376a(int i, int i2, C3887d[] c3887dArr) {
        C3887d[] b;
        C3887d c3887d = c3887dArr[i2];
        C3887d[] b2 = this.f15020b[i - 1].m19396b();
        if (this.f15020b[i + 1] != null) {
            b = this.f15020b[i + 1].m19396b();
        } else {
            b = b2;
        }
        C3887d[] c3887dArr2 = new C3887d[14];
        c3887dArr2[2] = b2[i2];
        c3887dArr2[3] = b[i2];
        if (i2 > 0) {
            c3887dArr2[0] = c3887dArr[i2 - 1];
            c3887dArr2[4] = b2[i2 - 1];
            c3887dArr2[5] = b[i2 - 1];
        }
        if (i2 > 1) {
            c3887dArr2[8] = c3887dArr[i2 - 2];
            c3887dArr2[10] = b2[i2 - 2];
            c3887dArr2[11] = b[i2 - 2];
        }
        if (i2 < c3887dArr.length - 1) {
            c3887dArr2[1] = c3887dArr[i2 + 1];
            c3887dArr2[6] = b2[i2 + 1];
            c3887dArr2[7] = b[i2 + 1];
        }
        if (i2 < c3887dArr.length - 2) {
            c3887dArr2[9] = c3887dArr[i2 + 2];
            c3887dArr2[12] = b2[i2 + 2];
            c3887dArr2[13] = b[i2 + 2];
        }
        int length = c3887dArr2.length;
        int i3 = 0;
        while (i3 < length && !C3890g.m19378a(c3887d, c3887dArr2[i3])) {
            i3++;
        }
    }

    private static boolean m19378a(C3887d c3887d, C3887d c3887d2) {
        if (c3887d2 == null || !c3887d2.m19357a() || c3887d2.m19364f() != c3887d.m19364f()) {
            return false;
        }
        c3887d.m19360b(c3887d2.m19366h());
        return true;
    }

    int m19388b() {
        return this.f15022d;
    }

    int m19389c() {
        return this.f15019a.m19340c();
    }

    int m19390d() {
        return this.f15019a.m19339b();
    }

    public void m19386a(C3886c c3886c) {
        this.f15021c = c3886c;
    }

    C3886c m19391e() {
        return this.f15021c;
    }

    void m19385a(int i, C3891h c3891h) {
        this.f15020b[i] = c3891h;
    }

    C3891h m19384a(int i) {
        return this.f15020b[i];
    }

    public String toString() {
        C3891h c3891h = this.f15020b[0];
        if (c3891h == null) {
            c3891h = this.f15020b[this.f15022d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < c3891h.m19396b().length; i++) {
            formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
            for (int i2 = 0; i2 < this.f15022d + 2; i2++) {
                if (this.f15020b[i2] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    if (this.f15020b[i2].m19396b()[i] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(this.f15020b[i2].m19396b()[i].m19366h()), Integer.valueOf(this.f15020b[i2].m19396b()[i].m19365g())});
                    }
                }
            }
            formatter.format("\n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
