package com.google.zxing.p299f.p300a;

import com.google.zxing.C3832d;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p299f.C3895a;
import com.google.zxing.p299f.p300a.p301a.C3881a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: PDF417ScanningDecoder */
public final class C3894k {
    private static final C3881a f15027a = new C3881a();

    public static C3720e m19415a(C3717b c3717b, C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4, int i, int i2) throws C3932i, C3900f, C3832d {
        C3891h c3891h = null;
        int i3 = 0;
        C3886c c3886c = new C3886c(c3717b, c3922o, c3922o2, c3922o3, c3922o4);
        C3890g c3890g = null;
        C3891h c3891h2 = null;
        while (i3 < 2) {
            C3891h a;
            C3891h a2;
            if (c3922o != null) {
                a = C3894k.m19421a(c3717b, c3886c, c3922o, true, i, i2);
            } else {
                a = c3891h2;
            }
            if (c3922o3 != null) {
                a2 = C3894k.m19421a(c3717b, c3886c, c3922o3, false, i, i2);
            } else {
                a2 = c3891h;
            }
            C3890g a3 = C3894k.m19420a((C3892i) a, (C3892i) a2);
            if (a3 == null) {
                throw C3932i.m19565a();
            } else if (i3 != 0 || a3.m19391e() == null || (a3.m19391e().m19351c() >= c3886c.m19351c() && a3.m19391e().m19352d() <= c3886c.m19352d())) {
                a3.m19386a(c3886c);
                c3891h = a2;
                c3890g = a3;
                c3891h2 = a;
                break;
            } else {
                i3++;
                c3891h = a2;
                c3890g = a3;
                c3886c = a3.m19391e();
                c3891h2 = a;
            }
        }
        int b = c3890g.m19388b() + 1;
        c3890g.m19385a(0, c3891h2);
        c3890g.m19385a(b, c3891h);
        boolean z = c3891h2 != null;
        int i4 = 1;
        int i5 = i2;
        i3 = i;
        while (i4 <= b) {
            int i6 = z ? i4 : b - i4;
            if (c3890g.m19384a(i6) == null) {
                C3891h c3892i;
                if (i6 == 0 || i6 == b) {
                    c3892i = new C3892i(c3886c, i6 == 0);
                } else {
                    c3892i = new C3891h(c3886c);
                }
                c3890g.m19385a(i6, c3892i);
                int c = c3886c.m19351c();
                int i7 = -1;
                while (c <= c3886c.m19352d()) {
                    int i8;
                    int a4 = C3894k.m19411a(c3890g, i6, c, z);
                    if (a4 < 0 || a4 > c3886c.m19350b()) {
                        if (i7 == -1) {
                            i8 = i7;
                            c++;
                            i7 = i8;
                        } else {
                            a4 = i7;
                        }
                    }
                    C3887d a5 = C3894k.m19419a(c3717b, c3886c.m19348a(), c3886c.m19350b(), z, a4, c, i3, i5);
                    if (a5 != null) {
                        c3892i.m19394a(c, a5);
                        i3 = Math.min(i3, a5.m19361c());
                        i5 = Math.max(i5, a5.m19361c());
                        i8 = a4;
                    } else {
                        i8 = i7;
                    }
                    c++;
                    i7 = i8;
                }
            }
            i4++;
        }
        return C3894k.m19416a(c3890g);
    }

    private static C3890g m19420a(C3892i c3892i, C3892i c3892i2) throws C3932i {
        if (c3892i == null && c3892i2 == null) {
            return null;
        }
        C3884a b = C3894k.m19429b(c3892i, c3892i2);
        if (b != null) {
            return new C3890g(b, C3886c.m19345a(C3894k.m19418a(c3892i), C3894k.m19418a(c3892i2)));
        }
        return null;
    }

    private static C3886c m19418a(C3892i c3892i) throws C3932i {
        if (c3892i == null) {
            return null;
        }
        int[] d = c3892i.m19402d();
        if (d == null) {
            return null;
        }
        int length;
        int a = C3894k.m19412a(d);
        int i = 0;
        for (int i2 : d) {
            i += a - i2;
            if (i2 > 0) {
                break;
            }
        }
        C3887d[] b = c3892i.m19396b();
        int i3 = i;
        i = 0;
        while (i3 > 0 && b[i] == null) {
            i3--;
            i++;
        }
        i = 0;
        for (length = d.length - 1; length >= 0; length--) {
            i += a - d[length];
            if (d[length] > 0) {
                break;
            }
        }
        length = i;
        i = b.length - 1;
        while (length > 0 && b[i] == null) {
            length--;
            i--;
        }
        return c3892i.m19392a().m19349a(i3, length, c3892i.m19404f());
    }

