package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.C0467l;

public class cx {
    protected final Context f675a;

    public cx(Context context) {
        this.f675a = context;
    }

    public ApplicationInfo m1177a(String str, int i) throws NameNotFoundException {
        return this.f675a.getPackageManager().getApplicationInfo(str, i);
    }

    public CharSequence m1178a(String str) throws NameNotFoundException {
        return this.f675a.getPackageManager().getApplicationLabel(this.f675a.getPackageManager().getApplicationInfo(str, 0));
    }

    @TargetApi(19)
    public boolean m1179a(int i, String str) {
        if (C0467l.m829e()) {
            try {
                ((AppOpsManager) this.f675a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.f675a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public PackageInfo m1180b(String str, int i) throws NameNotFoundException {
        return this.f675a.getPackageManager().getPackageInfo(str, i);
    }
}
