package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.C3192d;
import com.aps.bf;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: AMapLocationManager */
public class C3184a {
    static C3184a f10634j = null;
    Vector<C3201i> f10635a = null;
    C3196d f10636b = null;
    C3188c f10637c = null;
    boolean f10638d = false;
    long f10639e;
    boolean f10640f = true;
    boolean f10641g = true;
    C3187b f10642h;
    long f10643i;
    private Context f10644k;
    private C3183a f10645l = null;
    private Vector<C3201i> f10646m = new Vector();
    private AMapLocation f10647n;
    private AMapLocation f10648o;
    private volatile Thread f10649p;
    private long f10650q = 2000;
    private float f10651r = 10.0f;

    /* compiled from: AMapLocationManager */
    class C3183a extends Handler {
        final /* synthetic */ C3184a f10633a;

        public C3183a(C3184a c3184a, Looper looper) {
            this.f10633a = c3184a;
            super(looper);
            Looper.prepare();
        }

        public C3183a(C3184a c3184a) {
            this.f10633a = c3184a;
        }

        public void handleMessage(Message message) {
            if (message != null) {
                if (message.what == 100 && this.f10633a.f10635a != null) {
                    try {
                        this.f10633a.f10647n = (AMapLocation) message.obj;
                        if (!(this.f10633a.f10647n == null || this.f10633a.f10647n.getAdCode() == null || this.f10633a.f10647n.getAdCode().length() <= 0)) {
                            this.f10633a.f10648o = this.f10633a.f10647n;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        return;
                    }
                    Iterator it = this.f10633a.f10635a.iterator();
                    while (it.hasNext()) {
                        C3201i c3201i = (C3201i) it.next();
                        if (c3201i.f10725b != null) {
                            AMapLocation aMapLocation = (AMapLocation) message.obj;
                            if (c3201i.f10726c.booleanValue() || aMapLocation.getAMapException().getErrorCode() == 0) {
                                try {
                                    c3201i.f10725b.onLocationChanged(aMapLocation);
                                } catch (Throwable th2) {
                                }
                            }
                        }
                        if (c3201i.f10726c.booleanValue() && c3201i.f10724a == -1 && this.f10633a.f10646m != null) {
                            this.f10633a.f10646m.add(c3201i);
                        }
                    }
                    if (this.f10633a.f10646m != null && this.f10633a.f10646m.size() > 0) {
                        for (int i = 0; i < this.f10633a.f10646m.size(); i++) {
                            this.f10633a.m14076a(((C3201i) this.f10633a.f10646m.get(i)).f10725b);
                        }
                        this.f10633a.f10646m.clear();
                    }
                    if (this.f10633a.f10647n != null) {
                        C3192d.m14141a(this.f10633a.f10644k, this.f10633a.f10647n);
                    }
                }
            }
        }
    }

    public static synchronized C3184a m14062a(Context context, LocationManager locationManager) {
        C3184a c3184a;
        synchronized (C3184a.class) {
            if (f10634j == null) {
                f10634j = new C3184a(context, locationManager);
            }
            c3184a = f10634j;
        }
        return c3184a;
    }

    private C3184a(Context context, LocationManager locationManager) {
        this.f10644k = context;
        m14070e();
        if (Looper.myLooper() == null) {
            this.f10645l = new C3183a(this, context.getMainLooper());
        } else {
            this.f10645l = new C3183a(this);
        }
        this.f10636b = new C3196d(context, locationManager, this.f10645l, this);
        this.f10637c = new C3188c(context, this.f10645l, this);
        m14081b(false);
        this.f10640f = true;
        this.f10641g = true;
        this.f10642h = new C3187b(this, context);
    }

    private void m14070e() {
        this.f10635a = new Vector();
    }

    void m14072a(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        bf bfVar = new bf();
        bfVar.f13019b = d;
        bfVar.f13018a = d2;
        bfVar.f13020c = f;
        bfVar.m17406a(j);
        this.f10637c.m14097a(bfVar, pendingIntent);
    }

