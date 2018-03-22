package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class HandlerPoster extends Handler {
    private final C2695k f9106a = new C2695k();
    private final int f9107b;
    private final C2687c f9108c;
    private boolean f9109d;

    HandlerPoster(C2687c c2687c, Looper looper, int i) {
        super(looper);
        this.f9108c = c2687c;
        this.f9107b = i;
    }

    void m12828a(C2699o c2699o, Object obj) {
        C2694j a = C2694j.m12846a(c2699o, obj);
        synchronized (this) {
            this.f9106a.m12850a(a);
            if (!this.f9109d) {
                this.f9109d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new C2692h("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C2694j a = this.f9106a.m12848a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f9106a.m12848a();
                        if (a == null) {
                            this.f9109d = false;
                            this.f9109d = false;
                            return;
                        }
                    }
                }
                this.f9108c.m12839a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f9107b));
            if (sendMessage(obtainMessage())) {
                this.f9109d = true;
                return;
            }
            throw new C2692h("Could not send handler message");
        } catch (Throwable th) {
            this.f9109d = false;
        }
    }
}
