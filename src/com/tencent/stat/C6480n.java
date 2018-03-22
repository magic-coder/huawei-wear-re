package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.p544a.C6444a;
import java.lang.Thread.UncaughtExceptionHandler;

final class C6480n implements UncaughtExceptionHandler {
    final /* synthetic */ Context f22526a;

    C6480n(Context context) {
        this.f22526a = context;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (C6470c.m29515b()) {
            C6487u.m29594a(this.f22526a).m29614a(new C6444a(this.f22526a, C6474g.m29552a(this.f22526a, false), 2, th), null);
            C6474g.f22503i.m29412g("MTA has caught the following uncaught exception:");
            C6474g.f22503i.m29410e(th);
            if (C6474g.f22504j != null) {
                C6474g.f22503i.m29412g("Call the original uncaught exception handler.");
                C6474g.f22504j.uncaughtException(thread, th);
                return;
            }
            C6474g.f22503i.m29412g("Original uncaught exception handler not set.");
        }
    }
}
