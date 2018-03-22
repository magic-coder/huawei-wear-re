package com.huawei.p030d.p031a;

import android.os.Build;
import com.huawei.p190v.C2538c;
import java.lang.reflect.InvocationTargetException;

/* compiled from: TimeStampListenerUtil */
public class C0800a {
    public static final String f1231a = C0800a.class.getSimpleName();

    public static boolean m2682a() {
        String str = Build.MANUFACTURER;
        String a = C0800a.m2681a("ro.build.version.emui", "");
        C2538c.m12677c(f1231a, "manufacturer is " + str);
        C2538c.m12677c(f1231a, "os version is " + a);
        if ("HUAWEI".equalsIgnoreCase(str) || a.startsWith("EmotionUI")) {
            return false;
        }
        return true;
    }

    public static String m2681a(String str, String str2) {
        ReflectiveOperationException e;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, "unknown"});
        } catch (ClassNotFoundException e2) {
            e = e2;
        } catch (NoSuchMethodException e3) {
            e = e3;
        } catch (IllegalAccessException e4) {
            e = e4;
        } catch (InvocationTargetException e5) {
            e = e5;
        }
        C2538c.m12680e(e.getMessage(), new Object[0]);
        return str2;
    }
}
