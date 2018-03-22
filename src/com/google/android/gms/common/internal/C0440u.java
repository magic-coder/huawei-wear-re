package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;

public class C0440u implements C0434r {
    final /* synthetic */ zzf f444a;

    public C0440u(zzf com_google_android_gms_common_internal_zzf) {
        this.f444a = com_google_android_gms_common_internal_zzf;
    }

    public void mo1777a(@NonNull ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            this.f444a.m545a(null, this.f444a.mo1761w());
        } else if (this.f444a.f385v != null) {
            this.f444a.f385v.mo1764a(connectionResult);
        }
    }
}
