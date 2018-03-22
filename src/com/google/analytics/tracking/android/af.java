package com.google.analytics.tracking.android;

import java.util.TimerTask;

/* compiled from: GAServiceProxy */
class af extends TimerTask {
    final /* synthetic */ C3668z f14051a;

    private af(C3668z c3668z) {
        this.f14051a = c3668z;
    }

    public void run() {
        if (this.f14051a.f14204b == ad.CONNECTING) {
            this.f14051a.m18394j();
        }
    }
}
