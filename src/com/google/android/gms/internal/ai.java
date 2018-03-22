package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C0388h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0371h;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.common.internal.C0444y;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.common.internal.zzaf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class ai implements aw {
    private final zzaav f529a;
    private final Lock f530b;
    private final Context f531c;
    private final C0388h f532d;
    private ConnectionResult f533e;
    private int f534f;
    private int f535g = 0;
    private int f536h;
    private final Bundle f537i = new Bundle();
    private final Set<C0371h> f538j = new HashSet();
    private dk f539k;
    private boolean f540l;
    private boolean f541m;
    private boolean f542n;
    private ao f543o;
    private boolean f544p;
    private boolean f545q;
    private final C0443x f546r;
    private final Map<C0367a<?>, Boolean> f547s;
    private final C0369f<? extends dk, dl> f548t;
    private ArrayList<Future<?>> f549u = new ArrayList();

    public ai(zzaav com_google_android_gms_internal_zzaav, C0443x c0443x, Map<C0367a<?>, Boolean> map, C0388h c0388h, C0369f<? extends dk, dl> c0369f, Lock lock, Context context) {
        this.f529a = com_google_android_gms_internal_zzaav;
        this.f546r = c0443x;
        this.f547s = map;
        this.f532d = c0388h;
        this.f548t = c0369f;
        this.f530b = lock;
        this.f531c = context;
    }

    private void m927a(zzbaw com_google_android_gms_internal_zzbaw) {
        if (m934b(0)) {
            ConnectionResult zzyh = com_google_android_gms_internal_zzbaw.zzyh();
            if (zzyh.isSuccess()) {
                zzaf zzPU = com_google_android_gms_internal_zzbaw.zzPU();
                ConnectionResult zzyh2 = zzPU.zzyh();
                if (zzyh2.isSuccess()) {
                    this.f542n = true;
                    this.f543o = zzPU.zzyg();
                    this.f544p = zzPU.zzyi();
                    this.f545q = zzPU.zzyj();
                    m942e();
                    return;
                }
                String valueOf = String.valueOf(zzyh2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                m939c(zzyh2);
            } else if (m935b(zzyh)) {
                m949h();
                m942e();
            } else {
                m939c(zzyh);
            }
        }
    }

    private void m928a(boolean z) {
        if (this.f539k != null) {
            if (this.f539k.m362b() && z) {
                this.f539k.mo1775k();
            }
            this.f539k.m358a();
            this.f543o = null;
        }
    }

    private boolean m929a(int i, boolean z, ConnectionResult connectionResult) {
        return (!z || m930a(connectionResult)) ? this.f533e == null || i < this.f534f : false;
    }

    private boolean m930a(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.f532d.mo1746b(connectionResult.getErrorCode()) != null;
    }

    private void m933b(ConnectionResult connectionResult, C0367a<?> c0367a, boolean z) {
        int a = c0367a.m333a().m355a();
        if (m929a(a, z, connectionResult)) {
            this.f533e = connectionResult;
            this.f534f = a;
        }
        this.f529a.f875b.put(c0367a.m335c(), connectionResult);
    }

    private boolean m934b(int i) {
        if (this.f535g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f529a.f880g.m1613l());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.f536h);
        valueOf = String.valueOf(m937c(this.f535g));
        String valueOf2 = String.valueOf(m937c(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        m939c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m935b(ConnectionResult connectionResult) {
        return this.f540l && !connectionResult.hasResolution();
    }

    private String m937c(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m939c(ConnectionResult connectionResult) {
        m950i();
        m928a(!connectionResult.hasResolution());
        this.f529a.m1621a(connectionResult);
        this.f529a.f881h.mo1894a(connectionResult);
    }

    private boolean m941d() {
        this.f536h--;
        if (this.f536h > 0) {
            return false;
        }
        if (this.f536h < 0) {
            Log.w("GoogleApiClientConnecting", this.f529a.f880g.m1613l());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m939c(new ConnectionResult(8, null));
            return false;
        } else if (this.f533e == null) {
            return true;
        } else {
            this.f529a.f879f = this.f534f;
            m939c(this.f533e);
            return false;
        }
    }

    private void m942e() {
        if (this.f536h == 0) {
            if (!this.f541m || this.f542n) {
                m945f();
            }
        }
    }

    private void m945f() {
        ArrayList arrayList = new ArrayList();
        this.f535g = 1;
        this.f536h = this.f529a.f874a.size();
        for (C0371h c0371h : this.f529a.f874a.keySet()) {
            if (!this.f529a.f875b.containsKey(c0371h)) {
                arrayList.add((C0372j) this.f529a.f874a.get(c0371h));
            } else if (m941d()) {
                m947g();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f549u.add(ay.m998a().submit(new ao(this, arrayList)));
        }
    }

    private void m947g() {
        this.f529a.m1632g();
        ay.m998a().execute(new aj(this));
        if (this.f539k != null) {
            if (this.f544p) {
                this.f539k.mo1866a(this.f543o, this.f545q);
            }
            m928a(false);
        }
        for (C0371h c0371h : this.f529a.f875b.keySet()) {
            ((C0372j) this.f529a.f874a.get(c0371h)).m358a();
        }
        this.f529a.f881h.mo1893a(this.f537i.isEmpty() ? null : this.f537i);
    }

    private void m949h() {
        this.f541m = false;
        this.f529a.f880g.f851d = Collections.emptySet();
        for (C0371h c0371h : this.f538j) {
            if (!this.f529a.f875b.containsKey(c0371h)) {
                this.f529a.f875b.put(c0371h, new ConnectionResult(17, null));
            }
        }
    }

    private void m950i() {
        Iterator it = this.f549u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f549u.clear();
    }

    private Set<Scope> m952j() {
        if (this.f546r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f546r.m759c());
        Map e = this.f546r.m761e();
        for (C0367a c0367a : e.keySet()) {
            if (!this.f529a.f875b.containsKey(c0367a.m335c())) {
                hashSet.addAll(((C0444y) e.get(c0367a)).f458a);
            }
        }
        return hashSet;
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1813a(T t) {
        this.f529a.f880g.f848a.add(t);
        return t;
    }

    public void mo1814a() {
        this.f529a.f875b.clear();
        this.f541m = false;
        this.f533e = null;
        this.f535g = 0;
        this.f540l = true;
        this.f542n = false;
        this.f544p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (C0367a c0367a : this.f547s.keySet()) {
            C0372j c0372j = (C0372j) this.f529a.f874a.get(c0367a.m335c());
            int i2 = (c0367a.m333a().m355a() == 1 ? 1 : 0) | i;
            boolean booleanValue = ((Boolean) this.f547s.get(c0367a)).booleanValue();
            if (c0372j.mo1868d()) {
                this.f541m = true;
                if (booleanValue) {
                    this.f538j.add(c0367a.m335c());
                } else {
                    this.f540l = false;
                }
            }
            hashMap.put(c0372j, new ak(this, c0367a, booleanValue));
            i = i2;
        }
        if (i != 0) {
            this.f541m = false;
        }
        if (this.f541m) {
            this.f546r.m757a(Integer.valueOf(this.f529a.f880g.m1614m()));
            C0380r arVar = new ar();
            this.f539k = (dk) this.f548t.mo1854a(this.f531c, this.f529a.f880g.mo1838a(), this.f546r, this.f546r.m764h(), arVar, arVar);
        }
        this.f536h = this.f529a.f874a.size();
        this.f549u.add(ay.m998a().submit(new al(this, hashMap)));
    }

    public void mo1815a(int i) {
        m939c(new ConnectionResult(8, null));
    }

    public void mo1816a(Bundle bundle) {
        if (m934b(1)) {
            if (bundle != null) {
                this.f537i.putAll(bundle);
            }
            if (m941d()) {
                m947g();
            }
        }
    }

    public void mo1817a(ConnectionResult connectionResult, C0367a<?> c0367a, boolean z) {
        if (m934b(1)) {
            m933b(connectionResult, c0367a, z);
            if (m941d()) {
                m947g();
            }
        }
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1818b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean mo1819b() {
        m950i();
        m928a(true);
        this.f529a.m1621a(null);
        return true;
    }

    public void mo1820c() {
    }
}
