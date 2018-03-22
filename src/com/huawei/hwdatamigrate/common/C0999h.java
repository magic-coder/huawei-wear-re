package com.huawei.hwdatamigrate.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.huawei.hwdatamigrate.a.w;
import com.huawei.hwdatamigrate.a.x;
import com.huawei.p190v.C2538c;

/* compiled from: InternalStorageUtil */
public class C0999h {
    public static String m3626a(Context context, String str) {
        x a;
        try {
            a = new w(context).a(str);
        } catch (Exception e) {
            C2538c.m12680e("InternalStorageUtil", "getRemindTable() Exception=" + e.getMessage());
            a = null;
        }
        if (a != null) {
            return a.c;
        }
        C2538c.m12674b("InternalStorageUtil", "getRemindTable() DB do not contain, so we use default value");
        return null;
    }

    public static void m3628a(Context context, String str, String str2) {
        w wVar = new w(context);
        x xVar = new x();
        xVar.b = str;
        xVar.c = str2;
        if (wVar.b(str).booleanValue()) {
            wVar.b(xVar);
        } else {
            wVar.a(xVar);
        }
    }

    public static boolean m3629a(Context context) {
        return Boolean.parseBoolean(C0999h.m3626a(context, "KEY_ANTI_LOST_REMIND"));
    }

    public static void m3627a(Context context, int i) {
        C0999h.m3628a(context, "KEY_SYNC_TIME_STAMP", String.valueOf(i));
    }

    public static String m3630b(Context context) {
        return C0999h.m3626a(context, "KEY_DEVICE_IMEI");
    }

    public static SharedPreferences m3625a(SharedPreferences sharedPreferences, Context context) {
        return context.getSharedPreferences("sharedPreferences", 4);
    }

    public static Editor m3624a(SharedPreferences sharedPreferences, Editor editor, Context context) {
        return sharedPreferences.edit();
    }

    public static boolean m3631c(Context context) {
        return C0999h.m3626a(context, "KEY_SERVICE_ATUO_SCRENN_UP_SWITCH_STATUS") == null ? true : Boolean.valueOf(C0999h.m3626a(context, "KEY_SERVICE_ATUO_SCRENN_UP_SWITCH_STATUS")).booleanValue();
    }

    public static String m3632d(Context context) {
        String a = C0999h.m3626a(context, "KEY_BONE_KEY_FILE_NAME_ONE");
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        return a;
    }

    public static String m3633e(Context context) {
        String a = C0999h.m3626a(context, "KEY_BONE_KEY_FILE_NAME_TWO");
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        return a;
    }

    public static String m3634f(Context context) {
        return C0999h.m3626a(context, "key_other_login_st");
    }

    public static boolean m3635g(Context context) {
        Object a = C0999h.m3626a(context, "KEY_HUAWEI_CLOUD_SERVICE_SWITCH_ON");
        C2538c.m12674b("InternalStorageUtil", "getCloudServiceOn: value = " + a);
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        return Boolean.parseBoolean(a);
    }

    public static boolean m3636h(Context context) {
        Object a = C0999h.m3626a(context, "KEY_HUAWEI_CLOUD_SERVICE_USERINFOR_SWITCH_ON");
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        return Boolean.parseBoolean(a);
    }
}
