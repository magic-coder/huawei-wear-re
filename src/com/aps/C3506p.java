package com.aps;

import android.os.Looper;
import java.util.Timer;

final class C3506p extends Thread {
    private /* synthetic */ C3505o f13233a;

    C3506p(C3505o c3505o, String str) {
        this.f13233a = c3505o;
        super(str);
    }

    public final void run() {
        try {
            Looper.prepare();
            this.f13233a.f13207C = Looper.myLooper();
            this.f13233a.f13205A = new Timer();
            this.f13233a.f13228v = new C3507q(this.f13233a);
            C3505o.m17571a(this.f13233a, this.f13233a.f13228v);
            this.f13233a.f13229w = new C3508r(this.f13233a);
            try {
                C3505o.m17570a(this.f13233a, this.f13233a.f13229w);
            } catch (Exception e) {
            }
            Looper.loop();
        } catch (Exception e2) {
        }
    }
}
