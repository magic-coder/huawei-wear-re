package com.huawei.uploadlog.p188c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.crowdtestsdk.bases.bean_new.SecUtils;
import com.huawei.crowdtestsdk.common.AppContext;

/* compiled from: PreferenceUtils */
public class C2514j {
    private static String m12524c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("upload_preference", 4);
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str, "");
    }

    private static void m12512a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("upload_preference", 4);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public static String m12507a(Context context) {
        return C2514j.m12524c(context, "imei");
    }

    public static void m12511a(Context context, String str) {
        C2514j.m12512a(context, "imei", str);
    }

    public static void m12521b(Context context, String str) {
        C2514j.m12512a(context, "sn", str);
    }

    public static String m12520b(Context context) {
        return C2514j.m12524c(context, "imei");
    }

    protected static Context m12506a() {
        return AppContext.getInstance().getApplicationContext();
    }

    private static long m12528e(String str) {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("logInfo", 4);
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong(str, 0);
    }

    private static void m12516a(String str, String str2) {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("logInfo", 4);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    private static void m12517a(String str, boolean z) {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("logInfo", 4);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    private static Boolean m12531f(String str) {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("logInfo", 4);
        if (sharedPreferences == null) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
    }

    public static void m12514a(String str) {
        C2514j.m12516a("currentUserId", SecUtils.getString1(str));
    }

    public static String m12519b() {
        return SecUtils.getString2(C2514j.m12532g("currentUserId"));
    }

    private static String m12532g(String str) {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("logInfo", 4);
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str, "");
    }

    public static String m12523c() {
        return C2514j.m12532g("currentUserAccount");
    }

    public static void m12522b(String str) {
        C2514j.m12516a("currentUserAccount", str);
    }

    public static void m12508a(int i) {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("productType", 4);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putInt("productType", i);
            edit.commit();
        }
    }

    public static int m12526d() {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("productType", 4);
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt("productType", -1);
    }

    public static String m12529e() {
        return C2514j.m12532g("cloudLoginBean");
    }

    public static void m12525c(String str) {
        C2514j.m12516a("cloudLoginBean", str);
    }

    public static void m12509a(long j) {
        C2514j.m12515a("lastProjectUpdateTime", j);
    }

    private static void m12515a(String str, long j) {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("logInfo", 4);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public static long m12530f() {
        return C2514j.m12528e("lastProjectUpdateTime");
    }

    public static void m12533g() {
        C2514j.m12534h();
        C2514j.m12535i();
        C2514j.m12536j();
    }

    public static void m12534h() {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("logInfo", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public static void m12535i() {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("productType", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public static void m12536j() {
        SharedPreferences sharedPreferences = C2514j.m12506a().getSharedPreferences("upload_preference", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public static void m12527d(String str) {
        C2514j.m12516a("userType", str);
    }

    public static void m12510a(Context context, long j) {
        C2514j.m12515a("currentAgreementVersion", j);
    }

    public static void m12513a(Context context, boolean z) {
        C2514j.m12517a("current_agreement_status", z);
    }

    public static boolean m12537k() {
        return C2514j.m12531f("current_agreement_status").booleanValue();
    }

    public static boolean m12538l() {
        return C2514j.m12531f("isLogin").booleanValue();
    }

    public static void m12518a(boolean z) {
        C2514j.m12517a("isLogin", z);
    }
}
