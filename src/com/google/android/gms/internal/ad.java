package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.C0456a;

public class ad extends C0492i {
    private final C0456a<ez<?>> f521e;
    private az f522f;

    public void mo1795a() {
        super.mo1795a();
        if (!this.f521e.isEmpty()) {
            this.f522f.m1027a(this);
        }
    }

    protected void mo1800a(ConnectionResult connectionResult, int i) {
        this.f522f.m1030b(connectionResult, i);
    }

    public void mo1798b() {
        super.mo1798b();
        this.f522f.m1031b(this);
    }

    protected void mo1802c() {
        this.f522f.m1032c();
    }

    C0456a<ez<?>> m891e() {
        return this.f521e;
    }
}
