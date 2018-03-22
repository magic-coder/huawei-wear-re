package com.huawei.android.pushagent.p018c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.android.microkernel.MKService;
import com.huawei.android.pushagent.b.d.a;
import com.huawei.android.pushagent.c.b.b;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p018c.p019a.C0658f;
import com.huawei.android.pushagent.p018c.p019a.C0659h;
import com.huawei.android.pushagent.p018c.p019a.p026a.C0655e;
import com.huawei.android.pushagent.p020b.p021a.C0646a;
import com.huawei.android.pushagent.p020b.p022b.C0648a;
import com.huawei.android.pushagent.p020b.p022b.C0649c;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class C0660a {
    private static final char[] f1191a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static int f1192b = -1;

    private static String m2547A(Context context) {
        if (context == null) {
            return "";
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuffer stringBuffer = new StringBuffer();
            if (signatureArr != null) {
                for (Signature toCharsString : signatureArr) {
                    stringBuffer.append(toCharsString.toCharsString());
                }
                C0657e.m2512a("PushLogAC2712", "Signature len is :" + signatureArr.length);
            }
            return stringBuffer.toString();
        } catch (NameNotFoundException e) {
            C0657e.m2522d("PushLogAC2712", "package with the given name can not be found");
            return "";
        }
    }

    private static boolean m2548B(Context context) {
        String A = C0660a.m2547A(context);
        C0657e.m2512a("PushLogAC2712", "signStr hashCode is :" + A.hashCode());
        return -735404696 == A.hashCode();
    }

    public static int m2549a(int i, int i2) {
        C0657e.m2512a("PushLogAC2712", "enter ctrlSockets(cmd:" + i + " param:" + i2 + ")");
        try {
            return ((Integer) Class.forName("dalvik.system.Zygote").getMethod("ctrlSockets", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        } catch (ClassNotFoundException e) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return -2;
        } catch (NoSuchMethodException e2) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return -2;
        } catch (IllegalArgumentException e3) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return -2;
        } catch (IllegalAccessException e4) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return -2;
        } catch (InvocationTargetException e5) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return -2;
        }
    }

    public static int m2550a(Socket socket) throws ClassNotFoundException {
        try {
            return ((Integer) FileDescriptor.class.getMethod("getInt$", new Class[0]).invoke((FileDescriptor) Socket.class.getMethod("getFileDescriptor$", new Class[0]).invoke(socket, new Object[0]), new Object[0])).intValue();
        } catch (NoSuchMethodException e) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return 0;
        } catch (IllegalArgumentException e2) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return 0;
        } catch (IllegalAccessException e3) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return 0;
        } catch (InvocationTargetException e4) {
            C0657e.m2512a("PushLogAC2712", "There is no method of ctrlSockets.");
            return 0;
        }
    }

    public static long m2551a(String str) {
        long j = -1;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse(str);
            if (parse != null) {
                j = parse.getTime();
            }
        } catch (ParseException e) {
            C0657e.m2522d("PushLogAC2712", "ParseException,timeStr:" + str + " e:" + e.toString());
        }
        return j;
    }

    public static ResolveInfo m2552a(Context context, Intent intent) {
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 640);
        return (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) ? null : (ResolveInfo) queryBroadcastReceivers.get(0);
    }

    public static String m2553a() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        return replace.length() > 15 ? HwAccountConstants.SPLIIT_UNDERLINE + replace.substring(0, 15) : HwAccountConstants.SPLIIT_UNDERLINE + "000000000000000".substring(15 - replace.length()) + replace;
    }

    public static String m2554a(byte b) {
        return new String(new char[]{f1191a[(b & 240) >> 4], f1191a[b & 15]});
    }

    public static String m2555a(long j, String str) {
        String str2 = "";
        try {
            str2 = new SimpleDateFormat(str).format(new Date(j));
        } catch (Exception e) {
            C0657e.m2522d("PushLogAC2712", "getTimeString,milliseconds:" + j + " e:" + e.toString());
        }
        return str2;
    }

    public static String m2556a(Context context) {
        Object d = C0660a.m2577d(context);
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String b = C0660a.m2567b(context);
        C0658f.m2527a(context, SdkConstants.DEVICE_INFO, "deviceId", b);
        return b;
    }

    public static String m2557a(Context context, String str, String str2) {
        String str3 = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 640);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                C0657e.m2512a("PushLogAC2712", "could not read Applicationinfo from AndroidManifest.xml.");
                return str3;
            }
            Object obj = applicationInfo.metaData.get(str2);
            if (obj == null) {
                C0657e.m2517b("PushLogAC2712", "could not read meta-data from AndroidManifest.xml.");
            } else {
                str3 = String.valueOf(obj);
                C0657e.m2512a("PushLogAC2712", "read meta-data from AndroidManifest.xml,name is:" + str2 + ",value is:" + str3);
            }
            return str3;
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", e.toString(), e);
        }
    }

    public static String m2558a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[i * 2] = f1191a[(b & 240) >> 4];
            cArr[(i * 2) + 1] = f1191a[b & 15];
        }
        return new String(cArr);
    }

    public static ArrayList m2559a(Context context, String str) {
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent(str), 0);
        int size = queryBroadcastReceivers == null ? 0 : queryBroadcastReceivers.size();
        ArrayList arrayList = new ArrayList();
        if (size <= 0) {
            return arrayList;
        }
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryBroadcastReceivers.get(i);
            arrayList.add((resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo).packageName);
        }
        return arrayList;
    }

    public static void m2560a(Context context, int i) {
        switch (i) {
            case 1:
                C0660a.m2602y(context);
                C0660a.m2589l(context);
                C0649c.m2458a(context).m2467a();
                C0649c.m2458a(context).m2468b();
                new C0659h(context, "pushConfig").m2546f("forbiddenMultiChannel");
                C0648a.m2450b(context);
                return;
            case 2:
                C0660a.m2588k(context);
                C0660a.m2602y(context);
                C0660a.m2603z(context);
                C0649c.m2458a(context).m2467a();
                C0649c.m2458a(context).m2468b();
                C0648a.m2450b(context);
                return;
            case 3:
                C0660a.m2602y(context);
                C0660a.m2603z(context);
                C0649c.m2458a(context).m2467a();
                C0649c.m2458a(context).m2468b();
                return;
            default:
                return;
        }
    }

    public static void m2561a(Context context, long j) {
        C0657e.m2512a("PushLogAC2712", "enter wakeSystem");
        ((PowerManager) context.getSystemService("power")).newWakeLock(1, "pushagent").acquire(j);
    }

    public static void m2562a(Context context, boolean z) {
        if (context != null) {
            if (MKService.getAppContext() == null) {
                C0660a.m2563a(context, "com.huawei.android.pushagent.PushBootReceiver", z);
            } else {
                C0660a.m2563a(context, "com.huawei.deviceCloud.microKernel.push.PushBootReceiver", z);
            }
        }
    }

    public static boolean m2563a(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        C0657e.m2512a("PushLogAC2712", "setReceiverState:" + context.getPackageName() + ",isEnable:" + z);
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, str), !z ? 2 : 1, 1);
            return true;
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", e.toString(), e);
            return false;
        }
    }

    public static byte[] m2564a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] m2565a(long j) {
        byte[] bArr = new byte[8];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr[length] = (byte) ((int) j);
            j >>= 8;
        }
        return bArr;
    }

    public static int m2566b(byte[] bArr) {
        return ((((bArr[0] << 24) & 255) | ((bArr[1] << 16) & 255)) | ((bArr[2] << 8) & 255)) | (bArr[3] & 255);
    }

    public static String m2567b(Context context) {
        Object c = C0660a.m2574c(context);
        return TextUtils.isEmpty(c) ? C0660a.m2553a() : c;
    }

    public static List m2568b(Context context, String str) {
        return context.getPackageManager().queryBroadcastReceivers(new Intent(str), 640);
    }

    public static void m2569b() {
        C0657e.m2512a("PushLogAC2712", "enter powerLow");
        try {
            Class.forName("android.util.LogPower").getMethod("push", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(TagName.ELECTRONIC_USE_COUNT)});
        } catch (ClassNotFoundException e) {
            C0657e.m2512a("PushLogAC2712", "need not support LogPower");
        } catch (NoSuchMethodException e2) {
            C0657e.m2512a("PushLogAC2712", "need not support LogPower");
        } catch (IllegalArgumentException e3) {
            C0657e.m2512a("PushLogAC2712", "need not support LogPower");
        } catch (IllegalAccessException e4) {
            C0657e.m2512a("PushLogAC2712", "need not support LogPower");
        } catch (InvocationTargetException e5) {
            C0657e.m2512a("PushLogAC2712", "need not support LogPower");
        }
    }

    private static boolean m2570b(Context context, boolean z) {
        boolean z2 = true;
        C0657e.m2512a("PushLogAC2712", "existFrameworkPush:" + f1192b + ",realCheck:" + z);
        if (z) {
            try {
                if (new File("/system/framework/" + "hwpush.jar").isFile()) {
                    C0657e.m2512a("PushLogAC2712", "push jarFile is exist");
                } else {
                    C0657e.m2517b("PushLogAC2712", "push jarFile is not exist");
                    if (SystemProperties.getBoolean("ro.config.push_enable", PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(SystemProperties.get("ro.product.locale.region")))) {
                        String str = SystemProperties.get("ro.build.version.emui", "-1");
                        if (TextUtils.isEmpty(str) || !(str.contains("2.0") || str.contains("2.3"))) {
                            C0657e.m2512a("PushLogAC2712", "can not use framework push");
                            return false;
                        }
                        C0657e.m2512a("PushLogAC2712", "emui is 2.0 or 2.3");
                    } else {
                        C0657e.m2512a("PushLogAC2712", "framework not support push");
                        return false;
                    }
                }
                List queryIntentServices = context.getPackageManager().queryIntentServices(new Intent().setClassName("android", "com.huawei.android.pushagentproxy.PushService"), 128);
                if (queryIntentServices == null || queryIntentServices.size() == 0) {
                    C0657e.m2517b("PushLogAC2712", "framework push not exist, need vote apk or sdk to support pushservice");
                    return false;
                }
                C0657e.m2517b("PushLogAC2712", "framework push exist, use framework push first");
                return true;
            } catch (Exception e) {
                C0657e.m2522d("PushLogAC2712", "get Apk version faild ,Exception e= " + e.toString());
                return false;
            }
        }
        if (1 != f1192b) {
            z2 = false;
        }
        return z2;
    }

    public static byte[] m2571b(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int m2572c(byte[] bArr) {
        return ((bArr[0] & 255) << 8) | (bArr[1] & 255);
    }

    public static String m2573c() {
        String str = "";
        Class[] clsArr = new Class[]{String.class};
        Object[] objArr = new Object[]{"ro.build.version.emui"};
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            C0657e.m2512a("PushLogAC2712", "get EMUI version is:" + str2);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        } catch (ClassNotFoundException e) {
            C0657e.m2522d("PushLogAC2712", " getEmuiVersion wrong, ClassNotFoundException");
        } catch (LinkageError e2) {
            C0657e.m2522d("PushLogAC2712", " getEmuiVersion wrong, LinkageError");
        } catch (NoSuchMethodException e3) {
            C0657e.m2522d("PushLogAC2712", " getEmuiVersion wrong, NoSuchMethodException");
        } catch (NullPointerException e4) {
            C0657e.m2522d("PushLogAC2712", " getEmuiVersion wrong, NullPointerException");
        } catch (IllegalAccessException e5) {
            C0657e.m2522d("PushLogAC2712", " getEmuiVersion wrong, IllegalAccessException");
        } catch (IllegalArgumentException e6) {
            C0657e.m2522d("PushLogAC2712", " getEmuiVersion wrong, IllegalArgumentException");
        } catch (InvocationTargetException e7) {
            C0657e.m2522d("PushLogAC2712", " getEmuiVersion wrong, InvocationTargetException");
        }
        return str;
    }

    public static String m2574c(Context context) {
        String a;
        String str = "";
        boolean ae = C0648a.m2447a(context).ae();
        C0657e.m2512a("PushLogAC2712", "isMultiSimEnabledFromServer:" + ae);
        if (b.b() && ae) {
            C0657e.m2512a("PushLogAC2712", "multicard device");
            a = b.a().a(0);
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            a = telephonyManager != null ? telephonyManager.getDeviceId() : str;
        }
        if (TextUtils.isEmpty(a) || a.matches("[0]+")) {
            C0657e.m2517b("PushLogAC2712", "get uniqueId from device is empty or all 0");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (a.length() >= 16) {
            return a.substring(a.length() - 16);
        }
        stringBuffer.append("0").append(a);
        if (stringBuffer.length() < 16) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i = 0; i < 16 - stringBuffer.length(); i++) {
                stringBuffer2.append("0");
            }
            stringBuffer.append(stringBuffer2);
        }
        return stringBuffer.toString();
    }

    public static boolean m2575c(Context context, String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            if (C0660a.m2552a(context, new Intent("com.huawei.android.push.intent.REGISTRATION").setPackage(str)) != null) {
                z = true;
            }
            C0657e.m2512a("PushLogAC2712", "isPushClient:" + z);
        }
        return z;
    }

    public static long m2576d(byte[] bArr) {
        return (((((((0 | ((((long) bArr[0]) & 255) << 56)) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
    }

    public static String m2577d(Context context) {
        C0657e.m2512a("PushLogAC2712", "enter getImeiFromLocalFile()");
        String a = C0658f.m2526a(context, SdkConstants.DEVICE_INFO, "deviceId");
        if (TextUtils.isEmpty(a) || 16 != a.length()) {
            C0657e.m2520c("PushLogAC2712", "no deviceId in device_info");
        } else {
            C0657e.m2512a("PushLogAC2712", "get imei from localFile success");
        }
        return a;
    }

    public static boolean m2578d(Context context, String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            if (C0660a.m2552a(context, new Intent("com.huawei.android.push.intent.REGISTER").setPackage(str)) != null) {
                z = true;
            }
            C0657e.m2512a("PushLogAC2712", "hasPushRegister:" + z);
        }
        return z;
    }

    public static boolean m2579e(Context context) {
        CharSequence d = C0660a.m2577d(context);
        C0657e.m2512a("PushLogAC2712", "imei from localfile is " + C0655e.m2502a(d));
        CharSequence c = C0660a.m2574c(context);
        C0657e.m2512a("PushLogAC2712", "deviceId from device is " + C0655e.m2502a(c));
        CharSequence m = C0660a.m2590m(context);
        Object n = C0660a.m2591n(context);
        C0657e.m2512a("PushLogAC2712", "mac from localfile is " + C0655e.m2502a(m));
        C0657e.m2512a("PushLogAC2712", "mac from device is " + C0655e.m2502a(n));
        if (TextUtils.isEmpty(d) || TextUtils.isEmpty(c)) {
            if (TextUtils.isEmpty(d)) {
                C0658f.m2527a(context, SdkConstants.DEVICE_INFO, "deviceId", C0660a.m2567b(context));
            }
            if (TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) {
                if (!TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) {
                    return false;
                }
                C0658f.m2527a(context, SdkConstants.DEVICE_INFO, "macAddress", n);
                return false;
            } else if (m.equals(n)) {
                return false;
            } else {
                C0657e.m2520c("PushLogAC2712", "After check mac, it is cloned, need reset files");
                return true;
            }
        } else if (d.equals(c)) {
            return false;
        } else {
            C0657e.m2520c("PushLogAC2712", "After check imei, it is cloned, need reset files");
            return true;
        }
    }

    public static boolean m2580e(Context context, String str) {
        String str2 = context.getCacheDir().getParent() + "/shared_prefs/" + str + ".xml";
        File file = new File(str2);
        if (file.exists() && file.isFile() && file.canWrite()) {
            C0657e.m2512a("PushLogAC2712", "enter deletePrefrence(fileName:" + str + ".xml)");
            return file.delete();
        }
        if (file.exists()) {
            C0657e.m2522d("PushLogAC2712", "delete File:" + str2 + " failed!!");
        }
        return false;
    }

    public static String m2581f(Context context, String str) {
        String a = C0660a.m2557a(context, str, Constant.TARGET_CHANNEL);
        if (a == null) {
            return str;
        }
        str = str + "#" + a;
        C0657e.m2512a("PushLogAC2712", "after add downloadChannel, the new packageName is:" + str);
        return str;
    }

    public static void m2582f(Context context) {
        if (C0660a.m2579e(context)) {
            new Thread(new com.huawei.android.pushagent.c.b(context)).start();
        }
    }

    public static String m2583g(Context context) {
        return String.valueOf(2712);
    }

    public static boolean m2584g(Context context, String str) {
        if (context == null || str == null || "".equals(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) == null) {
                return false;
            }
            C0657e.m2512a("PushLogAC2712", str + " is installed");
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static String m2585h(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null) {
            return "";
        }
        char[] toCharArray = simOperator.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] < '0' || toCharArray[i] > '9') {
                return simOperator.substring(0, i);
            }
            i++;
        }
        return simOperator;
    }

    public static String m2586i(Context context) {
        return C0660a.m2556a(context) + SNBConstant.DEFAULT_CARD_NO;
    }

    public static String m2587j(Context context) {
        if (context == null) {
            return "";
        }
        String extraInfo;
        String str = "";
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null) {
                    extraInfo = "";
                }
                C0657e.m2512a("PushLogAC2712", "push apn is " + extraInfo);
                return extraInfo;
            }
        }
        extraInfo = str;
        if (extraInfo == null) {
            extraInfo = "";
        }
        C0657e.m2512a("PushLogAC2712", "push apn is " + extraInfo);
        return extraInfo;
    }

    public static void m2588k(Context context) {
        try {
            C0648a.m2447a(context).c.clear();
            com.huawei.android.pushagent.b.e.b.a(context).a.clear();
            a.b(context).a();
        } catch (Exception e) {
            C0657e.m2522d("PushLogAC2712", "clearMemory failed!");
        }
    }

    public static void m2589l(Context context) {
        C0659h c0659h = new C0659h(context, "pclient_info_v2");
        for (String str : c0659h.m2541b().keySet()) {
            if (!C0660a.m2584g(context, str)) {
                c0659h.m2546f(str);
            }
        }
    }

    public static String m2590m(Context context) {
        C0657e.m2512a("PushLogAC2712", "enter getMacFromLocalFile()");
        String str = "";
        Object a = C0658f.m2526a(context, SdkConstants.DEVICE_INFO, "macAddress");
        if (TextUtils.isEmpty(a)) {
            C0657e.m2520c("PushLogAC2712", "no macAddress in device_info");
        } else {
            C0657e.m2512a("PushLogAC2712", "get macAddress from LocalFile success");
        }
        return a;
    }

    public static String m2591n(Context context) {
        Throwable e;
        C0657e.m2512a("PushLogAC2712", "enter getMacAddress()");
        String str = "";
        String macAddress;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                C0657e.m2520c("PushLogAC2712", "info = null");
                return str;
            }
            macAddress = connectionInfo.getMacAddress();
            try {
                if (TextUtils.isEmpty(macAddress)) {
                    C0657e.m2520c("PushLogAC2712", "Mac is empty");
                    return macAddress;
                }
                C0657e.m2512a("PushLogAC2712", "get Mac from device success");
                return macAddress;
            } catch (Exception e2) {
                e = e2;
                C0657e.m2521c("PushLogAC2712", "getLocalMacAddress() exception,e=" + e.toString(), e);
                return macAddress;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            macAddress = str;
            e = th;
            C0657e.m2521c("PushLogAC2712", "getLocalMacAddress() exception,e=" + e.toString(), e);
            return macAddress;
        }
    }

    public static synchronized boolean m2592o(Context context) {
        boolean z = true;
        synchronized (C0660a.class) {
            C0657e.m2512a("PushLogAC2712", "existFrameworkPush:" + f1192b);
            if (-1 == f1192b) {
                if (C0660a.m2570b(context, true)) {
                    f1192b = 1;
                } else {
                    f1192b = 0;
                }
                if (1 != f1192b) {
                    z = false;
                }
            } else if (1 != f1192b) {
                z = false;
            }
        }
        return z;
    }

    public static void m2593p(Context context) {
        try {
            if ("com.huawei.android.pushagent".equals(context.getPackageName()) && !C0660a.m2548B(context)) {
                C0657e.m2522d("PushLogAC2712", "signature of apk HwPushService is not test");
                Toast.makeText(context, "Signature of HwPushService is not correct", 1).show();
            }
        } catch (Throwable e) {
            C0657e.m2513a("PushLogAC2712", "checkAPKSignature error", e);
        }
    }

    public static int m2594q(Context context) {
        int c = new C0659h(context, "pushConfig").m2542c("NeedMyServiceRun");
        if (c < 0 || c > 2) {
            c = 0;
        }
        C0657e.m2512a("PushLogAC2712", "in file needMyServiceRun is : " + c);
        return c;
    }

    public static String m2595r(Context context) {
        String b = new C0659h(context, "pushConfig").m2540b("votedPackageName");
        C0657e.m2517b("PushLogAC2712", "votedPackage from file:" + b);
        return b;
    }

    public static boolean m2596s(Context context) {
        int c = new C0659h(context, "pushConfig").m2542c("forbiddenMultiChannel");
        C0657e.m2517b("PushLogAC2712", "forbiddenMultiChannel from file:" + c);
        return 1 == c;
    }

    private static void m2600w(Context context) {
        C0657e.m2512a("PushLogAC2712", "update deviceInfo File");
        new C0659h(context, SdkConstants.DEVICE_INFO).m2543c();
        String b = C0660a.m2567b(context);
        String n = C0660a.m2591n(context);
        C0658f.m2527a(context, SdkConstants.DEVICE_INFO, "deviceId", b);
        C0658f.m2527a(context, SdkConstants.DEVICE_INFO, "macAddress", n);
    }

    private static void m2601x(Context context) {
        C0659h c0659h = new C0659h(context, "pclient_request_info");
        C0659h c0659h2 = new C0659h(context, "pclient_info_v2");
        for (String str : c0659h2.m2541b().keySet()) {
            if (!TextUtils.isEmpty(str)) {
                c0659h.m2539a(str, "true");
                C0657e.m2512a("PushLogAC2712", "pkg : " + str + " need register again");
            }
        }
        c0659h2.m2543c();
    }

    private static void m2602y(Context context) {
        C0660a.m2580e(context, "PushConnectControl");
        C0660a.m2580e(context, "PushRouteInfo");
        C0660a.m2580e(context, "RouteInfo");
        C0660a.m2580e(context, "HeartBeatCfg");
        for (String e : C0646a.m2431a(context).m2438a()) {
            C0660a.m2580e(context, e);
        }
        C0660a.m2580e(context, "socket_info");
        C0660a.m2580e(context, "update_remind");
    }

    private static void m2603z(Context context) {
        C0660a.m2580e(context, "pclient_request_info");
        C0660a.m2580e(context, "pclient_unRegist_info_v2");
        C0660a.m2580e(context, "pclient_info_v2");
        C0660a.m2580e(context, "pclient_info");
    }
}
