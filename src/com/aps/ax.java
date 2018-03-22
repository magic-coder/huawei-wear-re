package com.aps;

import android.util.SparseArray;

/* compiled from: Const */
public class ax {
    static String f12971a = null;
    static String f12972b = null;
    static String f12973c = null;
    static String f12974d = "";
    static String f12975e = "";
    static String f12976f = "";
    static boolean f12977g = false;
    static boolean f12978h = true;
    static long f12979i = 10000;
    static long f12980j = StatisticConfig.MIN_UPLOAD_INTERVAL;
    static boolean f12981k = true;
    static final SparseArray<String> f12982l = new SparseArray();
    static final String[] f12983m = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    static {
        f12982l.append(0, "UNKNOWN");
        f12982l.append(1, "GPRS");
        f12982l.append(2, "EDGE");
        f12982l.append(3, "UMTS");
        f12982l.append(4, "CDMA");
        f12982l.append(5, "EVDO_0");
        f12982l.append(6, "EVDO_A");
        f12982l.append(7, "1xRTT");
        f12982l.append(8, "HSDPA");
        f12982l.append(9, "HSUPA");
        f12982l.append(10, "HSPA");
        f12982l.append(11, "IDEN");
        f12982l.append(12, "EVDO_B");
        f12982l.append(13, "LTE");
        f12982l.append(14, "EHRPD");
        f12982l.append(15, "HSPAP");
    }

    static void m17352a(String str) {
        f12974d = str;
    }

    static void m17354b(String str) {
        f12975e = str;
    }

    static void m17355c(String str) {
        f12976f = str;
    }

    static void m17353a(boolean z) {
        f12977g = z;
    }
}
