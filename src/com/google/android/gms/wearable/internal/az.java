package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.wearable.C0535v;

class az extends da<C0535v> {
    final /* synthetic */ String f962d;
    final /* synthetic */ String f963e;
    final /* synthetic */ byte[] f964f;

    az(ay ayVar, C0378p c0378p, String str, String str2, byte[] bArr) {
        this.f962d = str;
        this.f963e = str2;
        this.f964f = bArr;
        super(c0378p);
    }

    protected void m1949a(ch chVar) throws RemoteException {
        chVar.m2041a((C0502h) this, this.f962d, this.f963e, this.f964f);
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m1949a((ch) c0370g);
    }

    protected /* synthetic */ C0366w mo2003c(Status status) {
        return m1952d(status);
    }

    protected C0535v m1952d(Status status) {
        return new ba(status, -1);
    }
}
