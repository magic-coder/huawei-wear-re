package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.C0388h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0371h;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.common.internal.C0444y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class C0516x implements bj {
    private final Map<C0371h<?>, C0515w<?>> f828a = new HashMap();
    private final Map<C0371h<?>, C0515w<?>> f829b = new HashMap();
    private final Map<C0367a<?>, Boolean> f830c;
    private final az f831d;
    private final zzaat f832e;
    private final Lock f833f;
    private final Looper f834g;
    private final C0388h f835h;
    private final Condition f836i;
    private final C0443x f837j;
    private final boolean f838k;
    private final boolean f839l;
    private final Queue<C0503g<?, ?>> f840m = new LinkedList();
    private boolean f841n;
    private Map<ez<?>, ConnectionResult> f842o;
    private Map<ez<?>, ConnectionResult> f843p;
    private aa f844q;
    private ConnectionResult f845r;

    public C0516x(Context context, Lock lock, Looper looper, C0388h c0388h, Map<C0371h<?>, C0372j> map, C0443x c0443x, Map<C0367a<?>, Boolean> map2, C0369f<? extends dk, dl> c0369f, ArrayList<C0510q> arrayList, zzaat com_google_android_gms_internal_zzaat, boolean z) {
        this.f833f = lock;
        this.f834g = looper;
        this.f836i = lock.newCondition();
        this.f835h = c0388h;
        this.f832e = com_google_android_gms_internal_zzaat;
        this.f830c = map2;
        this.f837j = c0443x;
        this.f838k = z;
        Map hashMap = new HashMap();
        for (C0367a c0367a : map2.keySet()) {
            hashMap.put(c0367a.m335c(), c0367a);
        }
        Map hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0510q c0510q = (C0510q) it.next();
            hashMap2.put(c0510q.f804a, c0510q);
        }
        Object obj = 1;
        Object obj2 = null;
        Object obj3 = null;
        for (Entry entry : map.entrySet()) {
            Object obj4;
            Object obj5;
            Object obj6;
            C0367a c0367a2 = (C0367a) hashMap.get(entry.getKey());
            C0372j c0372j = (C0372j) entry.getValue();
            if (c0372j.mo2011e()) {
                obj4 = 1;
                if (((Boolean) this.f830c.get(c0367a2)).booleanValue()) {
                    obj5 = obj;
                    obj6 = obj2;
                } else {
                    obj5 = obj;
                    obj6 = 1;
                }
            } else {
                obj4 = obj3;
                obj5 = null;
                obj6 = obj2;
            }
            C0515w c0515w = new C0515w(context, c0367a2, looper, c0372j, (C0510q) hashMap2.get(c0367a2), c0443x, c0369f);
            this.f828a.put((C0371h) entry.getKey(), c0515w);
            if (c0372j.mo1868d()) {
                this.f829b.put((C0371h) entry.getKey(), c0515w);
            }
            obj3 = obj4;
            obj = obj5;
            obj2 = obj6;
        }
        boolean z2 = obj3 != null && obj == null && obj2 == null;
        this.f839l = z2;
        this.f831d = az.m1001a();
    }

    @Nullable
    private ConnectionResult m1548a(@NonNull C0371h<?> c0371h) {
        this.f833f.lock();
        try {
            C0515w c0515w = (C0515w) this.f828a.get(c0371h);
            if (this.f842o == null || c0515w == null) {
                this.f833f.unlock();
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.f842o.get(c0515w.m344b());
            return connectionResult;
        } finally {
            this.f833f.unlock();
        }
    }

    private boolean m1552a(C0515w<?> c0515w, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && ((Boolean) this.f830c.get(c0515w.m340a())).booleanValue() && c0515w.m1547e().mo2011e() && this.f835h.mo1745a(connectionResult.getErrorCode());
    }

    private <T extends C0503g<? extends C0366w, ? extends C0370g>> boolean m1558c(@NonNull T t) {
        C0371h b = t.mo1882b();
        ConnectionResult a = m1548a(b);
        if (a == null || a.getErrorCode() != 4) {
            return false;
        }
        t.mo1880a(new Status(4, null, this.f831d.m1023a(((C0515w) this.f828a.get(b)).m344b(), this.f832e.m1614m())));
        return true;
    }

    private void m1562f() {
        if (this.f837j == null) {
            this.f832e.f851d = Collections.emptySet();
            return;
        }
        Set hashSet = new HashSet(this.f837j.m759c());
        Map e = this.f837j.m761e();
        for (C0367a c0367a : e.keySet()) {
            ConnectionResult a = m1572a(c0367a);
            if (a != null && a.isSuccess()) {
                hashSet.addAll(((C0444y) e.get(c0367a)).f458a);
            }
        }
        this.f832e.f851d = hashSet;
    }

    private void m1564g() {
        while (!this.f840m.isEmpty()) {
            mo1887b((C0503g) this.f840m.remove());
        }
        this.f832e.mo1893a(null);
    }

    @Nullable
    private ConnectionResult m1565h() {
        int i = 0;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        for (C0515w c0515w : this.f828a.values()) {
            C0367a a = c0515w.m340a();
            ConnectionResult connectionResult3 = (ConnectionResult) this.f842o.get(c0515w.m344b());
            if (!connectionResult3.isSuccess() && (!((Boolean) this.f830c.get(a)).booleanValue() || connectionResult3.hasResolution() || this.f835h.mo1745a(connectionResult3.getErrorCode()))) {
                int a2;
                if (connectionResult3.getErrorCode() == 4 && this.f838k) {
                    a2 = a.m333a().m355a();
                    if (connectionResult == null || i > a2) {
                        i = a2;
                        connectionResult = connectionResult3;
                    }
                } else {
                    ConnectionResult connectionResult4;
                    int i3;
                    a2 = a.m333a().m355a();
                    if (connectionResult2 == null || i2 > a2) {
                        int i4 = a2;
                        connectionResult4 = connectionResult3;
                        i3 = i4;
                    } else {
                        i3 = i2;
                        connectionResult4 = connectionResult2;
                    }
                    i2 = i3;
                    connectionResult2 = connectionResult4;
                }
            }
        }
        return (connectionResult2 == null || connectionResult == null || i2 <= i) ? connectionResult2 : connectionResult;
    }

    @Nullable
    public ConnectionResult m1572a(@NonNull C0367a<?> c0367a) {
        return m1548a(c0367a.m335c());
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1884a(@NonNull T t) {
        if (this.f838k && m1558c((C0503g) t)) {
            return t;
        }
        if (mo1889c()) {
            this.f832e.f856i.m1146a((C0501m) t);
            return ((C0515w) this.f828a.get(t.mo1882b())).m343a(t);
        }
        this.f840m.add(t);
        return t;
    }

    public void mo1885a() {
        this.f833f.lock();
        try {
            if (!this.f841n) {
                this.f841n = true;
                this.f842o = null;
                this.f843p = null;
                this.f844q = null;
                this.f845r = null;
                this.f831d.m1032c();
                this.f831d.m1024a(this.f828a.values()).mo1738a(new cu(this.f834g), new C0518z());
                this.f833f.unlock();
            }
        } finally {
            this.f833f.unlock();
        }
    }

    public void mo1886a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1887b(@NonNull T t) {
        C0371h b = t.mo1882b();
        if (this.f838k && m1558c((C0503g) t)) {
            return t;
        }
        this.f832e.f856i.m1146a((C0501m) t);
        return ((C0515w) this.f828a.get(b)).m345b(t);
    }

    public void mo1888b() {
        this.f833f.lock();
        try {
            this.f841n = false;
            this.f842o = null;
            this.f843p = null;
            if (this.f844q != null) {
                this.f844q.m878a();
                this.f844q = null;
            }
            this.f845r = null;
            while (!this.f840m.isEmpty()) {
                C0503g c0503g = (C0503g) this.f840m.remove();
                c0503g.m1479a(null);
                c0503g.m1483e();
            }
            this.f836i.signalAll();
        } finally {
            this.f833f.unlock();
        }
    }

    public boolean mo1889c() {
        this.f833f.lock();
        try {
            boolean z = this.f842o != null && this.f845r == null;
            this.f833f.unlock();
            return z;
        } catch (Throwable th) {
            this.f833f.unlock();
        }
    }

    public boolean mo1890d() {
        this.f833f.lock();
        try {
            boolean z = this.f842o == null && this.f841n;
            this.f833f.unlock();
            return z;
        } catch (Throwable th) {
            this.f833f.unlock();
        }
    }

    public void mo1891e() {
    }
}
