package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.amap.api.mapcore.util.bh;
import com.amap.api.mapcore.util.bn;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;

/* compiled from: AMapDelegateImp */
class C3246d extends Handler {
    final /* synthetic */ AMapDelegateImp f11222a;

    C3246d(AMapDelegateImp aMapDelegateImp) {
        this.f11222a = aMapDelegateImp;
    }

    public void handleMessage(Message message) {
        if (message != null && !this.f11222a.aI.booleanValue()) {
            this.f11222a.mo3816e(false);
            CameraPosition cameraPosition;
            C3259o c3259o;
            int b;
            switch (message.what) {
                case 2:
                    Log.w("amapsdk", "Key验证失败：[" + bn.f11513b + "]");
                    break;
                case 10:
                    cameraPosition = (CameraPosition) message.obj;
                    if (!(cameraPosition == null || this.f11222a.f10840T == null)) {
                        this.f11222a.f10840T.onCameraChange(cameraPosition);
                        break;
                    }
                case 11:
                    if (this.f11222a.aw != null) {
                        try {
                            this.f11222a.mo3776a(this.f11222a.aw);
                        } catch (Throwable th) {
                            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "onMapLoaded");
                            th.printStackTrace();
                        }
                    }
                    if (this.f11222a.f10839S != null) {
                        this.f11222a.f10839S.onMapLoaded();
                        break;
                    }
                    break;
                case 12:
                    c3259o = (C3259o) message.obj;
                    if (c3259o != null) {
                        this.f11222a.f10851e.m14847a(c3259o);
                        break;
                    }
                    break;
                case 13:
                    if (this.f11222a.al != null && this.f11222a.al.m15319h()) {
                        switch (this.f11222a.al.m15321j()) {
                            case 2:
                                c3259o = C3259o.m15335a(new IPoint(this.f11222a.al.m15312b(), this.f11222a.al.m15314c()), this.f11222a.al.m15315d(), this.f11222a.al.m15316e(), this.f11222a.al.m15317f());
                                if (this.f11222a.al.m15311a()) {
                                    c3259o.f11338p = true;
                                }
                                c3259o.f11336n = this.f11222a.al.m15322k();
                                this.f11222a.f10851e.m14847a(c3259o);
                                break;
                            default:
                                b = this.f11222a.al.m15312b() - this.f11222a.am;
                                int c = this.f11222a.al.m15314c() - this.f11222a.an;
                                this.f11222a.am = this.f11222a.al.m15312b();
                                this.f11222a.an = this.f11222a.al.m15314c();
                                FPoint fPoint = new FPoint((float) (b + (this.f11222a.m14625m() / 2)), (float) (c + (this.f11222a.m14627n() / 2)));
                                FPoint fPoint2 = new FPoint();
                                this.f11222a.f10824D.win2Map((int) fPoint.f13252x, (int) fPoint.f13253y, fPoint2);
                                IPoint iPoint = new IPoint();
                                this.f11222a.f10824D.map2Geo(fPoint2.f13252x, fPoint2.f13253y, iPoint);
                                c3259o = C3259o.m15334a(iPoint);
                                if (this.f11222a.al.m15311a()) {
                                    c3259o.f11338p = true;
                                }
                                this.f11222a.f10851e.m14847a(c3259o);
                                break;
                        }
                    }
                case 14:
                    if (this.f11222a.f10832L != null) {
                        this.f11222a.f10832L.m15369b();
                        break;
                    }
                    return;
                case 15:
                    this.f11222a.m14617i();
                    break;
                case 16:
                    Bitmap bitmap = (Bitmap) message.obj;
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        if (this.f11222a.f10830J != null) {
                            this.f11222a.f10830J.onDraw(canvas);
                        }
                        if (!(this.f11222a.ab == null || this.f11222a.ac == null)) {
                            Bitmap drawingCache = this.f11222a.ab.getDrawingCache(true);
                            if (drawingCache != null) {
                                canvas.drawBitmap(drawingCache, (float) this.f11222a.ab.getLeft(), (float) this.f11222a.ab.getTop(), new Paint());
                            }
                        }
                        if (this.f11222a.as != null) {
                            this.f11222a.as.onMapPrint(new BitmapDrawable(this.f11222a.f10822B.getResources(), bitmap));
                        }
                        if (this.f11222a.at != null) {
                            this.f11222a.at.onMapScreenShot(bitmap);
                        }
                    } else {
                        if (this.f11222a.as != null) {
                            this.f11222a.as.onMapPrint(null);
                        }
                        if (this.f11222a.at != null) {
                            this.f11222a.at.onMapScreenShot(null);
                        }
                    }
                    this.f11222a.as = null;
                    this.f11222a.at = null;
                    break;
                case 17:
                    if (!(this.f11222a.ab == null || this.f11222a.ad == null)) {
                        this.f11222a.ab.setVisibility(0);
                    }
                    try {
                        cameraPosition = this.f11222a.mo3834q();
                        if (cameraPosition != null) {
                            if (cameraPosition.zoom < 10.0f || bh.m15628a(cameraPosition.target.latitude, cameraPosition.target.longitude)) {
                                this.f11222a.f10830J.setVisibility(0);
                            } else {
                                this.f11222a.f10830J.setVisibility(8);
                            }
                        }
                        if (this.f11222a.ao == null || !this.f11222a.aF) {
                            this.f11222a.m14587a(true, cameraPosition);
                        }
                        if (this.f11222a.ao != null) {
                            this.f11222a.aG = true;
                            this.f11222a.ao.onFinish();
                            this.f11222a.aG = false;
                        }
                        if (!this.f11222a.aH) {
                            this.f11222a.ao = null;
                            break;
                        } else {
                            this.f11222a.aH = false;
                            break;
                        }
                    } catch (Throwable th2) {
                        ca.m15831a(th2, "AMapDelegateImpGLSurfaceView", "CameraUpdateFinish");
                        break;
                    }
                    break;
                case 18:
                    b = this.f11222a.m14625m();
                    int n = this.f11222a.m14627n();
                    if (b > 0 && n > 0) {
                        try {
                            CameraPosition q = this.f11222a.mo3834q();
                            MapProjection.lonlat2Geo(q.target.longitude, q.target.latitude, new IPoint());
                            MapProjection mapProjection = new MapProjection(this.f11222a.f10821A);
                            mapProjection.setCameraHeaderAngle(q.tilt);
                            mapProjection.setMapAngle(q.bearing);
                            mapProjection.setMapZoomer(q.zoom);
                            mapProjection.recalculate();
                            DPoint dPoint = new DPoint();
                            this.f11222a.m14462a(mapProjection, 0, 0, dPoint);
                            LatLng latLng = new LatLng(dPoint.f13251y, dPoint.f13250x, false);
                            this.f11222a.m14462a(mapProjection, b, 0, dPoint);
                            LatLng latLng2 = new LatLng(dPoint.f13251y, dPoint.f13250x, false);
                            this.f11222a.m14462a(mapProjection, 0, n, dPoint);
                            LatLng latLng3 = new LatLng(dPoint.f13251y, dPoint.f13250x, false);
                            this.f11222a.m14462a(mapProjection, b, n, dPoint);
                            this.f11222a.bg = LatLngBounds.builder().include(latLng3).include(new LatLng(dPoint.f13251y, dPoint.f13250x, false)).include(latLng).include(latLng2).build();
                            mapProjection.recycle();
                            break;
                        } catch (Throwable th3) {
                            break;
                        }
                    }
                    this.f11222a.bg = null;
                    break;
                case 19:
                    try {
                        this.f11222a.m14515H();
                        this.f11222a.m14626m(true);
                        break;
                    } catch (Throwable th22) {
                        ca.m15831a(th22, "AMapDelegateImpGLSurfaceView", "CREATEMAP");
                        th22.printStackTrace();
                        break;
                    }
                case 20:
                    if (this.f11222a.al.m15311a() || !(this.f11222a.al.m15321j() == 1 || this.f11222a.f10853g == null)) {
                        this.f11222a.f10853g.m15219b(false);
                    }
                    if (this.f11222a.f10853g != null) {
                        this.f11222a.f10853g.m15217a(message.arg1 != 0);
                        break;
                    }
                    break;
                case 21:
                    if (this.f11222a.f10852f != null) {
                        this.f11222a.f10852f.m15264a(this.f11222a.mo3740E());
                        break;
                    }
                    break;
                case 22:
                    this.f11222a.ad();
                    break;
            }
            this.f11222a.mo3816e(false);
        }
    }
}
