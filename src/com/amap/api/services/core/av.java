package com.amap.api.services.core;

import com.amap.api.services.core.ax.C3391a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: ThreadPool */
public final class av {
    private static av f12372a = null;
    private ExecutorService f12373b;
    private ConcurrentHashMap<ax, Future<?>> f12374c = new ConcurrentHashMap();
    private C3391a f12375d = new aw(this);

    public static synchronized av m16694a(int i) {
        av avVar;
        synchronized (av.class) {
            if (f12372a == null) {
                f12372a = new av(i);
            }
            avVar = f12372a;
        }
        return avVar;
    }

    private av(int i) {
        try {
            this.f12373b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            ay.m16709a(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    private synchronized void m16696a(ax axVar, boolean z) {
        try {
            Future future = (Future) this.f12374c.remove(axVar);
            if (z && future != null) {
                future.cancel(true);
            }
        } catch (Throwable th) {
            ay.m16709a(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
