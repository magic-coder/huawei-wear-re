package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;

/* compiled from: GAServiceManager */
public class C0339w extends bd {
    private static final Object f217a = new Object();
    private static C0339w f218o;
    private Context f219b;
    private f f220c;
    private volatile h f221d;
    private int f222e = 1800;
    private boolean f223f = true;
    private boolean f224g;
    private String f225h;
    private boolean f226i = true;
    private boolean f227j = true;
    private g f228k = new x(this);
    private Handler f229l;
    private v f230m;
    private boolean f231n = false;

    public static C0339w m259a() {
        if (f218o == null) {
            f218o = new C0339w();
        }
        return f218o;
    }

    private C0339w() {
    }

    private void m265g() {
        this.f230m = new v(this);
        this.f230m.a(this.f219b);
    }

    private void m266h() {
        this.f229l = new Handler(this.f219b.getMainLooper(), new y(this));
        if (this.f222e > 0) {
            this.f229l.sendMessageDelayed(this.f229l.obtainMessage(1, f217a), (long) (this.f222e * 1000));
        }
    }

    synchronized void m268a(Context context, h hVar) {
        if (this.f219b == null) {
            this.f219b = context.getApplicationContext();
            if (this.f221d == null) {
                this.f221d = hVar;
                if (this.f223f) {
                    mo1735c();
                    this.f223f = false;
                }
                if (this.f224g) {
                    m273d();
                    this.f224g = false;
                }
            }
        }
    }

    synchronized f m271b() {
        if (this.f220c == null) {
            if (this.f219b == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f220c = new ax(this.f228k, this.f219b);
            if (this.f225h != null) {
                this.f220c.b().a(this.f225h);
                this.f225h = null;
            }
        }
        if (this.f229l == null) {
            m266h();
        }
        if (this.f230m == null && this.f227j) {
            m265g();
        }
        return this.f220c;
    }

    @Deprecated
    public synchronized void mo1735c() {
        if (this.f221d == null) {
            ar.c("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f223f = true;
        } else {
            am.a().a(an.S);
            this.f221d.a();
        }
    }

    @Deprecated
    public synchronized void mo1733a(int i) {
        if (this.f229l == null) {
            ar.c("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.f222e = i;
        } else {
            am.a().a(an.T);
            if (!this.f231n && this.f226i && this.f222e > 0) {
                this.f229l.removeMessages(1, f217a);
            }
            this.f222e = i;
            if (i > 0 && !this.f231n && this.f226i) {
                this.f229l.sendMessageDelayed(this.f229l.obtainMessage(1, f217a), (long) (i * 1000));
            }
        }
    }

    @Deprecated
    public void m273d() {
        if (this.f221d == null) {
            ar.c("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.f224g = true;
            return;
        }
        am.a().a(an.af);
        this.f221d.b();
    }

    synchronized void m270a(boolean z, boolean z2) {
        if (!(this.f231n == z && this.f226i == z2)) {
            if (z || !z2) {
                if (this.f222e > 0) {
                    this.f229l.removeMessages(1, f217a);
                }
            }
            if (!z && z2 && this.f222e > 0) {
                this.f229l.sendMessageDelayed(this.f229l.obtainMessage(1, f217a), (long) (this.f222e * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            ar.c(append.append(str).toString());
            this.f231n = z;
            this.f226i = z2;
        }
    }

    synchronized void mo1734a(boolean z) {
        m270a(this.f231n, z);
    }

    synchronized void mo1736e() {
        if (!this.f231n && this.f226i && this.f222e > 0) {
            this.f229l.removeMessages(1, f217a);
            this.f229l.sendMessage(this.f229l.obtainMessage(1, f217a));
        }
    }
}
