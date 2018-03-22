package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;

public final class ad {
    private static int f10261a = 0;

    public static String m13585a() {
        if (f10261a == 0) {
            String d = C2947n.m13284d(C2917a.m13105a(), "RECORD_FUNCTION_STATE");
            if (d != null) {
                f10261a = Integer.parseInt(d);
            }
        }
        return String.valueOf(f10261a);
    }

    public static void m13586a(int i) {
        int i2 = 0;
        String d = C2947n.m13284d(C2917a.m13105a(), "RECORD_FUNCTION_STATE");
        if (d != null) {
            i2 = Integer.parseInt(d);
        }
        int i3 = i2 | i;
        f10261a = i3;
        if (i3 != i2) {
            C2947n.m13274a("RECORD_FUNCTION_STATE", String.valueOf(i3));
        }
    }
}
