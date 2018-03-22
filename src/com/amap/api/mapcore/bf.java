package com.amap.api.mapcore;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.WeightedLatLng;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: PolylineDelegateImp */
class bf implements ak {
    private float f11048A = 0.0f;
    private float f11049B;
    private float f11050C;
    private float f11051D;
    private float f11052E;
    private float f11053F = 0.0f;
    private float f11054G = 0.0f;
    private float[] f11055H;
    private int[] f11056I;
    private int[] f11057J;
    private double f11058K = 5.0d;
    private C3347v f11059a;
    private String f11060b;
    private List<IPoint> f11061c = new ArrayList();
    private List<FPoint> f11062d = new ArrayList();
    private List<LatLng> f11063e = new ArrayList();
    private List<BitmapDescriptor> f11064f = new ArrayList();
    private List<Integer> f11065g = new ArrayList();
    private List<Integer> f11066h = new ArrayList();
    private FloatBuffer f11067i;
    private BitmapDescriptor f11068j = null;
    private LatLngBounds f11069k = null;
    private Object f11070l = new Object();
    private boolean f11071m = true;
    private boolean f11072n = true;
    private boolean f11073o = false;
    private boolean f11074p = false;
    private boolean f11075q = false;
    private boolean f11076r = false;
    private boolean f11077s = true;
    private boolean f11078t = false;
    private int f11079u = 0;
    private int f11080v = 0;
    private int f11081w = ViewCompat.MEASURED_STATE_MASK;
    private int f11082x = 0;
    private float f11083y = 10.0f;
    private float f11084z = 0.0f;

    public void m15059d(boolean z) {
        this.f11077s = z;
        this.f11059a.f11886a.mo3816e(false);
    }

    public void mo3907b(boolean z) throws RemoteException {
        this.f11073o = z;
        this.f11059a.f11886a.mo3816e(false);
    }

    public boolean mo3914m() {
        return this.f11073o;
    }

    public void mo3910c(boolean z) {
        if (this.f11079u == 2 || this.f11079u == 0) {
            this.f11074p = z;
            if (z && this.f11072n) {
                this.f11079u = 2;
            }
            this.f11059a.f11886a.mo3816e(false);
        }
    }

    public boolean mo3915n() {
        return this.f11074p;
    }

    public bf(C3347v c3347v) {
        this.f11059a = c3347v;
        try {
            this.f11060b = mo3883c();
        } catch (Throwable e) {
            ca.m15831a(e, "PolylineDelegateImp", "create");
            e.printStackTrace();
        }
    }

