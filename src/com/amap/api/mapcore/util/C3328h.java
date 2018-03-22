package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* compiled from: OfflineDownloadManager */
public class C3328h {
    public static String f11795b = "";
    private static C3328h f11796h;
    CopyOnWriteArrayList<C3323g> f11797a = new CopyOnWriteArrayList();
    C3327b f11798c = null;
    public C3332l f11799d;
    C3334n f11800e;
    C3331k f11801f = null;
    private Context f11802g;
    private C3326a f11803i;
    private C3336q f11804j;
    private C3345z f11805k;
    private ExecutorService f11806l = null;
    private ExecutorService f11807m = null;

    /* compiled from: OfflineDownloadManager */
    public interface C3326a {
        void mo4088a(C3323g c3323g);

        void mo4089b(C3323g c3323g);

        void mo4090c(C3323g c3323g);
    }

    /* compiled from: OfflineDownloadManager */
    class C3327b extends Handler {
        final /* synthetic */ C3328h f11794a;

        public C3327b(C3328h c3328h, Looper looper) {
            this.f11794a = c3328h;
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof C3323g) {
                    C3323g c3323g = (C3323g) obj;
                    ag.m15453a("OfflineMapHandler handleMessage CitObj  name: " + c3323g.getCity() + " complete: " + c3323g.getcompleteCode() + " status: " + c3323g.getState());
                    if (this.f11794a.f11803i != null) {
                        this.f11794a.f11803i.mo4088a(c3323g);
                        return;
                    }
                    return;
                }
                ag.m15453a("Do not callback by CityObject! ");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private C3328h(Context context) {
        this.f11802g = context;
        m16154f();
    }

    public static synchronized C3328h m16149a(Context context) {
        C3328h c3328h;
        synchronized (C3328h.class) {
            if (f11796h == null) {
                f11796h = new C3328h(context.getApplicationContext());
            }
            c3328h = f11796h;
        }
        return c3328h;
    }

