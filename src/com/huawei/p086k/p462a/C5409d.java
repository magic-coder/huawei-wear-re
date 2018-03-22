package com.huawei.p086k.p462a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/* compiled from: PackageManagerHelper */
public class C5409d {
    private final PackageManager f19223a;

    public C5409d(Context context) {
        this.f19223a = context.getPackageManager();
    }

    public int m25999a(String str) {
        try {
            PackageInfo packageInfo = this.f19223a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }
}
