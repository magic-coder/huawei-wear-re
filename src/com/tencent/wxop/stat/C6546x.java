package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p546a.C6497b;
import com.tencent.wxop.stat.p546a.C6500f;
import com.tencent.wxop.stat.p546a.C6503i;
import com.tencent.wxop.stat.p547b.C6507b;
import com.tencent.wxop.stat.p547b.C6511f;
import com.tencent.wxop.stat.p547b.C6517l;
import com.tencent.wxop.stat.p547b.C6522q;
import com.unionpay.tsmservice.data.Constant;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class C6546x {
    static volatile int f22840a = 0;
    static volatile long f22841b = 0;
    static volatile long f22842c = 0;
    private static C6511f f22843d;
    private static volatile Map<C6497b, Long> f22844e = new ConcurrentHashMap();
    private static volatile Map<String, Properties> f22845f = new ConcurrentHashMap();
    private static volatile Map<Integer, Integer> f22846g = new ConcurrentHashMap(10);
    private static volatile long f22847h = 0;
    private static volatile long f22848i = 0;
    private static volatile long f22849j = 0;
    private static String f22850k = "";
    private static volatile int f22851l = 0;
    private static volatile String f22852m = "";
    private static volatile String f22853n = "";
    private static Map<String, Long> f22854o = new ConcurrentHashMap();
    private static Map<String, Long> f22855p = new ConcurrentHashMap();
    private static C6507b f22856q = C6517l.m29740c();
    private static UncaughtExceptionHandler f22857r = null;
    private static volatile boolean f22858s = true;
    private static Context f22859t = null;

    static int m29858a(Context context, boolean z, C6547y c6547y) {
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = z && currentTimeMillis - f22848i >= ((long) C6544v.m29834d());
        f22848i = currentTimeMillis;
        if (f22849j == 0) {
            f22849j = C6517l.m29743d();
        }
        if (currentTimeMillis >= f22849j) {
            f22849j = C6517l.m29743d();
            if (am.m29668a(context).m29697b(context).m29715d() != 1) {
                am.m29668a(context).m29697b(context).m29714c();
            }
            C6544v.m29853t();
            f22840a = 0;
            f22850k = C6517l.m29745e();
            z3 = true;
        }
        Object obj = f22850k;
        if (C6517l.m29735a(c6547y)) {
            obj = c6547y.m29894c() + f22850k;
        }
        if (f22855p.containsKey(obj)) {
            z2 = z3;
        }
        if (z2) {
            if (C6517l.m29735a(c6547y)) {
                C6546x.m29863a(context, c6547y);
            } else if (C6544v.m29854u() < C6544v.m29851r()) {
                C6517l.m29767u(context);
                C6546x.m29863a(context, null);
            } else {
                f22856q.m29708e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            f22855p.put(obj, Long.valueOf(1));
        }
        if (f22858s) {
            if (C6544v.m29833c()) {
                Context g = C6546x.m29882g(context);
                if (g == null) {
                    f22856q.m29707d("The Context of StatService.testSpeed() can not be null!");
                } else if (C6546x.m29886i(g) != null) {
                    f22843d.m29719a(new ab(g));
                }
            }
            f22858s = false;
        }
        return f22851l;
    }

    public static Properties m29861a(String str) {
        return (Properties) f22845f.get(str);
    }

    public static void m29862a(Context context) {
        if (C6544v.m29833c() && C6546x.m29886i(context) != null) {
            f22843d.m29719a(new ae(context));
        }
    }

    private static void m29863a(Context context, C6547y c6547y) {
        if (C6546x.m29886i(context) != null) {
            if (C6544v.m29830b()) {
                f22856q.m29710g("start new session.");
            }
            if (c6547y == null || f22851l == 0) {
                f22851l = C6517l.m29727a();
            }
            C6544v.m29850q();
            C6544v.m29852s();
            new ai(new C6503i(context, f22851l, C6546x.m29890l(), c6547y)).m29659a();
        }
    }

    public static void m29864a(Context context, String str) {
        if (C6544v.m29833c()) {
            Context g = C6546x.m29882g(context);
            if (g == null) {
                f22856q.m29707d("The Context of StatService.trackCustomEvent() can not be null!");
                return;
            }
            Object obj = (str == null || str.length() == 0) ? 1 : null;
            if (obj != null) {
                f22856q.m29707d("The event_id of StatService.trackCustomEvent() can not be null or empty.");
                return;
            }
            C6497b c6497b = new C6497b(str);
            if (C6546x.m29886i(g) != null) {
                f22843d.m29719a(new C6541s(g, c6497b));
            }
        }
    }

    public static void m29865a(Context context, String str, C6547y c6547y) {
        if (C6544v.m29833c()) {
            Context g = C6546x.m29882g(context);
            if (g == null || str == null || str.length() == 0) {
                f22856q.m29707d("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (C6546x.m29886i(g) != null) {
                f22843d.m29719a(new C6542t(str2, g, c6547y));
            }
        }
    }

    static void m29866a(Context context, Throwable th) {
        if (C6544v.m29833c()) {
            Context g = C6546x.m29882g(context);
            if (g == null) {
                f22856q.m29707d("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (C6546x.m29886i(g) != null) {
                f22843d.m29719a(new C6539q(g, th));
            }
        }
    }

    static boolean m29867a() {
        if (f22840a < 2) {
            return false;
        }
        f22841b = System.currentTimeMillis();
        return true;
    }

    public static boolean m29868a(Context context, String str, String str2) {
        try {
            if (C6544v.m29833c()) {
                String str3 = "2.0.3";
                if (C6544v.m29830b()) {
                    f22856q.m29710g("MTA SDK version, current: " + str3 + " ,required: " + str2);
                }
                if (context == null || str2 == null) {
                    f22856q.m29707d("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                    C6544v.m29825a(false);
                    return false;
                } else if (C6517l.m29738b(str3) < C6517l.m29738b(str2)) {
                    f22856q.m29707d(("MTA SDK version conflicted, current: " + str3 + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                    C6544v.m29825a(false);
                    return false;
                } else {
                    str3 = C6544v.m29827b(context);
                    if (str3 == null || str3.length() == 0) {
                        C6544v.m29829b("-");
                    }
                    if (str != null) {
                        C6544v.m29821a(context, str);
                    }
                    if (C6546x.m29886i(context) != null) {
                        f22843d.m29719a(new af(context));
                    }
                    return true;
                }
            }
            f22856q.m29707d("MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            f22856q.m29705b(th);
            return false;
        }
    }

    static void m29870b() {
        f22840a = 0;
        f22841b = 0;
    }

    public static void m29871b(Context context) {
        if (C6544v.m29833c() && C6546x.m29886i(context) != null) {
            f22843d.m29719a(new C6538p(context));
        }
    }

    public static void m29872b(Context context, String str, C6547y c6547y) {
        if (C6544v.m29833c()) {
            Context g = C6546x.m29882g(context);
            if (g == null || str == null || str.length() == 0) {
                f22856q.m29707d("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (C6546x.m29886i(g) != null) {
                f22843d.m29719a(new ad(g, str2, c6547y));
            }
        }
    }

    static void m29874c() {
        f22840a++;
        f22841b = System.currentTimeMillis();
        C6546x.m29879e(f22859t);
    }

    static void m29875c(Context context) {
        if (C6544v.m29833c()) {
            Context g = C6546x.m29882g(context);
            if (g == null) {
                f22856q.m29707d("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                C6534l.m29803b(g).m29804a(new C6500f(g), new C6540r());
            } catch (Throwable th) {
                f22856q.m29705b(th);
            }
        }
    }

    public static void m29877d(Context context) {
        if (C6544v.m29833c()) {
            if (C6544v.m29830b()) {
                f22856q.m29702a((Object) "commitEvents, maxNumber=-1");
            }
            Context g = C6546x.m29882g(context);
            if (g == null) {
                f22856q.m29707d("The Context of StatService.commitEvents() can not be null!");
            } else if (C6548z.m29898a(f22859t).m29908f() && C6546x.m29886i(g) != null) {
                f22843d.m29719a(new aa(g));
            }
        }
    }

    public static void m29879e(Context context) {
        if (C6544v.m29833c() && C6544v.f22818n > 0) {
            Context g = C6546x.m29882g(context);
            if (g == null) {
                f22856q.m29707d("The Context of StatService.testSpeed() can not be null!");
            } else {
                am.m29668a(g).m29699c();
            }
        }
    }

    static void m29881f(Context context) {
        f22842c = System.currentTimeMillis() + ((long) (60000 * C6544v.m29845l()));
        C6522q.m29780a(context, "last_period_ts", f22842c);
        C6546x.m29877d(context);
    }

    private static Context m29882g(Context context) {
        return context != null ? context : f22859t;
    }

    private static synchronized void m29885h(Context context) {
        boolean z = false;
        synchronized (C6546x.class) {
            if (context != null) {
                if (f22843d == null) {
                    long a = C6522q.m29777a(context, C6544v.f22807c);
                    long b = C6517l.m29738b("2.0.3");
                    boolean z2 = true;
                    if (b <= a) {
                        f22856q.m29707d("MTA is disable for current version:" + b + ",wakeup version:" + a);
                        z2 = false;
                    }
                    a = C6522q.m29777a(context, C6544v.f22808d);
                    if (a > System.currentTimeMillis()) {
                        f22856q.m29707d("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + a);
                    } else {
                        z = z2;
                    }
                    C6544v.m29825a(z);
                    if (z) {
                        Context applicationContext = context.getApplicationContext();
                        f22859t = applicationContext;
                        f22843d = new C6511f();
                        f22850k = C6517l.m29745e();
                        f22847h = System.currentTimeMillis() + C6544v.f22813i;
                        f22843d.m29719a(new C6537o(applicationContext));
                    }
                }
            }
        }
    }

    private static C6511f m29886i(Context context) {
        if (f22843d == null) {
            synchronized (C6546x.class) {
                if (f22843d == null) {
                    try {
                        C6546x.m29885h(context);
                    } catch (Throwable th) {
                        f22856q.m29703a(th);
                        C6544v.m29825a(false);
                    }
                }
            }
        }
        return f22843d;
    }

    private static JSONObject m29890l() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (C6544v.f22806b.f22757d != 0) {
                jSONObject2.put(Constant.KEY_VERSION, C6544v.f22806b.f22757d);
            }
            jSONObject.put(Integer.toString(C6544v.f22806b.f22754a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (C6544v.f22805a.f22757d != 0) {
                jSONObject2.put(Constant.KEY_VERSION, C6544v.f22805a.f22757d);
            }
            jSONObject.put(Integer.toString(C6544v.f22805a.f22754a), jSONObject2);
        } catch (Throwable e) {
            f22856q.m29705b(e);
        }
        return jSONObject;
    }
}
