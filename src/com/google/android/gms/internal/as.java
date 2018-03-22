package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;

abstract class as implements Runnable {
    final /* synthetic */ ai f554b;

    private as(ai aiVar) {
        this.f554b = aiVar;
    }

    @WorkerThread
    protected abstract void mo1822a();

    @WorkerThread
    public void run() {
        this.f554b.f530b.lock();
        try {
            if (!Thread.interrupted()) {
                mo1822a();
                this.f554b.f530b.unlock();
            }
        } catch (RuntimeException e) {
            this.f554b.f529a.m1624a(e);
        } finally {
            this.f554b.f530b.unlock();
        }
    }
}
