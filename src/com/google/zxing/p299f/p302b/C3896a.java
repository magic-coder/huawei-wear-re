package com.google.zxing.p299f.p302b;

import com.google.zxing.C3740c;
import com.google.zxing.C3880e;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;
import com.google.zxing.p278b.C3717b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Detector */
public final class C3896a {
    private static final int[] f15031a;
    private static final int[] f15032b = new int[]{6, 2, 7, 3};
    private static final int[] f15033c = new int[]{8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] f15034d = new int[]{7, 1, 1, 3, 1, 1, 1, 2, 1};

    static {
        int[] iArr = new int[4];
        iArr[1] = 4;
        iArr[2] = 1;
        iArr[3] = 5;
        f15031a = iArr;
    }

    public static C3897b m19439a(C3740c c3740c, Map<C3880e, ?> map, boolean z) throws C3932i {
        C3717b c = c3740c.m18821c();
        List a = C3896a.m19440a(z, c);
        if (a.isEmpty()) {
            C3896a.m19441a(c);
            a = C3896a.m19440a(z, c);
        }
        return new C3897b(c, a);
    }

    private static List<C3922o[]> m19440a(boolean z, C3717b c3717b) {
        List<C3922o[]> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < c3717b.m18720e()) {
            Object a = C3896a.m19444a(c3717b, i3, i2);
            if (a[0] == null && a[3] == null) {
                if (i == 0) {
                    break;
                }
                for (C3922o[] c3922oArr : arrayList) {
                    if (c3922oArr[1] != null) {
                        i3 = (int) Math.max((float) i3, c3922oArr[1].m19523b());
                    }
                    if (c3922oArr[3] != null) {
                        i3 = Math.max(i3, (int) c3922oArr[3].m19523b());
                    }
                }
                i2 = 0;
                i3 += 5;
                i = 0;
            } else {
                arrayList.add(a);
                if (!z) {
                    break;
                } else if (a[2] != null) {
                    i3 = (int) a[2].m19523b();
                    i2 = (int) a[2].m19522a();
                    i = 1;
                } else {
                    i3 = (int) a[4].m19523b();
                    i2 = (int) a[4].m19522a();
                    i = 1;
                }
            }
        }
        return arrayList;
    }

    static void m19441a(C3717b c3717b) {
        int d = c3717b.m18719d();
        int e = c3717b.m18720e();
        C3712a c3712a = new C3712a(d);
        C3712a c3712a2 = new C3712a(d);
        C3712a c3712a3 = new C3712a(d);
        for (d = 0; d < ((e + 1) >> 1); d++) {
            c3712a = c3717b.m18710a(d, c3712a);
            c3717b.m18715b(d, C3896a.m19438a(c3717b.m18710a((e - 1) - d, c3712a2), c3712a3));
            c3717b.m18715b((e - 1) - d, C3896a.m19438a(c3712a, c3712a3));
        }
    }

    static C3712a m19438a(C3712a c3712a, C3712a c3712a2) {
        c3712a2.m18680b();
        int a = c3712a.m18676a();
        for (int i = 0; i < a; i++) {
            if (c3712a.m18678a(i)) {
                c3712a2.m18681b((a - 1) - i);
            }
        }
        return c3712a2;
    }

    private static C3922o[] m19444a(C3717b c3717b, int i, int i2) {
        int a;
        int b;
        int e = c3717b.m18720e();
        int d = c3717b.m18719d();
        C3922o[] c3922oArr = new C3922o[8];
        C3896a.m19442a(c3922oArr, C3896a.m19445a(c3717b, e, d, i, i2, f15033c), f15031a);
        if (c3922oArr[4] != null) {
            a = (int) c3922oArr[4].m19522a();
            b = (int) c3922oArr[4].m19523b();
        } else {
            a = i2;
            b = i;
        }
        C3896a.m19442a(c3922oArr, C3896a.m19445a(c3717b, e, d, b, a, f15034d), f15032b);
        return c3922oArr;
    }

    private static void m19442a(C3922o[] c3922oArr, C3922o[] c3922oArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            c3922oArr[iArr[i]] = c3922oArr2[i];
        }
    }

    private static C3922o[] m19445a(C3717b c3717b, int i, int i2, int i3, int i4, int[] iArr) {
        int[] iArr2;
        int i5;
        Object obj;
        int i6;
        int i7;
        C3922o[] c3922oArr = new C3922o[4];
        int[] iArr3 = new int[iArr.length];
        int i8 = i3;
        while (i8 < i) {
            int[] a = C3896a.m19443a(c3717b, i4, i8, i2, false, iArr, iArr3);
            int i9;
            if (a != null) {
                iArr2 = a;
                i5 = i8;
                while (i5 > 0) {
                    i8 = i5 - 1;
                    a = C3896a.m19443a(c3717b, i4, i8, i2, false, iArr, iArr3);
                    if (a == null) {
                        i5 = i8 + 1;
                        break;
                    }
                    iArr2 = a;
                    i5 = i8;
                }
                c3922oArr[0] = new C3922o((float) iArr2[0], (float) i5);
                c3922oArr[1] = new C3922o((float) iArr2[1], (float) i5);
                obj = 1;
                i6 = i5;
                i5 = i6 + 1;
                if (obj != null) {
                    iArr2 = new int[]{(int) c3922oArr[0].m19522a(), (int) c3922oArr[1].m19522a()};
                    i7 = 0;
                    i8 = i5;
                    while (i8 < i) {
                        a = C3896a.m19443a(c3717b, iArr2[0], i8, i2, false, iArr, iArr3);
                        if (a != null || Math.abs(iArr2[0] - a[0]) >= 5 || Math.abs(iArr2[1] - a[1]) >= 5) {
                            if (i7 <= 25) {
                                break;
                            }
                            i9 = i7 + 1;
                            a = iArr2;
                        } else {
                            i9 = 0;
                        }
                        i8++;
                        iArr2 = a;
                        i7 = i9;
                    }
                    i5 = i8 - (i7 + 1);
                    c3922oArr[2] = new C3922o((float) iArr2[0], (float) i5);
                    c3922oArr[3] = new C3922o((float) iArr2[1], (float) i5);
                }
                if (i5 - i6 < 10) {
                    for (i5 = 0; i5 < c3922oArr.length; i5++) {
                        c3922oArr[i5] = null;
                    }
                }
                return c3922oArr;
            }
            i8 += 5;
        }
        obj = null;
        i6 = i8;
        i5 = i6 + 1;
        if (obj != null) {
            iArr2 = new int[]{(int) c3922oArr[0].m19522a(), (int) c3922oArr[1].m19522a()};
            i7 = 0;
            i8 = i5;
            while (i8 < i) {
                a = C3896a.m19443a(c3717b, iArr2[0], i8, i2, false, iArr, iArr3);
                if (a != null) {
                }
                if (i7 <= 25) {
                    break;
                }
                i9 = i7 + 1;
                a = iArr2;
                i8++;
                iArr2 = a;
                i7 = i9;
            }
            i5 = i8 - (i7 + 1);
            c3922oArr[2] = new C3922o((float) iArr2[0], (float) i5);
            c3922oArr[3] = new C3922o((float) iArr2[1], (float) i5);
        }
        if (i5 - i6 < 10) {
            for (i5 = 0; i5 < c3922oArr.length; i5++) {
                c3922oArr[i5] = null;
            }
        }
        return c3922oArr;
    }

    private static int[] m19443a(C3717b c3717b, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        int i4;
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (c3717b.m18712a(i, i2) && i > 0) {
            i4 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i--;
            i5 = i4;
        }
        i5 = 0;
        i4 = i;
        int i6 = z;
        while (i < i3) {
            if ((c3717b.m18712a(i, i2) ^ i6) != 0) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (C3896a.m19437a(iArr2, iArr, 204) < 107) {
                    return new int[]{i4, i};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                i6 = i6 != 0 ? 0 : 1;
            }
            i++;
        }
        if (i5 != length - 1 || C3896a.m19437a(iArr2, iArr, 204) >= 107) {
            return null;
        }
        return new int[]{i4, i - 1};
    }

    private static int m19437a(int[] iArr, int[] iArr2, int i) {
        int i2;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        for (i2 = 0; i2 < length; i2++) {
            i4 += iArr[i2];
            i3 += iArr2[i2];
        }
        if (i4 < i3) {
            return Integer.MAX_VALUE;
        }
        int i5 = (i4 << 8) / i3;
        int i6 = (i * i5) >> 8;
        i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            int i7 = iArr[i2] << 8;
            int i8 = iArr2[i2] * i5;
            i7 = i7 > i8 ? i7 - i8 : i8 - i7;
            if (i7 > i6) {
                return Integer.MAX_VALUE;
            }
            i3 += i7;
        }
        return i3 / i4;
    }
}