    private void m16154f() {
        this.f11805k = C3345z.m16317a(this.f11802g.getApplicationContext());
        this.f11798c = new C3327b(this, this.f11802g.getMainLooper());
        this.f11799d = new C3332l(this.f11802g, this.f11798c);
        this.f11804j = C3336q.m16228a(1);
        m16157g();
        this.f11801f = new C3331k(this.f11802g);
        this.f11801f.start();
        Iterator it = this.f11799d.m16198a().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                this.f11797a.add(new C3323g(this.f11802g, (OfflineMapCity) it2.next()));
            }
        }
        m16159h();
    }

    private void m16157g() {
        if (!bk.m15673b(this.f11802g).equals("")) {
            String c;
            File file = new File(bk.m15673b(this.f11802g) + "offlinemapv4.png");
            if (file.exists()) {
                c = ag.m15459c(file);
            } else {
                c = ag.m15452a(this.f11802g, "offlinemapv4.png");
            }
            if (c != null) {
                try {
                    m16155f(c);
                } catch (Throwable e) {
                    ca.m15831a(e, "MapDownloadManager", "paseJson io");
                    e.printStackTrace();
                }
            }
        }
    }

    private void m16155f(String str) throws JSONException {
        List c = ag.m15460c(str);
        if (c != null && c.size() != 0) {
            this.f11799d.m16200a(c);
        }
    }

    private void m16159h() {
        ag.m15456b("sestUploadlist: ");
        ArrayList a = this.f11805k.m16322a();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            C3337r c3337r = (C3337r) it.next();
            if (!(c3337r == null || c3337r.m16244c() == null || c3337r.m16251f().length() < 1)) {
                ag.m15456b("sestUploadlist: " + c3337r.m16244c() + " > " + c3337r.f11829a + "  list size:" + a.size());
                if (!(c3337r.f11829a == 4 || c3337r.f11829a == 7 || c3337r.f11829a < 0)) {
                    c3337r.f11829a = 3;
                }
                C3323g g = m16156g(c3337r.m16244c());
                if (g == null) {
                    ag.m15456b("getCityObject is null, do not have this city： " + c3337r.m16244c());
                } else {
                    g.m16117a(c3337r.f11829a);
                    g.setCompleteCode(c3337r.m16264o());
                    g.setVersion(c3337r.m16247d());
                    g.setUrl(c3337r.m16253g());
                    this.f11799d.m16199a(g);
                }
            }
        }
    }

    public void m16165a(ArrayList<C3337r> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3337r c3337r = (C3337r) it.next();
            C3323g g = m16156g(c3337r.m16244c());
            if (g != null) {
                bf.m15627a(bf.f11497a, "Update from Verify: " + c3337r.m16244c(), 111);
                g.m16122a(c3337r);
                m16167b(g);
            }
        }
    }

    public void m16164a(final String str) {
        if (str != null) {
            if (this.f11806l == null) {
                this.f11806l = Executors.newSingleThreadExecutor();
            }
            this.f11806l.execute(new Runnable(this) {
                final /* synthetic */ C3328h f11791b;

                public void run() {
                    C3323g a = this.f11791b.m16156g(str);
                    try {
                        if (a.m16125c().equals(a.f11782f)) {
                            String adcode = a.getAdcode();
                            if (adcode.length() > 0) {
                                adcode = this.f11791b.f11805k.m16331e(adcode);
                                if (C3328h.f11795b.length() > 0 && !adcode.equals(C3328h.f11795b)) {
                                    a.m16131i();
                                    this.f11791b.f11803i.mo4089b(a);
                                    return;
                                }
                            }
                            this.f11791b.m16160i();
                            C3329i c3329i = (C3329i) new C3330j(this.f11791b.f11802g, C3328h.f11795b).m15484d();
                            if (this.f11791b.f11803i != null) {
                                if (c3329i == null) {
                                    this.f11791b.f11803i.mo4089b(a);
                                    return;
                                } else if (c3329i.m16179a()) {
                                    this.f11791b.m16161a();
                                }
                            }
                            this.f11791b.f11803i.mo4089b(a);
                        }
                    } catch (Exception e) {
                        bf.m15627a(bf.f11497a, e.getMessage(), 115);
                    } finally {
                        this.f11791b.f11803i.mo4089b(a);
                    }
                }
            });
        } else if (this.f11803i != null) {
            this.f11803i.mo4089b(null);
        }
    }

    private void m16160i() throws AMapException {
        if (!bk.m15679c(this.f11802g)) {
            throw new AMapException("http连接失败 - ConnectionException");
        }
    }

    protected void m16161a() throws AMapException {
        C3335o c3335o = new C3335o(this.f11802g, "");
        c3335o.m16224a(this.f11802g);
        List list = (List) c3335o.m15484d();
        if (list != null) {
            this.f11799d.m16200a(list);
        }
    }

    public boolean m16168b(String str) {
        if (m16156g(str) == null) {
            return false;
        }
        return true;
    }

    public void m16171c(String str) {
        final C3323g g = m16156g(str);
        if (g != null) {
            if (this.f11800e == null) {
                this.f11800e = new C3334n(this.f11802g);
            }
            if (this.f11807m == null) {
                this.f11807m = Executors.newSingleThreadExecutor();
            }
            this.f11807m.execute(new Runnable(this) {
                final /* synthetic */ C3328h f11793b;

                public void run() {
                    if (g.m16125c().equals(g.f11777a)) {
                        this.f11793b.f11803i.mo4090c(g);
                    } else {
                        this.f11793b.f11800e.m16219a(g);
                    }
                }
            });
        } else if (this.f11803i != null) {
            this.f11803i.mo4090c(g);
        }
    }

    public void m16162a(C3323g c3323g) {
        try {
            this.f11804j.m16232a(c3323g, this.f11802g, null);
        } catch (bl e) {
            e.printStackTrace();
        }
    }

    public void m16167b(C3323g c3323g) {
        this.f11799d.m16199a(c3323g);
        Message obtainMessage = this.f11798c.obtainMessage();
        obtainMessage.obj = c3323g;
        this.f11798c.sendMessage(obtainMessage);
    }

    public void m16166b() {
        Iterator it = this.f11797a.iterator();
        while (it.hasNext()) {
            C3323g c3323g = (C3323g) it.next();
            if (c3323g.m16125c().equals(c3323g.f11779c) || c3323g.m16125c().equals(c3323g.f11778b)) {
                c3323g.m16128f();
            }
        }
    }

    public void m16169c() {
        Iterator it = this.f11797a.iterator();
        while (it.hasNext()) {
            C3323g c3323g = (C3323g) it.next();
            if (c3323g.m16125c().equals(c3323g.f11779c)) {
                c3323g.m16128f();
                return;
            }
        }
    }

    public void m16172d() {
        if (!(this.f11806l == null || this.f11806l.isShutdown())) {
            this.f11806l.shutdownNow();
        }
        if (this.f11801f != null) {
            if (this.f11801f.isAlive()) {
                this.f11801f.interrupt();
            }
            this.f11801f = null;
        }
        this.f11804j.m16233b();
        this.f11799d.m16209g();
        m16175e();
        f11796h = null;
    }

    private C3323g m16156g(String str) {
        Iterator it = this.f11797a.iterator();
        while (it.hasNext()) {
            C3323g c3323g = (C3323g) it.next();
            if (str.equals(c3323g.getCity())) {
                return c3323g;
            }
        }
        return null;
    }

    private C3323g m16158h(String str) {
        Iterator it = this.f11797a.iterator();
        while (it.hasNext()) {
            C3323g c3323g = (C3323g) it.next();
            if (str.equals(c3323g.getCode())) {
                return c3323g;
            }
        }
        return null;
    }

    public void m16174d(String str) {
        C3323g g = m16156g(str);
        if (g != null) {
            g.m16128f();
        } else {
            ag.m15456b("getCityObject is null, do not have this city： " + str);
        }
    }

    public void m16176e(String str) {
        C3323g h = m16158h(str);
        if (h != null) {
            h.m16128f();
        } else {
            ag.m15456b("getCityObject is null, do not have this city： " + str);
        }
    }

    public void m16170c(C3323g c3323g) {
        this.f11804j.m16231a((C3322p) c3323g);
    }

    public void m16173d(C3323g c3323g) {
        this.f11804j.m16234b(c3323g);
    }

    public void m16163a(C3326a c3326a) {
        this.f11803i = c3326a;
    }

    public void m16175e() {
        this.f11803i = null;
    }
}
