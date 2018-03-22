package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0521h;

final class dh extends da<Status> {
    private final String f1028d;
    private C0521h f1029e;

    dh(C0378p c0378p, C0521h c0521h, String str) {
        super(c0378p);
        this.f1029e = (C0521h) C0424f.m649a((Object) c0521h);
        this.f1028d = str;
    }

    protected void m2118a(ch chVar) throws RemoteException {
        chVar.m2036a((C0502h) this, this.f1029e, this.f1028d);
        this.f1029e = null;
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2118a((ch) c0370g);
    }

    public /* synthetic */ C0366w mo2003c(Status status) {
        return m2121d(status);
    }

    public Status m2121d(Status status) {
        this.f1029e = null;
        return status;
    }
}
