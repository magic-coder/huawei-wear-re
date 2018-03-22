package com.cmcc.sso.sdk.p013b;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class C0328b {
    public static synchronized void m208a(Context context, String str, String str2) {
        synchronized (C0328b.class) {
            Editor edit = context.getSharedPreferences("config", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public static synchronized String m209b(Context context, String str, String str2) {
        String string;
        synchronized (C0328b.class) {
            string = context.getSharedPreferences("config", 0).getString(str, str2);
        }
        return string;
    }
}
