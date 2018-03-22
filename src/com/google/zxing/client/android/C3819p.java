package com.google.zxing.client.android;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PictureFetcher */
class C3819p implements ThreadFactory {
    private final AtomicInteger f14830a = new AtomicInteger(1);

    C3819p() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "PictureFecher AsyncTask #" + this.f14830a.getAndIncrement());
    }
}
