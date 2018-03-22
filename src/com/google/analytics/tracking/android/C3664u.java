package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

/* compiled from: FutureApis */
class C3664u {
    public static int m18375a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            ar.m18264a("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    static boolean m18376a(String str) {
        if (C3664u.m18375a() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
