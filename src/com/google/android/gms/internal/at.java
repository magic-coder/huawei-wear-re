package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0370g;
import java.util.Collections;

public class at implements aw {
    private final zzaav f566a;

    public at(zzaav com_google_android_gms_internal_zzaav) {
        this.f566a = com_google_android_gms_internal_zzaav;
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1813a(T t) {
        this.f566a.f880g.f848a.add(t);
        return t;
    }

    public void mo1814a() {
        this.f566a.m1633h();
        this.f566a.f880g.f851d = Collections.emptySet();
    }

    public void mo1815a(int i) {
    }

    public void mo1816a(Bundle bundle) {
    }

    public void mo1817a(ConnectionResult connectionResult, C0367a<?> c0367a, boolean z) {
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1818b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean mo1819b() {
        return true;
    }

    public void mo1820c() {
        this.f566a.m1631f();
    }
}