    private static int m19412a(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static C3884a m19429b(C3892i c3892i, C3892i c3892i2) {
        if (c3892i == null || c3892i.m19403e() == null) {
            if (c3892i2 == null) {
                return null;
            }
            return c3892i2.m19403e();
        } else if (c3892i2 != null && c3892i2.m19403e() != null) {
            C3884a e = c3892i.m19403e();
            C3884a e2 = c3892i2.m19403e();
            if (e.m19338a() == e2.m19338a() || e.m19339b() == e2.m19339b() || e.m19340c() == e2.m19340c()) {
                return e;
            }
            return null;
        } else if (c3892i != null) {
            return c3892i.m19403e();
        } else {
            return null;
        }
    }

    private static C3892i m19421a(C3717b c3717b, C3886c c3886c, C3922o c3922o, boolean z, int i, int i2) {
        C3892i c3892i = new C3892i(c3886c, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int a = (int) c3922o.m19522a();
            int b = (int) c3922o.m19523b();
            while (b <= c3886c.m19352d() && b >= c3886c.m19351c()) {
                C3887d a2 = C3894k.m19419a(c3717b, 0, c3717b.m18719d(), z, a, b, i, i2);
                if (a2 != null) {
                    c3892i.m19394a(b, a2);
                    if (z) {
                        a = a2.m19362d();
                    } else {
                        a = a2.m19363e();
                    }
                }
                b += i4;
            }
            i3++;
        }
        return c3892i;
    }

    private static void m19422a(C3890g c3890g, C3885b[][] c3885bArr) throws C3932i {
        int[] a = c3885bArr[0][1].m19344a();
        int b = (c3890g.m19388b() * c3890g.m19389c()) - C3894k.m19410a(c3890g.m19390d());
        if (a.length == 0) {
            if (b < 1 || b > 928) {
                throw C3932i.m19565a();
            }
            c3885bArr[0][1].m19343a(b);
        } else if (a[0] != b) {
            c3885bArr[0][1].m19343a(b);
        }
    }

    private static C3720e m19416a(C3890g c3890g) throws C3900f, C3832d, C3932i {
        int i = 0;
        C3885b[][] b = C3894k.m19431b(c3890g);
        C3894k.m19422a(c3890g, b);
        Collection arrayList = new ArrayList();
        int[] iArr = new int[(c3890g.m19389c() * c3890g.m19388b())];
        List arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < c3890g.m19389c(); i2++) {
            for (int i3 = 0; i3 < c3890g.m19388b(); i3++) {
                Object a = b[i2][i3 + 1].m19344a();
                int b2 = (c3890g.m19388b() * i2) + i3;
                if (a.length == 0) {
                    arrayList.add(Integer.valueOf(b2));
                } else if (a.length == 1) {
                    iArr[b2] = a[0];
                } else {
                    arrayList3.add(Integer.valueOf(b2));
                    arrayList2.add(a);
                }
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        while (i < iArr2.length) {
            iArr2[i] = (int[]) arrayList2.get(i);
            i++;
        }
        return C3894k.m19414a(c3890g.m19390d(), iArr, C3895a.m19435a(arrayList), C3895a.m19435a(arrayList3), iArr2);
    }

    private static C3720e m19414a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws C3900f, C3832d {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw C3832d.m19108a();
            }
            for (i2 = 0; i2 < iArr5.length; i2++) {
                iArr[iArr3[i2]] = iArr4[i2][iArr5[i2]];
            }
            try {
                break;
            } catch (C3832d e) {
                if (iArr5.length == 0) {
                    throw C3832d.m19108a();
                }
                for (i2 = 0; i2 < iArr5.length; i2++) {
                    if (iArr5[i2] < iArr4[i2].length - 1) {
                        iArr5[i2] = iArr5[i2] + 1;
                        i2 = i3;
                        break;
                    }
                    iArr5[i2] = 0;
                    if (i2 == iArr5.length - 1) {
                        throw C3832d.m19108a();
                    }
                }
                i2 = i3;
            }
        }
        return C3894k.m19417a(iArr, i, iArr2);
    }

    private static C3885b[][] m19431b(C3890g c3890g) {
        int i;
        int i2;
        C3885b[][] c3885bArr = (C3885b[][]) Array.newInstance(C3885b.class, new int[]{c3890g.m19389c(), c3890g.m19388b() + 2});
        for (i = 0; i < c3885bArr.length; i++) {
            for (i2 = 0; i2 < c3885bArr[i].length; i2++) {
                c3885bArr[i][i2] = new C3885b();
            }
        }
        C3891h[] a = c3890g.m19387a();
        int length = a.length;
        i2 = 0;
        i = -1;
        while (i2 < length) {
            C3891h c3891h = a[i2];
            int i3 = i + 1;
            if (c3891h != null) {
                for (C3887d c3887d : c3891h.m19396b()) {
                    if (!(c3887d == null || c3887d.m19366h() == -1)) {
                        c3885bArr[c3887d.m19366h()][i3].m19343a(c3887d.m19365g());
                    }
                }
            }
            i2++;
            i = i3;
        }
        return c3885bArr;
    }

    private static boolean m19425a(C3890g c3890g, int i) {
        return i >= 0 && i <= c3890g.m19388b() + 1;
    }

