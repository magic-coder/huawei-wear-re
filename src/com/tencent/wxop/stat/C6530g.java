package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p547b.C6517l;
import java.util.Timer;
import java.util.TimerTask;

public class C6530g {
    private static volatile C6530g f22750b = null;
    private Timer f22751a = null;
    private Context f22752c = null;

    private C6530g(Context context) {
        this.f22752c = context.getApplicationContext();
        this.f22751a = new Timer(false);
    }

    public static C6530g m29799a(Context context) {
        if (f22750b == null) {
            synchronized (C6530g.class) {
                if (f22750b == null) {
                    f22750b = new C6530g(context);
                }
            }
        }
        return f22750b;
    }

    public final void m29800a() {
        if (C6544v.m29815a() == C6545w.PERIOD) {
            long l = (long) ((C6544v.m29845l() * 60) * 1000);
            if (C6544v.m29830b()) {
                C6517l.m29740c().m29702a("setupPeriodTimer delay:" + l);
            }
            TimerTask c6531h = new C6531h(this);
            if (this.f22751a != null) {
                if (C6544v.m29830b()) {
                    C6517l.m29740c().m29702a("setupPeriodTimer schedule delay:" + l);
                }
                this.f22751a.schedule(c6531h, l);
            } else if (C6544v.m29830b()) {
                C6517l.m29740c().m29706c("setupPeriodTimer schedule timer == null");
            }
        }
    }
}
