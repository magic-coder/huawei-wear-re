package com.google.zxing.p276a.p279b;

import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p276a.C3704a;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3721i;
import com.google.zxing.p278b.p280a.C3710a;
import com.google.zxing.p278b.p280a.C3711b;
import com.google.zxing.p278b.p281b.C3713a;
import com.google.zxing.p278b.p281b.C3715c;
import com.google.zxing.p278b.p281b.C3716d;

/* compiled from: Detector */
public final class C3705a {
    private static final int[] f14380g = new int[]{3808, 476, 2107, 1799};
    private final C3717b f14381a;
    private boolean f14382b;
    private int f14383c;
    private int f14384d;
    private int f14385e;
    private int f14386f;

    public C3705a(C3717b c3717b) {
        this.f14381a = c3717b;
    }

    public C3704a m18660a(boolean z) throws C3932i {
        C3922o[] a = m18655a(m18648a());
        if (z) {
            C3922o c3922o = a[0];
            a[0] = a[2];
            a[2] = c3922o;
        }
        m18651a(a);
        return new C3704a(m18650a(this.f14381a, a[this.f14386f % 4], a[(this.f14386f + 1) % 4], a[(this.f14386f + 2) % 4], a[(this.f14386f + 3) % 4]), m18659b(a), this.f14382b, this.f14384d, this.f14383c);
    }

    private void m18651a(C3922o[] c3922oArr) throws C3932i {
        if (m18654a(c3922oArr[0]) && m18654a(c3922oArr[1]) && m18654a(c3922oArr[2]) && m18654a(c3922oArr[3])) {
            int[] iArr = new int[]{m18646a(c3922oArr[0], c3922oArr[1], r1), m18646a(c3922oArr[1], c3922oArr[2], r1), m18646a(c3922oArr[2], c3922oArr[3], r1), m18646a(c3922oArr[3], c3922oArr[0], this.f14385e * 2)};
            this.f14386f = C3705a.m18647a(iArr, this.f14385e * 2);
            long j = 0;
            for (int i = 0; i < 4; i++) {
                int i2 = iArr[(this.f14386f + i) % 4];
                if (this.f14382b) {
                    j = (j << 7) + ((long) ((i2 >> 1) & 127));
                } else {
                    j = (j << 10) + ((long) (((i2 >> 1) & 31) + ((i2 >> 2) & 992)));
                }
            }
            int a = C3705a.m18644a(j, this.f14382b);
            if (this.f14382b) {
                this.f14383c = (a >> 6) + 1;
                this.f14384d = (a & 63) + 1;
                return;
            }
            this.f14383c = (a >> 11) + 1;
            this.f14384d = (a & 2047) + 1;
            return;
        }
        throw C3932i.m19565a();
    }

