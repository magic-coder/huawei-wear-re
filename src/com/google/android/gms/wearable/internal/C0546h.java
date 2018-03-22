package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0548k;
import com.google.android.gms.wearable.PutDataRequest;

class C0546h extends da<C0548k> {
    final /* synthetic */ PutDataRequest f1056d;

    C0546h(C0545g c0545g, C0378p c0378p, PutDataRequest putDataRequest) {
        this.f1056d = putDataRequest;
        super(c0378p);
    }

    protected void m2175a(ch chVar) throws RemoteException {
        chVar.m2032a((C0502h) this, this.f1056d);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2175a((ch) c0370g);
    }

    public /* synthetic */ C0366w mo2003c(Status status) {
        return m2178d(status);
    }

    public C0548k m2178d(Status status) {
        return new C0549j(status, null);
    }
}
