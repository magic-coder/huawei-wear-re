package com.amap.api.mapcore;

import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.bj;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: PolygonDelegateImp */
class be implements aj {
    private static float f11032p = 1.0E10f;
    private aa f11033a;
    private float f11034b = 0.0f;
    private boolean f11035c = true;
    private String f11036d;
    private float f11037e;
    private int f11038f;
    private int f11039g;
    private List<LatLng> f11040h;
    private CopyOnWriteArrayList<IPoint> f11041i = new CopyOnWriteArrayList();
    private FloatBuffer f11042j;
    private FloatBuffer f11043k;
    private int f11044l = 0;
    private int f11045m = 0;
    private LatLngBounds f11046n = null;
    private boolean f11047o = false;

    public be(aa aaVar) {
        this.f11033a = aaVar;
        try {
            this.f11036d = mo3883c();
        } catch (Throwable e) {
            ca.m15831a(e, "PolygonDelegateImp", "create");
            e.printStackTrace();
        }
    }

    public void mo3880b() throws RemoteException {
        this.f11033a.mo3800a(mo3883c());
        this.f11033a.mo3816e(false);
    }

    public String mo3883c() throws RemoteException {
        if (this.f11036d == null) {
            this.f11036d = C3347v.m16333a(SearchBound.POLYGON_SHAPE);
        }
        return this.f11036d;
    }

    public void mo3895a(List<LatLng> list) throws RemoteException {
        this.f11040h = list;
        m15008b((List) list);
        this.f11033a.mo3816e(false);
    }

    public List<LatLng> mo3901l() throws RemoteException {
        return this.f11040h;
    }

    public void mo3873a(float f) throws RemoteException {
        this.f11034b = f;
        this.f11033a.mo3746M();
        this.f11033a.mo3816e(false);
    }

    public float mo3884d() throws RemoteException {
        return this.f11034b;
    }

    public void mo3877a(boolean z) throws RemoteException {
        this.f11035c = z;
        this.f11033a.mo3816e(false);
    }

    public boolean mo3885e() throws RemoteException {
        return this.f11035c;
    }

    public boolean mo3879a(ai aiVar) throws RemoteException {
        if (equals(aiVar) || aiVar.mo3883c().equals(mo3883c())) {
            return true;
        }
        return false;
    }

