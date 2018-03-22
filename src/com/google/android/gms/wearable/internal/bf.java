package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.aa;

class bf extends da<Status> {
    final /* synthetic */ aa f968d;

    bf(bc bcVar, C0378p c0378p, aa aaVar) {
        this.f968d = aaVar;
        super(c0378p);
    }

    protected void m1973a(ch chVar) throws RemoteException {
        chVar.m2033a((C0502h) this, this.f968d);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m1973a((ch) c0370g);
    }

    public /* synthetic */ C0366w mo2003c(Status status) {
        return m1976d(status);
    }

    public Status m1976d(Status status) {
        return status;
    }
}
