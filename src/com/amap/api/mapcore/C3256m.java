package com.amap.api.mapcore;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: ArcDelegateImp */
class C3256m implements ab {
    float f11244a;
    float f11245b;
    float f11246c;
    float f11247d;
    private LatLng f11248e;
    private LatLng f11249f;
    private LatLng f11250g;
    private float f11251h = 10.0f;
    private int f11252i = ViewCompat.MEASURED_STATE_MASK;
    private float f11253j = 0.0f;
    private boolean f11254k = true;
    private String f11255l;
    private aa f11256m;
    private float[] f11257n;
    private int f11258o = 0;
    private boolean f11259p = false;
    private double f11260q = 0.0d;
    private double f11261r = 0.0d;
    private double f11262s = 0.0d;

    public C3256m(aa aaVar) {
        this.f11256m = aaVar;
        try {
            this.f11255l = mo3883c();
        } catch (Throwable e) {
            ca.m15831a(e, "ArcDelegateImp", "create");
            e.printStackTrace();
        }
    }

    public boolean mo3878a() {
        return true;
    }

    public void mo3880b() throws RemoteException {
        this.f11256m.mo3800a(mo3883c());
        this.f11256m.mo3816e(false);
    }

    public String mo3883c() throws RemoteException {
        if (this.f11255l == null) {
            this.f11255l = C3347v.m16333a("Arc");
        }
        return this.f11255l;
    }

    public void mo3873a(float f) throws RemoteException {
        this.f11253j = f;
        this.f11256m.mo3746M();
        this.f11256m.mo3816e(false);
    }

    public float mo3884d() throws RemoteException {
        return this.f11253j;
    }

    public void mo3877a(boolean z) throws RemoteException {
        this.f11254k = z;
        this.f11256m.mo3816e(false);
    }

    public boolean mo3885e() throws RemoteException {
        return this.f11254k;
    }

    public boolean mo3879a(ai aiVar) throws RemoteException {
        if (equals(aiVar) || aiVar.mo3883c().equals(mo3883c())) {
            return true;
        }
        return false;
    }

    public int mo3886f() throws RemoteException {
        return 0;
    }

    public void mo3887g() throws RemoteException {
        int i = 0;
        if (this.f11248e != null && this.f11249f != null && this.f11250g != null && this.f11254k) {
            try {
                this.f11259p = false;
                MapProjection c = this.f11256m.mo3809c();
                FPoint fPoint;
                if (m15280l()) {
                    DPoint m = m15281m();
                    int abs = (int) ((Math.abs(this.f11262s - this.f11261r) * 180.0d) / 3.141592653589793d);
                    double d = (this.f11262s - this.f11261r) / ((double) abs);
                    FPoint[] fPointArr = new FPoint[(abs + 1)];
                    this.f11257n = new float[(fPointArr.length * 3)];
                    for (int i2 = 0; i2 <= abs; i2++) {
                        MapProjection mapProjection;
                        if (i2 == abs) {
                            fPoint = new FPoint();
                            this.f11256m.mo3764a(this.f11250g.latitude, this.f11250g.longitude, fPoint);
                            fPointArr[i2] = fPoint;
                        } else {
                            mapProjection = c;
                            fPointArr[i2] = m15279a(mapProjection, (((double) i2) * d) + this.f11261r, m.f13250x, m.f13251y);
                        }
                        mapProjection = c;
                        fPointArr[i2] = m15279a(mapProjection, (((double) i2) * d) + this.f11261r, m.f13250x, m.f13251y);
                        this.f11257n[i2 * 3] = fPointArr[i2].f13252x;
                        this.f11257n[(i2 * 3) + 1] = fPointArr[i2].f13253y;
                        this.f11257n[(i2 * 3) + 2] = 0.0f;
                    }
                    this.f11258o = fPointArr.length;
                    return;
                }
                FPoint[] fPointArr2 = new FPoint[3];
                this.f11257n = new float[(fPointArr2.length * 3)];
                fPoint = new FPoint();
                this.f11256m.mo3764a(this.f11248e.latitude, this.f11248e.longitude, fPoint);
                fPointArr2[0] = fPoint;
                fPoint = new FPoint();
                this.f11256m.mo3764a(this.f11249f.latitude, this.f11249f.longitude, fPoint);
                fPointArr2[1] = fPoint;
                fPoint = new FPoint();
                this.f11256m.mo3764a(this.f11250g.latitude, this.f11250g.longitude, fPoint);
                fPointArr2[2] = fPoint;
                while (i < 3) {
                    this.f11257n[i * 3] = fPointArr2[i].f13252x;
                    this.f11257n[(i * 3) + 1] = fPointArr2[i].f13253y;
                    this.f11257n[(i * 3) + 2] = 0.0f;
                    i++;
                }
                this.f11258o = fPointArr2.length;
            } catch (Throwable th) {
                ca.m15831a(th, "ArcDelegateImp", "calMapFPoint");
                th.printStackTrace();
            }
        }
    }

    private FPoint m15279a(MapProjection mapProjection, double d, double d2, double d3) {
        int cos = (int) ((Math.cos(d) * this.f11260q) + d2);
        int i = (int) (((-Math.sin(d)) * this.f11260q) + d3);
        FPoint fPoint = new FPoint();
        mapProjection.geo2Map(cos, i, fPoint);
        return fPoint;
    }

