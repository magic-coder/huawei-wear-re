package com.amap.api.services.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import org.apache.http.HttpEntity;

/* compiled from: NetManger */
public class bs {
    private static bs f12473a;
    private av f12474b;
    private Handler f12475c;

    /* compiled from: NetManger */
    class C34061 extends ax {
        final /* synthetic */ bt f12470b;
        final /* synthetic */ bu f12471c;
        final /* synthetic */ bs f12472d;

        public void mo4122a() {
            try {
                this.f12472d.m16864a(this.f12472d.m16866b(this.f12470b, false), this.f12471c);
            } catch (C3433v e) {
                this.f12472d.m16865a(e, this.f12471c);
            }
        }
    }

    /* compiled from: NetManger */
    class C3407a extends Handler {
        private C3407a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((bx) message.obj).f12479b.m16870a();
                        return;
                    case 1:
                        bx bxVar = (bx) message.obj;
                        bxVar.f12479b.m16871a(bxVar.f12478a);
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

    public static bs m16858a(boolean z) {
        return m16859a(z, 5);
    }

    private static synchronized bs m16859a(boolean z, int i) {
        bs bsVar;
        synchronized (bs.class) {
            try {
                if (f12473a == null) {
                    f12473a = new bs(z, i);
                } else if (z) {
                    if (f12473a.f12474b == null) {
                        f12473a.f12474b = av.m16694a(i);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            bsVar = f12473a;
        }
        return bsVar;
    }

    private bs(boolean z, int i) {
        if (z) {
            try {
                this.f12474b = av.m16694a(i);
            } catch (Throwable th) {
                ay.m16709a(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f12475c = new C3407a(Looper.getMainLooper());
        } else {
            this.f12475c = new C3407a();
        }
    }

    public byte[] m16868a(bt btVar) throws C3433v {
        C3433v e;
        try {
            bv a = m16861a(btVar, false);
            if (a != null) {
                return a.f12476a;
            }
            return null;
        } catch (C3433v e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new C3433v("未知的错误");
        }
    }

    public byte[] m16869b(bt btVar) throws C3433v {
        C3433v e;
        try {
            bv a = m16861a(btVar, true);
            if (a != null) {
                return a.f12476a;
            }
            return null;
        } catch (C3433v e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new C3433v("未知的错误");
        }
    }

    private bv m16861a(bt btVar, boolean z) throws C3433v {
        C3433v e;
        HttpEntity e2 = btVar.mo4099e();
        byte[] e_ = btVar.e_();
        try {
            Proxy proxy;
            m16867c(btVar);
            if (btVar.f12300g == null) {
                proxy = null;
            } else {
                proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(btVar.f12300g.getHostName(), btVar.f12300g.getPort()));
            }
            bq bqVar = new bq(btVar.f12298e, btVar.f12299f, proxy, z);
            if (e2 == null && e_ == null) {
                return bqVar.m16856b(btVar.mo4103b(), btVar.d_(), btVar.c_());
            }
            if (e_ != null) {
                return bqVar.m16854a(btVar.mo4103b(), btVar.d_(), btVar.c_(), e_);
            }
            return bqVar.m16853a(btVar.mo4103b(), btVar.d_(), btVar.c_(), e2);
        } catch (C3433v e3) {
            throw e3;
        } catch (Throwable th) {
            th.printStackTrace();
            e3 = new C3433v("未知的错误");
        }
    }

    private bv m16866b(bt btVar, boolean z) throws C3433v {
        C3433v e;
        try {
            Proxy proxy;
            m16867c(btVar);
            if (btVar.f12300g == null) {
                proxy = null;
            } else {
                proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(btVar.f12300g.getHostName(), btVar.f12300g.getPort()));
            }
            return new bq(btVar.f12298e, btVar.f12299f, proxy, z).m16852a(btVar.mo4103b(), btVar.d_(), btVar.c_());
        } catch (C3433v e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new C3433v("未知的错误");
        }
    }

    private void m16867c(bt btVar) throws C3433v {
        if (btVar == null) {
            throw new C3433v("requeust is null");
        } else if (btVar.mo4103b() == null || "".equals(btVar.mo4103b())) {
            throw new C3433v("request url is empty");
        }
    }

    private void m16865a(C3433v c3433v, bu buVar) {
        bx bxVar = new bx();
        bxVar.f12478a = c3433v;
        bxVar.f12479b = buVar;
        Message obtain = Message.obtain();
        obtain.obj = bxVar;
        obtain.what = 1;
        this.f12475c.sendMessage(obtain);
    }

    private void m16864a(bv bvVar, bu buVar) {
        buVar.m16872a(bvVar.f12477b, bvVar.f12476a);
        bx bxVar = new bx();
        bxVar.f12479b = buVar;
        Message obtain = Message.obtain();
        obtain.obj = bxVar;
        obtain.what = 0;
        this.f12475c.sendMessage(obtain);
    }
}
