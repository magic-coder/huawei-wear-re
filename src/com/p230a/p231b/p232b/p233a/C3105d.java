package com.p230a.p231b.p232b.p233a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class C3105d extends Thread {
    private static final boolean f10416a = C3121x.f10470b;
    private final BlockingQueue f10417b;
    private final BlockingQueue f10418c;
    private final C3088b f10419d;
    private final C3108s f10420e;
    private volatile boolean f10421f = false;

    public C3105d(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, C3088b c3088b, C3108s c3108s) {
        this.f10417b = blockingQueue;
        this.f10418c = blockingQueue2;
        this.f10419d = c3088b;
        this.f10420e = c3108s;
    }

    public void m13847a() {
        this.f10421f = true;
        interrupt();
    }

    public void run() {
        if (f10416a) {
            C3121x.m13905a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f10419d.mo3653a();
        while (true) {
            try {
                C3115m c3115m = (C3115m) this.f10417b.take();
                c3115m.m13873a("cache-queue-take");
                if (c3115m.m13884i()) {
                    c3115m.m13877b("cache-discard-canceled");
                } else {
                    C3104c a = this.f10419d.mo3652a(c3115m.m13882g());
                    if (a == null) {
                        c3115m.m13873a("cache-miss");
                        this.f10418c.put(c3115m);
                    } else if (a.m13844a()) {
                        c3115m.m13873a("cache-hit-expired");
                        c3115m.m13869a(a);
                        this.f10418c.put(c3115m);
                    } else {
                        c3115m.m13873a("cache-hit");
                        C3118p a2 = c3115m.mo3662a(new C3112j(a.f10410a, a.f10415f));
                        c3115m.m13873a("cache-hit-parsed");
                        if (a.m13845b()) {
                            c3115m.m13873a("cache-hit-refresh-needed");
                            c3115m.m13869a(a);
                            a2.f10468d = true;
                            this.f10420e.mo3660a(c3115m, a2, new C3122y(this, c3115m));
                        } else {
                            this.f10420e.mo3659a(c3115m, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f10421f) {
                    return;
                }
            }
        }
    }
}
