package com.amap.api.mapcore;

import android.location.Location;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;

/* compiled from: AMapOnLocationChangedListener */
class C3255l implements OnLocationChangedListener {
    Location f11242a;
    private aa f11243b;

    C3255l(aa aaVar) {
        this.f11243b = aaVar;
    }

    public void onLocationChanged(Location location) {
        this.f11242a = location;
        try {
            if (this.f11243b.mo3841x()) {
                this.f11243b.mo3774a(location);
            }
        } catch (Throwable e) {
            ca.m15831a(e, "AMapOnLocationChangedListener", "onLocationChanged");
            e.printStackTrace();
        }
    }
}
