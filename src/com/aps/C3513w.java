package com.aps;

import android.os.Looper;
import java.util.List;

final class C3513w extends Thread {
    final /* synthetic */ bz f13239a;

    C3513w(bz bzVar, String str) {
        this.f13239a = bzVar;
        super(str);
    }

    public final void run() {
        try {
            Looper.prepare();
            this.f13239a.f13112B = Looper.myLooper();
            this.f13239a.f13115E = new C3514x(this.f13239a);
            try {
                this.f13239a.f13134s.addGpsStatusListener(this.f13239a.f13115E);
                this.f13239a.f13134s.addNmeaListener(this.f13239a.f13115E);
            } catch (Exception e) {
            }
            this.f13239a.f13116F = new au(this);
            List allProviders = this.f13239a.f13134s.getAllProviders();
            if (allProviders != null && allProviders.contains("gps")) {
                allProviders.contains("passive");
            }
            try {
                this.f13239a.f13134s.requestLocationUpdates("passive", 1000, (float) bz.f13103c, this.f13239a.f13118H);
            } catch (Exception e2) {
            }
            Looper.loop();
        } catch (Exception e3) {
        }
    }
}
