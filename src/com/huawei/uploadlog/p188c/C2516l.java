package com.huawei.uploadlog.p188c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.crowdtestsdk.common.AppContext;

/* compiled from: TimePreferenceUtils */
public class C2516l {
    public static void m12554a() {
        C2516l.m12555a(System.currentTimeMillis());
    }

    private static void m12555a(long j) {
        C2516l.m12556a("times", "accept_license_agreement_time", j);
    }

    protected static Context m12557b() {
        return AppContext.getInstance().getApplicationContext();
    }

    public static void m12556a(String str, String str2, long j) {
        SharedPreferences sharedPreferences = C2516l.m12557b().getSharedPreferences(str, 4);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    public static void m12558c() {
        SharedPreferences sharedPreferences = C2516l.m12557b().getSharedPreferences("times", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }
}
