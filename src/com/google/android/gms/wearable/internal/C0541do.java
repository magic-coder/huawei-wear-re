package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;

class C0541do extends da<Status> {
    final /* synthetic */ Uri f1037d;
    final /* synthetic */ boolean f1038e;
    final /* synthetic */ zzu f1039f;

    C0541do(zzu com_google_android_gms_wearable_internal_zzu, C0378p c0378p, Uri uri, boolean z) {
        this.f1039f = com_google_android_gms_wearable_internal_zzu;
        this.f1037d = uri;
        this.f1038e = z;
        super(c0378p);
    }

    protected void m2141a(ch chVar) throws RemoteException {
        chVar.m2040a((C0502h) this, this.f1039f.zzaiJ, this.f1037d, this.f1038e);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2141a((ch) c0370g);
    }

    public /* synthetic */ C0366w mo2003c(Status status) {
        return m2144d(status);
    }

    public Status m2144d(Status status) {
        return status;
    }
}
