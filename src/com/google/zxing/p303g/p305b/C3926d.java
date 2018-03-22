package com.google.zxing.p303g.p305b;

import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.C3922o;

/* compiled from: FinderPattern */
public final class C3926d extends C3922o {
    private final float f15102a;
    private final int f15103b;

    C3926d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private C3926d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f15102a = f3;
        this.f15103b = i;
    }

    public float m19543c() {
        return this.f15102a;
    }

    int m19544d() {
        return this.f15103b;
    }

    boolean m19541a(float f, float f2, float f3) {
        if (Math.abs(f2 - m19523b()) > f || Math.abs(f3 - m19522a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f15102a);
        if (abs <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT || abs <= this.f15102a) {
            return true;
        }
        return false;
    }

    C3926d m19542b(float f, float f2, float f3) {
        int i = this.f15103b + 1;
        return new C3926d(((((float) this.f15103b) * m19522a()) + f2) / ((float) i), ((((float) this.f15103b) * m19523b()) + f) / ((float) i), ((((float) this.f15103b) * this.f15102a) + f3) / ((float) i), i);
    }
}
