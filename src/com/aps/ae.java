package com.aps;

import java.util.TimerTask;

/* compiled from: APS */
class ae extends TimerTask {
    final /* synthetic */ int f12890a;
    final /* synthetic */ ac f12891b;

    ae(ac acVar, int i) {
        this.f12891b = acVar;
        this.f12890a = i;
    }

    public void run() {
        try {
            if (this.f12891b.m17243n()) {
                this.f12891b.m17225d(this.f12890a);
                if (!this.f12891b.m17269e()) {
                    this.f12891b.m17252w();
                    return;
                }
                return;
            }
            this.f12891b.m17252w();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
