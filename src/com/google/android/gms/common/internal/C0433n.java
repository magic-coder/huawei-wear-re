package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import com.google.android.gms.common.ConnectionResult;

abstract class C0433n extends C0432q<Boolean> {
    public final int f437a;
    public final Bundle f438b;
    final /* synthetic */ zzf f439c;

    @BinderThread
    protected C0433n(zzf com_google_android_gms_common_internal_zzf, int i, Bundle bundle) {
        this.f439c = com_google_android_gms_common_internal_zzf;
        super(com_google_android_gms_common_internal_zzf, Boolean.valueOf(true));
        this.f437a = i;
        this.f438b = bundle;
    }

    protected abstract void mo1778a(ConnectionResult connectionResult);

    protected void m687a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.f439c.m529a(1, null);
            return;
        }
        switch (this.f437a) {
            case 0:
                if (!mo1779a()) {
                    this.f439c.m529a(1, null);
                    mo1778a(new ConnectionResult(8, null));
                    return;
                }
                return;
            case 10:
                this.f439c.m529a(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.f439c.m529a(1, null);
                if (this.f438b != null) {
                    pendingIntent = (PendingIntent) this.f438b.getParcelable("pendingIntent");
                }
                mo1778a(new ConnectionResult(this.f437a, pendingIntent));
                return;
        }
    }

    protected /* synthetic */ void mo1776a(Object obj) {
        m687a((Boolean) obj);
    }

    protected abstract boolean mo1779a();
}
