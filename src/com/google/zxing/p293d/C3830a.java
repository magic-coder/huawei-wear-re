package com.google.zxing.p293d;

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
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p293d.p294a.C3829c;
import java.util.Map;

/* compiled from: MaxiCodeReader */
public final class C3830a implements C3707k {
    private static final C3922o[] f14848a = new C3922o[0];
    private final C3829c f14849b = new C3829c();

    public C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f {
        if (map == null || !map.containsKey(C3880e.PURE_BARCODE)) {
            throw C3932i.m19565a();
        }
        C3720e a = this.f14849b.m19104a(C3830a.m19105a(c3740c.m18821c()), map);
        C3934m c3934m = new C3934m(a.m18729b(), a.m18728a(), f14848a, C3709a.MAXICODE);
        String d = a.m18732d();
        if (d != null) {
            c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, d);
        }
        return c3934m;
    }

    public void mo4302a() {
    }

    private static C3717b m19105a(C3717b c3717b) throws C3932i {
        int[] a = c3717b.m18713a();
        if (a == null) {
            throw C3932i.m19565a();
        }
        int i = a[0];
        int i2 = a[1];
        int i3 = a[2];
        int i4 = a[3];
        C3717b c3717b2 = new C3717b(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = i2 + (((i5 * i4) + (i4 / 2)) / 33);
            for (int i7 = 0; i7 < 30; i7++) {
                if (c3717b.m18712a(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    c3717b2.m18714b(i7, i5);
                }
            }
        }
        return c3717b2;
    }
}
