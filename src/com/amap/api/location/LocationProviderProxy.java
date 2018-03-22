package com.amap.api.location;

import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;

public class LocationProviderProxy {
    public static final String AMapNetwork = "lbs";
    public static final int AVAILABLE = 2;
    public static final int OUT_OF_SERVICE = 0;
    public static final int TEMPORARILY_UNAVAILABLE = 1;
    private LocationManager f10628a;
    private String f10629b;

    protected LocationProviderProxy(LocationManager locationManager, String str) {
        this.f10628a = locationManager;
        this.f10629b = str;
    }

    static LocationProviderProxy m14059a(LocationManager locationManager, String str) {
        return new LocationProviderProxy(locationManager, str);
    }

    private LocationProvider m14058a() {
        try {
            if (this.f10628a != null) {
                return this.f10628a.getProvider(this.f10629b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public int getAccuracy() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f10629b)) {
                return 2;
            }
            if (m14058a() != null) {
                return m14058a().getAccuracy();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getName() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f10629b)) {
                return AMapNetwork;
            }
            if (m14058a() != null) {
                return m14058a().getName();
            }
            return "null";
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getPowerRequirement() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f10629b)) {
                return 2;
            }
            if (m14058a() != null) {
                return m14058a().getPowerRequirement();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean hasMonetaryCost() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f10629b)) && m14058a() != null) {
                z = m14058a().hasMonetaryCost();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean meetsCriteria(Criteria criteria) {
        try {
            if (AMapNetwork == null || !AMapNetwork.equals(this.f10629b)) {
                if (m14058a() != null) {
                    return m14058a().meetsCriteria(criteria);
                }
                return false;
            } else if (criteria == null) {
                return true;
            } else {
                if (criteria.isAltitudeRequired() || criteria.isBearingRequired() || criteria.isSpeedRequired() || criteria.getAccuracy() == 1) {
                    return false;
                }
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean requiresCell() {
        boolean z = true;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f10629b)) && m14058a() != null) {
                z = m14058a().requiresCell();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean requiresNetwork() {
        boolean z = true;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f10629b)) && m14058a() != null) {
                z = m14058a().requiresNetwork();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean requiresSatellite() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f10629b)) {
                return false;
            }
            if (m14058a() != null) {
                return m14058a().requiresNetwork();
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean supportsAltitude() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f10629b)) && m14058a() != null) {
                z = m14058a().supportsAltitude();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean supportsBearing() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f10629b)) && m14058a() != null) {
                z = m14058a().supportsBearing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean supportsSpeed() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f10629b)) && m14058a() != null) {
                z = m14058a().supportsSpeed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }
}
