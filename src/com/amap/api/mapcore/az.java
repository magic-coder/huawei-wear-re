package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES10;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.util.Log;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.mapcore.util.dx;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: MarkerDelegateImp */
class az implements ag {
    private static int f10954a = 0;
    private boolean f10955A = false;
    private boolean f10956B = true;
    private av f10957C;
    private FloatBuffer f10958D;
    private Object f10959E;
    private boolean f10960F = false;
    private CopyOnWriteArrayList<BitmapDescriptor> f10961G = null;
    private boolean f10962H = false;
    private boolean f10963I = false;
    private boolean f10964J = true;
    private int f10965K = 0;
    private int f10966L = 20;
    private boolean f10967M = false;
    private int f10968N;
    private int f10969O;
    private long f10970P = 0;
    private boolean f10971b = false;
    private boolean f10972c = false;
    private boolean f10973d = false;
    private float f10974e = 0.0f;
    private float f10975f = 0.0f;
    private boolean f10976g = false;
    private int f10977h = 0;
    private int f10978i = 0;
    private int f10979j = 0;
    private int f10980k = 0;
    private int f10981l;
    private int f10982m;
    private FPoint f10983n = new FPoint();
    private float[] f10984o;
    private int[] f10985p = null;
    private float f10986q = 0.0f;
    private boolean f10987r = false;
    private FloatBuffer f10988s = null;
    private String f10989t;
    private LatLng f10990u;
    private LatLng f10991v;
    private String f10992w;
    private String f10993x;
    private float f10994y = 0.5f;
    private float f10995z = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;

    private static String m14883c(String str) {
        f10954a++;
        return str + f10954a;
    }

    public void mo3683a(float f) {
        this.f10975f = f;
        this.f10974e = (((-f) % 360.0f) + 360.0f) % 360.0f;
        if (mo3714n()) {
            this.f10957C.m14873e(this);
            this.f10957C.m14871d(this);
        }
        m14878M();
    }

    public boolean mo3724x() {
        return this.f10987r;
    }

    public synchronized void mo3725y() {
        if (this.f10987r) {
            try {
                mo3699b();
                if (this.f10961G != null) {
                    Iterator it = this.f10961G.iterator();
                    while (it.hasNext()) {
                        ((BitmapDescriptor) it.next()).recycle();
                    }
                    this.f10961G = null;
                }
                if (this.f10958D != null) {
                    this.f10958D.clear();
                    this.f10958D = null;
                }
                if (this.f10988s != null) {
                    this.f10988s.clear();
                    this.f10988s = null;
                }
                this.f10990u = null;
                this.f10959E = null;
                this.f10985p = null;
            } catch (Throwable th) {
                ca.m15831a(th, "MarkerDelegateImp", "realdestroy");
                th.printStackTrace();
                Log.d("destroy erro", "MarkerDelegateImp destroy");
            }
        }
        return;
    }

