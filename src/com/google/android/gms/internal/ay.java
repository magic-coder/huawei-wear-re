package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ay {
    private static final ExecutorService f569a = Executors.newFixedThreadPool(2, new cv("GAC_Executor"));

    public static ExecutorService m998a() {
        return f569a;
    }
}
