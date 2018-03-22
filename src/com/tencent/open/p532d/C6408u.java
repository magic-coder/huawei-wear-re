package com.tencent.open.p532d;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
public final class C6408u {
    public static final Executor f22254a = C6408u.m29232c();
    private static Object f22255b = new Object();
    private static Handler f22256c;
    private static HandlerThread f22257d;

    private static Executor m29232c() {
        Executor threadPoolExecutor;
        if (VERSION.SDK_INT >= 11) {
            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            Executor executor;
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                executor = (Executor) declaredField.get(null);
            } catch (Exception e) {
                Object threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
            threadPoolExecutor = executor;
        }
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) threadPoolExecutor).setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }

    public static Handler m29229a() {
        if (f22256c == null) {
            synchronized (C6408u.class) {
                f22257d = new HandlerThread("SDK_SUB");
                f22257d.start();
                f22256c = new Handler(f22257d.getLooper());
            }
        }
        return f22256c;
    }

    public static void m29230a(Runnable runnable) {
        C6408u.m29229a().post(runnable);
    }

    public static Executor m29231b() {
        return new C6410w();
    }
}
