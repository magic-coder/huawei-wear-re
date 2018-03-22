package com.google.android.gms.internal;

class ce implements Runnable {
    final /* synthetic */ bm f654a;
    final /* synthetic */ String f655b;
    final /* synthetic */ cd f656c;

    ce(cd cdVar, bm bmVar, String str) {
        this.f656c = cdVar;
        this.f654a = bmVar;
        this.f655b = str;
    }

    public void run() {
        if (this.f656c.f652c >= 1) {
            this.f654a.mo1797a(this.f656c.f653d != null ? this.f656c.f653d.getBundle(this.f655b) : null);
        }
        if (this.f656c.f652c >= 2) {
            this.f654a.mo1795a();
        }
        if (this.f656c.f652c >= 3) {
            this.f654a.mo1798b();
        }
        if (this.f656c.f652c >= 4) {
            this.f654a.m858g();
        }
    }
}
