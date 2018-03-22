package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost */
final class C2694j {
    private static final List<C2694j> f9137d = new ArrayList();
    Object f9138a;
    C2699o f9139b;
    C2694j f9140c;

    private C2694j(Object obj, C2699o c2699o) {
        this.f9138a = obj;
        this.f9139b = c2699o;
    }

    static C2694j m12846a(C2699o c2699o, Object obj) {
        synchronized (f9137d) {
            int size = f9137d.size();
            if (size > 0) {
                C2694j c2694j = (C2694j) f9137d.remove(size - 1);
                c2694j.f9138a = obj;
                c2694j.f9139b = c2699o;
                c2694j.f9140c = null;
                return c2694j;
            }
            return new C2694j(obj, c2699o);
        }
    }

    static void m12847a(C2694j c2694j) {
        c2694j.f9138a = null;
        c2694j.f9139b = null;
        c2694j.f9140c = null;
        synchronized (f9137d) {
            if (f9137d.size() < 10000) {
                f9137d.add(c2694j);
            }
        }
    }
}
