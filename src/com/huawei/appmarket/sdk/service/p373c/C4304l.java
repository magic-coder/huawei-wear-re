package com.huawei.appmarket.sdk.service.p373c;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.helpers.FileWatchdog;

public class C4304l {
    private static int f16023a = 0;
    private static long f16024b = System.currentTimeMillis();
    private static AtomicInteger f16025c = new AtomicInteger(0);

    public static synchronized boolean m20758a() {
        boolean z = true;
        synchronized (C4304l.class) {
            if (f16025c.get() < 200) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f16024b > FileWatchdog.DEFAULT_DELAY) {
                    f16024b = currentTimeMillis;
                    f16023a = 0;
                    f16025c.incrementAndGet();
                    z = false;
                } else if (f16023a < 60) {
                    f16025c.incrementAndGet();
                    f16023a++;
                    z = false;
                }
            }
        }
        return z;
    }
}
