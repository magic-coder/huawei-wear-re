package com.tencent.wxop.stat.p547b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.wxop.stat.C6544v;
import com.tencent.wxop.stat.C6547y;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class C6517l {
    private static String f22711a = null;
    private static String f22712b = null;
    private static String f22713c = null;
    private static String f22714d = null;
    private static Random f22715e = null;
    private static DisplayMetrics f22716f = null;
    private static String f22717g = null;
    private static String f22718h = "";
    private static String f22719i = "";
    private static int f22720j = -1;
    private static C6507b f22721k = null;
    private static String f22722l = null;
    private static String f22723m = null;
    private static volatile int f22724n = -1;
    private static String f22725o = null;
    private static String f22726p = null;
    private static long f22727q = -1;
    private static String f22728r = "";
    private static C6520o f22729s = null;
    private static String f22730t = "__MTA_FIRST_ACTIVATE__";
    private static int f22731u = -1;
    private static long f22732v = -1;
    private static int f22733w = 0;
    private static String f22734x = "";

    public static int m29727a() {
        return C6517l.m29754i().nextInt(Integer.MAX_VALUE);
    }

    public static int m29728a(Context context, boolean z) {
        if (z) {
            f22733w = C6522q.m29776a(context, "mta.qq.com.difftime", 0);
        }
        return f22733w;
    }

    private static Long m29729a(String str, String str2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != 3) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i = 0;
            while (i < split.length) {
                Long valueOf2 = Long.valueOf(100 * (valueOf.longValue() + Long.valueOf(split[i]).longValue()));
                i++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static String m29730a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String m29731a(Context context, String str) {
        if (!C6544v.m29855v()) {
            return str;
        }
        if (f22723m == null) {
            f22723m = C6517l.m29761o(context);
        }
        return f22723m != null ? str + HwAccountConstants.SPLIIT_UNDERLINE + f22723m : str;
    }

    public static String m29732a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "0";
        }
    }

    public static HttpHost m29733a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
    }

    public static void m29734a(Context context, int i) {
        f22733w = i;
        C6522q.m29781b(context, "mta.qq.com.difftime", i);
    }

    public static boolean m29735a(C6547y c6547y) {
        return c6547y == null ? false : C6517l.m29742c(c6547y.m29894c());
    }

    public static byte[] m29736a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    public static int m29737b() {
        if (f22720j != -1) {
            return f22720j;
        }
        try {
            if (C6521p.m29775a()) {
                f22720j = 1;
            }
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
        f22720j = 0;
        return 0;
    }

    public static long m29738b(String str) {
        return C6517l.m29729a(str, ".", Long.valueOf(0)).longValue();
    }

    public static synchronized String m29739b(Context context) {
        String a;
        synchronized (C6517l.class) {
            if (f22711a == null || f22711a.trim().length() == 0) {
                a = C6523r.m29783a(context);
                f22711a = a;
                if (a == null || f22711a.trim().length() == 0) {
                    f22711a = Integer.toString(C6517l.m29754i().nextInt(Integer.MAX_VALUE));
                }
                a = f22711a;
            } else {
                a = f22711a;
            }
        }
        return a;
    }

    public static synchronized C6507b m29740c() {
        C6507b c6507b;
        synchronized (C6517l.class) {
            if (f22721k == null) {
                c6507b = new C6507b("MtaSDK");
                f22721k = c6507b;
                c6507b.m29701a();
            }
            c6507b = f22721k;
        }
        return c6507b;
    }

    public static synchronized String m29741c(Context context) {
        String str;
        synchronized (C6517l.class) {
            if (f22713c == null || f22713c.trim().length() == 0) {
                f22713c = C6523r.m29787b(context);
            }
            str = f22713c;
        }
        return str;
    }

    public static boolean m29742c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static long m29743d() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            f22721k.m29705b(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static DisplayMetrics m29744d(Context context) {
        if (f22716f == null) {
            f22716f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f22716f);
        }
        return f22716f;
    }

    public static String m29745e() {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, 0);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static boolean m29746e(Context context) {
        try {
            if (C6523r.m29786a(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            f22721k.m29704b((Object) "can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
    }

    public static String m29747f() {
        if (C6517l.m29742c(f22726p)) {
            return f22726p;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize())) / 1000000) + "/" + String.valueOf(blockCount);
        f22726p = str;
        return str;
    }

    public static String m29748f(Context context) {
        if (f22712b != null) {
            return f22712b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    f22712b = string;
                    return string;
                }
                f22721k.m29702a((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f22721k.m29702a((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String m29749g(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f22721k.m29706c("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f22721k.m29708e("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static JSONObject m29750g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", C6518m.m29771a());
            String d = C6518m.m29774d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = C6518m.m29772b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            b = C6518m.m29773c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
        } catch (Throwable th) {
            Log.w("MtaSDK", "get cpu error", th);
        }
        return jSONObject;
    }

    public static String m29752h(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String m29753i(Context context) {
        if (f22717g != null) {
            return f22717g;
        }
        try {
            if (C6523r.m29786a(context, "android.permission.READ_PHONE_STATE")) {
                if ((context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) != 0 ? null : 1) != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f22717g = telephonyManager.getSimOperator();
                    }
                }
            } else {
                f22721k.m29708e("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
        return f22717g;
    }

    private static synchronized Random m29754i() {
        Random random;
        synchronized (C6517l.class) {
            if (f22715e == null) {
                f22715e = new Random();
            }
            random = f22715e;
        }
        return random;
    }

    private static long m29755j() {
        if (f22727q > 0) {
            return f22727q;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception e) {
        }
        f22727q = j;
        return j;
    }

    public static String m29756j(Context context) {
        if (C6517l.m29742c(f22718h)) {
            return f22718h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f22718h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
        return f22718h;
    }

    public static String m29757k(Context context) {
        String str = "";
        try {
            if (C6523r.m29786a(context, "android.permission.INTERNET") && C6523r.m29786a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            f22721k.m29708e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            f22721k.m29705b(th);
            return str;
        }
    }

    public static Integer m29758l(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String m29759m(Context context) {
        if (C6517l.m29742c(f22719i)) {
            return f22719i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f22719i = str;
            if (str == null || f22719i.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
        return f22719i;
    }

    public static String m29760n(Context context) {
        if (C6517l.m29742c(f22722l)) {
            return f22722l;
        }
        try {
            if (C6523r.m29786a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
                        f22722l = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            f22721k.m29704b((Object) "can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
    }

    static String m29761o(Context context) {
        try {
            if (f22723m != null) {
                return f22723m;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    f22723m = runningAppProcessInfo.processName;
                    break;
                }
            }
            return f22723m;
        } catch (Throwable th) {
        }
    }

    public static String m29762p(Context context) {
        return C6517l.m29731a(context, C6506a.f22657b);
    }

    public static synchronized Integer m29763q(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (C6517l.class) {
            if (f22724n <= 0) {
                f22724n = C6522q.m29776a(context, "MTA_EVENT_INDEX", 0);
                C6522q.m29781b(context, "MTA_EVENT_INDEX", f22724n + 1000);
            } else if (f22724n % 1000 == 0) {
                try {
                    int i2 = f22724n + 1000;
                    if (f22724n < 2147383647) {
                        i = i2;
                    }
                    C6522q.m29781b(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    f22721k.m29706c(th);
                }
            }
            i = f22724n + 1;
            f22724n = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    public static String m29764r(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000000) + "/" + String.valueOf(C6517l.m29755j() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String m29765s(Context context) {
        if (C6517l.m29742c(f22728r)) {
            return f22728r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    f22728r = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            f22721k.m29705b(th);
        }
        return f22728r;
    }

    public static synchronized int m29766t(Context context) {
        int i;
        synchronized (C6517l.class) {
            if (f22731u != -1) {
                i = f22731u;
            } else {
                C6517l.m29767u(context);
                i = f22731u;
            }
        }
        return i;
    }

    public static void m29767u(Context context) {
        int a = C6522q.m29776a(context, f22730t, 1);
        f22731u = a;
        if (a == 1) {
            C6522q.m29781b(context, f22730t, 0);
        }
    }

    public static boolean m29768v(Context context) {
        if (f22732v < 0) {
            f22732v = C6522q.m29777a(context, "mta.qq.com.checktime");
        }
        return Math.abs(System.currentTimeMillis() - f22732v) > 86400000;
    }

    public static void m29769w(Context context) {
        f22732v = System.currentTimeMillis();
        C6522q.m29780a(context, "mta.qq.com.checktime", f22732v);
    }

    public static String m29770x(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }
}
