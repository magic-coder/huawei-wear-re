package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import java.io.File;

/* compiled from: AbstractFileCache */
public abstract class C1885a {
    private String f6207a = mo2625a();

    public abstract String mo2625a();

    public abstract String mo2626b(String str);

    public C1885a(Context context) {
    }

    public File m9645a(String str) {
        return new File(mo2626b(str));
    }
}
