package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;

/* compiled from: AI013x0x1xDecoder */
final class C3841e extends C3835i {
    private final String f14853a;
    private final String f14854b;

    C3841e(C3712a c3712a, String str, String str2) {
        super(c3712a);
        this.f14853a = str2;
        this.f14854b = str;
    }

    public String mo4319a() throws C3932i {
        if (m19111b().m18676a() != 84) {
            throw C3932i.m19565a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        m19115b(stringBuilder, 8);
        m19118b(stringBuilder, 48, 20);
        m19126c(stringBuilder, 68);
        return stringBuilder.toString();
    }

    private void m19126c(StringBuilder stringBuilder, int i) {
        int a = m19112c().m19169a(i, 16);
        if (a != 38400) {
            stringBuilder.append('(');
            stringBuilder.append(this.f14853a);
            stringBuilder.append(')');
            int i2 = a % 32;
            a /= 32;
            int i3 = (a % 12) + 1;
            a /= 12;
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
            if (i3 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i3);
            if (i2 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i2);
        }
    }

    protected void mo4318a(StringBuilder stringBuilder, int i) {
        int i2 = i / 100000;
        stringBuilder.append('(');
        stringBuilder.append(this.f14854b);
        stringBuilder.append(i2);
        stringBuilder.append(')');
    }

    protected int mo4320a(int i) {
        return i % 100000;
    }
}
