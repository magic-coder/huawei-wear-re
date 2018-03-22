package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ab;
import com.google.android.gms.p015b.C0359c;

abstract class ev extends eu {
    protected final C0359c<Void> f774b;

    public ev(int i, C0359c<Void> c0359c) {
        super(i);
        this.f774b = c0359c;
    }

    public void mo1876a(@NonNull Status status) {
        this.f774b.m311b(new ab(status));
    }

    public void mo1877a(@NonNull ab abVar, boolean z) {
    }

    public final void mo1878a(bb<?> bbVar) throws DeadObjectException {
        try {
            mo1879b(bbVar);
        } catch (RemoteException e) {
            mo1876a(eu.m1453b(e));
            throw e;
        } catch (RemoteException e2) {
            mo1876a(eu.m1453b(e2));
        }
    }

    protected abstract void mo1879b(bb<?> bbVar) throws RemoteException;
}
