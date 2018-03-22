package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.p544a.C6443b;
import com.tencent.stat.p544a.C6444a;
import com.tencent.stat.p544a.C6447e;
import com.tencent.stat.p544a.C6448f;
import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6458h;
import com.tencent.stat.p545b.C6463m;
import com.tencent.stat.p545b.C6468r;
import com.unionpay.tsmservice.data.Constant;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class C6474g {
    private static Handler f22495a;
    private static volatile Map<Object, Long> f22496b = new ConcurrentHashMap();
    private static volatile long f22497c = 0;
    private static volatile long f22498d = 0;
    private static volatile int f22499e = 0;
    private static volatile String f22500f = "";
    private static volatile String f22501g = "";
    private static Map<String, Long> f22502h = new ConcurrentHashMap();
    private static C6452b f22503i = C6463m.m29449b();
    private static UncaughtExceptionHandler f22504j = null;
    private static volatile boolean f22505k = true;

    static int m29552a(Context context, boolean z) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z || currentTimeMillis - f22497c < ((long) C6470c.m29516c())) {
            boolean z2 = false;
        } else {
            int i2 = 1;
        }
        f22497c = currentTimeMillis;
        if (f22498d == 0) {
            f22498d = C6463m.m29452c();
        }
        if (currentTimeMillis >= f22498d) {
            f22498d = C6463m.m29452c();
            if (C6487u.m29594a(context).m29618b(context).m29394g() != 1) {
                C6487u.m29594a(context).m29618b(context).m29385b(1);
            }
            C6470c.m29513b(0);
            C6471d.m29545c(context);
            i2 = 1;
        }
        if (!f22505k) {
            i = i2;
        }
        if (i != 0) {
            if (C6470c.m29536s() < C6470c.m29534q()) {
                C6463m.m29438F(context);
                C6474g.m29562d(context);
            } else {
                f22503i.m29411f("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (f22505k) {
            C6458h.m29426b(context);
            C6474g.m29566h(context);
            C6474g.m29565g(context);
            f22505k = false;
        }
        return f22499e;
    }

    static JSONObject m29553a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (C6470c.f22453b.f22515d != 0) {
                jSONObject2.put(Constant.KEY_VERSION, C6470c.f22453b.f22515d);
            }
            jSONObject.put(Integer.toString(C6470c.f22453b.f22512a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (C6470c.f22452a.f22515d != 0) {
                jSONObject2.put(Constant.KEY_VERSION, C6470c.f22452a.f22515d);
            }
            jSONObject.put(Integer.toString(C6470c.f22452a.f22512a), jSONObject2);
        } catch (Exception e) {
            f22503i.m29406b(e);
        }
        return jSONObject;
    }

    static synchronized void m29554a(Context context) {
        synchronized (C6474g.class) {
            if (context != null) {
                if (f22495a == null && C6474g.m29559b(context)) {
                    if (C6458h.m29425a(context)) {
                        HandlerThread handlerThread = new HandlerThread("StatService");
                        handlerThread.start();
                        f22495a = new Handler(handlerThread.getLooper());
                        C6487u.m29594a(context);
                        C6477k.m29579a(context);
                        C6477k.m29580b();
                        C6470c.m29522e(context);
                        f22504j = Thread.getDefaultUncaughtExceptionHandler();
                        if (C6470c.m29529l()) {
                            Thread.setDefaultUncaughtExceptionHandler(new C6480n(context.getApplicationContext()));
                        } else {
                            f22503i.m29408c("MTA SDK AutoExceptionCaught is disable");
                        }
                        if (C6470c.m29503a() == C6473f.APP_LAUNCH && C6463m.m29465h(context)) {
                            C6487u.m29594a(context).m29613a(-1);
                        }
                        f22503i.m29413h("Init MTA StatService success.");
                    } else {
                        f22503i.m29411f("ooh, Compatibility problem was found in this device!");
                        f22503i.m29411f("If you are on debug mode, please delete apk and try again.");
                        C6470c.m29511a(false);
                    }
                }
            }
        }
    }

    public static void m29555a(Context context, String str) {
        if (!C6470c.m29515b()) {
            return;
        }
        if (context == null || str == null || str.length() == 0) {
            f22503i.m29410e("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            return;
        }
        try {
            synchronized (f22502h) {
                if (f22502h.size() >= C6470c.m29527j()) {
                    f22503i.m29410e("The number of page events exceeds the maximum value " + Integer.toString(C6470c.m29527j()));
                    return;
                }
                f22500f = str;
                if (f22502h.containsKey(f22500f)) {
                    f22503i.m29411f("Duplicate PageID : " + f22500f + ", onResume() repeated?");
                    return;
                }
                f22502h.put(f22500f, Long.valueOf(System.currentTimeMillis()));
                C6474g.m29552a(context, true);
            }
        } catch (Throwable th) {
            f22503i.m29411f(th);
            C6474g.m29556a(context, th);
        }
    }

    static void m29556a(Context context, Throwable th) {
        try {
            if (!C6470c.m29515b()) {
                return;
            }
            if (context == null) {
                f22503i.m29410e("The Context of StatService.reportSdkSelfException() can not be null!");
                return;
            }
            C6443b c6444a = new C6444a(context, C6474g.m29552a(context, false), 99, th);
            if (C6474g.m29560c(context) != null) {
                C6474g.m29560c(context).post(new C6484r(c6444a));
            }
        } catch (Throwable th2) {
            f22503i.m29411f("reportSdkSelfException error: " + th2);
        }
    }

    public static void m29558b(Context context, String str) {
        if (!C6470c.m29515b()) {
            return;
        }
        if (context == null || str == null || str.length() == 0) {
            f22503i.m29410e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            return;
        }
        try {
            Long l;
            synchronized (f22502h) {
                l = (Long) f22502h.remove(str);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String str2 = f22501g;
                if (str2 != null && str2.equals(str)) {
                    str2 = "-";
                }
                if (C6474g.m29560c(context) != null) {
                    C6443b c6447e = new C6447e(context, str2, str, C6474g.m29552a(context, false), valueOf);
                    if (!str.equals(f22500f)) {
                        f22503i.m29408c("Invalid invocation since previous onResume on diff page.");
                    }
                    C6474g.m29560c(context).post(new C6484r(c6447e));
                }
                f22501g = str;
                return;
            }
            f22503i.m29411f("Starttime for PageID:" + str + " not found, lost onResume()?");
        } catch (Throwable th) {
            f22503i.m29411f(th);
            C6474g.m29556a(context, th);
        }
    }

    static boolean m29559b(Context context) {
        if (C6463m.m29448b("1.6.2") > C6468r.m29491a(context, C6470c.f22454c, 0)) {
            return true;
        }
        C6470c.m29511a(false);
        return false;
    }

    static Handler m29560c(Context context) {
        if (f22495a == null) {
            C6474g.m29554a(context);
        }
        return f22495a;
    }

    static void m29562d(Context context) {
        if (C6474g.m29560c(context) != null) {
            f22503i.m29413h("start new session.");
            f22499e = C6463m.m29440a();
            C6470c.m29506a(0);
            C6470c.m29535r();
            C6474g.m29560c(context).post(new C6484r(new C6448f(context, f22499e, C6474g.m29553a())));
        }
    }

    public static void m29563e(Context context) {
        if (!C6470c.m29515b()) {
            return;
        }
        if (context == null) {
            f22503i.m29410e("The Context of StatService.onResume() can not be null!");
        } else {
            C6474g.m29555a(context, C6463m.m29469k(context));
        }
    }

    public static void m29564f(Context context) {
        if (!C6470c.m29515b()) {
            return;
        }
        if (context == null) {
            f22503i.m29410e("The Context of StatService.onPause() can not be null!");
        } else {
            C6474g.m29558b(context, C6463m.m29469k(context));
        }
    }

    static void m29565g(Context context) {
        if (!C6470c.m29515b()) {
            return;
        }
        if (context == null) {
            f22503i.m29410e("The Context of StatService.reportNativeCrash() can not be null!");
            return;
        }
        try {
            if (C6474g.m29560c(context) != null) {
                C6474g.m29560c(context).post(new C6482p(context));
            }
        } catch (Throwable th) {
            f22503i.m29411f(th);
            C6474g.m29556a(context, th);
        }
    }

    public static void m29566h(Context context) {
        if (!C6470c.m29515b()) {
            return;
        }
        if (context == null) {
            f22503i.m29410e("The Context of StatService.testSpeed() can not be null!");
            return;
        }
        try {
            if (C6474g.m29560c(context) != null) {
                C6474g.m29560c(context).post(new C6483q(context, null));
            }
        } catch (Throwable th) {
            f22503i.m29411f(th);
            C6474g.m29556a(context, th);
        }
    }
}
