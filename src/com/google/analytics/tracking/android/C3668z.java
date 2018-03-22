package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.Command;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: GAServiceProxy */
class C3668z implements be, C3653d, C3654e {
    private volatile long f14203a;
    private volatile ad f14204b;
    private volatile C3645a f14205c;
    private C3655f f14206d;
    private C3655f f14207e;
    private final ao f14208f;
    private final C3647h f14209g;
    private final Context f14210h;
    private final Queue<ag> f14211i;
    private volatile int f14212j;
    private volatile Timer f14213k;
    private volatile Timer f14214l;
    private volatile Timer f14215m;
    private boolean f14216n;
    private boolean f14217o;
    private boolean f14218p;
    private boolean f14219q;
    private C3646l f14220r;
    private long f14221s;

    C3668z(Context context, C3647h c3647h, C3655f c3655f, ao aoVar) {
        this.f14211i = new ConcurrentLinkedQueue();
        this.f14221s = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
        this.f14207e = c3655f;
        this.f14210h = context;
        this.f14209g = c3647h;
        this.f14208f = aoVar;
        this.f14220r = new aa(this);
        this.f14212j = 0;
        this.f14204b = ad.DISCONNECTED;
    }

    C3668z(Context context, C3647h c3647h) {
        this(context, c3647h, null, ao.m18247a(context));
    }

    public void mo4263a(Map<String, String> map, long j, String str, List<Command> list) {
        ar.m18268c("putHit called");
        this.f14211i.add(new ag(map, j, str, list));
        m18390h();
    }

    public void mo4265c() {
        switch (ac.f14041a[this.f14204b.ordinal()]) {
            case 1:
                m18391i();
                return;
            case 2:
                return;
            default:
                this.f14216n = true;
                return;
        }
    }

    public void m18403d() {
        ar.m18268c("clearHits called");
        this.f14211i.clear();
        switch (ac.f14041a[this.f14204b.ordinal()]) {
            case 1:
                this.f14206d.m18349a(0);
                this.f14217o = false;
                return;
            case 2:
                this.f14205c.mo4244a();
                this.f14217o = false;
                return;
            default:
                this.f14217o = true;
                return;
        }
    }

    public synchronized void mo4266e() {
        if (!this.f14219q) {
            ar.m18268c("setForceLocalDispatch called.");
            this.f14219q = true;
            switch (ac.f14041a[this.f14204b.ordinal()]) {
                case 1:
                case 4:
                case 5:
                case 6:
                    break;
                case 2:
                    m18396l();
                    break;
                case 3:
                    this.f14218p = true;
                    break;
                default:
                    break;
            }
        }
    }

    private Timer m18380a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private void m18388g() {
        this.f14213k = m18380a(this.f14213k);
        this.f14214l = m18380a(this.f14214l);
        this.f14215m = m18380a(this.f14215m);
    }

