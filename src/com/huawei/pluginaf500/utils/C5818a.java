package com.huawei.pluginaf500.utils;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: BtTimeoutCheckCommon */
public class C5818a {
    private static HashMap<C5820c, C5819b> f19986a;
    private static C5818a f19987b = null;

    private C5818a() {
    }

    public static C5818a m26894a() {
        if (f19987b == null) {
            f19987b = new C5818a();
            f19986a = new HashMap();
        }
        return f19987b;
    }

    public void m26895a(C5820c c5820c, int i, TimerTask timerTask) {
        C5819b c5819b;
        C5819b c5819b2;
        if (f19986a.containsKey(c5820c)) {
            c5819b2 = (C5819b) f19986a.get(c5820c);
            if (c5819b2.f19989b != null) {
                c5819b2.f19989b.cancel();
            }
            c5819b2.f19989b = timerTask;
            c5819b2.f19990c = i;
            c5819b = c5819b2;
        } else {
            c5819b2 = new C5819b();
            c5819b2.f19988a = new Timer();
            c5819b2.f19989b = timerTask;
            c5819b2.f19990c = i;
            f19986a.put(c5820c, c5819b2);
            c5819b = c5819b2;
        }
        c5819b.f19988a.schedule(c5819b.f19989b, 1000, 1000);
    }

    public boolean m26896a(C5820c c5820c) {
        if (!f19986a.containsKey(c5820c)) {
            return true;
        }
        C5819b c5819b = (C5819b) f19986a.get(c5820c);
        int i = c5819b.f19990c - 1;
        c5819b.f19990c = i;
        if (i > 0) {
            return false;
        }
        c5819b.f19989b.cancel();
        c5819b.f19988a.cancel();
        c5819b.f19988a.purge();
        f19986a.remove(c5820c);
        return true;
    }

    public boolean m26897b(C5820c c5820c) {
        if (f19986a.containsKey(c5820c)) {
            C5819b c5819b = (C5819b) f19986a.get(c5820c);
            c5819b.f19989b.cancel();
            c5819b.f19988a.cancel();
            c5819b.f19988a.purge();
            f19986a.remove(c5820c);
        }
        return true;
    }
}
