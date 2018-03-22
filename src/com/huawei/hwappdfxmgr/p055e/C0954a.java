package com.huawei.hwappdfxmgr.p055e;

import com.huawei.p190v.C2538c;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolManager */
public final class C0954a {
    private static final TimeUnit f1550a = TimeUnit.SECONDS;
    private static int f1551b = 3;
    private static int f1552c = 3;
    private static int f1553d = 3600;
    private static int f1554e = 20;
    private static C0954a f1555i = new C0954a();
    private volatile ThreadPoolExecutor f1556f = null;
    private RejectedExecutionHandler f1557g = new DiscardOldestPolicy();
    private BlockingQueue<Runnable> f1558h = new ArrayBlockingQueue(f1554e);

    private C0954a() {
    }

    public static C0954a m3337a() {
        C0954a c0954a;
        synchronized (f1555i) {
            if (f1555i.f1556f == null || f1555i.f1556f.isShutdown()) {
                f1555i.f1556f = new ThreadPoolExecutor(f1551b, f1552c, (long) f1553d, f1550a, f1555i.f1558h, f1555i.f1557g);
            }
            C2538c.m12674b("ThreadPoolManager", "初始化任务");
            c0954a = f1555i;
        }
        return c0954a;
    }

    public void m3338a(Runnable runnable) {
        C2538c.m12674b("ThreadPoolManager", "执行任务");
        this.f1556f.execute(runnable);
    }
}
