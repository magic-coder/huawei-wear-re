package com.tencent.open.p541a;

import java.io.File;
import java.io.FileFilter;

/* compiled from: ProGuard */
final class C6356c implements FileFilter {
    C6356c() {
    }

    public boolean accept(File file) {
        if (file.isDirectory() && C6355b.m29062a(file) > 0) {
            return true;
        }
        return false;
    }
}
