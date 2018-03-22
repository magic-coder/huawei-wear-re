package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class C0432q<TListener> {
    private TListener f434a;
    private boolean f435b = false;
    final /* synthetic */ zzf f436d;

    public C0432q(zzf com_google_android_gms_common_internal_zzf, TListener tListener) {
        this.f436d = com_google_android_gms_common_internal_zzf;
        this.f434a = tListener;
    }

    protected abstract void mo1776a(TListener tListener);

    public void m683b() {
        synchronized (this) {
            Object obj = this.f434a;
            if (this.f435b) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (obj != null) {
            try {
                mo1776a(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.f435b = true;
        }
        m684c();
    }

    public void m684c() {
        m685d();
        synchronized (this.f436d.f381r) {
            this.f436d.f381r.remove(this);
        }
    }

    public void m685d() {
        synchronized (this) {
            this.f434a = null;
        }
    }
}
