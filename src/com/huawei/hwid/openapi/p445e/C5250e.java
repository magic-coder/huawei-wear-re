package com.huawei.hwid.openapi.p445e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class C5250e {
    public static boolean m25454a(Context context) {
        return 1 == C5250e.m25455b(context);
    }

    public static int m25455b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) ? -100 : activeNetworkInfo.getType();
    }

    public static void m25456c(Context context) {
        CookieSyncManager.createInstance(context);
        CookieSyncManager.getInstance().startSync();
        CookieManager.getInstance().removeSessionCookie();
    }
}
