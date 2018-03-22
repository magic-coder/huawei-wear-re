package com.amap.api.maps.model;

public class RoutePara {
    private int f12116a = 0;
    private int f12117b = 0;
    private LatLng f12118c;
    private LatLng f12119d;
    private String f12120e;
    private String f12121f;

    public int getDrivingRouteStyle() {
        return this.f12116a;
    }

    public void setDrivingRouteStyle(int i) {
        if (i >= 0 && i < 9) {
            this.f12116a = i;
        }
    }

    public int getTransitRouteStyle() {
        return this.f12117b;
    }

    public void setTransitRouteStyle(int i) {
        if (i >= 0 && i < 6) {
            this.f12117b = i;
        }
    }

    public LatLng getStartPoint() {
        return this.f12118c;
    }

    public void setStartPoint(LatLng latLng) {
        this.f12118c = latLng;
    }

    public LatLng getEndPoint() {
        return this.f12119d;
    }

    public void setEndPoint(LatLng latLng) {
        this.f12119d = latLng;
    }

    public String getEndName() {
        return this.f12121f;
    }

    public void setEndName(String str) {
        this.f12121f = str;
    }

    public String getStartName() {
        return this.f12120e;
    }

    public void setStartName(String str) {
        this.f12120e = str;
    }
}
