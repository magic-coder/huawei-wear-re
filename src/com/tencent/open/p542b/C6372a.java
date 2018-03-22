package com.tencent.open.p542b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
public class C6372a {
    protected static final String f22169a = C6372a.class.getName();
    protected static final Uri f22170b = Uri.parse("content://telephony/carriers/preferapn");

    public static String m29132a(Context context) {
        int d = C6372a.m29135d(context);
        if (d == 2) {
            return "wifi";
        }
        if (d == 1) {
            return "cmwap";
        }
        if (d == 4) {
            return "cmnet";
        }
        if (d == 16) {
            return "uniwap";
        }
        if (d == 8) {
            return "uninet";
        }
        if (d == 64) {
            return "wap";
        }
        if (d == 32) {
            return "net";
        }
        if (d == 512) {
            return "ctwap";
        }
        if (d == 256) {
            return "ctnet";
        }
        if (d == 2048) {
            return "3gnet";
        }
        if (d == 1024) {
            return "3gwap";
        }
        String b = C6372a.m29133b(context);
        if (b == null || b.length() == 0) {
            return "none";
        }
        return b;
    }

    public static String m29133b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f22170b, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("apn"));
            if (query == null) {
                return string;
            }
            query.close();
            return string;
        } catch (SecurityException e) {
            C6367n.m29112e(f22169a, "getApn has exception: " + e.getMessage());
            return "";
        }
    }

    public static String m29134c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f22170b, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            if (query == null) {
                return string;
            }
            query.close();
            return string;
        } catch (SecurityException e) {
            C6367n.m29112e(f22169a, "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    public static int m29135d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 128;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 128;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String toLowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (toLowerCase.startsWith("cmnet") || toLowerCase.startsWith("epc.tmobile.com")) {
                return 4;
            }
            if (toLowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (toLowerCase.startsWith("uninet")) {
                return 8;
            }
            if (toLowerCase.startsWith("wap")) {
                return 64;
            }
            if (toLowerCase.startsWith("net")) {
                return 32;
            }
            if (toLowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (toLowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (toLowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (toLowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (toLowerCase.startsWith("#777")) {
                toLowerCase = C6372a.m29134c(context);
                if (toLowerCase == null || toLowerCase.length() <= 0) {
                    return 256;
                }
                return 512;
            }
            return 128;
        } catch (Exception e) {
            C6367n.m29112e(f22169a, "getMProxyType has exception: " + e.getMessage());
        }
    }

    public static String m29136e(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "MOBILE";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getTypeName();
        }
        return "MOBILE";
    }
}
