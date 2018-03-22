package com.huawei.pluginkidwatch.common.lib.p145d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ThreadPoolUtils */
final class C1478k implements ThreadFactory {
    private final AtomicInteger f3446a = new AtomicInteger();

    C1478k() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "HW ThreadPool thread:" + this.f3446a.getAndIncrement());
    }
}
