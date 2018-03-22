package com.amap.api.mapcore;

import android.graphics.Bitmap;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.amap.api.mapcore.util.av;
import com.amap.api.mapcore.util.av.C3285d;
import com.amap.api.mapcore.util.ba.C3288a;
import com.amap.api.mapcore.util.bb;
import com.amap.api.mapcore.util.bd;
import com.amap.api.mapcore.util.bd.C3289a;
import com.amap.api.mapcore.util.bf;
import com.amap.api.mapcore.util.bh;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: TileOverlayDelegateImp */
public class bm implements ao {
    private static int f11157g = 0;
    private bn f11158a;
    private TileProvider f11159b;
    private Float f11160c;
    private boolean f11161d;
    private boolean f11162e;
    private aa f11163f;
    private int f11164h;
    private int f11165i;
    private int f11166j;
    private bb f11167k;
    private CopyOnWriteArrayList<C3239a> f11168l;
    private boolean f11169m;
    private C3240b f11170n;
    private String f11171o;
    private FloatBuffer f11172p;

    /* compiled from: TileOverlayDelegateImp */
    public class C3239a implements Cloneable {
        public int f11130a;
        public int f11131b;
        public int f11132c;
        public int f11133d;
        public IPoint f11134e;
        public int f11135f = 0;
        public boolean f11136g = false;
        public FloatBuffer f11137h = null;
        public Bitmap f11138i = null;
        public C3289a f11139j = null;
        public int f11140k = 0;
        final /* synthetic */ bm f11141l;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m15162a();
        }

        public C3239a(bm bmVar, int i, int i2, int i3, int i4) {
            this.f11141l = bmVar;
            this.f11130a = i;
            this.f11131b = i2;
            this.f11132c = i3;
            this.f11133d = i4;
        }

        public C3239a(bm bmVar, C3239a c3239a) {
            this.f11141l = bmVar;
            this.f11130a = c3239a.f11130a;
            this.f11131b = c3239a.f11131b;
            this.f11132c = c3239a.f11132c;
            this.f11133d = c3239a.f11133d;
            this.f11134e = c3239a.f11134e;
            this.f11137h = c3239a.f11137h;
        }

