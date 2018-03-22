package cn.com.xy.sms.p204a;

import cn.com.xy.sms.sdk.p216h.C2997c;
import java.util.Random;

public final class C2909j {
    private static String f9887a = null;
    private static char[] f9888b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static short f9889c = (short) 20;
    private static String f9890d = null;

    public static String m13080a() {
        try {
            String a = C2997c.m13508a(false);
            return (a == null || "".equals(a.trim())) ? System.nanoTime() + String.valueOf(new Random().nextInt(1000000000)) : new StringBuilder(String.valueOf(a)).append(System.nanoTime()).append(String.valueOf(new Random().nextInt(1000000000))).toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
