package com.huawei.openalliance.ad.utils.p129b;

import com.huawei.openalliance.ad.utils.p129b.C1338e.C1337a;
import java.io.File;

public abstract class C1336d {
    private static C1338e f2885a = null;

    public static void m5882a(String str, C1339f c1339f, String str2) {
        C1338e.m5898a(str + File.separator + str2 + ".log");
        C1338e.m5897a(c1339f);
        f2885a = new C1337a(str2).m5893a(true).m5894a();
    }

    public static void m5883a(String str, String str2, Throwable th) {
        if (C1336d.m5889c()) {
            f2885a.m5907c(str, str2);
        }
    }

    public static void m5884a(String str, String... strArr) {
        if (C1336d.m5885a() && strArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : strArr) {
                stringBuffer.append(append);
            }
            f2885a.m5904a(str, stringBuffer.toString());
        }
    }

    public static boolean m5885a() {
        return C1336d.m5892e() && f2885a.m5908c(C1339f.DEBUG);
    }

    public static void m5886b(String str, String... strArr) {
        if (C1336d.m5887b() && strArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : strArr) {
                stringBuffer.append(append);
            }
            f2885a.m5906b(str, stringBuffer.toString());
        }
    }

    public static boolean m5887b() {
        return C1336d.m5892e() && f2885a.m5908c(C1339f.INFO);
    }

    public static void m5888c(String str, String... strArr) {
        if (C1336d.m5889c() && strArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : strArr) {
                stringBuffer.append(append);
            }
            f2885a.m5907c(str, stringBuffer.toString());
        }
    }

    public static boolean m5889c() {
        return C1336d.m5892e() && f2885a.m5908c(C1339f.WARN);
    }

    public static void m5890d(String str, String... strArr) {
        if (C1336d.m5891d() && strArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : strArr) {
                stringBuffer.append(append);
            }
            f2885a.m5909d(str, stringBuffer.toString());
        }
    }

    public static boolean m5891d() {
        return C1336d.m5892e() && f2885a.m5908c(C1339f.ERROR);
    }

    private static boolean m5892e() {
        return f2885a != null;
    }
}
