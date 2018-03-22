package com.p004c.p005a.p010c;

import android.content.Context;
import android.os.Handler;
import com.p004c.p005a.p008b.p009a.C0313a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class C0316a {
    private static ScheduledExecutorService f158a = Executors.newScheduledThreadPool(1);
    private static boolean f159b = false;
    private static int f160c = 0;

    public static void m154a(Context context) {
        if (context == null) {
            C0313a.m146h();
            return;
        }
        Handler g = C0313a.m145g();
        if (g != null) {
            g.post(new C0320e(context, 0, System.currentTimeMillis()));
        }
        C0313a.m146h();
    }

    public static void m155a(Context context, String str, String str2) {
        if (context == null) {
            C0313a.m146h();
        } else if (str == null || str.equals("")) {
            C0313a.m146h();
        } else if (str2 == null || str2.equals("")) {
            C0313a.m146h();
        } else {
            Handler g = C0313a.m145g();
            if (g != null) {
                g.post(new C0317b(context, str, str2, System.currentTimeMillis()));
            }
            C0313a.m146h();
        }
    }

    public static void m156a(Long l) {
        if (l.longValue() >= 24) {
            C0313a.m131a(Long.valueOf((l.longValue() * 60) * 60));
        }
    }

    public static void m157b(Context context) {
        if (context == null) {
            C0313a.m146h();
            return;
        }
        Handler g = C0313a.m145g();
        if (g != null) {
            g.post(new C0320e(context, 1, System.currentTimeMillis()));
        }
        C0313a.m146h();
    }

    public static void m158c(Context context) {
        if (context == null) {
            C0313a.m146h();
            return;
        }
        Handler g = C0313a.m145g();
        if (g != null) {
            g.post(new C0320e(context, 2, System.currentTimeMillis()));
        }
        C0313a.m146h();
    }
}
