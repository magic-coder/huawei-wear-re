package com.google.zxing.p278b;

import com.android.volley.DefaultRetryPolicy;

/* compiled from: PerspectiveTransform */
public final class C3726k {
    private final float f14487a;
    private final float f14488b;
    private final float f14489c;
    private final float f14490d;
    private final float f14491e;
    private final float f14492f;
    private final float f14493g;
    private final float f14494h;
    private final float f14495i;

    private C3726k(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f14487a = f;
        this.f14488b = f4;
        this.f14489c = f7;
        this.f14490d = f2;
        this.f14491e = f5;
        this.f14492f = f8;
        this.f14493g = f3;
        this.f14494h = f6;
        this.f14495i = f9;
    }

    public static C3726k m18758a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return C3726k.m18757a(f9, f10, f11, f12, f13, f14, f15, f16).m18761a(C3726k.m18759b(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public void m18762a(float[] fArr) {
        int length = fArr.length;
        float f = this.f14487a;
        float f2 = this.f14488b;
        float f3 = this.f14489c;
        float f4 = this.f14490d;
        float f5 = this.f14491e;
        float f6 = this.f14492f;
        float f7 = this.f14493g;
        float f8 = this.f14494h;
        float f9 = this.f14495i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr[i];
            float f11 = fArr[i + 1];
            float f12 = ((f3 * f10) + (f6 * f11)) + f9;
            fArr[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i + 1] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    public static C3726k m18757a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new C3726k(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f10 * f11) - (f9 * f13)) / f15;
        return new C3726k((f3 - f) + (f16 * f3), (f7 - f) + (f17 * f7), f, (f16 * f4) + (f4 - f2), (f17 * f8) + (f8 - f2), f2, f16, f17, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    public static C3726k m18759b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return C3726k.m18757a(f, f2, f3, f4, f5, f6, f7, f8).m18760a();
    }

    C3726k m18760a() {
        return new C3726k((this.f14491e * this.f14495i) - (this.f14492f * this.f14494h), (this.f14492f * this.f14493g) - (this.f14490d * this.f14495i), (this.f14490d * this.f14494h) - (this.f14491e * this.f14493g), (this.f14489c * this.f14494h) - (this.f14488b * this.f14495i), (this.f14487a * this.f14495i) - (this.f14489c * this.f14493g), (this.f14488b * this.f14493g) - (this.f14487a * this.f14494h), (this.f14488b * this.f14492f) - (this.f14489c * this.f14491e), (this.f14489c * this.f14490d) - (this.f14487a * this.f14492f), (this.f14487a * this.f14491e) - (this.f14488b * this.f14490d));
    }

    C3726k m18761a(C3726k c3726k) {
        return new C3726k(((this.f14487a * c3726k.f14487a) + (this.f14490d * c3726k.f14488b)) + (this.f14493g * c3726k.f14489c), ((this.f14487a * c3726k.f14490d) + (this.f14490d * c3726k.f14491e)) + (this.f14493g * c3726k.f14492f), ((this.f14487a * c3726k.f14493g) + (this.f14490d * c3726k.f14494h)) + (this.f14493g * c3726k.f14495i), ((this.f14488b * c3726k.f14487a) + (this.f14491e * c3726k.f14488b)) + (this.f14494h * c3726k.f14489c), ((this.f14488b * c3726k.f14490d) + (this.f14491e * c3726k.f14491e)) + (this.f14494h * c3726k.f14492f), ((this.f14488b * c3726k.f14493g) + (this.f14491e * c3726k.f14494h)) + (this.f14494h * c3726k.f14495i), ((this.f14489c * c3726k.f14487a) + (this.f14492f * c3726k.f14488b)) + (this.f14495i * c3726k.f14489c), ((this.f14489c * c3726k.f14490d) + (this.f14492f * c3726k.f14491e)) + (this.f14495i * c3726k.f14492f), ((this.f14489c * c3726k.f14493g) + (this.f14492f * c3726k.f14494h)) + (this.f14495i * c3726k.f14495i));
    }
}
