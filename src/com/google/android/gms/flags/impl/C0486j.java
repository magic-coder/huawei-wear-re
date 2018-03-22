package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.dc;

public class C0486j {
    private static SharedPreferences f504a = null;

    public static SharedPreferences m843a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f504a == null) {
                f504a = (SharedPreferences) dc.m1189a(new C0487k(context));
            }
            sharedPreferences = f504a;
        }
        return sharedPreferences;
    }
}
