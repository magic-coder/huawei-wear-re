package com.tencent.wxop.stat.p547b;

import java.io.File;

final class C6521p {
    private static int f22735a = -1;

    public static boolean m29775a() {
        if (f22735a == 1) {
            return true;
        }
        if (f22735a == 0) {
            return false;
        }
        String[] strArr = new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < strArr.length) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    f22735a = 1;
                    return true;
                }
                i++;
            } catch (Exception e) {
            }
        }
        f22735a = 0;
        return false;
    }
}
