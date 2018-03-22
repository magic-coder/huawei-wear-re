package com.p230a.p231b.p232b.p233a;

import com.android.volley.DefaultRetryPolicy;

public class C3107e implements C3106t {
    private int f10422a;
    private int f10423b;
    private final int f10424c;
    private final float f10425d;

    public C3107e() {
        this(20000, 1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    public C3107e(int i, int i2, float f) {
        this.f10422a = i;
        this.f10424c = i2;
        this.f10425d = f;
    }

    public int mo3656a() {
        return this.f10422a;
    }

    public void mo3657a(C3102w c3102w) {
        this.f10423b++;
        this.f10422a = (int) (((float) this.f10422a) + (((float) this.f10422a) * this.f10425d));
        if (!m13854c()) {
            throw c3102w;
        }
    }

    public int mo3658b() {
        return this.f10423b;
    }

    protected boolean m13854c() {
        return this.f10423b <= this.f10424c;
    }
}
