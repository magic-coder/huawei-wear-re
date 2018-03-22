package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.bf;
import com.amap.api.mapcore.util.bq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionManager extends SingalThread {
    private static final int MAX_THREAD_COUNT = 1;
    private ArrayList<BaseMapLoader> connPool = new ArrayList();
    MapCore mGLMapEngine;
    boolean threadFlag = true;
    private ExecutorService threadPool = Executors.newFixedThreadPool(1);
    private ArrayList<C3521a> threadPoolList = new ArrayList();

    public ConnectionManager(MapCore mapCore) {
        this.mGLMapEngine = mapCore;
    }

    public void shutDown() {
        if (this.connPool != null) {
            this.threadPool.shutdownNow();
        }
    }

    public void insertConntionTask(BaseMapLoader baseMapLoader) {
        synchronized (this.connPool) {
            this.connPool.add(baseMapLoader);
        }
        doAwake();
    }

    void checkListPoolOld() {
        Iterator it = this.threadPoolList.iterator();
        while (it.hasNext()) {
            BaseMapLoader baseMapLoader = ((C3521a) it.next()).f13275a;
            if (!baseMapLoader.isRequestValid() || baseMapLoader.hasFinished()) {
                baseMapLoader.doCancel();
                it.remove();
            }
        }
    }

    private void checkListPool() {
        Collection arrayList = new ArrayList();
        int size = this.threadPoolList.size();
        for (int i = 0; i < size; i++) {
            C3521a c3521a = (C3521a) this.threadPoolList.get(i);
            BaseMapLoader baseMapLoader = c3521a.f13275a;
            if (!baseMapLoader.isRequestValid() || baseMapLoader.hasFinished()) {
                arrayList.add(c3521a);
                baseMapLoader.doCancel();
            }
        }
        this.threadPoolList.removeAll(arrayList);
    }

    public void run() {
        try {
            bq.m15721a();
            doAsyncRequest();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void doAsyncRequest() {
        while (this.threadFlag) {
            Object obj;
            synchronized (this.connPool) {
                checkListPool();
                while (this.connPool.size() > 0) {
                    if (this.threadPoolList.size() > 1) {
                        obj = 1;
                        break;
                    }
                    BaseMapLoader baseMapLoader = (BaseMapLoader) this.connPool.remove(0);
                    Runnable c3521a = new C3521a(baseMapLoader);
                    bf.m15627a(bf.f11497a, hashCode() + " add Task, get mapdata from net, datasource: " + baseMapLoader.datasource, 111);
                    this.threadPoolList.add(c3521a);
                    if (!this.threadPool.isShutdown()) {
                        this.threadPool.execute(c3521a);
                    }
                }
                obj = null;
            }
            if (obj != null) {
                try {
                    sleep(30);
                } catch (Exception e) {
                }
            } else if (this.threadFlag) {
                try {
                    doWait();
                } catch (Throwable th) {
                }
            }
        }
    }
}
