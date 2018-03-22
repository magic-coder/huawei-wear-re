package com.google.zxing.p282c.p283a;

import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3717b;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: BitMatrixParser */
final class C3728a {
    private final C3717b f14498a;
    private final C3717b f14499b;
    private final C3733f f14500c;

    C3728a(C3717b c3717b) throws C3900f {
        int e = c3717b.m18720e();
        if (e < 8 || e > SyslogAppender.LOG_LOCAL2 || (e & 1) != 0) {
            throw C3900f.m19459a();
        }
        this.f14500c = C3728a.m18764b(c3717b);
        this.f14498a = m18766a(c3717b);
        this.f14499b = new C3717b(this.f14498a.m18719d(), this.f14498a.m18720e());
    }

    C3733f m18767a() {
        return this.f14500c;
    }

    private static C3733f m18764b(C3717b c3717b) throws C3900f {
        return C3733f.m18789a(c3717b.m18720e(), c3717b.m18719d());
    }

    byte[] m18771b() throws C3900f {
        Object obj = null;
        byte[] bArr = new byte[this.f14500c.m18796f()];
        int e = this.f14498a.m18720e();
        int d = this.f14498a.m18719d();
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int i = 0;
        int i2 = 4;
        int i3 = 0;
        while (true) {
            int i4;
            if (i2 == e && i == 0 && r4 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m18765a(e, d);
                int i5 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i5;
                obj4 = 1;
            } else if (i2 == e - 2 && i == 0 && (d & 3) != 0 && r3 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m18769b(e, d);
                int i6 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i6;
                i6 = 1;
            } else if (i2 == e + 4 && i == 2 && (d & 7) == 0 && r2 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m18772c(e, d);
                int i7 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i7;
                i7 = 1;
            } else if (i2 == e - 2 && i == 0 && (d & 7) == 4 && r0 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m18773d(e, d);
                int i8 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i8;
                i8 = 1;
            } else {
                i4 = i;
                int i9 = i2;
                i2 = i3;
                i3 = i9;
                while (true) {
                    if (i3 >= e || i4 < 0 || this.f14499b.m18712a(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) m18770b(i3, i4, e, d);
                    }
                    i3 -= 2;
                    i2 = i4 + 2;
                    if (i3 < 0 || i2 >= d) {
                        i3++;
                        i4 = i2 + 3;
                        i2 = i;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i3++;
                i4 = i2 + 3;
                i2 = i;
                while (true) {
                    if (i3 < 0 || i4 >= d || this.f14499b.m18712a(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) m18770b(i3, i4, e, d);
                    }
                    i3 += 2;
                    i2 = i4 - 2;
                    if (i3 >= e || i2 < 0) {
                        i4 = i3 + 3;
                        i2++;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i4 = i3 + 3;
                i2++;
            }
            if (i4 >= e && i2 >= d) {
                break;
            }
            i3 = i;
            i = i2;
            i2 = i4;
        }
        if (i == this.f14500c.m18796f()) {
            return bArr;
        }
        throw C3900f.m19459a();
    }

    boolean m18768a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0) {
            i5 = i + i3;
            i6 = (4 - ((i3 + 4) & 7)) + i2;
        } else {
            i6 = i2;
            i5 = i;
        }
        if (i6 < 0) {
            i6 += i4;
            i5 += 4 - ((i4 + 4) & 7);
        }
        this.f14499b.m18714b(i6, i5);
        return this.f14498a.m18712a(i6, i5);
    }

    int m18770b(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (m18768a(i - 2, i2 - 2, i3, i4)) {
            i5 = 1;
        }
        i5 <<= 1;
        if (m18768a(i - 2, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m18768a(i - 1, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m18768a(i - 1, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m18768a(i - 1, i2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m18768a(i, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m18768a(i, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m18768a(i, i2, i3, i4)) {
            return i5 | 1;
        }
        return i5;
    }

    int m18765a(int i, int i2) {
        int i3;
        if (m18768a(i - 1, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (m18768a(i - 1, 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(i - 1, 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(3, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    int m18769b(int i, int i2) {
        int i3;
        if (m18768a(i - 3, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (m18768a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(1, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    int m18772c(int i, int i2) {
        int i3;
        if (m18768a(i - 1, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (m18768a(i - 1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(1, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(1, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(1, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    int m18773d(int i, int i2) {
        int i3;
        if (m18768a(i - 3, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (m18768a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m18768a(3, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    C3717b m18766a(C3717b c3717b) {
        int b = this.f14500c.m18792b();
        int c = this.f14500c.m18793c();
        if (c3717b.m18720e() != b) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int d = this.f14500c.m18794d();
        int e = this.f14500c.m18795e();
        int i = b / d;
        int i2 = c / e;
        C3717b c3717b2 = new C3717b(i2 * e, i * d);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * d;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * e;
                for (c = 0; c < d; c++) {
                    int i7 = (((d + 2) * i3) + 1) + c;
                    int i8 = i4 + c;
                    for (b = 0; b < e; b++) {
                        if (c3717b.m18712a((((e + 2) * i5) + 1) + b, i7)) {
                            c3717b2.m18714b(i6 + b, i8);
                        }
                    }
                }
            }
        }
        return c3717b2;
    }
}
