package com.google.analytics.tracking.android;

import com.amap.api.maps.model.WeightedLatLng;

/* compiled from: SendHitRateLimiter */
class bc implements ba {
    private final long f14159a;
    private final int f14160b;
    private double f14161c;
    private long f14162d;
    private final Object f14163e;

    public bc(int i, long j) {
        this.f14163e = new Object();
        this.f14160b = i;
        this.f14161c = (double) this.f14160b;
        this.f14159a = j;
    }

    public bc() {
        this(60, 2000);
    }

    public boolean mo4249a() {
        boolean z;
        synchronized (this.f14163e) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f14161c < ((double) this.f14160b)) {
                double d = ((double) (currentTimeMillis - this.f14162d)) / ((double) this.f14159a);
                if (d > 0.0d) {
                    this.f14161c = Math.min((double) this.f14160b, d + this.f14161c);
                }
            }
            this.f14162d = currentTimeMillis;
            if (this.f14161c >= WeightedLatLng.DEFAULT_INTENSITY) {
                this.f14161c -= WeightedLatLng.DEFAULT_INTENSITY;
                z = true;
            } else {
                ar.m18269d("Excessive tracking detected.  Tracking call ignored.");
                z = false;
            }
        }
        return z;
    }
}
