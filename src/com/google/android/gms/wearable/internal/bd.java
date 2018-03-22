package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0538z;
import java.util.ArrayList;

class bd extends da<C0538z> {
    bd(bc bcVar, C0378p c0378p) {
        super(c0378p);
    }

    protected void m1966a(ch chVar) throws RemoteException {
        chVar.m2030a((C0502h) this);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m1966a((ch) c0370g);
    }

    protected /* synthetic */ C0366w mo2003c(Status status) {
        return m1969d(status);
    }

    protected C0538z m1969d(Status status) {
        return new bg(status, new ArrayList());
    }
}
