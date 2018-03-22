package com.huawei.aj.p315a.p318c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetworkUtil */
public final class C4026a {
    public static boolean m19819a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
