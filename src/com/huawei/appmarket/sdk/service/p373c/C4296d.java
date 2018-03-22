package com.huawei.appmarket.sdk.service.p373c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.conn.util.InetAddressUtils;

public class C4296d {
    public static String m20726a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String m20727a(Context context) {
        if (context == null) {
            return "UNKNOWN";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "UNKNOWN";
        }
        String extraInfo = activeNetworkInfo.getExtraInfo();
        switch (activeNetworkInfo.getType()) {
            case 0:
                return C4296d.m20729b(extraInfo) ? "UNKNOWN" : extraInfo;
            case 1:
                return "WIFI";
            default:
                return "UNKNOWN";
        }
    }

    public static InetAddress[] m20728a(String str) {
        try {
            return InetAddress.getAllByName(str);
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public static boolean m20729b(String str) {
        return str == null || str.trim().equals("");
    }

    protected static void m20730c(String str) {
        new Thread(new C4305m(str)).start();
    }

    public static boolean m20731d(String str) {
        return InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str);
    }
}
