package com.google.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

/* compiled from: SharedPreferencesUtil */
class bc {
    static void m18515a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new bd(editor)).start();
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    static void m18514a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m18515a(edit);
    }
}
