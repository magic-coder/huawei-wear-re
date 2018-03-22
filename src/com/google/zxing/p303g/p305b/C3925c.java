package com.google.zxing.p303g.p305b;

import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.C3803p;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3703g;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3721i;
import com.google.zxing.p278b.C3726k;
import com.google.zxing.p278b.p280a.C3710a;
import com.google.zxing.p303g.p304a.C3918r;
import java.util.Map;

/* compiled from: Detector */
public class C3925c {
    private final C3717b f15100a;
    private C3803p f15101b;

    public C3925c(C3717b c3717b) {
        this.f15100a = c3717b;
    }

    public final C3703g m19539a(Map<C3880e, ?> map) throws C3932i, C3900f {
        C3803p c3803p;
        if (map == null) {
            c3803p = null;
        } else {
            c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
        }
        this.f15101b = c3803p;
        return m19538a(new C3927e(this.f15100a, this.f15101b).m19553a((Map) map));
    }

    protected final C3703g m19538a(C3930h c3930h) throws C3932i, C3900f {
        C3922o b = c3930h.m19558b();
        C3922o c = c3930h.m19559c();
        C3922o a = c3930h.m19557a();
        float a2 = m19537a(b, c, a);
        if (a2 < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            throw C3932i.m19565a();
        }
        C3922o[] c3922oArr;
        int a3 = C3925c.m19533a(b, c, a, a2);
        C3918r a4 = C3918r.m19501a(a3);
        int d = a4.m19509d() - 7;
        C3922o c3922o = null;
        if (a4.m19507b().length > 0) {
            float a5 = (c.m19522a() - b.m19522a()) + a.m19522a();
            float b2 = (c.m19523b() - b.m19523b()) + a.m19523b();
            float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - (3.0f / ((float) d));
            int a6 = (int) (((a5 - b.m19522a()) * f) + b.m19522a());
            d = (int) (b.m19523b() + (f * (b2 - b.m19523b())));
            int i = 4;
            while (i <= 16) {
                try {
                    c3922o = m19540a(a2, a6, d, (float) i);
                    break;
                } catch (C3932i e) {
                    i <<= 1;
                }
            }
        }
        C3717b a7 = C3925c.m19534a(this.f15100a, C3925c.m19535a(b, c, a, c3922o, a3), a3);
        if (c3922o == null) {
            c3922oArr = new C3922o[]{a, b, c};
        } else {
            c3922oArr = new C3922o[]{a, b, c, c3922o};
        }
        return new C3703g(a7, c3922oArr);
    }

    private static C3726k m19535a(C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4, int i) {
        float a;
        float b;
        float f;
        float f2;
        float f3 = ((float) i) - 3.5f;
        if (c3922o4 != null) {
            a = c3922o4.m19522a();
            b = c3922o4.m19523b();
            f = f3 - 3.0f;
            f2 = f;
        } else {
            a = (c3922o2.m19522a() - c3922o.m19522a()) + c3922o3.m19522a();
            b = (c3922o2.m19523b() - c3922o.m19523b()) + c3922o3.m19523b();
            f = f3;
            f2 = f3;
        }
        return C3726k.m18758a(3.5f, 3.5f, f3, 3.5f, f2, f, 3.5f, f3, c3922o.m19522a(), c3922o.m19523b(), c3922o2.m19522a(), c3922o2.m19523b(), a, b, c3922o3.m19522a(), c3922o3.m19523b());
    }

    private static C3717b m19534a(C3717b c3717b, C3726k c3726k, int i) throws C3932i {
        return C3721i.m18734a().mo4304a(c3717b, i, i, c3726k);
    }

    private static int m19533a(C3922o c3922o, C3922o c3922o2, C3922o c3922o3, float f) throws C3932i {
        int a = ((C3710a.m18670a(C3922o.m19519a(c3922o, c3922o2) / f) + C3710a.m18670a(C3922o.m19519a(c3922o, c3922o3) / f)) >> 1) + 7;
        switch (a & 3) {
            case 0:
                return a + 1;
            case 2:
                return a - 1;
            case 3:
                throw C3932i.m19565a();
            default:
                return a;
        }
    }

