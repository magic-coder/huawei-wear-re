package com.google.zxing.p278b.p280a;

import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3717b;

/* compiled from: WhiteRectangleDetector */
public final class C3711b {
    private final C3717b f14407a;
    private final int f14408b;
    private final int f14409c;
    private final int f14410d;
    private final int f14411e;
    private final int f14412f;
    private final int f14413g;

    public C3711b(C3717b c3717b) throws C3932i {
        this.f14407a = c3717b;
        this.f14408b = c3717b.m18720e();
        this.f14409c = c3717b.m18719d();
        this.f14410d = (this.f14409c - 30) >> 1;
        this.f14411e = (this.f14409c + 30) >> 1;
        this.f14413g = (this.f14408b - 30) >> 1;
        this.f14412f = (this.f14408b + 30) >> 1;
        if (this.f14413g < 0 || this.f14410d < 0 || this.f14412f >= this.f14408b || this.f14411e >= this.f14409c) {
            throw C3932i.m19565a();
        }
    }

    public C3711b(C3717b c3717b, int i, int i2, int i3) throws C3932i {
        this.f14407a = c3717b;
        this.f14408b = c3717b.m18720e();
        this.f14409c = c3717b.m18719d();
        int i4 = i >> 1;
        this.f14410d = i2 - i4;
        this.f14411e = i2 + i4;
        this.f14413g = i3 - i4;
        this.f14412f = i4 + i3;
        if (this.f14413g < 0 || this.f14410d < 0 || this.f14412f >= this.f14408b || this.f14411e >= this.f14409c) {
            throw C3932i.m19565a();
        }
    }

    public C3922o[] m18674a() throws C3932i {
        int i;
        int i2;
        boolean z = false;
        int i3 = this.f14410d;
        int i4 = this.f14411e;
        int i5 = this.f14413g;
        int i6 = this.f14412f;
        boolean z2 = false;
        boolean z3 = true;
        while (z3) {
            z3 = true;
            boolean z4 = false;
            while (z3 && i4 < this.f14409c) {
                z3 = m18672a(i5, i6, i4, false);
                if (z3) {
                    i4++;
                    z4 = true;
                }
            }
            if (i4 >= this.f14409c) {
                z = true;
                i = i5;
                i2 = i4;
                i5 = i3;
                i3 = i6;
                break;
            }
            z3 = true;
            while (z3 && i6 < this.f14408b) {
                z3 = m18672a(i3, i4, i6, true);
                if (z3) {
                    i6++;
                    z4 = true;
                }
            }
            if (i6 >= this.f14408b) {
                z = true;
                i = i5;
                i2 = i4;
                i5 = i3;
                i3 = i6;
                break;
            }
            z3 = true;
            while (z3 && i3 >= 0) {
                z3 = m18672a(i5, i6, i3, false);
                if (z3) {
                    i3--;
                    z4 = true;
                }
            }
            if (i3 < 0) {
                z = true;
                i = i5;
                i2 = i4;
                i5 = i3;
                i3 = i6;
                break;
            }
            z3 = z4;
            z4 = true;
            while (z4 && i5 >= 0) {
                z4 = m18672a(i3, i4, i5, true);
                if (z4) {
                    i5--;
                    z3 = true;
                }
            }
            if (i5 < 0) {
                z = true;
                i = i5;
                i2 = i4;
                i5 = i3;
                i3 = i6;
                break;
            } else if (z3) {
                z2 = true;
            }
        }
        i = i5;
        i2 = i4;
        i5 = i3;
        i3 = i6;
        if (z || !r9) {
            throw C3932i.m19565a();
        }
        C3922o c3922o;
        int i7 = i2 - i5;
        C3922o c3922o2 = null;
        for (i6 = 1; i6 < i7; i6++) {
            c3922o2 = m18671a((float) i5, (float) (i3 - i6), (float) (i5 + i6), (float) i3);
            if (c3922o2 != null) {
                c3922o = c3922o2;
                break;
            }
        }
        c3922o = c3922o2;
        if (c3922o == null) {
            throw C3932i.m19565a();
        }
        C3922o c3922o3;
        c3922o2 = null;
        for (i6 = 1; i6 < i7; i6++) {
            c3922o2 = m18671a((float) i5, (float) (i + i6), (float) (i5 + i6), (float) i);
            if (c3922o2 != null) {
                c3922o3 = c3922o2;
                break;
            }
        }
        c3922o3 = c3922o2;
        if (c3922o3 == null) {
            throw C3932i.m19565a();
        }
        c3922o2 = null;
        for (i6 = 1; i6 < i7; i6++) {
            c3922o2 = m18671a((float) i2, (float) (i + i6), (float) (i2 - i6), (float) i);
            if (c3922o2 != null) {
                break;
            }
        }
        if (c3922o2 == null) {
            throw C3932i.m19565a();
        }
        C3922o c3922o4 = null;
        for (int i8 = true; i8 < i7; i8++) {
            c3922o4 = m18671a((float) i2, (float) (i3 - i8), (float) (i2 - i8), (float) i3);
            if (c3922o4 != null) {
                break;
            }
        }
        if (c3922o4 != null) {
            return m18673a(c3922o4, c3922o, c3922o2, c3922o3);
        }
        throw C3932i.m19565a();
    }

    private C3922o m18671a(float f, float f2, float f3, float f4) {
        int a = C3710a.m18670a(C3710a.m18668a(f, f2, f3, f4));
        float f5 = (f3 - f) / ((float) a);
        float f6 = (f4 - f2) / ((float) a);
        for (int i = 0; i < a; i++) {
            int a2 = C3710a.m18670a((((float) i) * f5) + f);
            int a3 = C3710a.m18670a((((float) i) * f6) + f2);
            if (this.f14407a.m18712a(a2, a3)) {
                return new C3922o((float) a2, (float) a3);
            }
        }
        return null;
    }

    private C3922o[] m18673a(C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4) {
        float a = c3922o.m19522a();
        float b = c3922o.m19523b();
        float a2 = c3922o2.m19522a();
        float b2 = c3922o2.m19523b();
        float a3 = c3922o3.m19522a();
        float b3 = c3922o3.m19523b();
        float a4 = c3922o4.m19522a();
        float b4 = c3922o4.m19523b();
        if (a < ((float) this.f14409c) / 2.0f) {
            return new C3922o[]{new C3922o(a4 - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b4 + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT), new C3922o(a2 + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b2 + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT), new C3922o(a3 - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b3 - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT), new C3922o(a + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)};
        }
        return new C3922o[]{new C3922o(a4 + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b4 + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT), new C3922o(a2 + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b2 - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT), new C3922o(a3 - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b3 + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT), new C3922o(a - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, b - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)};
    }

    private boolean m18672a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f14407a.m18712a(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.f14407a.m18712a(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
