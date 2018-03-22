package com.google.zxing.client.android.p286a;

import android.content.SharedPreferences;

/* compiled from: FrontLightMode */
public enum C3776f {
    ON,
    AUTO,
    OFF;

    private static C3776f m19000a(String str) {
        return str == null ? OFF : C3776f.valueOf(str);
    }

    public static C3776f m18999a(SharedPreferences sharedPreferences) {
        return C3776f.m19000a(sharedPreferences.getString("preferences_front_light_mode", null));
    }
}
