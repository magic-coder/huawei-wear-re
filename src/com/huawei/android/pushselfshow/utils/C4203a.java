package com.huawei.android.pushselfshow.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p018c.p019a.p026a.C4101g;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.richpush.provider.C4198a;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

public class C4203a {
    private static final char[] f15811a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static Typeface f15812b = null;

    public static int m20412a(int i, int i2) {
        e.a("PushSelfShowLog", "enter ctrlSockets(cmd:" + i + " param:" + i2 + ")");
        try {
            return ((Integer) Class.forName("dalvik.system.Zygote").getMethod("ctrlSockets", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        } catch (NoSuchMethodException e) {
            e.d("PushSelfShowLog", "NoSuchMethodException:" + e);
            return -2;
        } catch (ClassNotFoundException e2) {
            e.d("PushSelfShowLog", "ClassNotFoundException:" + e2);
            return -2;
        } catch (IllegalAccessException e3) {
            e.d("PushSelfShowLog", "IllegalAccessException:" + e3);
            return -2;
        } catch (InvocationTargetException e4) {
            e.d("PushSelfShowLog", "InvocationTargetException:" + e4);
            return -2;
        } catch (RuntimeException e5) {
            e.d("PushSelfShowLog", "RuntimeException:" + e5);
            return -2;
        } catch (Exception e6) {
            e.d("PushSelfShowLog", "Exception:" + e6);
            return -2;
        }
    }

    public static int m20413a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static long m20414a() {
        return System.currentTimeMillis();
    }

    public static long m20415a(Context context) {
        e.a("PushSelfShowLog", "enter getVersion()");
        long a;
        try {
            List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent("com.huawei.android.push.intent.REGISTER").setPackage(context.getPackageName()), 640);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() == 0) {
                return -1000;
            }
            a = C4203a.m20416a((ResolveInfo) queryBroadcastReceivers.get(0), "CS_cloud_version");
            e.a("PushSelfShowLog", "get the version is :" + a);
            return a;
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
            a = -1000;
        }
    }

    public static long m20416a(ResolveInfo resolveInfo, String str) {
        long j = -1;
        if (resolveInfo != null) {
            try {
                j = Long.parseLong(C4203a.m20429b(resolveInfo, str));
            } catch (NumberFormatException e) {
                e.b("PushSelfShowLog", str + " is not set in " + C4203a.m20420a(resolveInfo));
            }
        }
        return j;
    }

