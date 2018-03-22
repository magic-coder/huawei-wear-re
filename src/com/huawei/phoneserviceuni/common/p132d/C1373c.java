package com.huawei.phoneserviceuni.common.p132d;

import android.util.Log;
import com.huawei.phoneserviceuni.common.a;
import com.huawei.phoneserviceuni.common.b;

/* compiled from: LogUtil */
public class C1373c {
    private static boolean f2954a = true;
    private static boolean f2955b = true;
    private static boolean f2956c = true;
    private static boolean f2957d = true;
    private static boolean f2958e = true;

    public static void m6138a(String str, String str2) {
        if (str != null && str2 != null) {
            if (f2958e) {
                Log.v(str, str2);
            }
            b a = a.a.a();
            if (a != null) {
                a.d(str, str2);
            }
        }
    }

    public static void m6139b(String str, String str2) {
        if (str != null && str2 != null) {
            if (f2958e) {
                Log.d(str, str2);
            }
            b a = a.a.a();
            if (a != null) {
                a.a(str, str2);
            }
        }
    }

    public static void m6140c(String str, String str2) {
        if (str != null && str2 != null) {
            if (f2957d) {
                Log.i(str, str2);
            }
            b a = a.a.a();
            if (a != null) {
                a.b(str, str2);
            }
        }
    }

    public static void m6141d(String str, String str2) {
        if (str != null && str2 != null) {
            Log.e(str, str2);
            b a = a.a.a();
            if (a != null) {
                a.c(str, str2);
            }
        }
    }

    public static void m6137a(Exception exception, String str) {
        if (exception != null && exception.getMessage() != null) {
            Log.e(str, exception.getMessage());
        }
    }
}
