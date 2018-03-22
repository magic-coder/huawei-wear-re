package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;

/* compiled from: LocationListenerProxy */
public class C3200h implements AMapLocationListener {
    private LocationManagerProxy f10722a;
    private AMapLocationListener f10723b = null;

    public C3200h(LocationManagerProxy locationManagerProxy) {
        this.f10722a = locationManagerProxy;
    }

    public boolean m14174a(AMapLocationListener aMapLocationListener, long j, float f, String str) {
        this.f10723b = aMapLocationListener;
        if (!LocationProviderProxy.AMapNetwork.equals(str)) {
            return false;
        }
        this.f10722a.requestLocationUpdates(str, j, f, this);
        return true;
    }

    public void m14173a() {
        if (this.f10722a != null) {
            this.f10722a.removeUpdates(this);
        }
        this.f10723b = null;
    }

    public void onLocationChanged(Location location) {
        if (this.f10723b != null) {
            this.f10723b.onLocationChanged(location);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (this.f10723b != null) {
            this.f10723b.onStatusChanged(str, i, bundle);
        }
    }

    public void onProviderEnabled(String str) {
        if (this.f10723b != null) {
            this.f10723b.onProviderEnabled(str);
        }
    }

    public void onProviderDisabled(String str) {
        if (this.f10723b != null) {
            this.f10723b.onProviderDisabled(str);
        }
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (this.f10723b != null) {
            this.f10723b.onLocationChanged(aMapLocation);
        }
    }
}
