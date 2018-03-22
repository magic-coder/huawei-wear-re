package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C0424f;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class cv implements ThreadFactory {
    private final String f669a;
    private final int f670b;
    private final AtomicInteger f671c;
    private final ThreadFactory f672d;

    public cv(String str) {
        this(str, 0);
    }

    public cv(String str, int i) {
        this.f671c = new AtomicInteger();
        this.f672d = Executors.defaultThreadFactory();
        this.f669a = (String) C0424f.m650a((Object) str, (Object) "Name must not be null");
        this.f670b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f672d.newThread(new cw(runnable, this.f670b));
        String str = this.f669a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f671c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
