package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.api.C0383u;
import com.google.android.gms.common.api.C0384v;
import com.google.android.gms.common.api.C0385x;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class C0501m<R extends C0366w> extends C0382t<R> {
    static final ThreadLocal<Boolean> f781a = new C0507n();
    protected final C0508o<R> f782b;
    protected final WeakReference<C0378p> f783c;
    private final Object f784d;
    private final CountDownLatch f785e;
    private final ArrayList<C0383u> f786f;
    private C0385x<? super R> f787g;
    private final AtomicReference<cj> f788h;
    private R f789i;
    private Status f790j;
    private C0509p f791k;
    private volatile boolean f792l;
    private boolean f793m;
    private boolean f794n;
    private ar f795o;
    private volatile zzabx<R> f796p;
    private boolean f797q;

    @Deprecated
    C0501m() {
        this.f784d = new Object();
        this.f785e = new CountDownLatch(1);
        this.f786f = new ArrayList();
        this.f788h = new AtomicReference();
        this.f797q = false;
        this.f782b = new C0508o(Looper.getMainLooper());
        this.f783c = new WeakReference(null);
    }

    protected C0501m(C0378p c0378p) {
        this.f784d = new Object();
        this.f785e = new CountDownLatch(1);
        this.f786f = new ArrayList();
        this.f788h = new AtomicReference();
        this.f797q = false;
        this.f782b = new C0508o(c0378p != null ? c0378p.mo1838a() : Looper.getMainLooper());
        this.f783c = new WeakReference(c0378p);
    }

    private void mo1882b() {
        cj cjVar = (cj) this.f788h.getAndSet(null);
        if (cjVar != null) {
            cjVar.mo1853a(this);
        }
    }

    public static void m1471b(C0366w c0366w) {
        if (c0366w instanceof C0384v) {
            try {
                ((C0384v) c0366w).mo1750a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c0366w);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private R mo1883c() {
        R r;
        boolean z = true;
        synchronized (this.f784d) {
            if (this.f792l) {
                z = false;
            }
            C0424f.m655a(z, (Object) "Result has already been consumed.");
            C0424f.m655a(m1482d(), (Object) "Result is not ready.");
            r = this.f789i;
            this.f789i = null;
            this.f787g = null;
            this.f792l = true;
        }
        mo1882b();
        return r;
    }

    private void m1473c(R r) {
        this.f789i = r;
        this.f795o = null;
        this.f785e.countDown();
        this.f790j = this.f789i.getStatus();
        if (this.f793m) {
            this.f787g = null;
        } else if (this.f787g != null) {
            this.f782b.m1499a();
            this.f782b.m1500a(this.f787g, mo1883c());
        } else if (this.f789i instanceof C0384v) {
            this.f791k = new C0509p();
        }
        Iterator it = this.f786f.iterator();
        while (it.hasNext()) {
            ((C0383u) it.next()).mo1804a(this.f790j);
        }
        this.f786f.clear();
    }

    public final R mo1846a(long j, TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = j <= 0 || Looper.myLooper() != Looper.getMainLooper();
        C0424f.m655a(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        C0424f.m655a(!this.f792l, (Object) "Result has already been consumed.");
        if (this.f796p != null) {
            z = false;
        }
        C0424f.m655a(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.f785e.await(j, timeUnit)) {
                m1480b(Status.zzazA);
            }
        } catch (InterruptedException e) {
            m1480b(Status.zzazy);
        }
        C0424f.m655a(m1482d(), (Object) "Result is not ready.");
        return mo1883c();
    }

    public Integer mo1847a() {
        return null;
    }

    public final void mo1848a(C0383u c0383u) {
        C0424f.m658b(c0383u != null, "Callback cannot be null.");
        synchronized (this.f784d) {
            if (m1482d()) {
                c0383u.mo1804a(this.f790j);
            } else {
                this.f786f.add(c0383u);
            }
        }
    }

    public final void m1477a(R r) {
        boolean z = true;
        synchronized (this.f784d) {
            if (this.f794n || this.f793m) {
                C0501m.m1471b((C0366w) r);
                return;
            }
            if (m1482d()) {
            }
            C0424f.m655a(!m1482d(), (Object) "Results have already been set");
            if (this.f792l) {
                z = false;
            }
            C0424f.m655a(z, (Object) "Result has already been consumed");
            m1473c((C0366w) r);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1849a(com.google.android.gms.common.api.C0385x<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.f784d;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.f787g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.f792l;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.C0424f.m655a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.f796p;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.C0424f.m655a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.m1485g();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.m1482d();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.f782b;	 Catch:{ all -> 0x0027 }
        r1 = r5.mo1883c();	 Catch:{ all -> 0x0027 }
        r0.m1500a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.f787g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.m.a(com.google.android.gms.common.api.x):void");
    }

    public void m1479a(cj cjVar) {
        this.f788h.set(cjVar);
    }

    public final void m1480b(Status status) {
        synchronized (this.f784d) {
            if (!m1482d()) {
                m1477a(mo2003c(status));
                this.f794n = true;
            }
        }
    }

    @NonNull
    protected abstract R mo2003c(Status status);

    public final boolean m1482d() {
        return this.f785e.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1483e() {
        /*
        r2 = this;
        r1 = r2.f784d;
        monitor-enter(r1);
        r0 = r2.f793m;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f792l;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.f795o;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.f795o;	 Catch:{ RemoteException -> 0x002c }
        r0.m625a();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.f789i;	 Catch:{ all -> 0x0029 }
        com.google.android.gms.internal.C0501m.m1471b(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.f793m = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.zzazB;	 Catch:{ all -> 0x0029 }
        r0 = r2.mo2003c(r0);	 Catch:{ all -> 0x0029 }
        r2.m1473c(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.m.e():void");
    }

    public boolean m1484f() {
        boolean g;
        synchronized (this.f784d) {
            if (((C0378p) this.f783c.get()) == null || !this.f797q) {
                m1483e();
            }
            g = m1485g();
        }
        return g;
    }

    public boolean m1485g() {
        boolean z;
        synchronized (this.f784d) {
            z = this.f793m;
        }
        return z;
    }

    public void m1486h() {
        mo1849a(null);
    }

    public void m1487i() {
        boolean z = this.f797q || ((Boolean) f781a.get()).booleanValue();
        this.f797q = z;
    }
}
