package com.huawei.pluginkidwatch.common.lib.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.List;

/* compiled from: BOneUtil */
public class C1483c {
    public static int m6822a(String str, int i) {
        if (!(str == null || str.trim().length() == 0)) {
            String trim = str.trim();
            try {
                i = Integer.parseInt(trim);
            } catch (Exception e) {
                try {
                    i = Float.valueOf(Float.parseFloat(trim)).intValue();
                } catch (Exception e2) {
                }
            }
        }
        return i;
    }

    public static int m6821a(String str) {
        return C1483c.m6822a(str, 0);
    }

    public static String m6823a(Context context) {
        String str = "1.0";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            C2538c.m12680e("BOneUtil", "getAppVersionName() Exception=" + e.getMessage());
        }
        C2538c.m12674b("BOneUtil", "getAppVersionName() return=" + str);
        return str;
    }

    public static boolean m6829b(Context context) {
        return C1483c.m6835d(context) && C1483c.m6833c(context);
    }

    public static boolean m6833c(Context context) {
        if (context == null) {
            return false;
        }
        Configuration configuration = context.getResources().getConfiguration();
        String country = configuration.locale.getCountry();
        C2538c.m12674b("BOneUtil", "isChineseSimplified(): country = " + country + ", language = " + configuration.locale.getLanguage());
        if (PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equalsIgnoreCase(configuration.locale.getLanguage()) && HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(country)) {
            return true;
        }
        return false;
    }

    public static boolean m6835d(Context context) {
        return true;
    }

    public static boolean m6826a(Context context, String str) {
        C2538c.m12674b("BOneUtil", "Enter checkApkExist ");
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m6830b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            C2538c.m12674b("BOneUtil", "isForeground getClassName = " + ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName());
            if (str.equals(((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static void m6832c(Context context, String str) {
        C1483c.m6825a(context, str, 0);
    }

    public static void m6824a(Context context, int i) {
        if (context != null) {
            C1483c.m6825a(context, context.getString(i), 0);
        }
    }

    public static void m6834d(Context context, String str) {
        C1483c.m6825a(context, str, 1);
    }

    public static void m6828b(Context context, int i) {
        if (context != null) {
            C1483c.m6825a(context, context.getString(i), 1);
        }
    }

    public static void m6825a(Context context, String str, int i) {
        Toast b = C1483c.m6827b(context, str, i);
        if (context == null || b == null) {
            C2538c.m12680e("BOneUtil", "showToast() error, context=null or result is null ");
            return;
        }
        b.show();
    }

    public static Toast m6827b(Context context, String str, int i) {
        if (context == null) {
            C2538c.m12680e("BOneUtil", "showToast() error, context=null");
            return null;
        }
        Toast toast = new Toast(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(h.round_toast, null);
        ((TextView) inflate.findViewById(g.tv_toast_message)).setText(str);
        toast.setView(inflate);
        toast.setDuration(i);
        return toast;
    }

    public static double m6820a(double d, double d2, double d3, double d4) {
        double a = C1483c.m6819a(d);
        double a2 = C1483c.m6819a(d3);
        double a3 = C1483c.m6819a(d2) - C1483c.m6819a(d4);
        return ((double) Math.round(((Math.asin(Math.sqrt(((Math.cos(a) * Math.cos(a2)) * Math.pow(Math.sin(a3 / 2.0d), 2.0d)) + Math.pow(Math.sin((a - a2) / 2.0d), 2.0d))) * 2.0d) * 6378.137d) * 10000.0d)) / 10000.0d;
    }

    private static double m6819a(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    public static boolean m6831b(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return false;
        }
        return true;
    }
}
