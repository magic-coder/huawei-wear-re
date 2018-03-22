package com.huawei.phoneserviceuni.common.p132d.p496b;

import com.huawei.phoneserviceuni.common.d.c;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolManager */
public final class C5766a {
    private static final TimeUnit f19546a = TimeUnit.SECONDS;
    private static int f19547b = 2;
    private static int f19548c = 5;
    private static int f19549d = 3600;
    private static int f19550e = ((f19547b + f19548c) / 2);
    private static C5766a f19551i = new C5766a();
    private volatile ThreadPoolExecutor f19552f = null;
    private RejectedExecutionHandler f19553g = new DiscardOldestPolicy();
    private BlockingQueue<Runnable> f19554h = new ArrayBlockingQueue(f19550e);

    private C5766a() {
    }

    public static C5766a m26469a() {
        C5766a c5766a;
        synchronized (f19551i) {
            if (f19551i.f19552f == null || f19551i.f19552f.isShutdown()) {
                try {
                    f19551i.f19552f = new ThreadPoolExecutor(f19547b, f19548c, (long) f19549d, f19546a, f19551i.f19554h, f19551i.f19553g);
                } catch (Exception e) {
                    c.a(e, "ThreadPoolManager");
                }
            }
            c5766a = f19551i;
        }
        return c5766a;
    }

    public void m26470a(Runnable runnable) {
        if (this.f19552f != null && runnable != null) {
            try {
                this.f19552f.execute(runnable);
            } catch (Exception e) {
                c.a(e, "ThreadPoolManager");
            }
        }
    }
}
