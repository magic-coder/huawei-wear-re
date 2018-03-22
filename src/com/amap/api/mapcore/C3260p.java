package com.amap.api.mapcore;

import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: CircleDelegateImp */
class C3260p implements ac {
    private static float f11339m = 4.0075016E7f;
    private static int f11340n = 256;
    private static int f11341o = 20;
    private LatLng f11342a = null;
    private double f11343b = 0.0d;
    private float f11344c = 10.0f;
    private int f11345d = ViewCompat.MEASURED_STATE_MASK;
    private int f11346e = 0;
    private float f11347f = 0.0f;
    private boolean f11348g = true;
    private String f11349h;
    private aa f11350i;
    private FloatBuffer f11351j;
    private int f11352k = 0;
    private boolean f11353l = false;

    public C3260p(aa aaVar) {
        this.f11350i = aaVar;
        try {
            this.f11349h = mo3883c();
        } catch (Throwable e) {
            ca.m15831a(e, "CircleDelegateImp", "create");
            e.printStackTrace();
        }
    }

    public boolean mo3878a() {
        return true;
    }

    public void mo3880b() throws RemoteException {
        this.f11350i.mo3800a(mo3883c());
        this.f11350i.mo3816e(false);
    }

    public String mo3883c() throws RemoteException {
        if (this.f11349h == null) {
            this.f11349h = C3347v.m16333a("Circle");
        }
        return this.f11349h;
    }

    public void mo3873a(float f) throws RemoteException {
        this.f11347f = f;
        this.f11350i.mo3746M();
        this.f11350i.mo3816e(false);
    }

    public float mo3884d() throws RemoteException {
        return this.f11347f;
    }

    public void mo3877a(boolean z) throws RemoteException {
        this.f11348g = z;
        this.f11350i.mo3816e(false);
    }

    public boolean mo3885e() throws RemoteException {
        return this.f11348g;
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
        this.f11353l = false;
        LatLng latLng = this.f11342a;
        if (latLng != null) {
            FPoint[] fPointArr = new FPoint[360];
            float[] fArr = new float[(fPointArr.length * 3)];
            double c = m15342c(this.f11342a.latitude) * this.f11343b;
            IPoint iPoint = new IPoint();
            MapProjection c2 = this.f11350i.mo3809c();
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            while (i < 360) {
                double d = (((double) i) * 3.141592653589793d) / 180.0d;
                double sin = Math.sin(d) * c;
                int i2 = (int) (sin + ((double) iPoint.f13273x));
                int cos = (int) ((Math.cos(d) * c) + ((double) iPoint.f13274y));
                FPoint fPoint = new FPoint();
                c2.geo2Map(i2, cos, fPoint);
                fPointArr[i] = fPoint;
                fArr[i * 3] = fPointArr[i].f13252x;
                fArr[(i * 3) + 1] = fPointArr[i].f13253y;
                fArr[(i * 3) + 2] = 0.0f;
                i++;
            }
            this.f11352k = fPointArr.length;
            this.f11351j = bk.m15659a(fArr);
        }
    }

    public void mo3876a(GL10 gl10) throws RemoteException {
        if (this.f11342a != null && this.f11343b > 0.0d && this.f11348g) {
            if (this.f11351j == null || this.f11352k == 0) {
                mo3887g();
            }
            if (this.f11351j != null && this.f11352k > 0) {
                C3267t.m15374b(gl10, this.f11346e, this.f11345d, this.f11351j, this.f11344c, this.f11352k);
            }
            this.f11353l = true;
        }
    }

    void m15360h() {
        this.f11352k = 0;
        if (this.f11351j != null) {
            this.f11351j.clear();
        }
        this.f11350i.mo3816e(false);
    }

    public void mo3987a(LatLng latLng) throws RemoteException {
        this.f11342a = latLng;
        m15360h();
    }

    public LatLng mo3991i() throws RemoteException {
        return this.f11342a;
    }

    public void mo3985a(double d) throws RemoteException {
        this.f11343b = d;
        m15360h();
    }

    public double mo3992l() throws RemoteException {
        return this.f11343b;
    }

    public void mo3988b(float f) throws RemoteException {
        this.f11344c = f;
        this.f11350i.mo3816e(false);
    }

    public float mo3993m() throws RemoteException {
        return this.f11344c;
    }

    public void mo3986a(int i) throws RemoteException {
        this.f11345d = i;
    }

    public int mo3994n() throws RemoteException {
        return this.f11345d;
    }

    public void mo3989b(int i) throws RemoteException {
        this.f11346e = i;
        this.f11350i.mo3816e(false);
    }

    public int mo3995o() throws RemoteException {
        return this.f11346e;
    }

    private float m15341b(double d) {
        return (float) ((Math.cos((3.141592653589793d * d) / 180.0d) * ((double) f11339m)) / ((double) (f11340n << f11341o)));
    }

    private double m15342c(double d) {
        return WeightedLatLng.DEFAULT_INTENSITY / ((double) m15341b(d));
    }

    public void mo3890j() {
        try {
            this.f11342a = null;
            if (this.f11351j != null) {
                this.f11351j.clear();
                this.f11351j = null;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "CircleDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "CircleDelegateImp destroy");
        }
    }

    public boolean mo3990b(LatLng latLng) throws RemoteException {
        if (this.f11343b >= ((double) AMapUtils.calculateLineDistance(this.f11342a, latLng))) {
            return true;
        }
        return false;
    }

    public boolean mo3891k() {
        return this.f11353l;
    }
}
