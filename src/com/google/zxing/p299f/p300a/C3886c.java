package com.google.zxing.p299f.p300a;

import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3717b;

/* compiled from: BoundingBox */
final class C3886c {
    private C3717b f14994a;
    private C3922o f14995b;
    private C3922o f14996c;
    private C3922o f14997d;
    private C3922o f14998e;
    private int f14999f;
    private int f15000g;
    private int f15001h;
    private int f15002i;

    C3886c(C3717b c3717b, C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4) throws C3932i {
        if (!(c3922o == null && c3922o3 == null) && (!(c3922o2 == null && c3922o4 == null) && ((c3922o == null || c3922o2 != null) && (c3922o3 == null || c3922o4 != null)))) {
            m19346a(c3717b, c3922o, c3922o2, c3922o3, c3922o4);
            return;
        }
        throw C3932i.m19565a();
    }

    C3886c(C3886c c3886c) {
        m19346a(c3886c.f14994a, c3886c.f14995b, c3886c.f14996c, c3886c.f14997d, c3886c.f14998e);
    }

    private void m19346a(C3717b c3717b, C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4) {
        this.f14994a = c3717b;
        this.f14995b = c3922o;
        this.f14996c = c3922o2;
        this.f14997d = c3922o3;
        this.f14998e = c3922o4;
        m19347i();
    }

    static C3886c m19345a(C3886c c3886c, C3886c c3886c2) throws C3932i {
        if (c3886c == null) {
            return c3886c2;
        }
        if (c3886c2 == null) {
            return c3886c;
        }
        return new C3886c(c3886c.f14994a, c3886c.f14995b, c3886c.f14996c, c3886c2.f14997d, c3886c2.f14998e);
    }

    C3886c m19349a(int i, int i2, boolean z) throws C3932i {
        int b;
        C3922o c3922o;
        C3922o c3922o2 = this.f14995b;
        C3922o c3922o3 = this.f14996c;
        C3922o c3922o4 = this.f14997d;
        C3922o c3922o5 = this.f14998e;
        if (i > 0) {
            C3922o c3922o6 = z ? this.f14995b : this.f14997d;
            b = ((int) c3922o6.m19523b()) - i;
            if (b < 0) {
                b = 0;
            }
            c3922o = new C3922o(c3922o6.m19522a(), (float) b);
            if (!z) {
                c3922o4 = c3922o;
                c3922o = c3922o2;
            }
        } else {
            c3922o = c3922o2;
        }
        if (i2 > 0) {
            c3922o6 = z ? this.f14996c : this.f14998e;
            b = ((int) c3922o6.m19523b()) + i2;
            if (b >= this.f14994a.m18720e()) {
                b = this.f14994a.m18720e() - 1;
            }
            c3922o2 = new C3922o(c3922o6.m19522a(), (float) b);
            if (!z) {
                c3922o5 = c3922o2;
                c3922o2 = c3922o3;
            }
        } else {
            c3922o2 = c3922o3;
        }
        m19347i();
        return new C3886c(this.f14994a, c3922o, c3922o2, c3922o4, c3922o5);
    }

    private void m19347i() {
        if (this.f14995b == null) {
            this.f14995b = new C3922o(0.0f, this.f14997d.m19523b());
            this.f14996c = new C3922o(0.0f, this.f14998e.m19523b());
        } else if (this.f14997d == null) {
            this.f14997d = new C3922o((float) (this.f14994a.m18719d() - 1), this.f14995b.m19523b());
            this.f14998e = new C3922o((float) (this.f14994a.m18719d() - 1), this.f14996c.m19523b());
        }
        this.f14999f = (int) Math.min(this.f14995b.m19522a(), this.f14996c.m19522a());
        this.f15000g = (int) Math.max(this.f14997d.m19522a(), this.f14998e.m19522a());
        this.f15001h = (int) Math.min(this.f14995b.m19523b(), this.f14997d.m19523b());
        this.f15002i = (int) Math.max(this.f14996c.m19523b(), this.f14998e.m19523b());
    }

    int m19348a() {
        return this.f14999f;
    }

    int m19350b() {
        return this.f15000g;
    }

    int m19351c() {
        return this.f15001h;
    }

    int m19352d() {
        return this.f15002i;
    }

    C3922o m19353e() {
        return this.f14995b;
    }

    C3922o m19354f() {
        return this.f14997d;
    }

    C3922o m19355g() {
        return this.f14996c;
    }

    C3922o m19356h() {
        return this.f14998e;
    }
}
