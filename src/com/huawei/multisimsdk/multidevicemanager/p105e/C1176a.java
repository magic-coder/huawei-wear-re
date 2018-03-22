package com.huawei.multisimsdk.multidevicemanager.p105e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncHttpUtils */
public class C1176a {
    public static final int f2577a = Runtime.getRuntime().availableProcessors();
    public static final Executor f2578b = new ThreadPoolExecutor(f2579c, f2580d, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private static final int f2579c = (f2577a + 1);
    private static final int f2580d = ((f2577a * 2) + 1);
    private static C1176a f2581e;

    public static synchronized C1176a m5272a() {
        C1176a c1176a;
        synchronized (C1176a.class) {
            if (f2581e == null) {
                f2581e = new C1176a();
            }
            c1176a = f2581e;
        }
        return c1176a;
    }

    public void m5273a(String str, String str2, C1141i c1141i) {
        Runnable c1178c = new C1178c(this, new Handler(Looper.getMainLooper()), str, str2, c1141i);
        C1183h.m5282b("AsyncHttpUtils", "threadPoolExecutor.execute");
        f2578b.execute(c1178c);
    }
}
