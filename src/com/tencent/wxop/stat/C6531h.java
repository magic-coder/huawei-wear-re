package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p547b.C6517l;
import java.util.TimerTask;

final class C6531h extends TimerTask {
    final /* synthetic */ C6530g f22753a;

    C6531h(C6530g c6530g) {
        this.f22753a = c6530g;
    }

    public final void run() {
        if (C6544v.m29830b()) {
            C6517l.m29740c().m29702a((Object) "TimerTask run");
        }
        C6546x.m29881f(this.f22753a.f22752c);
        cancel();
        this.f22753a.m29800a();
    }
}
