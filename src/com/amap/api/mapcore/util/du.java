package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.dv.C3319a;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: ThreadPool */
public final class du {
    private static du f11746a = null;
    private ExecutorService f11747b;
    private ConcurrentHashMap<dv, Future<?>> f11748c = new ConcurrentHashMap();
    private C3319a f11749d = new dw(this);

    public static synchronized du m16092a(int i) {
        du duVar;
        synchronized (du.class) {
            if (f11746a == null) {
                f11746a = new du(i);
            }
            duVar = f11746a;
        }
        return duVar;
    }

    private du(int i) {
        try {
            this.f11747b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            ca.m15831a(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public void m16099a(dv dvVar) throws bl {
        try {
            if (!m16098b(dvVar) && this.f11747b != null && !this.f11747b.isShutdown()) {
                dvVar.f11734d = this.f11749d;
                Future submit = this.f11747b.submit(dvVar);
                if (submit != null) {
                    m16095a(dvVar, submit);
                }
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
            ca.m15831a(th, "TPool", "addTask");
            bl blVar = new bl("thread pool has exception");
        }
    }

    public static synchronized void m16093a() {
        synchronized (du.class) {
            try {
                if (f11746a != null) {
                    f11746a.m16097b();
                    f11746a = null;
                }
            } catch (Throwable th) {
                ca.m15831a(th, "TPool", "onDestroy");
                th.printStackTrace();
            }
        }
    }

    private void m16097b() {
        try {
            for (Entry key : this.f11748c.entrySet()) {
                Future future = (Future) this.f11748c.get((dv) key.getKey());
                if (future != null) {
                    future.cancel(true);
                }
            }
            this.f11748c.clear();
            this.f11747b.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            ca.m15831a(th, "TPool", "destroy");
            th.printStackTrace();
        }
    }

    private synchronized boolean m16098b(dv dvVar) {
        boolean z;
        z = false;
        try {
            z = this.f11748c.containsKey(dvVar);
        } catch (Throwable th) {
            ca.m15831a(th, "TPool", "contain");
            th.printStackTrace();
        }
        return z;
    }

    private synchronized void m16095a(dv dvVar, Future<?> future) {
        try {
            this.f11748c.put(dvVar, future);
        } catch (Throwable th) {
            ca.m15831a(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized void m16096a(dv dvVar, boolean z) {
        try {
            Future future = (Future) this.f11748c.remove(dvVar);
            if (z && future != null) {
                future.cancel(true);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