    private static int m19411a(C3890g c3890g, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        C3887d c3887d = null;
        if (C3894k.m19425a(c3890g, i - i3)) {
            c3887d = c3890g.m19384a(i - i3).m19397c(i2);
        }
        if (c3887d == null) {
            c3887d = c3890g.m19384a(i).m19393a(i2);
            if (c3887d != null) {
                return z ? c3887d.m19362d() : c3887d.m19363e();
            } else {
                if (C3894k.m19425a(c3890g, i - i3)) {
                    c3887d = c3890g.m19384a(i - i3).m19393a(i2);
                }
                if (c3887d != null) {
                    return z ? c3887d.m19363e() : c3887d.m19362d();
                } else {
                    int i4 = 0;
                    while (C3894k.m19425a(c3890g, i - i3)) {
                        i -= i3;
                        for (C3887d c3887d2 : c3890g.m19384a(i).m19396b()) {
                            if (c3887d2 != null) {
                                return ((i3 * i4) * (c3887d2.m19363e() - c3887d2.m19362d())) + (z ? c3887d2.m19363e() : c3887d2.m19362d());
                            }
                        }
                        i4++;
                    }
                    if (z) {
                        return c3890g.m19391e().m19348a();
                    }
                    return c3890g.m19391e().m19350b();
                }
            }
        } else if (z) {
            return c3887d.m19363e();
        } else {
            return c3887d.m19362d();
        }
    }

    private static C3887d m19419a(C3717b c3717b, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int b = C3894k.m19427b(c3717b, i, i2, z, i3, i4);
        int[] a = C3894k.m19426a(c3717b, i, i2, z, b, i4);
        if (a == null) {
            return null;
        }
        int i7;
        int a2 = C3895a.m19434a(a);
        if (z) {
            i7 = b;
            b += a2;
        } else {
            for (i7 = 0; i7 < (a.length >> 1); i7++) {
                int i8 = a[i7];
                a[i7] = a[(a.length - 1) - i7];
                a[(a.length - 1) - i7] = i8;
            }
            i7 = b - a2;
        }
        if (!C3894k.m19424a(a2, i5, i6)) {
            return null;
        }
        a2 = C3893j.m19405a(a);
        i8 = C3895a.m19433a((long) a2);
        if (i8 == -1) {
            return null;
        }
        return new C3887d(i7, b, C3894k.m19432c(a2), i8);
    }

    private static int[] m19426a(C3717b c3717b, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (((z && i3 < i2) || (!z && i3 >= i)) && i6 < iArr.length) {
                if (c3717b.m18712a(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        if (i6 == iArr.length || (((z && i3 == i2) || (!z && i3 == i)) && i6 == iArr.length - 1)) {
            return iArr;
        }
        return null;
    }

    private static int m19410a(int i) {
        return 2 << i;
    }

    private static int m19427b(C3717b c3717b, int i, int i2, boolean z, int i3, int i4) {
        int i5 = 0;
        int i6 = z ? -1 : 1;
        int i7 = i3;
        while (i5 < 2) {
            int i8 = i7;
            while (true) {
                if (((!z || i8 < i) && (z || i8 >= i2)) || z != c3717b.m18712a(i8, i4)) {
                    i6 = -i6;
                } else if (Math.abs(i3 - i8) > 2) {
                    return i3;
                } else {
                    i8 += i6;
                }
            }
            i6 = -i6;
            i5++;
            z = !z;
            i7 = i8;
        }
        return i7;
    }

    private static boolean m19424a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static C3720e m19417a(int[] iArr, int i, int[] iArr2) throws C3900f, C3832d {
        if (iArr.length == 0) {
            throw C3900f.m19459a();
        }
        int i2 = 1 << (i + 1);
        int a = C3894k.m19413a(iArr, iArr2, i2);
        C3894k.m19423a(iArr, i2);
        C3720e a2 = C3888e.m19370a(iArr, String.valueOf(i));
        a2.m18726a(Integer.valueOf(a));
        a2.m18730b(Integer.valueOf(iArr2.length));
        return a2;
    }

    private static int m19413a(int[] iArr, int[] iArr2, int i) throws C3832d {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f15027a.m19317a(iArr, i, iArr2);
        }
        throw C3832d.m19108a();
    }

    private static void m19423a(int[] iArr, int i) throws C3900f {
        if (iArr.length < 4) {
            throw C3900f.m19459a();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw C3900f.m19459a();
        } else if (i2 != 0) {
        } else {
            if (i < iArr.length) {
                iArr[0] = iArr.length - i;
                return;
            }
            throw C3900f.m19459a();
        }
    }

    private static int[] m19430b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int length = iArr.length - 1;
        while (true) {
            if ((i & 1) != i2) {
                i2 = i & 1;
                length--;
                if (length < 0) {
                    return iArr;
                }
            }
            iArr[length] = iArr[length] + 1;
            i >>= 1;
        }
    }

    private static int m19432c(int i) {
        return C3894k.m19428b(C3894k.m19430b(i));
    }

    private static int m19428b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
