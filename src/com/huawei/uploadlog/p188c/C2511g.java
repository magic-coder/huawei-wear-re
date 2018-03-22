package com.huawei.uploadlog.p188c;

import android.util.Log;
import de.p194a.p195a.p196a.p197a.C2684b;
import java.io.File;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* compiled from: LogUtils */
public class C2511g {
    private static final Boolean f8997a = Boolean.valueOf(true);
    private static Logger f8998b;

    public static void m12478a(String str, String str2, String str3) {
        boolean z = true;
        Log.d(str3, "[LogUtils.initLog]start...");
        C2684b c2684b = new C2684b();
        Log.d(str3, "[LogUtils.initLog]step 1111");
        C2511g.m12480a(str);
        Log.d(str3, "[LogUtils.initLog]step 2222");
        c2684b.m12816b(str + File.separator + str2);
        Log.d(str3, "LogFileName:" + c2684b.m12820e());
        c2684b.m12813a(Level.ALL);
        c2684b.m12812a("org.apache", Level.ALL);
        c2684b.m12817b(true);
        c2684b.m12811a("%d %-5p [%c{2}-%L] %m%n");
        c2684b.m12810a(10485760);
        c2684b.m12814a(true);
        try {
            Log.d(str3, "[LogUtils.initLog]step 3333");
            c2684b.m12809a();
        } catch (Exception e) {
            Log.d(str3, "[LogUtils.initLog]config log error!" + e.toString());
        }
        Log.d(str3, "[LogUtils.initLog]step 4444");
        f8998b = Logger.getLogger(str3);
        StringBuilder append = new StringBuilder().append("[LogUtils.initLog]logger is null : ");
        if (f8998b != null) {
            z = false;
        }
        Log.d(str3, append.append(z).toString());
        f8998b.info("LogUtils initLog finish");
    }

    private static boolean m12480a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void m12477a(String str, String str2) {
        if (f8997a.booleanValue()) {
            C2511g.m12476a(0, str, str2, null);
        }
    }

    public static void m12481b(String str, String str2) {
        if (f8997a.booleanValue()) {
            C2511g.m12476a(1, str, str2, null);
        }
    }

    public static void m12483c(String str, String str2) {
        if (f8997a.booleanValue()) {
            C2511g.m12476a(2, str, str2, null);
        }
    }

    public static void m12479a(String str, String str2, Throwable th) {
        if (f8997a.booleanValue()) {
            C2511g.m12476a(3, str, str2, th);
        }
    }

    public static void m12484d(String str, String str2) {
        if (f8997a.booleanValue()) {
            C2511g.m12476a(4, str, str2, null);
        }
    }

    public static void m12482b(String str, String str2, Throwable th) {
        if (f8997a.booleanValue()) {
            C2511g.m12476a(5, str, str2, th);
        }
    }

    private static void m12476a(int i, String str, String str2, Throwable th) {
        if (f8998b == null || !f8997a.booleanValue()) {
            Log.d("CrowdTest", "[LogUtils.log4j]logger is null or log switch is off");
            return;
        }
        String str3 = "[" + str + "] : " + str2;
        switch (i) {
            case 0:
                f8998b.info(str3);
                return;
            case 1:
                f8998b.debug(str3);
                return;
            case 2:
                f8998b.warn(str3);
                return;
            case 3:
                f8998b.warn(str3, th);
                return;
            case 4:
                f8998b.error(str3);
                return;
            case 5:
                f8998b.error(str3, th);
                return;
            default:
                return;
        }
    }
}
