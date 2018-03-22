package com.huawei.common.applog.bean;

import com.huawei.phoneserviceuni.common.d.c;
import java.util.Timer;

/* compiled from: TimerManage */
public final class C4351e {
    private static final C4351e f16180a = new C4351e();
    private static final Object f16181c = new Object();
    private Timer f16182b = null;

    private C4351e() {
    }

    public static C4351e m20921a() {
        return f16180a;
    }

    public Timer m20923b() {
        return this.f16182b;
    }

    public void m20922a(Timer timer) {
        this.f16182b = timer;
    }

    public void m20924c() {
        synchronized (f16181c) {
            if (this.f16182b != null) {
                c.d("ReportApi", "Timer cancel");
                this.f16182b.cancel();
                this.f16182b = null;
            }
        }
    }
}
