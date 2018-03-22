package com.google.zxing.p303g;

import com.google.zxing.C3707k;
import com.google.zxing.C3709a;
import com.google.zxing.C3740c;
import com.google.zxing.C3832d;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.C3935n;
import com.google.zxing.p278b.C3703g;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p303g.p304a.C3913m;
import com.google.zxing.p303g.p304a.C3917q;
import com.google.zxing.p303g.p305b.C3925c;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeReader */
public class C3921a implements C3707k {
    private static final C3922o[] f15086a = new C3922o[0];
    private final C3913m f15087b = new C3913m();

    public final C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f {
        C3720e a;
        C3922o[] e;
        if (map == null || !map.containsKey(C3880e.PURE_BARCODE)) {
            C3703g a2 = new C3925c(c3740c.m18821c()).m19539a((Map) map);
            a = this.f15087b.m19491a(a2.m18638d(), (Map) map);
            e = a2.m18639e();
        } else {
            a = this.f15087b.m19491a(C3921a.m19516a(c3740c.m18821c()), (Map) map);
            e = f15086a;
        }
        if (a.m18733e() instanceof C3917q) {
            ((C3917q) a.m18733e()).m19500a(e);
        }
        C3934m c3934m = new C3934m(a.m18729b(), a.m18728a(), e, C3709a.QR_CODE);
        List c = a.m18731c();
        if (c != null) {
            c3934m.m19573a(C3935n.BYTE_SEGMENTS, c);
        }
        String d = a.m18732d();
        if (d != null) {
            c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, d);
        }
        return c3934m;
    }

    public void mo4302a() {
    }

    private static C3717b m19516a(C3717b c3717b) throws C3932i {
        int[] b = c3717b.m18716b();
        int[] c = c3717b.m18718c();
        if (b == null || c == null) {
            throw C3932i.m19565a();
        }
        float a = C3921a.m19515a(b, c3717b);
        int i = b[1];
        int i2 = c[1];
        int i3 = b[0];
        int i4 = c[0];
        if (i3 >= i4 || i >= i2) {
            throw C3932i.m19565a();
        }
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / a);
        int round2 = Math.round(((float) ((i2 - i) + 1)) / a);
        if (round <= 0 || round2 <= 0) {
            throw C3932i.m19565a();
        } else if (round2 != round) {
            throw C3932i.m19565a();
        } else {
            int i5 = (int) (a / 2.0f);
            int i6 = i + i5;
            i = i3 + i5;
            i4 = (((int) (((float) (round - 1)) * a)) + i) - (i4 - 1);
            if (i4 <= 0) {
                i3 = i;
            } else if (i4 > i5) {
                throw C3932i.m19565a();
            } else {
                i3 = i - i4;
            }
            i4 = (((int) (((float) (round2 - 1)) * a)) + i6) - (i2 - 1);
            if (i4 <= 0) {
                i4 = i6;
            } else if (i4 > i5) {
                throw C3932i.m19565a();
            } else {
                i4 = i6 - i4;
            }
            C3717b c3717b2 = new C3717b(round, round2);
            for (i = 0; i < round2; i++) {
                i5 = i4 + ((int) (((float) i) * a));
                for (i6 = 0; i6 < round; i6++) {
                    if (c3717b.m18712a(((int) (((float) i6) * a)) + i3, i5)) {
                        c3717b2.m18714b(i6, i);
                    }
                }
            }
            return c3717b2;
        }
    }

    private static float m19515a(int[] iArr, C3717b c3717b) throws C3932i {
        int e = c3717b.m18720e();
        int d = c3717b.m18719d();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < d && i2 < e) {
            boolean z2;
            if (z != c3717b.m18712a(i3, i2)) {
                i = i4 + 1;
                if (i == 5) {
                    break;
                }
                boolean z3;
                if (z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                int i5 = i;
                z2 = z3;
                i4 = i5;
            } else {
                z2 = z;
            }
            i3++;
            i2++;
            z = z2;
        }
        if (i3 != d && i2 != e) {
            return ((float) (i3 - iArr[0])) / 7.0f;
        }
        throw C3932i.m19565a();
    }
}
