package com.amap.api.mapcore.util;

/* compiled from: ThreadTask */
public abstract class dv implements Runnable {
    C3319a f11734d;

    /* compiled from: ThreadTask */
    interface C3319a {
        void mo4044a(dv dvVar);

        void mo4045b(dv dvVar);

        void mo4046c(dv dvVar);
    }

    public abstract void mo4042a();

    public final void run() {
        try {
            if (this.f11734d != null) {
                this.f11734d.mo4044a(this);
            }
            if (!Thread.interrupted()) {
                mo4042a();
                if (!Thread.interrupted() && this.f11734d != null) {
                    this.f11734d.mo4045b(this);
                }
            }
        } catch (Throwable th) {
            ca.m15831a(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public final void m16078e() {
        try {
            if (this.f11734d != null) {
                this.f11734d.mo4046c(this);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }
}
