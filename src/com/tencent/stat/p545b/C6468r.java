package com.tencent.stat.p545b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class C6468r {
    private static SharedPreferences f22442a = null;

    public static int m29490a(Context context, String str, int i) {
        return C6468r.m29492a(context).getInt(C6463m.m29451b(context, "" + str), i);
    }

    public static long m29491a(Context context, String str, long j) {
        return C6468r.m29492a(context).getLong(C6463m.m29451b(context, "" + str), j);
    }

    static synchronized SharedPreferences m29492a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C6468r.class) {
            if (f22442a == null) {
                f22442a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f22442a;
        }
        return sharedPreferences;
    }

    public static String m29493a(Context context, String str, String str2) {
        return C6468r.m29492a(context).getString(C6463m.m29451b(context, "" + str), str2);
    }

    public static void m29494b(Context context, String str, int i) {
        String b = C6463m.m29451b(context, "" + str);
        Editor edit = C6468r.m29492a(context).edit();
        edit.putInt(b, i);
        edit.commit();
    }

    public static void m29495b(Context context, String str, long j) {
        String b = C6463m.m29451b(context, "" + str);
        Editor edit = C6468r.m29492a(context).edit();
        edit.putLong(b, j);
        edit.commit();
    }

    public static void m29496b(Context context, String str, String str2) {
        String b = C6463m.m29451b(context, "" + str);
        Editor edit = C6468r.m29492a(context).edit();
        edit.putString(b, str2);
        edit.commit();
    }
}
