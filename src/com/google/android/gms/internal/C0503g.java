package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0371h;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;

public abstract class C0503g<R extends C0366w, A extends C0370g> extends C0501m<R> implements C0502h<R> {
    private final C0371h<A> f798d;
    private final C0367a<?> f799e;

    protected C0503g(C0367a<?> c0367a, C0378p c0378p) {
        super((C0378p) C0424f.m650a((Object) c0378p, (Object) "GoogleApiClient must not be null"));
        this.f798d = c0367a.m335c();
        this.f799e = c0367a;
    }

    private void m1490a(RemoteException remoteException) {
        mo1880a(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public final void mo1880a(Status status) {
        C0424f.m658b(!status.isSuccess(), "Failed result must not be success");
        m1477a(mo2003c(status));
    }

    public final void m1492a(A a) throws DeadObjectException {
        try {
            mo2002b(a);
        } catch (RemoteException e) {
            m1490a(e);
            throw e;
        } catch (RemoteException e2) {
            m1490a(e2);
        }
    }

    public /* synthetic */ void mo1881a(Object obj) {
        super.m1477a((C0366w) obj);
    }

    public final C0371h<A> mo1882b() {
        return this.f798d;
    }

    protected abstract void mo2002b(A a) throws RemoteException;

    public final C0367a<?> mo1883c() {
        return this.f799e;
    }
}
