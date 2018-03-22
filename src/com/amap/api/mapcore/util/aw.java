package com.amap.api.mapcore.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
final class aw implements ThreadFactory {
    private final AtomicInteger f11437a = new AtomicInteger(1);

    aw() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.f11437a.getAndIncrement());
    }
}
