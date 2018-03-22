package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: MapOverlayImageView */
class av extends View {
    aa f10937a;
    C3236a f10938b = new C3236a();
    private CopyOnWriteArrayList<ag> f10939c = new CopyOnWriteArrayList(new ArrayList(500));
    private CopyOnWriteArrayList<bd> f10940d = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<Integer> f10941e = new CopyOnWriteArrayList();
    private IPoint f10942f;
    private ag f10943g;
    private Handler f10944h = new Handler();
    private Runnable f10945i = new aw(this);
    private final Handler f10946j = new Handler();
    private final Runnable f10947k = new ax(this);

    /* compiled from: MapOverlayImageView */
    class C3236a implements Serializable, Comparator<Object> {
        C3236a() {
        }

        public int compare(Object obj, Object obj2) {
            ag agVar = (ag) obj;
            ag agVar2 = (ag) obj2;
            if (!(agVar == null || agVar2 == null)) {
                try {
                    if (agVar.mo3680G() > agVar2.mo3680G()) {
                        return 1;
                    }
                    if (agVar.mo3680G() < agVar2.mo3680G()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "MapOverlayImageView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public av(Context context) {
        super(context);
    }

    public av(Context context, AttributeSet attributeSet, aa aaVar) {
        super(context, attributeSet);
        this.f10937a = aaVar;
    }

    protected synchronized int m14855a() {
        return this.f10939c.size();
    }

    public synchronized void m14862a(String str) {
        Object obj;
        Iterator it;
        ag agVar;
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    obj = null;
                    this.f10943g = null;
                    this.f10942f = null;
                    if (obj == null) {
                        it = this.f10939c.iterator();
                        while (it.hasNext()) {
                            ((ag) it.next()).mo3699b();
                        }
                        this.f10939c.clear();
                    } else {
                        it = this.f10939c.iterator();
                        while (it.hasNext()) {
                            agVar = (ag) it.next();
                            if (!str.equals(agVar.mo3708h())) {
                                agVar.mo3699b();
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                ca.m15831a(e, "MapOverlayImageView", "clear");
                e.printStackTrace();
            }
        }
        obj = 1;
        this.f10943g = null;
        this.f10942f = null;
        if (obj == null) {
            it = this.f10939c.iterator();
            while (it.hasNext()) {
                agVar = (ag) it.next();
                if (!str.equals(agVar.mo3708h())) {
                    agVar.mo3699b();
                }
            }
        } else {
            it = this.f10939c.iterator();
            while (it.hasNext()) {
                ((ag) it.next()).mo3699b();
            }
            this.f10939c.clear();
        }
        return;
    }

    public synchronized void m14859a(ag agVar) {
        this.f10939c.add(agVar);
        m14876h();
    }

    public synchronized boolean m14867b(ag agVar) {
        m14873e(agVar);
        return this.f10939c.remove(agVar);
    }

    public synchronized void m14868c(ag agVar) {
        try {
            if (this.f10939c.remove(agVar)) {
                m14854j();
                this.f10939c.add(agVar);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "MapOverlayImageView", "set2Top");
        }
    }

    public void m14871d(ag agVar) {
        if (this.f10942f == null) {
            this.f10942f = new IPoint();
        }
        Rect d = agVar.mo3702d();
        this.f10942f = new IPoint(d.left + (d.width() / 2), d.top);
        this.f10943g = agVar;
        try {
            this.f10937a.mo3775a(this.f10943g);
        } catch (Throwable th) {
            ca.m15831a(th, "MapOverlayImageView", "showInfoWindow");
            th.printStackTrace();
        }
    }

    public void m14873e(ag agVar) {
        if (agVar.mo3714n()) {
            this.f10937a.mo3739D();
            this.f10943g = null;
        }
    }

    public synchronized void m14865b() {
        Iterator it = this.f10939c.iterator();
        while (it.hasNext()) {
            ag agVar = (ag) it.next();
            try {
                if (agVar.mo3715o()) {
                    agVar.mo3718r();
                }
            } catch (Throwable th) {
                ca.m15831a(th, "MapOverlayImageView", "calFPoint");
                th.printStackTrace();
            }
        }
    }

    private void m14854j() {
        try {
            Collection arrayList = new ArrayList(this.f10939c);
            Collections.sort(arrayList, this.f10938b);
            this.f10939c = new CopyOnWriteArrayList(arrayList);
        } catch (Throwable th) {
            ca.m15831a(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    public void m14863a(GL10 gl10) {
        Iterator it = this.f10941e.iterator();
        while (it.hasNext()) {
            gl10.glDeleteTextures(1, new int[]{((Integer) it.next()).intValue()}, 0);
            this.f10937a.mo3818f(r0.intValue());
        }
        this.f10941e.clear();
        if (!(this.f10943g == null || this.f10943g.mo3679F())) {
            m14877i();
        }
        it = this.f10939c.iterator();
        while (it.hasNext()) {
            ag agVar = (ag) it.next();
            if (agVar.mo3681H() || agVar.mo3714n()) {
                agVar.mo3693a(gl10, this.f10937a);
            }
        }
    }

    public synchronized boolean m14869c() {
        boolean z;
        Iterator it = this.f10939c.iterator();
        while (it.hasNext()) {
            if (!((ag) it.next()).mo3701c()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public ag m14870d() {
        return this.f10943g;
    }

    public ag m14857a(MotionEvent motionEvent) {
        Iterator it = this.f10939c.iterator();
        while (it.hasNext()) {
            ag agVar = (ag) it.next();
            if ((agVar instanceof az) && m14864a(agVar.mo3702d(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f10943g = agVar;
                return this.f10943g;
            }
        }
        return null;
    }

    public synchronized void m14860a(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.m14995b() != 0) {
                this.f10940d.add(bdVar);
            }
        }
    }

    public synchronized void m14858a(int i) {
        Iterator it = this.f10940d.iterator();
        while (it.hasNext()) {
            bd bdVar = (bd) it.next();
            if (bdVar.m14995b() == i) {
                this.f10940d.remove(bdVar);
            }
        }
    }

    public void m14861a(Integer num) {
        if (num.intValue() != 0) {
            this.f10941e.add(num);
        }
    }

    public synchronized int m14856a(BitmapDescriptor bitmapDescriptor) {
        int b;
        if (bitmapDescriptor != null) {
            if (!(bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled())) {
                for (int i = 0; i < this.f10940d.size(); i++) {
                    bd bdVar = (bd) this.f10940d.get(i);
                    if (bdVar.m14994a().equals(bitmapDescriptor)) {
                        b = bdVar.m14995b();
                        break;
                    }
                }
                b = 0;
            }
        }
        b = 0;
        return b;
    }

    public synchronized void m14872e() {
        try {
            Iterator it = this.f10939c.iterator();
            while (it.hasNext()) {
                ag agVar = (ag) it.next();
                if (agVar != null) {
                    agVar.mo3716p();
                }
            }
            m14862a(null);
            it = this.f10940d.iterator();
            while (it.hasNext()) {
                ((bd) it.next()).m14994a().recycle();
            }
            this.f10940d.clear();
        } catch (Throwable th) {
            ca.m15831a(th, "MapOverlayImageView", "destroy");
            th.printStackTrace();
            Log.d("amapApi", "MapOverlayImageView clear erro" + th.getMessage());
        }
        return;
    }

    public boolean m14866b(MotionEvent motionEvent) throws RemoteException {
        Iterator it = this.f10939c.iterator();
        while (it.hasNext()) {
            ag agVar = (ag) it.next();
            if ((agVar instanceof az) && agVar.mo3715o()) {
                Rect d = agVar.mo3702d();
                boolean a = m14864a(d, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (a) {
                    this.f10942f = new IPoint(d.left + (d.width() / 2), d.top);
                    this.f10943g = agVar;
                    return a;
                }
            }
        }
        return false;
    }

    public boolean m14864a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public synchronized List<Marker> m14874f() {
        List<Marker> arrayList;
        arrayList = new ArrayList();
        try {
            Rect rect = new Rect(0, 0, this.f10937a.mo3827k(), this.f10937a.mo3829l());
            IPoint iPoint = new IPoint();
            Iterator it = this.f10939c.iterator();
            while (it.hasNext()) {
                ag agVar = (ag) it.next();
                if (!(agVar instanceof bk)) {
                    FPoint f = agVar.mo3706f();
                    if (f != null) {
                        this.f10937a.mo3809c().map2Win(f.f13252x, f.f13253y, iPoint);
                        if (m14864a(rect, iPoint.f13273x, iPoint.f13274y)) {
                            arrayList.add(new Marker(agVar));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ca.m15831a(th, "MapOverlayImageView", "getMapScreenMarkers");
            th.printStackTrace();
        }
        return arrayList;
    }

    public synchronized void m14875g() {
        Iterator it = this.f10939c.iterator();
        while (it.hasNext()) {
            ag agVar = (ag) it.next();
            if (agVar.mo3724x()) {
                agVar.mo3725y();
            }
        }
    }

    protected synchronized void m14876h() {
        this.f10944h.removeCallbacks(this.f10945i);
        this.f10944h.postDelayed(this.f10945i, 10);
    }

    public void m14877i() {
        this.f10946j.post(this.f10947k);
    }
}
