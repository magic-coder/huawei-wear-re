package com.tencent.connect.p531a;

import android.content.Context;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p532d.C6403p;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class C6244a {
    private static Class<?> f21714a = null;
    private static Class<?> f21715b = null;
    private static Method f21716c = null;
    private static Method f21717d = null;
    private static Method f21718e = null;
    private static Method f21719f = null;
    private static boolean f21720g = false;

    public static boolean m28699a(Context context, C6284w c6284w) {
        return C6403p.m29203a(context, c6284w.m28849b()).m29213b("Common_ta_enable");
    }

    public static void m28700b(Context context, C6284w c6284w) {
        try {
            if (C6244a.m28699a(context, c6284w)) {
                f21719f.invoke(f21714a, new Object[]{Boolean.valueOf(true)});
                return;
            }
            f21719f.invoke(f21714a, new Object[]{Boolean.valueOf(false)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m28701c(Context context, C6284w c6284w) {
        String str = "Aqc" + c6284w.m28849b();
        try {
            f21714a = Class.forName("com.tencent.stat.c");
            f21715b = Class.forName("com.tencent.stat.g");
            f21716c = f21715b.getMethod("reportQQ", new Class[]{Context.class, String.class});
            f21717d = f21715b.getMethod("trackCustomEvent", new Class[]{Context.class, String.class, String[].class});
            f21718e = f21715b.getMethod("commitEvents", new Class[]{Context.class, Integer.TYPE});
            f21719f = f21714a.getMethod("setEnableStatService", new Class[]{Boolean.TYPE});
            C6244a.m28700b(context, c6284w);
            f21714a.getMethod("setAutoExceptionCaught", new Class[]{Boolean.TYPE}).invoke(f21714a, new Object[]{Boolean.valueOf(false)});
            f21714a.getMethod("setEnableSmartReporting", new Class[]{Boolean.TYPE}).invoke(f21714a, new Object[]{Boolean.valueOf(true)});
            f21714a.getMethod("setSendPeriodMinutes", new Class[]{Integer.TYPE}).invoke(f21714a, new Object[]{Integer.valueOf(1440)});
            Class cls = Class.forName("com.tencent.stat.f");
            f21714a.getMethod("setStatSendStrategy", new Class[]{cls}).invoke(f21714a, new Object[]{cls.getField("PERIOD").get(null)});
            f21715b.getMethod("startStatService", new Class[]{Context.class, String.class, String.class}).invoke(f21715b, new Object[]{context, str, Class.forName("com.tencent.stat.b.a").getField("VERSION").get(null)});
            f21720g = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m28702d(Context context, C6284w c6284w) {
        if (f21720g) {
            C6244a.m28700b(context, c6284w);
            if (c6284w.m28852d() != null) {
                try {
                    f21716c.invoke(f21715b, new Object[]{context, c6284w.m28852d()});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void m28698a(Context context, C6284w c6284w, String str, String... strArr) {
        if (f21720g) {
            C6244a.m28700b(context, c6284w);
            try {
                f21717d.invoke(f21715b, new Object[]{context, str, strArr});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
