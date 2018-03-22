package com.amap.api.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.SystemClock;

/* compiled from: IGPSManager */
class C3197e implements LocationListener {
    final /* synthetic */ C3196d f10719a;

    C3197e(C3196d c3196d) {
        this.f10719a = c3196d;
    }

    public void onLocationChanged(Location location) {
        this.f10719a.f10716e.m14081b(true);
        this.f10719a.f10716e.f10639e = SystemClock.elapsedRealtime();
    }

    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            this.f10719a.f10716e.m14081b(false);
        }
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0 || i == 1) {
            this.f10719a.f10716e.m14081b(false);
        }
    }
}
