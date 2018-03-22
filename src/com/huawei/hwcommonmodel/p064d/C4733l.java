package com.huawei.hwcommonmodel.p064d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ThreadPoolUtils */
final class C4733l implements ThreadFactory {
    private final AtomicInteger f17285a = new AtomicInteger();

    C4733l() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "hwcommonmodel--- HW ThreadPool thread:" + this.f17285a.getAndIncrement());
    }
}
