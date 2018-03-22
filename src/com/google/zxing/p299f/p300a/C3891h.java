package com.google.zxing.p299f.p300a;

import java.util.Formatter;

/* compiled from: DetectionResultColumn */
class C3891h {
    private final C3886c f15023a;
    private final C3887d[] f15024b;

    C3891h(C3886c c3886c) {
        this.f15023a = new C3886c(c3886c);
        this.f15024b = new C3887d[((c3886c.m19352d() - c3886c.m19351c()) + 1)];
    }

    final C3887d m19393a(int i) {
        C3887d c = m19397c(i);
        if (c != null) {
            return c;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int b = m19395b(i) - i2;
            if (b >= 0) {
                c = this.f15024b[b];
                if (c != null) {
                    return c;
                }
            }
            b = m19395b(i) + i2;
            if (b < this.f15024b.length) {
                c = this.f15024b[b];
                if (c != null) {
                    return c;
                }
            }
        }
        return null;
    }

    final int m19395b(int i) {
        return i - this.f15023a.m19351c();
    }

    final void m19394a(int i, C3887d c3887d) {
        this.f15024b[m19395b(i)] = c3887d;
    }

    final C3887d m19397c(int i) {
        return this.f15024b[m19395b(i)];
    }

    final C3886c m19392a() {
        return this.f15023a;
    }

    final C3887d[] m19396b() {
        return this.f15024b;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        C3887d[] c3887dArr = this.f15024b;
        int length = c3887dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            C3887d c3887d = c3887dArr[i];
            if (c3887d == null) {
                Object[] objArr = new Object[1];
                i3 = i2 + 1;
                objArr[0] = Integer.valueOf(i2);
                formatter.format("%3d:    |   \n", objArr);
            } else {
                r9 = new Object[3];
                i3 = i2 + 1;
                r9[0] = Integer.valueOf(i2);
                r9[1] = Integer.valueOf(c3887d.m19366h());
                r9[2] = Integer.valueOf(c3887d.m19365g());
                formatter.format("%3d: %3d|%3d\n", r9);
            }
            i++;
            i2 = i3;
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