    private boolean m15280l() {
        if (Math.abs(((this.f11248e.latitude - this.f11249f.latitude) * (this.f11249f.longitude - this.f11250g.longitude)) - ((this.f11248e.longitude - this.f11249f.longitude) * (this.f11249f.latitude - this.f11250g.latitude))) < 1.0E-6d) {
            return false;
        }
        return true;
    }

    private DPoint m15281m() {
        IPoint iPoint = new IPoint();
        this.f11256m.mo3765a(this.f11248e.latitude, this.f11248e.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f11256m.mo3765a(this.f11249f.latitude, this.f11249f.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f11256m.mo3765a(this.f11250g.latitude, this.f11250g.longitude, iPoint3);
        double d = (double) iPoint.f13273x;
        double d2 = (double) iPoint.f13274y;
        double d3 = (double) iPoint2.f13273x;
        double d4 = (double) iPoint2.f13274y;
        double d5 = (double) iPoint3.f13273x;
        double d6 = (double) iPoint3.f13274y;
        double d7 = (((d6 - d2) * ((((d4 * d4) - (d2 * d2)) + (d3 * d3)) - (d * d))) + ((d4 - d2) * ((((d2 * d2) - (d6 * d6)) + (d * d)) - (d5 * d5)))) / (((2.0d * (d3 - d)) * (d6 - d2)) - ((2.0d * (d5 - d)) * (d4 - d2)));
        double d8 = (((d5 - d) * ((((d3 * d3) - (d * d)) + (d4 * d4)) - (d2 * d2))) + ((d3 - d) * ((((d * d) - (d5 * d5)) + (d2 * d2)) - (d6 * d6)))) / (((2.0d * (d4 - d2)) * (d5 - d)) - ((2.0d * (d6 - d2)) * (d3 - d)));
        this.f11260q = Math.sqrt(((d - d7) * (d - d7)) + ((d2 - d8) * (d2 - d8)));
        this.f11261r = m15278a(d7, d8, d, d2);
        d = m15278a(d7, d8, d3, d4);
        this.f11262s = m15278a(d7, d8, d5, d6);
        if (this.f11261r < this.f11262s) {
            if (d <= this.f11261r || d >= this.f11262s) {
                this.f11262s -= 6.283185307179586d;
            }
        } else if (d <= this.f11262s || d >= this.f11261r) {
            this.f11262s += 6.283185307179586d;
        }
        return new DPoint(d7, d8);
    }

    private double m15278a(double d, double d2, double d3, double d4) {
        double d5 = (d2 - d4) / this.f11260q;
        if (Math.abs(d5) > WeightedLatLng.DEFAULT_INTENSITY) {
            d5 = Math.signum(d5);
        }
        d5 = Math.asin(d5);
        if (d5 >= 0.0d) {
            if (d3 < d) {
                return 3.141592653589793d - Math.abs(d5);
            }
            return d5;
        } else if (d3 < d) {
            return 3.141592653589793d - d5;
        } else {
            return d5 + 6.283185307179586d;
        }
    }

    public void mo3876a(GL10 gl10) throws RemoteException {
        if (this.f11248e != null && this.f11249f != null && this.f11250g != null && this.f11254k) {
            if (this.f11257n == null || this.f11258o == 0) {
                mo3887g();
            }
            if (this.f11257n != null && this.f11258o > 0) {
                float mapLenWithWin = this.f11256m.mo3809c().getMapLenWithWin((int) this.f11251h);
                this.f11256m.mo3809c().getMapLenWithWin(1);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.f11257n, this.f11257n.length, mapLenWithWin, this.f11256m.mo3801b(), this.f11245b, this.f11246c, this.f11247d, this.f11244a, 0.0f, false, true, false);
            }
            this.f11259p = true;
        }
    }

    public void mo3982b(float f) throws RemoteException {
        this.f11251h = f;
        this.f11256m.mo3816e(false);
    }

    public float mo3983h() throws RemoteException {
        return this.f11251h;
    }

    public void mo3981a(int i) throws RemoteException {
        this.f11252i = i;
        this.f11244a = ((float) Color.alpha(i)) / 255.0f;
        this.f11245b = ((float) Color.red(i)) / 255.0f;
        this.f11246c = ((float) Color.green(i)) / 255.0f;
        this.f11247d = ((float) Color.blue(i)) / 255.0f;
        this.f11256m.mo3816e(false);
    }

    public int mo3984i() throws RemoteException {
        return this.f11252i;
    }

    public void mo3890j() {
        try {
            this.f11248e = null;
            this.f11249f = null;
            this.f11250g = null;
        } catch (Throwable th) {
            ca.m15831a(th, "ArcDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "ArcDelegateImp destroy");
        }
    }

    public boolean mo3891k() {
        return this.f11259p;
    }

    public void m15284a(LatLng latLng) {
        this.f11248e = latLng;
    }

    public void m15291b(LatLng latLng) {
        this.f11249f = latLng;
    }

    public void m15293c(LatLng latLng) {
        this.f11250g = latLng;
    }
}
