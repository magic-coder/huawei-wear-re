package com.huawei.pluginkidwatch.common.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.huawei.hwdatamigrate.common.C0998f;
import com.huawei.hwdatamigrate.common.C0999h;
import com.huawei.hwdatamigrate.common.a.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.p149e.C1480b;
import com.huawei.pluginkidwatch.common.p138a.C1392h;

/* compiled from: SharedPreferencesUtil */
public class C1497q {
    private static final String f3497a = ("KIDWATCH_" + C1497q.class.getSimpleName());
    private static SharedPreferences f3498b;
    private static Editor f3499c;
    private static char[] f3500d = null;
    private static char[] f3501e = null;
    private static char[] f3502f = null;
    private static String f3503g = "";
    private static String f3504h = "";
    private static String f3505i = "";

    private static void m6949c(Context context) {
        synchronized (C1497q.class) {
            f3498b = C0999h.m3625a(f3498b, context);
            f3499c = C0999h.m3624a(f3498b, f3499c, context);
        }
    }

    public static void m6943a(Context context, String str, String str2) {
        C2538c.m12674b(f3497a, "====setString==== keyShared = ", str, ", valueName = ", str2);
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            C1497q.m6946b(context);
            f3499c.putString(str, C1484d.m6838a(str2));
            f3499c.commit();
        }
    }

    private static String m6951d(Context context, String str) {
        String string;
        C2538c.m12674b(f3497a, "====setString==== keyShared = ", str);
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            string = f3498b.getString(str, "");
        }
        return string;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m6945b(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
        r0 = f3497a;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "====getString==== keyShared = ";
        r1[r2] = r3;
        r2 = 1;
        r1[r2] = r5;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r1 = com.huawei.pluginkidwatch.common.lib.utils.C1497q.class;
        monitor-enter(r1);
        com.huawei.pluginkidwatch.common.lib.utils.C1497q.m6949c(r4);	 Catch:{ all -> 0x0031 }
        r0 = f3498b;	 Catch:{ all -> 0x0031 }
        r0 = r0.getString(r5, r6);	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        r2 = r0.equals(r6);	 Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0026;
    L_0x0024:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
    L_0x0025:
        return r6;
    L_0x0026:
        com.huawei.pluginkidwatch.common.lib.utils.C1497q.m6946b(r4);	 Catch:{ all -> 0x0031 }
        r0 = com.huawei.pluginkidwatch.common.lib.utils.C1484d.m6840b(r0);	 Catch:{ all -> 0x0031 }
        if (r0 != 0) goto L_0x0034;
    L_0x002f:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        goto L_0x0025;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        r6 = r0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.common.lib.utils.q.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void m6940a(Context context) {
        C2538c.m12674b(f3497a, "====getDeviceCodeString==== keyShared = ", "sharedpreferences_watch_device_code");
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            String string = f3498b.getString("sharedpreferences_watch_device_code", "");
            C2538c.m12674b(f3497a, "====getDeviceCodeString==== res = ", string, "res length = ", Integer.valueOf(string.length()));
            if (!string.equals("") && string.length() >= 32 && C1484d.m6840b(string) == null) {
                C2538c.m12674b(f3497a, "====getDeviceCodeString==== null == result");
                C1497q.m6957h(context);
            }
        }
    }

    private static void m6950c(Context context, String str, String str2) {
        C2538c.m12674b(f3497a, "====checkKey====");
        if (!str2.equals(C1497q.m6958i(context))) {
            C2538c.m12674b(f3497a, "====checkKey===RootKey is wrong from db====");
            C1497q.m6952d(context);
        } else if (!str.equals(C1497q.m6954e(context))) {
            C2538c.m12674b(f3497a, "====checkKey===RealKey is wrong from db====");
            C1497q.m6952d(context);
        }
    }

    private static void m6952d(Context context) {
        String a = C1484d.m6836a();
        String a2 = C1484d.m6836a();
        C1484d.m6843d(a2);
        C1497q.m6953d(context, a2, C1484d.m6838a(a));
        C2538c.m12674b(f3497a, "====createKey====");
        C1497q.m6950c(context, a, a2);
    }

    private static String m6954e(Context context) {
        C1484d.m6843d(C1497q.m6958i(context));
        String str = "";
        if ("".equals(f3505i)) {
            str = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS");
        } else {
            str = f3505i;
        }
        return C1484d.m6840b(str);
    }

    public static String m6939a(String str, String str2, String str3, String str4) {
        C1484d.m6843d(C1497q.m6938a(str2, str3, str4));
        return C1484d.m6840b(str);
    }

    private static void m6955f(Context context) {
        C2538c.m12674b(f3497a, "====enter checkShareEqualsPropertyKey====");
        String b;
        if ("".equals(C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS"))) {
            b = C1491k.m6899b(context, "KEY_BONE_PARAGRAPH_MARS", "");
            C2538c.m12674b(f3497a, "====isShareNoEqualsProperty K1SharedPreferencesUtil====", " ERK = ", b, ", length = ", Integer.valueOf(b.length()));
            if (!"".equals(b)) {
                String b2 = C1491k.m6899b(context, "KEY_BONE_PARAGRAPH_VENUS", "");
                String b3 = C1491k.m6899b(context, "KEY_BONE_PARAGRAPH_JUPITER", "");
                String b4 = C1491k.m6899b(context, "KEY_BONE_PARAGRAPH_MERCURY", "");
                C2538c.m12674b(f3497a, "====isShareNoEqualsProperty K1SharedPreferencesUtil====", " venus = ", b2, ", length = ", Integer.valueOf(b2.length()));
                C2538c.m12674b(f3497a, "====isShareNoEqualsProperty K1SharedPreferencesUtil====", " jupiter = ", b3, ", length = ", Integer.valueOf(b3.length()));
                C2538c.m12674b(f3497a, "====isShareNoEqualsProperty K1SharedPreferencesUtil====", " mercury = ", b4, ", length = ", Integer.valueOf(b4.length()));
                C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS", b2);
                C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER", b3);
                C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY", a.b(C1480b.m6807a(b4)));
                C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS", b);
                C1497q.m6956g(context);
                return;
            }
            return;
        }
        CharSequence a = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY");
        C2538c.m12674b(f3497a, "====checkShareEqualsPropertyKey====KEY_BONE_PARAGRAPH_NEW_MERCURY... ", " mercury = ", a);
        if (TextUtils.isEmpty(a)) {
            b = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MERCURY");
            C2538c.m12674b(f3497a, "====checkShareEqualsPropertyKey====KEY_BONE_PARAGRAPH_MERCURY... ", " mercury = ", b);
            if (TextUtils.isEmpty(b)) {
                b = C1491k.m6899b(context, "KEY_BONE_PARAGRAPH_MERCURY", "");
                C2538c.m12674b(f3497a, "====checkShareEqualsPropertyKey====K1SharedPreferencesUtil... ", " mercury = ", b);
                if (TextUtils.isEmpty(b)) {
                    C1497q.m6957h(context);
                    return;
                }
                C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY", a.b(C1480b.m6807a(b)));
            } else {
                C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY", a.b(C1480b.m6807a(b)));
            }
            C1497q.m6956g(context);
        }
    }

    private static void m6956g(Context context) {
        String a = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS");
        String a2 = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS");
        String a3 = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER");
        String a4 = C1480b.m6805a(a.c(C1480b.m6807a(C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY"))));
        C2538c.m12674b(f3497a, "====isShareNoEqualsProperty==== DBStorageUtil ", " ERK = ", a, ", length = ", Integer.valueOf(a.length()));
        C2538c.m12674b(f3497a, "====isShareNoEqualsProperty==== DBStorageUtil ", " venus = ", a2, ", length = ", Integer.valueOf(a2.length()));
        C2538c.m12674b(f3497a, "====isShareNoEqualsProperty==== DBStorageUtil ", " jupiter = ", a3, ", length = ", Integer.valueOf(a3.length()));
        C2538c.m12674b(f3497a, "====isShareNoEqualsProperty==== DBStorageUtil ", " mercury = ", a4, ", length = ", Integer.valueOf(a4.length()));
        C1484d.m6843d(C1497q.m6939a(a, a2, a3, a4));
        C1497q.m6940a(context);
    }

    private static void m6957h(Context context) {
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS", "");
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER", "");
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY", a.b(C1480b.m6807a("")));
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS", "");
        C1392h.m6292b(context);
        C1392h.m6276a(context);
        C1392h.m6302c(context);
        C1392h.m6305d(context);
    }

    public static void m6946b(Context context) {
        synchronized (C1497q.class) {
            String str = "";
            str = "";
            if ("".equals(f3505i) || f3500d == null || f3501e == null || f3502f == null) {
                C1497q.m6955f(context);
                str = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS");
                if ("".equals(str)) {
                    str = C1497q.m6951d(context, "sharedpreferences_filename1");
                    String d = C1497q.m6951d(context, "sharedpreferences_filename2");
                    if ("".equals(str) || "".equals(d)) {
                        C1497q.m6952d(context);
                    } else {
                        str = C1497q.m6959j(context);
                        d = C1484d.m6836a();
                        C1484d.m6843d(d);
                        C1497q.m6953d(context, d, C1484d.m6838a(str));
                    }
                } else {
                    f3505i = str;
                    f3500d = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS").toCharArray();
                    f3501e = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER").toCharArray();
                    f3502f = C1480b.m6805a(a.c(C1480b.m6807a(C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY")))).toCharArray();
                }
            }
            str = C1497q.m6954e(context);
            C2538c.m12674b(f3497a, "====setAESKey===RealKey:=" + str);
            C1484d.m6843d(str);
        }
    }

    private static void m6953d(Context context, String str, String str2) {
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = C1484d.m6836a().toCharArray();
        char[] toCharArray3 = C1484d.m6836a().toCharArray();
        char[] cArr = new char[toCharArray.length];
        for (int i = 0; i < toCharArray.length; i++) {
            cArr[i] = (char) ((((toCharArray[i] << 4) ^ toCharArray2[i]) >> 3) ^ (toCharArray3[i] << 2));
        }
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS", String.valueOf(toCharArray2));
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER", String.valueOf(toCharArray3));
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY", a.b(C1480b.m6807a(new String(cArr))));
        C0998f.m3622a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS", str2);
    }

    private static String m6958i(Context context) {
        char[] toCharArray;
        char[] toCharArray2;
        char[] toCharArray3;
        if (f3500d == null || f3501e == null || f3502f == null) {
            String a = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS");
            String a2 = C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER");
            String a3 = C1480b.m6805a(a.c(C1480b.m6807a(C0998f.m3621a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_NEW_MERCURY"))));
            toCharArray = a.toCharArray();
            toCharArray2 = a2.toCharArray();
            toCharArray3 = a3.toCharArray();
        } else {
            toCharArray = f3500d;
            toCharArray2 = f3501e;
            toCharArray3 = f3502f;
        }
        char[] cArr = new char[toCharArray.length];
        for (int i = 0; i < toCharArray.length; i++) {
            cArr[i] = (char) ((((toCharArray3[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray[i]) >> 4);
        }
        return String.valueOf(cArr);
    }

    private static String m6938a(String str, String str2, String str3) {
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = str2.toCharArray();
        char[] toCharArray3 = str3.toCharArray();
        char[] cArr = new char[toCharArray.length];
        for (int i = 0; i < toCharArray.length; i++) {
            cArr[i] = (char) ((((toCharArray3[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray[i]) >> 4);
        }
        return String.valueOf(cArr);
    }

    private static String m6959j(Context context) {
        String d = C1497q.m6951d(context, "sharedpreferences_filename1");
        String d2 = C1497q.m6951d(context, "sharedpreferences_filename2");
        if ("".equals(d) || "".equals(d2)) {
            d = C0999h.m3632d(context);
            d2 = C0999h.m3633e(context);
        }
        char[] toCharArray = context.getSharedPreferences(d2, 4).getString("sharedpreferences_newc3", "").toCharArray();
        char[] toCharArray2 = context.getSharedPreferences(d, 4).getString("sharedpreferences_newctwo", "").toCharArray();
        char[] toCharArray3 = C1497q.m6951d(context, "sharedpreferences_newcone").toCharArray();
        char[] cArr = new char[toCharArray3.length];
        for (int i = 0; i < toCharArray3.length; i++) {
            cArr[i] = (char) ((((toCharArray[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray3[i]) >> 4);
        }
        return String.valueOf(cArr);
    }

    public static long m6936a(Context context, String str) {
        long j;
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            j = f3498b.getLong(str, 0);
        }
        return j;
    }

    public static void m6941a(Context context, String str, long j) {
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            f3499c.putLong(str, j);
            f3499c.commit();
        }
    }

    public static Boolean m6944b(Context context, String str) {
        Boolean valueOf;
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            valueOf = Boolean.valueOf(f3498b.getBoolean(str, false));
        }
        return valueOf;
    }

    public static Boolean m6937a(Context context, String str, boolean z) {
        Boolean valueOf;
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            valueOf = Boolean.valueOf(f3498b.getBoolean(str, z));
        }
        return valueOf;
    }

    public static void m6942a(Context context, String str, Boolean bool) {
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            f3499c.putBoolean(str, bool.booleanValue());
            f3499c.commit();
        }
    }

    public static int m6948c(Context context, String str) {
        int i;
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            i = f3498b.getInt(str, 5);
        }
        return i;
    }

    public static int m6935a(Context context, String str, int i) {
        int i2;
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            i2 = f3498b.getInt(str, i);
        }
        return i2;
    }

    public static void m6947b(Context context, String str, int i) {
        synchronized (C1497q.class) {
            C1497q.m6949c(context);
            f3499c.putInt(str, i);
            f3499c.commit();
        }
    }
}
