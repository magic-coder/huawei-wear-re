package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;

class dp extends da<Status> {
    final /* synthetic */ Uri f1040d;
    final /* synthetic */ long f1041e;
    final /* synthetic */ long f1042f;
    final /* synthetic */ zzu f1043g;

    dp(zzu com_google_android_gms_wearable_internal_zzu, C0378p c0378p, Uri uri, long j, long j2) {
        this.f1043g = com_google_android_gms_wearable_internal_zzu;
        this.f1040d = uri;
        this.f1041e = j;
        this.f1042f = j2;
        super(c0378p);
    }

    protected void m2145a(ch chVar) throws RemoteException {
        chVar.m2039a((C0502h) this, this.f1043g.zzaiJ, this.f1040d, this.f1041e, this.f1042f);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2145a((ch) c0370g);
    }

    public /* synthetic */ C0366w mo2003c(Status status) {
        return m2148d(status);
    }

    public Status m2148d(Status status) {
        return status;
    }
}
