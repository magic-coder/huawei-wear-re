package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import java.util.concurrent.ThreadFactory;

/* compiled from: InactivityTimer */
final class C1968o implements ThreadFactory {
    private C1968o() {
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}
