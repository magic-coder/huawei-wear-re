package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Point;
import android.os.Message;
import android.os.RemoteException;
import com.amap.api.mapcore.C3259o.C3258a;
import com.amap.api.mapcore.util.C3320f;
import com.amap.api.mapcore.util.bf;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.WeightedLatLng;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.BaseMapCallImplement;
import com.autonavi.amap.mapcore.Convert;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.MapSourceGridData;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: AMapCallback */
class C3228a extends BaseMapCallImplement {
    IPoint f10874a = new IPoint();
    float f10875b;
    float f10876c;
    float f10877d;
    IPoint f10878e = new IPoint();
    private AMapDelegateImp f10879f;
    private float f10880g = GroundOverlayOptions.NO_DIMENSION;
    private int f10881h;
    private int f10882i;

    public String getMapSvrAddress() {
        return "http://mps.amap.com";
    }

    public C3228a(AMapDelegateImp aMapDelegateImp) {
        this.f10879f = aMapDelegateImp;
    }

    public void OnMapSurfaceCreate(GL10 gl10, MapCore mapCore) {
        super.OnMapSurfaceCreate(mapCore);
    }

    public void OnMapSurfaceRenderer(GL10 gl10, MapCore mapCore, int i) {
        super.OnMapSurfaceRenderer(gl10, mapCore, i);
        if (i == 3) {
            this.f10879f.f10854h.m16341a(gl10, true, this.f10879f.mo3748Q());
            if (this.f10879f.f10859m != null) {
                this.f10879f.f10859m.onDrawFrame(gl10);
            }
        }
    }

    public void OnMapSufaceChanged(GL10 gl10, MapCore mapCore, int i, int i2) {
    }

    public void OnMapProcessEvent(MapCore mapCore) {
        float f = 0.0f;
        if (this.f10879f != null && this.f10879f.m14522O()) {
            this.f10879f.m14523P();
        }
        if (this.f10879f != null) {
            float E = this.f10879f.mo3740E();
            m14656a(mapCore);
            while (true) {
                at b = this.f10879f.f10851e.m14848b();
                if (b == null) {
                    break;
                } else if (b.f10932a == 2) {
                    if (b.m14844a()) {
                        mapCore.setParameter(2010, 4, 0, 0, 0);
                    } else {
                        mapCore.setParameter(2010, 0, 0, 0, 0);
                    }
                }
            }
            mapCore.setMapstate(this.f10879f.mo3809c());
            if (!(this.f10875b < this.f10879f.mo3836s() || this.f10880g == E || this.f10879f.f10858l == null)) {
                this.f10879f.f10858l.obtainMessage(21).sendToTarget();
            }
            f = E;
        }
        this.f10880g = f;
    }

    void m14656a(MapCore mapCore) {
        Object obj = null;
        MapProjection c = this.f10879f.mo3809c();
        float mapZoomer = c.getMapZoomer();
        float cameraHeaderAngle = c.getCameraHeaderAngle();
        float mapAngle = c.getMapAngle();
        c.getGeoCenter(this.f10878e);
        int i = 0;
        while (true) {
            C3259o d = this.f10879f.f10851e.m14850d();
            if (d == null) {
                break;
            }
            try {
                m14655a(d);
                i |= d.f11338p;
            } catch (Throwable e) {
                ca.m15831a(e, "AMapCallback", "runMessage");
                e.printStackTrace();
            }
        }
        this.f10875b = c.getMapZoomer();
        this.f10876c = c.getCameraHeaderAngle();
        this.f10877d = c.getMapAngle();
        c.getGeoCenter(this.f10874a);
        if (!(mapZoomer == this.f10875b && this.f10876c == cameraHeaderAngle && this.f10877d == mapAngle && this.f10874a.f13273x == this.f10878e.f13273x && this.f10874a.f13274y == this.f10878e.f13274y)) {
            obj = 1;
        }
        if (obj != null) {
            try {
                this.f10879f.mo3816e(false);
                if (this.f10879f.m14509B() != null) {
                    DPoint dPoint = new DPoint();
                    MapProjection.geo2LonLat(this.f10874a.f13273x, this.f10874a.f13274y, dPoint);
                    this.f10879f.m14580a(new CameraPosition(new LatLng(dPoint.f13251y, dPoint.f13250x, false), this.f10875b, this.f10876c, this.f10877d));
                }
                this.f10879f.m14513F();
            } catch (Throwable e2) {
                ca.m15831a(e2, "AMapCallback", "runMessage cameraChange");
                e2.printStackTrace();
                return;
            }
        }
        this.f10879f.mo3816e(true);
        if (i != 0) {
            if (i != 0) {
                this.f10879f.m14626m(true);
            } else {
                this.f10879f.m14626m(false);
            }
            Message message = new Message();
            message.what = 17;
            this.f10879f.f10858l.sendMessage(message);
        }
        if (!(this.f10876c == cameraHeaderAngle && this.f10877d == mapAngle) && this.f10879f.mo3843z().mo3963c()) {
            this.f10879f.m14611g();
        }
        if (mapZoomer != this.f10875b && this.f10879f.mo3843z().mo3958a()) {
            this.f10879f.m14614h();
        }
    }

