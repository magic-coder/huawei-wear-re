package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0428j;

public class af implements aw {
    private final zzaav f524a;
    private boolean f525b = false;

    public af(zzaav com_google_android_gms_internal_zzaav) {
        this.f524a = com_google_android_gms_internal_zzaav;
    }

    private <A extends C0370g> void m909c(C0503g<? extends C0366w, A> c0503g) throws DeadObjectException {
        this.f524a.f880g.f856i.m1146a((C0501m) c0503g);
        C0370g a = this.f524a.f880g.m1591a(c0503g.mo1882b());
        if (a.m362b() || !this.f524a.f875b.containsKey(c0503g.mo1882b())) {
            if (a instanceof C0428j) {
                a = ((C0428j) a).mo1775k();
            }
            c0503g.m1492a(a);
            return;
        }
        c0503g.mo1880a(new Status(17));
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1813a(T t) {
        return mo1818b(t);
    }

    public void mo1814a() {
    }

    public void mo1815a(int i) {
        this.f524a.m1621a(null);
        this.f524a.f881h.mo1892a(i, this.f525b);
    }

    public void mo1816a(Bundle bundle) {
    }

    public void mo1817a(ConnectionResult connectionResult, C0367a<?> c0367a, boolean z) {
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1818b(T t) {
        try {
            m909c(t);
        } catch (DeadObjectException e) {
            this.f524a.m1623a(new ag(this, this));
        }
        return t;
    }

    public boolean mo1819b() {
        if (this.f525b) {
            return false;
        }
        if (this.f524a.f880g.m1612k()) {
            this.f525b = true;
            for (zzabx a : this.f524a.f880g.f855h) {
                a.m1651a();
            }
            return false;
        }
        this.f524a.m1621a(null);
        return true;
    }

    public void mo1820c() {
        if (this.f525b) {
            this.f525b = false;
            this.f524a.m1623a(new ah(this, this));
        }
    }

    void m918d() {
        if (this.f525b) {
            this.f525b = false;
            this.f524a.f880g.f856i.m1145a();
            mo1819b();
        }
    }
}
