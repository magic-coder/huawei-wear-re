package com.google.analytics.tracking.android;

import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: ScreenResolutionDefaultProvider */
class bb implements C3649n {
    private static bb f14156a;
    private static Object f14157b = new Object();
    private final Context f14158c;

    public static void m18313a(Context context) {
        synchronized (f14157b) {
            if (f14156a == null) {
                f14156a = new bb(context);
            }
        }
    }

    public static bb m18312a() {
        bb bbVar;
        synchronized (f14157b) {
            bbVar = f14156a;
        }
        return bbVar;
    }

    protected bb(Context context) {
        this.f14158c = context;
    }

    public String mo4248a(String str) {
        if (str != null && str.equals("&sr")) {
            return m18315b();
        }
        return null;
    }

    protected String m18315b() {
        DisplayMetrics displayMetrics = this.f14158c.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }
}
