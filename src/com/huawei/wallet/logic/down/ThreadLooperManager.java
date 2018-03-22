package com.huawei.wallet.logic.down;

import android.os.HandlerThread;
import android.os.Looper;

public final class ThreadLooperManager {
    private static volatile ThreadLooperManager f21250b;
    private static final byte[] f21251c = new byte[0];
    private HandlerThread f21252a = new HandlerThread("otoHandlerThread");

    private ThreadLooperManager() {
        this.f21252a.start();
    }

    public static ThreadLooperManager m28047a() {
        if (f21250b == null) {
            synchronized (f21251c) {
                if (f21250b == null) {
                    f21250b = new ThreadLooperManager();
                }
            }
        }
        return f21250b;
    }

    public Looper m28048b() {
        return this.f21252a.getLooper();
    }
}
