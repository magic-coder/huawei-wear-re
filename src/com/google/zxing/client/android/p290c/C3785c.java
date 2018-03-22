package com.google.zxing.client.android.p290c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: GetNewestBitmap */
class C3785c implements ThreadFactory {
    private final AtomicInteger f14727a = new AtomicInteger(1);

    C3785c() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "GetNewestBitmap AsyncTask #" + this.f14727a.getAndIncrement());
    }
}
