package com.amap.api.location;

import android.location.GpsStatus.Listener;

/* compiled from: IGPSManager */
class C3199g implements Listener {
    final /* synthetic */ C3196d f10721a;

    C3199g(C3196d c3196d) {
        this.f10721a = c3196d;
    }

    public void onGpsStatusChanged(int i) {
        this.f10721a.m14166a(i, this.f10721a.f10712a.getGpsStatus(null));
    }
}
