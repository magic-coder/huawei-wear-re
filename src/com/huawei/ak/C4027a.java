package com.huawei.ak;

import com.huawei.p190v.C2538c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ThreadPoolManager */
public class C4027a {
    private static ExecutorService f15307a;
    private static C4027a f15308b;
    private static byte[] f15309c = new byte[1];

    static {
        f15307a = null;
        f15307a = Executors.newFixedThreadPool(5);
    }

    private C4027a() {
    }

    public static C4027a m19820a() {
        C4027a c4027a;
        synchronized (f15309c) {
            if (f15308b == null) {
                f15308b = new C4027a();
            }
            c4027a = f15308b;
        }
        return c4027a;
    }

    public void m19821a(Runnable runnable) {
        C2538c.b("ThreadPoolManager", new Object[]{"ececute the task"});
        f15307a.execute(runnable);
    }
}
