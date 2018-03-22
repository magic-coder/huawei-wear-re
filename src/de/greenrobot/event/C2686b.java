package de.greenrobot.event;

import android.util.Log;

/* compiled from: BackgroundPoster */
final class C2686b implements Runnable {
    private final C2695k f9112a = new C2695k();
    private volatile boolean f9113b;
    private final C2687c f9114c;

    C2686b(C2687c c2687c) {
        this.f9114c = c2687c;
    }

    public void m12830a(C2699o c2699o, Object obj) {
        C2694j a = C2694j.m12846a(c2699o, obj);
        synchronized (this) {
            this.f9112a.m12850a(a);
            if (!this.f9113b) {
                this.f9113b = true;
                C2687c.f9115a.execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                C2694j a = this.f9112a.m12849a(1000);
                if (a == null) {
                    synchronized (this) {
                        a = this.f9112a.m12848a();
                        if (a == null) {
                            this.f9113b = false;
                            this.f9113b = false;
                            return;
                        }
                    }
                }
                this.f9114c.m12839a(a);
            } catch (Throwable e) {
                Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                this.f9113b = false;
                return;
            } catch (Throwable th) {
                this.f9113b = false;
            }
        }
    }
}
