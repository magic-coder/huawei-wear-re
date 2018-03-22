package com.tencent.wxop.stat.p547b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class C6522q {
    private static SharedPreferences f22736a = null;

    public static int m29776a(Context context, String str, int i) {
        return C6522q.m29778a(context).getInt(C6517l.m29731a(context, "wxop_" + str), i);
    }

    public static long m29777a(Context context, String str) {
        return C6522q.m29778a(context).getLong(C6517l.m29731a(context, "wxop_" + str), 0);
    }

    private static synchronized SharedPreferences m29778a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C6522q.class) {
            sharedPreferences = context.getSharedPreferences(".mta-wxop", 0);
            f22736a = sharedPreferences;
            if (sharedPreferences == null) {
                f22736a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f22736a;
        }
        return sharedPreferences;
    }

    public static String m29779a(Context context, String str, String str2) {
        return C6522q.m29778a(context).getString(C6517l.m29731a(context, "wxop_" + str), str2);
    }

    public static void m29780a(Context context, String str, long j) {
        String a = C6517l.m29731a(context, "wxop_" + str);
        Editor edit = C6522q.m29778a(context).edit();
        edit.putLong(a, j);
        edit.commit();
    }

    public static void m29781b(Context context, String str, int i) {
        String a = C6517l.m29731a(context, "wxop_" + str);
        Editor edit = C6522q.m29778a(context).edit();
        edit.putInt(a, i);
        edit.commit();
    }

    public static void m29782b(Context context, String str, String str2) {
        String a = C6517l.m29731a(context, "wxop_" + str);
        Editor edit = C6522q.m29778a(context).edit();
        edit.putString(a, str2);
        edit.commit();
    }
}
