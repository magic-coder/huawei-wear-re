package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher {
    private final Deque<Call> executedCalls = new ArrayDeque();
    private ExecutorService executorService;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<AsyncCall> readyCalls = new ArrayDeque();
    private final Deque<AsyncCall> runningCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public synchronized ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public synchronized void setMaxRequests(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        this.maxRequests = i;
        promoteCalls();
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized void setMaxRequestsPerHost(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        this.maxRequestsPerHost = i;
        promoteCalls();
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    synchronized void enqueue(AsyncCall asyncCall) {
        if (this.runningCalls.size() >= this.maxRequests || runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) {
            this.readyCalls.add(asyncCall);
        } else {
            this.runningCalls.add(asyncCall);
            getExecutorService().execute(asyncCall);
        }
    }

    public synchronized void cancel(Object obj) {
        for (AsyncCall asyncCall : this.readyCalls) {
            if (Util.equal(obj, asyncCall.tag())) {
                asyncCall.cancel();
            }
        }
        for (AsyncCall asyncCall2 : this.runningCalls) {
            if (Util.equal(obj, asyncCall2.tag())) {
                asyncCall2.get().canceled = true;
                HttpEngine httpEngine = asyncCall2.get().engine;
                if (httpEngine != null) {
                    httpEngine.disconnect();
                }
            }
        }
        for (Call call : this.executedCalls) {
            if (Util.equal(obj, call.tag())) {
                call.cancel();
            }
        }
    }

    synchronized void finished(AsyncCall asyncCall) {
        if (this.runningCalls.remove(asyncCall)) {
            promoteCalls();
        } else {
            throw new AssertionError("AsyncCall wasn't running!");
        }
    }

    private void promoteCalls() {
        if (this.runningCalls.size() < this.maxRequests && !this.readyCalls.isEmpty()) {
            Iterator it = this.readyCalls.iterator();
            while (it.hasNext()) {
                AsyncCall asyncCall = (AsyncCall) it.next();
                if (runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
                    it.remove();
                    this.runningCalls.add(asyncCall);
                    getExecutorService().execute(asyncCall);
                }
                if (this.runningCalls.size() >= this.maxRequests) {
                    return;
                }
            }
        }
    }

    private int runningCallsForHost(AsyncCall asyncCall) {
        int i = 0;
        for (AsyncCall host : this.runningCalls) {
            int i2;
            if (host.host().equals(asyncCall.host())) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    synchronized void executed(Call call) {
        this.executedCalls.add(call);
    }

    synchronized void finished(Call call) {
        if (!this.executedCalls.remove(call)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }
}
