package com.google.zxing.p282c.p283a;

import com.google.zxing.C3900f;
import com.snowballtech.business.constant.BusinessCode;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: Version */
public final class C3733f {
    private static final C3733f[] f14517a = C3733f.m18790h();
    private final int f14518b;
    private final int f14519c;
    private final int f14520d;
    private final int f14521e;
    private final int f14522f;
    private final C3735h f14523g;
    private final int f14524h;

    private C3733f(int i, int i2, int i3, int i4, int i5, C3735h c3735h) {
        int i6 = 0;
        this.f14518b = i;
        this.f14519c = i2;
        this.f14520d = i3;
        this.f14521e = i4;
        this.f14522f = i5;
        this.f14523g = c3735h;
        int a = c3735h.m18800a();
        C3734g[] b = c3735h.m18801b();
        int length = b.length;
        int i7 = 0;
        while (i6 < length) {
            C3734g c3734g = b[i6];
            i7 += (c3734g.m18799b() + a) * c3734g.m18798a();
            i6++;
        }
        this.f14524h = i7;
    }

    public int m18791a() {
        return this.f14518b;
    }

    public int m18792b() {
        return this.f14519c;
    }

    public int m18793c() {
        return this.f14520d;
    }

    public int m18794d() {
        return this.f14521e;
    }

    public int m18795e() {
        return this.f14522f;
    }

    public int m18796f() {
        return this.f14524h;
    }

    C3735h m18797g() {
        return this.f14523g;
    }

    public static C3733f m18789a(int i, int i2) throws C3900f {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (C3733f c3733f : f14517a) {
                if (c3733f.f14519c == i && c3733f.f14520d == i2) {
                    return c3733f;
                }
            }
            throw C3900f.m19459a();
        }
        throw C3900f.m19459a();
    }

    public String toString() {
        return String.valueOf(this.f14518b);
    }

    private static C3733f[] m18790h() {
        return new C3733f[]{new C3733f(1, 10, 10, 8, 8, new C3735h(5, new C3734g(1, 3))), new C3733f(2, 12, 12, 10, 10, new C3735h(7, new C3734g(1, 5))), new C3733f(3, 14, 14, 12, 12, new C3735h(10, new C3734g(1, 8))), new C3733f(4, 16, 16, 14, 14, new C3735h(12, new C3734g(1, 12))), new C3733f(5, 18, 18, 16, 16, new C3735h(14, new C3734g(1, 18))), new C3733f(6, 20, 20, 18, 18, new C3735h(18, new C3734g(1, 22))), new C3733f(7, 22, 22, 20, 20, new C3735h(20, new C3734g(1, 30))), new C3733f(8, 24, 24, 22, 22, new C3735h(24, new C3734g(1, 36))), new C3733f(9, 26, 26, 24, 24, new C3735h(28, new C3734g(1, 44))), new C3733f(10, 32, 32, 14, 14, new C3735h(36, new C3734g(1, 62))), new C3733f(11, 36, 36, 16, 16, new C3735h(42, new C3734g(1, 86))), new C3733f(12, 40, 40, 18, 18, new C3735h(48, new C3734g(1, 114))), new C3733f(13, 44, 44, 20, 20, new C3735h(56, new C3734g(1, SyslogAppender.LOG_LOCAL2))), new C3733f(14, 48, 48, 22, 22, new C3735h(68, new C3734g(1, 174))), new C3733f(15, 52, 52, 24, 24, new C3735h(42, new C3734g(2, 102))), new C3733f(16, 64, 64, 14, 14, new C3735h(56, new C3734g(2, 140))), new C3733f(17, 72, 72, 16, 16, new C3735h(36, new C3734g(4, 92))), new C3733f(18, 80, 80, 18, 18, new C3735h(48, new C3734g(4, 114))), new C3733f(19, 88, 88, 20, 20, new C3735h(56, new C3734g(4, SyslogAppender.LOG_LOCAL2))), new C3733f(20, 96, 96, 22, 22, new C3735h(68, new C3734g(4, 174))), new C3733f(21, 104, 104, 24, 24, new C3735h(56, new C3734g(6, SyslogAppender.LOG_LOCAL1))), new C3733f(22, 120, 120, 18, 18, new C3735h(68, new C3734g(6, 175))), new C3733f(23, 132, 132, 20, 20, new C3735h(62, new C3734g(8, 163))), new C3733f(24, SyslogAppender.LOG_LOCAL2, SyslogAppender.LOG_LOCAL2, 22, 22, new C3735h(62, new C3734g(8, BusinessCode.CURRENCY_CODE_RMB), new C3734g(2, 155))), new C3733f(25, 8, 18, 6, 16, new C3735h(7, new C3734g(1, 5))), new C3733f(26, 8, 32, 6, 14, new C3735h(11, new C3734g(1, 10))), new C3733f(27, 12, 26, 10, 24, new C3735h(14, new C3734g(1, 16))), new C3733f(28, 12, 36, 10, 16, new C3735h(18, new C3734g(1, 22))), new C3733f(29, 16, 36, 14, 16, new C3735h(24, new C3734g(1, 32))), new C3733f(30, 16, 48, 14, 22, new C3735h(28, new C3734g(1, 49)))};
    }
}
