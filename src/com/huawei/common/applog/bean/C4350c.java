package com.huawei.common.applog.bean;

import com.huawei.phoneserviceuni.common.d.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ReportApiThreadPoolManager */
public final class C4350c {
    private static C4350c f16178a = null;
    private ExecutorService f16179b = null;

    private C4350c() {
        c.d("ReportApiThreadPoolManager", "ReportApiThreadPoolManager init!");
        this.f16179b = Executors.newCachedThreadPool();
    }

    public static synchronized C4350c m20919a() {
        C4350c c4350c;
        synchronized (C4350c.class) {
            if (f16178a == null) {
                f16178a = new C4350c();
            }
            c4350c = f16178a;
        }
        return c4350c;
    }

    public void m20920a(Runnable runnable) {
        this.f16179b.execute(runnable);
    }
}
