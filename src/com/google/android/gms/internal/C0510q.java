package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.internal.C0424f;

public class C0510q implements C0380r, C0381s {
    public final C0367a<?> f804a;
    private final boolean f805b;
    private C0496r f806c;

    public C0510q(C0367a<?> c0367a, boolean z) {
        this.f804a = c0367a;
        this.f805b = z;
    }

    private void m1502a() {
        C0424f.m650a(this.f806c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public void mo1828a(int i) {
        m1502a();
        this.f806c.mo1828a(i);
    }

    public void mo1829a(@Nullable Bundle bundle) {
        m1502a();
        this.f806c.mo1829a(bundle);
    }

    public void mo1830a(@NonNull ConnectionResult connectionResult) {
        m1502a();
        this.f806c.mo1835a(connectionResult, this.f804a, this.f805b);
    }

    public void m1506a(C0496r c0496r) {
        this.f806c = c0496r;
    }
}
