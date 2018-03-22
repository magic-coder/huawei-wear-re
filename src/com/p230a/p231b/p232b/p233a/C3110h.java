package com.p230a.p231b.p232b.p233a;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class C3110h extends Thread {
    private final BlockingQueue f10427a;
    private final C3085g f10428b;
    private final C3088b f10429c;
    private final C3108s f10430d;
    private volatile boolean f10431e = false;

    public C3110h(BlockingQueue blockingQueue, C3085g c3085g, C3088b c3088b, C3108s c3108s) {
        this.f10427a = blockingQueue;
        this.f10428b = c3085g;
        this.f10429c = c3088b;
        this.f10430d = c3108s;
    }

    public void m13861a() {
        this.f10431e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(-2);
        while (true) {
            try {
                C3115m c3115m = (C3115m) this.f10427a.take();
                try {
                    c3115m.m13873a("network-queue-take");
                    if (c3115m.m13884i()) {
                        c3115m.m13877b("network-discard-cancelled");
                    } else {
                        if (VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(c3115m.m13880e());
                        }
                        C3112j a = this.f10428b.mo3651a(c3115m);
                        c3115m.m13873a("network-http-complete");
                        if (a.f10435d && c3115m.m13896u()) {
                            c3115m.m13877b("not-modified");
                        } else {
                            C3118p a2 = c3115m.mo3662a(a);
                            c3115m.m13873a("network-parse-complete");
                            if (c3115m.m13891p() && a2.f10466b != null) {
                                this.f10429c.mo3654a(c3115m.m13882g(), a2.f10466b);
                                c3115m.m13873a("network-cache-written");
                            }
                            c3115m.m13895t();
                            this.f10430d.mo3659a(c3115m, a2);
                        }
                    }
                } catch (C3102w e) {
                    this.f10430d.mo3661a(c3115m, c3115m.m13866a(e));
                } catch (Throwable e2) {
                    C3121x.m13906a(e2, "Unhandled exception %s", e2.toString());
                    this.f10430d.mo3661a(c3115m, new C3102w(e2));
                }
            } catch (InterruptedException e3) {
                if (this.f10431e) {
                    return;
                }
            }
        }
    }
}
