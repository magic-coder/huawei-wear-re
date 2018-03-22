package com.amap.api.mapcore;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: CameraUpdateFactoryDelegate */
public class C3259o {
    C3258a f11323a = C3258a.none;
    float f11324b;
    float f11325c;
    float f11326d;
    float f11327e;
    float f11328f;
    float f11329g;
    CameraPosition f11330h;
    LatLngBounds f11331i;
    int f11332j;
    int f11333k;
    int f11334l;
    Point f11335m = null;
    boolean f11336n = false;
    IPoint f11337o;
    boolean f11338p = false;

    /* compiled from: CameraUpdateFactoryDelegate */
    enum C3258a {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    private C3259o() {
    }

    public static C3259o m15323a() {
        return new C3259o();
    }

    public static C3259o m15336b() {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.zoomIn;
        return a;
    }

    public static C3259o m15338c() {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.zoomOut;
        return a;
    }

    public static C3259o m15325a(float f, float f2) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.scrollBy;
        a.f11324b = f;
        a.f11325c = f2;
        return a;
    }

    public static C3259o m15324a(float f) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.zoomTo;
        a.f11326d = f;
        return a;
    }

    public static C3259o m15337b(float f) {
        return C3259o.m15326a(f, null);
    }

    public static C3259o m15326a(float f, Point point) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.zoomBy;
        a.f11327e = f;
        a.f11335m = point;
        return a;
    }

    public static C3259o m15328a(CameraPosition cameraPosition) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.newCameraPosition;
        a.f11330h = cameraPosition;
        return a;
    }

    public static C3259o m15334a(IPoint iPoint) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.changeCenter;
        a.f11337o = iPoint;
        return a;
    }

    public static C3259o m15339c(float f) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.changeTilt;
        a.f11328f = f;
        return a;
    }

    public static C3259o m15340d(float f) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.changeBearing;
        a.f11329g = f;
        return a;
    }

    public static C3259o m15327a(float f, IPoint iPoint) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.changeBearingGeoCenter;
        a.f11329g = f;
        a.f11337o = iPoint;
        return a;
    }

    public static C3259o m15329a(LatLng latLng) {
        return C3259o.m15328a(CameraPosition.builder().target(latLng).build());
    }

    public static C3259o m15330a(LatLng latLng, float f) {
        return C3259o.m15328a(CameraPosition.builder().target(latLng).zoom(f).build());
    }

    public static C3259o m15331a(LatLng latLng, float f, float f2, float f3) {
        return C3259o.m15328a(CameraPosition.builder().target(latLng).zoom(f).bearing(f2).tilt(f3).build());
    }

    static C3259o m15335a(IPoint iPoint, float f, float f2, float f3) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.changeGeoCenterZoomTiltBearing;
        a.f11337o = iPoint;
        a.f11326d = f;
        a.f11329g = f2;
        a.f11328f = f3;
        return a;
    }

    public static C3259o m15332a(LatLngBounds latLngBounds, int i) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.newLatLngBounds;
        a.f11331i = latLngBounds;
        a.f11332j = i;
        return a;
    }

    public static C3259o m15333a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        C3259o a = C3259o.m15323a();
        a.f11323a = C3258a.newLatLngBoundsWithSize;
        a.f11331i = latLngBounds;
        a.f11332j = i3;
        a.f11333k = i;
        a.f11334l = i2;
        return a;
    }
}
