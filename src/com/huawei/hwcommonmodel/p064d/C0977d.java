package com.huawei.hwcommonmodel.p064d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Locale;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: CommonUtil */
public class C0977d {
    public static final String f1643a = (BaseApplication.m2632b().getFilesDir().getAbsolutePath() + "/log/");
    private static final Object f1644b = new Object();
    private static final String f1645c = (f1643a + "com.huawei.bone");
    private static long f1646d = 0;
    private static long f1647e = 0;

    public static boolean m3535a(Context context) {
        if (context == null) {
            return false;
        }
        boolean z;
        Configuration configuration = context.getResources().getConfiguration();
        String country = configuration.locale.getCountry();
        C2538c.m12674b("CommonUtil", "isChineseSimplified(): country = " + country + ", language = " + configuration.locale.getLanguage());
        if (PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equalsIgnoreCase(configuration.locale.getLanguage()) && HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(country)) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12674b("CommonUtil", "isChineseSimplified(): result = " + z);
        return z;
    }

    public static boolean m3536a(Context context, String str) {
        C2538c.m12677c("CommonUtil", "getIfInEUAccountArea() enter");
        String[] stringArray = context.getResources().getStringArray(c.eu_national_code);
        if (stringArray == null || stringArray.length < 1) {
            C2538c.m12680e("CommonUtil", "getIfInEUAccountArea() if (countryList == null || countryList.length < 1)");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = Locale.getDefault().getCountry();
        }
        C2538c.m12677c("CommonUtil", "getIfInEUAccountArea() country=" + str);
        for (String equalsIgnoreCase : stringArray) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m3545b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z;
        C2538c.m12674b("CommonUtil", "judgeIfInAccountArea(): country = " + str);
        if (HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(str)) {
            z = true;
        } else {
            z = C0977d.m3536a(context, str);
        }
        C2538c.m12674b("CommonUtil", "judgeIfInAccountArea() retState = " + z);
        return z;
    }

    public static boolean m3544b(Context context) {
        String networkOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str = "";
        String str2 = "";
        if (telephonyManager != null) {
            str2 = telephonyManager.getSimOperator();
            networkOperator = telephonyManager.getNetworkOperator();
        } else {
            networkOperator = str2;
            str2 = str;
        }
        if (TextUtils.isEmpty(str2) || str2.length() < 3 || TextUtils.isEmpty(networkOperator) || networkOperator.length() < 3) {
            return false;
        }
        boolean z;
        if (str2.substring(0, 3).equals(networkOperator.substring(0, 3))) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public static String m3547c(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        String[] stringArray = context.getResources().getStringArray(c.CountryCodes);
        if (stringArray == null) {
            return str;
        }
        String networkOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (telephonyManager != null) {
            str3 = telephonyManager.getSimOperator();
            networkOperator = telephonyManager.getNetworkOperator();
        } else {
            networkOperator = str3;
            str3 = str2;
        }
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            networkOperator = networkOperator.substring(0, 3);
        } else if (TextUtils.isEmpty(str3) || str3.length() < 3) {
            networkOperator = str4;
        } else {
            networkOperator = str3.substring(0, 3);
        }
        for (String str22 : stringArray) {
            String[] split = str22.split(",");
            if (split != null && split[0].trim().equals(r0.trim())) {
                networkOperator = split[1];
                break;
            }
        }
        networkOperator = str;
        return networkOperator;
    }

