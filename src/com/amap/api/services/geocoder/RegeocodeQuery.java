package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

public class RegeocodeQuery {
    private LatLonPoint f12590a;
    private float f12591b;
    private String f12592c = GeocodeSearch.AMAP;

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.f12590a = latLonPoint;
        this.f12591b = f;
        setLatLonType(str);
    }

    public LatLonPoint getPoint() {
        return this.f12590a;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f12590a = latLonPoint;
    }

    public float getRadius() {
        return this.f12591b;
    }

    public void setRadius(float f) {
        this.f12591b = f;
    }

    public String getLatLonType() {
        return this.f12592c;
    }

    public void setLatLonType(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(GeocodeSearch.AMAP) || str.equals("gps")) {
            this.f12592c = str;
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12592c == null ? 0 : this.f12592c.hashCode()) + 31) * 31;
        if (this.f12590a != null) {
            i = this.f12590a.hashCode();
        }
        return ((hashCode + i) * 31) + Float.floatToIntBits(this.f12591b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        if (this.f12592c == null) {
            if (regeocodeQuery.f12592c != null) {
                return false;
            }
        } else if (!this.f12592c.equals(regeocodeQuery.f12592c)) {
            return false;
        }
        if (this.f12590a == null) {
            if (regeocodeQuery.f12590a != null) {
                return false;
            }
        } else if (!this.f12590a.equals(regeocodeQuery.f12590a)) {
            return false;
        }
        if (Float.floatToIntBits(this.f12591b) != Float.floatToIntBits(regeocodeQuery.f12591b)) {
            return false;
        }
        return true;
    }
}
