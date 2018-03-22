package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.mapcore.C3259o;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        return new CameraUpdate(C3259o.m15336b());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(C3259o.m15338c());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(C3259o.m15325a(f, f2));
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(C3259o.m15324a(f));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(C3259o.m15337b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(C3259o.m15326a(f, point));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(C3259o.m15328a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(C3259o.m15329a(latLng));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        return new CameraUpdate(C3259o.m15330a(latLng, f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return new CameraUpdate(C3259o.m15332a(latLngBounds, i));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        return new CameraUpdate(C3259o.m15334a(iPoint));
    }

    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(C3259o.m15340d(f % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f, IPoint iPoint) {
        return new CameraUpdate(C3259o.m15327a(f % 360.0f, iPoint));
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(C3259o.m15339c(f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        return new CameraUpdate(C3259o.m15333a(latLngBounds, i, i2, i3));
    }
}
