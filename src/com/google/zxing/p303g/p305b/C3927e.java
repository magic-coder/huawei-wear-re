package com.google.zxing.p303g.p305b;

import com.google.zxing.C3803p;
import com.google.zxing.C3880e;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3717b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: FinderPatternFinder */
public class C3927e {
    private final C3717b f15104a;
    private final List<C3926d> f15105b = new ArrayList();
    private boolean f15106c;
    private final int[] f15107d = new int[5];
    private final C3803p f15108e;

    public C3927e(C3717b c3717b, C3803p c3803p) {
        this.f15104a = c3717b;
        this.f15108e = c3803p;
    }

    final C3930h m19553a(Map<C3880e, ?> map) throws C3932i {
        int i;
        Object obj = (map == null || !map.containsKey(C3880e.TRY_HARDER)) ? null : 1;
        int e = this.f15104a.m18720e();
        int d = this.f15104a.m18719d();
        int i2 = (e * 3) / 228;
        if (i2 < 3 || obj != null) {
            i = 3;
        } else {
            i = i2;
        }
        boolean z = false;
        int[] iArr = new int[5];
        int i3 = i - 1;
        int i4 = i;
        while (i3 < e && !r3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            i = 0;
            i2 = 0;
            while (i2 < d) {
                if (this.f15104a.m18712a(i2, i3)) {
                    if ((i & 1) == 1) {
                        i++;
                    }
                    iArr[i] = iArr[i] + 1;
                } else if ((i & 1) != 0) {
                    iArr[i] = iArr[i] + 1;
                } else if (i != 4) {
                    i++;
                    iArr[i] = iArr[i] + 1;
                } else if (!C3927e.m19547a(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                } else if (m19554a(iArr, i3, i2)) {
                    int i5;
                    boolean c;
                    i4 = 2;
                    if (this.f15106c) {
                        i5 = i2;
                        i2 = i3;
                        c = m19551c();
                        i = i5;
                    } else {
                        i = m19550b();
                        if (i > iArr[2]) {
                            i2 = i3 + ((i - iArr[2]) - 2);
                            i = d - 1;
                            c = z;
                        } else {
                            i = i2;
                            i2 = i3;
                            c = z;
                        }
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i5 = i;
                    i = 0;
                    z = c;
                    i3 = i2;
                    i2 = i5;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                }
                i2++;
            }
            if (C3927e.m19547a(iArr) && m19554a(iArr, i3, d)) {
                i4 = iArr[0];
                if (this.f15106c) {
                    z = m19551c();
                }
            }
            i3 += i4;
        }
        C3922o[] d2 = m19552d();
        C3922o.m19521a(d2);
        return new C3930h(d2);
    }

    private static float m19546a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean m19547a(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 5; i++) {
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            i2 += i3;
        }
        if (i2 < 7) {
            return false;
        }
        i = (i2 << 8) / 7;
        i2 = i / 2;
        if (Math.abs(i - (iArr[0] << 8)) >= i2 || Math.abs(i - (iArr[1] << 8)) >= i2 || Math.abs((i * 3) - (iArr[2] << 8)) >= i2 * 3 || Math.abs(i - (iArr[3] << 8)) >= i2 || Math.abs(i - (iArr[4] << 8)) >= i2) {
            return false;
        }
        return true;
    }

    private int[] m19548a() {
        this.f15107d[0] = 0;
        this.f15107d[1] = 0;
        this.f15107d[2] = 0;
        this.f15107d[3] = 0;
        this.f15107d[4] = 0;
        return this.f15107d;
    }

    private float m19545a(int i, int i2, int i3, int i4) {
        C3717b c3717b = this.f15104a;
        int e = c3717b.m18720e();
        int[] a = m19548a();
        int i5 = i;
        while (i5 >= 0 && c3717b.m18712a(i2, i5)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c3717b.m18712a(i2, i5) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && c3717b.m18712a(i2, i5) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < e && c3717b.m18712a(i2, i5)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == e) {
            return Float.NaN;
        }
        while (i5 < e && !c3717b.m18712a(i2, i5) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == e || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < e && c3717b.m18712a(i2, i5) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        if (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 * 2 || !C3927e.m19547a(a)) {
            return Float.NaN;
        }
        return C3927e.m19546a(a, i5);
    }

    private float m19549b(int i, int i2, int i3, int i4) {
        C3717b c3717b = this.f15104a;
        int d = c3717b.m18719d();
        int[] a = m19548a();
        int i5 = i;
        while (i5 >= 0 && c3717b.m18712a(i5, i2)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c3717b.m18712a(i5, i2) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && c3717b.m18712a(i5, i2) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < d && c3717b.m18712a(i5, i2)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == d) {
            return Float.NaN;
        }
        while (i5 < d && !c3717b.m18712a(i5, i2) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == d || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < d && c3717b.m18712a(i5, i2) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        if (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 || !C3927e.m19547a(a)) {
            return Float.NaN;
        }
        return C3927e.m19546a(a, i5);
    }

    protected final boolean m19554a(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4];
        float a = C3927e.m19546a(iArr, i2);
        float a2 = m19545a(i, (int) a, iArr[2], i3);
        if (Float.isNaN(a2)) {
            return false;
        }
        float b = m19549b((int) a, (int) a2, iArr[2], i3);
        if (Float.isNaN(b)) {
            return false;
        }
        float f = ((float) i3) / 7.0f;
        for (int i4 = 0; i4 < this.f15105b.size(); i4++) {
            C3926d c3926d = (C3926d) this.f15105b.get(i4);
            if (c3926d.m19541a(f, a2, b)) {
                this.f15105b.set(i4, c3926d.m19542b(a2, b, f));
                z = true;
                break;
            }
        }
        if (!z) {
            C3922o c3926d2 = new C3926d(b, a2, f);
            this.f15105b.add(c3926d2);
            if (this.f15108e != null) {
                this.f15108e.mo4312a(c3926d2);
            }
        }
        return true;
    }

    private int m19550b() {
        if (this.f15105b.size() <= 1) {
            return 0;
        }
        C3922o c3922o = null;
        for (C3922o c3922o2 : this.f15105b) {
            if (c3922o2.m19544d() >= 2) {
                if (c3922o == null) {
                    c3922o = c3922o2;
                } else {
                    this.f15106c = true;
                    return ((int) (Math.abs(c3922o.m19522a() - c3922o2.m19522a()) - Math.abs(c3922o.m19523b() - c3922o2.m19523b()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean m19551c() {
        float f = 0.0f;
        int size = this.f15105b.size();
        float f2 = 0.0f;
        int i = 0;
        for (C3926d c3926d : this.f15105b) {
            if (c3926d.m19544d() >= 2) {
                i++;
                f2 = c3926d.m19543c() + f2;
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (C3926d c3926d2 : this.f15105b) {
            f += Math.abs(c3926d2.m19543c() - f3);
        }
        if (f <= 0.05f * f2) {
            return true;
        }
        return false;
    }

    private C3926d[] m19552d() throws C3932i {
        float f = 0.0f;
        int size = this.f15105b.size();
        if (size < 3) {
            throw C3932i.m19565a();
        }
        if (size > 3) {
            float c;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (C3926d c2 : this.f15105b) {
                c = c2.m19543c();
                f3 += c;
                f2 = (c * c) + f2;
            }
            f3 /= (float) size;
            c = (float) Math.sqrt((double) ((f2 / ((float) size)) - (f3 * f3)));
            Collections.sort(this.f15105b, new C3929g(f3));
            float max = Math.max(0.2f * f3, c);
            int i = 0;
            while (i < this.f15105b.size() && this.f15105b.size() > 3) {
                if (Math.abs(((C3926d) this.f15105b.get(i)).m19543c() - f3) > max) {
                    this.f15105b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.f15105b.size() > 3) {
            for (C3926d c22 : this.f15105b) {
                f += c22.m19543c();
            }
            Collections.sort(this.f15105b, new C3928f(f / ((float) this.f15105b.size())));
            this.f15105b.subList(3, this.f15105b.size()).clear();
        }
        return new C3926d[]{(C3926d) this.f15105b.get(0), (C3926d) this.f15105b.get(1), (C3926d) this.f15105b.get(2)};
    }
}
