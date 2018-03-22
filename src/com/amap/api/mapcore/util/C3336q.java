package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: TaskManager */
public class C3336q {
    private static C3336q f11825a;
    private du f11826b;
    private LinkedHashMap<String, dv> f11827c = new LinkedHashMap();
    private boolean f11828d = true;

    public static C3336q m16228a(int i) {
        return C3336q.m16229a(true, i);
    }

    private static synchronized C3336q m16229a(boolean z, int i) {
        C3336q c3336q;
        synchronized (C3336q.class) {
            try {
                if (f11825a == null) {
                    f11825a = new C3336q(z, i);
                } else if (z) {
                    if (f11825a.f11826b == null) {
                        f11825a.f11826b = du.m16092a(i);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            c3336q = f11825a;
        }
        return c3336q;
    }

    private C3336q(boolean z, int i) {
        if (z) {
            try {
                this.f11826b = du.m16092a(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void m16230a() {
        synchronized (this.f11827c) {
            if (this.f11827c.size() < 1) {
                return;
            }
            for (Entry entry : this.f11827c.entrySet()) {
                entry.getKey();
                ((C3333m) entry.getValue()).m16214b();
            }
            this.f11827c.clear();
        }
    }

    public void m16231a(C3322p c3322p) {
        synchronized (this.f11827c) {
            C3333m c3333m = (C3333m) this.f11827c.get(c3322p.mo4057b());
            if (c3333m == null) {
                ag.m15456b("stop task,task  is null" + c3322p.mo4057b());
                return;
            }
            c3333m.m16214b();
        }
    }

    public void m16232a(C3322p c3322p, Context context, AMap aMap) throws bl {
        if (this.f11826b == null) {
            ag.m15456b("threadpool is null ");
        }
        if (!this.f11827c.containsKey(c3322p.mo4057b())) {
            C3333m c3333m = new C3333m(c3322p, context.getApplicationContext(), aMap);
            synchronized (this.f11827c) {
                ag.m15456b("tasks put task " + c3322p.mo4057b());
                this.f11827c.put(c3322p.mo4057b(), c3333m);
            }
        }
        this.f11826b.m16099a((dv) this.f11827c.get(c3322p.mo4057b()));
    }

    public void m16233b() {
        m16230a();
        du duVar = this.f11826b;
        du.m16093a();
        this.f11826b = null;
        f11825a = null;
    }

    public void m16234b(C3322p c3322p) {
        C3333m c3333m = (C3333m) this.f11827c.get(c3322p.mo4057b());
        if (c3333m != null) {
            synchronized (this.f11827c) {
                c3333m.m16215c();
                this.f11827c.remove(c3322p.mo4057b());
            }
            ag.m15456b("task finish remove task" + c3322p.mo4057b());
            return;
        }
        ag.m15456b("task finish : by stop  had been removed" + c3322p.mo4057b());
    }
}
