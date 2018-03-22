package com.google.android.gms.internal;

class C0512t implements Runnable {
    final /* synthetic */ C0511s f821a;

    public void run() {
        this.f821a.f819m.lock();
        try {
            this.f821a.m1525h();
        } finally {
            this.f821a.f819m.unlock();
        }
    }
}
