package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.C3900f;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.unionpay.tsmservice.data.Constant;

/* compiled from: GeneralAppIdDecoder */
final class C3852t {
    private final C3712a f14875a;
    private final C3845m f14876b = new C3845m();
    private final StringBuilder f14877c = new StringBuilder();

    C3852t(C3712a c3712a) {
        this.f14875a = c3712a;
    }

    String m19171a(StringBuilder stringBuilder, int i) throws C3932i, C3900f {
        String str = null;
        while (true) {
            C3849p a = m19170a(i, str);
            str = C3851s.m19153a(a.m19145a());
            if (str != null) {
                stringBuilder.append(str);
            }
            if (a.m19146b()) {
                str = String.valueOf(a.m19147c());
            } else {
                str = null;
            }
            if (i == a.m19142e()) {
                return stringBuilder.toString();
            }
            i = a.m19142e();
        }
    }

    private boolean m19157a(int i) {
        if (i + 7 <= this.f14875a.m18676a()) {
            for (int i2 = i; i2 < i + 3; i2++) {
                if (this.f14875a.m18678a(i2)) {
                    return true;
                }
            }
            return this.f14875a.m18678a(i + 3);
        } else if (i + 4 <= this.f14875a.m18676a()) {
            return true;
        } else {
            return false;
        }
    }

    private C3850q m19159b(int i) throws C3900f {
        if (i + 7 > this.f14875a.m18676a()) {
            int a = m19169a(i, 4);
            if (a == 0) {
                return new C3850q(this.f14875a.m18676a(), 10, 10);
            }
            return new C3850q(this.f14875a.m18676a(), a - 1, 10);
        }
        int a2 = m19169a(i, 7);
        return new C3850q(i + 7, (a2 - 8) / 11, (a2 - 8) % 11);
    }

    int m19169a(int i, int i2) {
        return C3852t.m19155a(this.f14875a, i, i2);
    }

