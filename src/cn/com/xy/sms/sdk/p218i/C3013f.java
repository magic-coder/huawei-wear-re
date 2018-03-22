package cn.com.xy.sms.sdk.p218i;

import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class C3013f {
    public static BlockingQueue<C3015h> f10173a = new LinkedBlockingQueue();
    public static int f10174b = 10;
    private static Thread f10175c = null;

    public static synchronized void m13538a() {
        synchronized (C3013f.class) {
            if (f10175c == null) {
                Thread c3014g = new C3014g();
                f10175c = c3014g;
                c3014g.start();
            }
        }
    }

    public static void m13539a(C3015h c3015h) {
        try {
            f10173a.put(c3015h);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "addTask: " + th.getMessage(), th);
        }
    }
}
