package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.zzabh;

final class C0566x<T> extends da<Status> {
    private T f1073d;
    private zzabh<T> f1074e;
    private C0537y<T> f1075f;

    private C0566x(C0378p c0378p, T t, zzabh<T> com_google_android_gms_internal_zzabh_T, C0537y<T> c0537y) {
        super(c0378p);
        this.f1073d = C0424f.m649a((Object) t);
        this.f1074e = (zzabh) C0424f.m649a((Object) com_google_android_gms_internal_zzabh_T);
        this.f1075f = (C0537y) C0424f.m649a((Object) c0537y);
    }

    static <T> C0382t<Status> m2218a(C0378p c0378p, C0537y<T> c0537y, T t) {
        return c0378p.mo1839a(new C0566x(c0378p, t, c0378p.mo1897a((Object) t), c0537y));
    }

    protected void m2219a(ch chVar) throws RemoteException {
        this.f1075f.mo2007a(chVar, this, this.f1073d, this.f1074e);
        this.f1073d = null;
        this.f1074e = null;
    }

    protected /* synthetic */ void mo2002b(C0370g c0370g) throws RemoteException {
        m2219a((ch) c0370g);
    }

    protected /* synthetic */ C0366w mo2003c(Status status) {
        return m2222d(status);
    }

    protected Status m2222d(Status status) {
        this.f1073d = null;
        this.f1074e = null;
        return status;
    }
}
