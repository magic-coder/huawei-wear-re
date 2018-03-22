package com.google.zxing.p303g.p305b;

import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.C3922o;

/* compiled from: AlignmentPattern */
public final class C3923a extends C3922o {
    private final float f15090a;

    C3923a(float f, float f2, float f3) {
        super(f, f2);
        this.f15090a = f3;
    }

    boolean m19524a(float f, float f2, float f3) {
        if (Math.abs(f2 - m19523b()) > f || Math.abs(f3 - m19522a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f15090a);
        if (abs <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT || abs <= this.f15090a) {
            return true;
        }
        return false;
    }

    C3923a m19525b(float f, float f2, float f3) {
        return new C3923a((m19522a() + f2) / 2.0f, (m19523b() + f) / 2.0f, (this.f15090a + f3) / 2.0f);
    }
}