    public static Intent m20417a(Context context, String str) {
        Intent intent = null;
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Throwable e) {
            e.b("PushSelfShowLog", e.toString(), e);
        }
        return intent;
    }

    public static Boolean m20418a(Context context, String str, Intent intent) {
        try {
            List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                int i = 0;
                while (i < size) {
                    if (((ResolveInfo) queryIntentActivities.get(i)).activityInfo != null && str.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.applicationInfo.packageName)) {
                        return Boolean.valueOf(true);
                    }
                    i++;
                }
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
        return Boolean.valueOf(false);
    }

    public static String m20419a(Context context, String str, String str2) {
        try {
            if (context.getResources().getConfiguration().locale.getLanguage().endsWith(PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH)) {
                return str;
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "getStringByLanguage failed ", e);
        }
        return str2;
    }

    public static String m20420a(ResolveInfo resolveInfo) {
        return resolveInfo.serviceInfo != null ? resolveInfo.serviceInfo.packageName : resolveInfo.activityInfo.packageName;
    }

    public static String m20421a(String str) {
        String str2 = "";
        String str3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDf5raDExuuXbsVNCWl48yuB89W\rfNOuuhPuS2Mptii/0UorpzypBkNTTGt11E7aorCc1lFwlB+4KDMIpFyQsdChSk+A\rt9UfhFKa95uiDpMe5rMfU+DAhoXGER6WQ2qGtrHmBWVv33i3lc76u9IgEfYuLwC6\r1mhQDHzAKPiViY6oeQIDAQAB\r";
        try {
            str2 = C4203a.m20422a(C4101g.m20119a(str.getBytes(GameManager.DEFAULT_CHARSET), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDf5raDExuuXbsVNCWl48yuB89W\rfNOuuhPuS2Mptii/0UorpzypBkNTTGt11E7aorCc1lFwlB+4KDMIpFyQsdChSk+A\rt9UfhFKa95uiDpMe5rMfU+DAhoXGER6WQ2qGtrHmBWVv33i3lc76u9IgEfYuLwC6\r1mhQDHzAKPiViY6oeQIDAQAB\r"));
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "encrypter error ", e);
        }
        return str2;
    }

    public static String m20422a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(f15811a[(bArr[i] >>> 4) & 15]);
            stringBuilder.append(f15811a[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static void m20423a(Context context, Intent intent, long j) {
        try {
            e.a("PushSelfShowLog", "enter setAPDelayAlarm(intent:" + intent.toURI() + " interval:" + j + "ms, context:" + context);
            ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, new SecureRandom().nextInt(), intent, 0));
        } catch (Throwable e) {
            e.a("PushSelfShowLog", "set DelayAlarm error", e);
        }
    }

    public static void m20424a(Context context, String str, C4149a c4149a) {
        if (c4149a != null) {
            C4203a.m20425a(context, str, c4149a.f15590l, c4149a.f15593o);
        }
    }

    public static void m20425a(Context context, String str, String str2, String str3) {
        new Thread(new C4208b(context, str2, str, str3)).start();
    }

    public static void m20426a(File file) {
        if (file != null) {
            e.a("PushSelfShowLog", "delete file " + file.getAbsolutePath());
            File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
            if (!file.renameTo(file2)) {
                return;
            }
            if (!(file2.isFile() && file2.delete()) && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File a : listFiles) {
                        C4203a.m20426a(a);
                    }
                    if (!file2.delete()) {
                        e.a("PushSelfShowLog", "delete file unsuccess");
                    }
                } else if (!file2.delete()) {
                    e.a("PushSelfShowLog", "delete file failed");
                }
            }
        }
    }

    public static long m20427b(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Date date = new Date();
            int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
            String concat = str.concat(str);
            e.a("PushSelfShowLog", "startIndex is %s ,and ap is %s ,length is %s", new Object[]{Integer.valueOf(hours), concat, Integer.valueOf(concat.length())});
            int i = hours;
            while (i < concat.length()) {
                if (concat.charAt(i) != '0') {
                    long minutes = ((long) (((i - hours) * 30) - (date.getMinutes() % 30))) * FileWatchdog.DEFAULT_DELAY;
                    e.a("PushSelfShowLog", "startIndex is %s i is %s delay %s", new Object[]{Integer.valueOf(hours), Integer.valueOf(i), Long.valueOf(minutes)});
                    return minutes >= 0 ? minutes : 0;
                } else {
                    i++;
                }
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "error ", e);
        }
        return 0;
    }

    public static String m20428b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getDeviceId() : "";
    }

    private static String m20429b(ResolveInfo resolveInfo, String str) {
        Bundle bundle = resolveInfo.serviceInfo != null ? resolveInfo.serviceInfo.metaData : resolveInfo.activityInfo.metaData;
        return bundle == null ? null : bundle.getString(str);
    }

    public static void m20430b(File file) {
        e.a("PushSelfShowLog", "delete file before ");
        if (file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    try {
                        if (currentTimeMillis - file2.lastModified() > 86400000) {
                            e.e("PushSelfShowLog", "delete file before " + file2.getAbsolutePath());
                            C4203a.m20426a(file2);
                        }
                    } catch (Exception e) {
                        e.e("PushSelfShowLog", e.toString());
                    }
                }
            }
        }
    }

    public static boolean m20431b() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean m20432b(Context context, String str) {
        if (context == null || str == null || "".equals(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                return false;
            }
            e.a("PushSelfShowLog", str + " is installed");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String m20433c(Context context, String str) {
        String str2;
        Throwable e;
        String str3 = "";
        try {
            str2 = "";
            str2 = ((!Environment.getExternalStorageState().equals("mounted") ? context.getFilesDir().getPath() : Environment.getExternalStorageDirectory().getPath()) + File.separator + "PushService") + File.separator + str;
            try {
                e.a("PushSelfShowLog", "dbPath is " + str2);
            } catch (Exception e2) {
                e = e2;
                e.d("PushSelfShowLog", "getDbPath error", e);
                return str2;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            str2 = str3;
            e = th;
            e.d("PushSelfShowLog", "getDbPath error", e);
            return str2;
        }
        return str2;
    }

    public static boolean m20434c() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean m20435c(Context context) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setPackage("com.android.email");
        intent.setData(Uri.fromParts("mailto", "xxxx@xxxx.com", null));
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        return (queryIntentActivities == null || queryIntentActivities.size() == 0) ? false : true;
    }

    public static boolean m20436d() {
        return C4103b.m20121a() >= 9;
    }

    public static boolean m20437d(Context context) {
        return "com.huawei.android.pushagent".equals(context.getPackageName());
    }

    public static boolean m20438e(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.android.pushagent", 128) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m20439f(Context context) {
        Cursor query;
        Throwable e;
        try {
            query = context.getContentResolver().query(C4198a.f15799a, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(query.getColumnIndex("isSupport"));
                        e.a("PushSelfShowLog", "isExistProvider:" + i);
                        boolean z = 1 == i;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.a("PushSelfShowLog", e.toString(), e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            e.a("PushSelfShowLog", e.toString(), e);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return false;
    }

    public static int m20440g(Context context) {
        if (context == null) {
            return 3;
        }
        return (VERSION.SDK_INT < 16 || context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null) == 0) ? 3 : 0;
    }

    public static int m20441h(Context context) {
        try {
            Class cls = Class.forName("com.huawei.android.immersion.ImmersionStyle");
            int intValue = ((Integer) cls.getDeclaredMethod("getPrimaryColor", new Class[]{Context.class}).invoke(cls, new Object[]{context})).intValue();
            e.b("PushSelfShowLog", "colorPrimary:" + intValue);
            return intValue;
        } catch (ClassNotFoundException e) {
            e.d("PushSelfShowLog", "ImmersionStyle ClassNotFoundException");
        } catch (Throwable e2) {
            e.c("PushSelfShowLog", e2.toString(), e2);
        } catch (Throwable e22) {
            e.c("PushSelfShowLog", e22.toString(), e22);
        } catch (Throwable e222) {
            e.c("PushSelfShowLog", e222.toString(), e222);
        } catch (Throwable e2222) {
            e.c("PushSelfShowLog", e2222.toString(), e2222);
        } catch (Throwable e22222) {
            e.c("PushSelfShowLog", e22222.toString(), e22222);
        }
        return 0;
    }

    private static boolean m20443j(Context context) {
        boolean z = true;
        int i = -1;
        if (context == null) {
            return false;
        }
        try {
            i = Secure.getInt(context.getContentResolver(), "user_experience_involved", -1);
            e.a("PushSelfShowLog", "settingMainSwitch:" + i);
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
        if (i != 1) {
            z = false;
        }
        return z;
    }
}
