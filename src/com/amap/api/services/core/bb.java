package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;

/* compiled from: CrashLogUpDateProcessor */
class bb extends bg {
    private static boolean f12401a = true;

    protected bb(Context context) {
        super(context);
    }

    protected String mo4111a() {
        return bf.f12417c;
    }

    protected int mo4113b() {
        return 0;
    }

    protected boolean mo4112a(Context context) {
        if (!f12401a) {
            return false;
        }
        f12401a = false;
        synchronized (Looper.getMainLooper()) {
            aq aqVar = new aq(context);
            as a = aqVar.m16678a();
            if (a == null) {
                return true;
            } else if (a.m16687a()) {
                a.m16686a(false);
                aqVar.m16679a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
