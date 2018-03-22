package com.google.zxing.p295e;

import com.google.zxing.C3707k;
import com.google.zxing.C3709a;
import com.google.zxing.C3831l;
import com.google.zxing.C3880e;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import com.google.zxing.p295e.p296a.C3862e;
import com.google.zxing.p295e.p296a.p297a.C3858d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader */
public final class C3873i extends C3856k {
    private final C3856k[] f14953a;

    public C3873i(Map<C3880e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(C3880e.POSSIBLE_FORMATS);
        }
        boolean z = (map == null || map.get(C3880e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(C3709a.EAN_13) || collection.contains(C3709a.UPC_A) || collection.contains(C3709a.EAN_8) || collection.contains(C3709a.UPC_E)) {
                arrayList.add(new C3874j(map));
            }
            if (collection.contains(C3709a.CODE_39)) {
                arrayList.add(new C3866c(z));
            }
            if (collection.contains(C3709a.CODE_93)) {
                arrayList.add(new C3867d());
            }
            if (collection.contains(C3709a.CODE_128)) {
                arrayList.add(new C3865b());
            }
            if (collection.contains(C3709a.ITF)) {
                arrayList.add(new C3872h());
            }
            if (collection.contains(C3709a.CODABAR)) {
                arrayList.add(new C3864a());
            }
            if (collection.contains(C3709a.RSS_14)) {
                arrayList.add(new C3862e());
            }
            if (collection.contains(C3709a.RSS_EXPANDED)) {
                arrayList.add(new C3858d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C3874j(map));
            arrayList.add(new C3866c());
            arrayList.add(new C3864a());
            arrayList.add(new C3867d());
            arrayList.add(new C3865b());
            arrayList.add(new C3872h());
            arrayList.add(new C3862e());
            arrayList.add(new C3858d());
        }
        this.f14953a = (C3856k[]) arrayList.toArray(new C3856k[arrayList.size()]);
    }

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i {
        C3856k[] c3856kArr = this.f14953a;
        int i2 = 0;
        while (i2 < c3856kArr.length) {
            try {
                return c3856kArr[i2].mo4321a(i, c3712a, (Map) map);
            } catch (C3831l e) {
                i2++;
            }
        }
        throw C3932i.m19565a();
    }

    public void mo4302a() {
        for (C3707k a : this.f14953a) {
            a.mo4302a();
        }
    }
}