    void m14079b(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        bf bfVar = new bf();
        bfVar.f13019b = d;
        bfVar.f13018a = d2;
        bfVar.f13020c = f;
        bfVar.m17406a(j);
        this.f10637c.m14102b(bfVar, pendingIntent);
    }

    void m14075a(PendingIntent pendingIntent) {
        this.f10637c.m14096a(pendingIntent);
    }

    void m14080b(PendingIntent pendingIntent) {
        this.f10637c.m14101b(pendingIntent);
    }

    AMapLocation m14071a() {
        if (this.f10647n != null) {
            return this.f10647n;
        }
        return C3192d.m14145b(this.f10644k);
    }

    void m14074a(long j, float f, AMapLocationListener aMapLocationListener, String str, boolean z) {
        this.f10650q = j;
        this.f10651r = f;
        if (aMapLocationListener != null) {
            C3201i c3201i = new C3201i(j, f, aMapLocationListener, str, z);
            if (!this.f10635a.contains(c3201i)) {
                this.f10635a.add(c3201i);
            }
            if ("gps".equals(str)) {
                this.f10636b.m14171a(j, f);
            } else if (LocationProviderProxy.AMapNetwork.equals(str)) {
                if (this.f10641g) {
                    this.f10636b.m14171a(j, f);
                }
                this.f10637c.m14095a(j);
                m14067c(true);
                if (this.f10649p == null) {
                    this.f10637c.m14103b(true);
                    this.f10649p = new Thread(this.f10637c);
                    this.f10649p.start();
                }
            }
        }
    }

    private void m14067c(boolean z) {
        this.f10640f = z;
    }

    void m14076a(AMapLocationListener aMapLocationListener) {
        int size;
        if (this.f10635a != null) {
            size = this.f10635a.size();
        } else {
            size = 0;
        }
        int i = 0;
        int i2 = size;
        while (i < i2) {
            C3201i c3201i = (C3201i) this.f10635a.get(i);
            if (c3201i == null) {
                this.f10635a.remove(i);
                size = i - 1;
                i = i2 - 1;
            } else if (c3201i.f10725b == null || aMapLocationListener.equals(c3201i.f10725b)) {
                this.f10635a.remove(c3201i);
                size = i - 1;
                i = i2 - 1;
            } else {
                size = i;
                i = i2;
            }
            i2 = i;
            i = size + 1;
        }
        if (this.f10635a == null || this.f10635a.size() == 0) {
            m14081b(false);
            m14067c(false);
            m14078b();
            if (this.f10636b != null) {
                this.f10636b.m14172b();
            }
        }
    }

    void m14078b() {
        if (this.f10637c != null) {
            this.f10637c.m14103b(false);
        }
        if (this.f10649p != null) {
            this.f10649p.interrupt();
            this.f10649p = null;
        }
    }

    void m14077a(boolean z) {
        m14069d(z);
        if (this.f10635a != null && this.f10635a.size() > 0) {
            if (z) {
                this.f10636b.m14172b();
                this.f10636b.m14171a(this.f10650q, this.f10651r);
                return;
            }
            this.f10636b.m14172b();
        }
    }

    private void m14069d(boolean z) {
        this.f10641g = z;
    }

    static synchronized void m14066c() {
        synchronized (C3184a.class) {
            if (f10634j != null) {
                f10634j.m14082d();
            }
            f10634j = null;
        }
    }

    void m14082d() {
        if (this.f10636b != null) {
            this.f10636b.m14172b();
            this.f10636b.m14170a();
            this.f10636b = null;
        }
        if (this.f10637c != null) {
            this.f10637c.m14100b();
        }
        if (this.f10635a != null) {
            this.f10635a.clear();
        }
        m14081b(false);
    }

    void m14081b(boolean z) {
        this.f10638d = z;
    }

    void m14073a(final int i, final AMapLocalWeatherListener aMapLocalWeatherListener) {
        try {
            new Thread(this) {
                final /* synthetic */ C3184a f10632c;

                public void run() {
                    this.f10632c.f10642h.m14088a(i, aMapLocalWeatherListener, this.f10632c.f10648o);
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