    private void m14650b(C3259o c3259o) {
        MapCore a = this.f10879f.m14544a();
        MapProjection c = this.f10879f.mo3809c();
        LatLngBounds latLngBounds = c3259o.f11331i;
        int i = c3259o.f11333k;
        int i2 = c3259o.f11334l;
        int i3 = c3259o.f11332j;
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.northeast.latitude, iPoint);
        MapProjection.lonlat2Geo(latLngBounds.southwest.longitude, latLngBounds.southwest.latitude, iPoint2);
        int i4 = iPoint2.f13274y - iPoint.f13274y;
        int i5 = i - (i3 * 2);
        i = i2 - (i3 * 2);
        if (iPoint.f13273x - iPoint2.f13273x >= 0 || i4 >= 0) {
            if (i5 <= 0) {
                i5 = 1;
            }
            if (i <= 0) {
                i = 1;
            }
            float a2 = m14641a(latLngBounds.northeast, latLngBounds.southwest, i5, i);
            i5 = (iPoint.f13273x + iPoint2.f13273x) / 2;
            int i6 = (iPoint.f13274y + iPoint2.f13274y) / 2;
            c.setMapZoomer(a2);
            c.setGeoCenter(i5, i6);
            c.setCameraHeaderAngle(0.0f);
            c.setMapAngle(0.0f);
            a.setMapstate(c);
        }
    }

    private float m14641a(LatLng latLng, LatLng latLng2, int i, int i2) {
        float a;
        MapProjection c = this.f10879f.mo3809c();
        c.setMapAngle(0.0f);
        c.setCameraHeaderAngle(0.0f);
        c.recalculate();
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        this.f10879f.mo3802b(latLng.latitude, latLng.longitude, iPoint);
        this.f10879f.mo3802b(latLng2.latitude, latLng2.longitude, iPoint2);
        double d = (double) (iPoint.f13273x - iPoint2.f13273x);
        double d2 = (double) (iPoint2.f13274y - iPoint.f13274y);
        if (d <= 0.0d) {
            d = WeightedLatLng.DEFAULT_INTENSITY;
        }
        if (d2 <= 0.0d) {
            d2 = WeightedLatLng.DEFAULT_INTENSITY;
        }
        d = Math.log(((double) i) / d) / Math.log(2.0d);
        double min = Math.min(d, Math.log(((double) i2) / d2) / Math.log(2.0d));
        Object obj = Math.abs(min - d) < 1.0E-7d ? 1 : null;
        float a2 = bk.m15640a((float) (((double) c.getMapZoomer()) + Math.floor(min)));
        while (true) {
            a = bk.m15640a((float) (((double) a2) + 0.1d));
            c.setMapZoomer(a);
            c.recalculate();
            this.f10879f.mo3802b(latLng.latitude, latLng.longitude, iPoint);
            this.f10879f.mo3802b(latLng2.latitude, latLng2.longitude, iPoint2);
            d = (double) (iPoint.f13273x - iPoint2.f13273x);
            min = (double) (iPoint2.f13274y - iPoint.f13274y);
            if (obj != null) {
                if (d >= ((double) i)) {
                    break;
                }
                if (a < 19.0f) {
                    return a;
                }
                a2 = a;
            } else {
                if (min >= ((double) i2)) {
                    break;
                }
                if (a < 19.0f) {
                    return a;
                }
                a2 = a;
            }
        }
        return (float) (((double) a) - 0.1d);
    }

    void m14655a(C3259o c3259o) throws RemoteException {
        MapCore a = this.f10879f.m14544a();
        MapProjection c = this.f10879f.mo3809c();
        c3259o.f11326d = this.f10879f.m14590b(c3259o.f11326d);
        float b;
        switch (C3238b.f10996a[c3259o.f11323a.ordinal()]) {
            case 1:
                if (c3259o.f11336n) {
                    m14647a(c, c3259o.f11337o);
                } else {
                    c.setGeoCenter(c3259o.f11337o.f13273x, c3259o.f11337o.f13274y);
                }
                a.setMapstate(c);
                return;
            case 2:
                if (c3259o.f11336n) {
                    m14653d(c, c3259o);
                } else {
                    c.setMapAngle(c3259o.f11329g);
                }
                a.setMapstate(c);
                return;
            case 3:
                if (c3259o.f11336n) {
                    m14646a(c, c3259o);
                } else {
                    c.setMapAngle(c3259o.f11329g);
                    c.setGeoCenter(c3259o.f11337o.f13273x, c3259o.f11337o.f13274y);
                }
                a.setMapstate(c);
                return;
            case 4:
                c3259o.f11328f = bk.m15641a(c3259o.f11328f, c.getMapZoomer());
                if (c3259o.f11336n) {
                    m14652c(c, c3259o);
                } else {
                    c.setCameraHeaderAngle(c3259o.f11328f);
                }
                a.setMapstate(c);
                return;
            case 5:
                if (c3259o.f11336n) {
                    m14651b(c, c3259o);
                } else {
                    c.setGeoCenter(c3259o.f11337o.f13273x, c3259o.f11337o.f13274y);
                    c.setMapZoomer(c3259o.f11326d);
                }
                a.setMapstate(c);
                return;
            case 6:
                LatLng latLng = c3259o.f11330h.target;
                IPoint iPoint = new IPoint();
                MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
                float a2 = bk.m15640a(c3259o.f11330h.zoom);
                float f = c3259o.f11330h.bearing;
                float a3 = bk.m15641a(c3259o.f11330h.tilt, a2);
                if (c3259o.f11336n) {
                    m14648a(c, iPoint, a2, f, a3);
                } else {
                    c.setGeoCenter(iPoint.f13273x, iPoint.f13274y);
                    c.setMapZoomer(a2);
                    c.setMapAngle(f);
                    c.setCameraHeaderAngle(a3);
                }
                a.setMapstate(c);
                return;
            case 7:
                b = this.f10879f.m14590b(c.getMapZoomer() + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                if (c3259o.f11336n) {
                    m14644a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case 8:
                b = this.f10879f.m14590b(c.getMapZoomer() - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                if (c3259o.f11336n) {
                    m14644a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                c.setMapZoomer(b);
                a.setMapstate(c);
                return;
            case 9:
                b = c3259o.f11326d;
                if (c3259o.f11336n) {
                    m14644a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case 10:
                b = this.f10879f.m14590b(c.getMapZoomer() + c3259o.f11327e);
                Point point = c3259o.f11335m;
                if (point != null) {
                    m14645a(c, b, point.x, point.y);
                } else if (c3259o.f11336n) {
                    m14644a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case 11:
                b = c3259o.f11324b;
                b += ((float) this.f10879f.m14625m()) / 2.0f;
                float n = c3259o.f11325c + (((float) this.f10879f.m14627n()) / 2.0f);
                IPoint iPoint2 = new IPoint();
                this.f10879f.mo3773a((int) b, (int) n, iPoint2);
                c.setGeoCenter(iPoint2.f13273x, iPoint2.f13274y);
                a.setMapstate(c);
                return;
            case 12:
                c3259o.f11323a = C3258a.newLatLngBoundsWithSize;
                c3259o.f11333k = this.f10879f.m14625m();
                c3259o.f11334l = this.f10879f.m14627n();
                m14650b(c3259o);
                return;
            case 13:
                m14650b(c3259o);
                return;
            case 14:
                c3259o.f11328f = bk.m15641a(c3259o.f11328f, c3259o.f11326d);
                if (c3259o.f11336n) {
                    m14648a(c, c3259o.f11337o, c3259o.f11326d, c3259o.f11329g, c3259o.f11328f);
                } else {
                    c.setGeoCenter(c3259o.f11337o.f13273x, c3259o.f11337o.f13274y);
                    c.setMapZoomer(c3259o.f11326d);
                    c.setMapAngle(c3259o.f11329g);
                    c.setCameraHeaderAngle(c3259o.f11328f);
                }
                a.setMapstate(c);
                return;
            default:
                a.setMapstate(c);
                return;
        }
    }

    private void m14646a(MapProjection mapProjection, C3259o c3259o) {
        mapProjection.setMapAngle(c3259o.f11329g);
        m14647a(mapProjection, c3259o.f11337o);
    }

    private void m14644a(MapProjection mapProjection, float f) {
        m14645a(mapProjection, f, this.f10881h, this.f10882i);
    }

    private void m14645a(MapProjection mapProjection, float f, int i, int i2) {
        IPoint a = m14643a(mapProjection, i, i2);
        mapProjection.setMapZoomer(f);
        m14649a(mapProjection, a, i, i2);
    }

    private void m14648a(MapProjection mapProjection, IPoint iPoint, float f, float f2, float f3) {
        mapProjection.setMapZoomer(f);
        mapProjection.setMapAngle(f2);
        mapProjection.setCameraHeaderAngle(f3);
        m14647a(mapProjection, iPoint);
    }

    private void m14651b(MapProjection mapProjection, C3259o c3259o) {
        mapProjection.setMapZoomer(c3259o.f11326d);
        m14647a(mapProjection, c3259o.f11337o);
    }

    private void m14652c(MapProjection mapProjection, C3259o c3259o) {
        IPoint a = m14642a(mapProjection);
        mapProjection.setCameraHeaderAngle(c3259o.f11328f);
        m14647a(mapProjection, a);
    }

    private void m14653d(MapProjection mapProjection, C3259o c3259o) {
        IPoint a = m14642a(mapProjection);
        mapProjection.setMapAngle(c3259o.f11329g);
        m14647a(mapProjection, a);
    }

    private void m14647a(MapProjection mapProjection, IPoint iPoint) {
        m14649a(mapProjection, iPoint, this.f10881h, this.f10882i);
    }

    private void m14649a(MapProjection mapProjection, IPoint iPoint, int i, int i2) {
        mapProjection.recalculate();
        IPoint a = m14643a(mapProjection, i, i2);
        IPoint iPoint2 = new IPoint();
        mapProjection.getGeoCenter(iPoint2);
        mapProjection.setGeoCenter((iPoint2.f13273x + iPoint.f13273x) - a.f13273x, (iPoint2.f13274y + iPoint.f13274y) - a.f13274y);
    }

    private IPoint m14642a(MapProjection mapProjection) {
        return m14643a(mapProjection, this.f10881h, this.f10882i);
    }

    private IPoint m14643a(MapProjection mapProjection, int i, int i2) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        IPoint iPoint = new IPoint();
        mapProjection.map2Geo(fPoint.f13252x, fPoint.f13253y, iPoint);
        return iPoint;
    }

    public void OnMapDestory(GL10 gl10, MapCore mapCore) {
        super.OnMapDestory(mapCore);
    }

    public void OnMapReferencechanged(MapCore mapCore, String str, String str2) {
        try {
            if (this.f10879f.mo3843z().mo3963c()) {
                this.f10879f.m14611g();
            }
            if (this.f10879f.mo3843z().mo3958a()) {
                this.f10879f.m14614h();
            }
            this.f10879f.m14626m(true);
        } catch (Throwable e) {
            ca.m15831a(e, "AMapCallback", "OnMapReferencechanged");
            e.printStackTrace();
        }
        this.f10879f.m14528U();
    }

    public Context getContext() {
        return this.f10879f.m14529V();
    }

    public boolean isMapEngineValid() {
        if (this.f10879f.m14544a() != null) {
            return this.f10879f.m14544a().isMapEngineValid();
        }
        return false;
    }

    public void OnMapLoaderError(int i) {
        bf.m15627a("MapCore", "OnMapLoaderError=" + i, 112);
    }

    public void m14654a(int i, int i2) {
        this.f10881h = i;
        this.f10882i = i2;
    }

    public void requestRender() {
        this.f10879f.mo3816e(false);
    }

    public void onIndoorBuildingActivity(MapCore mapCore, byte[] bArr) {
        C3320f c3320f = null;
        if (bArr != null) {
            try {
                C3320f c3320f2 = new C3320f();
                byte b = bArr[0];
                c3320f2.f11752a = new String(bArr, 1, b);
                int i = b + 1;
                int i2 = i + 1;
                b = bArr[i];
                c3320f2.f11753b = new String(bArr, i2, b);
                i = b + i2;
                i2 = i + 1;
                b = bArr[i];
                c3320f2.f11754c = new String(bArr, i2, b);
                i = b + i2;
                c3320f2.f11755d = Convert.getInt(bArr, i);
                i += 4;
                i2 = i + 1;
                b = bArr[i];
                c3320f2.f11756e = new String(bArr, i2, b);
                i = b + i2;
                c3320f2.f11757f = Convert.getInt(bArr, i);
                i += 4;
                c3320f2.f11758g = new int[c3320f2.f11757f];
                c3320f2.f11759h = new String[c3320f2.f11757f];
                c3320f2.f11760i = new String[c3320f2.f11757f];
                for (int i3 = 0; i3 < c3320f2.f11757f; i3++) {
                    c3320f2.f11758g[i3] = Convert.getInt(bArr, i);
                    i2 = i + 4;
                    i = i2 + 1;
                    byte b2 = bArr[i2];
                    if (b2 > (byte) 0) {
                        c3320f2.f11759h[i3] = new String(bArr, i, b2);
                        i2 = i + b2;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    b2 = bArr[i2];
                    if (b2 > (byte) 0) {
                        c3320f2.f11760i[i3] = new String(bArr, i, b2);
                        i += b2;
                    }
                }
                c3320f2.f11761j = Convert.getInt(bArr, i);
                i += 4;
                if (c3320f2.f11761j > 0) {
                    c3320f2.f11762k = new int[c3320f2.f11761j];
                    int i4 = i;
                    for (i = 0; i < c3320f2.f11761j; i++) {
                        c3320f2.f11762k[i] = Convert.getInt(bArr, i4);
                        i4 += 4;
                    }
                }
                c3320f = c3320f2;
            } catch (Throwable th) {
                th.printStackTrace();
                ca.m15831a(th, "AMapCallback", "onIndoorBuildingActivity");
                return;
            }
        }
        this.f10879f.m14562a(c3320f);
    }

    public void onIndoorDataRequired(MapCore mapCore, int i, String[] strArr, int[] iArr, int[] iArr2) {
        if (strArr != null && strArr.length != 0) {
            ArrayList reqGridList = getReqGridList(i);
            if (reqGridList != null) {
                reqGridList.clear();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    reqGridList.add(new MapSourceGridData(strArr[i2], i, iArr[i2], iArr2[i2]));
                }
                if (i != 5) {
                    proccessRequiredData(mapCore, reqGridList, i);
                }
            }
        }
    }
}