    public static int m3546c(Context context, String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            C2538c.m12674b("CommonUtil", "stringToInt str is empty");
        } else {
            try {
                if (str.indexOf(".") > 0) {
                    str = str.substring(0, str.indexOf("."));
                }
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                C2538c.m12680e("CommonUtil", "Exception e = " + e.getMessage());
            }
        }
        return i;
    }

    public static long m3551d(Context context, String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            C2538c.m12674b("CommonUtil", "stringToLong str is empty");
        } else {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
                C2538c.m12680e("CommonUtil", "Exception e = " + e.getMessage());
            }
        }
        return j;
    }

    public static boolean m3556e(Context context, String str) {
        Exception e;
        Throwable th;
        JarFile jarFile = null;
        JarFile jarFile2;
        try {
            PublicKey[] h = C0977d.m3566h(context, context.getPackageName());
            if (h == null || h.length == 0) {
                C2538c.m12680e("CommonUtil", "verifySignature installedAppPubKeys == null||installedAppPubKeys.length==0");
                if (null != null) {
                    try {
                        jarFile.close();
                    } catch (IOException e2) {
                        C2538c.m12680e("CommonUtil", "verifySignature Exception:" + e2.getMessage());
                    }
                }
                return false;
            }
            jarFile2 = new JarFile(str);
            try {
                Certificate[] a;
                JarEntry jarEntry = jarFile2.getJarEntry("classes.dex");
                if (jarEntry != null) {
                    a = C0977d.m3539a(jarFile2, jarEntry);
                } else {
                    a = null;
                }
                if (a != null && a.length > 0) {
                    for (Certificate publicKey : a) {
                        PublicKey publicKey2 = publicKey.getPublicKey();
                        int i = 0;
                        while (i < h.length) {
                            if (!publicKey2.equals(h[i])) {
                                i++;
                            } else if (jarFile2 == null) {
                                return true;
                            } else {
                                try {
                                    jarFile2.close();
                                    return true;
                                } catch (IOException e22) {
                                    C2538c.m12680e("CommonUtil", "verifySignature Exception:" + e22.getMessage());
                                    return true;
                                }
                            }
                        }
                    }
                }
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (IOException e222) {
                        C2538c.m12680e("CommonUtil", "verifySignature Exception:" + e222.getMessage());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C2538c.m12680e("CommonUtil", "verifySignature Exception:" + e.getMessage());
                    if (jarFile2 != null) {
                        try {
                            jarFile2.close();
                        } catch (IOException e2222) {
                            C2538c.m12680e("CommonUtil", "verifySignature Exception:" + e2222.getMessage());
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (jarFile2 != null) {
                        try {
                            jarFile2.close();
                        } catch (IOException e4) {
                            C2538c.m12680e("CommonUtil", "verifySignature Exception:" + e4.getMessage());
                        }
                    }
                    throw th;
                }
            }
            return false;
        } catch (Exception e5) {
            e = e5;
            jarFile2 = null;
            C2538c.m12680e("CommonUtil", "verifySignature Exception:" + e.getMessage());
            if (jarFile2 != null) {
                jarFile2.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            jarFile2 = null;
            if (jarFile2 != null) {
                jarFile2.close();
            }
            throw th;
        }
    }

    private static PublicKey[] m3566h(Context context, String str) {
        PublicKey[] publicKeyArr = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.versionName == null)) {
                publicKeyArr = C0977d.m3538a(packageInfo);
            }
        } catch (NameNotFoundException e) {
        } catch (Exception e2) {
            C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e2.getMessage());
        }
        return publicKeyArr;
    }

    private static PublicKey[] m3538a(PackageInfo packageInfo) {
        Exception exception;
        PublicKey[] publicKeyArr = null;
        try {
            if (packageInfo.signatures == null || packageInfo.signatures.length == 0) {
                return null;
            }
            PublicKey[] publicKeyArr2 = new PublicKey[packageInfo.signatures.length];
            int i = 0;
            while (i < publicKeyArr2.length) {
                try {
                    publicKeyArr2[i] = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[i].toByteArray()))).getPublicKey();
                    i++;
                } catch (Exception e) {
                    Exception exception2 = e;
                    publicKeyArr = publicKeyArr2;
                    exception = exception2;
                }
            }
            return publicKeyArr2;
        } catch (Exception e2) {
            exception = e2;
            C2538c.m12680e("CommonUtil", "getPublicKey Exception:" + exception.getMessage());
            return publicKeyArr;
        }
    }

    private static Certificate[] m3539a(JarFile jarFile, JarEntry jarEntry) {
        InputStream inputStream;
        IOException e;
        Throwable th;
        Certificate[] certificateArr = null;
        try {
            byte[] bArr = new byte[2048];
            inputStream = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (IOException e2) {
                    e = e2;
                }
            } while (inputStream.read(bArr, 0, bArr.length) != -1);
            certificateArr = jarEntry.getCertificates();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e3.getMessage());
                }
            }
        } catch (IOException e4) {
            e3 = e4;
            inputStream = null;
            try {
                C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e3.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e32) {
                        C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e32.getMessage());
                    }
                }
                return certificateArr;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e322) {
                        C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e322.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return certificateArr;
    }

    public static int m3524a(String str, int i) {
        if (!(str == null || str.trim().length() == 0)) {
            String trim = str.trim();
            try {
                i = Integer.parseInt(trim);
            } catch (Exception e) {
                C2538c.m12680e("CommonUtil", "getInteger()->Integer.valueOf(" + trim + ") Exception=" + e.getMessage());
                try {
                    i = Float.valueOf(Float.parseFloat(trim)).intValue();
                } catch (Exception e2) {
                    C2538c.m12680e("CommonUtil", "getInteger()->Float.valueOf(" + trim + ") Exception=" + e2.getMessage());
                }
            }
        }
        return i;
    }

    public static int m3523a(String str) {
        return C0977d.m3524a(str, 0);
    }

    public static Long m3525a(String str, Long l) {
        if (!(str == null || str.length() == 0)) {
            try {
                l = Long.valueOf(str.trim());
            } catch (Exception e) {
                C2538c.m12680e("CommonUtil", "getLong Exception = " + e.getMessage());
            }
        }
        return l;
    }

    public static Long m3541b(String str) {
        return C0977d.m3525a(str, Long.valueOf(0));
    }

    public static int m3550d(Context context) {
        int i;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            C2538c.m12680e("CommonUtil", "getAppVersion() Exception=" + e.getMessage());
            i = 1;
        }
        C2538c.m12674b("CommonUtil", "getAppVersion() return=" + i);
        return i;
    }

    public static boolean m3555e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static String m3558f(Context context) {
        String str = "1.0.0.0";
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
                C2538c.m12680e("CommonUtil", "getAppVersionName() Exception = " + e.getMessage());
            }
            C2538c.m12674b("CommonUtil", "getAppVersionName() version = " + str);
        }
        return str;
    }

    public static int m3561g(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            C2538c.m12674b("CommonUtil", "getDeviceType() deviceType = " + ((TelephonyManager) context.getSystemService("phone")).getPhoneType());
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
        } catch (SecurityException e) {
            C2538c.m12674b("CommonUtil", "getDeviceType() SecurityException ");
            return -1;
        } catch (Exception e2) {
            C2538c.m12674b("CommonUtil", "getDeviceType() Exception");
            return -1;
        }
    }

    public static String m3564h(Context context) {
        if (context == null) {
            try {
                return "";
            } catch (SecurityException e) {
                C2538c.m12674b("CommonUtil", "getIMEI() SecurityException ");
                return "";
            } catch (Exception e2) {
                C2538c.m12674b("CommonUtil", "getIMEI() Exception");
                return "";
            }
        }
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        C2538c.m12674b("CommonUtil", "getIMEI() imei = " + deviceId);
        if (deviceId == null) {
            return "";
        }
        return deviceId;
    }

    public static void m3532a(Intent intent, Context context) {
        if (C0977d.m3537a("com.huawei.hwservicesmgr.PhoneService", context)) {
            C2538c.m12677c("CommonUtil", "PhoneService was running..........don't need start");
            return;
        }
        context.startService(intent);
        C2538c.m12677c("CommonUtil", "startService to handleIntent - PhoneService");
    }

    public static boolean m3537a(String str, Context context) {
        List runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(100);
        if (runningServices == null || runningServices.size() <= 0) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m3534a() {
        String str = "EmotionUI";
        try {
            boolean z;
            Class cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.version.emui"});
            C2538c.m12674b("CommonUtil", "emui:" + str2);
            if (str2 == null || str2.indexOf(str) == -1) {
                z = false;
            } else {
                z = true;
            }
            return z;
        } catch (ClassNotFoundException e) {
            C2538c.m12674b("CommonUtil", e.getMessage());
            return false;
        } catch (NoSuchMethodException e2) {
            C2538c.m12674b("CommonUtil", e2.getMessage());
            return false;
        } catch (InvocationTargetException e3) {
            C2538c.m12674b("CommonUtil", e3.getMessage());
            return false;
        } catch (IllegalAccessException e4) {
            C2538c.m12674b("CommonUtil", e4.getMessage());
            return false;
        }
    }

    public static int m3567i(Context context) {
        try {
            int type;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                type = activeNetworkInfo.getType();
                if (type == 1) {
                    return 1;
                }
                if (type == 0) {
                    type = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    C2538c.m12674b("CommonUtil", "telephone networkType:" + type);
                    return C0977d.m3540b(type);
                }
            }
            type = -1;
            C2538c.m12674b("CommonUtil", "telephone networkType:" + type);
            return C0977d.m3540b(type);
        } catch (Exception e) {
            C2538c.m12680e("CommonUtil", e.getMessage());
            return -1;
        }
    }

    private static int m3540b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return -1;
        }
    }

    public static boolean m3543b() {
        return false;
    }

    public static boolean m3548c() {
        return false;
    }

    public static String m3528a(int i) {
        String str = "";
        ActivityManager activityManager = (ActivityManager) BaseApplication.m2632b().getSystemService("activity");
        if (!(activityManager == null || activityManager.getRunningAppProcesses() == null || activityManager.getRunningAppProcesses().size() <= 0)) {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                String str2;
                if (runningAppProcessInfo.pid == i) {
                    str2 = runningAppProcessInfo.processName;
                } else {
                    str2 = str;
                }
                str = str2;
            }
        }
        return str;
    }

    public static double m3522a(double d, int i) {
        if (i < 0) {
            C2538c.m12679d("CommonUtil", "round, parameter ERROR!");
            i = 0;
        }
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), i, 4).doubleValue();
    }

    public static String m3553d() {
        Configuration configuration = BaseApplication.m2632b().getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        return language + "-" + configuration.locale.getCountry();
    }

    public static boolean m3560f(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            C2538c.m12674b("CommonUtil", "isForeground getClassName = " + ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName());
            if (str.equals(((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean m3570j(Context context) {
        PackageInfo packageInfo;
        boolean z;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(WeChat.HEALTH_PACKAGE_NAME, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12674b("CommonUtil", "checkHIsInstall res " + z);
        return z;
    }

    public static PackageInfo m3572k(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(WeChat.HEALTH_PACKAGE_NAME, 0);
        } catch (NameNotFoundException e) {
            C2538c.m12674b("CommonUtil", "checkHealth packageInfo == NULL");
        }
        return packageInfo;
    }

    public static boolean m3573l(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.huawei.appmarket", 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    public static boolean m3574m(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.android.vending", 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    public static void m3530a(Context context, int i) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(WeChat.HEALTH_PACKAGE_NAME, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                String str = resolveInfo.activityInfo.packageName;
                String str2 = resolveInfo.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(270532608);
                intent2.setAction("android.intent.action.VIEW");
                context.startActivity(intent2);
            }
        } catch (NameNotFoundException e) {
            C2538c.m12680e("CommonUtil", "Exception e = " + e.getMessage());
        }
    }

    public static void m3563g(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(WeChat.HEALTH_PACKAGE_NAME, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                String str2 = resolveInfo.activityInfo.packageName;
                String str3 = resolveInfo.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str2, str3));
                intent2.setFlags(270532608);
                intent2.setAction(str);
                context.startActivity(intent2);
            }
        } catch (NameNotFoundException e) {
            C2538c.m12680e("CommonUtil", "Exception e = " + e.getMessage());
        }
    }

    public static void m3529a(int i, String str, String str2, Context context, boolean z) {
        C2538c.m12680e("CommonUtil", "Enter runHealthDetail");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(WeChat.HEALTH_PACKAGE_NAME, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                C2538c.m12680e("CommonUtil", "Enter runHealthDetail packageName:" + resolveInfo.activityInfo.packageName);
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName(r0, "com.huawei.health.StartHealthActivity"));
                intent2.putExtra("health_smartmsg_type", 3);
                intent2.putExtra("produceType", i);
                intent2.putExtra("produceName", str);
                intent2.putExtra("produceMac", str2);
                intent2.putExtra("isPorc", z);
                intent2.setFlags(270532608);
                context.startActivity(intent2);
            }
        } catch (NameNotFoundException e) {
            C2538c.m12680e("CommonUtil", "Exception e = " + e.getMessage());
        }
    }

    public static void m3531a(Context context, Class<?> cls) {
        C2538c.m12677c("CommonUtil", "toggleNotificationListenerService enter");
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(context, cls), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, cls), 1, 1);
    }

    public static void m3575n(Context context) {
        if (context != null) {
        }
    }

    public static byte[] m3549c(String str) {
        FileInputStream fileInputStream;
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        Exception e3;
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e4.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e42) {
                            C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e42.getMessage());
                        }
                    }
                } catch (FileNotFoundException e5) {
                    e2 = e5;
                    try {
                        C2538c.m12677c("CommonUtil", "file2byte FileNotFoundException : file : " + e2.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e422) {
                                C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e422.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4222) {
                                C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e4222.getMessage());
                            }
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e42222) {
                                C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e42222.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e422222) {
                                C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e422222.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e422222 = e6;
                    C2538c.m12677c("CommonUtil", "file2byte IOException file : " + e422222.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4222222) {
                            C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e4222222.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e42222222) {
                            C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e42222222.getMessage());
                        }
                    }
                    return bArr;
                } catch (Exception e7) {
                    e3 = e7;
                    C2538c.m12677c("CommonUtil", "file2byte Exception file : " + e3.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e422222222) {
                            C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e422222222.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4222222222) {
                            C2538c.m12680e("CommonUtil", "loadCertificates Exception:" + e4222222222.getMessage());
                        }
                    }
                    return bArr;
                }
            } catch (FileNotFoundException e8) {
                e2 = e8;
                byteArrayOutputStream = bArr;
                C2538c.m12677c("CommonUtil", "file2byte FileNotFoundException : file : " + e2.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (IOException e9) {
                e4222222222 = e9;
                byteArrayOutputStream = bArr;
                C2538c.m12677c("CommonUtil", "file2byte IOException file : " + e4222222222.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Exception e10) {
                e3 = e10;
                byteArrayOutputStream = bArr;
                C2538c.m12677c("CommonUtil", "file2byte Exception file : " + e3.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th3) {
                byteArrayOutputStream = bArr;
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e11) {
            e2 = e11;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            C2538c.m12677c("CommonUtil", "file2byte FileNotFoundException : file : " + e2.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr;
        } catch (IOException e12) {
            e4222222222 = e12;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            C2538c.m12677c("CommonUtil", "file2byte IOException file : " + e4222222222.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr;
        } catch (Exception e13) {
            e3 = e13;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            C2538c.m12677c("CommonUtil", "file2byte Exception file : " + e3.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr;
        } catch (Throwable th32) {
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            th = th32;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    public static boolean m3554e() {
        C2538c.m12677c("CommonUtil", "Enter isVersionUpEMUI_5_0");
        if (C0977d.m3557e("com.huawei.android.os.BuildEx")) {
            C2538c.m12677c("CommonUtil", "EMUI Version = " + C0977d.m3571k());
            if (C0977d.m3571k() > 11) {
                return true;
            }
        }
        return false;
    }

    public static boolean m3559f() {
        C2538c.m12677c("CommonUtil", "Enter isVersionUpEMUI_5_0");
        if (C0977d.m3557e("com.huawei.android.os.BuildEx")) {
            C2538c.m12677c("CommonUtil", "EMUI Version = " + C0977d.m3571k());
            if (C0977d.m3571k() >= 11) {
                return true;
            }
        }
        return false;
    }

    private static boolean m3557e(String str) {
        C2538c.m12677c("CommonUtil", "Enter isExsitOfClass");
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            C2538c.m12680e("CommonUtil", "The class is not existing: " + str);
            return false;
        }
    }

    private static void m3533a(Class cls, Class[] clsArr, Object[] objArr) throws Exception {
        C2538c.m12677c("CommonUtil", "Enter paramsCheck");
        if (cls == null) {
            throw new Exception("class is null in staticFun");
        } else if (clsArr == null) {
            if (objArr != null) {
                throw new Exception("paramsType is null, but params is not null");
            }
        } else if (objArr == null) {
            throw new Exception("paramsType or params should be same");
        } else if (clsArr.length != objArr.length) {
            throw new Exception("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
        }
    }

    private static int m3571k() {
        int parseInt;
        C2538c.m12677c("CommonUtil", "Enter getEmuiVersionCodeEx");
        try {
            Object b = C0977d.m3542b("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{"ro.build.hw_emui_api_level", ""});
            if (b != null) {
                parseInt = Integer.parseInt(b.toString());
                C2538c.m12677c("CommonUtil", "getEmuiVersionCodeEx　emUIversion=　" + parseInt);
                return parseInt;
            }
        } catch (Exception e) {
            C2538c.m12679d("CommonUtil", "getEmuiVersionCodeEx　Exception　" + e.getMessage());
        }
        parseInt = 0;
        C2538c.m12677c("CommonUtil", "getEmuiVersionCodeEx　emUIversion=　" + parseInt);
        return parseInt;
    }

    private static Object m3526a(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Object obj = null;
        C2538c.m12677c("CommonUtil", "Enter staticFun with class");
        C0977d.m3533a(cls, clsArr, objArr);
        try {
            try {
                obj = cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException e) {
                C2538c.m12664a("CommonUtil", e.getMessage());
            } catch (IllegalArgumentException e2) {
                C2538c.m12664a("CommonUtil", e2.getMessage());
            } catch (InvocationTargetException e3) {
                C2538c.m12664a("CommonUtil", e3.getMessage());
            }
        } catch (NoSuchMethodException e4) {
            C2538c.m12664a("CommonUtil", e4.getMessage());
        } catch (Exception e5) {
            C2538c.m12680e("CommonUtil", e5.getMessage());
        }
        return obj;
    }

    private static Object m3542b(String str, String str2, Class[] clsArr, Object[] objArr) {
        C2538c.m12677c("CommonUtil", "Enter staticFun with string");
        try {
            return C0977d.m3526a(Class.forName(str), str2, clsArr, objArr);
        } catch (ClassNotFoundException e) {
            C2538c.m12664a("CommonUtil", e.getMessage());
            return null;
        } catch (Exception e2) {
            C2538c.m12664a("CommonUtil", e2.getMessage());
            return null;
        } catch (Throwable th) {
            C2538c.m12664a("CommonUtil", th.getMessage());
            return null;
        }
    }

    public static String m3562g() {
        C2538c.m12677c("CommonUtil", "pathPre = ", f1645c);
        return f1645c;
    }

    public static boolean m3576o(Context context) {
        if (context == null) {
            return false;
        }
        C2538c.m12677c("CommonUtil", "isBackground packageName : " + context.getPackageName());
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
            C2538c.m12677c("CommonUtil", "isBackground null == appProcesses || appProcesses.size() <= 0");
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            C2538c.m12677c("CommonUtil", "isBackground appProcess : " + runningAppProcessInfo.processName);
            if (r3.equals(runningAppProcessInfo.processName)) {
                C2538c.m12677c("CommonUtil", "isBackground appProcess packageName.equals  " + runningAppProcessInfo.importance);
                if (runningAppProcessInfo.importance != 100) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean m3565h() {
        C2538c.m12677c("CommonUtil", "Enter isEMUI_4_0");
        if (C0977d.m3557e("com.huawei.android.os.BuildEx")) {
            C2538c.m12677c("CommonUtil", "EMUI Version = " + C0977d.m3571k());
            if (C0977d.m3571k() >= 9) {
                return true;
            }
        }
        return false;
    }

    public static boolean m3568i() {
        C2538c.m12677c("CommonUtil", "Enter isUPEMUI_5_1");
        if (C0977d.m3557e("com.huawei.android.os.BuildEx")) {
            C2538c.m12677c("CommonUtil", "EMUI Version = " + C0977d.m3571k());
            if (C0977d.m3571k() >= 12) {
                return true;
            }
        }
        return false;
    }

    public static boolean m3569j() {
        String str;
        String str2;
        String str3 = "";
        String str4 = "";
        try {
            Object a = C0977d.m3527a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.language"});
            Object a2 = C0977d.m3527a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.region"});
            if (a != null) {
                str3 = (String) a;
            }
            if (a2 != null) {
                str = (String) a2;
            } else {
                str = str4;
            }
            str2 = str3;
        } catch (Exception e) {
            Exception exception = e;
            str = str3;
            C2538c.m12680e("CommonUtil", "can not get language and region:" + exception.getMessage());
            str2 = str;
            str = str4;
        }
        boolean equalsIgnoreCase = (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(Locale.getDefault().getCountry()) : PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equalsIgnoreCase(str2) && HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(str);
        C2538c.m12677c("CommonUtil", "isChinaROM res:" + equalsIgnoreCase + "  lang:" + str2 + "  region:" + str);
        return equalsIgnoreCase;
    }

    public static Object m3527a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Object invoke;
        Class cls = null;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C2538c.m12674b("CommonUtil", "invokeFun params invalid");
        } else {
            Object d = C0977d.m3552d(str);
            if (d != null) {
                Class cls2;
                Method method;
                try {
                    cls2 = Class.forName(str);
                } catch (ClassNotFoundException e) {
                    C2538c.m12680e("CommonUtil", "can not find class:" + str);
                    cls2 = cls;
                }
                if (cls2 != null) {
                    try {
                        method = cls2.getMethod(str2, clsArr);
                    } catch (NoSuchMethodException e2) {
                        C2538c.m12680e("CommonUtil", "can not find method:" + str2);
                    }
                    if (method != null) {
                        try {
                            invoke = method.invoke(d, objArr);
                        } catch (IllegalAccessException e3) {
                            C2538c.m12680e("CommonUtil", "method can not invoke:" + e3.getMessage());
                        } catch (IllegalArgumentException e4) {
                            C2538c.m12680e("CommonUtil", "method can not invoke:" + e4.getMessage());
                        } catch (InvocationTargetException e5) {
                            C2538c.m12680e("CommonUtil", "method can not invoke:" + e5.getMessage());
                        }
                    }
                }
                Object obj = cls;
                if (method != null) {
                    invoke = method.invoke(d, objArr);
                }
            }
        }
        return invoke;
    }

    public static Object m3552d(String str) {
        Class cls;
        Object newInstance;
        Class cls2 = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            C2538c.m12680e("CommonUtil", "can not find class:" + str);
            cls = cls2;
        }
        if (cls != null) {
            try {
                newInstance = cls.newInstance();
            } catch (InstantiationException e2) {
                C2538c.m12680e("CommonUtil", "class creat instance error :" + e2.getMessage());
            } catch (IllegalAccessException e3) {
                C2538c.m12680e("CommonUtil", "class creat instance error :" + e3.getMessage());
            }
        }
        return newInstance;
    }

    public static boolean m3577p(Context context) {
        List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(300);
        if (runningServices != null) {
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                C2538c.m12677c("CommonUtil", "11111 serivce is :" + runningServiceInfo.service.getClassName());
                if ("com.huawei.bone.ui.setting.NotificationPushListener".equals(((RunningServiceInfo) r3.next()).service.getClassName())) {
                    C2538c.m12677c("CommonUtil", "11111 serivce is running!!!");
                    return true;
                }
            }
        }
        return false;
    }

    public static String m3578q(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(WeChat.HEALTH_PACKAGE_NAME, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                C2538c.m12677c("CommonUtil", "appInfo className" + applicationInfo.className + " processName" + applicationInfo.processName);
                C2538c.m12677c("CommonUtil", "appInfo.metaData " + applicationInfo.metaData);
                C2538c.m12677c("CommonUtil", "isSupportWearInHealth " + applicationInfo.metaData.getString("is-support-wear"));
                return applicationInfo.metaData.getString("is-support-wear");
            }
        } catch (NameNotFoundException e) {
            C2538c.m12680e("CommonUtil", "Failed to get the isSupportWearInHealth.", e);
        }
        return null;
    }
}
