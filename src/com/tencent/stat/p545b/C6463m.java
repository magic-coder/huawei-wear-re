package com.tencent.stat.p545b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.stat.C6470c;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
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

public class C6463m {
    private static String f22430a = null;
    private static String f22431b = null;
    private static String f22432c = null;
    private static String f22433d = null;
    private static Random f22434e = null;
    private static C6452b f22435f = null;
    private static String f22436g = null;
    private static C6464n f22437h = null;
    private static C6466p f22438i = null;
    private static String f22439j = "__MTA_FIRST_ACTIVATE__";
    private static int f22440k = -1;

    public static String m29433A(Context context) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
        return "";
    }

    public static WifiInfo m29434B(Context context) {
        if (C6463m.m29446a(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    public static String m29435C(Context context) {
        try {
            WifiInfo B = C6463m.m29434B(context);
            if (B != null) {
                return B.getBSSID();
            }
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
        return null;
    }

    public static String m29436D(Context context) {
        try {
            WifiInfo B = C6463m.m29434B(context);
            if (B != null) {
                return B.getSSID();
            }
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
        return null;
    }

    public static synchronized int m29437E(Context context) {
        int i;
        synchronized (C6463m.class) {
            if (f22440k != -1) {
                i = f22440k;
            } else {
                C6463m.m29438F(context);
                i = f22440k;
            }
        }
        return i;
    }

    public static void m29438F(Context context) {
        f22440k = C6468r.m29490a(context, f22439j, 1);
        f22435f.m29411f(Integer.valueOf(f22440k));
        if (f22440k == 1) {
            C6468r.m29494b(context, f22439j, 0);
        }
    }

    private static long m29439G(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static int m29440a() {
        return C6463m.m29464h().nextInt(Integer.MAX_VALUE);
    }

    public static Long m29441a(String str, String str2, int i, int i2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != i2) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i3 = 0;
            while (i3 < split.length) {
                Long valueOf2 = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(split[i3]).longValue()));
                i3++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static String m29442a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String m29443a(String str) {
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

    public static HttpHost m29444a(Context context) {
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
            return null;
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
    }

    public static void m29445a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                f22435f.m29411f(th);
            }
        }
    }

    public static boolean m29446a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            f22435f.m29411f(th);
            return false;
        }
    }

    public static byte[] m29447a(byte[] bArr) {
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

    public static long m29448b(String str) {
        return C6463m.m29441a(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    public static synchronized C6452b m29449b() {
        C6452b c6452b;
        synchronized (C6463m.class) {
            if (f22435f == null) {
                f22435f = new C6452b("MtaSDK");
                f22435f.m29404a(false);
            }
            c6452b = f22435f;
        }
        return c6452b;
    }

    public static synchronized String m29450b(Context context) {
        String str;
        synchronized (C6463m.class) {
            if (f22430a == null || f22430a.trim().length() == 0) {
                f22430a = C6463m.m29470l(context);
                if (f22430a == null || f22430a.trim().length() == 0) {
                    f22430a = Integer.toString(C6463m.m29464h().nextInt(Integer.MAX_VALUE));
                }
                str = f22430a;
            } else {
                str = f22430a;
            }
        }
        return str;
    }

    public static String m29451b(Context context, String str) {
        if (!C6470c.m29538u()) {
            return str;
        }
        if (f22436g == null) {
            f22436g = C6463m.m29479u(context);
        }
        return f22436g != null ? str + HwAccountConstants.SPLIIT_UNDERLINE + f22436g : str;
    }

    public static long m29452c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            f22435f.m29411f(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static synchronized String m29453c(Context context) {
        String str;
        synchronized (C6463m.class) {
            if (f22432c == null || "" == f22432c) {
                f22432c = C6463m.m29461f(context);
            }
            str = f22432c;
        }
        return str;
    }

    public static String m29454c(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C6459i.m29429b(C6457g.m29419a(str.getBytes(GameManager.DEFAULT_CHARSET)), 0), GameManager.DEFAULT_CHARSET);
        } catch (Throwable th) {
            f22435f.m29411f(th);
            return str;
        }
    }

    public static int m29455d() {
        return VERSION.SDK_INT;
    }

    public static DisplayMetrics m29456d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String m29457d(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C6457g.m29421b(C6459i.m29427a(str.getBytes(GameManager.DEFAULT_CHARSET), 0)), GameManager.DEFAULT_CHARSET);
        } catch (Throwable th) {
            f22435f.m29411f(th);
            return str;
        }
    }

    public static String m29458e() {
        long f = C6463m.m29460f() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf(f);
    }

    public static boolean m29459e(Context context) {
        try {
            if (C6463m.m29446a(context, "android.permission.ACCESS_WIFI_STATE")) {
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
            f22435f.m29408c("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
    }

    public static long m29460f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static String m29461f(Context context) {
        if (C6463m.m29446a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                f22435f.m29406b(e);
                return "";
            }
        }
        f22435f.m29411f("Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    public static boolean m29463g(Context context) {
        try {
            if (C6463m.m29446a(context, "android.permission.INTERNET") && C6463m.m29446a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
                }
                return false;
            }
            f22435f.m29408c("can not get the permisson of android.permission.INTERNET");
            return false;
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
    }

    private static synchronized Random m29464h() {
        Random random;
        synchronized (C6463m.class) {
            if (f22434e == null) {
                f22434e = new Random();
            }
            random = f22434e;
        }
        return random;
    }

    public static boolean m29465h(Context context) {
        try {
            if (C6463m.m29446a(context, "android.permission.INTERNET") && C6463m.m29446a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        return true;
                    }
                    f22435f.m29409d("Network error");
                    return false;
                }
                return false;
            }
            f22435f.m29408c("can not get the permisson of android.permission.INTERNET");
            return false;
        } catch (Throwable th) {
        }
    }

    private static long m29466i() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
            return j;
        } catch (IOException e) {
            return j;
        }
    }

    public static String m29467i(Context context) {
        if (f22431b != null) {
            return f22431b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    f22431b = string;
                    return string;
                }
                f22435f.m29409d("Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f22435f.m29409d("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String m29468j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f22435f.m29409d("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f22435f.m29411f("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String m29469k(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String m29470l(Context context) {
        try {
            if (C6463m.m29446a(context, "android.permission.READ_PHONE_STATE")) {
                String str = "";
                if (C6463m.m29473o(context)) {
                    str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                }
                if (str != null) {
                    return str;
                }
            }
            f22435f.m29411f("Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
        return null;
    }

    public static String m29471m(Context context) {
        try {
            if (!C6463m.m29446a(context, "android.permission.READ_PHONE_STATE")) {
                f22435f.m29411f("Could not get permission of android.permission.READ_PHONE_STATE");
                return null;
            } else if (!C6463m.m29473o(context)) {
                return null;
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager != null ? telephonyManager.getSimOperator() : null;
            }
        } catch (Throwable th) {
            f22435f.m29411f(th);
            return null;
        }
    }

    public static String m29472n(Context context) {
        Object th;
        String str = "";
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str2 != null) {
                return str2;
            }
            try {
                return "";
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str2 = str;
            th = th4;
            f22435f.m29411f(th);
            return str2;
        }
    }

    public static boolean m29473o(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static String m29474p(Context context) {
        try {
            if (C6463m.m29446a(context, "android.permission.INTERNET") && C6463m.m29446a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        return typeName.equalsIgnoreCase("WIFI") ? "WIFI" : typeName.equalsIgnoreCase("MOBILE") ? extraInfo == null ? "MOBILE" : extraInfo : extraInfo == null ? typeName : extraInfo;
                    }
                }
                return null;
            }
            f22435f.m29411f("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return null;
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
    }

    public static Integer m29475q(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String m29476r(Context context) {
        Object th;
        String str = "";
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str2 != null) {
                try {
                    if (str2.length() != 0) {
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    f22435f.m29411f(th);
                    return str2;
                }
            }
            return "unknown";
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str2 = str;
            th = th4;
            f22435f.m29411f(th);
            return str2;
        }
    }

    public static int m29477s(Context context) {
        try {
            if (C6467q.m29489a()) {
                return 1;
            }
        } catch (Throwable th) {
            f22435f.m29411f(th);
        }
        return 0;
    }

    public static String m29478t(Context context) {
        try {
            if (C6463m.m29446a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState == null || !externalStorageState.equals("mounted")) {
                    return null;
                }
                externalStorageState = Environment.getExternalStorageDirectory().getPath();
                if (externalStorageState == null) {
                    return null;
                }
                StatFs statFs = new StatFs(externalStorageState);
                long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                return String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
            }
            f22435f.m29408c("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            f22435f.m29411f(th);
            return null;
        }
    }

    static String m29479u(Context context) {
        try {
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String m29480v(Context context) {
        return C6463m.m29451b(context, C6451a.f22383a);
    }

    public static synchronized Integer m29481w(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (C6463m.class) {
            try {
                int a = C6468r.m29490a(context, "MTA_EVENT_INDEX", 0);
                if (a < 2147483646) {
                    i = a;
                }
                C6468r.m29494b(context, "MTA_EVENT_INDEX", i + 1);
            } catch (Throwable th) {
                f22435f.m29411f(th);
            }
            valueOf = Integer.valueOf(i + 1);
        }
        return valueOf;
    }

    public static String m29482x(Context context) {
        return String.valueOf(C6463m.m29439G(context) / 1000000) + "/" + String.valueOf(C6463m.m29466i() / 1000000);
    }

    public static synchronized C6464n m29483y(Context context) {
        C6464n c6464n;
        synchronized (C6463m.class) {
            if (f22437h == null) {
                f22437h = new C6464n();
            }
            c6464n = f22437h;
        }
        return c6464n;
    }

    public static JSONObject m29484z(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            C6463m.m29483y(context);
            int b = C6464n.m29486b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            C6463m.m29483y(context);
            b = C6464n.m29487c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
            C6463m.m29483y(context);
            b = C6464n.m29485a();
            if (b > 0) {
                jSONObject.put("n", b);
            }
            C6463m.m29483y(context);
            String d = C6464n.m29488d();
            if (d != null && d.length() == 0) {
                C6463m.m29483y(context);
                jSONObject.put("na", C6464n.m29488d());
            }
        } catch (Exception e) {
            f22435f.m29406b(e);
        }
        return jSONObject;
    }
}
