package com.huawei.hwcommonmodel.p064d;

import com.huawei.p190v.C2538c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolUtils */
public class C4732k {
    private static int f17279a = 5;
    private static int f17280b = 30;
    private static int f17281c = 35;
    private static BlockingQueue<Runnable> f17282d = new SynchronousQueue();
    private static ThreadFactory f17283e = new C4733l();
    private static ThreadPoolExecutor f17284f = new ThreadPoolExecutor(f17279a, f17280b, (long) f17281c, TimeUnit.SECONDS, f17282d, f17283e, new AbortPolicy());

    public static int m22635a(Runnable runnable) {
        try {
            f17284f.execute(runnable);
            C2538c.c("ThreadPoolUtils", new Object[]{"ThreadPool.getActiveCount = ", String.valueOf(f17284f.getActiveCount())});
            C2538c.c("ThreadPoolUtils", new Object[]{"ThreadPool.getPoolSize = ", String.valueOf(f17284f.getPoolSize())});
            C2538c.c("ThreadPoolUtils", new Object[]{"ThreadPool.getTaskCount = ", String.valueOf(f17284f.getTaskCount())});
            return 0;
        } catch (RejectedExecutionException e) {
            C2538c.c("ThreadPoolUtils", new Object[]{"ThreadPool is  rejected. e = " + e.getMessage()});
            try {
                Executors.newSingleThreadExecutor().execute(runnable);
                return 0;
            } catch (RejectedExecutionException e2) {
                C2538c.c("ThreadPoolUtils", new Object[]{"SingleThreadExecutor is  rejected. e = " + e2.getMessage()});
                return -1;
            }
        }
    }
}
