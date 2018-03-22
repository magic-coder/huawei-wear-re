package com.tencent.open.p532d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.open.p541a.C6367n;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public class C6406s {
    public static String m29220a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static int m29217a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException e) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        if (split2.length > i) {
            return -1;
        }
        return 0;
    }

    public static String m29223b(Context context, String str) {
        String packageName;
        Throwable e;
        C6367n.m29104a("openSDK_LOG", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(signatureArr[0].toByteArray());
            String a = C6412y.m29243a(instance.digest());
            instance.reset();
            C6367n.m29107b("SystemUtils", "-->sign: " + a);
            instance.update(C6412y.m29269k(packageName + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + str + ""));
            packageName = C6412y.m29243a(instance.digest());
            try {
                instance.reset();
                C6367n.m29107b("SystemUtils", "-->signEncryped: " + packageName);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C6367n.m29108b("openSDK_LOG", "OpenUi, getSignValidString error", e);
                return packageName;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            packageName = str2;
            e = th;
            e.printStackTrace();
            C6367n.m29108b("openSDK_LOG", "OpenUi, getSignValidString error", e);
            return packageName;
        }
        return packageName;
    }

    public static boolean m29221a(Context context, Intent intent) {
        if (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
            return false;
        }
        return true;
    }

    public static String m29219a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int m29225c(Context context, String str) {
        return C6406s.m29217a(C6406s.m29220a(context, "com.tencent.mobileqq"), str);
    }

    public static int m29216a() {
        int i = 0;
        try {
            i = Integer.valueOf(VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
        }
        return i;
    }

    public static boolean m29224b() {
        boolean z = false;
        boolean z2 = false;
        for (Method method : MotionEvent.class.getDeclaredMethods()) {
            if (method.getName().equals("getPointerCount")) {
                z2 = true;
            }
            if (method.getName().equals("getPointerId")) {
                z = true;
            }
        }
        if (C6406s.m29216a() >= 7) {
            return true;
        }
        if (z2 && r2) {
            return true;
        }
        return false;
    }

    @SuppressLint({"SdCardPath"})
    public static boolean m29222a(String str, String str2, int i) {
        Throwable e;
        Throwable th;
        OutputStream outputStream = null;
        C6367n.m29110c("openSDK_LOG.SysUtils", "-->extractSecureLib, libName: " + str);
        Context a = C6395h.m29184a();
        if (a == null) {
            C6367n.m29110c("openSDK_LOG.SysUtils", "-->extractSecureLib, global context is null. ");
            return false;
        }
        SharedPreferences sharedPreferences = a.getSharedPreferences("secure_lib", 0);
        File file = new File(a.getFilesDir(), str2);
        if (file.exists()) {
            int i2 = sharedPreferences.getInt("version", 0);
            C6367n.m29110c("openSDK_LOG.SysUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            if (i == i2) {
                return true;
            }
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && parentFile.mkdirs()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        InputStream open;
        try {
            open = a.getAssets().open(str);
            try {
                outputStream = a.openFileOutput(str2, 0);
                C6406s.m29218a(open, outputStream);
                Editor edit = sharedPreferences.edit();
                edit.putInt("version", i);
                edit.commit();
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e3) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                try {
                    C6367n.m29108b("openSDK_LOG.SysUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (outputStream != null) {
                        return false;
                    }
                    try {
                        outputStream.close();
                        return false;
                    } catch (IOException e7) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e9) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e10) {
            e = e10;
            open = null;
            C6367n.m29108b("openSDK_LOG.SysUtils", "-->extractSecureLib, when copy lib execption.", e);
            if (open != null) {
                open.close();
            }
            if (outputStream != null) {
                return false;
            }
            outputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            open = null;
            if (open != null) {
                open.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    private static long m29218a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                C6367n.m29110c("openSDK_LOG.SysUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }
}
