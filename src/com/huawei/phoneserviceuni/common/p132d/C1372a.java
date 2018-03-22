package com.huawei.phoneserviceuni.common.p132d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.feedback.C0811c;
import com.huawei.phoneserviceuni.common.a.a;
import com.huawei.phoneserviceuni.common.d.e;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* compiled from: DeviceUtils */
public class C1372a {
    public static boolean m6109a() {
        return C1372a.m6111a("com.huawei.android.os.BuildEx");
    }

    public static String m6113b() {
        return VERSION.RELEASE;
    }

    public static String m6116c() {
        return Build.DISPLAY;
    }

    public static String m6118d() {
        return e.a("ro.product.brand");
    }

    public static String m6120e() {
        return e.a("ro.build.version.emui");
    }

    private static boolean m6111a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static String m6107a(String str, Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            C1373c.m6141d("DeviceUtils", "getPackageVersionCode:NameNotFoundException");
            packageInfo = null;
        }
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return null;
    }

    public static String m6114b(String str, Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            C1373c.m6141d("DeviceUtils", "getPackageVersionName:NameNotFoundException");
            packageInfo = null;
        }
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionName);
        }
        return null;
    }

    public static boolean m6121f() {
        if (!C1372a.m6109a() || BuildEx.VERSION.EMUI_SDK_INT < 8) {
            return false;
        }
        return true;
    }

    public static boolean m6122g() {
        if (!C1372a.m6109a() || BuildEx.VERSION.EMUI_SDK_INT < 9) {
            return false;
        }
        return true;
    }

    public static boolean m6123h() {
        String i = C1372a.m6124i();
        if (!TextUtils.isEmpty(i)) {
            i = i.toLowerCase(Locale.getDefault());
        }
        if (!TextUtils.isEmpty(i) && (i.contains("emotionui_1") || i.contains("emotionui 1"))) {
            return false;
        }
        if (!TextUtils.isEmpty(i) && (i.contains("emotionui_2") || i.contains("emotionui 2"))) {
            return false;
        }
        if (TextUtils.isEmpty(i) || (!i.contains("emotionui_3") && !i.contains("emotionui 3"))) {
            return C1372a.m6125j();
        }
        return true;
    }

    public static String m6124i() {
        return e.a("ro.build.version.emui");
    }

    public static boolean m6125j() {
        boolean a = C1372a.m6111a("com.huawei.android.app.ActionBarEx");
        C1373c.m6138a("DeviceUtils", "isSupportActionBarEx: " + a);
        return a;
    }

    public static boolean m6126k() {
        return "wifi-only".equals(e.a("ro.carrier", ""));
    }

    public static boolean m6110a(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable();
    }

    public static boolean m6115b(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            return !((Boolean) connectivityManager.getClass().getMethod("isNetworkSupported", new Class[]{Integer.TYPE}).invoke(connectivityManager, new Object[]{Integer.valueOf(0)})).booleanValue();
        } catch (NoSuchMethodException e) {
            C1373c.m6141d("DeviceUtils", "isWifiOnly NoSuchMethodException");
            return false;
        } catch (IllegalAccessException e2) {
            C1373c.m6141d("DeviceUtils", "isWifiOnly IllegalAccessException");
            return false;
        } catch (IllegalArgumentException e3) {
            C1373c.m6141d("DeviceUtils", "isWifiOnly IllegalArgumentException");
            return false;
        } catch (InvocationTargetException e4) {
            C1373c.m6141d("DeviceUtils", "isWifiOnly InvocationTargetException");
            return false;
        }
    }

    public static String m6127l() {
        String str;
        String str2 = "";
        try {
            str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.serialno"});
        } catch (NoSuchMethodException e) {
            C1373c.m6141d("DeviceUtils", "getSN NoSuchMethodException");
            str = str2;
        } catch (IllegalAccessException e2) {
            C1373c.m6141d("DeviceUtils", "getSN IllegalAccessException");
            str = str2;
        } catch (ClassNotFoundException e3) {
            C1373c.m6141d("DeviceUtils", "getSN ClassNotFoundException");
            str = str2;
        } catch (IllegalArgumentException e4) {
            C1373c.m6141d("DeviceUtils", "getSN IllegalArgumentException");
            str = str2;
        } catch (InvocationTargetException e5) {
            C1373c.m6141d("DeviceUtils", "getSN InvocationTargetException");
            str = str2;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String m6117c(Context context) {
        String c = a.c();
        if (TextUtils.isEmpty(c)) {
            C1373c.m6141d("DeviceUtils", "imei empty!");
            if (C1372a.m6115b(context)) {
                C1373c.m6141d("DeviceUtils", "isWifiOnly!");
                c = C0811c.m2815v(context);
            } else {
                C1373c.m6141d("DeviceUtils", "not WifiOnly!");
                c = "000000000000000";
            }
        }
        C1373c.m6141d("DeviceUtils", "imei is not empty!");
        return c;
    }

    public static boolean m6128m() {
        if (!C1372a.m6109a() || BuildEx.VERSION.EMUI_SDK_INT < 11) {
            return false;
        }
        return true;
    }

    public static boolean m6129n() {
        return C1372a.m6111a("huawei.android.widget.CounterTextLayout");
    }

    public static String m6130o() {
        return VERSION.RELEASE;
    }

    public static String m6131p() {
        return Build.MODEL;
    }

    public static String m6106a(Context context, String str) {
        String str2 = null;
        if (context == null) {
            C1373c.m6141d("DeviceUtils", "Context is null.");
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        str2 = packageInfo.versionName;
                    }
                } catch (Exception e) {
                    C1372a.m6108a(e, "DeviceUtils", "getVersionName");
                }
            }
        }
        return str2;
    }

    public static void m6108a(Exception exception, String str, String str2) {
        if (exception != null && exception.getMessage() != null && str2 != null) {
            C1373c.m6141d(str, str2 + "/" + exception.getMessage());
        }
    }

    public static String m6132q() {
        String country = Locale.getDefault().getCountry();
        return country != null ? country : "";
    }

    public static String m6133r() {
        String s = C1372a.m6134s();
        return (s + "-" + C1372a.m6132q()).toLowerCase(Locale.getDefault());
    }

    public static String m6134s() {
        String language = Locale.getDefault().getLanguage();
        return language != null ? language : "";
    }

    public static String m6119d(Context context) {
        if (context == null) {
            return "";
        }
        return C1372a.m6112b(context, context.getPackageName()) + "";
    }

    public static int m6112b(Context context, String str) {
        int i = 0;
        if (!(context == null || TextUtils.isEmpty(str))) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        i = packageInfo.versionCode;
                    }
                } catch (Exception e) {
                    C1372a.m6108a(e, "DeviceUtils", "getVersionCode");
                }
            }
        }
        return i;
    }

    public static int m6135t() {
        if (C1372a.m6126k()) {
            return 3;
        }
        if (C1372a.m6136u()) {
            return 2;
        }
        return 1;
    }

    public static boolean m6136u() {
        return "tablet".equals(e.a("ro.build.characteristics"));
    }
}
