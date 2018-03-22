package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.C3900f;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;

/* compiled from: AI01392xDecoder */
final class C3839c extends C3834h {
    C3839c(C3712a c3712a) {
        super(c3712a);
    }

    public String mo4319a() throws C3932i, C3900f {
        if (m19111b().m18676a() < 48) {
            throw C3932i.m19565a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        m19115b(stringBuilder, 8);
        int a = m19112c().m19169a(48, 2);
        stringBuilder.append("(392");
        stringBuilder.append(a);
        stringBuilder.append(')');
        stringBuilder.append(m19112c().m19170a(50, null).m19145a());
        return stringBuilder.toString();
    }
}
