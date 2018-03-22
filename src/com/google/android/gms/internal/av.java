package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class av extends bi {
    private WeakReference<zzaat> f568a;

    av(zzaat com_google_android_gms_internal_zzaat) {
        this.f568a = new WeakReference(com_google_android_gms_internal_zzaat);
    }

    public void mo1833a() {
        zzaat com_google_android_gms_internal_zzaat = (zzaat) this.f568a.get();
        if (com_google_android_gms_internal_zzaat != null) {
            com_google_android_gms_internal_zzaat.m1588o();
        }
    }
}