        public C3239a m15162a() {
            try {
                C3239a c3239a = (C3239a) super.clone();
                c3239a.f11130a = this.f11130a;
                c3239a.f11131b = this.f11131b;
                c3239a.f11132c = this.f11132c;
                c3239a.f11133d = this.f11133d;
                c3239a.f11134e = (IPoint) this.f11134e.clone();
                c3239a.f11137h = this.f11137h.asReadOnlyBuffer();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new C3239a(this.f11141l, this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C3239a)) {
                return false;
            }
            C3239a c3239a = (C3239a) obj;
            if (this.f11130a == c3239a.f11130a && this.f11131b == c3239a.f11131b && this.f11132c == c3239a.f11132c && this.f11133d == c3239a.f11133d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f11130a * 7) + (this.f11131b * 11)) + (this.f11132c * 13)) + this.f11133d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f11130a);
            stringBuilder.append("-");
            stringBuilder.append(this.f11131b);
            stringBuilder.append("-");
            stringBuilder.append(this.f11132c);
            stringBuilder.append("-");
            stringBuilder.append(this.f11133d);
            return stringBuilder.toString();
        }

        public void m15163a(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    this.f11139j = null;
                    this.f11138i = bk.m15650a(bitmap, bk.m15642a(bitmap.getWidth()), bk.m15642a(bitmap.getHeight()));
                    this.f11141l.f11163f.mo3816e(false);
                } catch (Throwable th) {
                    ca.m15831a(th, "TileOverlayDelegateImp", "setBitmap");
                    th.printStackTrace();
                    if (this.f11140k < 3) {
                        this.f11141l.f11167k.m15593a(true, this);
                        this.f11140k++;
                        bf.m15627a("TileOverlayDelegateImp", "setBitmap Throwable: " + this + "retry: " + this.f11140k, 111);
                    }
                }
            } else if (this.f11140k < 3) {
                this.f11141l.f11167k.m15593a(true, this);
                this.f11140k++;
                bf.m15627a("TileOverlayDelegateImp", "setBitmap failed: " + this + "retry: " + this.f11140k, 111);
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }

        public void m15164b() {
            bd.m15584a(this);
            if (this.f11136g) {
                this.f11141l.f11158a.f11178c.add(Integer.valueOf(this.f11135f));
            }
            this.f11136g = false;
            this.f11135f = 0;
            if (!(this.f11138i == null || this.f11138i.isRecycled())) {
                this.f11138i.recycle();
            }
            this.f11138i = null;
            if (this.f11137h != null) {
                this.f11137h.clear();
            }
            this.f11137h = null;
            this.f11139j = null;
        }
    }

    /* compiled from: TileOverlayDelegateImp */
    class C3240b extends av<aa, Void, List<C3239a>> {
        final /* synthetic */ bm f11154a;
        private int f11155e;
        private boolean f11156f;

        public C3240b(bm bmVar, boolean z) {
            this.f11154a = bmVar;
            this.f11156f = z;
        }

        protected List<C3239a> m15185a(aa... aaVarArr) {
            int l;
            int i = 0;
            try {
                int k = aaVarArr[0].mo3827k();
                l = aaVarArr[0].mo3829l();
                this.f11155e = (int) aaVarArr[0].mo3740E();
                i = k;
            } catch (Throwable th) {
                l = 0;
            }
            if (i <= 0 || l <= 0) {
                return null;
            }
            return this.f11154a.m15190a(this.f11155e, i, l);
        }

        protected void m15187a(List<C3239a> list) {
            if (list != null && list.size() > 0) {
                this.f11154a.m15195a((List) list, this.f11155e, this.f11156f);
                list.clear();
            }
        }
    }

    private static String m15189a(String str) {
        f11157g++;
        return str + f11157g;
    }

    public bm(TileOverlayOptions tileOverlayOptions, bn bnVar) {
        this.f11162e = false;
        this.f11164h = 256;
        this.f11165i = 256;
        this.f11166j = -1;
        this.f11168l = new CopyOnWriteArrayList();
        this.f11169m = false;
        this.f11170n = null;
        this.f11171o = null;
        this.f11172p = null;
        this.f11158a = bnVar;
        this.f11159b = tileOverlayOptions.getTileProvider();
        this.f11164h = this.f11159b.getTileWidth();
        this.f11165i = this.f11159b.getTileHeight();
        int a = bk.m15642a(this.f11164h);
        float f = ((float) this.f11164h) / ((float) a);
        float a2 = ((float) this.f11165i) / ((float) bk.m15642a(this.f11165i));
        this.f11172p = bk.m15659a(new float[]{0.0f, a2, f, a2, f, 0.0f, 0.0f, 0.0f});
        this.f11160c = Float.valueOf(tileOverlayOptions.getZIndex());
        this.f11161d = tileOverlayOptions.isVisible();
        this.f11171o = mo3945c();
        this.f11163f = this.f11158a.m15214a();
        this.f11166j = Integer.valueOf(this.f11171o.substring("TileOverlay".length())).intValue();
        C3288a c3288a = new C3288a(this.f11158a.getContext(), this.f11171o);
        c3288a.m15561a(tileOverlayOptions.getMemoryCacheEnabled());
        c3288a.m15563b(tileOverlayOptions.getDiskCacheEnabled());
        c3288a.m15559a(tileOverlayOptions.getMemCacheSize());
        c3288a.m15562b(tileOverlayOptions.getDiskCacheSize());
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (!(diskCacheDir == null || diskCacheDir.equals(""))) {
            c3288a.m15560a(diskCacheDir);
        }
        this.f11167k = new bb(this.f11158a.getContext(), this.f11164h, this.f11165i);
        this.f11167k.m15612a(this.f11159b);
        this.f11167k.m15591a(c3288a);
        mo3944b(true);
    }

    public bm(TileOverlayOptions tileOverlayOptions, bn bnVar, boolean z) {
        this(tileOverlayOptions, bnVar);
        this.f11162e = z;
    }

    public void mo3938a() {
        if (this.f11170n != null && this.f11170n.m15173a() == C3285d.RUNNING) {
            this.f11170n.m15177a(true);
        }
        Iterator it = this.f11168l.iterator();
        while (it.hasNext()) {
            ((C3239a) it.next()).m15164b();
        }
        this.f11168l.clear();
        this.f11167k.m15601h();
        this.f11158a.m15220b((ao) this);
        this.f11163f.mo3816e(false);
    }

    public void mo3943b() {
        this.f11167k.m15599f();
    }

    public String mo3945c() {
        if (this.f11171o == null) {
            this.f11171o = m15189a("TileOverlay");
        }
        return this.f11171o;
    }

    public void mo3939a(float f) {
        this.f11160c = Float.valueOf(f);
        this.f11158a.m15221c();
    }

    public float mo3947d() {
        return this.f11160c.floatValue();
    }

    public void mo3941a(boolean z) {
        this.f11161d = z;
        this.f11163f.mo3816e(false);
        if (z) {
            mo3944b(true);
        }
    }

    public boolean mo3948e() {
        return this.f11161d;
    }

    public boolean mo3942a(ao aoVar) {
        if (equals(aoVar) || aoVar.mo3945c().equals(mo3945c())) {
            return true;
        }
        return false;
    }

    public int mo3949f() {
        return super.hashCode();
    }

    private boolean m15193a(C3239a c3239a) {
        MapProjection c = this.f11163f.mo3809c();
        float f = (float) c3239a.f11132c;
        int i = this.f11164h;
        int i2 = this.f11165i;
        int i3 = c3239a.f11134e.f13273x;
        int i4 = c3239a.f11134e.f13274y + ((1 << (20 - ((int) f))) * i2);
        r6 = new float[12];
        FPoint fPoint = new FPoint();
        c.geo2Map(i3, i4, fPoint);
        FPoint fPoint2 = new FPoint();
        c.geo2Map(((1 << (20 - ((int) f))) * i) + i3, i4, fPoint2);
        FPoint fPoint3 = new FPoint();
        c.geo2Map((i * (1 << (20 - ((int) f)))) + i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint3);
        FPoint fPoint4 = new FPoint();
        c.geo2Map(i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint4);
        r6[0] = fPoint.f13252x;
        r6[1] = fPoint.f13253y;
        r6[2] = 0.0f;
        r6[3] = fPoint2.f13252x;
        r6[4] = fPoint2.f13253y;
        r6[5] = 0.0f;
        r6[6] = fPoint3.f13252x;
        r6[7] = fPoint3.f13253y;
        r6[8] = 0.0f;
        r6[9] = fPoint4.f13252x;
        r6[10] = fPoint4.f13253y;
        r6[11] = 0.0f;
        if (c3239a.f11137h == null) {
            c3239a.f11137h = bk.m15659a(r6);
        } else {
            c3239a.f11137h = bk.m15660a(r6, c3239a.f11137h);
        }
        return true;
    }

    private void m15192a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
            gl10.glTexEnvf(8960, 8704, 8448.0f);
            gl10.glBlendFunc(770, 771);
            gl10.glColor4f(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            gl10.glEnable(3553);
            gl10.glEnableClientState(32884);
            gl10.glEnableClientState(32888);
            gl10.glBindTexture(3553, i);
            gl10.glVertexPointer(3, 5126, 0, floatBuffer);
            gl10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            gl10.glDrawArrays(6, 0, 4);
            gl10.glDisableClientState(32884);
            gl10.glDisableClientState(32888);
            gl10.glDisable(3553);
            gl10.glDisable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
        }
    }

    public void mo3940a(GL10 gl10) {
        if (this.f11168l != null && this.f11168l.size() != 0) {
            Iterator it = this.f11168l.iterator();
            while (it.hasNext()) {
                C3239a c3239a = (C3239a) it.next();
                if (!c3239a.f11136g) {
                    try {
                        IPoint iPoint = c3239a.f11134e;
                        if (!(c3239a.f11138i == null || c3239a.f11138i.isRecycled() || iPoint == null)) {
                            c3239a.f11135f = bk.m15645a(gl10, c3239a.f11138i);
                            if (c3239a.f11135f != 0) {
                                c3239a.f11136g = true;
                            }
                            c3239a.f11138i = null;
                        }
                    } catch (Throwable th) {
                        ca.m15831a(th, "TileOverlayDelegateImp", "drawTiles");
                        bf.m15627a("TileOverlayDelegateImp", th.toString(), 112);
                    }
                }
                if (c3239a.f11136g) {
                    m15193a(c3239a);
                    m15192a(gl10, c3239a.f11135f, c3239a.f11137h, this.f11172p);
                }
            }
        }
    }

    private ArrayList<C3239a> m15190a(int i, int i2, int i3) {
        MapProjection c = this.f11163f.mo3809c();
        FPoint fPoint = new FPoint();
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        c.win2Map(0, 0, fPoint);
        c.map2Geo(fPoint.f13252x, fPoint.f13253y, iPoint);
        int min = Math.min(Integer.MAX_VALUE, iPoint.f13273x);
        int max = Math.max(0, iPoint.f13273x);
        int min2 = Math.min(Integer.MAX_VALUE, iPoint.f13274y);
        int max2 = Math.max(0, iPoint.f13274y);
        c.win2Map(i2, 0, fPoint);
        c.map2Geo(fPoint.f13252x, fPoint.f13253y, iPoint);
        min = Math.min(min, iPoint.f13273x);
        max = Math.max(max, iPoint.f13273x);
        min2 = Math.min(min2, iPoint.f13274y);
        max2 = Math.max(max2, iPoint.f13274y);
        c.win2Map(0, i3, fPoint);
        c.map2Geo(fPoint.f13252x, fPoint.f13253y, iPoint);
        min = Math.min(min, iPoint.f13273x);
        max = Math.max(max, iPoint.f13273x);
        min2 = Math.min(min2, iPoint.f13274y);
        max2 = Math.max(max2, iPoint.f13274y);
        c.win2Map(i2, i3, fPoint);
        c.map2Geo(fPoint.f13252x, fPoint.f13253y, iPoint);
        min = Math.min(min, iPoint.f13273x);
        int max3 = Math.max(max, iPoint.f13273x);
        max = Math.min(min2, iPoint.f13274y);
        int max4 = Math.max(max2, iPoint.f13274y);
        int i4 = min - ((1 << (20 - i)) * this.f11164h);
        int i5 = max - ((1 << (20 - i)) * this.f11165i);
        c.getGeoCenter(iPoint2);
        max = (iPoint2.f13273x >> (20 - i)) / this.f11164h;
        min2 = (iPoint2.f13274y >> (20 - i)) / this.f11165i;
        int i6 = (max << (20 - i)) * this.f11164h;
        int i7 = (min2 << (20 - i)) * this.f11165i;
        C3239a c3239a = new C3239a(this, max, min2, i, this.f11166j);
        c3239a.f11134e = new IPoint(i6, i7);
        ArrayList<C3239a> arrayList = new ArrayList();
        arrayList.add(c3239a);
        min = 1;
        while (true) {
            Object obj = null;
            for (i6 = max - min; i6 <= max + min; i6++) {
                i7 = min2 + min;
                IPoint iPoint3 = new IPoint((i6 << (20 - i)) * this.f11164h, (i7 << (20 - i)) * this.f11165i);
                if (iPoint3.f13273x < max3 && iPoint3.f13273x > i4 && iPoint3.f13274y < max4 && iPoint3.f13274y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    C3239a c3239a2 = new C3239a(this, i6, i7, i, this.f11166j);
                    c3239a2.f11134e = iPoint3;
                    arrayList.add(c3239a2);
                }
                i7 = min2 - min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.f11164h, (i7 << (20 - i)) * this.f11165i);
                if (iPoint3.f13273x < max3 && iPoint3.f13273x > i4 && iPoint3.f13274y < max4 && iPoint3.f13274y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    c3239a2 = new C3239a(this, i6, i7, i, this.f11166j);
                    c3239a2.f11134e = iPoint3;
                    arrayList.add(c3239a2);
                }
            }
            for (i7 = (min2 + min) - 1; i7 > min2 - min; i7--) {
                i6 = max + min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.f11164h, (i7 << (20 - i)) * this.f11165i);
                if (iPoint3.f13273x < max3 && iPoint3.f13273x > i4 && iPoint3.f13274y < max4 && iPoint3.f13274y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    c3239a2 = new C3239a(this, i6, i7, i, this.f11166j);
                    c3239a2.f11134e = iPoint3;
                    arrayList.add(c3239a2);
                }
                i6 = max - min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.f11164h, (i7 << (20 - i)) * this.f11165i);
                if (iPoint3.f13273x < max3 && iPoint3.f13273x > i4 && iPoint3.f13274y < max4 && iPoint3.f13274y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    c3239a2 = new C3239a(this, i6, i7, i, this.f11166j);
                    c3239a2.f11134e = iPoint3;
                    arrayList.add(c3239a2);
                }
            }
            if (obj == null) {
                return arrayList;
            }
            min++;
        }
    }

    private boolean m15195a(List<C3239a> list, int i, boolean z) {
        int i2 = 0;
        if (list == null) {
            return false;
        }
        if (this.f11168l == null) {
            return false;
        }
        int i3;
        Iterator it = this.f11168l.iterator();
        while (it.hasNext()) {
            C3239a c3239a = (C3239a) it.next();
            for (C3239a c3239a2 : list) {
                if (c3239a.equals(c3239a2) && c3239a.f11136g) {
                    c3239a2.f11136g = c3239a.f11136g;
                    c3239a2.f11135f = c3239a.f11135f;
                    i3 = 1;
                    break;
                }
            }
            i3 = 0;
            if (i3 == 0) {
                c3239a.m15164b();
            }
        }
        this.f11168l.clear();
        if (i > ((int) this.f11163f.mo3835r()) || i < ((int) this.f11163f.mo3836s())) {
            return false;
        }
        i3 = list.size();
        if (i3 <= 0) {
            return false;
        }
        while (i2 < i3) {
            c3239a = (C3239a) list.get(i2);
            if (c3239a != null && (!this.f11162e || (c3239a.f11132c >= 10 && !bh.m15629a(c3239a.f11130a, c3239a.f11131b, c3239a.f11132c)))) {
                this.f11168l.add(c3239a);
                if (!c3239a.f11136g) {
                    this.f11167k.m15593a(z, c3239a);
                }
            }
            i2++;
        }
        return true;
    }

    public void mo3944b(boolean z) {
        if (!this.f11169m) {
            if (this.f11170n != null && this.f11170n.m15173a() == C3285d.RUNNING) {
                this.f11170n.m15177a(true);
            }
            this.f11170n = new C3240b(this, z);
            this.f11170n.m15181c((Object[]) new aa[]{this.f11163f});
        }
    }

    public void mo3950g() {
        this.f11167k.m15595b(false);
        this.f11167k.m15592a(true);
        this.f11167k.m15600g();
    }

    public void mo3951h() {
        this.f11167k.m15592a(false);
    }

    public void mo3946c(boolean z) {
        if (this.f11169m != z) {
            this.f11169m = z;
            this.f11167k.m15595b(z);
        }
    }
}
