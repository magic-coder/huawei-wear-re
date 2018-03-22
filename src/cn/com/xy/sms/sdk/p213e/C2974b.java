package cn.com.xy.sms.sdk.p213e;

import android.os.Process;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2952s;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3059x;

final class C2974b implements Runnable {
    private final /* synthetic */ String f10073a;

    C2974b(String str) {
        this.f10073a = str;
    }

    public final void run() {
        try {
            Process.setThreadPriority(10);
            Thread.currentThread().setPriority(1);
            if (this.f10073a != null && this.f10073a.length() > 7) {
                long j = 0;
                Long l = (Long) C2917a.f9892b.get(this.f10073a);
                if (l != null) {
                    j = l.longValue();
                }
                if (System.currentTimeMillis() >= (C2973a.f10067d != null ? C2973a.m13350a(6, 600000) : 600000) + j) {
                    C2952s.m13292a(this.f10073a, "-1", 1);
                    C2917a.f9892b.put(this.f10073a, Long.valueOf(System.currentTimeMillis()));
                    C3059x.m13732a();
                }
            }
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "getClassLoaderBymap: " + e.getMessage(), e);
        }
    }
}
