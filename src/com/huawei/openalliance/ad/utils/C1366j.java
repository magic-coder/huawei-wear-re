package com.huawei.openalliance.ad.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class C1366j {
    public static final Executor f2949a = new ThreadPoolExecutor(3, 7, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(512), new DiscardOldestPolicy());
    public static final Executor f2950b = new ThreadPoolExecutor(3, 7, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(512), new DiscardOldestPolicy());
    public static final Executor f2951c = new ThreadPoolExecutor(3, 7, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(512), new DiscardOldestPolicy());
}
