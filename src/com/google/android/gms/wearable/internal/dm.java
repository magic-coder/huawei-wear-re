package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0527e;

class dm extends da<C0527e> {
    final /* synthetic */ zzu f1035d;

    dm(zzu com_google_android_gms_wearable_internal_zzu, C0378p c0378p) {
        this.f1035d = com_google_android_gms_wearable_internal_zzu;
        super(c0378p);
    }

    protected void m2133a(ch chVar) throws RemoteException {
        chVar.m2043b(this, this.f1035d.zzaiJ);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2133a((ch) c0370g);
    }

    public /* synthetic */ C0366w mo2003c(Status status) {
        return m2136d(status);
    }

    public C0527e m2136d(Status status) {
        return new dr(status, null);
    }
}
