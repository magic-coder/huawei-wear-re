package com.huawei.hwversionmgr.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: UpdateUtil */
public class C1080f {
    public static String m4597a(String str) {
        int i = 0;
        String str2 = "";
        Boolean valueOf = Boolean.valueOf(false);
        C2538c.m12677c("TAG", "===www===stringTransfer =" + str + "");
        if (str == null || "".equals(str)) {
            return str2;
        }
        String[] split = str.split("\n");
        StringBuffer stringBuffer = new StringBuffer();
        while (i < split.length) {
            if (!"".equals(split[i])) {
                if (valueOf.booleanValue()) {
                    stringBuffer.append('\n');
                }
                stringBuffer.append(split[i]);
                valueOf = Boolean.valueOf(true);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static boolean m4602b(String str) {
        C2538c.m12677c("TAG", "isAlreadyUpdatedOfBand: strLastTime = " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Date c = C1080f.m4604c(str);
        if (c == null) {
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - c.getTime()) <= 259200000) {
            return true;
        }
        return false;
    }

    public static Date m4604c(String str) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (ParseException e) {
            C2538c.m12677c("TAG", "Exception e = " + e.getMessage());
            return null;
        }
    }

    public static String m4595a() {
        C2538c.m12677c("TAG", "getCurrentTime: strCurTime");
        try {
            C2538c.m12677c("TAG", "getCurrentTime: strCurTime = " + new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
            return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            C2538c.m12677c("TAG", "Exception e = " + e.getMessage());
            return null;
        }
    }

    public static void m4599a(String str, Context context) {
        C2538c.m12677c("Util", "setAppAutoCheckTime,time-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_app_auto_check_time", str, c0993c);
    }

    public static String m4596a(Context context) {
        C2538c.m12677c("Util", "getAppAutoCheckTime,mAutoCheckTime-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_app_auto_check_time"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_app_auto_check_time");
    }

    public static String m4600b(Context context) {
        C2538c.m12677c("Util", "getBandAutoCheckTime,mAutoCheckTime-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_band_auto_check_time"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_band_auto_check_time");
    }

    public static void m4601b(String str, Context context) {
        C2538c.m12677c("Util", "setBandAutoCheckTime,time-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_band_auto_check_time", str, c0993c);
    }

    public static void m4605c(String str, Context context) {
        C2538c.m12677c("Util", "setAppCheckNewVersionCode,versionCode-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_app_new_version_code", str, c0993c);
    }

    public static String m4603c(Context context) {
        C2538c.m12677c("Util", "getAppCheckNewVersionCode,mVersionCode-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_app_new_version_code"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_app_new_version_code");
    }

    public static String m4606d(Context context) {
        C2538c.m12677c("Util", "getAppStorePath,mStorePath-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_app_store_path"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_app_store_path");
    }

    public static void m4607d(String str, Context context) {
        C2538c.m12677c("Util", "setAppStorePath, storePath-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_app_store_path", str, c0993c);
    }

    public static void m4609e(String str, Context context) {
        C2538c.m12677c("Util", "setAppLastVersionCode, mLastVersionCode-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_app_last_version_code", str, c0993c);
    }

    public static void m4611f(String str, Context context) {
        C2538c.m12677c("Util", "setBandCheckNewVersion,version-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_band_new_version", str, c0993c);
    }

    public static String m4608e(Context context) {
        C2538c.m12677c("Util", "setBandCheckNewVersion,mVersion-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_band_new_version"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_band_new_version");
    }

    public static String m4610f(Context context) {
        C2538c.m12677c("Util", "getBandLastVersionCode,mLastVersionCode-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_band_last_version_code"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_band_last_version_code");
    }

    public static void m4613g(String str, Context context) {
        C2538c.m12677c("Util", "setBandLastVersionCode, mLastVersionCode-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_band_last_version_code", str, c0993c);
    }

    public static String m4612g(Context context) {
        C2538c.m12677c("Util", "getBandStorePath,mStorePath-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_band_store_path"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_band_store_path");
    }

    public static void m4615h(String str, Context context) {
        C2538c.m12677c("Util", "setBandStorePath, storePath-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_band_store_path", str, c0993c);
    }

    public static String m4614h(Context context) {
        C2538c.m12677c("Util", "getBandDeviceVersion,mVersion-----------" + C0996a.m3612a(context, String.valueOf(1003), "update_key_band_device_version"));
        return C0996a.m3612a(context, String.valueOf(1003), "update_key_band_device_version");
    }

    public static void m4617i(String str, Context context) {
        C2538c.m12677c("Util", "setBandDeviceVersion,Version-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_band_device_version", str, c0993c);
    }

    public static void m4616i(Context context) {
        String g = C1080f.m4612g(context);
        C2538c.m12677c("Util", "deleteUpdateDfu: path = " + g);
        if (!TextUtils.isEmpty(g)) {
            File file = new File(g);
            if (file.exists() && !file.delete()) {
                C2538c.m12680e("Util", "deleteUpdateDfu: path = " + g + " failed!");
            }
        }
    }

    public static void m4598a(Context context, boolean z) {
        C2538c.m12677c("Util", "setBandForcedUpdate,result-----------" + z);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(1003), "update_key_band_new_version_tip", "" + z, c0993c);
    }

    public static void m4618j(Context context) {
        C2538c.m12677c("Util", "resetBandUpdate");
        C1080f.m4598a(context, false);
        C1080f.m4601b("", context);
        C1080f.m4611f("", context);
        C1080f.m4617i("", context);
        C1080f.m4613g("", context);
    }
}
