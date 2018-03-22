package com.amap.api.mapcore;

import com.amap.api.mapcore.util.ca;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: CustomGLOverlayLayer */
class C3266s {
    C3265a f11371a = new C3265a();
    private CopyOnWriteArrayList<C3268u> f11372b = new CopyOnWriteArrayList();

    /* compiled from: CustomGLOverlayLayer */
    class C3265a implements Serializable, Comparator<Object> {
        C3265a() {
        }

        public int compare(Object obj, Object obj2) {
            C3268u c3268u = (C3268u) obj;
            C3268u c3268u2 = (C3268u) obj2;
            if (!(c3268u == null || c3268u2 == null)) {
                try {
                    if (c3268u.getZIndex() > c3268u2.getZIndex()) {
                        return 1;
                    }
                    if (c3268u.getZIndex() < c3268u2.getZIndex()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "CustomGLOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    C3266s() {
    }

    public boolean m15371a(C3268u c3268u) {
        if (this.f11372b.contains(c3268u)) {
            return this.f11372b.remove(c3268u);
        }
        return false;
    }

    public void m15370a(GL10 gl10) {
        Iterator it = this.f11372b.iterator();
        while (it.hasNext()) {
            ((C3268u) it.next()).onDrawFrame(gl10);
        }
    }
}
