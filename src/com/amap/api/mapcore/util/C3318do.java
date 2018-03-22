package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Proxy;

/* compiled from: NetManger */
public class C3318do extends dk {
    private static C3318do f11738a;
    private du f11739b;
    private Handler f11740c;

    /* compiled from: NetManger */
    class C33161 extends dv {
        final /* synthetic */ dp f11735a;
        final /* synthetic */ dq f11736b;
        final /* synthetic */ C3318do f11737c;

        public void mo4042a() {
            try {
                this.f11737c.m16085a(this.f11737c.m16086b(this.f11735a, false), this.f11736b);
            } catch (bl e) {
                this.f11737c.m16082a(e, this.f11736b);
            }
        }
    }

    /* compiled from: NetManger */
    class C3317a extends Handler {
        private C3317a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((dt) message.obj).f11745b.m16089a();
                        return;
                    case 1:
                        dt dtVar = (dt) message.obj;
                        dtVar.f11745b.m16090a(dtVar.f11744a);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    public static C3318do m16080a(boolean z) {
        return C3318do.m16081a(z, 5);
    }

    private static synchronized C3318do m16081a(boolean z, int i) {
        C3318do c3318do;
        synchronized (C3318do.class) {
            try {
                if (f11738a == null) {
                    f11738a = new C3318do(z, i);
                } else if (z) {
                    if (f11738a.f11739b == null) {
                        f11738a.f11739b = du.m16092a(i);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            c3318do = f11738a;
        }
        return c3318do;
    }

    private C3318do(boolean z, int i) {
        if (z) {
            try {
                this.f11739b = du.m16092a(i);
            } catch (Throwable th) {
                ca.m15831a(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f11740c = new C3317a(Looper.getMainLooper());
        } else {
            this.f11740c = new C3317a();
        }
    }

    public byte[] mo4043b(dp dpVar) throws bl {
        bl e;
        try {
            dr a = m16060a(dpVar, false);
            if (a != null) {
                return a.f11741a;
            }
            return null;
        } catch (bl e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            ca.m15832b().m15837b(th, "NetManager", "makeSyncPostRequest");
            e2 = new bl("未知的错误");
        }
    }

    public byte[] m16088d(dp dpVar) throws bl {
        bl e;
        try {
            dr b = m16086b(dpVar, false);
            if (b != null) {
                return b.f11741a;
            }
            return null;
        } catch (bl e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new bl("未知的错误");
        }
    }

    public dr m16086b(dp dpVar, boolean z) throws bl {
        bl e;
        try {
            Proxy proxy;
            m16063c(dpVar);
            if (dpVar.f11413i == null) {
                proxy = null;
            } else {
                proxy = dpVar.f11413i;
            }
            return new dm(dpVar.f11411g, dpVar.f11412h, proxy, z).m16070a(dpVar.mo4002a(), dpVar.mo4004c(), dpVar.mo4003b());
        } catch (bl e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new bl("未知的错误");
        }
    }

    private void m16082a(bl blVar, dq dqVar) {
        dt dtVar = new dt();
        dtVar.f11744a = blVar;
        dtVar.f11745b = dqVar;
        Message obtain = Message.obtain();
        obtain.obj = dtVar;
        obtain.what = 1;
        this.f11740c.sendMessage(obtain);
    }

    private void m16085a(dr drVar, dq dqVar) {
        dqVar.m16091a(drVar.f11742b, drVar.f11741a);
        dt dtVar = new dt();
        dtVar.f11745b = dqVar;
        Message obtain = Message.obtain();
        obtain.obj = dtVar;
        obtain.what = 0;
        this.f11740c.sendMessage(obtain);
    }
}
