package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo */
public class bm {
    private static String f11507a = "";
    private static String f11508b = "";
    private static String f11509c = "";
    private static String f11510d = "";
    private static String f11511e = null;

    public static String m15684a(Context context) {
        try {
            return m15691g(context);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return f11510d;
        } catch (Throwable th) {
            th.printStackTrace();
            return f11510d;
        }
    }

    public static String m15686b(Context context) {
        try {
            if (!"".equals(f11507a)) {
                return f11507a;
            }
            PackageManager packageManager = context.getPackageManager();
            f11507a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f11507a;
        } catch (Throwable e) {
            cd.m15825a(e, "AppInfo", "getApplicationName");
        } catch (Throwable e2) {
            cd.m15825a(e2, "AppInfo", "getApplicationName");
        }
    }

    public static String m15687c(Context context) {
        try {
            if (f11508b != null && !"".equals(f11508b)) {
                return f11508b;
            }
            f11508b = context.getApplicationContext().getPackageName();
            return f11508b;
        } catch (Throwable th) {
            cd.m15825a(th, "AppInfo", "getPackageName");
        }
    }

    public static String m15688d(Context context) {
        try {
            if (!"".equals(f11509c)) {
                return f11509c;
            }
            f11509c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return f11509c;
        } catch (Throwable e) {
            cd.m15825a(e, "AppInfo", "getApplicationVersion");
        } catch (Throwable e2) {
            cd.m15825a(e2, "AppInfo", "getApplicationVersion");
        }
    }

    public static String m15689e(Context context) {
        try {
            if (f11511e != null && !"".equals(f11511e)) {
                return f11511e;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toUpperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(":");
            }
            stringBuffer.append(packageInfo.packageName);
            f11511e = stringBuffer.toString();
            return f11511e;
        } catch (Throwable e) {
            cd.m15825a(e, "AppInfo", "getSHA1AndPackage");
            return f11511e;
        } catch (Throwable e2) {
            cd.m15825a(e2, "AppInfo", "getSHA1AndPackage");
            return f11511e;
        } catch (Throwable e22) {
            cd.m15825a(e22, "AppInfo", "getSHA1AndPackage");
            return f11511e;
        }
    }

    static void m15685a(String str) {
        f11510d = str;
    }

    private static String m15691g(Context context) throws NameNotFoundException {
        if (f11510d == null || f11510d.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return f11510d;
            }
            f11510d = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
        }
        return f11510d;
    }

    public static String m15690f(Context context) {
        try {
            return m15691g(context);
        } catch (Throwable e) {
            cd.m15825a(e, "AppInfo", "getKey");
            return f11510d;
        } catch (Throwable e2) {
            cd.m15825a(e2, "AppInfo", "getKey");
            return f11510d;
        }
    }
}
