package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p546a.C6495d;
import com.tencent.wxop.stat.p546a.C6502h;

final class ad implements Runnable {
    final /* synthetic */ Context f22605a;
    final /* synthetic */ String f22606b;
    final /* synthetic */ C6547y f22607c;

    ad(Context context, String str, C6547y c6547y) {
        this.f22605a = context;
        this.f22606b = str;
        this.f22607c = c6547y;
    }

    public final void run() {
        try {
            Long l;
            C6546x.m29879e(this.f22605a);
            synchronized (C6546x.f22854o) {
                l = (Long) C6546x.f22854o.remove(this.f22606b);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String i = C6546x.f22853n;
                if (i != null && i.equals(this.f22606b)) {
                    i = "-";
                }
                C6495d c6502h = new C6502h(this.f22605a, i, this.f22606b, C6546x.m29858a(this.f22605a, false, this.f22607c), valueOf, this.f22607c);
                if (!this.f22606b.equals(C6546x.f22852m)) {
                    C6546x.f22856q.m29704b((Object) "Invalid invocation since previous onResume on diff page.");
                }
                new ai(c6502h).m29659a();
                C6546x.f22853n = this.f22606b;
                return;
            }
            C6546x.f22856q.m29708e("Starttime for PageID:" + this.f22606b + " not found, lost onResume()?");
        } catch (Throwable th) {
            C6546x.f22856q.m29705b(th);
            C6546x.m29866a(this.f22605a, th);
        }
    }
}
