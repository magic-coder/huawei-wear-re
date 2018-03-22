package com.tencent.p527a.p528a.p529a.p530a;

import android.content.Context;
import android.provider.Settings.System;
import android.util.Log;

public final class C6241e extends C6237f {
    public C6241e(Context context) {
        super(context);
    }

    protected final void mo5283a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            System.putString(this.a.getContentResolver(), C6243h.m28696c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    protected final boolean mo5284a() {
        return C6243h.m28692a(this.a, "android.permission.WRITE_SETTINGS");
    }

    protected final String mo5285b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            string = System.getString(this.a.getContentResolver(), C6243h.m28696c("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }
}
