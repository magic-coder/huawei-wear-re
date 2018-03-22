package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;

/* compiled from: ANRLogUpDateProcessor */
class az extends bg {
    private static boolean f12389a = true;

    protected az(Context context) {
        super(context);
    }

    protected String mo4111a() {
        return bf.f12418d;
    }

    protected int mo4113b() {
        return 2;
    }

    protected boolean mo4112a(Context context) {
        if (C3438z.m17015g(context) != 1 || !f12389a) {
            return false;
        }
        f12389a = false;
        synchronized (Looper.getMainLooper()) {
            aq aqVar = new aq(context);
            as a = aqVar.m16678a();
            if (a == null) {
                return true;
            } else if (a.m16691c()) {
                a.m16690c(false);
                aqVar.m16679a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
