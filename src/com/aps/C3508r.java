package com.aps;

import android.location.GpsStatus.NmeaListener;

final class C3508r implements NmeaListener {
    private /* synthetic */ C3505o f13235a;

    private C3508r(C3505o c3505o) {
        this.f13235a = c3505o;
    }

    public final void onNmeaReceived(long j, String str) {
        try {
            this.f13235a.f13219l = j;
            this.f13235a.f13220m = str;
        } catch (Exception e) {
        }
    }
}
