package com.huawei.pluginkidwatch.common.lib.p145d;

import com.huawei.p190v.C2538c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolUtils */
public class C1477j {
    private static int f3440a = 5;
    private static int f3441b = 20;
    private static int f3442c = 30;
    private static BlockingQueue<Runnable> f3443d = new SynchronousQueue();
    private static ThreadFactory f3444e = new C1478k();
    private static ThreadPoolExecutor f3445f = new ThreadPoolExecutor(f3440a, f3441b, (long) f3442c, TimeUnit.SECONDS, f3443d, f3444e, new AbortPolicy());

    public static ThreadPoolExecutor m6804a() {
        if (f3445f == null) {
            C2538c.m12674b("ThreadPoolUtils", "ThreadPoolExecutor is null ");
        } else {
            C2538c.m12674b("ThreadPoolUtils", "ThreadPoolExecutor != null ");
        }
        return f3445f;
    }
}
