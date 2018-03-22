package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0344b;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0428j;
import com.google.android.gms.p015b.C0359c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class bb<O extends C0344b> implements C0380r, C0381s, C0496r {
    final /* synthetic */ az f592a;
    private final Queue<eu> f593b = new LinkedList();
    private final C0372j f594c;
    private final C0370g f595d;
    private final ez<O> f596e;
    private final ab f597f;
    private final Set<C0497c> f598g = new HashSet();
    private final Map<bq<?>, bv> f599h = new HashMap();
    private final int f600i;
    private final bz f601j;
    private boolean f602k;
    private ConnectionResult f603l = null;

    @WorkerThread
    public bb(az azVar, ad<O> adVar) {
        this.f592a = azVar;
        this.f594c = adVar.mo1895a(azVar.f586q.getLooper(), this);
        if (this.f594c instanceof C0428j) {
            this.f595d = ((C0428j) this.f594c).mo1775k();
        } else {
            this.f595d = this.f594c;
        }
        this.f596e = adVar.m344b();
        this.f597f = new ab();
        this.f600i = adVar.m346c();
        if (this.f594c.mo1868d()) {
            this.f601j = adVar.mo1896a(azVar.f577h, azVar.f586q);
        } else {
            this.f601j = null;
        }
    }

    @WorkerThread
    private void m1041b(eu euVar) {
        euVar.mo1877a(this.f597f, m1066k());
        try {
            euVar.mo1878a(this);
        } catch (DeadObjectException e) {
            mo1828a(1);
            this.f594c.m358a();
        }
    }

    @WorkerThread
    private void m1042c(ConnectionResult connectionResult) {
        for (C0497c a : this.f598g) {
            a.m1132a(this.f596e, connectionResult);
        }
        this.f598g.clear();
    }

    @WorkerThread
    private void m1043n() {
        m1059d();
        m1042c(ConnectionResult.zzayj);
        m1046q();
        Iterator it = this.f599h.values().iterator();
        while (it.hasNext()) {
            it.next();
            try {
                C0359c c0359c = new C0359c();
            } catch (DeadObjectException e) {
                mo1828a(1);
                this.f594c.m358a();
            } catch (RemoteException e2) {
            }
        }
        m1045p();
        m1047r();
    }

    @WorkerThread
    private void m1044o() {
        m1059d();
        this.f602k = true;
        this.f597f.m885c();
        this.f592a.f586q.sendMessageDelayed(Message.obtain(this.f592a.f586q, 9, this.f596e), this.f592a.f574c);
        this.f592a.f586q.sendMessageDelayed(Message.obtain(this.f592a.f586q, 11, this.f596e), this.f592a.f575d);
        this.f592a.f579j = -1;
    }

    @WorkerThread
    private void m1045p() {
        while (this.f594c.m362b() && !this.f593b.isEmpty()) {
            m1041b((eu) this.f593b.remove());
        }
    }

    @WorkerThread
    private void m1046q() {
        if (this.f602k) {
            this.f592a.f586q.removeMessages(11, this.f596e);
            this.f592a.f586q.removeMessages(9, this.f596e);
            this.f602k = false;
        }
    }

    private void m1047r() {
        this.f592a.f586q.removeMessages(12, this.f596e);
        this.f592a.f586q.sendMessageDelayed(this.f592a.f586q.obtainMessage(12, this.f596e), this.f592a.f576e);
    }

    @WorkerThread
    public void m1048a() {
        C0424f.m653a(this.f592a.f586q);
        m1053a(az.f570a);
        this.f597f.m884b();
        for (bq exVar : this.f599h.keySet()) {
            m1055a(new ex(exVar, new C0359c()));
        }
        m1042c(new ConnectionResult(4));
        this.f594c.m358a();
    }

    public void mo1828a(int i) {
        if (Looper.myLooper() == this.f592a.f586q.getLooper()) {
            m1044o();
        } else {
            this.f592a.f586q.post(new bd(this));
        }
    }

    public void mo1829a(@Nullable Bundle bundle) {
        if (Looper.myLooper() == this.f592a.f586q.getLooper()) {
            m1043n();
        } else {
            this.f592a.f586q.post(new bc(this));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    public void mo1830a(@android.support.annotation.NonNull com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r0 = r5.f592a;
        r0 = r0.f586q;
        com.google.android.gms.common.internal.C0424f.m653a(r0);
        r0 = r5.f601j;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r5.f601j;
        r0.m1130b();
    L_0x0012:
        r5.m1059d();
        r0 = r5.f592a;
        r1 = -1;
        r0.f579j = r1;
        r5.m1042c(r6);
        r0 = r6.getErrorCode();
        r1 = 4;
        if (r0 != r1) goto L_0x002d;
    L_0x0025:
        r0 = com.google.android.gms.internal.az.f571b;
        r5.m1053a(r0);
    L_0x002c:
        return;
    L_0x002d:
        r0 = r5.f593b;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r5.f603l = r6;
        goto L_0x002c;
    L_0x0038:
        r1 = com.google.android.gms.internal.az.f572f;
        monitor-enter(r1);
        r0 = r5.f592a;	 Catch:{ all -> 0x0060 }
        r0 = r0.f583n;	 Catch:{ all -> 0x0060 }
        if (r0 == 0) goto L_0x0063;
    L_0x0045:
        r0 = r5.f592a;	 Catch:{ all -> 0x0060 }
        r0 = r0.f584o;	 Catch:{ all -> 0x0060 }
        r2 = r5.f596e;	 Catch:{ all -> 0x0060 }
        r0 = r0.contains(r2);	 Catch:{ all -> 0x0060 }
        if (r0 == 0) goto L_0x0063;
    L_0x0053:
        r0 = r5.f592a;	 Catch:{ all -> 0x0060 }
        r0 = r0.f583n;	 Catch:{ all -> 0x0060 }
        r2 = r5.f600i;	 Catch:{ all -> 0x0060 }
        r0.m867b(r6, r2);	 Catch:{ all -> 0x0060 }
        monitor-exit(r1);	 Catch:{ all -> 0x0060 }
        goto L_0x002c;
    L_0x0060:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0060 }
        throw r0;
    L_0x0063:
        monitor-exit(r1);	 Catch:{ all -> 0x0060 }
        r0 = r5.f592a;
        r1 = r5.f600i;
        r0 = r0.m1028a(r6, r1);
        if (r0 != 0) goto L_0x002c;
    L_0x006e:
        r0 = r6.getErrorCode();
        r1 = 18;
        if (r0 != r1) goto L_0x0079;
    L_0x0076:
        r0 = 1;
        r5.f602k = r0;
    L_0x0079:
        r0 = r5.f602k;
        if (r0 == 0) goto L_0x009b;
    L_0x007d:
        r0 = r5.f592a;
        r0 = r0.f586q;
        r1 = r5.f592a;
        r1 = r1.f586q;
        r2 = 9;
        r3 = r5.f596e;
        r1 = android.os.Message.obtain(r1, r2, r3);
        r2 = r5.f592a;
        r2 = r2.f574c;
        r0.sendMessageDelayed(r1, r2);
        goto L_0x002c;
    L_0x009b:
        r0 = new com.google.android.gms.common.api.Status;
        r1 = 17;
        r2 = r5.f596e;
        r2 = r2.m1468a();
        r2 = java.lang.String.valueOf(r2);
        r3 = java.lang.String.valueOf(r2);
        r3 = r3.length();
        r3 = r3 + 38;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "API: ";
        r3 = r4.append(r3);
        r2 = r3.append(r2);
        r3 = " is not available on this device.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r1, r2);
        r5.m1053a(r0);
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.bb.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void mo1835a(ConnectionResult connectionResult, C0367a<?> c0367a, boolean z) {
        if (Looper.myLooper() == this.f592a.f586q.getLooper()) {
            mo1830a(connectionResult);
        } else {
            this.f592a.f586q.post(new be(this, connectionResult));
        }
    }

    @WorkerThread
    public void m1053a(Status status) {
        C0424f.m653a(this.f592a.f586q);
        for (eu a : this.f593b) {
            a.mo1876a(status);
        }
        this.f593b.clear();
    }

    @WorkerThread
    public void m1054a(C0497c c0497c) {
        C0424f.m653a(this.f592a.f586q);
        this.f598g.add(c0497c);
    }

    @WorkerThread
    public void m1055a(eu euVar) {
        C0424f.m653a(this.f592a.f586q);
        if (this.f594c.m362b()) {
            m1041b(euVar);
            m1047r();
            return;
        }
        this.f593b.add(euVar);
        if (this.f603l == null || !this.f603l.hasResolution()) {
            m1064i();
        } else {
            mo1830a(this.f603l);
        }
    }

    public C0372j m1056b() {
        return this.f594c;
    }

    @WorkerThread
    public void m1057b(@NonNull ConnectionResult connectionResult) {
        C0424f.m653a(this.f592a.f586q);
        this.f594c.m358a();
        mo1830a(connectionResult);
    }

    public Map<bq<?>, bv> m1058c() {
        return this.f599h;
    }

    @WorkerThread
    public void m1059d() {
        C0424f.m653a(this.f592a.f586q);
        this.f603l = null;
    }

    @WorkerThread
    public ConnectionResult m1060e() {
        C0424f.m653a(this.f592a.f586q);
        return this.f603l;
    }

    @WorkerThread
    public void m1061f() {
        C0424f.m653a(this.f592a.f586q);
        if (this.f602k) {
            m1064i();
        }
    }

    @WorkerThread
    public void m1062g() {
        C0424f.m653a(this.f592a.f586q);
        if (this.f602k) {
            m1046q();
            m1053a(this.f592a.f578i.mo1742a(this.f592a.f577h) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.f594c.m358a();
        }
    }

    @WorkerThread
    public void m1063h() {
        C0424f.m653a(this.f592a.f586q);
        if (!this.f594c.m362b() || this.f599h.size() != 0) {
            return;
        }
        if (this.f597f.m883a()) {
            m1047r();
        } else {
            this.f594c.m358a();
        }
    }

    @WorkerThread
    public void m1064i() {
        C0424f.m653a(this.f592a.f586q);
        if (!this.f594c.m362b() && !this.f594c.m363c()) {
            if (this.f594c.mo2011e() && this.f592a.f579j != 0) {
                this.f592a.f579j = this.f592a.f578i.mo1742a(this.f592a.f577h);
                if (this.f592a.f579j != 0) {
                    mo1830a(new ConnectionResult(this.f592a.f579j, null));
                    return;
                }
            }
            cb bfVar = new bf(this.f592a, this.f594c, this.f596e);
            if (this.f594c.mo1868d()) {
                this.f601j.m1128a(bfVar);
            }
            this.f594c.mo2010a(bfVar);
        }
    }

    boolean m1065j() {
        return this.f594c.m362b();
    }

    public boolean m1066k() {
        return this.f594c.mo1868d();
    }

    public int m1067l() {
        return this.f600i;
    }

    dk m1068m() {
        return this.f601j == null ? null : this.f601j.m1124a();
    }
}
