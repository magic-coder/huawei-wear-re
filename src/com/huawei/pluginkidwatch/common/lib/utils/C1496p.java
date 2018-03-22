package com.huawei.pluginkidwatch.common.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.p190v.C2538c;

/* compiled from: SharedPreferencesPush */
public class C1496p {
    private static SharedPreferences f3495a;
    private static Editor f3496b;

    private static void m6933a(Context context) {
        f3495a = context.getSharedPreferences("sharedPreferences_for_push", 4);
        f3496b = f3495a.edit();
    }

    public static Boolean m6932a(Context context, String str, boolean z) {
        C2538c.m12674b("SharedPreferencesPush", "=====enter getBoolean");
        C1496p.m6933a(context);
        return Boolean.valueOf(f3495a.getBoolean(str, z));
    }

    public static void m6934a(Context context, String str, Boolean bool) {
        C2538c.m12674b("SharedPreferencesPush", "=====value:" + bool);
        C1496p.m6933a(context);
        f3496b.putBoolean(str, bool.booleanValue());
        f3496b.commit();
    }
}
