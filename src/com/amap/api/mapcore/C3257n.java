package com.amap.api.mapcore;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.WeightedLatLng;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: CameraAnimator */
public class C3257n {
    private static float f11263J = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final float[] f11264K = new float[101];
    private static final float[] f11265L = new float[101];
    private static float f11266Q = 8.0f;
    private static float f11267R;
    private float f11268A;
    private float f11269B;
    private boolean f11270C;
    private Interpolator f11271D;
    private boolean f11272E;
    private float f11273F;
    private float f11274G;
    private int f11275H;
    private float f11276I;
    private float f11277M;
    private final float f11278N;
    private float f11279O;
    private boolean f11280P;
    private int f11281a;
    private int f11282b;
    private int f11283c;
    private float f11284d;
    private float f11285e;
    private float f11286f;
    private int f11287g;
    private int f11288h;
    private float f11289i;
    private float f11290j;
    private float f11291k;
    private int f11292l;
    private int f11293m;
    private int f11294n;
    private int f11295o;
    private int f11296p;
    private int f11297q;
    private float f11298r;
    private float f11299s;
    private float f11300t;
    private long f11301u;
    private long f11302v;
    private float f11303w;
    private float f11304x;
    private float f11305y;
    private float f11306z;

    static {
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (i < 100) {
            float f3;
            float f4 = ((float) i) / 100.0f;
            float f5 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            float f6 = f2;
            while (true) {
                f2 = ((f5 - f6) / 2.0f) + f6;
                f3 = (3.0f * f2) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2);
                float f7 = ((((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2) * 0.175f) + (0.35000002f * f2)) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f6 = f2;
                }
            }
            f11264K[i] = (f2 * (f2 * f2)) + (f3 * (((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2) * 0.5f) + f2));
            f5 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            while (true) {
                f2 = ((f5 - f) / 2.0f) + f;
                f3 = (3.0f * f2) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2);
                f7 = ((((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2) * 0.5f) + f2) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f = f2;
                }
            }
            f11265L[i] = (f2 * (f2 * f2)) + ((((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = f11264K;
        f11265L[100] = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        fArr[100] = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        f11267R = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        f11267R = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / C3257n.m15302a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    public C3257n(Context context) {
        this(context, null);
    }

    public C3257n(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public C3257n(Context context, Interpolator interpolator, boolean z) {
        this.f11276I = ViewConfiguration.getScrollFriction();
        this.f11270C = true;
        this.f11271D = interpolator;
        this.f11278N = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f11277M = m15303b(ViewConfiguration.getScrollFriction());
        this.f11272E = z;
        this.f11279O = m15303b(0.84f);
    }

    public void m15309a(Interpolator interpolator) {
        this.f11271D = interpolator;
    }

    private float m15303b(float f) {
        return (386.0878f * this.f11278N) * f;
    }

    public final boolean m15311a() {
        return this.f11270C;
    }

    public final void m15310a(boolean z) {
        this.f11270C = z;
    }

    public final int m15312b() {
        return this.f11296p;
    }

    public final int m15314c() {
        return this.f11297q;
    }

    public final float m15315d() {
        return this.f11298r;
    }

    public final float m15316e() {
        return this.f11299s;
    }

    public final float m15317f() {
        return this.f11300t;
    }

    public float m15318g() {
        if (this.f11281a == 1) {
            return this.f11274G;
        }
        return this.f11273F - ((this.f11277M * ((float) m15320i())) / 2000.0f);
    }

    public boolean m15319h() {
        if (this.f11270C) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f11301u);
        if (((long) currentAnimationTimeMillis) < this.f11302v) {
            float f;
            switch (this.f11281a) {
                case 1:
                    float f2 = ((float) currentAnimationTimeMillis) / ((float) this.f11302v);
                    int i = (int) (100.0f * f2);
                    float f3 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                    f = 0.0f;
                    if (i < 100) {
                        f3 = ((float) i) / 100.0f;
                        f = ((float) (i + 1)) / 100.0f;
                        float f4 = f11264K[i];
                        f = (f11264K[i + 1] - f4) / (f - f3);
                        f3 = ((f2 - f3) * f) + f4;
                    }
                    this.f11274G = ((f * ((float) this.f11275H)) / ((float) this.f11302v)) * 1000.0f;
                    this.f11296p = this.f11282b + Math.round(((float) (this.f11287g - this.f11282b)) * f3);
                    this.f11296p = Math.min(this.f11296p, this.f11293m);
                    this.f11296p = Math.max(this.f11296p, this.f11292l);
                    this.f11297q = this.f11283c + Math.round(f3 * ((float) (this.f11288h - this.f11283c)));
                    this.f11297q = Math.min(this.f11297q, this.f11295o);
                    this.f11297q = Math.max(this.f11297q, this.f11294n);
                    if (this.f11296p == this.f11287g && this.f11297q == this.f11288h) {
                        this.f11270C = true;
                        break;
                    }
                case 2:
                    f = ((float) currentAnimationTimeMillis) * this.f11303w;
                    if (this.f11271D == null) {
                        f = C3257n.m15302a(f);
                    } else {
                        f = this.f11271D.getInterpolation(f);
                    }
                    this.f11296p = this.f11282b + Math.round(this.f11304x * f);
                    this.f11297q = this.f11283c + Math.round(this.f11305y * f);
                    this.f11298r = this.f11284d + (this.f11306z * f);
                    this.f11299s = this.f11285e + (this.f11268A * f);
                    this.f11300t = (f * this.f11269B) + this.f11286f;
                    break;
            }
        }
        this.f11296p = this.f11287g;
        this.f11297q = this.f11288h;
        this.f11298r = this.f11289i;
        this.f11299s = this.f11290j;
        this.f11300t = this.f11291k;
        this.f11270C = true;
        return true;
    }

    public void m15307a(int i, int i2, float f, float f2, float f3, int i3, int i4, float f4, float f5, float f6, long j) {
        this.f11281a = 2;
        this.f11270C = false;
        this.f11302v = j;
        this.f11301u = AnimationUtils.currentAnimationTimeMillis();
        this.f11282b = i;
        this.f11283c = i2;
        this.f11284d = f;
        this.f11285e = f2;
        this.f11286f = f3;
        this.f11287g = i + i3;
        this.f11288h = i2 + i4;
        this.f11289i = f + f4;
        this.f11290j = f2 + f5;
        this.f11291k = f3 + f6;
        this.f11304x = (float) i3;
        this.f11305y = (float) i4;
        this.f11306z = f4;
        this.f11268A = f5;
        this.f11269B = f6;
        this.f11303w = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / ((float) this.f11302v);
    }

    public void m15308a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        float g;
        float f;
        float f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        if (this.f11272E && !this.f11270C) {
            g = m15318g();
            f = (float) (this.f11287g - this.f11282b);
            float f3 = (float) (this.f11288h - this.f11283c);
            float sqrt = (float) Math.sqrt((double) ((f * f) + (f3 * f3)));
            f = (f / sqrt) * g;
            g *= f3 / sqrt;
            if (Math.signum((float) i3) == Math.signum(f) && Math.signum((float) i4) == Math.signum(g)) {
                i3 = (int) (f + ((float) i3));
                i4 = (int) (g + ((float) i4));
            }
        }
        this.f11281a = 1;
        this.f11270C = false;
        f = (float) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        this.f11273F = f;
        this.f11302v = (long) m15305d(f);
        this.f11301u = AnimationUtils.currentAnimationTimeMillis();
        this.f11282b = i;
        this.f11283c = i2;
        g = f == 0.0f ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT : ((float) i3) / f;
        if (f != 0.0f) {
            f2 = ((float) i4) / f;
        }
        double e = m15306e(f);
        this.f11275H = (int) (((double) Math.signum(f)) * e);
        this.f11292l = i5;
        this.f11293m = i6;
        this.f11294n = i7;
        this.f11295o = i8;
        this.f11287g = ((int) Math.round(((double) g) * e)) + i;
        this.f11287g = Math.min(this.f11287g, this.f11293m);
        this.f11287g = Math.max(this.f11287g, this.f11292l);
        this.f11288h = ((int) Math.round(((double) f2) * e)) + i2;
        this.f11288h = Math.min(this.f11288h, this.f11295o);
        this.f11288h = Math.max(this.f11288h, this.f11294n);
    }

    private double m15304c(float f) {
        return Math.log((double) ((0.35f * Math.abs(f)) / (this.f11276I * this.f11279O)));
    }

    private int m15305d(float f) {
        return (int) (Math.exp(m15304c(f) / (((double) f11263J) - WeightedLatLng.DEFAULT_INTENSITY)) * 1000.0d);
    }

    private double m15306e(float f) {
        return Math.exp(m15304c(f) * (((double) f11263J) / (((double) f11263J) - WeightedLatLng.DEFAULT_INTENSITY))) * ((double) (this.f11276I * this.f11279O));
    }

    static float m15302a(float f) {
        float f2 = f11266Q * f;
        if (f2 < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            f2 -= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((float) Math.exp((double) (-f2)));
        } else {
            f2 = ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((float) Math.exp((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2)))) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - 0.36787945f)) + 0.36787945f;
        }
        return f2 * f11267R;
    }

    public int m15320i() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f11301u);
    }

    public final int m15321j() {
        return this.f11281a;
    }

    public void m15313b(boolean z) {
        this.f11280P = z;
    }

    public boolean m15322k() {
        return this.f11280P;
    }
}
