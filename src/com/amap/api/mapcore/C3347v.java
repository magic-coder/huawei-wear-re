package com.amap.api.mapcore;

import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.LatLng;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLOverlayLayer */
class C3347v {
    private static int f11885c = 0;
    aa f11886a;
    C3346a f11887b = new C3346a();
    private CopyOnWriteArrayList<ai> f11888d = new CopyOnWriteArrayList(new ArrayList(500));
    private CopyOnWriteArrayList<Integer> f11889e = new CopyOnWriteArrayList();
    private Handler f11890f = new Handler();
    private Runnable f11891g = new C3348w(this);

    /* compiled from: GLOverlayLayer */
    class C3346a implements Serializable, Comparator<Object> {
        C3346a() {
        }

        public int compare(Object obj, Object obj2) {
            ai aiVar = (ai) obj;
            ai aiVar2 = (ai) obj2;
            if (!(aiVar == null || aiVar2 == null)) {
                try {
                    if (aiVar.mo3884d() > aiVar2.mo3884d()) {
                        return 1;
                    }
                    if (aiVar.mo3884d() < aiVar2.mo3884d()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "GLOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    static String m16333a(String str) {
        f11885c++;
        return str + f11885c;
    }

    public C3347v(aa aaVar) {
        this.f11886a = aaVar;
    }

    public synchronized void m16343b(String str) {
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    Iterator it = this.f11888d.iterator();
                    while (it.hasNext()) {
                        ai aiVar = (ai) it.next();
                        if (!str.equals(aiVar.mo3883c())) {
                            this.f11888d.remove(aiVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ca.m15831a(th, "GLOverlayLayer", "clear");
                th.printStackTrace();
                Log.d("amapApi", "GLOverlayLayer clear erro" + th.getMessage());
            }
        }
        this.f11888d.clear();
        f11885c = 0;
    }

    public synchronized void m16338a() {
        try {
            Iterator it = this.f11888d.iterator();
            while (it.hasNext()) {
                ((ai) it.next()).mo3890j();
            }
            m16343b(null);
        } catch (Throwable th) {
            ca.m15831a(th, "GLOverlayLayer", "destory");
            th.printStackTrace();
            Log.d("amapApi", "GLOverlayLayer destory erro" + th.getMessage());
        }
        return;
    }

    private synchronized ai m16336d(String str) throws RemoteException {
        ai aiVar;
        Iterator it = this.f11888d.iterator();
        while (it.hasNext()) {
            aiVar = (ai) it.next();
            if (aiVar != null && aiVar.mo3883c().equals(str)) {
                break;
            }
        }
        aiVar = null;
        return aiVar;
    }

    public synchronized void m16339a(ai aiVar) throws RemoteException {
        this.f11888d.add(aiVar);
        m16342b();
    }

    public synchronized boolean m16345c(String str) throws RemoteException {
        boolean remove;
        ai d = m16336d(str);
        if (d != null) {
            remove = this.f11888d.remove(d);
        } else {
            remove = false;
        }
        return remove;
    }

    protected synchronized void m16342b() {
        this.f11890f.removeCallbacks(this.f11891g);
        this.f11890f.postDelayed(this.f11891g, 10);
    }

    public void m16341a(GL10 gl10, boolean z, int i) {
        Iterator it = this.f11889e.iterator();
        while (it.hasNext()) {
            gl10.glDeleteTextures(1, new int[]{((Integer) it.next()).intValue()}, 0);
            this.f11886a.mo3818f(r0.intValue());
        }
        this.f11889e.clear();
        int size = this.f11888d.size();
        Iterator it2 = this.f11888d.iterator();
        while (it2.hasNext()) {
            ai aiVar = (ai) it2.next();
            try {
                if (aiVar.mo3885e()) {
                    if (size > 20) {
                        if (aiVar.mo3878a()) {
                            if (z) {
                                if (aiVar.mo3884d() <= ((float) i)) {
                                    aiVar.mo3876a(gl10);
                                }
                            } else if (aiVar.mo3884d() > ((float) i)) {
                                aiVar.mo3876a(gl10);
                            }
                        }
                    } else if (z) {
                        if (aiVar.mo3884d() <= ((float) i)) {
                            aiVar.mo3876a(gl10);
                        }
                    } else if (aiVar.mo3884d() > ((float) i)) {
                        aiVar.mo3876a(gl10);
                    }
                }
            } catch (Throwable e) {
                ca.m15831a(e, "GLOverlayLayer", "draw");
                e.printStackTrace();
            }
        }
    }

    public void m16340a(Integer num) {
        if (num.intValue() != 0) {
            this.f11889e.add(num);
        }
    }

    public synchronized void m16344c() {
        Iterator it = this.f11888d.iterator();
        while (it.hasNext()) {
            ai aiVar = (ai) it.next();
            if (aiVar != null) {
                try {
                    aiVar.mo3887g();
                } catch (Throwable e) {
                    ca.m15831a(e, "GLOverlayLayer", "calMapFPoint");
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean m16346d() {
        Iterator it = this.f11888d.iterator();
        while (it.hasNext()) {
            ai aiVar = (ai) it.next();
            if (aiVar != null && !aiVar.mo3891k()) {
                return false;
            }
        }
        return true;
    }

    public synchronized ai m16337a(LatLng latLng) {
        ai aiVar;
        Iterator it = this.f11888d.iterator();
        while (it.hasNext()) {
            aiVar = (ai) it.next();
            if (aiVar != null && aiVar.mo3891k() && (aiVar instanceof ak) && ((ak) aiVar).mo3908b(latLng)) {
                break;
            }
        }
        aiVar = null;
        return aiVar;
    }
}
