package cn.com.xy.sms.sdk.p216h;

import android.util.LruCache;
import cn.com.xy.sms.p204a.C2905f;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2942i;
import cn.com.xy.sms.sdk.p208d.p211c.C2943j;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p229l.C3046k;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C2996a {
    public static String f10129a = ("http://scene" + ((int) ((Math.random() * 10.0d) + WeightedLatLng.DEFAULT_INTENSITY)) + ".bizport.cn:8981/statservice/stat/");
    public static String f10130b = ("http://pubserver" + ((int) ((Math.random() * 10.0d) + WeightedLatLng.DEFAULT_INTENSITY)) + ".bizport.cn:9998/pubNumService/");
    public static String f10131c = ("http://smssdk" + ((int) ((Math.random() * 10.0d) + WeightedLatLng.DEFAULT_INTENSITY)) + ".bizport.cn/popupservice/api/");
    public static String f10132d = "http://down1.bizport.cn";
    public static String f10133e = ("https://pubapi" + ((int) ((Math.random() * 10.0d) + WeightedLatLng.DEFAULT_INTENSITY)) + ".bizport.cn:9443/pubNumService/");
    public static String f10134f = ("https://sdkapi" + ((int) ((Math.random() * 10.0d) + WeightedLatLng.DEFAULT_INTENSITY)) + ".bizport.cn:8943/popupservice/");
    public static String f10135g = ("http://olapi" + ((int) ((Math.random() * 10.0d) + WeightedLatLng.DEFAULT_INTENSITY)) + ".bizport.cn/");
    public static String f10136h = "201607121714";
    public static ExecutorService f10137i = Executors.newFixedThreadPool(1);
    private static int f10138j = 0;
    private static final Object f10139k = new Object();
    private static String f10140l = null;
    private static final LruCache<String, Long> f10141m = new LruCache(500);
    private static long f10142n = 0;
    private static int f10143o = 0;

    public static String m13481a(String str) {
        return str;
    }

    public static void m13482a(int i, int i2, String str, C2904g c2904g, String str2, boolean z) {
        Runnable c3005j = new C3005j(i2, str2, str, c2904g, true);
        if (z) {
            C2996a.m13484a(c3005j);
        } else {
            c3005j.run();
        }
    }

    public static void m13483a(int i, String str, C2904g c2904g, String str2, Map<String, String> map, boolean z) {
        Runnable c3005j = new C3005j(-1, str2, str, c2904g, true);
        if (z) {
            C2996a.m13484a(c3005j);
        } else {
            c3005j.run();
        }
    }

    public static void m13484a(Runnable runnable) {
        f10137i.execute(runnable);
    }

    public static void m13485a(String str, String str2, long j, boolean z, boolean z2, boolean z3, HashMap<String, String> hashMap, String str3, C2905f c2905f, C2905f c2905f2) {
        C2996a.m13506f(hashMap);
        String f = C2996a.m13505f();
        if (C3049n.m13653e(f) || f.equals(str3) || !C2996a.m13493a(str2, j)) {
            C3050o.m13670a((C2904g) c2905f2, Integer.valueOf(-10), "server error");
            return;
        }
        try {
            C2996a.m13490a(str, str2, (C2904g) c2905f, z, z2, z3, (Map) hashMap);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "OperatorService requestNewTokenAndPostRequestAgain error: " + th.getMessage(), th);
            C3050o.m13670a((C2904g) c2905f2, Integer.valueOf(-10), "error:" + th.getMessage());
        }
    }

    public static void m13486a(String str, String str2, C2904g c2904g, String str3, Map<String, String> map) {
        C2996a.m13484a(new C3006k(str3, str2, null, "990005", false, c2904g, Boolean.valueOf(true)));
    }

    public static void m13487a(String str, String str2, C2904g c2904g, String str3, boolean z) {
        C2996a.m13484a(new C2997c(str3, null, str, false, str2, c2904g, z));
    }

    public static void m13488a(String str, String str2, C2904g c2904g, String str3, boolean z, boolean z2, String str4, boolean z3) {
        String d = C2947n.m13284d(C2917a.m13105a(), "CUSTOM_PUBLIC_SERVER_URL");
        if (str4 == null) {
            str4 = "";
        }
        Runnable c3006k = new C3006k(C3049n.m13653e(d) ? C2996a.m13501d() + str4 + "/" : new StringBuilder(String.valueOf(d)).append(str4).append("/").toString(), str, "", str2, z2, c2904g, Boolean.valueOf(z3));
        if (z) {
            C2996a.m13484a(c3006k);
        } else {
            c3006k.run();
        }
    }

    public static void m13489a(String str, String str2, C2904g c2904g, boolean z, boolean z2, String str3, boolean z3) {
        if (C2996a.m13491a()) {
            String d = C2947n.m13284d(C2917a.m13105a(), "CUSTOM_PUBLIC_SERVER_URL");
            if (str3 == null) {
                str3 = "";
            }
            Runnable c3006k = new C3006k(C3049n.m13653e(d) ? C2996a.m13501d() + str3 + "/" : new StringBuilder(String.valueOf(d)).append(str3).append("/").toString(), str, "", str2, z2, c2904g, Boolean.valueOf(z3));
            if (z) {
                C2996a.m13484a(c3006k);
            } else {
                c3006k.run();
            }
        }
    }

    public static void m13490a(String str, String str2, C2904g c2904g, boolean z, boolean z2, boolean z3, Map<String, String> map) {
        String d = C2947n.m13284d(C2917a.m13105a(), "CUSTOM_PUBINFO_SERVER_URL");
        if (str == null) {
            str = "";
        }
        Runnable c2998b = new C2998b(C3049n.m13653e(d) ? C2996a.m13503e() + str : new StringBuilder(String.valueOf(d)).append(str).toString(), str2, c2904g, z2, z3, map);
        if (z) {
            C2996a.m13484a(c2998b);
        } else {
            c2998b.run();
        }
    }

    public static boolean m13491a() {
        boolean a = C2947n.m13281a(C2917a.m13105a(), "smartsms_enhance", true);
        return ("VMhlWdEwVNEW_LENOVO".equals(C3046k.f10294a) && a) ? C2996a.m13492a(2) : ("1w36SBLwVNEW_ZTE".equals(C3046k.f10294a) && a) ? C2996a.m13492a(2) : a;
    }

    public static boolean m13492a(int i) {
        int c = C2947n.m13283c(C2917a.m13105a(), "SUPPORT_NETWORK_TYPE");
        if (c == 0) {
            return false;
        }
        c = i == 2 ? c == 2 ? C3050o.m13664a(C2917a.m13105a(), 2) : C3050o.m13664a(C2917a.m13105a(), 1) : C3050o.m13664a(C2917a.m13105a(), 1);
        return c == 0;
    }

    public static boolean m13493a(String str, long j) {
        synchronized (f10141m) {
            Long l = (Long) f10141m.get(str);
            if (l == null || l.longValue() + j < System.currentTimeMillis()) {
                f10141m.put(str, Long.valueOf(System.currentTimeMillis()));
                return true;
            }
            return false;
        }
    }

    public static boolean m13494a(Map<String, String> map) {
        try {
            int a = C3050o.m13663a(C2917a.m13105a());
            if (a == -1) {
                return false;
            }
            new StringBuilder("extend=").append(map);
            if (map == null || map.isEmpty()) {
                return C2996a.m13492a(2);
            }
            String str = (String) map.get("SUPPORT_NETWORK_TYPE");
            int intValue = !C3049n.m13653e(str) ? Integer.valueOf(str).intValue() : 1;
            if (intValue == 0 || (a == 1 && intValue == 1)) {
                C2982a.m13415a("HTTP", "不支持网络连,或只支持wifi: type: " + intValue + " netType=" + a, null);
                return false;
            }
            return true;
        } catch (Throwable th) {
        }
    }

    public static void m13495b(String str) {
        if (C3049n.m13653e(C2947n.m13284d(C2917a.m13105a(), "HTTPTOKEN"))) {
            if (C3049n.m13653e(str)) {
                C2942i a = C2943j.m13258a(C2917a.m13105a());
                if (a != null) {
                    str = a.f9980b;
                }
            }
            C2996a.m13499c(str);
        }
    }

    public static void m13496b(Map<String, String> map) {
        if (C3049n.m13653e(C2996a.m13505f())) {
            C2996a.m13504e(map);
        }
    }

    public static boolean m13497b() {
        if (f10138j != 0) {
            return f10138j == 1;
        } else {
            try {
                C3046k.m13626a();
                String[] strArr = new String[]{"3GdfMSKwHUAWEI", "5Mj22a4wHUAWEICARD", "J8KeTyOROASamsungReminder", "SAMBANKVwIDAQAB", "SAMCLASSFIYVwIDAQAB", "5xKI47wSAMALL", "XYTEST"};
                for (int i = 0; i < 7; i++) {
                    if (strArr[i].equals(C3046k.f10294a)) {
                        f10138j = 1;
                        return true;
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "isUseHttps: " + th.getMessage(), th);
            }
            f10138j = 2;
            return false;
        }
    }

    public static String m13498c() {
        return C2996a.m13497b() ? f10134f : f10131c;
    }

    public static void m13499c(String str) {
        try {
            C2904g c3003h = new C3003h();
            String a = C2991i.m13444a(str);
            if (!C3049n.m13653e(a)) {
                C2996a.m13489a(a, "990005", c3003h, false, true, SNBConstant.FIELD_TOKEN, false);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "QueryNewTokenRequest: " + th.getMessage(), th);
        }
    }

    public static boolean m13500c(Map<String, String> map) {
        C2996a.m13496b((Map) map);
        return !C3049n.m13653e(C2996a.m13505f());
    }

    public static String m13501d() {
        return C2996a.m13497b() ? f10133e : f10130b;
    }

    public static void m13502d(Map<String, String> map) {
        C2996a.m13504e(map);
    }

    public static String m13503e() {
        return f10135g;
    }

    public static void m13504e(Map<String, String> map) {
        try {
            C2904g c3004i = new C3004i();
            String a = C2991i.m13443a();
            if (!C3049n.m13653e(a)) {
                C2996a.m13490a(SNBConstant.FIELD_TOKEN, a, c3004i, false, true, false, (Map) map);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "QueryTokenRequest: " + th.getMessage(), th);
        }
    }

    public static String m13505f() {
        return C2947n.m13284d(C2917a.m13105a(), "NEWHTTPTOKEN");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m13506f(java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
        r1 = 1;
        r0 = 0;
        r2 = cn.com.xy.sms.sdk.p216h.C2996a.m13507g();
        if (r2 == 0) goto L_0x0011;
    L_0x0008:
        r1 = "XIAOYUAN";
        r2 = "NetUtil syncRequestNewToken error:repeat request token";
        r3 = 0;
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r3);
    L_0x0010:
        return r0;
    L_0x0011:
        r2 = f10139k;	 Catch:{ Throwable -> 0x0052 }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x0052 }
        r3 = cn.com.xy.sms.sdk.p216h.C2996a.m13507g();	 Catch:{ all -> 0x004f }
        if (r3 == 0) goto L_0x001d;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x004f }
        r0 = r1;
        goto L_0x0010;
    L_0x001d:
        r3 = cn.com.xy.sms.sdk.p216h.C2996a.m13505f();	 Catch:{ all -> 0x004f }
        cn.com.xy.sms.sdk.p216h.C2996a.m13504e(r6);	 Catch:{ all -> 0x004f }
        r4 = cn.com.xy.sms.sdk.p216h.C2996a.m13505f();	 Catch:{ all -> 0x004f }
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r4);	 Catch:{ all -> 0x004f }
        if (r5 != 0) goto L_0x004d;
    L_0x002e:
        r3 = r4.equals(r3);	 Catch:{ all -> 0x004f }
        if (r3 != 0) goto L_0x004d;
    L_0x0034:
        r3 = f10143o;	 Catch:{ all -> 0x004f }
        r3 = r3 + 1;
        f10143o = r3;	 Catch:{ all -> 0x004f }
        if (r1 != 0) goto L_0x0041;
    L_0x003c:
        r3 = f10143o;	 Catch:{ all -> 0x004f }
        r4 = 3;
        if (r3 < r4) goto L_0x004a;
    L_0x0041:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x004f }
        f10142n = r4;	 Catch:{ all -> 0x004f }
        r3 = 0;
        f10143o = r3;	 Catch:{ all -> 0x004f }
    L_0x004a:
        monitor-exit(r2);	 Catch:{ all -> 0x004f }
        r0 = r1;
        goto L_0x0010;
    L_0x004d:
        r1 = r0;
        goto L_0x0034;
    L_0x004f:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ Throwable -> 0x0052 }
        throw r1;	 Catch:{ Throwable -> 0x0052 }
    L_0x0052:
        r1 = move-exception;
        r2 = "XIAOYUAN";
        r3 = new java.lang.StringBuilder;
        r4 = "NetUtil syncRequestNewToken error:";
        r3.<init>(r4);
        r4 = r1.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r1);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.h.a.f(java.util.Map):boolean");
    }

    private static boolean m13507g() {
        return f10142n + LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME > System.currentTimeMillis();
    }
}