    void m15008b(List<LatLng> list) throws RemoteException {
        Builder builder = LatLngBounds.builder();
        this.f11041i.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    IPoint iPoint = new IPoint();
                    this.f11033a.mo3765a(latLng.latitude, latLng.longitude, iPoint);
                    this.f11041i.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.f11041i.size();
            if (size > 1) {
                IPoint iPoint2 = (IPoint) this.f11041i.get(0);
                IPoint iPoint3 = (IPoint) this.f11041i.get(size - 1);
                if (iPoint2.f13273x == iPoint3.f13273x && iPoint2.f13274y == iPoint3.f13274y) {
                    this.f11041i.remove(size - 1);
                }
            }
        }
        this.f11046n = builder.build();
        if (this.f11042j != null) {
            this.f11042j.clear();
        }
        if (this.f11043k != null) {
            this.f11043k.clear();
        }
        this.f11044l = 0;
        this.f11045m = 0;
        this.f11033a.mo3816e(false);
    }

    public void mo3887g() throws RemoteException {
        int i = 0;
        this.f11047o = false;
        FPoint[] fPointArr = new FPoint[this.f11041i.size()];
        float[] fArr = new float[(this.f11041i.size() * 3)];
        Iterator it = this.f11041i.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            fPointArr[i2] = new FPoint();
            this.f11033a.mo3805b(iPoint.f13274y, iPoint.f13273x, fPointArr[i2]);
            fArr[i2 * 3] = fPointArr[i2].f13252x;
            fArr[(i2 * 3) + 1] = fPointArr[i2].f13253y;
            fArr[(i2 * 3) + 2] = 0.0f;
            i2++;
        }
        FPoint[] a = m14996a(fPointArr);
        if (a.length == 0) {
            if (f11032p == 1.0E10f) {
                f11032p = 1.0E8f;
            } else {
                f11032p = 1.0E10f;
            }
            a = m14996a(fPointArr);
        }
        float[] fArr2 = new float[(a.length * 3)];
        int length = a.length;
        i2 = 0;
        while (i < length) {
            FPoint fPoint = a[i];
            fArr2[i2 * 3] = fPoint.f13252x;
            fArr2[(i2 * 3) + 1] = fPoint.f13253y;
            fArr2[(i2 * 3) + 2] = 0.0f;
            i2++;
            i++;
        }
        this.f11044l = fPointArr.length;
        this.f11045m = a.length;
        this.f11042j = bk.m15659a(fArr);
        this.f11043k = bk.m15659a(fArr2);
    }

    public int mo3886f() throws RemoteException {
        return super.hashCode();
    }

    public boolean mo3878a() {
        if (this.f11046n == null) {
            return false;
        }
        LatLngBounds G = this.f11033a.mo3741G();
        if (G == null) {
            return true;
        }
        if (this.f11046n.contains(G) || this.f11046n.intersects(G)) {
            return true;
        }
        return false;
    }

    public void mo3876a(GL10 gl10) throws RemoteException {
        if (this.f11041i != null && this.f11041i.size() != 0) {
            if (this.f11042j == null || this.f11043k == null || this.f11044l == 0 || this.f11045m == 0) {
                mo3887g();
            }
            if (this.f11042j != null && this.f11043k != null && this.f11044l > 0 && this.f11045m > 0) {
                C3267t.m15373a(gl10, this.f11038f, this.f11039g, this.f11042j, this.f11037e, this.f11043k, this.f11044l, this.f11045m);
            }
            this.f11047o = true;
        }
    }

    public void mo3897b(float f) throws RemoteException {
        this.f11037e = f;
        this.f11033a.mo3816e(false);
    }

    public float mo3899h() throws RemoteException {
        return this.f11037e;
    }

    public void mo3894a(int i) throws RemoteException {
        this.f11038f = i;
        this.f11033a.mo3816e(false);
    }

    public int mo3900i() throws RemoteException {
        return this.f11038f;
    }

    public void mo3898b(int i) throws RemoteException {
        this.f11039g = i;
        this.f11033a.mo3816e(false);
    }

    public int mo3902m() throws RemoteException {
        return this.f11039g;
    }

    static FPoint[] m14996a(FPoint[] fPointArr) {
        int i = 0;
        int length = fPointArr.length;
        float[] fArr = new float[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2 * 2] = fPointArr[i2].f13252x * f11032p;
            fArr[(i2 * 2) + 1] = fPointArr[i2].f13253y * f11032p;
        }
        bj a = new az().m15539a(fArr);
        length = a.f11500b;
        FPoint[] fPointArr2 = new FPoint[length];
        while (i < length) {
            fPointArr2[i] = new FPoint();
            fPointArr2[i].f13252x = fArr[a.m15631a(i) * 2] / f11032p;
            fPointArr2[i].f13253y = fArr[(a.m15631a(i) * 2) + 1] / f11032p;
            i++;
        }
        return fPointArr2;
    }

    public void mo3890j() {
        try {
            if (this.f11042j != null) {
                this.f11042j.clear();
                this.f11042j = null;
            }
            if (this.f11043k != null) {
                this.f11043k = null;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "PolygonDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolygonDelegateImp destroy");
        }
    }

    public boolean mo3896a(LatLng latLng) throws RemoteException {
        try {
            return bk.m15667a(latLng, mo3901l());
        } catch (Throwable th) {
            ca.m15831a(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    public boolean mo3891k() {
        return this.f11047o;
    }
}
