package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C0550m;

class C0547i extends da<C0550m> {
    final /* synthetic */ Asset f1057d;

    C0547i(C0545g c0545g, C0378p c0378p, Asset asset) {
        this.f1057d = asset;
        super(c0378p);
    }

    protected void m2179a(ch chVar) throws RemoteException {
        chVar.m2031a((C0502h) this, this.f1057d);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2179a((ch) c0370g);
    }

    protected /* synthetic */ C0366w mo2003c(Status status) {
        return m2182d(status);
    }

    protected C0550m m2182d(Status status) {
        return new C0551k(status, null);
    }
}
