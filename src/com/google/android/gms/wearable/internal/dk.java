package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;

class dk extends da<Status> {
    final /* synthetic */ zzu f1032d;

    dk(zzu com_google_android_gms_wearable_internal_zzu, C0378p c0378p) {
        this.f1032d = com_google_android_gms_wearable_internal_zzu;
        super(c0378p);
    }

    protected void m2125a(ch chVar) throws RemoteException {
        chVar.m2037a((C0502h) this, this.f1032d.zzaiJ);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2125a((ch) c0370g);
    }

    protected /* synthetic */ C0366w mo2003c(Status status) {
        return m2128d(status);
    }

    protected Status m2128d(Status status) {
        return status;
    }
}
