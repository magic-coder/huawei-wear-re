package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;

class be implements Runnable {
    final /* synthetic */ ConnectionResult f606a;
    final /* synthetic */ bb f607b;

    be(bb bbVar, ConnectionResult connectionResult) {
        this.f607b = bbVar;
        this.f606a = connectionResult;
    }

    public void run() {
        this.f607b.mo1830a(this.f606a);
    }
}
