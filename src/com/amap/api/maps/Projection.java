package com.amap.api.maps;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.mapcore.al;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

public class Projection {
    private final al f130a;

    Projection(al alVar) {
        this.f130a = alVar;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.f130a.a(point);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.f130a.a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public PointF toMapLocation(LatLng latLng) {
        try {
            return this.f130a.b(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public PointF toOpenGLLocation(LatLng latLng) {
        try {
            return this.f130a.b(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float toOpenGLWidth(int i) {
        try {
            return this.f130a.a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.f130a.a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) {
        try {
            return this.f130a.a(latLngBounds, i, i2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLngBounds getMapBounds(LatLng latLng, float f) {
        try {
            return this.f130a.a(latLng, f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
