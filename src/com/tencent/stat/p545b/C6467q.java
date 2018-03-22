package com.tencent.stat.p545b;

import java.io.File;

class C6467q {
    private static int f22441a = -1;

    public static boolean m29489a() {
        if (f22441a == 1) {
            return true;
        }
        if (f22441a == 0) {
            return false;
        }
        String[] strArr = new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < strArr.length) {
            try {
                File file = new File(strArr[i] + "su");
                if (file == null || !file.exists()) {
                    i++;
                } else {
                    f22441a = 1;
                    return true;
                }
            } catch (Exception e) {
            }
        }
        f22441a = 0;
        return false;
    }
}
