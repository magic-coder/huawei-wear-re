package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import java.util.Iterator;
import java.util.WeakHashMap;

/* compiled from: BitmapManager */
public class C1540a {
    private static C1540a f3691b = null;
    private final WeakHashMap<Thread, C1544e> f3692a = new WeakHashMap();

    private C1540a() {
    }

    private C1544e m7129b(Thread thread) {
        C1544e c1544e;
        synchronized (this) {
            c1544e = (C1544e) this.f3692a.get(thread);
            if (c1544e == null) {
                c1544e = new C1544e();
                this.f3692a.put(thread, c1544e);
            }
        }
        return c1544e;
    }

    public void m7130a(C1543d c1543d) {
        synchronized (this) {
            Iterator it = c1543d.iterator();
            while (it.hasNext()) {
                m7131a((Thread) it.next());
            }
        }
    }

    public void m7131a(Thread thread) {
        synchronized (this) {
            C1544e b = m7129b(thread);
            b.f3698a = C1542c.CANCEL;
            if (b.f3699b != null) {
                b.f3699b.requestCancelDecode();
            }
            notifyAll();
        }
    }

    public static C1540a m7128a() {
        C1540a c1540a;
        synchronized (C1540a.class) {
            if (f3691b == null) {
                f3691b = new C1540a();
            }
            c1540a = f3691b;
        }
        return c1540a;
    }
}
