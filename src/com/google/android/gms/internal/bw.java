package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class bw {
    private static final ExecutorService f633a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new cv("GAC_Transform"));

    public static ExecutorService m1115a() {
        return f633a;
    }
}
