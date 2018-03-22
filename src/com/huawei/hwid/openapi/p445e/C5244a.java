package com.huawei.hwid.openapi.p445e;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

public class C5244a {
    public static boolean m25427a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
