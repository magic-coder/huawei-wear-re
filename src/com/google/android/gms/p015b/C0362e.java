package com.google.android.gms.p015b;

class C0362e implements Runnable {
    final /* synthetic */ C0358b f252a;
    final /* synthetic */ C0361d f253b;

    C0362e(C0361d c0361d, C0358b c0358b) {
        this.f253b = c0361d;
        this.f252a = c0358b;
    }

    public void run() {
        synchronized (this.f253b.f250b) {
            if (this.f253b.f251c != null) {
                this.f253b.f251c.mo1803a(this.f252a);
            }
        }
    }
}
