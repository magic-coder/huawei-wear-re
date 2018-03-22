package com.google.zxing;

import com.google.zxing.p276a.C3708b;
import com.google.zxing.p282c.C3736a;
import com.google.zxing.p293d.C3830a;
import com.google.zxing.p295e.C3873i;
import com.google.zxing.p299f.C3898b;
import com.google.zxing.p303g.C3921a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader */
public final class C3931h implements C3707k {
    private Map<C3880e, ?> f15114a;
    private C3707k[] f15115b;

    public C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i {
        m19564a((Map) map);
        return m19560b(c3740c);
    }

    public C3934m m19561a(C3740c c3740c) throws C3932i {
        if (this.f15115b == null) {
            m19564a(null);
        }
        return m19560b(c3740c);
    }

    public void m19564a(Map<C3880e, ?> map) {
        Object obj = null;
        this.f15114a = map;
        Object obj2 = (map == null || !map.containsKey(C3880e.TRY_HARDER)) ? null : 1;
        Collection collection = map == null ? null : (Collection) map.get(C3880e.POSSIBLE_FORMATS);
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(C3709a.UPC_A) || collection.contains(C3709a.UPC_E) || collection.contains(C3709a.EAN_13) || collection.contains(C3709a.EAN_8) || collection.contains(C3709a.CODABAR) || collection.contains(C3709a.CODE_39) || collection.contains(C3709a.CODE_93) || collection.contains(C3709a.CODE_128) || collection.contains(C3709a.ITF) || collection.contains(C3709a.RSS_14) || collection.contains(C3709a.RSS_EXPANDED)) {
                int i = 1;
            }
            if (obj != null && obj2 == null) {
                arrayList.add(new C3873i(map));
            }
            if (collection.contains(C3709a.QR_CODE)) {
                arrayList.add(new C3921a());
            }
            if (collection.contains(C3709a.DATA_MATRIX)) {
                arrayList.add(new C3736a());
            }
            if (collection.contains(C3709a.AZTEC)) {
                arrayList.add(new C3708b());
            }
            if (collection.contains(C3709a.PDF_417)) {
                arrayList.add(new C3898b());
            }
            if (collection.contains(C3709a.MAXICODE)) {
                arrayList.add(new C3830a());
            }
            if (!(obj == null || obj2 == null)) {
                arrayList.add(new C3873i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (obj2 == null) {
                arrayList.add(new C3873i(map));
            }
            arrayList.add(new C3921a());
            arrayList.add(new C3736a());
            arrayList.add(new C3708b());
            arrayList.add(new C3898b());
            arrayList.add(new C3830a());
            if (obj2 != null) {
                arrayList.add(new C3873i(map));
            }
        }
        this.f15115b = (C3707k[]) arrayList.toArray(new C3707k[arrayList.size()]);
    }

    public void mo4302a() {
        if (this.f15115b != null) {
            for (C3707k a : this.f15115b) {
                a.mo4302a();
            }
        }
    }

    private C3934m m19560b(C3740c c3740c) throws C3932i {
        if (this.f15115b != null) {
            C3707k[] c3707kArr = this.f15115b;
            int length = c3707kArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return c3707kArr[i].mo4301a(c3740c, this.f15114a);
                } catch (C3831l e) {
                    i++;
                }
            }
        }
        throw C3932i.m19565a();
    }
}
