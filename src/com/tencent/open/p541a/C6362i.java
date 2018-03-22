package com.tencent.open.p541a;

import java.io.File;

/* compiled from: ProGuard */
public final class C6362i {
    public static boolean m29091a(File file) {
        int i = 0;
        if (file == null) {
            return false;
        }
        if (file.isFile()) {
            if (file.delete()) {
                return true;
            }
            file.deleteOnExit();
            return false;
        } else if (!file.isDirectory()) {
            return false;
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return false;
            }
            int length = listFiles.length;
            while (i < length) {
                C6362i.m29091a(listFiles[i]);
                i++;
            }
            return file.delete();
        }
    }
}
