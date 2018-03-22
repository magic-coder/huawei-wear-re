package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

/* compiled from: ExceptionLogUpDateProcessor */
class cg extends cj {
    private static boolean f11599a = true;

    protected cg(Context context) {
        super(context);
    }

    protected String mo4020a() {
        return ci.f11610b;
    }

    protected int mo4022b() {
        return 1;
    }

    protected boolean mo4021a(Context context) {
        if (bq.m15735m(context) != 1 || !f11599a) {
            return false;
        }
        f11599a = false;
        synchronized (Looper.getMainLooper()) {
            da daVar = new da(context);
            dc a = daVar.m15987a();
            if (a == null) {
                return true;
            } else if (a.m15998b()) {
                a.m15997b(false);
                daVar.m15988a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
