package com.google.android.gms.internal;

class bp implements Runnable {
    final /* synthetic */ bm f622a;
    final /* synthetic */ String f623b;
    final /* synthetic */ bo f624c;

    bp(bo boVar, bm bmVar, String str) {
        this.f624c = boVar;
        this.f622a = bmVar;
        this.f623b = str;
    }

    public void run() {
        if (this.f624c.f620c >= 1) {
            this.f622a.mo1797a(this.f624c.f621d != null ? this.f624c.f621d.getBundle(this.f623b) : null);
        }
        if (this.f624c.f620c >= 2) {
            this.f622a.mo1795a();
        }
        if (this.f624c.f620c >= 3) {
            this.f622a.mo1798b();
        }
        if (this.f624c.f620c >= 4) {
            this.f622a.m858g();
        }
    }
}
