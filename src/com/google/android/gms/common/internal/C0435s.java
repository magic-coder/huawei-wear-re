package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public final class C0435s extends av {
    private zzf f440a;
    private final int f441b;

    public C0435s(@NonNull zzf com_google_android_gms_common_internal_zzf, int i) {
        this.f440a = com_google_android_gms_common_internal_zzf;
        this.f441b = i;
    }

    private void m691a() {
        this.f440a = null;
    }

    @BinderThread
    public void mo1768a(int i, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @BinderThread
    public void mo1769a(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        C0424f.m650a(this.f440a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.f440a.mo2009a(i, iBinder, bundle, this.f441b);
        m691a();
    }
}
