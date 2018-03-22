package com.huawei.hwdatamigrate.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.p190v.C2538c;

/* compiled from: SharedPreferencesUtil */
public class C4804j {
    private static SharedPreferences f17752a;
    private static Editor f17753b;
    private static char[] f17754c = null;
    private static char[] f17755d = null;
    private static char[] f17756e = null;
    private static String f17757f = "";

    private static void m23012b(Context context) {
        synchronized (C4804j.class) {
            f17752a = h.a(f17752a, context);
            f17753b = h.a(f17752a, f17753b, context);
        }
    }

    private static String m23011b(Context context, String str) {
        String string;
        synchronized (C4804j.class) {
            C4804j.m23012b(context);
            string = f17752a.getString(str, "");
        }
        return string;
    }

    private static void m23010a(Context context, String str, String str2) {
        C2538c.b("SHARTUIL", new Object[]{"====checkKey===="});
        if (!str2.equals(C4804j.m23016e(context))) {
            C2538c.b("SHARTUIL", new Object[]{"====checkKey===RootKey is wrong from db===="});
            C4804j.m23014c(context);
        } else if (!str.equals(C4804j.m23015d(context))) {
            C2538c.b("SHARTUIL", new Object[]{"====checkKey===RealKey is wrong from db===="});
            C4804j.m23014c(context);
        }
    }

    private static void m23014c(Context context) {
        String a = C4801c.m22994a();
        String a2 = C4801c.m22994a();
        C4801c.m23000d(a2);
        C4804j.m23013b(context, a2, C4801c.m22995a(a));
        C2538c.b("SHARTUIL", new Object[]{"====createKey===="});
        C4804j.m23010a(context, a, a2);
    }

    public static void m23008a(Context context) {
        synchronized (C4804j.class) {
            String str = "";
            str = "";
            if ("".equals(f17757f) || f17754c == null || f17755d == null || f17756e == null) {
                str = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS");
                if ("".equals(str)) {
                    str = C4804j.m23011b(context, "sharedpreferences_filename1");
                    String b = C4804j.m23011b(context, "sharedpreferences_filename2");
                    if ("".equals(str) || "".equals(b)) {
                        C4804j.m23014c(context);
                    } else {
                        str = C4804j.m23017f(context);
                        b = C4801c.m22994a();
                        C4801c.m23000d(b);
                        C4804j.m23013b(context, b, C4801c.m22995a(str));
                    }
                } else {
                    f17757f = str;
                    f17754c = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS").toCharArray();
                    f17755d = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER").toCharArray();
                    f17756e = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MERCURY").toCharArray();
                }
            }
            C4801c.m23000d(C4804j.m23015d(context));
        }
    }

    private static String m23015d(Context context) {
        C4801c.m23000d(C4804j.m23016e(context));
        String str = "";
        if ("".equals(f17757f)) {
            str = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS");
        } else {
            str = f17757f;
        }
        return C4801c.m22997b(str);
    }

    private static void m23013b(Context context, String str, String str2) {
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = C4801c.m22994a().toCharArray();
        char[] toCharArray3 = C4801c.m22994a().toCharArray();
        char[] cArr = new char[toCharArray.length];
        for (int i = 0; i < toCharArray.length; i++) {
            cArr[i] = (char) ((((toCharArray[i] << 4) ^ toCharArray2[i]) >> 3) ^ (toCharArray3[i] << 2));
        }
        f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS", String.valueOf(toCharArray2));
        f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER", String.valueOf(toCharArray3));
        f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MERCURY", String.valueOf(cArr));
        f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MARS", str2);
    }

    private static String m23016e(Context context) {
        char[] toCharArray;
        char[] toCharArray2;
        char[] toCharArray3;
        if (f17754c == null || f17755d == null || f17756e == null) {
            String a = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_VENUS");
            String a2 = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_JUPITER");
            String a3 = f.a(context.getContentResolver(), "KEY_BONE_PARAGRAPH_MERCURY");
            toCharArray = a.toCharArray();
            toCharArray2 = a2.toCharArray();
            toCharArray3 = a3.toCharArray();
        } else {
            toCharArray = f17754c;
            toCharArray2 = f17755d;
            toCharArray3 = f17756e;
        }
        char[] cArr = new char[toCharArray.length];
        for (int i = 0; i < toCharArray.length; i++) {
            cArr[i] = (char) ((((toCharArray3[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray[i]) >> 4);
        }
        return String.valueOf(cArr);
    }

    private static String m23017f(Context context) {
        String b = C4804j.m23011b(context, "sharedpreferences_filename1");
        String b2 = C4804j.m23011b(context, "sharedpreferences_filename2");
        if ("".equals(b) || "".equals(b2)) {
            b = h.d(context);
            b2 = h.e(context);
        }
        char[] toCharArray = context.getSharedPreferences(b2, 4).getString("sharedpreferences_newc3", "").toCharArray();
        char[] toCharArray2 = context.getSharedPreferences(b, 4).getString("sharedpreferences_newctwo", "").toCharArray();
        char[] toCharArray3 = C4804j.m23011b(context, "sharedpreferences_newcone").toCharArray();
        char[] cArr = new char[toCharArray3.length];
        for (int i = 0; i < toCharArray3.length; i++) {
            cArr[i] = (char) ((((toCharArray[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray3[i]) >> 4);
        }
        return String.valueOf(cArr);
    }

    public static Boolean m23007a(Context context, String str) {
        Boolean valueOf;
        synchronized (C4804j.class) {
            C4804j.m23012b(context);
            valueOf = Boolean.valueOf(f17752a.getBoolean(str, false));
        }
        return valueOf;
    }

    public static void m23009a(Context context, String str, Boolean bool) {
        synchronized (C4804j.class) {
            C4804j.m23012b(context);
            f17753b.putBoolean(str, bool.booleanValue());
            f17753b.commit();
        }
    }
}
