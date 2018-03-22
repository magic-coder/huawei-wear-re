package com.aps;

import android.content.Context;
import android.util.Log;

public final class ao {
    private static String f12913a = "";

    protected static void m17282a(String str) {
        if (!str.equals("GPS_SATELLITE")) {
        }
    }

    protected static boolean m17283a(Context context) {
        if (context != null) {
            f12913a = context.getPackageName();
            return true;
        }
        Log.d(f12913a, "Error: No SD Card!");
        return false;
    }
}
