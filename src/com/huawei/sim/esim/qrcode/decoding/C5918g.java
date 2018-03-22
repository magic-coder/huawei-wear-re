package com.huawei.sim.esim.qrcode.decoding;

import java.util.concurrent.ThreadFactory;

/* compiled from: InactivityTimer */
final class C5918g implements ThreadFactory {
    private C5918g() {
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}