    public void mo4267f() {
        if (this.f14205c == null) {
            this.f14205c = new C3648b(this.f14210h, this, this);
            m18395k();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m18390h() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r3 = r8.f14209g;	 Catch:{ all -> 0x0074 }
        r3 = r3.mo4237d();	 Catch:{ all -> 0x0074 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.f14209g;	 Catch:{ all -> 0x0074 }
        r2 = r2.mo4236c();	 Catch:{ all -> 0x0074 }
        r3 = new com.google.analytics.tracking.android.ab;	 Catch:{ all -> 0x0074 }
        r3.<init>(r8);	 Catch:{ all -> 0x0074 }
        r2.add(r3);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.f14217o;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x0028;
    L_0x0025:
        r8.m18403d();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r2 = com.google.analytics.tracking.android.ac.f14041a;	 Catch:{ all -> 0x0074 }
        r3 = r8.f14204b;	 Catch:{ all -> 0x0074 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0074 }
        r2 = r2[r3];	 Catch:{ all -> 0x0074 }
        switch(r2) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r2 = r8.f14211i;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0077;
    L_0x003e:
        r2 = r8.f14211i;	 Catch:{ all -> 0x0074 }
        r2 = r2.poll();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.analytics.tracking.android.ag) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to store  ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.analytics.tracking.android.ar.m18268c(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.f14206d;	 Catch:{ all -> 0x0074 }
        r3 = r7.m18208a();	 Catch:{ all -> 0x0074 }
        r4 = r7.m18209b();	 Catch:{ all -> 0x0074 }
        r6 = r7.m18210c();	 Catch:{ all -> 0x0074 }
        r7 = r7.m18211d();	 Catch:{ all -> 0x0074 }
        r2.m18350a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x0077:
        r2 = r8.f14216n;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x001f;
    L_0x007b:
        r8.m18391i();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r2 = r8.f14211i;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00d0;
    L_0x0087:
        r2 = r8.f14211i;	 Catch:{ all -> 0x0074 }
        r2 = r2.peek();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.analytics.tracking.android.ag) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to service   ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.analytics.tracking.android.ar.m18268c(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.f14208f;	 Catch:{ all -> 0x0074 }
        r2 = r2.m18252b();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00ca;
    L_0x00af:
        r2 = r8.f14205c;	 Catch:{ all -> 0x0074 }
        r3 = r7.m18208a();	 Catch:{ all -> 0x0074 }
        r4 = r7.m18209b();	 Catch:{ all -> 0x0074 }
        r6 = r7.m18210c();	 Catch:{ all -> 0x0074 }
        r7 = r7.m18211d();	 Catch:{ all -> 0x0074 }
        r2.mo4245a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r2 = r8.f14211i;	 Catch:{ all -> 0x0074 }
        r2.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r2 = "Dry run enabled. Hit not actually sent to service.";
        com.google.analytics.tracking.android.ar.m18268c(r2);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r2 = r8.f14220r;	 Catch:{ all -> 0x0074 }
        r2 = r2.mo4232a();	 Catch:{ all -> 0x0074 }
        r8.f14203a = r2;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r2 = "Need to reconnect";
        com.google.analytics.tracking.android.ar.m18268c(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.f14211i;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x001f;
    L_0x00e7:
        r8.m18395k();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.z.h():void");
    }

    private void m18391i() {
        this.f14206d.m18348a();
        this.f14216n = false;
    }

    private synchronized void m18394j() {
        if (this.f14204b != ad.CONNECTED_LOCAL) {
            m18388g();
            ar.m18268c("falling back to local store");
            if (this.f14207e != null) {
                this.f14206d = this.f14207e;
            } else {
                w a = w.a();
                a.a(this.f14210h, this.f14209g);
                this.f14206d = a.b();
            }
            this.f14204b = ad.CONNECTED_LOCAL;
            m18390h();
        }
    }

    private synchronized void m18395k() {
        if (this.f14219q || this.f14205c == null || this.f14204b == ad.CONNECTED_LOCAL) {
            ar.m18269d("client not initialized.");
            m18394j();
        } else {
            try {
                this.f14212j++;
                m18380a(this.f14214l);
                this.f14204b = ad.CONNECTING;
                this.f14214l = new Timer("Failed Connect");
                this.f14214l.schedule(new af(), 3000);
                ar.m18268c("connecting to Analytics service");
                this.f14205c.mo4246b();
            } catch (SecurityException e) {
                ar.m18269d("security exception on connectToService");
                m18394j();
            }
        }
    }

    private synchronized void m18396l() {
        if (this.f14205c != null && this.f14204b == ad.CONNECTED_SERVICE) {
            this.f14204b = ad.PENDING_DISCONNECT;
            this.f14205c.mo4247c();
        }
    }

    public synchronized void mo4261a() {
        this.f14214l = m18380a(this.f14214l);
        this.f14212j = 0;
        ar.m18268c("Connected to service");
        this.f14204b = ad.CONNECTED_SERVICE;
        if (this.f14218p) {
            m18396l();
            this.f14218p = false;
        } else {
            m18390h();
            this.f14215m = m18380a(this.f14215m);
            this.f14215m = new Timer("disconnect check");
            this.f14215m.schedule(new ae(), this.f14221s);
        }
    }

    public synchronized void mo4264b() {
        if (this.f14204b == ad.PENDING_DISCONNECT) {
            ar.m18268c("Disconnected from service");
            m18388g();
            this.f14204b = ad.DISCONNECTED;
        } else {
            ar.m18268c("Unexpected disconnect.");
            this.f14204b = ad.PENDING_CONNECTION;
            if (this.f14212j < 2) {
                m18397m();
            } else {
                m18394j();
            }
        }
    }

    public synchronized void mo4262a(int i, Intent intent) {
        this.f14204b = ad.PENDING_CONNECTION;
        if (this.f14212j < 2) {
            ar.m18269d("Service unavailable (code=" + i + "), will retry.");
            m18397m();
        } else {
            ar.m18269d("Service unavailable (code=" + i + "), using local store.");
            m18394j();
        }
    }

    private void m18397m() {
        this.f14213k = m18380a(this.f14213k);
        this.f14213k = new Timer("Service Reconnect");
        this.f14213k.schedule(new ah(), 5000);
    }
}
