package com.google.zxing.p299f;

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
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p299f.p300a.C3894k;
import com.google.zxing.p299f.p302b.C3896a;
import com.google.zxing.p299f.p302b.C3897b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: PDF417Reader */
public final class C3898b implements C3707k {
    public C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i, C3900f, C3832d {
        C3934m[] a = C3898b.m19450a(c3740c, map, false);
        if (a != null && a.length != 0 && a[0] != null) {
            return a[0];
        }
        throw C3932i.m19565a();
    }

    private static C3934m[] m19450a(C3740c c3740c, Map<C3880e, ?> map, boolean z) throws C3932i, C3900f, C3832d {
        List arrayList = new ArrayList();
        C3897b a = C3896a.m19439a(c3740c, (Map) map, z);
        for (C3922o[] c3922oArr : a.m19447b()) {
            C3720e a2 = C3894k.m19415a(a.m19446a(), c3922oArr[4], c3922oArr[5], c3922oArr[6], c3922oArr[7], C3898b.m19452b(c3922oArr), C3898b.m19449a(c3922oArr));
            C3934m c3934m = new C3934m(a2.m18729b(), a2.m18728a(), c3922oArr, C3709a.PDF_417);
            c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, a2.m18732d());
            C3899c c3899c = (C3899c) a2.m18733e();
            if (c3899c != null) {
                c3934m.m19573a(C3935n.PDF417_EXTRA_METADATA, c3899c);
            }
            arrayList.add(c3934m);
        }
        return (C3934m[]) arrayList.toArray(new C3934m[arrayList.size()]);
    }

    private static int m19448a(C3922o c3922o, C3922o c3922o2) {
        if (c3922o == null || c3922o2 == null) {
            return 0;
        }
        return (int) Math.abs(c3922o.m19522a() - c3922o2.m19522a());
    }

    private static int m19451b(C3922o c3922o, C3922o c3922o2) {
        if (c3922o == null || c3922o2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(c3922o.m19522a() - c3922o2.m19522a());
    }

    private static int m19449a(C3922o[] c3922oArr) {
        return Math.max(Math.max(C3898b.m19448a(c3922oArr[0], c3922oArr[4]), (C3898b.m19448a(c3922oArr[6], c3922oArr[2]) * 17) / 18), Math.max(C3898b.m19448a(c3922oArr[1], c3922oArr[5]), (C3898b.m19448a(c3922oArr[7], c3922oArr[3]) * 17) / 18));
    }

    private static int m19452b(C3922o[] c3922oArr) {
        return Math.min(Math.min(C3898b.m19451b(c3922oArr[0], c3922oArr[4]), (C3898b.m19451b(c3922oArr[6], c3922oArr[2]) * 17) / 18), Math.min(C3898b.m19451b(c3922oArr[1], c3922oArr[5]), (C3898b.m19451b(c3922oArr[7], c3922oArr[3]) * 17) / 18));
    }

    public void mo4302a() {
    }
}
