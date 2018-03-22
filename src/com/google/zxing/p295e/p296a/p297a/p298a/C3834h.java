package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.p278b.C3712a;

/* compiled from: AI01decoder */
abstract class C3834h extends C3833j {
    C3834h(C3712a c3712a) {
        super(c3712a);
    }

    protected final void m19115b(StringBuilder stringBuilder, int i) {
        stringBuilder.append("(01)");
        int length = stringBuilder.length();
        stringBuilder.append('9');
        m19114a(stringBuilder, i, length);
    }

    protected final void m19114a(StringBuilder stringBuilder, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int a = m19112c().m19169a((i3 * 10) + i, 10);
            if (a / 100 == 0) {
                stringBuilder.append('0');
            }
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
        }
        C3834h.mo4318a(stringBuilder, i2);
    }

    private static void mo4318a(StringBuilder stringBuilder, int i) {
        int charAt;
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            charAt = stringBuilder.charAt(i3 + i) - 48;
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        charAt = 10 - (i2 % 10);
        if (charAt == 10) {
            charAt = 0;
        }
        stringBuilder.append(charAt);
    }
}
