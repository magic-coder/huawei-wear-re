package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0378p;

class cf implements Runnable {
    final /* synthetic */ C0366w f657a;
    final /* synthetic */ zzabx f658b;

    cf(zzabx com_google_android_gms_internal_zzabx, C0366w c0366w) {
        this.f658b = com_google_android_gms_internal_zzabx;
        this.f657a = c0366w;
    }

    @WorkerThread
    public void run() {
        C0378p c0378p;
        try {
            C0501m.f781a.set(Boolean.valueOf(true));
            this.f658b.f903h.sendMessage(this.f658b.f903h.obtainMessage(0, this.f658b.f896a.m412a(this.f657a)));
            C0501m.f781a.set(Boolean.valueOf(false));
            this.f658b.m1646b(this.f657a);
            c0378p = (C0378p) this.f658b.f902g.get();
            if (c0378p != null) {
                c0378p.mo1842b(this.f658b);
            }
        } catch (RuntimeException e) {
            this.f658b.f903h.sendMessage(this.f658b.f903h.obtainMessage(1, e));
            C0501m.f781a.set(Boolean.valueOf(false));
            this.f658b.m1646b(this.f657a);
            c0378p = (C0378p) this.f658b.f902g.get();
            if (c0378p != null) {
                c0378p.mo1842b(this.f658b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            C0501m.f781a.set(Boolean.valueOf(false));
            this.f658b.m1646b(this.f657a);
            c0378p = (C0378p) this.f658b.f902g.get();
            if (c0378p != null) {
                c0378p.mo1842b(this.f658b);
            }
        }
    }
}
