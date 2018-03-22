package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.ae;
import java.lang.ref.WeakReference;

class ci implements DeathRecipient, cj {
    private final WeakReference<C0501m<?>> f665a;
    private final WeakReference<ae> f666b;
    private final WeakReference<IBinder> f667c;

    private ci(C0501m<?> c0501m, ae aeVar, IBinder iBinder) {
        this.f666b = new WeakReference(aeVar);
        this.f665a = new WeakReference(c0501m);
        this.f667c = new WeakReference(iBinder);
    }

    private void m1151a() {
        C0501m c0501m = (C0501m) this.f665a.get();
        ae aeVar = (ae) this.f666b.get();
        if (!(aeVar == null || c0501m == null)) {
            aeVar.m348a(c0501m.mo1847a().intValue());
        }
        IBinder iBinder = (IBinder) this.f667c.get();
        if (iBinder != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    public void mo1853a(C0501m<?> c0501m) {
        m1151a();
    }

    public void binderDied() {
        m1151a();
    }
}
