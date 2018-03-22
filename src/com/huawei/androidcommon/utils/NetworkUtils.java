package com.huawei.androidcommon.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
    public static int getNetworkType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? -1 : activeNetworkInfo.getType();
    }

    public static boolean checkNetworkStatus(Context context) {
        if (getNetworkType(context) < 0) {
            return false;
        }
        return true;
    }
}
