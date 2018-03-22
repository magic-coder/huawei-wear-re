package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p546a.C6498c;
import java.lang.Thread.UncaughtExceptionHandler;

final class ag implements UncaughtExceptionHandler {
    ag() {
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (C6544v.m29833c() && C6546x.f22859t != null) {
            if (C6544v.m29848o()) {
                am.m29668a(C6546x.f22859t).m29694a(new C6498c(C6546x.f22859t, C6546x.m29858a(C6546x.f22859t, false, null), th, thread), null, false, true);
                C6546x.f22856q.m29709f("MTA has caught the following uncaught exception:");
                C6546x.f22856q.m29703a(th);
            }
            C6546x.m29879e(C6546x.f22859t);
            if (C6546x.f22857r != null) {
                C6546x.f22856q.m29710g("Call the original uncaught exception handler.");
                if (!(C6546x.f22857r instanceof ag)) {
                    C6546x.f22857r.uncaughtException(thread, th);
                }
            }
        }
    }
}
