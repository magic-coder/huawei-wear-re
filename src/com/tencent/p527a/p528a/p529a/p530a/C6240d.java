package com.tencent.p527a.p528a.p529a.p530a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

final class C6240d extends C6237f {
    public C6240d(Context context) {
        super(context);
    }

    protected final void mo5283a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
            edit.putString(C6243h.m28696c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }

    protected final boolean mo5284a() {
        return true;
    }

    protected final String mo5285b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.a).getString(C6243h.m28696c("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }
}
