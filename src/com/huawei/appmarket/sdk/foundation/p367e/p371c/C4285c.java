package com.huawei.appmarket.sdk.foundation.p367e.p371c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import org.apache.http.HttpHost;

public class C4285c {
    private static String f15966a = "NetworkUtil";
    private static int f15967b = -1;
    private static int f15968c = -1;
    private static HttpHost f15969d = null;

    public static int m20679a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static HttpHost m20680a() {
        return f15969d;
    }

    public static void m20681a(int i) {
        f15968c = i;
    }

    public static void m20682a(HttpHost httpHost) {
        f15969d = httpHost;
    }

    public static boolean m20683a(Context context) {
        if (-1 == f15968c) {
            C4285c.m20685b(context);
        }
        return f15968c == -3;
    }

    private static boolean m20684a(NetworkInfo networkInfo, Context context) {
        int type = networkInfo.getType();
        boolean b = C4283a.m20669b(context);
        if (type != 0 || !b) {
            return false;
        }
        String host = Proxy.getHost(context);
        int port = Proxy.getPort(context);
        HttpHost httpHost = null;
        if (!(host == null || host.length() <= 0 || port == -1)) {
            httpHost = new HttpHost(host, port);
        }
        C4285c.m20682a(httpHost);
        return true;
    }

    public static int m20685b(Context context) {
        if (-1 == f15967b) {
            C4241a.m20529a(f15966a, "getPsType() need init");
            if (context != null) {
                C4285c.m20687c(context);
            }
        }
        return f15967b;
    }

    public static void m20686b(int i) {
        f15967b = i;
    }

    public static void m20687c(Context context) {
        try {
            C4285c.m20681a(0);
            NetworkInfo f = C4285c.m20690f(context);
            if (f == null) {
                C4241a.m20529a(f15966a, "setPsType() info = null");
                return;
            }
            f15967b = C4285c.m20679a(f);
            if (1 != f15967b) {
                if (C4285c.m20684a(f, context)) {
                    C4285c.m20681a(-3);
                } else {
                    C4285c.m20681a(-2);
                }
            }
            C4285c.m20686b(f15967b);
        } catch (Throwable e) {
            C4241a.m20530a(f15966a, "setPsType() exception is", e);
        }
    }

    public static boolean m20688d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        return networkInfo == null ? false : networkInfo.isConnectedOrConnecting();
    }

    public static boolean m20689e(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    private static NetworkInfo m20690f(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }
}
