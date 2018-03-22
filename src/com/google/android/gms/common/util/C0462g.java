package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.C0391p;

public final class C0462g {
    private static Boolean f477a;
    private static Boolean f478b;
    private static Boolean f479c;

    public static boolean m816a() {
        boolean z = C0391p.f312c;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean m817a(Context context) {
        if (f477a == null) {
            boolean z = C0467l.m830f() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            f477a = Boolean.valueOf(z);
        }
        return f477a.booleanValue();
    }

    @TargetApi(24)
    public static boolean m818b(Context context) {
        return (!C0467l.m832h() || C0462g.m819c(context)) && C0462g.m817a(context);
    }

    @TargetApi(21)
    public static boolean m819c(Context context) {
        if (f478b == null) {
            boolean z = C0467l.m831g() && context.getPackageManager().hasSystemFeature("cn.google");
            f478b = Boolean.valueOf(z);
        }
        return f478b.booleanValue();
    }

    public static boolean m820d(Context context) {
        if (f479c == null) {
            f479c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
        }
        return f479c.booleanValue();
    }
}
