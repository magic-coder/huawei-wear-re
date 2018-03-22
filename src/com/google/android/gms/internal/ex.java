package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ab;
import com.google.android.gms.p015b.C0359c;

public final class ex extends ev {
    public final bq<?> f776c;

    public ex(bq<?> bqVar, C0359c<Void> c0359c) {
        super(4, c0359c);
        this.f776c = bqVar;
    }

    public /* bridge */ /* synthetic */ void mo1876a(@NonNull Status status) {
        super.mo1876a(status);
    }

    public /* bridge */ /* synthetic */ void mo1877a(@NonNull ab abVar, boolean z) {
        super.mo1877a(abVar, z);
    }

    public void mo1879b(bb<?> bbVar) throws RemoteException {
        bv bvVar = (bv) bbVar.m1058c().remove(this.f776c);
        if (bvVar != null) {
            bvVar.f632a.m1114a();
            return;
        }
        Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
        this.b.m311b(new ab(Status.zzazz));
    }
}
