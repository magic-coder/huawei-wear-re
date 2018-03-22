package com.huawei.hms.p039c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetWorkUtil */
public class C0855d {
    public static int m3011a(Context context) {
        return C0855d.m3012a(C0855d.m3013b(context));
    }

    private static NetworkInfo m3013b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    private static int m3012a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return 1;
            }
            if (networkInfo.getType() == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 15:
                        return 3;
                    case 13:
                    case 14:
                        return 4;
                    default:
                        return 6;
                }
            }
        }
        return 0;
    }
}
