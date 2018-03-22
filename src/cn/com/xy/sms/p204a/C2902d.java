package cn.com.xy.sms.p204a;

import cn.com.xy.sms.sdk.p229l.C3037b;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C2902d {
    public static boolean f9874a = false;
    static ExecutorService f9875b = Executors.newFixedThreadPool(1);
    private static long f9876c = 21600000;
    private static long f9877d = 1296000000;

    public static void m13074a(String str, String str2) {
        try {
            if (C3049n.m13653e(str)) {
                C3037b.m13590d(str2);
            }
            C3037b a = C3037b.m13588a(str);
            if (a != null) {
                a.m13591c(str2);
            }
        } catch (Throwable th) {
        }
    }
}
