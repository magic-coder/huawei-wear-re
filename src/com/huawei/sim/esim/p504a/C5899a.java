package com.huawei.sim.esim.p504a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import com.huawei.hwcommonmodel.p064d.C4725b;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p190v.C2538c;

/* compiled from: EsimUtil */
public class C5899a {
    private static final String[] f20194a = new String[]{"android.permission.CAMERA"};

    public static int m27105a(String str) {
        int i = 0;
        try {
            if (str.indexOf(".") > 0) {
                str = str.substring(0, str.indexOf("."));
            }
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C2538c.e("EsimUtil", new Object[]{"Exception e = " + e.getMessage()});
        }
        return i;
    }

    public static boolean m27107a(Context context, String[] strArr) {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        C2538c.c("EsimUtil", new Object[]{"hasPermission =" + C4725b.m22616a(context, strArr)});
        return C4725b.m22616a(context, strArr);
    }

    public static void m27106a(Context context) {
        if (context != null) {
            PackageInfo packageInfo;
            String str = "com.google.android.wearable.app";
            String str2 = NFCBaseActivity.AW_NAME_CN;
            PackageManager packageManager = context.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(str2, 0);
            } catch (NameNotFoundException e) {
                C2538c.c("EsimUtil", new Object[]{"onClick() androidWearNameCn, error = " + e.getMessage()});
                try {
                    packageInfo = packageManager.getPackageInfo(str, 0);
                } catch (NameNotFoundException e2) {
                    C2538c.c("EsimUtil", new Object[]{"onClick() androidWearName, error = " + e2.getMessage()});
                    packageInfo = null;
                }
            }
            if (packageInfo != null) {
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(packageInfo.packageName);
                ResolveInfo resolveInfo = (ResolveInfo) context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
                if (resolveInfo != null) {
                    String str3 = resolveInfo.activityInfo.packageName;
                    str = resolveInfo.activityInfo.name;
                    intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.setComponent(new ComponentName(str3, str));
                    context.startActivity(intent);
                }
            }
        }
    }
}
