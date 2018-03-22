package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;

class dl extends da<Status> {
    final /* synthetic */ int f1033d;
    final /* synthetic */ zzu f1034e;

    dl(zzu com_google_android_gms_wearable_internal_zzu, C0378p c0378p, int i) {
        this.f1034e = com_google_android_gms_wearable_internal_zzu;
        this.f1033d = i;
        super(c0378p);
    }

    protected void m2129a(ch chVar) throws RemoteException {
        chVar.m2044b(this, this.f1034e.zzaiJ, this.f1033d);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2129a((ch) c0370g);
    }

    protected /* synthetic */ C0366w mo2003c(Status status) {
        return m2132d(status);
    }

    protected Status m2132d(Status status) {
        return status;
    }
}
