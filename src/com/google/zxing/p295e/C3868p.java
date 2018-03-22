package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3803p;
import com.google.zxing.C3831l;
import com.google.zxing.C3832d;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.C3935n;
import com.google.zxing.p278b.C3712a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader */
public abstract class C3868p extends C3856k {
    static final int[] f14936b = new int[]{1, 1, 1};
    static final int[] f14937c = new int[]{1, 1, 1, 1, 1};
    static final int[][] f14938d = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] f14939e = new int[20][];
    private final StringBuilder f14940a = new StringBuilder(20);
    private final C3878o f14941f = new C3878o();
    private final C3871g f14942g = new C3871g();

    protected abstract int mo4322a(C3712a c3712a, int[] iArr, StringBuilder stringBuilder) throws C3932i;

    abstract C3709a mo4323b();

    static {
        System.arraycopy(f14938d, 0, f14939e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f14938d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f14939e[i] = iArr2;
        }
    }

    protected C3868p() {
    }

    static int[] m19263a(C3712a c3712a) throws C3932i {
        int[] iArr = new int[f14936b.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f14936b.length, 0);
            iArr2 = C3868p.m19265a(c3712a, i, false, f14936b, iArr);
            int i2 = iArr2[0];
            i = iArr2[1];
            int i3 = i2 - (i - i2);
            if (i3 >= 0) {
                z = c3712a.m18679a(i3, i2, false);
            }
        }
        return iArr2;
    }

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f {
        return mo4324a(i, c3712a, C3868p.m19263a(c3712a), (Map) map);
    }

    public C3934m mo4324a(int i, C3712a c3712a, int[] iArr, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f {
        C3803p c3803p;
        if (map == null) {
            c3803p = null;
        } else {
            c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
        }
        if (c3803p != null) {
            c3803p.mo4312a(new C3922o(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder stringBuilder = this.f14940a;
        stringBuilder.setLength(0);
        int a = mo4322a(c3712a, iArr, stringBuilder);
        if (c3803p != null) {
            c3803p.mo4312a(new C3922o((float) a, (float) i));
        }
        int[] a2 = mo4326a(c3712a, a);
        if (c3803p != null) {
            c3803p.mo4312a(new C3922o(((float) (a2[0] + a2[1])) / 2.0f, (float) i));
        }
        int i2 = a2[1];
        int i3 = (i2 - a2[0]) + i2;
        if (i3 >= c3712a.m18676a() || !c3712a.m18679a(i2, i3, false)) {
            throw C3932i.m19565a();
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() < 8) {
            throw C3900f.m19459a();
        } else if (mo4325a(stringBuilder2)) {
            float f = ((float) (iArr[1] + iArr[0])) / 2.0f;
            float f2 = ((float) (a2[1] + a2[0])) / 2.0f;
            C3709a b = mo4323b();
            C3934m c3934m = new C3934m(stringBuilder2, null, new C3922o[]{new C3922o(f, (float) i), new C3922o(f2, (float) i)}, b);
            try {
                C3934m a3 = this.f14941f.m19307a(i, c3712a, a2[1]);
                c3934m.m19573a(C3935n.UPC_EAN_EXTENSION, a3.m19572a());
                c3934m.m19574a(a3.m19579e());
                c3934m.m19575a(a3.m19577c());
            } catch (C3831l e) {
            }
            if (b == C3709a.EAN_13 || b == C3709a.UPC_A) {
                stringBuilder2 = this.f14942g.m19279a(stringBuilder2);
                if (stringBuilder2 != null) {
                    c3934m.m19573a(C3935n.POSSIBLE_COUNTRY, stringBuilder2);
                }
            }
            return c3934m;
        } else {
            throw C3832d.m19108a();
        }
    }

    boolean mo4325a(String str) throws C3832d, C3900f {
        return C3868p.m19262a((CharSequence) str);
    }

    static boolean m19262a(CharSequence charSequence) throws C3900f {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i;
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw C3900f.m19459a();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            length = charSequence.charAt(i) - 48;
            if (length < 0 || length > 9) {
                throw C3900f.m19459a();
            }
            i2 += length;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }

    int[] mo4326a(C3712a c3712a, int i) throws C3932i {
        return C3868p.m19264a(c3712a, i, false, f14936b);
    }

    static int[] m19264a(C3712a c3712a, int i, boolean z, int[] iArr) throws C3932i {
        return C3868p.m19265a(c3712a, i, z, iArr, new int[iArr.length]);
    }

    private static int[] m19265a(C3712a c3712a, int i, boolean z, int[] iArr, int[] iArr2) throws C3932i {
        int length = iArr.length;
        int a = c3712a.m18676a();
        int d = z ? c3712a.m18684d(i) : c3712a.m18682c(i);
        int i2 = 0;
        int i3 = z;
        for (int i4 = d; i4 < a; i4++) {
            if ((c3712a.m18678a(i4) ^ i3) != 0) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else if (C3856k.m19182a(iArr2, iArr, 179) < 122) {
                    return new int[]{d, i4};
                } else {
                    d += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                if (i3 != 0) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
            }
        }
        throw C3932i.m19565a();
    }

    static int m19261a(C3712a c3712a, int[] iArr, int i, int[][] iArr2) throws C3932i {
        C3856k.m19183a(c3712a, i, iArr);
        int i2 = 122;
        int i3 = -1;
        int length = iArr2.length;
        int i4 = 0;
        while (i4 < length) {
            int a = C3856k.m19182a(iArr, iArr2[i4], 179);
            if (a < i2) {
                i3 = i4;
            } else {
                a = i2;
            }
            i4++;
            i2 = a;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw C3932i.m19565a();
    }
}
