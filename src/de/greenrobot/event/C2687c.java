package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: EventBus */
public class C2687c {
    static ExecutorService f9115a = Executors.newCachedThreadPool();
    public static String f9116b = "Event";
    private static volatile C2687c f9117c;
    private static final Map<Class<?>, List<Class<?>>> f9118d = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<C2699o>> f9119e = new HashMap();
    private final Map<Object, List<Class<?>>> f9120f = new HashMap();
    private final Map<Class<?>, Object> f9121g = new ConcurrentHashMap();
    private final ThreadLocal<List<Object>> f9122h = new C2688d(this);
    private final ThreadLocal<C2691g> f9123i = new C2689e(this);
    private String f9124j = "onEvent";
    private final HandlerPoster f9125k = new HandlerPoster(this, Looper.getMainLooper(), 10);
    private final C2686b f9126l = new C2686b(this);
    private final C2685a f9127m = new C2685a(this);
    private final C2698n f9128n = new C2698n();
    private boolean f9129o;
    private boolean f9130p = true;

    public static C2687c m12831a() {
        if (f9117c == null) {
            synchronized (C2687c.class) {
                if (f9117c == null) {
                    f9117c = new C2687c();
                }
            }
        }
        return f9117c;
    }

    public void m12841a(Object obj) {
        m12836a(obj, this.f9124j, false);
    }

    private void m12836a(Object obj, String str, boolean z) {
        for (C2697m a : this.f9128n.m12852a(obj.getClass(), str)) {
            m12834a(obj, a, z);
        }
    }

    private void m12834a(Object obj, C2697m c2697m, boolean z) {
        this.f9129o = true;
        Class cls = c2697m.f9149c;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9119e.get(cls);
        C2699o c2699o = new C2699o(obj, c2697m);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f9119e.put(cls, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((C2699o) it.next()).equals(c2699o)) {
                    throw new C2692h("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        c2697m.f9147a.setAccessible(true);
        copyOnWriteArrayList.add(c2699o);
        List list = (List) this.f9120f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f9120f.put(obj, list);
        }
        list.add(cls);
        if (z) {
            Object obj2;
            synchronized (this.f9121g) {
                obj2 = this.f9121g.get(cls);
            }
            if (obj2 != null) {
                m12833a(c2699o, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void m12835a(Object obj, Class<?> cls) {
        List list = (List) this.f9119e.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2;
                C2699o c2699o = (C2699o) list.get(i);
                if (c2699o.f9153a == obj) {
                    c2699o.f9155c = false;
                    list.remove(i);
                    i2 = i - 1;
                    i = size - 1;
                } else {
                    i2 = i;
                    i = size;
                }
                size = i;
                i = i2 + 1;
            }
        }
    }

    public synchronized void m12842b(Object obj) {
        List<Class> list = (List) this.f9120f.get(obj);
        if (list != null) {
            for (Class a : list) {
                m12835a(obj, a);
            }
            this.f9120f.remove(obj);
        } else {
            Log.w(f9116b, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void m12843c(Object obj) {
        List list = (List) this.f9122h.get();
        list.add(obj);
        C2691g c2691g = (C2691g) this.f9123i.get();
        if (!c2691g.f9134a) {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            c2691g.f9134a = true;
            while (!list.isEmpty()) {
                try {
                    m12837a(list.remove(0), z);
                } finally {
                    c2691g.f9134a = false;
                }
            }
        }
    }

    private void m12837a(Object obj, boolean z) throws Error {
        Class cls = obj.getClass();
        List a = m12832a(cls);
        int size = a.size();
        int i = 0;
        Object obj2 = null;
        while (i < size) {
            Object obj3;
            Class cls2 = (Class) a.get(i);
            synchronized (this) {
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9119e.get(cls2);
            }
            if (copyOnWriteArrayList != null) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    m12833a((C2699o) it.next(), obj, z);
                }
                obj3 = 1;
            } else {
                obj3 = obj2;
            }
            i++;
            obj2 = obj3;
        }
        if (obj2 == null) {
            Log.d(f9116b, "No subscribers registered for event " + cls);
            if (cls != C2693i.class && cls != C2696l.class) {
                m12843c(new C2693i(this, obj));
            }
        }
    }

    private void m12833a(C2699o c2699o, Object obj, boolean z) {
        switch (C2690f.f9133a[c2699o.f9154b.f9148b.ordinal()]) {
            case 1:
                m12840a(c2699o, obj);
                return;
            case 2:
                if (z) {
                    m12840a(c2699o, obj);
                    return;
                } else {
                    this.f9125k.m12828a(c2699o, obj);
                    return;
                }
            case 3:
                if (z) {
                    this.f9126l.m12830a(c2699o, obj);
                    return;
                } else {
                    m12840a(c2699o, obj);
                    return;
                }
            case 4:
                this.f9127m.m12829a(c2699o, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + c2699o.f9154b.f9148b);
        }
    }

    private List<Class<?>> m12832a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f9118d) {
            list = (List) f9118d.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    C2687c.m12838a((List) list, cls2.getInterfaces());
                }
                f9118d.put(cls, list);
            }
        }
        return list;
    }

    static void m12838a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                C2687c.m12838a((List) list, cls.getInterfaces());
            }
        }
    }

    void m12839a(C2694j c2694j) {
        Object obj = c2694j.f9138a;
        C2699o c2699o = c2694j.f9139b;
        C2694j.m12847a(c2694j);
        if (c2699o.f9155c) {
            m12840a(c2699o, obj);
        }
    }

    void m12840a(C2699o c2699o, Object obj) throws Error {
        Throwable cause;
        try {
            c2699o.f9154b.f9147a.invoke(c2699o.f9153a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            cause = e.getCause();
            if (obj instanceof C2696l) {
                Log.e(f9116b, "SubscriberExceptionEvent subscriber " + c2699o.f9153a.getClass() + " threw an exception", cause);
                C2696l c2696l = (C2696l) obj;
                Log.e(f9116b, "Initial event " + c2696l.f9145c + " caused exception in " + c2696l.f9146d, c2696l.f9144b);
                return;
            }
            if (this.f9130p) {
                Log.e(f9116b, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + c2699o.f9153a.getClass(), cause);
            }
            m12843c(new C2696l(this, cause, obj, c2699o.f9153a));
        } catch (Throwable cause2) {
            throw new IllegalStateException("Unexpected exception", cause2);
        }
    }
}
