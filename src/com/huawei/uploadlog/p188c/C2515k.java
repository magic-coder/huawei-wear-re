package com.huawei.uploadlog.p188c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.huawei.crowdtestsdk.common.AppContext;

/* compiled from: SettingsPreferenceUtils */
public class C2515k {
    protected static Context m12539a() {
        return AppContext.getInstance().getApplicationContext();
    }

    public static String m12546b() {
        return C2515k.m12540a("current_parent_file", null);
    }

    public static void m12542a(String str) {
        C2515k.m12543a("settings", "current_parent_file", str);
    }

    public static String m12540a(String str, String str2) {
        SharedPreferences sharedPreferences = C2515k.m12539a().getSharedPreferences(str, 4);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str2, null);
    }

    public static void m12543a(String str, String str2, String str3) {
        SharedPreferences sharedPreferences = C2515k.m12539a().getSharedPreferences(str, 4);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static String m12549c() {
        return C2515k.m12540a("settings_project", "default_project_id");
    }

    public static void m12548b(String str) {
        C2515k.m12543a("settings_project", "default_project_id", str);
        C2511g.m12481b("BETACLUB_SDK", "[SettingPreferenceUtils.setDefaultProjectId]SETTINGS_DEFAULT_PROJECT_ID is :" + str);
    }

    public static String m12552d() {
        return C2515k.m12540a("settings_project", "default_project_name");
    }

    public static void m12551c(String str) {
        C2515k.m12543a("settings_project", "default_project_name", str);
    }

    public static void m12541a(Context context) {
        C2515k.m12547b(context);
        C2515k.m12553d(context);
        C2515k.m12550c(context);
    }

    public static void m12547b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("settings", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public static void m12550c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("settings_project", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public static void m12553d(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("current_parent_file", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public static void m12545a(boolean z) {
        C2515k.m12544a("feedback_service_alive", z);
    }

    public static void m12544a(String str, boolean z) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(C2515k.m12539a()).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }
}
