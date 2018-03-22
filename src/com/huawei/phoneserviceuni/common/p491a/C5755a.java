package com.huawei.phoneserviceuni.common.p491a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.logupload.c.f;
import com.huawei.phoneserviceuni.common.p132d.C5768d;
import com.huawei.phoneserviceuni.common.p494c.p495a.C5761a;

/* compiled from: DeviceProperty */
public class C5755a {
    private static String f19530a = "";
    private static String f19531b = "";
    private static String f19532c = "";

    public static String m26424a() {
        Context f = C5755a.m26434f();
        if (f == null) {
            return "";
        }
        if (C5755a.m26431c(f)) {
            return f19530a;
        }
        TelephonyManager telephonyManager = (TelephonyManager) f.getSystemService("phone");
        if (telephonyManager != null) {
            f19530a = telephonyManager.getDeviceId();
        }
        if (TextUtils.isEmpty(f19530a)) {
            f19530a = C5755a.m26432d();
        }
        return f19530a;
    }

    private static String m26432d() {
        Context f = C5755a.m26434f();
        if (f == null) {
            return "";
        }
        if (C5755a.m26431c(f)) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) f.getSystemService("phone");
        CharSequence a = C5755a.m26426a(telephonyManager, 0);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = C5755a.m26426a(telephonyManager, 1);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        a2 = C5755a.m26425a(0);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        a2 = C5755a.m26425a(1);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    private static String m26426a(TelephonyManager telephonyManager, int i) {
        String str = null;
        if (C5755a.m26433e() >= 23 && telephonyManager != null && (i == 0 || i == 1)) {
            try {
                str = telephonyManager.getDeviceId(i);
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
        return str;
    }

    private static int m26433e() {
        return VERSION.SDK_INT;
    }

    private static String m26425a(int i) {
        if (C5756b.m26436a().m26442b() == null) {
            return null;
        }
        if (i == 0 || i == 1) {
            return C5756b.m26436a().m26441a(i);
        }
        return null;
    }

    public static String m26428b() {
        Context f = C5755a.m26434f();
        if (f == null) {
            return "";
        }
        if (C5755a.m26431c(f)) {
            return f19532c;
        }
        TelephonyManager telephonyManager = (TelephonyManager) f.getSystemService("phone");
        if (telephonyManager != null) {
            f19532c = telephonyManager.getSubscriberId();
        }
        if (f19532c == null) {
            f19532c = "";
        }
        return f19532c;
    }

    private static Context m26434f() {
        Context b = C5761a.m26451a().m26453b();
        if (b == null) {
            return C5761a.m26451a().m26454c();
        }
        return b;
    }

    public static String m26430c() {
        Context b = C5761a.m26451a().m26453b();
        if (b == null) {
            b = C5761a.m26451a().m26454c();
        }
        if (b == null) {
            return "";
        }
        if (!C5755a.m26429b(b)) {
            return f19530a;
        }
        TelephonyManager telephonyManager = (TelephonyManager) b.getSystemService("phone");
        if (telephonyManager != null) {
            f19530a = telephonyManager.getDeviceId();
        }
        if (TextUtils.isEmpty(f19530a)) {
            f19530a = C5755a.m26432d();
        }
        return f19530a;
    }

    private static boolean m26431c(Context context) {
        return VERSION.SDK_INT > 22 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0;
    }

    private static boolean m26435g() {
        int a = C5768d.m26480a("android.telephony.HwTelephonyManager", "SUPPORT_SYSTEMAPP_GET_DEVICEID", -1);
        f.c("DeviceProperty", "supportNewPermissionCheck value=" + a);
        if (a == 1) {
            return true;
        }
        return false;
    }

    public static boolean m26427a(Context context) {
        if (context == null) {
            return false;
        }
        Object packageName = context.getPackageName();
        try {
            if (TextUtils.isEmpty(packageName) || (context.getPackageManager().getApplicationInfo(packageName, 0).flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            f.d("DeviceProperty", "isSystemApp NameNotFoundException");
            return false;
        }
    }

    public static boolean m26429b(Context context) {
        if (context == null) {
            return false;
        }
        if (C5755a.m26427a(context) && C5755a.m26435g()) {
            f.d("AppLogApi/FeedbackUtils", "supportNewPermission");
            return true;
        } else if (!C5755a.m26431c(context)) {
            return true;
        } else {
            f.d("AppLogApi/FeedbackUtils", "no have READ_PHONE_STATE Permission");
            return false;
        }
    }
}
