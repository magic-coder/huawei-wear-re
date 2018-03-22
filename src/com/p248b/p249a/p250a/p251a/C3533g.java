package com.p248b.p249a.p250a.p251a;

import android.util.Log;

/* compiled from: GaiaLink */
class C3533g extends Thread {
    final /* synthetic */ C3532f f13346a;

    private C3533g(C3532f c3532f) {
        this.f13346a = c3532f;
    }

    public void run() {
        try {
            this.f13346a.f13330h.cancelDiscovery();
            this.f13346a.f13333k.connect();
            this.f13346a.f13334l = this.f13346a.f13333k.getInputStream();
            this.f13346a.f13335m = new C3535i(this.f13346a);
            this.f13346a.f13335m.start();
        } catch (Exception e) {
            if (this.f13346a.f13327e) {
                Log.e("GaiaLink", "connector: " + e.toString());
            }
            this.f13346a.f13337o.obtainMessage(C3534h.ERROR.ordinal(), e).sendToTarget();
        }
    }
}
