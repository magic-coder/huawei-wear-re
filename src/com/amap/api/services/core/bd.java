package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;

/* compiled from: ExceptionLogUpDateProcessor */
class bd extends bg {
    private static boolean f12405a = true;

    protected bd(Context context) {
        super(context);
    }

    protected String mo4111a() {
        return bf.f12416b;
    }

    protected int mo4113b() {
        return 1;
    }

    protected boolean mo4112a(Context context) {
        if (C3438z.m17015g(context) != 1 || !f12405a) {
            return false;
        }
        f12405a = false;
        synchronized (Looper.getMainLooper()) {
            aq aqVar = new aq(context);
            as a = aqVar.m16678a();
            if (a == null) {
                return true;
            } else if (a.m16689b()) {
                a.m16688b(false);
                aqVar.m16679a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