    static int m19155a(C3712a c3712a, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (c3712a.m18678a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    C3849p m19170a(int i, String str) throws C3900f {
        this.f14877c.setLength(0);
        if (str != null) {
            this.f14877c.append(str);
        }
        this.f14876b.m19135a(i);
        C3849p a = m19156a();
        if (a == null || !a.m19146b()) {
            return new C3849p(this.f14876b.m19134a(), this.f14877c.toString());
        }
        return new C3849p(this.f14876b.m19134a(), this.f14877c.toString(), a.m19147c());
    }

    private C3849p m19156a() throws C3900f {
        C3844l d;
        boolean b;
        do {
            int a = this.f14876b.m19134a();
            if (this.f14876b.m19137b()) {
                d = m19162d();
                b = d.m19133b();
            } else if (this.f14876b.m19138c()) {
                d = m19160c();
                b = d.m19133b();
            } else {
                d = m19158b();
                b = d.m19133b();
            }
            if ((a != this.f14876b.m19134a() ? 1 : null) == null && !b) {
                break;
            }
        } while (!b);
        return d.m19132a();
    }

    private C3844l m19158b() throws C3900f {
        while (m19157a(this.f14876b.m19134a())) {
            C3850q b = m19159b(this.f14876b.m19134a());
            this.f14876b.m19135a(b.m19142e());
            if (b.m19150c()) {
                C3849p c3849p;
                if (b.m19151d()) {
                    c3849p = new C3849p(this.f14876b.m19134a(), this.f14877c.toString());
                } else {
                    c3849p = new C3849p(this.f14876b.m19134a(), this.f14877c.toString(), b.m19149b());
                }
                return new C3844l(c3849p, true);
            }
            this.f14877c.append(b.m19148a());
            if (b.m19151d()) {
                return new C3844l(new C3849p(this.f14876b.m19134a(), this.f14877c.toString()), true);
            }
            this.f14877c.append(b.m19149b());
        }
        if (m19168i(this.f14876b.m19134a())) {
            this.f14876b.m19140e();
            this.f14876b.m19136b(4);
        }
        return new C3844l(false);
    }

    private C3844l m19160c() throws C3900f {
        while (m19161c(this.f14876b.m19134a())) {
            C3848o d = m19163d(this.f14876b.m19134a());
            this.f14876b.m19135a(d.m19142e());
            if (d.m19144b()) {
                return new C3844l(new C3849p(this.f14876b.m19134a(), this.f14877c.toString()), true);
            }
            this.f14877c.append(d.m19143a());
        }
        if (m19167h(this.f14876b.m19134a())) {
            this.f14876b.m19136b(3);
            this.f14876b.m19139d();
        } else if (m19166g(this.f14876b.m19134a())) {
            if (this.f14876b.m19134a() + 5 < this.f14875a.m18676a()) {
                this.f14876b.m19136b(5);
            } else {
                this.f14876b.m19135a(this.f14875a.m18676a());
            }
            this.f14876b.m19140e();
        }
        return new C3844l(false);
    }

    private C3844l m19162d() {
        while (m19164e(this.f14876b.m19134a())) {
            C3848o f = m19165f(this.f14876b.m19134a());
            this.f14876b.m19135a(f.m19142e());
            if (f.m19144b()) {
                return new C3844l(new C3849p(this.f14876b.m19134a(), this.f14877c.toString()), true);
            }
            this.f14877c.append(f.m19143a());
        }
        if (m19167h(this.f14876b.m19134a())) {
            this.f14876b.m19136b(3);
            this.f14876b.m19139d();
        } else if (m19166g(this.f14876b.m19134a())) {
            if (this.f14876b.m19134a() + 5 < this.f14875a.m18676a()) {
                this.f14876b.m19136b(5);
            } else {
                this.f14876b.m19135a(this.f14875a.m18676a());
            }
            this.f14876b.m19141f();
        }
        return new C3844l(false);
    }

    private boolean m19161c(int i) {
        if (i + 5 > this.f14875a.m18676a()) {
            return false;
        }
        int a = m19169a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 7 > this.f14875a.m18676a()) {
            return false;
        }
        a = m19169a(i, 7);
        if (a >= 64 && a < SpecialIssueType.BUG_TYPE_ID_CHARGE) {
            return true;
        }
        if (i + 8 > this.f14875a.m18676a()) {
            return false;
        }
        a = m19169a(i, 8);
        if (a < 232 || a >= 253) {
            return false;
        }
        return true;
    }

    private C3848o m19163d(int i) throws C3900f {
        int a = m19169a(i, 5);
        if (a == 15) {
            return new C3848o(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C3848o(i + 5, (char) ((a + 48) - 5));
        }
        a = m19169a(i, 7);
        if (a >= 64 && a < 90) {
            return new C3848o(i + 7, (char) (a + 1));
        }
        if (a >= 90 && a < SpecialIssueType.BUG_TYPE_ID_CHARGE) {
            return new C3848o(i + 7, (char) (a + 7));
        }
        char c;
        switch (m19169a(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case FitnessSleepType.HW_FITNESS_WAKE /*234*/:
                c = '%';
                break;
            case FitnessSleepType.HW_FITNESS_SLEEP_WRONG /*235*/:
                c = '&';
                break;
            case FitnessSleepType.HW_FITNESS_DREAM /*236*/:
                c = '\'';
                break;
            case FitnessSleepType.HW_FITNESS_NOON /*237*/:
                c = '(';
                break;
            case FitnessSleepType.HW_FITNESS_SLEEP /*238*/:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case Constant.PLAIN_TEXT_MAX_LENGTH /*245*/:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw C3900f.m19459a();
        }
        return new C3848o(i + 8, c);
    }

    private boolean m19164e(int i) {
        if (i + 5 > this.f14875a.m18676a()) {
            return false;
        }
        int a = m19169a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 6 > this.f14875a.m18676a()) {
            return false;
        }
        a = m19169a(i, 6);
        if (a < 16 || a >= 63) {
            return false;
        }
        return true;
    }

    private C3848o m19165f(int i) {
        int a = m19169a(i, 5);
        if (a == 15) {
            return new C3848o(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C3848o(i + 5, (char) ((a + 48) - 5));
        }
        a = m19169a(i, 6);
        if (a >= 32 && a < 58) {
            return new C3848o(i + 6, (char) (a + 33));
        }
        char c;
        switch (a) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + a);
        }
        return new C3848o(i + 6, c);
    }

    private boolean m19166g(int i) {
        if (i + 1 > this.f14875a.m18676a()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 5 && i2 + i < this.f14875a.m18676a()) {
            if (i2 == 2) {
                if (!this.f14875a.m18678a(i + 2)) {
                    return false;
                }
            } else if (this.f14875a.m18678a(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean m19167h(int i) {
        if (i + 3 > this.f14875a.m18676a()) {
            return false;
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.f14875a.m18678a(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean m19168i(int i) {
        if (i + 1 > this.f14875a.m18676a()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 4 && i2 + i < this.f14875a.m18676a()) {
            if (this.f14875a.m18678a(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
