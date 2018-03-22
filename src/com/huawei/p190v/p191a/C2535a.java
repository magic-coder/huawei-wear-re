package com.huawei.p190v.p191a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* compiled from: ManangeLog */
public class C2535a {
    private static String f9030a = "ManageLog";
    private static boolean f9031b = true;

    public static void m12642a(boolean z) {
        f9031b = z;
    }

    public static boolean m12643a(Context context) {
        if (context == null) {
            Log.e(f9030a, "isHavePermission()=false because context=null");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        int checkPermission = packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", packageName);
        int checkPermission2 = packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", packageName);
        if (checkPermission == 0 && checkPermission2 == 0) {
            return true;
        }
        Log.d(f9030a, "isHavePermission()=false");
        return false;
    }
}
