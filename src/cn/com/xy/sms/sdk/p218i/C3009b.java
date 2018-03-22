package cn.com.xy.sms.sdk.p218i;

import android.os.Process;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p229l.C3046k;
import cn.com.xy.sms.sdk.p229l.C3049n;

public final class C3009b extends Thread {
    private static boolean f10168a = false;

    public static synchronized void m13533a() {
        synchronized (C3009b.class) {
            if (C2996a.m13492a(1)) {
                if (!f10168a) {
                    f10168a = true;
                    new C3009b().start();
                }
            }
        }
    }

    private static void m13534a(int i) {
        String a = C2973a.m13354a(Integer.valueOf(i), C3046k.f10294a, C2996a.f10136h);
        try {
            new StringBuilder("type=").append(i).append(" postData=").append(a);
            if (!C3049n.m13653e(a) && !"[]".equals(a)) {
                C2996a.m13496b(null);
                C2996a.m13490a("logserver", a, new C3010c(i, a), false, false, true, null);
            }
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "sendLog: " + e.getMessage(), e);
        }
    }

    public final void run() {
        try {
            setName("xiaoyuan_ReportLogQueue");
            C3046k.m13626a();
            Process.setThreadPriority(C3013f.f10174b);
            C3009b.m13534a(1);
            C3009b.m13534a(2);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "run: " + th.getMessage(), th);
        } finally {
            f10168a = false;
        }
    }
}
