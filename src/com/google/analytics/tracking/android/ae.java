package com.google.analytics.tracking.android;

import java.util.TimerTask;

/* compiled from: GAServiceProxy */
class ae extends TimerTask {
    final /* synthetic */ C3668z f14050a;

    private ae(C3668z c3668z) {
        this.f14050a = c3668z;
    }

    public void run() {
        if (this.f14050a.f14204b == ad.CONNECTED_SERVICE && this.f14050a.f14211i.isEmpty() && this.f14050a.f14203a + this.f14050a.f14221s < this.f14050a.f14220r.mo4232a()) {
            ar.m18268c("Disconnecting due to inactivity");
            this.f14050a.m18396l();
            return;
        }
        this.f14050a.f14215m.schedule(new ae(this.f14050a), this.f14050a.f14221s);
    }
}
