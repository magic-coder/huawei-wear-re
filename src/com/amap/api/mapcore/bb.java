package com.amap.api.mapcore;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: NavigateArrowDelegateImp */
class bb implements ah {
    float f11010a;
    float f11011b;
    float f11012c;
    float f11013d;
    float f11014e;
    float f11015f;
    float f11016g;
    float f11017h;
    float[] f11018i;
    private aa f11019j;
    private float f11020k = 10.0f;
    private int f11021l = ViewCompat.MEASURED_STATE_MASK;
    private int f11022m = ViewCompat.MEASURED_STATE_MASK;
    private float f11023n = 0.0f;
    private boolean f11024o = true;
    private String f11025p;
    private CopyOnWriteArrayList<IPoint> f11026q = new CopyOnWriteArrayList();
    private int f11027r = 0;
    private boolean f11028s = false;
    private LatLngBounds f11029t = null;

    public bb(aa aaVar) {
        this.f11019j = aaVar;
        try {
            this.f11025p = mo3883c();
        } catch (Throwable e) {
            ca.m15831a(e, "NavigateArrowDelegateImp", "create");
            e.printStackTrace();
        }
    }

    void m14973b(List<LatLng> list) throws RemoteException {
        Builder builder = LatLngBounds.builder();
        this.f11026q.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!(latLng == null || latLng.equals(r1))) {
                    IPoint iPoint = new IPoint();
                    this.f11019j.mo3765a(latLng.latitude, latLng.longitude, iPoint);
                    this.f11026q.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
        }
        this.f11029t = builder.build();
        this.f11027r = 0;
        this.f11019j.mo3816e(false);
    }

    public void mo3880b() throws RemoteException {
        this.f11019j.mo3800a(mo3883c());
        this.f11019j.mo3816e(false);
    }

    public String mo3883c() throws RemoteException {
        if (this.f11025p == null) {
            this.f11025p = C3347v.m16333a("NavigateArrow");
        }
        return this.f11025p;
    }

    public void mo3875a(List<LatLng> list) throws RemoteException {
        m14973b((List) list);
    }

    public List<LatLng> mo3893m() throws RemoteException {
        return m14962n();
    }

    private List<LatLng> m14962n() throws RemoteException {
        if (this.f11026q == null) {
            return null;
        }
        List<LatLng> arrayList = new ArrayList();
        Iterator it = this.f11026q.iterator();
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            if (iPoint != null) {
                DPoint dPoint = new DPoint();
                this.f11019j.mo3804b(iPoint.f13273x, iPoint.f13274y, dPoint);
                arrayList.add(new LatLng(dPoint.f13251y, dPoint.f13250x));
            }
        }
        return arrayList;
    }

    public void mo3881b(float f) throws RemoteException {
        this.f11020k = f;
        this.f11019j.mo3816e(false);
    }

    public float mo3888h() throws RemoteException {
        return this.f11020k;
    }

    public void mo3874a(int i) throws RemoteException {
        this.f11021l = i;
        this.f11010a = ((float) Color.alpha(i)) / 255.0f;
        this.f11011b = ((float) Color.red(i)) / 255.0f;
        this.f11012c = ((float) Color.green(i)) / 255.0f;
        this.f11013d = ((float) Color.blue(i)) / 255.0f;
        this.f11019j.mo3816e(false);
    }

    public int mo3889i() throws RemoteException {
        return this.f11021l;
    }

    public void mo3882b(int i) throws RemoteException {
        this.f11022m = i;
        this.f11014e = ((float) Color.alpha(i)) / 255.0f;
        this.f11015f = ((float) Color.red(i)) / 255.0f;
        this.f11016g = ((float) Color.green(i)) / 255.0f;
        this.f11017h = ((float) Color.blue(i)) / 255.0f;
        this.f11019j.mo3816e(false);
    }

    public int mo3892l() throws RemoteException {
        return this.f11022m;
    }

    public void mo3873a(float f) throws RemoteException {
        this.f11023n = f;
        this.f11019j.mo3746M();
        this.f11019j.mo3816e(false);
    }

    public float mo3884d() throws RemoteException {
        return this.f11023n;
    }

    public void mo3877a(boolean z) throws RemoteException {
        this.f11024o = z;
        this.f11019j.mo3816e(false);
    }

    public boolean mo3885e() throws RemoteException {
        return this.f11024o;
    }

    public boolean mo3879a(ai aiVar) throws RemoteException {
        if (equals(aiVar) || aiVar.mo3883c().equals(mo3883c())) {
            return true;
        }
        return false;
    }

    public int mo3886f() throws RemoteException {
        return super.hashCode();
    }

    public boolean mo3878a() {
        if (this.f11029t == null) {
            return false;
        }
        LatLngBounds G = this.f11019j.mo3741G();
        if (G == null) {
            return true;
        }
        if (G.contains(this.f11029t) || this.f11029t.intersects(G)) {
            return true;
        }
        return false;
    }

    public void mo3887g() throws RemoteException {
        this.f11028s = false;
        FPoint fPoint = new FPoint();
        this.f11018i = new float[(this.f11026q.size() * 3)];
        Iterator it = this.f11026q.iterator();
        int i = 0;
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            this.f11019j.mo3805b(iPoint.f13274y, iPoint.f13273x, fPoint);
            this.f11018i[i * 3] = fPoint.f13252x;
            this.f11018i[(i * 3) + 1] = fPoint.f13253y;
            this.f11018i[(i * 3) + 2] = 0.0f;
            i++;
        }
        this.f11027r = this.f11026q.size();
    }

    public void mo3876a(GL10 gl10) throws RemoteException {
        if (this.f11026q != null && this.f11026q.size() != 0 && this.f11020k > 0.0f) {
            if (this.f11027r == 0) {
                mo3887g();
            }
            if (this.f11018i != null && this.f11027r > 0) {
                float mapLenWithWin = this.f11019j.mo3809c().getMapLenWithWin((int) this.f11020k);
                this.f11019j.mo3809c().getMapLenWithWin(1);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.f11018i, this.f11018i.length, mapLenWithWin, this.f11019j.mo3801b(), this.f11011b, this.f11012c, this.f11013d, this.f11010a, 0.0f, false, true, true);
            }
            this.f11028s = true;
        }
    }

    public void mo3890j() {
        try {
            if (this.f11018i != null) {
                this.f11018i = null;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "NavigateArrowDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "NavigateArrowDelegateImp destroy");
        }
    }

    public boolean mo3891k() {
        return this.f11028s;
    }
}