    void m15050b(List<LatLng> list) throws RemoteException {
        List arrayList = new ArrayList();
        Builder builder = LatLngBounds.builder();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!(latLng2 == null || latLng2.equals(latLng))) {
                    IPoint iPoint;
                    if (!this.f11073o) {
                        iPoint = new IPoint();
                        this.f11059a.f11886a.mo3765a(latLng2.latitude, latLng2.longitude, iPoint);
                        arrayList.add(iPoint);
                        builder.include(latLng2);
                    } else if (latLng != null) {
                        if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                            iPoint = new IPoint();
                            this.f11059a.f11886a.mo3765a(latLng.latitude, latLng.longitude, iPoint);
                            arrayList.add(iPoint);
                            builder.include(latLng);
                            iPoint = new IPoint();
                            this.f11059a.f11886a.mo3765a(latLng2.latitude, latLng2.longitude, iPoint);
                            arrayList.add(iPoint);
                            builder.include(latLng2);
                        } else {
                            m15041a(latLng, latLng2, arrayList, builder);
                        }
                    }
                    latLng = latLng2;
                }
            }
        }
        this.f11061c = arrayList;
        this.f11082x = 0;
        if (this.f11061c.size() > 0) {
            this.f11069k = builder.build();
        }
        this.f11059a.f11886a.mo3816e(false);
    }

    IPoint m15037a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d, int i) {
        IPoint iPoint4 = new IPoint();
        double d2 = (double) (iPoint2.f13273x - iPoint.f13273x);
        double d3 = (double) (iPoint2.f13274y - iPoint.f13274y);
        iPoint4.f13274y = (int) (((((double) i) * d) / Math.sqrt(((d3 * d3) / (d2 * d2)) + WeightedLatLng.DEFAULT_INTENSITY)) + ((double) iPoint3.f13274y));
        iPoint4.f13273x = (int) (((d3 * ((double) (iPoint3.f13274y - iPoint4.f13274y))) / d2) + ((double) iPoint3.f13273x));
        return iPoint4;
    }

    void m15043a(List<IPoint> list, List<IPoint> list2, double d) {
        if (list.size() == 3) {
            for (int i = 0; i <= 10; i = (int) (((float) i) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)) {
                float f = ((float) i) / 10.0f;
                IPoint iPoint = new IPoint();
                double d2 = ((((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(0)).f13273x)) + (((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(1)).f13273x)) * d)) + ((double) (((float) ((IPoint) list.get(2)).f13273x) * (f * f)));
                double d3 = ((((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(0)).f13274y)) + (((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(1)).f13274y)) * d)) + ((double) (((float) ((IPoint) list.get(2)).f13274y) * (f * f)));
                double d4 = (((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) + ((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * d)) + ((double) (f * f));
                iPoint.f13273x = (int) (d2 / ((((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) + ((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * d)) + ((double) (f * f))));
                iPoint.f13274y = (int) (d3 / d4);
                list2.add(iPoint);
            }
        }
    }

    void m15041a(LatLng latLng, LatLng latLng2, List<IPoint> list, Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d, false);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i = latLng3.latitude > 0.0d ? -1 : 1;
        IPoint iPoint = new IPoint();
        this.f11059a.f11886a.mo3765a(latLng.latitude, latLng.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f11059a.f11886a.mo3765a(latLng2.latitude, latLng2.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f11059a.f11886a.mo3765a(latLng3.latitude, latLng3.longitude, iPoint3);
        double cos = Math.cos(0.5d * abs);
        IPoint a = m15037a(iPoint, iPoint2, iPoint3, (Math.hypot((double) (iPoint.f13273x - iPoint2.f13273x), (double) (iPoint.f13274y - iPoint2.f13274y)) * 0.5d) * Math.tan(0.5d * abs), i);
        List arrayList = new ArrayList();
        arrayList.add(iPoint);
        arrayList.add(a);
        arrayList.add(iPoint2);
        m15043a(arrayList, (List) list, cos);
    }

    public void mo3880b() throws RemoteException {
        this.f11059a.m16345c(mo3883c());
        if (this.f11057J != null && this.f11057J.length > 0) {
            for (int valueOf : this.f11057J) {
                this.f11059a.m16340a(Integer.valueOf(valueOf));
            }
            this.f11057J = null;
        }
        if (this.f11080v > 0) {
            this.f11059a.m16340a(Integer.valueOf(this.f11080v));
            this.f11080v = 0;
        }
        this.f11059a.f11886a.mo3816e(false);
    }

    public String mo3883c() throws RemoteException {
        if (this.f11060b == null) {
            this.f11060b = C3347v.m16333a("Polyline");
        }
        return this.f11060b;
    }

    public void mo3905a(List<LatLng> list) throws RemoteException {
        try {
            this.f11063e = list;
            synchronized (this.f11070l) {
                m15050b((List) list);
                mo3887g();
            }
            this.f11059a.f11886a.mo3816e(false);
        } catch (Throwable th) {
            ca.m15831a(th, "PolylineDelegateImp", "setPoints");
            this.f11061c.clear();
            th.printStackTrace();
        }
    }

    public List<LatLng> mo3913l() throws RemoteException {
        return this.f11063e;
    }

    public void mo3906b(float f) throws RemoteException {
        this.f11083y = f;
        this.f11059a.f11886a.mo3816e(false);
    }

    public float mo3911h() throws RemoteException {
        return this.f11083y;
    }

    public void mo3904a(int i) {
        if (this.f11079u == 0 || this.f11079u == 2) {
            this.f11081w = i;
            this.f11049B = ((float) Color.alpha(i)) / 255.0f;
            this.f11050C = ((float) Color.red(i)) / 255.0f;
            this.f11051D = ((float) Color.green(i)) / 255.0f;
            this.f11052E = ((float) Color.blue(i)) / 255.0f;
            if (this.f11072n) {
                this.f11079u = 0;
            }
            this.f11059a.f11886a.mo3816e(false);
        }
    }

    public int mo3912i() throws RemoteException {
        return this.f11081w;
    }

    public void mo3873a(float f) throws RemoteException {
        this.f11084z = f;
        this.f11059a.m16342b();
        this.f11059a.f11886a.mo3816e(false);
    }

    public float mo3884d() throws RemoteException {
        return this.f11084z;
    }

    public void mo3877a(boolean z) throws RemoteException {
        this.f11071m = z;
        this.f11059a.f11886a.mo3816e(false);
    }

    public boolean mo3885e() throws RemoteException {
        return this.f11071m;
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
        if (this.f11069k == null) {
            return false;
        }
        LatLngBounds G = this.f11059a.f11886a.mo3741G();
        if (G == null) {
            return true;
        }
        if (G.contains(this.f11069k) || this.f11069k.intersects(G)) {
            return true;
        }
        return false;
    }

    public void mo3887g() throws RemoteException {
        synchronized (this.f11070l) {
            this.f11062d.clear();
            this.f11076r = false;
            this.f11055H = new float[(this.f11061c.size() * 3)];
            int i = 0;
            for (IPoint iPoint : this.f11061c) {
                FPoint fPoint = new FPoint();
                this.f11059a.f11886a.mo3805b(iPoint.f13274y, iPoint.f13273x, fPoint);
                this.f11055H[i * 3] = fPoint.f13252x;
                this.f11055H[(i * 3) + 1] = fPoint.f13253y;
                this.f11055H[(i * 3) + 2] = 0.0f;
                this.f11062d.add(fPoint);
                i++;
            }
        }
        if (!this.f11077s) {
            this.f11067i = bk.m15659a(this.f11055H);
        }
        this.f11082x = this.f11061c.size();
        m15033o();
    }

    private void m15033o() {
        if (this.f11082x <= 5000 || this.f11048A > 12.0f) {
            this.f11054G = this.f11059a.f11886a.mo3809c().getMapLenWithWin(10);
            return;
        }
        float f = (this.f11083y / 2.0f) + (this.f11048A / 2.0f);
        if (f > 200.0f) {
            f = 200.0f;
        }
        this.f11054G = this.f11059a.f11886a.mo3809c().getMapLenWithWin((int) f);
    }

    private void m15030f(List<FPoint> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size >= 2) {
            FPoint fPoint = (FPoint) list.get(0);
            arrayList.add(fPoint);
            int i = 1;
            FPoint fPoint2 = fPoint;
            while (i < size - 1) {
                fPoint = (FPoint) list.get(i);
                if (m15023a(fPoint2, fPoint)) {
                    arrayList.add(fPoint);
                } else {
                    fPoint = fPoint2;
                }
                i++;
                fPoint2 = fPoint;
            }
            arrayList.add(list.get(size - 1));
            this.f11055H = new float[(arrayList.size() * 3)];
            this.f11056I = null;
            this.f11056I = new int[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                fPoint = (FPoint) it.next();
                this.f11056I[i2] = i2;
                this.f11055H[i2 * 3] = fPoint.f13252x;
                this.f11055H[(i2 * 3) + 1] = fPoint.f13253y;
                this.f11055H[(i2 * 3) + 2] = 0.0f;
                i2++;
            }
            com.amap.api.mapcore.util.bf.m15627a(com.amap.api.mapcore.util.bf.f11497a, hashCode() + " vacuate limit width: " + this.f11054G + ",zoom: " + this.f11048A + ", before vacuate point size: " + this.f11062d.size() + ", after :" + arrayList.size(), 111);
        }
    }

    private boolean m15023a(FPoint fPoint, FPoint fPoint2) {
        return Math.abs(fPoint2.f13252x - fPoint.f13252x) >= this.f11054G || Math.abs(fPoint2.f13253y - fPoint.f13253y) >= this.f11054G;
    }

    public void m15040a(BitmapDescriptor bitmapDescriptor) {
        this.f11072n = false;
        this.f11079u = 1;
        this.f11068j = bitmapDescriptor;
        this.f11059a.f11886a.mo3816e(false);
    }

    public void mo3876a(GL10 gl10) throws RemoteException {
        if (this.f11061c != null && this.f11061c.size() != 0 && this.f11083y > 0.0f) {
            if (this.f11055H != null && this.f11082x > 0) {
                if (this.f11077s) {
                    m15024b(gl10);
                } else {
                    if (this.f11067i == null) {
                        this.f11067i = bk.m15659a(this.f11055H);
                    }
                    C3267t.m15372a(gl10, 3, this.f11081w, this.f11067i, this.f11083y, this.f11082x);
                }
            }
            this.f11076r = true;
        }
    }

    private void m15024b(GL10 gl10) {
        float mapLenWithWin = this.f11059a.f11886a.mo3809c().getMapLenWithWin((int) this.f11083y);
        switch (this.f11079u) {
            case 0:
                m15031f(gl10, mapLenWithWin);
                return;
            case 1:
                m15028d(gl10, mapLenWithWin);
                return;
            case 2:
                m15029e(gl10, mapLenWithWin);
                return;
            case 3:
                m15027c(gl10, mapLenWithWin);
                return;
            case 4:
                m15025b(gl10, mapLenWithWin);
                return;
            case 5:
                m15022a(gl10, mapLenWithWin);
                return;
            default:
                return;
        }
    }

    private void m15022a(GL10 gl10, float f) {
        int i = 0;
        if (!this.f11075q) {
            this.f11057J = new int[this.f11064f.size()];
            for (int i2 = 0; i2 < this.f11057J.length; i2++) {
                int i3;
                int K = this.f11059a.f11886a.mo3744K();
                if (K == 0) {
                    int[] iArr = new int[]{0};
                    gl10.glGenTextures(1, iArr, 0);
                    i3 = iArr[0];
                } else {
                    i3 = K;
                }
                bk.m15671b(gl10, i3, ((BitmapDescriptor) this.f11064f.get(i2)).getBitmap(), true);
                this.f11057J[i2] = i3;
            }
            this.f11075q = true;
        }
        int[] iArr2 = new int[this.f11065g.size()];
        while (i < iArr2.length) {
            iArr2[i] = this.f11057J[((Integer) this.f11065g.get(i)).intValue()];
            i++;
        }
        AMapNativeRenderer.nativeDrawLineByMultiTextureID(this.f11055H, this.f11055H.length, f, iArr2, iArr2.length, this.f11056I, this.f11056I.length, this.f11053F);
    }

    private void m15025b(GL10 gl10, float f) {
        int[] iArr = new int[this.f11066h.size()];
        for (int i = 0; i < this.f11066h.size(); i++) {
            iArr[i] = ((Integer) this.f11066h.get(i)).intValue();
        }
        AMapNativeRenderer.nativeDrawGradientColorLine(this.f11055H, this.f11055H.length, f, iArr, this.f11066h.size(), this.f11056I, this.f11056I.length, this.f11059a.f11886a.mo3801b());
    }

    private void m15027c(GL10 gl10, float f) {
        int[] iArr = new int[this.f11066h.size()];
        for (int i = 0; i < this.f11066h.size(); i++) {
            iArr[i] = ((Integer) this.f11066h.get(i)).intValue();
        }
        AMapNativeRenderer.nativeDrawLineByMultiColor(this.f11055H, this.f11055H.length, f, this.f11059a.f11886a.mo3801b(), iArr, this.f11066h.size(), this.f11056I, this.f11056I.length);
    }

    private void m15028d(GL10 gl10, float f) {
        if (!this.f11075q) {
            this.f11080v = this.f11059a.f11886a.mo3744K();
            if (this.f11080v == 0) {
                int[] iArr = new int[]{0};
                gl10.glGenTextures(1, iArr, 0);
                this.f11080v = iArr[0];
            }
            if (this.f11068j != null) {
                bk.m15671b(gl10, this.f11080v, this.f11068j.getBitmap(), true);
            }
            this.f11075q = true;
        }
        try {
            List list = this.f11062d;
            if (m15034p()) {
                synchronized (this.f11070l) {
                    list = bk.m15661a(this.f11059a.f11886a, this.f11062d);
                }
            }
            m15030f(list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapNativeRenderer.nativeDrawLineByTextureID(this.f11055H, this.f11055H.length, f, this.f11080v, this.f11050C, this.f11051D, this.f11052E, this.f11049B, this.f11053F, false, false, false);
    }

    private void m15029e(GL10 gl10, float f) {
        AMapNativeRenderer.nativeDrawLineByTextureID(this.f11055H, this.f11055H.length, f, this.f11059a.f11886a.mo3832o(), this.f11050C, this.f11051D, this.f11052E, this.f11049B, 0.0f, true, true, false);
    }

    private void m15031f(GL10 gl10, float f) {
        try {
            List list = this.f11062d;
            if (m15034p()) {
                synchronized (this.f11070l) {
                    list = bk.m15661a(this.f11059a.f11886a, this.f11062d);
                }
            }
            m15030f(list);
            AMapNativeRenderer.nativeDrawLineByTextureID(this.f11055H, this.f11055H.length, f, this.f11059a.f11886a.mo3801b(), this.f11050C, this.f11051D, this.f11052E, this.f11049B, 0.0f, false, true, false);
        } catch (Throwable th) {
            com.amap.api.mapcore.util.bf.m15627a(com.amap.api.mapcore.util.bf.f11497a, hashCode() + " drawSingleColorLine exception: " + th.getMessage(), 115);
        }
    }

    private boolean m15034p() {
        try {
            this.f11048A = this.f11059a.f11886a.mo3834q().zoom;
            m15033o();
            if (this.f11048A <= 10.0f || this.f11079u > 2) {
                return false;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if (this.f11059a.f11886a == null) {
                return false;
            }
            Rect rect = new Rect(-100, -100, this.f11059a.f11886a.mo3827k() + 100, this.f11059a.f11886a.mo3829l() + 100);
            LatLng latLng = this.f11069k.northeast;
            LatLng latLng2 = this.f11069k.southwest;
            IPoint iPoint = new IPoint();
            this.f11059a.f11886a.mo3802b(latLng.latitude, latLng2.longitude, iPoint);
            IPoint iPoint2 = new IPoint();
            this.f11059a.f11886a.mo3802b(latLng.latitude, latLng.longitude, iPoint2);
            IPoint iPoint3 = new IPoint();
            this.f11059a.f11886a.mo3802b(latLng2.latitude, latLng.longitude, iPoint3);
            IPoint iPoint4 = new IPoint();
            this.f11059a.f11886a.mo3802b(latLng2.latitude, latLng2.longitude, iPoint4);
            if (rect.contains(iPoint.f13273x, iPoint.f13274y) && rect.contains(iPoint2.f13273x, iPoint2.f13274y) && rect.contains(iPoint3.f13273x, iPoint3.f13274y) && rect.contains(iPoint4.f13273x, iPoint4.f13274y)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public void mo3890j() {
        try {
            mo3880b();
            if (this.f11055H != null) {
                this.f11055H = null;
            }
            if (this.f11067i != null) {
                this.f11067i.clear();
                this.f11067i = null;
            }
            if (this.f11064f != null && this.f11064f.size() > 0) {
                for (BitmapDescriptor recycle : this.f11064f) {
                    recycle.recycle();
                }
            }
            if (this.f11068j != null) {
                this.f11068j.recycle();
            }
            if (this.f11066h != null) {
                this.f11066h.clear();
                this.f11066h = null;
            }
            if (this.f11065g != null) {
                this.f11065g.clear();
                this.f11065g = null;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "PolylineDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolylineDelegateImp destroy");
        }
    }

    public boolean mo3891k() {
        return this.f11076r;
    }

    public LatLng mo3903a(LatLng latLng) {
        int i = 0;
        if (latLng == null) {
            return null;
        }
        if (this.f11063e == null || this.f11063e.size() == 0) {
            return null;
        }
        float f = 0.0f;
        int i2 = 0;
        while (i < this.f11063e.size()) {
            try {
                float calculateLineDistance;
                int i3;
                if (i == 0) {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, (LatLng) this.f11063e.get(i));
                    i3 = i2;
                } else {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, (LatLng) this.f11063e.get(i));
                    if (f > calculateLineDistance) {
                        i3 = i;
                    } else {
                        calculateLineDistance = f;
                        i3 = i2;
                    }
                }
                i++;
                i2 = i3;
                f = calculateLineDistance;
            } catch (Throwable th) {
                ca.m15831a(th, "PolylineDelegateImp", "getNearestLatLng");
                th.printStackTrace();
                return null;
            }
        }
        return (LatLng) this.f11063e.get(i2);
    }

    public boolean mo3908b(LatLng latLng) {
        Object obj = new float[this.f11055H.length];
        System.arraycopy(this.f11055H, 0, obj, 0, this.f11055H.length);
        if (obj.length / 3 < 2) {
            return false;
        }
        try {
            ArrayList q = m15035q();
            if (q == null || q.size() < 1) {
                return false;
            }
            double mapLenWithWin = (double) this.f11059a.f11886a.mo3809c().getMapLenWithWin(((int) this.f11083y) / 4);
            double mapLenWithWin2 = (double) this.f11059a.f11886a.mo3809c().getMapLenWithWin((int) this.f11058K);
            FPoint c = m15026c(latLng);
            FPoint fPoint = null;
            for (int i = 0; i < q.size() - 1; i++) {
                FPoint fPoint2;
                if (i == 0) {
                    fPoint2 = (FPoint) q.get(i);
                } else {
                    fPoint2 = fPoint;
                }
                fPoint = (FPoint) q.get(i + 1);
                if ((mapLenWithWin2 + mapLenWithWin) - m15021a(c, fPoint2, fPoint) >= 0.0d) {
                    q.clear();
                    return true;
                }
            }
            q.clear();
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private ArrayList<FPoint> m15035q() {
        ArrayList<FPoint> arrayList = new ArrayList();
        int i = 0;
        while (i < this.f11055H.length) {
            float f = this.f11055H[i];
            i++;
            float f2 = this.f11055H[i];
            i++;
            arrayList.add(new FPoint(f, f2));
            i++;
        }
        return arrayList;
    }

    private double m15021a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return m15020a((double) fPoint.f13252x, (double) fPoint.f13253y, (double) fPoint2.f13252x, (double) fPoint2.f13253y, (double) fPoint3.f13252x, (double) fPoint3.f13253y);
    }

    private FPoint m15026c(LatLng latLng) {
        IPoint iPoint = new IPoint();
        this.f11059a.f11886a.mo3765a(latLng.latitude, latLng.longitude, iPoint);
        FPoint fPoint = new FPoint();
        this.f11059a.f11886a.mo3805b(iPoint.f13274y, iPoint.f13273x, fPoint);
        return fPoint;
    }

    private double m15020a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = ((d5 - d3) * (d - d3)) + ((d6 - d4) * (d2 - d4));
        if (d7 <= 0.0d) {
            return Math.sqrt(((d - d3) * (d - d3)) + ((d2 - d4) * (d2 - d4)));
        }
        double d8 = ((d5 - d3) * (d5 - d3)) + ((d6 - d4) * (d6 - d4));
        if (d7 >= d8) {
            return Math.sqrt(((d - d5) * (d - d5)) + ((d2 - d6) * (d2 - d6)));
        }
        d7 /= d8;
        d8 = ((d5 - d3) * d7) + d3;
        d7 = (d7 * (d6 - d4)) + d4;
        return Math.sqrt(((d7 - d2) * (d7 - d2)) + ((d - d8) * (d - d8)));
    }

    public void mo3909c(float f) {
        this.f11053F = f;
        this.f11059a.f11886a.mo3816e(false);
    }

    public void m15055c(List<BitmapDescriptor> list) {
        if (list != null && list.size() != 0) {
            if (list.size() > 1) {
                this.f11072n = false;
                this.f11079u = 5;
                this.f11064f = list;
                this.f11059a.f11886a.mo3816e(false);
                return;
            }
            m15040a((BitmapDescriptor) list.get(0));
        }
    }

    public void m15058d(List<Integer> list) {
        if (list != null && list.size() != 0) {
            this.f11065g = m15032g(list);
        }
    }

    public void m15060e(List<Integer> list) {
        if (list != null && list.size() != 0) {
            if (list.size() > 1) {
                this.f11072n = false;
                this.f11066h = m15032g(list);
                this.f11079u = 3;
                this.f11059a.f11886a.mo3816e(false);
                return;
            }
            mo3904a(((Integer) list.get(0)).intValue());
        }
    }

    public void m15061e(boolean z) {
        if (z && this.f11066h != null && this.f11066h.size() > 1) {
            this.f11078t = z;
            this.f11079u = 4;
            this.f11059a.f11886a.mo3816e(false);
        }
    }

    private List<Integer> m15032g(List<Integer> list) {
        Object obj = new int[list.size()];
        List<Integer> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int intValue = ((Integer) list.get(i3)).intValue();
            if (i3 == 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else if (intValue != i2) {
                arrayList.add(Integer.valueOf(intValue));
            } else {
            }
            obj[i] = i3;
            i++;
            i2 = intValue;
        }
        this.f11056I = new int[arrayList.size()];
        System.arraycopy(obj, 0, this.f11056I, 0, this.f11056I.length);
        return arrayList;
    }
}
