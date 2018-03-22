package com.tencent.open.p541a;

import java.io.File;
import java.util.Comparator;

/* compiled from: ProGuard */
class C6358e implements Comparator<File> {
    final /* synthetic */ C6355b f22125a;

    C6358e(C6355b c6355b) {
        this.f22125a = c6355b;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m29089a((File) obj, (File) obj2);
    }

    public int m29089a(File file, File file2) {
        return C6355b.m29066f(file) - C6355b.m29066f(file2);
    }
}
