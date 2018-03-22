package com.huawei.hwdatamigrate.hihealth.p419i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.huawei.hihealth.HiAppInfo;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import com.huawei.p190v.C2538c;

/* compiled from: HiAppUtil */
public class C4938a {
    public static String m23801a(int i) {
        switch (i) {
            case 1:
            case 1001:
                return WeChat.HEALTH_PACKAGE_NAME;
            case 2:
            case 1002:
                return "com.huawei.bone";
            default:
                return "unknown";
        }
    }

    public static int m23799a(String str) {
        if (WeChat.HEALTH_PACKAGE_NAME.equals(str)) {
            return 1;
        }
        if ("com.huawei.bone".equals(str)) {
            return 2;
        }
        return 0;
    }

    public static String m23802b(String str) {
        if (WeChat.HEALTH_PACKAGE_NAME.equals(str)) {
            return "运动健康";
        }
        if ("com.huawei.bone".equals(str)) {
            return "华为穿戴";
        }
        return "未知APP";
    }

    public static HiAppInfo m23800a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        HiAppInfo hiAppInfo = new HiAppInfo();
        hiAppInfo.setPackageName(str);
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            hiAppInfo.setVersion(packageInfo.versionName);
            hiAppInfo.setAppName((String) packageManager.getApplicationLabel(applicationInfo));
            hiAppInfo.setSignature(C4543e.m21779a(packageInfo.signatures));
        } catch (NameNotFoundException e) {
            C2538c.e("Debug_HiAppUtil", new Object[]{"createExplicitIntent() e = ", e.getMessage()});
        }
        return hiAppInfo;
    }
}