    public void mo3716p() {
        try {
            int i;
            this.f10987r = true;
            mo3699b();
            if (this.f10957C != null) {
                this.f10957C.f10937a.mo3747N();
                i = 0;
                while (this.f10985p != null && i < this.f10985p.length) {
                    this.f10957C.m14861a(Integer.valueOf(this.f10985p[i]));
                    this.f10957C.m14858a(this.f10985p[i]);
                    i++;
                }
            }
            i = 0;
            while (this.f10961G != null && i < this.f10961G.size()) {
                ((BitmapDescriptor) this.f10961G.get(i)).recycle();
                i++;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "MarkerDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    synchronized void m14896a() {
        if (this.f10961G == null) {
            this.f10961G = new CopyOnWriteArrayList();
        } else {
            this.f10961G.clear();
        }
    }

    public synchronized void m14912b(ArrayList<BitmapDescriptor> arrayList) {
        m14896a();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) it.next();
                if (bitmapDescriptor != null) {
                    this.f10961G.add(bitmapDescriptor);
                }
            }
        }
    }

    public az(MarkerOptions markerOptions, av avVar) {
        this.f10957C = avVar;
        this.f10990u = markerOptions.getPosition();
        IPoint iPoint = new IPoint();
        this.f10962H = markerOptions.isGps();
        if (markerOptions.getPosition() != null) {
            if (this.f10962H) {
                try {
                    double[] a = dx.m16107a(markerOptions.getPosition().longitude, markerOptions.getPosition().latitude);
                    this.f10991v = new LatLng(a[1], a[0]);
                    MapProjection.lonlat2Geo(a[0], a[1], iPoint);
                } catch (Throwable th) {
                    ca.m15831a(th, "MarkerDelegateImp", "create");
                    this.f10991v = markerOptions.getPosition();
                }
            } else {
                MapProjection.lonlat2Geo(this.f10990u.longitude, this.f10990u.latitude, iPoint);
            }
        }
        this.f10981l = iPoint.f13273x;
        this.f10982m = iPoint.f13274y;
        this.f10994y = markerOptions.getAnchorU();
        this.f10995z = markerOptions.getAnchorV();
        this.f10977h = markerOptions.getInfoWindowOffsetX();
        this.f10978i = markerOptions.getInfoWindowOffsetY();
        this.f10966L = markerOptions.getPeriod();
        this.f10986q = markerOptions.getZIndex();
        mo3718r();
        m14912b(markerOptions.getIcons());
        this.f10956B = markerOptions.isVisible();
        this.f10993x = markerOptions.getSnippet();
        this.f10992w = markerOptions.getTitle();
        this.f10955A = markerOptions.isDraggable();
        this.f10989t = mo3708h();
        this.f10960F = markerOptions.isPerspective();
        this.f10976g = markerOptions.isFlat();
    }

    public int m14893J() {
        try {
            return m14895L().getWidth();
        } catch (Throwable th) {
            return 0;
        }
    }

    public int m14894K() {
        try {
            return m14895L().getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    public Rect mo3702d() {
        if (this.f10984o == null) {
            return new Rect(0, 0, 0, 0);
        }
        try {
            Rect rect;
            MapProjection c = this.f10957C.f10937a.mo3809c();
            int J = m14893J();
            int K = m14894K();
            IPoint iPoint = new IPoint();
            IPoint iPoint2 = new IPoint();
            c.map2Win(this.f10983n.f13252x, this.f10983n.f13253y, iPoint);
            if (this.f10976g) {
                c.map2Win(this.f10984o[0], this.f10984o[1], iPoint2);
                rect = new Rect(iPoint2.f13273x, iPoint2.f13274y, iPoint2.f13273x, iPoint2.f13274y);
                c.map2Win(this.f10984o[3], this.f10984o[4], iPoint2);
                rect.union(iPoint2.f13273x, iPoint2.f13274y);
                c.map2Win(this.f10984o[6], this.f10984o[7], iPoint2);
                rect.union(iPoint2.f13273x, iPoint2.f13274y);
                c.map2Win(this.f10984o[9], this.f10984o[10], iPoint2);
                rect.union(iPoint2.f13273x, iPoint2.f13274y);
            } else {
                m14880a((-this.f10994y) * ((float) J), (this.f10995z - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * ((float) K), iPoint2);
                rect = new Rect(iPoint.f13273x + iPoint2.f13273x, iPoint.f13274y - iPoint2.f13274y, iPoint.f13273x + iPoint2.f13273x, iPoint.f13274y - iPoint2.f13274y);
                m14880a((-this.f10994y) * ((float) J), this.f10995z * ((float) K), iPoint2);
                rect.union(iPoint.f13273x + iPoint2.f13273x, iPoint.f13274y - iPoint2.f13274y);
                m14880a((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f10994y) * ((float) J), this.f10995z * ((float) K), iPoint2);
                rect.union(iPoint.f13273x + iPoint2.f13273x, iPoint.f13274y - iPoint2.f13274y);
                m14880a((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f10994y) * ((float) J), (this.f10995z - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * ((float) K), iPoint2);
                rect.union(iPoint.f13273x + iPoint2.f13273x, iPoint.f13274y - iPoint2.f13274y);
            }
            this.f10979j = rect.centerX() - iPoint.f13273x;
            this.f10980k = rect.top - iPoint.f13274y;
            return rect;
        } catch (Throwable th) {
            ca.m15831a(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    public synchronized boolean mo3699b() {
        boolean z = false;
        synchronized (this) {
            m14878M();
            this.f10956B = false;
            if (this.f10957C != null) {
                z = this.f10957C.m14867b((ag) this);
            }
        }
        return z;
    }

    private void m14878M() {
        if (this.f10957C.f10937a != null) {
            this.f10957C.f10937a.mo3816e(false);
        }
    }

    public LatLng mo3704e() {
        if (!this.f10967M || this.f10983n == null) {
            return this.f10990u;
        }
        DPoint dPoint = new DPoint();
        IPoint iPoint = new IPoint();
        mo3718r();
        this.f10957C.f10937a.mo3767a(this.f10983n.f13252x, this.f10983n.f13253y, iPoint);
        MapProjection.geo2LonLat(iPoint.f13273x, iPoint.f13274y, dPoint);
        return new LatLng(dPoint.f13251y, dPoint.f13250x);
    }

    public String mo3708h() {
        if (this.f10989t == null) {
            this.f10989t = m14883c("Marker");
        }
        return this.f10989t;
    }

    public void mo3688a(LatLng latLng) {
        if (latLng == null) {
            ca.m15831a(new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
            return;
        }
        this.f10990u = latLng;
        IPoint iPoint = new IPoint();
        if (this.f10962H) {
            try {
                double[] a = dx.m16107a(latLng.longitude, latLng.latitude);
                this.f10991v = new LatLng(a[1], a[0]);
                MapProjection.lonlat2Geo(a[0], a[1], iPoint);
            } catch (Throwable th) {
                this.f10991v = latLng;
            }
        } else {
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        }
        this.f10981l = iPoint.f13273x;
        this.f10982m = iPoint.f13274y;
        this.f10967M = false;
        mo3718r();
        m14878M();
    }

    public void mo3691a(String str) {
        this.f10992w = str;
        m14878M();
    }

    public String mo3709i() {
        return this.f10992w;
    }

    public void mo3697b(String str) {
        this.f10993x = str;
        m14878M();
    }

    public String mo3710j() {
        return this.f10993x;
    }

    public void mo3694a(boolean z) {
        this.f10955A = z;
        m14878M();
    }

    public synchronized void mo3692a(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            try {
                if (this.f10961G != null) {
                    m14912b((ArrayList) arrayList);
                    this.f10963I = false;
                    this.f10971b = false;
                    if (this.f10958D != null) {
                        this.f10958D.clear();
                        this.f10958D = null;
                    }
                    this.f10985p = null;
                    if (mo3714n()) {
                        this.f10957C.m14873e(this);
                        this.f10957C.m14871d(this);
                    }
                    m14878M();
                }
            } catch (Throwable th) {
                ca.m15831a(th, "MarkerDelegateImp", "setIcons");
                th.printStackTrace();
            }
        }
    }

    public synchronized ArrayList<BitmapDescriptor> mo3723w() {
        ArrayList<BitmapDescriptor> arrayList;
        if (this.f10961G == null || this.f10961G.size() <= 0) {
            arrayList = null;
        } else {
            ArrayList<BitmapDescriptor> arrayList2 = new ArrayList();
            Iterator it = this.f10961G.iterator();
            while (it.hasNext()) {
                arrayList2.add((BitmapDescriptor) it.next());
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public synchronized void mo3687a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.f10961G != null) {
                    this.f10961G.clear();
                    this.f10961G.add(bitmapDescriptor);
                    this.f10963I = false;
                    this.f10971b = false;
                    this.f10985p = null;
                    if (this.f10958D != null) {
                        this.f10958D.clear();
                        this.f10958D = null;
                    }
                    if (mo3714n()) {
                        this.f10957C.m14873e(this);
                        this.f10957C.m14871d(this);
                    }
                    m14878M();
                }
            } catch (Throwable th) {
                ca.m15831a(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    public synchronized BitmapDescriptor m14895L() {
        BitmapDescriptor L;
        try {
            if (this.f10961G == null || this.f10961G.size() == 0) {
                m14896a();
                this.f10961G.add(BitmapDescriptorFactory.defaultMarker());
            } else if (this.f10961G.get(0) == null) {
                this.f10961G.clear();
                L = m14895L();
            }
            L = (BitmapDescriptor) this.f10961G.get(0);
        } catch (Throwable th) {
            ca.m15831a(th, "MarkerDelegateImp", "getBitmapDescriptor");
            th.printStackTrace();
            L = null;
        }
        return L;
    }

    public boolean mo3711k() {
        return this.f10955A;
    }

    public void mo3712l() {
        if (this.f10956B) {
            this.f10957C.m14871d(this);
            m14878M();
        }
    }

    public void mo3713m() {
        if (mo3714n()) {
            this.f10957C.m14873e(this);
            m14878M();
            this.f10972c = false;
        }
        this.f10973d = false;
    }

    public void mo3698b(boolean z) {
        this.f10972c = z;
        if (this.f10972c && this.f10967M) {
            this.f10973d = true;
        }
    }

    public boolean mo3714n() {
        return this.f10972c;
    }

    public void mo3700c(boolean z) {
        if (this.f10956B != z) {
            this.f10956B = z;
            if (!z && mo3714n()) {
                this.f10957C.m14873e(this);
            }
            m14878M();
        }
    }

    public boolean mo3715o() {
        return this.f10956B;
    }

    public void mo3684a(float f, float f2) {
        if (this.f10994y != f || this.f10995z != f2) {
            this.f10994y = f;
            this.f10995z = f2;
            if (mo3714n()) {
                this.f10957C.m14873e(this);
                this.f10957C.m14871d(this);
            }
            m14878M();
        }
    }

    public boolean mo3695a(ag agVar) throws RemoteException {
        if (equals(agVar) || agVar.mo3708h().equals(mo3708h())) {
            return true;
        }
        return false;
    }

    public int mo3717q() {
        return super.hashCode();
    }

    public boolean mo3718r() {
        if (this.f10967M) {
            this.f10957C.f10937a.mo3809c().win2Map(this.f10968N, this.f10969O, this.f10983n);
        } else {
            this.f10957C.f10937a.mo3809c().geo2Map(this.f10981l, this.f10982m, this.f10983n);
        }
        return true;
    }

    private void m14882a(aa aaVar) throws RemoteException {
        float[] a = bk.m15669a(aaVar, this.f10976g ? 1 : 0, this.f10983n, this.f10974e, m14893J(), m14894K(), this.f10994y, this.f10995z);
        this.f10984o = (float[]) a.clone();
        if (this.f10988s == null) {
            this.f10988s = bk.m15659a(a);
        } else {
            this.f10988s = bk.m15660a(a, this.f10988s);
        }
        if (this.f10961G != null && this.f10961G.size() > 0) {
            this.f10965K++;
            if (this.f10965K >= this.f10966L * this.f10961G.size()) {
                this.f10965K = 0;
            }
            int i = this.f10965K / this.f10966L;
            if (!this.f10964J) {
                m14878M();
            }
            if (this.f10985p != null && this.f10985p.length > 0) {
                m14881a(this.f10985p[i % this.f10961G.size()], this.f10988s, this.f10958D);
            }
        }
    }

    private void m14880a(float f, float f2, IPoint iPoint) {
        float f3 = (float) ((3.141592653589793d * ((double) this.f10974e)) / 180.0d);
        iPoint.f13273x = (int) ((((double) f) * Math.cos((double) f3)) + (((double) f2) * Math.sin((double) f3)));
        iPoint.f13274y = (int) ((((double) f2) * Math.cos((double) f3)) - (Math.sin((double) f3) * ((double) f)));
    }

    private void m14881a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i != 0 && floatBuffer != null && floatBuffer2 != null) {
            GLES10.glEnable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
            GLES10.glBlendFunc(1, 771);
            GLES10.glColor4f(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            GLES10.glEnable(3553);
            GLES10.glEnableClientState(32884);
            GLES10.glEnableClientState(32888);
            GLES10.glBindTexture(3553, i);
            GLES10.glVertexPointer(3, 5126, 0, floatBuffer);
            GLES10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            GLES10.glDrawArrays(6, 0, 4);
            GLES10.glDisableClientState(32884);
            GLES10.glDisableClientState(32888);
            GLES10.glDisable(3553);
            GLES10.glDisable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
        }
    }

    public void mo3693a(GL10 gl10, aa aaVar) {
        int i = 0;
        if (!this.f10956B) {
            return;
        }
        if (this.f10990u == null && !this.f10967M) {
            return;
        }
        if (m14895L() != null || this.f10961G != null) {
            int i2;
            int i3;
            BitmapDescriptor bitmapDescriptor;
            if (!this.f10963I) {
                try {
                    if (this.f10961G != null) {
                        this.f10985p = new int[this.f10961G.size()];
                        i2 = VERSION.SDK_INT >= 12 ? 1 : 0;
                        Iterator it = this.f10961G.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            bitmapDescriptor = (BitmapDescriptor) it.next();
                            if (i2 != 0) {
                                i = this.f10957C.m14856a(bitmapDescriptor);
                            }
                            if (i == 0) {
                                Bitmap bitmap = bitmapDescriptor.getBitmap();
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    i = m14879a(gl10);
                                    if (i2 != 0) {
                                        this.f10957C.m14860a(new bd(bitmapDescriptor, i));
                                    }
                                    bk.m15671b(gl10, i, bitmap, false);
                                }
                            }
                            int i4 = i;
                            this.f10985p[i3] = i4;
                            i3++;
                            i = i4;
                        }
                        if (this.f10961G.size() == 1) {
                            this.f10964J = true;
                        } else {
                            this.f10964J = false;
                        }
                        this.f10963I = true;
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "MarkerDelegateImp", "loadtexture");
                    return;
                }
            }
            try {
                if (!this.f10971b) {
                    if (this.f10958D == null) {
                        bitmapDescriptor = m14895L();
                        if (bitmapDescriptor != null) {
                            i = bitmapDescriptor.getWidth();
                            i3 = bitmapDescriptor.getHeight();
                            i2 = bitmapDescriptor.getBitmap().getHeight();
                            float width = ((float) i) / ((float) bitmapDescriptor.getBitmap().getWidth());
                            float f = ((float) i3) / ((float) i2);
                            this.f10958D = bk.m15659a(new float[]{0.0f, f, width, f, width, 0.0f, 0.0f, 0.0f});
                        } else {
                            return;
                        }
                    }
                    mo3718r();
                    this.f10970P = System.currentTimeMillis();
                    this.f10971b = true;
                }
                if (this.f10967M) {
                    aaVar.mo3772a(this.f10968N, this.f10969O, this.f10983n);
                }
                m14882a(aaVar);
                if (this.f10973d && mo3714n()) {
                    this.f10957C.m14877i();
                    if (System.currentTimeMillis() - this.f10970P > 1000) {
                        this.f10973d = false;
                    }
                }
            } catch (Throwable th2) {
                ca.m15831a(th2, "MarkerDelegateImp", "drawMarker");
            }
        }
    }

    private int m14879a(GL10 gl10) {
        int K = this.f10957C.f10937a.mo3744K();
        if (K != 0) {
            return K;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public boolean mo3701c() {
        return this.f10964J;
    }

    public void mo3685a(int i) {
        if (i <= 1) {
            this.f10966L = 1;
        } else {
            this.f10966L = i;
        }
    }

    public void mo3690a(Object obj) {
        this.f10959E = obj;
    }

    public Object mo3719s() {
        return this.f10959E;
    }

    public void mo3703d(boolean z) {
        this.f10960F = z;
    }

    public boolean mo3720t() {
        return this.f10960F;
    }

    public int mo3722v() {
        return this.f10966L;
    }

    public LatLng mo3707g() {
        if (!this.f10967M) {
            return this.f10962H ? this.f10991v : this.f10990u;
        } else {
            this.f10957C.f10937a.mo3809c().win2Map(this.f10968N, this.f10969O, this.f10983n);
            DPoint dPoint = new DPoint();
            this.f10957C.f10937a.mo3771a(this.f10968N, this.f10969O, dPoint);
            return new LatLng(dPoint.f13251y, dPoint.f13251y);
        }
    }

    public void mo3726z() {
        this.f10957C.m14868c(this);
    }

    public void mo3705e(boolean z) throws RemoteException {
        this.f10976g = z;
        m14878M();
    }

    public boolean mo3674A() {
        return this.f10976g;
    }

    public float mo3721u() {
        return this.f10975f;
    }

    public int mo3675B() {
        return this.f10977h;
    }

    public int mo3676C() {
        return this.f10978i;
    }

    public void mo3686a(int i, int i2) {
        int i3 = 1;
        this.f10968N = i;
        this.f10969O = i2;
        this.f10967M = true;
        mo3718r();
        try {
            aa aaVar = this.f10957C.f10937a;
            if (!this.f10976g) {
                i3 = 0;
            }
            this.f10984o = bk.m15669a(aaVar, i3, this.f10983n, this.f10974e, m14893J(), m14894K(), this.f10994y, this.f10995z);
        } catch (Throwable th) {
            ca.m15831a(th, "MarkerDelegateImp", "setPositionByPixels");
        }
        m14878M();
        if (mo3714n()) {
            mo3712l();
        }
    }

    public int mo3677D() {
        return this.f10979j;
    }

    public int mo3678E() {
        return this.f10980k;
    }

    public FPoint mo3706f() {
        return this.f10983n;
    }

    public boolean mo3679F() {
        return this.f10967M;
    }

    public void mo3696b(float f) {
        this.f10986q = f;
        this.f10957C.m14876h();
    }

    public float mo3680G() {
        return this.f10986q;
    }

    public boolean mo3681H() {
        Rect j = this.f10957C.f10937a.mo3825j();
        if (this.f10967M || j == null) {
            return true;
        }
        IPoint iPoint = new IPoint();
        if (this.f10962H && this.f10991v != null) {
            this.f10957C.f10937a.mo3802b(this.f10991v.latitude, this.f10991v.longitude, iPoint);
        } else if (this.f10990u != null) {
            this.f10957C.f10937a.mo3802b(this.f10990u.latitude, this.f10990u.longitude, iPoint);
        }
        return j.contains(iPoint.f13273x, iPoint.f13274y);
    }

    public void mo3689a(IPoint iPoint) {
        this.f10967M = false;
        this.f10981l = iPoint.f13273x;
        this.f10982m = iPoint.f13274y;
        DPoint dPoint = new DPoint();
        MapProjection.geo2LonLat(this.f10981l, this.f10982m, dPoint);
        this.f10990u = new LatLng(dPoint.f13251y, dPoint.f13250x, false);
        this.f10957C.f10937a.mo3809c().geo2Map(this.f10981l, this.f10982m, this.f10983n);
    }

    public IPoint mo3682I() {
        IPoint iPoint = new IPoint();
        if (!this.f10967M) {
            return new IPoint(this.f10981l, this.f10982m);
        }
        this.f10957C.f10937a.mo3773a(this.f10968N, this.f10969O, iPoint);
        return iPoint;
    }
}
