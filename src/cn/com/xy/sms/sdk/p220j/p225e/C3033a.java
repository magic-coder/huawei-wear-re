package cn.com.xy.sms.sdk.p220j.p225e;

import cn.com.xy.sms.sdk.p213e.C2973a;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C3033a {
    public static ExecutorService f10252a = Executors.newFixedThreadPool(1);
    private static boolean f10253b = false;

    public static String m13579a(String str, String str2, String str3, String str4, Map<String, String> map) {
        String a = C2973a.m13355a(str3, null);
        C3033a.m13580a(new C3034b(a));
        return a;
    }

    public static void m13580a(Runnable runnable) {
        f10252a.execute(runnable);
    }
}
