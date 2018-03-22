package com.huawei.nfc.carrera.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.pay.p473a.p476b.C5721c;
import java.util.HashMap;

public class LocationUtil {
    private static final String DEFAULT_LATITUDE = "0";
    private static final String DEFAULT_LONGITUDE = "0";

    public static Location getLastKnownLocation(Context context) {
        if (context == null) {
            return null;
        }
        return ((LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED)).getLastKnownLocation(LocationManagerProxy.NETWORK_PROVIDER);
    }

    public static boolean isEnableNetLocation(Context context) {
        if (context == null) {
            return false;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        return (locationManager == null || locationManager.getProvider(LocationManagerProxy.NETWORK_PROVIDER) == null) ? false : locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER);
    }

    public static HashMap<String, String> getLocationInfo(Context context) {
        LogX.i("getLocationInfo begin.");
        HashMap<String, String> hashMap = new HashMap();
        boolean z = C5721c.m26377a(context, "android.permission.ACCESS_FINE_LOCATION") && C5721c.m26377a(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (!z) {
            hashMap.put("longitude", "0");
            hashMap.put("latitude", "0");
            LogX.i("getLocationInfo failed , hasLocationPermision :" + z);
        } else if (isEnableNetLocation(context)) {
            Location lastKnownLocation = getLastKnownLocation(context);
            if (lastKnownLocation != null) {
                double longitude = lastKnownLocation.getLongitude();
                double latitude = lastKnownLocation.getLatitude();
                hashMap.put("longitude", String.valueOf(longitude));
                hashMap.put("latitude", String.valueOf(latitude));
                LogX.i("getLocationInfo success.");
            } else {
                hashMap.put("longitude", "0");
                hashMap.put("latitude", "0");
            }
        } else {
            hashMap.put("longitude", "0");
            hashMap.put("latitude", "0");
            LogX.i("getLocationInfo failed , isEnableNetLocation : false");
        }
        return hashMap;
    }
}
