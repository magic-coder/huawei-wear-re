package com.google.analytics.tracking.android;

/* compiled from: ClientIdDefaultProvider */
class C3659k extends Thread {
    final /* synthetic */ C3658j f14191a;

    C3659k(C3658j c3658j, String str) {
        this.f14191a = c3658j;
        super(str);
    }

    public void run() {
        synchronized (this.f14191a.f14190f) {
            this.f14191a.f14188d = this.f14191a.m18366c();
            this.f14191a.f14189e = true;
            this.f14191a.f14190f.notifyAll();
        }
    }
}
