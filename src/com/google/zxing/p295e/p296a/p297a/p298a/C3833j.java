package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.C3900f;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;

/* compiled from: AbstractExpandedDecoder */
public abstract class C3833j {
    private final C3712a f14851a;
    private final C3852t f14852b;

    public abstract String mo4319a() throws C3932i, C3900f;

    C3833j(C3712a c3712a) {
        this.f14851a = c3712a;
        this.f14852b = new C3852t(c3712a);
    }

    protected final C3712a m19111b() {
        return this.f14851a;
    }

    protected final C3852t m19112c() {
        return this.f14852b;
    }

    public static C3833j m19109a(C3712a c3712a) {
        if (c3712a.m18678a(1)) {
            return new C3842g(c3712a);
        }
        if (!c3712a.m18678a(2)) {
            return new C3843k(c3712a);
        }
        switch (C3852t.m19155a(c3712a, 1, 4)) {
            case 4:
                return new C3837a(c3712a);
            case 5:
                return new C3838b(c3712a);
            default:
                switch (C3852t.m19155a(c3712a, 1, 5)) {
                    case 12:
                        return new C3839c(c3712a);
                    case 13:
                        return new C3840d(c3712a);
                    default:
                        switch (C3852t.m19155a(c3712a, 1, 7)) {
                            case 56:
                                return new C3841e(c3712a, "310", "11");
                            case 57:
                                return new C3841e(c3712a, "320", "11");
                            case 58:
                                return new C3841e(c3712a, "310", "13");
                            case 59:
                                return new C3841e(c3712a, "320", "13");
                            case 60:
                                return new C3841e(c3712a, "310", "15");
                            case 61:
                                return new C3841e(c3712a, "320", "15");
                            case 62:
                                return new C3841e(c3712a, "310", "17");
                            case 63:
                                return new C3841e(c3712a, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: " + c3712a);
                        }
                }
        }
    }
}
