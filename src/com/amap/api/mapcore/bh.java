package com.amap.api.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.mapcore.util.bk;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: ProjectionDelegateImp */
class bh implements al {
    private aa f11085a;

    public bh(aa aaVar) {
        this.f11085a = aaVar;
    }

    public LatLng mo3918a(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint dPoint = new DPoint();
        this.f11085a.mo3771a(point.x, point.y, dPoint);
        return new LatLng(dPoint.f13251y, dPoint.f13250x);
    }

    public Point mo3917a(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint iPoint = new IPoint();
        this.f11085a.mo3802b(latLng.latitude, latLng.longitude, iPoint);
        return new Point(iPoint.f13273x, iPoint.f13274y);
    }

    public VisibleRegion mo3921a() throws RemoteException {
        int k = this.f11085a.mo3827k();
        int l = this.f11085a.mo3829l();
        LatLng a = mo3918a(new Point(0, 0));
        LatLng a2 = mo3918a(new Point(k, 0));
        LatLng a3 = mo3918a(new Point(0, l));
        LatLng a4 = mo3918a(new Point(k, l));
        return new VisibleRegion(a3, a4, a, a2, LatLngBounds.builder().include(a3).include(a4).include(a).include(a2).build());
    }

    public PointF mo3922b(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint fPoint = new FPoint();
        this.f11085a.mo3764a(latLng.latitude, latLng.longitude, fPoint);
        return new PointF(fPoint.f13252x, fPoint.f13253y);
    }

    public float mo3916a(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        return this.f11085a.mo3808c(i);
    }

    public TileProjection mo3920a(LatLngBounds latLngBounds, int i, int i2) throws RemoteException {
        if (latLngBounds == null || i < 0 || i > 20 || i2 <= 0) {
            return null;
        }
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        this.f11085a.mo3765a(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, iPoint);
        this.f11085a.mo3765a(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, iPoint2);
        int i3 = (iPoint.f13273x >> (20 - i)) / i2;
        int i4 = (iPoint2.f13274y >> (20 - i)) / i2;
        return new TileProjection((iPoint.f13273x - ((i3 << (20 - i)) * i2)) >> (20 - i), (iPoint2.f13274y - ((i4 << (20 - i)) * i2)) >> (20 - i), i3, (iPoint2.f13273x >> (20 - i)) / i2, i4, (iPoint.f13274y >> (20 - i)) / i2);
    }

    public LatLngBounds mo3919a(LatLng latLng, float f) throws RemoteException {
        if (this.f11085a == null || latLng == null) {
            return null;
        }
        return this.f11085a.mo3759a(latLng, bk.m15640a(f));
    }
}
