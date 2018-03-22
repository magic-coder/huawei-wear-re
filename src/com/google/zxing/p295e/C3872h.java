package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import java.util.Map;

/* compiled from: ITFReader */
public final class C3872h extends C3856k {
    static final int[][] f14948a = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private static final int[] f14949b = new int[]{48, 44, 24, 20, 18, 16, 14, 12, 10, 8, 6};
    private static final int[] f14950d = new int[]{1, 1, 1, 1};
    private static final int[] f14951e = new int[]{1, 1, 3};
    private int f14952c = -1;

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3900f, C3932i {
        int[] iArr;
        int i2;
        int[] a = m19286a(c3712a);
        int[] b = m19287b(c3712a);
        StringBuilder stringBuilder = new StringBuilder(20);
        C3872h.m19282a(c3712a, a[1], b[0], stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        if (map != null) {
            iArr = (int[]) map.get(C3880e.ALLOWED_LENGTHS);
        } else {
            iArr = null;
        }
        if (iArr == null) {
            iArr = f14949b;
        }
        int length = stringBuilder2.length();
        for (int i3 : r0) {
            if (length == i3) {
                i2 = 1;
                break;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            throw C3900f.m19459a();
        }
        return new C3934m(stringBuilder2, null, new C3922o[]{new C3922o((float) a[1], (float) i), new C3922o((float) b[0], (float) i)}, C3709a.ITF);
    }

    private static void m19282a(C3712a c3712a, int i, int i2, StringBuilder stringBuilder) throws C3932i {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        int i3 = i;
        while (i3 < i2) {
            int i4;
            C3856k.m19183a(c3712a, i3, iArr);
            for (i4 = 0; i4 < 5; i4++) {
                int i5 = i4 << 1;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            stringBuilder.append((char) (C3872h.m19280a(iArr2) + 48));
            stringBuilder.append((char) (C3872h.m19280a(iArr3) + 48));
            i4 = i3;
            for (int i6 : iArr) {
                i4 += i6;
            }
            i3 = i4;
        }
    }

    int[] m19286a(C3712a c3712a) throws C3932i {
        int[] c = C3872h.m19284c(c3712a, C3872h.m19283c(c3712a), f14950d);
        this.f14952c = (c[1] - c[0]) >> 2;
        m19281a(c3712a, c[0]);
        return c;
    }

    private void m19281a(C3712a c3712a, int i) throws C3932i {
        int i2 = this.f14952c * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i2;
        i2 = i - 1;
        while (i3 > 0 && i2 >= 0 && !c3712a.m18678a(i2)) {
            i3--;
            i2--;
        }
        if (i3 != 0) {
            throw C3932i.m19565a();
        }
    }

    private static int m19283c(C3712a c3712a) throws C3932i {
        int a = c3712a.m18676a();
        int c = c3712a.m18682c(0);
        if (c != a) {
            return c;
        }
        throw C3932i.m19565a();
    }

    int[] m19287b(C3712a c3712a) throws C3932i {
        c3712a.m18685d();
        try {
            int[] c = C3872h.m19284c(c3712a, C3872h.m19283c(c3712a), f14951e);
            m19281a(c3712a, c[0]);
            int i = c[0];
            c[0] = c3712a.m18676a() - c[1];
            c[1] = c3712a.m18676a() - i;
            return c;
        } finally {
            c3712a.m18685d();
        }
    }

    private static int[] m19284c(C3712a c3712a, int i, int[] iArr) throws C3932i {
        int length = iArr.length;
        Object obj = new int[length];
        int a = c3712a.m18676a();
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (i < a) {
            if ((c3712a.m18678a(i) ^ i4) != 0) {
                obj[i3] = obj[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (C3856k.m19182a((int[]) obj, iArr, 199) < 107) {
                    return new int[]{i2, i};
                } else {
                    i2 += obj[0] + obj[1];
                    System.arraycopy(obj, 2, obj, 0, length - 2);
                    obj[length - 2] = null;
                    obj[length - 1] = null;
                    i3--;
                }
                obj[i3] = 1;
                if (i4 != 0) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
            }
            i++;
        }
        throw C3932i.m19565a();
    }

    private static int m19280a(int[] iArr) throws C3932i {
        int i = 107;
        int i2 = -1;
        int length = f14948a.length;
        int i3 = 0;
        while (i3 < length) {
            int a = C3856k.m19182a(iArr, f14948a[i3], 199);
            if (a < i) {
                i2 = i3;
            } else {
                a = i;
            }
            i3++;
            i = a;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw C3932i.m19565a();
    }
}
