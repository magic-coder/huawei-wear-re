package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.C0356c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.common.internal.zzaf;
import java.util.HashSet;
import java.util.Set;

public class bz extends dp implements C0380r, C0381s {
    private static C0369f<? extends dk, dl> f635a = dg.f686c;
    private final Context f636b;
    private final Handler f637c;
    private final C0369f<? extends dk, dl> f638d;
    private final boolean f639e;
    private Set<Scope> f640f;
    private C0443x f641g;
    private dk f642h;
    private cb f643i;

    @WorkerThread
    public bz(Context context, Handler handler) {
        this.f636b = context;
        this.f637c = handler;
        this.f638d = f635a;
        this.f639e = true;
    }

    @WorkerThread
    public bz(Context context, Handler handler, C0443x c0443x, C0369f<? extends dk, dl> c0369f) {
        this.f636b = context;
        this.f637c = handler;
        this.f641g = c0443x;
        this.f640f = c0443x.m759c();
        this.f638d = c0369f;
        this.f639e = false;
    }

    @WorkerThread
    private void m1123b(zzbaw com_google_android_gms_internal_zzbaw) {
        ConnectionResult zzyh = com_google_android_gms_internal_zzbaw.zzyh();
        if (zzyh.isSuccess()) {
            zzaf zzPU = com_google_android_gms_internal_zzbaw.zzPU();
            ConnectionResult zzyh2 = zzPU.zzyh();
            if (zzyh2.isSuccess()) {
                this.f643i.mo1836a(zzPU.zzyg(), this.f640f);
            } else {
                String valueOf = String.valueOf(zzyh2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                this.f643i.mo1837b(zzyh2);
                this.f642h.m358a();
                return;
            }
        }
        this.f643i.mo1837b(zzyh);
        this.f642h.m358a();
    }

    public dk m1124a() {
        return this.f642h;
    }

    @WorkerThread
    public void mo1828a(int i) {
        this.f642h.m358a();
    }

    @WorkerThread
    public void mo1829a(@Nullable Bundle bundle) {
        this.f642h.mo1867a(this);
    }

    @WorkerThread
    public void mo1830a(@NonNull ConnectionResult connectionResult) {
        this.f643i.mo1837b(connectionResult);
    }

    @WorkerThread
    public void m1128a(cb cbVar) {
        if (this.f642h != null) {
            this.f642h.m358a();
        }
        if (this.f639e) {
            GoogleSignInOptions b = C0356c.m297a(this.f636b).m301b();
            this.f640f = b == null ? new HashSet() : new HashSet(b.zzrj());
            this.f641g = new C0443x(null, this.f640f, null, 0, null, null, null, dl.f693a);
        }
        this.f642h = (dk) this.f638d.mo1854a(this.f636b, this.f637c.getLooper(), this.f641g, this.f641g.m764h(), this, this);
        this.f643i = cbVar;
        this.f642h.mo1869l();
    }

    @BinderThread
    public void mo1826a(zzbaw com_google_android_gms_internal_zzbaw) {
        this.f637c.post(new ca(this, com_google_android_gms_internal_zzbaw));
    }

    public void m1130b() {
        this.f642h.m358a();
    }
}
