package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.p278b.C3712a;

/* compiled from: AI01320xDecoder */
final class C3838b extends C3836f {
    C3838b(C3712a c3712a) {
        super(c3712a);
    }

    protected void mo4318a(StringBuilder stringBuilder, int i) {
        if (i < 10000) {
            stringBuilder.append("(3202)");
        } else {
            stringBuilder.append("(3203)");
        }
    }

    protected int mo4320a(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
