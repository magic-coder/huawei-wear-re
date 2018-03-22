package cn.com.xy.sms.p204a;

import android.content.Context;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p215g.C2982a;

public class C2906g {
    public static String m13077a(Context context, String str) {
        return C2947n.m13284d(context, str);
    }

    public static boolean m13078a(Context context, String str, String str2) {
        return C2906g.m13079a(context, str, str2, null);
    }

    public static boolean m13079a(Context context, String str, String str2, String str3) {
        try {
            if (C2947n.m13272a(context, str, str2, str3) > 0) {
                C2947n.f10009a.put(str, str2);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "setParamValue: " + th.getMessage(), th);
        }
        return false;
    }
}