    private static int m18647a(int[] iArr, int i) throws C3932i {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += (i4 & 1) + ((i4 >> (i - 2)) << 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        while (i2 < 4) {
            if (Integer.bitCount(f14380g[i2] ^ i5) <= 2) {
                return i2;
            }
            i2++;
        }
        throw C3932i.m19565a();
    }

    private static int m18644a(long j, boolean z) throws C3932i {
        int i;
        int i2;
        int i3 = 0;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i4 = i - i2;
        int[] iArr = new int[i];
        for (i--; i >= 0; i--) {
            iArr[i] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new C3715c(C3713a.f14419d).m18709a(iArr, i4);
            for (int i5 = 0; i5 < i2; i5++) {
                i3 = iArr[i5] + (i3 << 4);
            }
            return i3;
        } catch (C3716d e) {
            throw C3932i.m19565a();
        }
    }

    private C3922o[] m18655a(C3706b c3706b) throws C3932i {
        boolean z = true;
        this.f14385e = 1;
        C3706b c3706b2 = c3706b;
        C3706b c3706b3 = c3706b;
        C3706b c3706b4 = c3706b;
        while (this.f14385e < 9) {
            C3706b a = m18649a(c3706b4, z, 1, -1);
            C3706b a2 = m18649a(c3706b3, z, 1, 1);
            C3706b a3 = m18649a(c3706b2, z, -1, 1);
            C3706b a4 = m18649a(c3706b, z, -1, -1);
            if (this.f14385e > 2) {
                float b = (C3705a.m18657b(a4, a) * ((float) this.f14385e)) / (C3705a.m18657b(c3706b, c3706b4) * ((float) (this.f14385e + 2)));
                if (((double) b) >= 0.75d) {
                    if (((double) b) <= 1.25d) {
                        if (!m18653a(a, a2, a3, a4)) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            if (z) {
                z = false;
            } else {
                z = true;
            }
            this.f14385e++;
            c3706b = a4;
            c3706b2 = a3;
            c3706b3 = a2;
            c3706b4 = a;
        }
        if (this.f14385e == 5 || this.f14385e == 7) {
            this.f14382b = this.f14385e == 5;
            C3922o c3922o = new C3922o(((float) c3706b4.m18662b()) + 0.5f, ((float) c3706b4.m18663c()) - 0.5f);
            C3922o c3922o2 = new C3922o(((float) c3706b3.m18662b()) + 0.5f, ((float) c3706b3.m18663c()) + 0.5f);
            C3922o c3922o3 = new C3922o(((float) c3706b2.m18662b()) - 0.5f, ((float) c3706b2.m18663c()) + 0.5f);
            C3922o c3922o4 = new C3922o(((float) c3706b.m18662b()) - 0.5f, ((float) c3706b.m18663c()) - 0.5f);
            return C3705a.m18656a(new C3922o[]{c3922o, c3922o2, c3922o3, c3922o4}, (float) ((this.f14385e * 2) - 3), (float) (this.f14385e * 2));
        }
        throw C3932i.m19565a();
    }

    private C3706b m18648a() {
        C3922o c3922o;
        C3922o c3922o2;
        C3922o c3922o3;
        C3922o c3922o4;
        int d;
        int e;
        try {
            C3922o[] a = new C3711b(this.f14381a).m18674a();
            c3922o = a[0];
            c3922o2 = a[1];
            c3922o3 = a[2];
            c3922o4 = a[3];
        } catch (C3932i e2) {
            d = this.f14381a.m18719d() / 2;
            e = this.f14381a.m18720e() / 2;
            c3922o = m18649a(new C3706b(d + 7, e - 7), false, 1, -1).m18661a();
            c3922o2 = m18649a(new C3706b(d + 7, e + 7), false, 1, 1).m18661a();
            c3922o3 = m18649a(new C3706b(d - 7, e + 7), false, -1, 1).m18661a();
            c3922o4 = m18649a(new C3706b(d - 7, e - 7), false, -1, -1).m18661a();
        }
        e = C3710a.m18670a((((c3922o.m19522a() + c3922o4.m19522a()) + c3922o2.m19522a()) + c3922o3.m19522a()) / 4.0f);
        d = C3710a.m18670a((((c3922o4.m19523b() + c3922o.m19523b()) + c3922o2.m19523b()) + c3922o3.m19523b()) / 4.0f);
        try {
            C3922o[] a2 = new C3711b(this.f14381a, 15, e, d).m18674a();
            c3922o = a2[0];
            c3922o2 = a2[1];
            c3922o3 = a2[2];
            c3922o4 = a2[3];
        } catch (C3932i e3) {
            c3922o = m18649a(new C3706b(e + 7, d - 7), false, 1, -1).m18661a();
            c3922o2 = m18649a(new C3706b(e + 7, d + 7), false, 1, 1).m18661a();
            c3922o3 = m18649a(new C3706b(e - 7, d + 7), false, -1, 1).m18661a();
            c3922o4 = m18649a(new C3706b(e - 7, d - 7), false, -1, -1).m18661a();
        }
        return new C3706b(C3710a.m18670a((((c3922o.m19522a() + c3922o4.m19522a()) + c3922o2.m19522a()) + c3922o3.m19522a()) / 4.0f), C3710a.m18670a((((c3922o4.m19523b() + c3922o.m19523b()) + c3922o2.m19523b()) + c3922o3.m19523b()) / 4.0f));
    }

    private C3922o[] m18659b(C3922o[] c3922oArr) {
        return C3705a.m18656a(c3922oArr, (float) (this.f14385e * 2), (float) m18658b());
    }

    private C3717b m18650a(C3717b c3717b, C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4) throws C3932i {
        C3721i a = C3721i.m18734a();
        int b = m18658b();
        float f = (((float) b) / 2.0f) - ((float) this.f14385e);
        float f2 = (((float) b) / 2.0f) + ((float) this.f14385e);
        return a.mo4303a(c3717b, b, b, f, f, f2, f, f2, f2, f, f2, c3922o.m19522a(), c3922o.m19523b(), c3922o2.m19522a(), c3922o2.m19523b(), c3922o3.m19522a(), c3922o3.m19523b(), c3922o4.m19522a(), c3922o4.m19523b());
    }

    private int m18646a(C3922o c3922o, C3922o c3922o2, int i) {
        int i2 = 0;
        float a = C3705a.m18643a(c3922o, c3922o2);
        float f = a / ((float) i);
        float a2 = c3922o.m19522a();
        float b = c3922o.m19523b();
        float a3 = ((c3922o2.m19522a() - c3922o.m19522a()) * f) / a;
        f = (f * (c3922o2.m19523b() - c3922o.m19523b())) / a;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.f14381a.m18712a(C3710a.m18670a((((float) i3) * a3) + a2), C3710a.m18670a((((float) i3) * f) + b))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private boolean m18653a(C3706b c3706b, C3706b c3706b2, C3706b c3706b3, C3706b c3706b4) {
        C3706b c3706b5 = new C3706b(c3706b.m18662b() - 3, c3706b.m18663c() + 3);
        C3706b c3706b6 = new C3706b(c3706b2.m18662b() - 3, c3706b2.m18663c() - 3);
        C3706b c3706b7 = new C3706b(c3706b3.m18662b() + 3, c3706b3.m18663c() - 3);
        C3706b c3706b8 = new C3706b(c3706b4.m18662b() + 3, 3 + c3706b4.m18663c());
        int a = m18645a(c3706b8, c3706b5);
        if (a != 0 && m18645a(c3706b5, c3706b6) == a && m18645a(c3706b6, c3706b7) == a && m18645a(c3706b7, c3706b8) == a) {
            return true;
        }
        return false;
    }

    private int m18645a(C3706b c3706b, C3706b c3706b2) {
        float b = C3705a.m18657b(c3706b, c3706b2);
        float b2 = ((float) (c3706b2.m18662b() - c3706b.m18662b())) / b;
        float c = ((float) (c3706b2.m18663c() - c3706b.m18663c())) / b;
        float b3 = (float) c3706b.m18662b();
        float c2 = (float) c3706b.m18663c();
        boolean a = this.f14381a.m18712a(c3706b.m18662b(), c3706b.m18663c());
        int i = 0;
        float f = b3;
        b3 = c2;
        for (int i2 = 0; ((float) i2) < b; i2++) {
            f += b2;
            b3 += c;
            if (this.f14381a.m18712a(C3710a.m18670a(f), C3710a.m18670a(b3)) != a) {
                i++;
            }
        }
        float f2 = ((float) i) / b;
        if (f2 > 0.1f && f2 < 0.9f) {
            return 0;
        }
        return ((f2 > 0.1f ? 1 : (f2 == 0.1f ? 0 : -1)) <= 0) == a ? 1 : -1;
    }

    private C3706b m18649a(C3706b c3706b, boolean z, int i, int i2) {
        int b = c3706b.m18662b() + i;
        int c = c3706b.m18663c() + i2;
        while (m18652a(b, c) && this.f14381a.m18712a(b, c) == z) {
            b += i;
            c += i2;
        }
        int i3 = c - i2;
        c = b - i;
        while (m18652a(c, i3) && this.f14381a.m18712a(c, i3) == z) {
            c += i;
        }
        b = c - i;
        c = i3;
        while (m18652a(b, c) && this.f14381a.m18712a(b, c) == z) {
            c += i2;
        }
        return new C3706b(b, c - i2);
    }

    private static C3922o[] m18656a(C3922o[] c3922oArr, float f, float f2) {
        float f3 = f2 / (2.0f * f);
        float a = c3922oArr[0].m19522a() - c3922oArr[2].m19522a();
        float b = c3922oArr[0].m19523b() - c3922oArr[2].m19523b();
        float a2 = (c3922oArr[0].m19522a() + c3922oArr[2].m19522a()) / 2.0f;
        float b2 = (c3922oArr[0].m19523b() + c3922oArr[2].m19523b()) / 2.0f;
        C3922o c3922o = new C3922o((f3 * a) + a2, (f3 * b) + b2);
        C3922o c3922o2 = new C3922o(a2 - (a * f3), b2 - (b * f3));
        a = c3922oArr[1].m19522a() - c3922oArr[3].m19522a();
        b = c3922oArr[1].m19523b() - c3922oArr[3].m19523b();
        a2 = (c3922oArr[1].m19522a() + c3922oArr[3].m19522a()) / 2.0f;
        b2 = (c3922oArr[1].m19523b() + c3922oArr[3].m19523b()) / 2.0f;
        C3922o c3922o3 = new C3922o((f3 * a) + a2, (f3 * b) + b2);
        C3922o c3922o4 = new C3922o(a2 - (a * f3), b2 - (f3 * b));
        return new C3922o[]{c3922o, c3922o3, c3922o2, c3922o4};
    }

    private boolean m18652a(int i, int i2) {
        return i >= 0 && i < this.f14381a.m18719d() && i2 > 0 && i2 < this.f14381a.m18720e();
    }

    private boolean m18654a(C3922o c3922o) {
        return m18652a(C3710a.m18670a(c3922o.m19522a()), C3710a.m18670a(c3922o.m19523b()));
    }

    private static float m18657b(C3706b c3706b, C3706b c3706b2) {
        return C3710a.m18669a(c3706b.m18662b(), c3706b.m18663c(), c3706b2.m18662b(), c3706b2.m18663c());
    }

    private static float m18643a(C3922o c3922o, C3922o c3922o2) {
        return C3710a.m18668a(c3922o.m19522a(), c3922o.m19523b(), c3922o2.m19522a(), c3922o2.m19523b());
    }

    private int m18658b() {
        if (this.f14382b) {
            return (this.f14383c * 4) + 11;
        }
        if (this.f14383c <= 4) {
            return (this.f14383c * 4) + 15;
        }
        return ((this.f14383c * 4) + ((((this.f14383c - 4) / 8) + 1) * 2)) + 15;
    }
}
