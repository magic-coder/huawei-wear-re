package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p546a.C6495d;
import com.tencent.wxop.stat.p546a.C6496a;
import com.tencent.wxop.stat.p546a.C6497b;

final class C6541s implements Runnable {
    final /* synthetic */ Context f22774a;
    final /* synthetic */ C6547y f22775b = null;
    final /* synthetic */ C6497b f22776c;

    C6541s(Context context, C6497b c6497b) {
        this.f22774a = context;
        this.f22776c = c6497b;
    }

    public final void run() {
        try {
            C6495d c6496a = new C6496a(this.f22774a, C6546x.m29858a(this.f22774a, false, this.f22775b), this.f22776c.f22574a, this.f22775b);
            c6496a.m29636a().f22576c = this.f22776c.f22576c;
            new ai(c6496a).m29659a();
        } catch (Throwable th) {
            C6546x.f22856q.m29705b(th);
            C6546x.m29866a(this.f22774a, th);
        }
    }
}
