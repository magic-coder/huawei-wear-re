package com.huawei.wallet.logic.down;

import com.huawei.wallet.utils.log.LogC;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadPoolManager {
    private static ThreadPoolManager f21253a = null;
    private static final byte[] f21254c = new byte[0];
    private ExecutorService f21255b = null;

    private ThreadPoolManager() {
        LogC.m28528b("ThreadPoolManager", "ThreadPool init!", false);
        this.f21255b = Executors.newCachedThreadPool();
    }

    public static ThreadPoolManager m28049a() {
        ThreadPoolManager threadPoolManager;
        synchronized (f21254c) {
            if (f21253a == null) {
                f21253a = new ThreadPoolManager();
            }
            threadPoolManager = f21253a;
        }
        return threadPoolManager;
    }

    public void m28050a(Runnable runnable) {
        this.f21255b.execute(runnable);
    }
}
