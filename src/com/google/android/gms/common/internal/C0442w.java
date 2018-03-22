package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class C0442w extends C0433n {
    final /* synthetic */ zzf f447e;

    @BinderThread
    public C0442w(zzf com_google_android_gms_common_internal_zzf, int i, @Nullable Bundle bundle) {
        this.f447e = com_google_android_gms_common_internal_zzf;
        super(com_google_android_gms_common_internal_zzf, i, bundle);
    }

    protected void mo1778a(ConnectionResult connectionResult) {
        this.f447e.f366b.mo1777a(connectionResult);
        this.f447e.m544a(connectionResult);
    }

    protected boolean mo1779a() {
        this.f447e.f366b.mo1777a(ConnectionResult.zzayj);
        return true;
    }
}