    protected final float m19537a(C3922o c3922o, C3922o c3922o2, C3922o c3922o3) {
        return (m19532a(c3922o, c3922o2) + m19532a(c3922o, c3922o3)) / 2.0f;
    }

    private float m19532a(C3922o c3922o, C3922o c3922o2) {
        float a = m19531a((int) c3922o.m19522a(), (int) c3922o.m19523b(), (int) c3922o2.m19522a(), (int) c3922o2.m19523b());
        float a2 = m19531a((int) c3922o2.m19522a(), (int) c3922o2.m19523b(), (int) c3922o.m19522a(), (int) c3922o.m19523b());
        if (Float.isNaN(a)) {
            return a2 / 7.0f;
        }
        if (Float.isNaN(a2)) {
            return a / 7.0f;
        }
        return (a + a2) / 14.0f;
    }

    private float m19531a(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6 = 0;
        float b = m19536b(i, i2, i3, i4);
        int i7 = i - (i3 - i);
        if (i7 < 0) {
            f = ((float) i) / ((float) (i - i7));
            i5 = 0;
        } else if (i7 >= this.f15100a.m18719d()) {
            f = ((float) ((this.f15100a.m18719d() - 1) - i)) / ((float) (i7 - i));
            i5 = this.f15100a.m18719d() - 1;
        } else {
            i5 = i7;
            f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        i7 = (int) (((float) i2) - (f * ((float) (i4 - i2))));
        if (i7 < 0) {
            f = ((float) i2) / ((float) (i2 - i7));
        } else if (i7 >= this.f15100a.m18720e()) {
            f = ((float) ((this.f15100a.m18720e() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.f15100a.m18720e() - 1;
        } else {
            i6 = i7;
            f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        return (m19536b(i, i2, (int) ((f * ((float) (i5 - i))) + ((float) i)), i6) + b) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }

    private float m19536b(int i, int i2, int i3, int i4) {
        Object obj;
        if (Math.abs(i4 - i2) > Math.abs(i3 - i)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i3 - i);
        int i7 = (-abs) >> 1;
        int i8 = i2 < i4 ? 1 : -1;
        int i9 = i < i3 ? 1 : -1;
        int i10 = 0;
        int i11 = i4 + i8;
        int i12 = i2;
        int i13 = i7;
        i7 = i;
        while (i12 != i11) {
            int i14;
            int i15;
            int i16 = obj != null ? i7 : i12;
            if (obj != null) {
                i14 = i12;
            } else {
                i14 = i7;
            }
            if ((i10 == 1) != this.f15100a.m18712a(i16, i14)) {
                i14 = i10;
            } else if (i10 == 2) {
                return C3710a.m18669a(i12, i7, i2, i);
            } else {
                i14 = i10 + 1;
            }
            i10 = i13 + abs2;
            if (i10 <= 0) {
                i15 = i7;
                i7 = i10;
            } else if (i7 == i3) {
                i9 = i14;
                break;
            } else {
                i15 = i7 + i9;
                i7 = i10 - abs;
            }
            i12 += i8;
            i10 = i14;
            i13 = i7;
            i7 = i15;
        }
        i9 = i10;
        if (i9 == 2) {
            return C3710a.m18669a(i4 + i8, i3, i2, i);
        }
        return Float.NaN;
    }

    protected final C3923a m19540a(float f, int i, int i2, float f2) throws C3932i {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f15100a.m18719d() - 1, i + i3);
        if (((float) (min - max)) < f * 3.0f) {
            throw C3932i.m19565a();
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.f15100a.m18720e() - 1, i3 + i2);
        if (((float) (min2 - max2)) < f * 3.0f) {
            throw C3932i.m19565a();
        }
        return new C3924b(this.f15100a, max, max2, min - max, min2 - max2, f, this.f15101b).m19530a();
    }
}
