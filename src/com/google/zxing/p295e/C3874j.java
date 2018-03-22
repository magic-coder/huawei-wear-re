package com.google.zxing.p295e;

import com.google.zxing.C3707k;
import com.google.zxing.C3709a;
import com.google.zxing.C3831l;
import com.google.zxing.C3880e;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader */
public final class C3874j extends C3856k {
    private final C3868p[] f14954a;

    public C3874j(Map<C3880e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(C3880e.POSSIBLE_FORMATS);
        }
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(C3709a.EAN_13)) {
                arrayList.add(new C3869e());
            } else if (collection.contains(C3709a.UPC_A)) {
                arrayList.add(new C3875l());
            }
            if (collection.contains(C3709a.EAN_8)) {
                arrayList.add(new C3870f());
            }
            if (collection.contains(C3709a.UPC_E)) {
                arrayList.add(new C3879q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C3869e());
            arrayList.add(new C3870f());
            arrayList.add(new C3879q());
        }
        this.f14954a = (C3868p[]) arrayList.toArray(new C3868p[arrayList.size()]);
    }

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i {
        int[] a = C3868p.m19263a(c3712a);
        C3868p[] c3868pArr = this.f14954a;
        int length = c3868pArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                int i3;
                C3934m a2 = c3868pArr[i2].mo4324a(i, c3712a, a, (Map) map);
                if (a2.m19578d() == C3709a.EAN_13 && a2.m19572a().charAt(0) == '0') {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                Collection collection = map == null ? null : (Collection) map.get(C3880e.POSSIBLE_FORMATS);
                if (collection == null || collection.contains(C3709a.UPC_A)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i3 == 0 || r0 == 0) {
                    return a2;
                }
                C3934m c3934m = new C3934m(a2.m19572a().substring(1), a2.m19576b(), a2.m19577c(), C3709a.UPC_A);
                c3934m.m19574a(a2.m19579e());
                return c3934m;
            } catch (C3831l e) {
                i2++;
            }
        }
        throw C3932i.m19565a();
    }

    public void mo4302a() {
        for (C3707k a : this.f14954a) {
            a.mo4302a();
        }
    }
}
