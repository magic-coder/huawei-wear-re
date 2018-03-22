package com.google.zxing;

import com.google.zxing.p278b.p280a.C3710a;

/* compiled from: ResultPoint */
public class C3922o {
    private final float f15088a;
    private final float f15089b;

    public C3922o(float f, float f2) {
        this.f15088a = f;
        this.f15089b = f2;
    }

    public final float m19522a() {
        return this.f15088a;
    }

    public final float m19523b() {
        return this.f15089b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3922o)) {
            return false;
        }
        C3922o c3922o = (C3922o) obj;
        if (this.f15088a == c3922o.f15088a && this.f15089b == c3922o.f15089b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f15088a) * 31) + Float.floatToIntBits(this.f15089b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append('(');
        stringBuilder.append(this.f15088a);
        stringBuilder.append(',');
        stringBuilder.append(this.f15089b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static void m19521a(C3922o[] c3922oArr) {
        C3922o c3922o;
        C3922o c3922o2;
        C3922o c3922o3;
        float a = C3922o.m19519a(c3922oArr[0], c3922oArr[1]);
        float a2 = C3922o.m19519a(c3922oArr[1], c3922oArr[2]);
        float a3 = C3922o.m19519a(c3922oArr[0], c3922oArr[2]);
        if (a2 >= a && a2 >= a3) {
            c3922o = c3922oArr[0];
            c3922o2 = c3922oArr[1];
            c3922o3 = c3922oArr[2];
        } else if (a3 < a2 || a3 < a) {
            c3922o = c3922oArr[2];
            c3922o2 = c3922oArr[0];
            c3922o3 = c3922oArr[1];
        } else {
            c3922o = c3922oArr[1];
            c3922o2 = c3922oArr[0];
            c3922o3 = c3922oArr[2];
        }
        if (C3922o.m19520a(c3922o2, c3922o, c3922o3) >= 0.0f) {
            C3922o c3922o4 = c3922o3;
            c3922o3 = c3922o2;
            c3922o2 = c3922o4;
        }
        c3922oArr[0] = c3922o3;
        c3922oArr[1] = c3922o;
        c3922oArr[2] = c3922o2;
    }

    public static float m19519a(C3922o c3922o, C3922o c3922o2) {
        return C3710a.m18668a(c3922o.f15088a, c3922o.f15089b, c3922o2.f15088a, c3922o2.f15089b);
    }

    private static float m19520a(C3922o c3922o, C3922o c3922o2, C3922o c3922o3) {
        float f = c3922o2.f15088a;
        float f2 = c3922o2.f15089b;
        return ((c3922o3.f15088a - f) * (c3922o.f15089b - f2)) - ((c3922o.f15088a - f) * (c3922o3.f15089b - f2));
    }
}
