package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0525c;

class dc extends da<C0525c> {
    final /* synthetic */ String f1022d;
    final /* synthetic */ int f1023e;

    dc(db dbVar, C0378p c0378p, String str, int i) {
        this.f1022d = str;
        this.f1023e = i;
        super(c0378p);
    }

    protected void m2110a(ch chVar) throws RemoteException {
        chVar.m2038a((C0502h) this, this.f1022d, this.f1023e);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2110a((ch) c0370g);
    }

    protected /* synthetic */ C0366w mo2003c(Status status) {
        return m2113d(status);
    }

    protected C0525c m2113d(Status status) {
        return new de(status, null);
    }
}
