package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.p278b.C3712a;

/* compiled from: AI01weightDecoder */
abstract class C3835i extends C3834h {
    protected abstract int mo4320a(int i);

    protected abstract void mo4318a(StringBuilder stringBuilder, int i);

    C3835i(C3712a c3712a) {
        super(c3712a);
    }

    protected final void m19118b(StringBuilder stringBuilder, int i, int i2) {
        int a = m19112c().m19169a(i, i2);
        mo4318a(stringBuilder, a);
        int a2 = mo4320a(a);
        int i3 = 100000;
        for (a = 0; a < 5; a++) {
            if (a2 / i3 == 0) {
                stringBuilder.append('0');
            }
            i3 /= 10;
        }
        stringBuilder.append(a2);
    }
}
