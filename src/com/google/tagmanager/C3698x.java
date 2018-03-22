package com.google.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

/* compiled from: FutureApis */
class C3698x {
    public static int m18618a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            C3700z.m18624a("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    @TargetApi(9)
    static boolean m18619a(String str) {
        if (C3698x.m18618a() < 9) {
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
