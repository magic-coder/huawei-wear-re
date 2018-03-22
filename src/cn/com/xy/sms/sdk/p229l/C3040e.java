package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C3040e {
    public static long m13602a(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "getTime: " + e.getMessage(), e);
            return 0;
        }
    }

    public static String m13603a(String str) {
        String str2 = "";
        try {
            str2 = new SimpleDateFormat(str).format(new Date(System.currentTimeMillis()));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getCurrentTimeString: " + th.getMessage(), th);
        }
        return str2;
    }

    public static String m13604a(String str, long j) {
        String str2 = "";
        try {
            str2 = new SimpleDateFormat(str).format(new Date(j));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getTimeString: " + th.getMessage(), th);
        }
        return str2;
    }

    public static String m13605a(String str, String str2, int i) {
        return C3040e.m13604a(str2, C3040e.m13602a(str, str2) + (86400000 * ((long) i)));
    }

    public static boolean m13606a(String str, String str2, String str3) {
        return C3040e.m13602a(str, str3) > C3040e.m13602a(str2, str3);
    }
}
