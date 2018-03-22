package com.huawei.wallet.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.huawei.wallet.utils.log.LogC;

public class PackageUtil {
    public static String m28460a(Context context) {
        return m28461a(context, null, false, null);
    }

    private static String m28461a(Context context, String str, boolean z, String str2) {
        if (context == null) {
            LogC.m28534d("getVersion context is null.", false);
        } else if (z && TextUtils.isEmpty(str)) {
            LogC.m28534d("getVersion packageName is null.", false);
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    if (TextUtils.isEmpty(str)) {
                        str = context.getPackageName();
                    }
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        str2 = packageInfo.versionName;
                    }
                }
            } catch (Throwable e) {
                LogC.m28529b("get the app version fail", e, false);
            }
        }
        return str2;
    }

    public static int m28458a(Context context, String str) {
        return m28459a(context, str, true);
    }

    public static int m28462b(Context context) {
        return m28459a(context, null, false);
    }

    private static int m28459a(Context context, String str, boolean z) {
        int i = 0;
        if (context == null) {
            LogC.m28534d("getVersionCode context is null.", false);
        } else if (z && TextUtils.isEmpty(str)) {
            LogC.m28534d("getVersion packageName is null.", false);
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName();
                }
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    i = packageInfo.versionCode;
                }
            } catch (Throwable e) {
                LogC.m28529b("get the app versioncode fail", e, false);
            }
        }
        return i;
    }

    public static boolean m28463b(Context context, String str) {
        if (TextUtils.isEmpty(m28461a(context, str, true, null))) {
            return false;
        }
        return true;
    }

    public static String m28464c(Context context) {
        String valueOf = String.valueOf(0);
        if (context != null) {
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (NameNotFoundException e) {
                LogC.m28530b("getAppChannel NameNotFoundException", false);
            }
            if (applicationInfo != null) {
                valueOf = String.valueOf(applicationInfo.metaData.getInt("APP_CHANNEL"));
            }
        }
        LogC.m28530b("package channel is :" + valueOf, false);
        return valueOf;
    }
}
