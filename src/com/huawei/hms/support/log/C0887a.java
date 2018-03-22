package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/* compiled from: HMSLog */
public class C0887a {
    private static final C0888b f1421a = new C0888b();

    public static void m3091a(Context context, int i, String str) {
        f1421a.m3102a(context, i, str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("============================================================================").append('\n');
        stringBuilder.append("====== ").append(C0887a.m3090a(context)).append('\n');
        stringBuilder.append("============================================================================");
        f1421a.m3103a(str, stringBuilder.toString());
    }

    private static String m3090a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "HMS-[unknown-version]";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
        } catch (NameNotFoundException e) {
            return "HMS-[unknown-version]";
        }
    }

    public static boolean m3093a() {
        return f1421a.m3104a(3);
    }

    public static boolean m3095b() {
        return f1421a.m3104a(4);
    }

    public static boolean m3097c() {
        return f1421a.m3104a(5);
    }

    public static boolean m3099d() {
        return f1421a.m3104a(6);
    }

    public static void m3092a(String str, String str2) {
        f1421a.m3101a(3, str, str2);
    }

    public static void m3094b(String str, String str2) {
        f1421a.m3101a(4, str, str2);
    }

    public static void m3096c(String str, String str2) {
        f1421a.m3101a(5, str, str2);
    }

    public static void m3098d(String str, String str2) {
        f1421a.m3101a(6, str, str2);
    }
}
