package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

/* compiled from: CrashLogUpDateProcessor */
class ce extends cj {
    private static boolean f11595a = true;

    protected ce(Context context) {
        super(context);
    }

    protected String mo4020a() {
        return ci.f11611c;
    }

    protected int mo4022b() {
        return 0;
    }

    protected boolean mo4021a(Context context) {
        if (!f11595a) {
            return false;
        }
        f11595a = false;
        synchronized (Looper.getMainLooper()) {
            da daVar = new da(context);
            dc a = daVar.m15987a();
            if (a == null) {
                return true;
            } else if (a.m15996a()) {
                a.m15995a(false);
                daVar.m15988a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
