package com.amap.api.services.core;

/* compiled from: ThreadTask */
public abstract class ax implements Runnable {
    C3391a f12377a;

    /* compiled from: ThreadTask */
    interface C3391a {
        void mo4108a(ax axVar);

        void mo4109b(ax axVar);
    }

    public abstract void mo4122a();

    public final void run() {
        try {
            if (this.f12377a != null) {
                this.f12377a.mo4108a(this);
            }
            if (!Thread.interrupted()) {
                mo4122a();
                if (!Thread.interrupted() && this.f12377a != null) {
                    this.f12377a.mo4109b(this);
                }
            }
        } catch (Throwable th) {
            ay.m16709a(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
