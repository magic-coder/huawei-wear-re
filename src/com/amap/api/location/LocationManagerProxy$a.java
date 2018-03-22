package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;

class LocationManagerProxy$a implements AMapLocationListener {
    final /* synthetic */ LocationManagerProxy f10626a;

    LocationManagerProxy$a(LocationManagerProxy locationManagerProxy) {
        this.f10626a = locationManagerProxy;
    }

    public void onLocationChanged(Location location) {
        int i = 0;
        int i2;
        C3201i c3201i;
        if (location != null) {
            try {
                AMapLocation aMapLocation = new AMapLocation(location);
                i2 = 0;
                while (LocationManagerProxy.c(this.f10626a) != null && i2 < LocationManagerProxy.c(this.f10626a).size()) {
                    c3201i = (C3201i) LocationManagerProxy.c(this.f10626a).get(i2);
                    if (c3201i != null) {
                        try {
                            if (c3201i.f10725b != null) {
                                c3201i.f10725b.onLocationChanged(aMapLocation);
                            }
                        } catch (Throwable th) {
                        }
                    }
                    if (c3201i != null) {
                        if (c3201i.f10724a == -1 && LocationManagerProxy.d(this.f10626a) != null) {
                            LocationManagerProxy.d(this.f10626a).add(c3201i);
                        }
                    }
                    i2++;
                }
                if (LocationManagerProxy.d(this.f10626a) != null && LocationManagerProxy.d(this.f10626a).size() > 0 && LocationManagerProxy.c(this.f10626a) != null) {
                    while (i < LocationManagerProxy.d(this.f10626a).size()) {
                        LocationManagerProxy.c(this.f10626a).remove(LocationManagerProxy.d(this.f10626a).get(i));
                        i++;
                    }
                    LocationManagerProxy.d(this.f10626a).clear();
                    if (LocationManagerProxy.c(this.f10626a).size() == 0 && LocationManagerProxy.e(this.f10626a) != null && LocationManagerProxy.f(this.f10626a) != null) {
                        LocationManagerProxy.e(this.f10626a).removeUpdates(LocationManagerProxy.f(this.f10626a));
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        i2 = 0;
        while (LocationManagerProxy.c(this.f10626a) != null && i2 < LocationManagerProxy.c(this.f10626a).size()) {
            c3201i = (C3201i) LocationManagerProxy.c(this.f10626a).get(i2);
            if (!(c3201i == null || c3201i.f10724a != -1 || LocationManagerProxy.d(this.f10626a) == null)) {
                LocationManagerProxy.d(this.f10626a).add(c3201i);
            }
            i2++;
        }
        if (LocationManagerProxy.d(this.f10626a) != null && LocationManagerProxy.d(this.f10626a).size() > 0 && LocationManagerProxy.c(this.f10626a) != null) {
            for (int i3 = 0; i3 < LocationManagerProxy.d(this.f10626a).size(); i3++) {
                LocationManagerProxy.c(this.f10626a).remove(LocationManagerProxy.d(this.f10626a).get(i3));
            }
            LocationManagerProxy.d(this.f10626a).clear();
            if (LocationManagerProxy.c(this.f10626a).size() == 0 && LocationManagerProxy.e(this.f10626a) != null && LocationManagerProxy.f(this.f10626a) != null) {
                LocationManagerProxy.e(this.f10626a).removeUpdates(LocationManagerProxy.f(this.f10626a));
            }
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onProviderDisabled(String str) {
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
    }
}
