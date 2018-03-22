package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p547b.C6517l;

final class C6537o implements Runnable {
    final /* synthetic */ Context f22769a;

    C6537o(Context context) {
        this.f22769a = context;
    }

    public final void run() {
        C6548z.m29898a(C6546x.f22859t).m29910h();
        C6517l.m29728a(this.f22769a, true);
        am.m29668a(this.f22769a);
        C6534l.m29803b(this.f22769a);
        C6546x.f22857r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new ag());
        if (C6544v.m29815a() == C6545w.APP_LAUNCH) {
            C6546x.m29877d(this.f22769a);
        }
        if (C6544v.m29830b()) {
            C6546x.f22856q.m29710g("Init MTA StatService success.");
        }
    }
}
