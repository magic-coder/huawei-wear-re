package com.amap.api.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

/* compiled from: IProjectionDelegate */
public interface al {
    float mo3916a(int i) throws RemoteException;

    Point mo3917a(LatLng latLng) throws RemoteException;

    LatLng mo3918a(Point point) throws RemoteException;

    LatLngBounds mo3919a(LatLng latLng, float f) throws RemoteException;

    TileProjection mo3920a(LatLngBounds latLngBounds, int i, int i2) throws RemoteException;

    VisibleRegion mo3921a() throws RemoteException;

    PointF mo3922b(LatLng latLng) throws RemoteException;
}
