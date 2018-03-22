package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: BasicLogHandler */
public class cd {
    protected static cd f11580a;
    protected UncaughtExceptionHandler f11581b;
    protected boolean f11582c = true;

    public static void m15825a(Throwable th, String str, String str2) {
        th.printStackTrace();
        if (f11580a != null) {
            f11580a.mo4019a(th, 1, str, str2);
        }
    }

    protected void mo4019a(Throwable th, int i, String str, String str2) {
    }

    protected void mo4018a(Context context, bv bvVar, boolean z) {
    }
}
