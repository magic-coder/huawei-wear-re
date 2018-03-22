package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/* compiled from: AppFieldsDefaultProvider */
class C3657i implements C3649n {
    private static C3657i f14179e;
    private static Object f14180f = new Object();
    protected String f14181a;
    protected String f14182b;
    protected String f14183c;
    protected String f14184d;

    public static void m18354a(Context context) {
        synchronized (f14180f) {
            if (f14179e == null) {
                f14179e = new C3657i(context);
            }
        }
    }

    public static C3657i m18353a() {
        return f14179e;
    }

    private C3657i(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.f14183c = context.getPackageName();
        this.f14184d = packageManager.getInstallerPackageName(this.f14183c);
        String str = this.f14183c;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            ar.m18264a("Error retrieving package info: appName set to " + str);
        }
        this.f14181a = str;
        this.f14182b = str2;
    }

    protected C3657i() {
    }

    public String mo4248a(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("&an")) {
            return this.f14181a;
        }
        if (str.equals("&av")) {
            return this.f14182b;
        }
        if (str.equals("&aid")) {
            return this.f14183c;
        }
        if (str.equals("&aiid")) {
            return this.f14184d;
        }
        return null;
    }
}
