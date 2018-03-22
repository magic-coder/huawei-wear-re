package com.tencent.stat.p545b;

import android.content.Context;

public class C6458h {
    static long f22411a = -1;

    static long m29423a(Context context, String str) {
        return C6468r.m29491a(context, str, f22411a);
    }

    static void m29424a(Context context, String str, long j) {
        C6468r.m29495b(context, str, j);
    }

    public static synchronized boolean m29425a(Context context) {
        boolean z;
        synchronized (C6458h.class) {
            long a = C6458h.m29423a(context, "1.6.2_begin_protection");
            long a2 = C6458h.m29423a(context, "1.6.2_end__protection");
            if (a <= 0 || a2 != f22411a) {
                if (a == f22411a) {
                    C6458h.m29424a(context, "1.6.2_begin_protection", System.currentTimeMillis());
                }
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void m29426b(Context context) {
        synchronized (C6458h.class) {
            if (C6458h.m29423a(context, "1.6.2_end__protection") == f22411a) {
                C6458h.m29424a(context, "1.6.2_end__protection", System.currentTimeMillis());
            }
        }
    }
}
