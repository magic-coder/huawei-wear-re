package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0434r;
import com.google.android.gms.common.internal.ao;
import java.util.Set;

class bf implements C0434r, cb {
    final /* synthetic */ az f608a;
    private final C0372j f609b;
    private final ez<?> f610c;
    private ao f611d = null;
    private Set<Scope> f612e = null;
    private boolean f613f = false;

    public bf(az azVar, C0372j c0372j, ez<?> ezVar) {
        this.f608a = azVar;
        this.f609b = c0372j;
        this.f610c = ezVar;
    }

    @WorkerThread
    private void m1072a() {
        if (this.f613f && this.f611d != null) {
            this.f609b.m359a(this.f611d, this.f612e);
        }
    }

    public void mo1777a(@NonNull ConnectionResult connectionResult) {
        this.f608a.f586q.post(new bg(this, connectionResult));
    }

    @WorkerThread
    public void mo1836a(ao aoVar, Set<Scope> set) {
        if (aoVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            mo1837b(new ConnectionResult(4));
            return;
        }
        this.f611d = aoVar;
        this.f612e = set;
        m1072a();
    }

    @WorkerThread
    public void mo1837b(ConnectionResult connectionResult) {
        ((bb) this.f608a.f582m.get(this.f610c)).m1057b(connectionResult);
    }
}
