package com.tencent.mm.sdk.p539b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public final class C6342a {
    private static int level = 6;
    public static C6345d f22081q;
    private static C6341a f22082r;
    private static C6341a f22083s;
    private static final String f22084t;

    public interface C6341a {
        void mo5305e(String str, String str2);

        void mo5306f(String str, String str2);

        void mo5307g(String str, String str2);

        int mo5308h();

        void mo5309h(String str, String str2);
    }

    static {
        C6341a c6343b = new C6343b();
        f22082r = c6343b;
        f22083s = c6343b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
        stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
        stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
        stringBuilder.append("] BOARD:[" + Build.BOARD);
        stringBuilder.append("] DEVICE:[" + Build.DEVICE);
        stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
        stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        stringBuilder.append("] HOST:[" + Build.HOST);
        stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        stringBuilder.append("] MODEL:[" + Build.MODEL);
        stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
        stringBuilder.append("] TAGS:[" + Build.TAGS);
        stringBuilder.append("] TYPE:[" + Build.TYPE);
        stringBuilder.append("] USER:[" + Build.USER + "]");
        f22084t = stringBuilder.toString();
    }

    public static void m29029a(String str, String str2) {
        C6342a.m29030a(str, str2, null);
    }

    public static void m29030a(String str, String str2, Object... objArr) {
        if (f22083s != null && f22083s.mo5308h() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String i = C6342a.m29035i(str);
            C6341a c6341a = f22083s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6341a.mo5309h(i, format);
        }
    }

    public static void m29031b(String str, String str2) {
        if (f22083s != null && f22083s.mo5308h() <= 3) {
            if (str2 == null) {
                str2 = "";
            }
            String i = C6342a.m29035i(str);
            C6341a c6341a = f22083s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6341a.mo5307g(i, str2);
        }
    }

    public static void m29032c(String str, String str2) {
        if (f22083s != null && f22083s.mo5308h() <= 2) {
            if (str2 == null) {
                str2 = "";
            }
            String i = C6342a.m29035i(str);
            C6341a c6341a = f22083s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6341a.mo5305e(i, str2);
        }
    }

    public static void m29033d(String str, String str2) {
        if (f22083s != null && f22083s.mo5308h() <= 1) {
            if (str2 == null) {
                str2 = "";
            }
            String i = C6342a.m29035i(str);
            C6341a c6341a = f22083s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6341a.mo5306f(i, str2);
        }
    }

    private static String m29035i(String str) {
        return f22081q != null ? f22081q.m29042i(str) : str;
    }
}
