package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo */
public class C3434w {
    private static String f12512a = "";
    private static String f12513b = null;
    private static String f12514c = "";
    private static String f12515d;
    private static String f12516e = null;

    public static String m16987a(Context context) {
        try {
            if (!"".equals(f12512a)) {
                return f12512a;
            }
            PackageManager packageManager = context.getPackageManager();
            f12512a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f12512a;
        } catch (Throwable e) {
            ay.m16709a(e, "AppInfo", "getApplicationName");
            e.printStackTrace();
        } catch (Throwable e2) {
            ay.m16709a(e2, "AppInfo", "getApplicationName");
            e2.printStackTrace();
        }
    }

    public static String m16989b(Context context) {
        try {
            if (f12513b != null && !"".equals(f12513b)) {
                return f12513b;
            }
            f12513b = context.getApplicationContext().getPackageName();
            return f12513b;
        } catch (Throwable th) {
            ay.m16709a(th, "AppInfo", "getPackageName");
            th.printStackTrace();
        }
    }

    public static String m16990c(Context context) {
        try {
            if (!"".equals(f12514c)) {
                return f12514c;
            }
            f12514c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return f12514c;
        } catch (Throwable e) {
            ay.m16709a(e, "AppInfo", "getApplicationVersion");
            e.printStackTrace();
        } catch (Throwable e2) {
            ay.m16709a(e2, "AppInfo", "getApplicationVersion");
            e2.printStackTrace();
        }
    }

    public static String m16991d(Context context) {
        try {
            if (f12516e != null && !"".equals(f12516e)) {
                return f12516e;
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
            f12516e = stringBuffer.toString();
            return f12516e;
        } catch (Throwable e) {
            ay.m16709a(e, "AppInfo", "getSHA1AndPackage");
            e.printStackTrace();
            return f12516e;
        } catch (Throwable e2) {
            ay.m16709a(e2, "AppInfo", "getSHA1AndPackage");
            e2.printStackTrace();
            return f12516e;
        } catch (Throwable e22) {
            ay.m16709a(e22, "AppInfo", "getSHA1AndPackage");
            e22.printStackTrace();
            return f12516e;
        }
    }

    static void m16988a(String str) {
        f12515d = str;
    }

    private static String m16994g(Context context) throws NameNotFoundException {
        if (f12515d == null || f12515d.equals("")) {
            f12515d = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.amap.api.v2.apikey");
        }
        return f12515d;
    }

    public static String m16992e(Context context) {
        try {
            return C3434w.m16994g(context);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return f12515d;
        } catch (Throwable th) {
            th.printStackTrace();
            return f12515d;
        }
    }

    public static String m16993f(Context context) {
        try {
            return C3434w.m16994g(context);
        } catch (Throwable e) {
            ay.m16709a(e, "AppInfo", "getKey");
            e.printStackTrace();
            return f12515d;
        } catch (Throwable e2) {
            ay.m16709a(e2, "AppInfo", "getKey");
            e2.printStackTrace();
            return f12515d;
        }
    }
}
