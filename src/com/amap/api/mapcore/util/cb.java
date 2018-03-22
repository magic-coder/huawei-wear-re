package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

/* compiled from: ANRLogUpDateProcessor */
class cb extends cj {
    private static boolean f11586a = true;

    protected cb(Context context) {
        super(context);
    }

    protected String mo4020a() {
        return ci.f11612d;
    }

    protected int mo4022b() {
        return 2;
    }

    protected boolean mo4021a(Context context) {
        if (bq.m15735m(context) != 1 || !f11586a) {
            return false;
        }
        f11586a = false;
        synchronized (Looper.getMainLooper()) {
            da daVar = new da(context);
            dc a = daVar.m15987a();
            if (a == null) {
                return true;
            } else if (a.m16000c()) {
                a.m15999c(false);
                daVar.m15988a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
