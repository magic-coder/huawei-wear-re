package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah implements Callback {
    final ArrayList<C0380r> f393a = new ArrayList();
    private final ai f394b;
    private final ArrayList<C0380r> f395c = new ArrayList();
    private final ArrayList<C0381s> f396d = new ArrayList();
    private volatile boolean f397e = false;
    private final AtomicInteger f398f = new AtomicInteger(0);
    private boolean f399g = false;
    private final Handler f400h;
    private final Object f401i = new Object();

    public ah(Looper looper, ai aiVar) {
        this.f394b = aiVar;
        this.f400h = new Handler(looper, this);
    }

    public void m585a() {
        this.f397e = false;
        this.f398f.incrementAndGet();
    }

    public void m586a(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f400h.getLooper()) {
            z = true;
        }
        C0424f.m655a(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f400h.removeMessages(1);
        synchronized (this.f401i) {
            this.f399g = true;
            ArrayList arrayList = new ArrayList(this.f395c);
            int i2 = this.f398f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0380r c0380r = (C0380r) it.next();
                if (!this.f397e || this.f398f.get() != i2) {
                    break;
                } else if (this.f395c.contains(c0380r)) {
                    c0380r.mo1828a(i);
                }
            }
            this.f393a.clear();
            this.f399g = false;
        }
    }

    public void m587a(Bundle bundle) {
        boolean z = true;
        C0424f.m655a(Looper.myLooper() == this.f400h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f401i) {
            C0424f.m654a(!this.f399g);
            this.f400h.removeMessages(1);
            this.f399g = true;
            if (this.f393a.size() != 0) {
                z = false;
            }
            C0424f.m654a(z);
            ArrayList arrayList = new ArrayList(this.f395c);
            int i = this.f398f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0380r c0380r = (C0380r) it.next();
                if (!this.f397e || !this.f394b.mo1831b() || this.f398f.get() != i) {
                    break;
                } else if (!this.f393a.contains(c0380r)) {
                    c0380r.mo1829a(bundle);
                }
            }
            this.f393a.clear();
            this.f399g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m588a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.f400h;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.C0424f.m655a(r0, r2);
        r0 = r5.f400h;
        r0.removeMessages(r1);
        r1 = r5.f401i;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.f396d;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.f398f;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.google.android.gms.common.api.C0381s) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.f397e;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.f398f;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.f396d;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.mo1830a(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.ah.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void m589a(C0380r c0380r) {
        C0424f.m649a((Object) c0380r);
        synchronized (this.f401i) {
            if (this.f395c.contains(c0380r)) {
                String valueOf = String.valueOf(c0380r);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f395c.add(c0380r);
            }
        }
        if (this.f394b.mo1831b()) {
            this.f400h.sendMessage(this.f400h.obtainMessage(1, c0380r));
        }
    }

    public void m590a(C0381s c0381s) {
        C0424f.m649a((Object) c0381s);
        synchronized (this.f401i) {
            if (this.f396d.contains(c0381s)) {
                String valueOf = String.valueOf(c0381s);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f396d.add(c0381s);
            }
        }
    }

    public void m591b() {
        this.f397e = true;
    }

    public void m592b(C0381s c0381s) {
        C0424f.m649a((Object) c0381s);
        synchronized (this.f401i) {
            if (!this.f396d.remove(c0381s)) {
                String valueOf = String.valueOf(c0381s);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            C0380r c0380r = (C0380r) message.obj;
            synchronized (this.f401i) {
                if (this.f397e && this.f394b.mo1831b() && this.f395c.contains(c0380r)) {
                    c0380r.mo1829a(this.f394b.mo1832t());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
