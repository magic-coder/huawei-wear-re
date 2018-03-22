package com.huawei.pluginkidwatch.plugin.menu.utils;

import java.io.File;

/* compiled from: FileHelper */
public class C1893j {
    public static String m9661a(String str) {
        if (str != null && str.length() > 0) {
            File file = new File(str);
            if (file != null) {
                return file.getName().substring(0, file.getName().indexOf(46));
            }
        }
        return "";
    }
}
