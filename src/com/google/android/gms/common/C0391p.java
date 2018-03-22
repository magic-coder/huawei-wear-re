package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.c;
import com.google.android.gms.common.internal.bd;
import com.google.android.gms.common.util.C0462g;
import com.google.android.gms.common.util.C0463h;
import com.google.android.gms.common.util.C0467l;
import com.google.android.gms.common.util.C0468m;
import java.util.concurrent.atomic.AtomicBoolean;

public class C0391p {
    private static boolean f310a = false;
    @Deprecated
    public static final int f311b = 10298000;
    public static boolean f312c = false;
    public static boolean f313d = false;
    static boolean f314e = false;
    static final AtomicBoolean f315f = new AtomicBoolean();
    private static final AtomicBoolean f316g = new AtomicBoolean();

    @Deprecated
    public static String m446a(int i) {
        return ConnectionResult.getStatusString(i);
    }

    private static void m447a(Context context) {
        if (!f316g.get()) {
            int a = bd.m643a(context);
            if (a == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (a != f311b) {
                int i = f311b;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(a).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    @Deprecated
    public static boolean m448a() {
        return C0462g.m816a();
    }

    @Deprecated
    public static boolean m449a(Context context, int i) {
        return C0468m.m833a(context, i);
    }

    @TargetApi(21)
    static boolean m450a(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (C0467l.m831g()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            boolean z = applicationInfo.enabled && !C0391p.m458g(context);
            return z;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    @Deprecated
    public static int m451b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(c.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            C0391p.m447a(context);
        }
        int i = (C0462g.m818b(context) || C0462g.m820d(context)) ? 0 : 1;
        PackageInfo packageInfo = null;
        if (i != 0) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C0452q a = C0452q.m785a(context);
            if (i != 0) {
                if (a.m786a(packageInfo, C0449m.f465a) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (a.m786a(packageInfo2, a.m786a(packageInfo, C0449m.f465a)) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (a.m786a(packageInfo2, C0449m.f465a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C0463h.m821a(packageInfo2.versionCode) < C0463h.m821a(f311b)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f311b + " but found " + packageInfo2.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean m452b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean m453b(Context context, int i) {
        return i == 18 ? true : i == 1 ? C0391p.m450a(context, "com.google.android.gms") : false;
    }

    public static boolean m454c(Context context) {
        C0391p.m459h(context);
        return f314e;
    }

    public static boolean m455d(Context context) {
        return C0391p.m454c(context) || !C0391p.m448a();
    }

    @Deprecated
    public static void m456e(Context context) {
        if (!f315f.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    public static Resources m457f(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @TargetApi(18)
    public static boolean m458g(Context context) {
        if (C0467l.m828d()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void m459h(Context context) {
        if (!f310a) {
            C0391p.m460i(context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m460i(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = com.google.android.gms.internal.cy.m1181b(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.m1180b(r1, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x000f:
        r1 = com.google.android.gms.common.C0452q.m785a(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r2 = 1;
        r2 = new com.google.android.gms.common.C0446j[r2];	 Catch:{ NameNotFoundException -> 0x002e }
        r3 = 0;
        r4 = com.google.android.gms.common.C0449m.f465a;	 Catch:{ NameNotFoundException -> 0x002e }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x002e }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x002e }
        r0 = r1.m786a(r0, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x0024:
        r0 = 1;
        f314e = r0;	 Catch:{ NameNotFoundException -> 0x002e }
    L_0x0027:
        f310a = r6;
    L_0x0029:
        return;
    L_0x002a:
        r0 = 0;
        f314e = r0;	 Catch:{ NameNotFoundException -> 0x002e }
        goto L_0x0027;
    L_0x002e:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0039 }
        f310a = r6;
        goto L_0x0029;
    L_0x0039:
        r0 = move-exception;
        f310a = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.p.i(android.content.Context):void");
    }
}
