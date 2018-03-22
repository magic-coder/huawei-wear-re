package com.huawei.openalliance.ad.p112a.p113a.p115b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

public class C1219e extends C1211a {
    private static final String TAG = "App";
    private String name__;
    private String pkgname__;
    private String version__;

    public C1219e(Context context) {
        this.pkgname__ = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.pkgname__, 0);
                this.version__ = packageInfo.versionName;
                this.name__ = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable e) {
                C1336d.m5883a(TAG, "fail to get packageInfo", e);
            }
        }
    }

    public String getName__() {
        return this.name__;
    }

    public String getPkgname__() {
        return this.pkgname__;
    }

    public String getVersion__() {
        return this.version__;
    }

    public void setName__(String str) {
        this.name__ = str;
    }

    public void setPkgname__(String str) {
        this.pkgname__ = str;
    }

    public void setVersion__(String str) {
        this.version__ = str;
    }
}
