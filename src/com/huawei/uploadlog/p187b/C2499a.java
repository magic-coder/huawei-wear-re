package com.huawei.uploadlog.p187b;

import com.huawei.uploadlog.p188c.C2511g;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolManager */
public final class C2499a {
    private static final TimeUnit f8970a = TimeUnit.SECONDS;
    private static int f8971b = 3;
    private static int f8972c = 3;
    private static int f8973d = 3600;
    private static int f8974e = 100;
    private static C2499a f8975i = new C2499a();
    private volatile ThreadPoolExecutor f8976f = null;
    private RejectedExecutionHandler f8977g = new DiscardOldestPolicy();
    private BlockingQueue<Runnable> f8978h = new ArrayBlockingQueue(f8974e);

    private C2499a() {
    }

    public static C2499a m12430a() {
        C2499a c2499a;
        synchronized (f8975i) {
            if (f8975i.f8976f == null || f8975i.f8976f.isShutdown()) {
                f8975i.f8976f = new ThreadPoolExecutor(f8971b, f8972c, (long) f8973d, f8970a, f8975i.f8978h, f8975i.f8977g);
            }
            C2511g.m12481b("LogUpload Service", "初始化任务");
            c2499a = f8975i;
        }
        return c2499a;
    }

    public void m12431a(Runnable runnable) {
        C2511g.m12481b("LogUpload Service", "执行任务");
        this.f8976f.execute(runnable);
    }
}
