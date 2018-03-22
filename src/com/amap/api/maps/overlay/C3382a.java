package com.amap.api.maps.overlay;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AMapServicesUtil */
class C3382a {
    public static int f12208a = 2048;

    C3382a() {
    }

    public static LatLng m16539a(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    public static ArrayList<LatLng> m16540a(List<LatLonPoint> list) {
        ArrayList<LatLng> arrayList = new ArrayList();
        for (LatLonPoint a : list) {
            arrayList.add(C3382a.m16539a(a));
        }
        return arrayList;
    }
}
