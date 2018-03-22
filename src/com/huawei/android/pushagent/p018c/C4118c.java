package com.huawei.android.pushagent.p018c;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class C4118c {
    public static void m20157a(Context context) {
        C4118c.m20158a(context, "push_plugin", C4118c.m20160c(context));
    }

    private static void m20158a(Context context, String str, String str2) {
        new Thread(new C4119d(context, str, str2)).start();
    }

    private static String m20160c(Context context) {
        String str = "|";
        str = a.a(context);
        String str2 = Build.MODEL;
        String str3 = Build.DISPLAY;
        return new StringBuffer().append(context.getPackageName()).append("|").append(C4118c.m20161d(context)).append("|").append(str).append("|").append(str2).append("|").append(str3).append("|").append("PushPlugin").append("|").append(2712).append("|").append(new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINESE).format(new Date())).toString();
    }

    private static String m20161d(Context context) {
        String str = "0.0";
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            e.a("PushLogAC2712", "package not exist", e);
            return str;
        } catch (Throwable e2) {
            e.c("PushLogAC2712", "getApkVersionName error", e2);
            return str;
        }
    }

    private static boolean m20162e(Context context) {
        boolean z = true;
        int i = -1;
        if (context == null) {
            return false;
        }
        try {
            i = Secure.getInt(context.getContentResolver(), "user_experience_involved", -1);
            e.a("PushLogAC2712", "settingMainSwitch:" + i);
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
        }
        if (i != 1) {
            z = false;
        }
        return z;
    }
}
