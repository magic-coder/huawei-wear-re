package com.tencent.open.p541a;

import java.io.File;
import java.io.FileFilter;

/* compiled from: ProGuard */
class C6357d implements FileFilter {
    final /* synthetic */ C6355b f22124a;

    C6357d(C6355b c6355b) {
        this.f22124a = c6355b;
    }

    public boolean accept(File file) {
        if (file.getName().endsWith(this.f22124a.m29087i()) && C6355b.m29066f(file) != -1) {
            return true;
        }
        return false;
    }
}
