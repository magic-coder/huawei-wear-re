package com.huawei.hwlocationmgr.util;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.huawei.p190v.C2538c;

/* compiled from: LocationMgrUtil */
class C5319d implements LocationListener {
    final /* synthetic */ C5316a f19046a;
    private boolean f19047b;

    private C5319d(C5316a c5316a) {
        this.f19046a = c5316a;
        this.f19047b = false;
    }

    public void onLocationChanged(Location location) {
        C2538c.c("LocationMgrUtil", new Object[]{"MyLocationListner()xxx location obtain success"});
        this.f19046a.f19035j = location;
        this.f19046a.m25712b(this.f19046a.f19035j);
        if (location != null && !this.f19047b && location.getProvider().equals("gps")) {
            this.f19046a.m25711b();
            this.f19047b = true;
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0 && "gps".equals(str)) {
            this.f19046a.m25717d();
        }
    }
}
