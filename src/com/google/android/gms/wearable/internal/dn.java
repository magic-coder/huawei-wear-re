package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0528f;

class dn extends da<C0528f> {
    final /* synthetic */ zzu f1036d;

    dn(zzu com_google_android_gms_wearable_internal_zzu, C0378p c0378p) {
        this.f1036d = com_google_android_gms_wearable_internal_zzu;
        super(c0378p);
    }

    protected void m2137a(ch chVar) throws RemoteException {
        chVar.m2045c(this, this.f1036d.zzaiJ);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2137a((ch) c0370g);
    }

    public /* synthetic */ C0366w mo2003c(Status status) {
        return m2140d(status);
    }

    public C0528f m2140d(Status status) {
        return new ds(status, null);
    }
}
