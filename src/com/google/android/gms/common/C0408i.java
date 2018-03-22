package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;

class C0408i {
    private static final Object f334a = new Object();
    private static Context f335b;

    static synchronized void m494a(Context context) {
        synchronized (C0408i.class) {
            if (f335b != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f335b = context.getApplicationContext();
            }
        }
    }
}
