package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.C0344b;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.ad;

public class bh<O extends C0344b> extends ae {
    private final ad<O> f616a;

    public bh(ad<O> adVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f616a = adVar;
    }

    public Looper mo1838a() {
        return this.f616a.m347d();
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1839a(@NonNull T t) {
        return this.f616a.m343a(t);
    }

    public void mo1840a(zzabx com_google_android_gms_internal_zzabx) {
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1841b(@NonNull T t) {
        return this.f616a.m345b(t);
    }

    public void mo1842b(zzabx com_google_android_gms_internal_zzabx) {
    }
}
