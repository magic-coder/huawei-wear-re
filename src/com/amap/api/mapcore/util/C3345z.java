package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OfflineDBOperation */
public class C3345z {
    private static C3345z f11882a;
    private static co f11883b;
    private Context f11884c;

    public static C3345z m16317a(Context context) {
        if (f11882a == null) {
            f11882a = new C3345z(context);
        }
        return f11882a;
    }

    private C3345z(Context context) {
        this.f11884c = context;
        f11883b = m16320b(this.f11884c);
    }

    private co m16320b(Context context) {
        try {
            return new co(context, C3344y.m16312a());
        } catch (Throwable th) {
            ca.m15831a(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean m16321b() {
        if (f11883b == null) {
            f11883b = m16320b(this.f11884c);
        }
        if (f11883b == null) {
            return false;
        }
        return true;
    }

    public ArrayList<C3337r> m16322a() {
        ArrayList<C3337r> arrayList = new ArrayList();
        if (!m16321b()) {
            return arrayList;
        }
        for (C3343x a : f11883b.m15927c("", new C3340u())) {
            arrayList.add(a.m16298a());
        }
        return arrayList;
    }

    public synchronized void m16324a(C3337r c3337r) {
        if (m16321b()) {
            cp c3340u = new C3340u();
            c3340u.mo4031a(new C3343x(c3337r));
            f11883b.m15920a(c3340u, C3340u.m16281a(c3337r.m16251f()));
            m16319a(c3337r.m16251f(), c3337r.m16261l());
        }
    }

    private void m16319a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            String a = C3341v.m16288a(str);
            if (f11883b.m15927c(a, new C3341v()).size() > 0) {
                f11883b.m15922a(a, new C3341v());
            }
            String[] split = str2.split(";");
            List arrayList = new ArrayList();
            for (String str3 : split) {
                cp c3341v = new C3341v();
                c3341v.mo4031a(new C3342w(str, str3));
                arrayList.add(c3341v);
            }
            f11883b.m15924a(arrayList);
        }
    }

    public synchronized List<String> m16323a(String str) {
        List arrayList;
        arrayList = new ArrayList();
        if (m16321b()) {
            arrayList.addAll(m16318a(f11883b.m15927c(C3341v.m16288a(str), new C3341v())));
        }
        return arrayList;
    }

    public synchronized List<String> m16328b(String str) {
        List arrayList;
        arrayList = new ArrayList();
        if (m16321b()) {
            arrayList.addAll(m16318a(f11883b.m15927c(C3341v.m16289b(str), new C3341v())));
        }
        return arrayList;
    }

    private List<String> m16318a(List<C3342w> list) {
        List<String> arrayList = new ArrayList();
        if (list.size() > 0) {
            for (C3342w b : list) {
                arrayList.add(b.m16297b());
            }
        }
        return arrayList;
    }

    public synchronized void m16329c(String str) {
        if (m16321b()) {
            f11883b.m15922a(C3340u.m16281a(str), new C3340u());
            f11883b.m15922a(C3341v.m16288a(str), new C3341v());
            f11883b.m15922a(C3338s.m16267a(str), new C3338s());
        }
    }

    public void m16325a(String str, int i, long j, long j2, long j3) {
        if (m16321b()) {
            m16326a(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    public synchronized void m16326a(String str, int i, long j, long[] jArr, long[] jArr2) {
        if (m16321b()) {
            cp c3338s = new C3338s();
            c3338s.mo4031a(new C3339t(str, j, i, jArr[0], jArr2[0]));
            f11883b.m15920a(c3338s, C3338s.m16267a(str));
        }
    }

    public synchronized long[] m16327a(String str, int i) {
        long[] jArr;
        if (m16321b()) {
            long a;
            long b;
            cp c3338s = new C3338s();
            List c = f11883b.m15927c(C3338s.m16267a(str), c3338s);
            if (c.size() > 0) {
                a = ((C3339t) c.get(0)).m16274a(i);
                b = ((C3339t) c.get(0)).m16277b(i);
            } else {
                b = 0;
                a = 0;
            }
            jArr = new long[]{a, b};
        } else {
            jArr = new long[]{0, 0};
        }
        return jArr;
    }

    public synchronized int m16330d(String str) {
        int i = 0;
        synchronized (this) {
            if (m16321b()) {
                cp c3338s = new C3338s();
                List c = f11883b.m15927c(C3338s.m16267a(str), c3338s);
                long j = 0;
                if (c.size() > 0) {
                    j = ((C3339t) c.get(0)).m16276b();
                }
                i = (int) j;
            }
        }
        return i;
    }

    public synchronized String m16331e(String str) {
        String str2;
        str2 = null;
        if (m16321b()) {
            cp c3340u = new C3340u();
            List c = f11883b.m15927c(C3340u.m16281a(str), c3340u);
            if (c.size() > 0) {
                str2 = ((C3343x) c.get(0)).m16303f();
            }
        }
        return str2;
    }

    public synchronized boolean m16332f(String str) {
        boolean z = false;
        synchronized (this) {
            if (m16321b()) {
                cp c3338s = new C3338s();
                if (f11883b.m15927c(C3340u.m16281a(str), c3338s).size() > 0) {
                    z = true;
                }
            }
        }
        return z;
    }
}
