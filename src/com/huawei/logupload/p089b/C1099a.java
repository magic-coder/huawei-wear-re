package com.huawei.logupload.p089b;

import com.huawei.logupload.p090c.C1103f;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolManager */
public final class C1099a {
    private static final TimeUnit f2260a = TimeUnit.SECONDS;
    private static int f2261b = 3;
    private static int f2262c = 3;
    private static int f2263d = 3600;
    private static int f2264e = 100;
    private static C1099a f2265i = new C1099a();
    private volatile ThreadPoolExecutor f2266f = null;
    private RejectedExecutionHandler f2267g = new DiscardOldestPolicy();
    private BlockingQueue<Runnable> f2268h = new ArrayBlockingQueue(f2264e);

    private C1099a() {
    }

    public static C1099a m4851a() {
        C1099a c1099a;
        synchronized (f2265i) {
            if (f2265i.f2266f == null || f2265i.f2266f.isShutdown()) {
                f2265i.f2266f = new ThreadPoolExecutor(f2261b, f2262c, (long) f2263d, f2260a, f2265i.f2268h, f2265i.f2267g);
            }
            C1103f.m4878b("LogUpload Service", "初始化任务");
            c1099a = f2265i;
        }
        return c1099a;
    }

    public void m4852a(Runnable runnable) {
        C1103f.m4878b("LogUpload Service", "执行任务");
        this.f2266f.execute(runnable);
    }
}
