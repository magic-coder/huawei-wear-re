package com.cmb.pboc.logger;

import android.util.Log;

public class PbocLog {
    public static void m17738a(String str, String str2) {
        if (str != null) {
            Log.d("PboccmB" + str, " - ^ - " + str2);
        } else {
            Log.d("PboccmB", " - ^ - " + str2);
        }
    }

    public static void m17739b(String str, String str2) {
        if (str != null) {
            Log.i("PboccmB" + str, " - ^ - " + str2);
        } else {
            Log.i("PboccmB", " - ^ - " + str2);
        }
    }

    public static void m17740c(String str, String str2) {
        if (str != null) {
            Log.w("PboccmB" + str, " - ^ - " + str2);
        } else {
            Log.w("PboccmB", " - ^ - " + str2);
        }
    }

    public static void m17741d(String str, String str2) {
        if (str != null) {
            Log.e("PboccmB" + str, " - ^ - " + str2);
        } else {
            Log.e("PboccmB", " - ^ - " + str2);
        }
    }
}
