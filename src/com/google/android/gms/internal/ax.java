package com.google.android.gms.internal;

abstract class ax {
    private final aw f526a;

    protected ax(aw awVar) {
        this.f526a = awVar;
    }

    protected abstract void mo1821a();

    public final void m920a(zzaav com_google_android_gms_internal_zzaav) {
        com_google_android_gms_internal_zzaav.f882i.lock();
        try {
            if (com_google_android_gms_internal_zzaav.f887n == this.f526a) {
                mo1821a();
                com_google_android_gms_internal_zzaav.f882i.unlock();
            }
        } finally {
            com_google_android_gms_internal_zzaav.f882i.unlock();
        }
    }
}
