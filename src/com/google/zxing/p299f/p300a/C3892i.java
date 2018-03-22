package com.google.zxing.p299f.p300a;

import com.google.zxing.C3922o;

/* compiled from: DetectionResultRowIndicatorColumn */
final class C3892i extends C3891h {
    private final boolean f15025a;

    C3892i(C3886c c3886c, boolean z) {
        super(c3886c);
        this.f15025a = z;
    }

    void m19401c() {
        for (C3887d c3887d : m19396b()) {
            if (c3887d != null) {
                c3887d.m19359b();
            }
        }
    }

    int m19399a(C3884a c3884a) {
        C3887d[] b = m19396b();
        m19401c();
        m19398a(b, c3884a);
        C3886c a = m19392a();
        C3922o e = this.f15025a ? a.m19353e() : a.m19354f();
        C3922o g = this.f15025a ? a.m19355g() : a.m19356h();
        int b2 = m19395b((int) e.m19523b());
        int b3 = m19395b((int) g.m19523b());
        float c = ((float) (b3 - b2)) / ((float) c3884a.m19340c());
        int i = -1;
        int i2 = b2;
        int i3 = 0;
        int i4 = 1;
        while (i2 < b3) {
            if (b[i2] == null) {
                b2 = i3;
                i3 = i4;
                i4 = i;
            } else {
                C3887d c3887d = b[i2];
                b2 = c3887d.m19366h() - i;
                if (b2 == 0) {
                    b2 = i3 + 1;
                    i3 = i4;
                    i4 = i;
                } else if (b2 == 1) {
                    b2 = Math.max(i4, i3);
                    i4 = c3887d.m19366h();
                    i3 = b2;
                    b2 = 1;
                } else if (b2 < 0 || c3887d.m19366h() >= c3884a.m19340c() || b2 > i2) {
                    b[i2] = null;
                    b2 = i3;
                    i3 = i4;
                    i4 = i;
                } else {
                    int i5;
                    Object obj;
                    if (i4 > 2) {
                        i5 = b2 * (i4 - 2);
                    } else {
                        i5 = b2;
                    }
                    if (i5 >= i2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    for (int i6 = 1; i6 <= i5 && obj == null; i6++) {
                        if (b[i2 - i6] != null) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        b[i2] = null;
                        b2 = i3;
                        i3 = i4;
                        i4 = i;
                    } else {
                        i3 = i4;
                        i4 = c3887d.m19366h();
                        b2 = 1;
                    }
                }
            }
            i2++;
            i = i4;
            i4 = i3;
            i3 = b2;
        }
        return (int) (((double) c) + 0.5d);
    }

    int[] m19402d() {
        C3884a e = m19403e();
        if (e == null) {
            return null;
        }
        m19400b(e);
        int[] iArr = new int[e.m19340c()];
        for (C3887d c3887d : m19396b()) {
            if (c3887d != null) {
                int h = c3887d.m19366h();
                iArr[h] = iArr[h] + 1;
            }
        }
        return iArr;
    }

    int m19400b(C3884a c3884a) {
        C3886c a = m19392a();
        C3922o e = this.f15025a ? a.m19353e() : a.m19354f();
        C3922o g = this.f15025a ? a.m19355g() : a.m19356h();
        int b = m19395b((int) e.m19523b());
        int b2 = m19395b((int) g.m19523b());
        float c = ((float) (b2 - b)) / ((float) c3884a.m19340c());
        C3887d[] b3 = m19396b();
        int i = -1;
        b = 0;
        int i2 = 1;
        for (int i3 = b; i3 < b2; i3++) {
            if (b3[i3] != null) {
                C3887d c3887d = b3[i3];
                c3887d.m19359b();
                int h = c3887d.m19366h() - i;
                if (h == 0) {
                    b++;
                } else if (h == 1) {
                    b = Math.max(i2, b);
                    i = c3887d.m19366h();
                    i2 = b;
                    b = 1;
                } else if (c3887d.m19366h() >= c3884a.m19340c()) {
                    b3[i3] = null;
                } else {
                    i = c3887d.m19366h();
                    b = 1;
                }
            }
        }
        return (int) (((double) c) + 0.5d);
    }

    C3884a m19403e() {
        C3887d[] b = m19396b();
        C3885b c3885b = new C3885b();
        C3885b c3885b2 = new C3885b();
        C3885b c3885b3 = new C3885b();
        C3885b c3885b4 = new C3885b();
        for (C3887d c3887d : b) {
            if (c3887d != null) {
                c3887d.m19359b();
                int g = c3887d.m19365g() % 30;
                int h = c3887d.m19366h();
                if (!this.f15025a) {
                    h += 2;
                }
                switch (h % 3) {
                    case 0:
                        c3885b2.m19343a((g * 3) + 1);
                        break;
                    case 1:
                        c3885b4.m19343a(g / 3);
                        c3885b3.m19343a(g % 3);
                        break;
                    case 2:
                        c3885b.m19343a(g + 1);
                        break;
                    default:
                        break;
                }
            }
        }
        if (c3885b.m19344a().length == 0 || c3885b2.m19344a().length == 0 || c3885b3.m19344a().length == 0 || c3885b4.m19344a().length == 0 || c3885b.m19344a()[0] < 1 || c3885b2.m19344a()[0] + c3885b3.m19344a()[0] < 3 || c3885b2.m19344a()[0] + c3885b3.m19344a()[0] > 90) {
            return null;
        }
        C3884a c3884a = new C3884a(c3885b.m19344a()[0], c3885b2.m19344a()[0], c3885b3.m19344a()[0], c3885b4.m19344a()[0]);
        m19398a(b, c3884a);
        return c3884a;
    }

    private void m19398a(C3887d[] c3887dArr, C3884a c3884a) {
        for (int i = 0; i < c3887dArr.length; i++) {
            C3887d c3887d = c3887dArr[i];
            if (c3887dArr[i] != null) {
                int g = c3887d.m19365g() % 30;
                int h = c3887d.m19366h();
                if (h <= c3884a.m19340c()) {
                    if (!this.f15025a) {
                        h += 2;
                    }
                    switch (h % 3) {
                        case 0:
                            if ((g * 3) + 1 == c3884a.m19341d()) {
                                break;
                            }
                            c3887dArr[i] = null;
                            break;
                        case 1:
                            if (g / 3 != c3884a.m19339b() || g % 3 != c3884a.m19342e()) {
                                c3887dArr[i] = null;
                                break;
                            }
                            break;
                            break;
                        case 2:
                            if (g + 1 == c3884a.m19338a()) {
                                break;
                            }
                            c3887dArr[i] = null;
                            break;
                        default:
                            break;
                    }
                }
                c3887dArr[i] = null;
            }
        }
    }

    boolean m19404f() {
        return this.f15025a;
    }

    public String toString() {
        return "IsLeft: " + this.f15025a + '\n' + super.toString();
    }
}
