package com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;

/* compiled from: AppUtil */
public class C5478a {
    private static String f19338a = "";

    public static String m26180a(Context context) {
        if (TextUtils.isEmpty(f19338a)) {
            ApplicationInfo applicationInfo = null;
            if (context != null) {
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (NameNotFoundException e) {
                    C5482d.m26186d("AppUtil", "getChannel NameNotFoundException");
                }
            } else {
                C5482d.m26186d("AppUtil", "context == null");
            }
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("MEMBERSDK_CHANNEL");
                if (obj != null) {
                    f19338a = obj.toString();
                } else {
                    C5482d.m26186d("AppUtil", "getChannel obj is null");
                    f19338a = applicationInfo.metaData.getInt("MEMBERSDK_CHANNEL") + "";
                }
            }
        }
        return f19338a;
    }
}
