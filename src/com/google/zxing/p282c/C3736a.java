package com.google.zxing.p282c;

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
import com.google.zxing.p282c.p283a.C3732e;
import com.google.zxing.p282c.p284b.C3737a;
import java.util.List;
import java.util.Map;

/* compiled from: DataMatrixReader */
public final class C3736a implements C3707k {
    private static final C3922o[] f14529a = new C3922o[0];
    private final C3732e f14530b = new C3732e();

    public C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f {
        C3720e a;
        C3922o[] e;
        if (map == null || !map.containsKey(C3880e.PURE_BARCODE)) {
            C3703g a2 = new C3737a(c3740c.m18821c()).m18813a();
            a = this.f14530b.m18788a(a2.m18638d());
            e = a2.m18639e();
        } else {
            a = this.f14530b.m18788a(C3736a.m18803a(c3740c.m18821c()));
            e = f14529a;
        }
        C3934m c3934m = new C3934m(a.m18729b(), a.m18728a(), e, C3709a.DATA_MATRIX);
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

    private static C3717b m18803a(C3717b c3717b) throws C3932i {
        int[] b = c3717b.m18716b();
        int[] c = c3717b.m18718c();
        if (b == null || c == null) {
            throw C3932i.m19565a();
        }
        int a = C3736a.m18802a(b, c3717b);
        int i = b[1];
        int i2 = c[1];
        int i3 = b[0];
        int i4 = ((c[0] - i3) + 1) / a;
        i2 = ((i2 - i) + 1) / a;
        if (i4 <= 0 || i2 <= 0) {
            throw C3932i.m19565a();
        }
        int i5 = a >> 1;
        i += i5;
        int i6 = i3 + i5;
        C3717b c3717b2 = new C3717b(i4, i2);
        for (i5 = 0; i5 < i2; i5++) {
            int i7 = i + (i5 * a);
            for (i3 = 0; i3 < i4; i3++) {
                if (c3717b.m18712a((i3 * a) + i6, i7)) {
                    c3717b2.m18714b(i3, i5);
                }
            }
        }
        return c3717b2;
    }

    private static int m18802a(int[] iArr, C3717b c3717b) throws C3932i {
        int d = c3717b.m18719d();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < d && c3717b.m18712a(i, i2)) {
            i++;
        }
        if (i == d) {
            throw C3932i.m19565a();
        }
        i -= iArr[0];
        if (i != 0) {
            return i;
        }
        throw C3932i.m19565a();
    }
}
