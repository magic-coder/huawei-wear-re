package com.huawei.pluginmessagecenter;

import android.content.Context;

/* compiled from: MessageSharedPrefrence */
public class C5870i {
    public static void m27066a(Context context, String str) {
        C5862a.m27025a(context).setSharedPreference("currentHuid", str, null);
    }

    public static void m27068b(Context context, String str) {
        C5862a.m27025a(context).setSharedPreference("lastLanguage", str, null);
    }

    public static void m27070c(Context context, String str) {
        C5862a.m27025a(context).setSharedPreference("push_token", str, null);
    }

    public static String m27065a(Context context) {
        return C5862a.m27025a(context).getSharedPreference("lastHuid");
    }

    public static void m27071d(Context context, String str) {
        C5862a.m27025a(context).setSharedPreference("lastHuid", str, null);
    }

    public static String m27067b(Context context) {
        return C5862a.m27025a(context).getSharedPreference("lastLanguage");
    }

    public static String m27069c(Context context) {
        return C5862a.m27025a(context).getSharedPreference("currentHuid");
    }
}
