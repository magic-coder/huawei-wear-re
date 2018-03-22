package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.tencent.p527a.p528a.p529a.p530a.C6242g;
import com.tencent.wxop.stat.p547b.C6507b;
import com.tencent.wxop.stat.p547b.C6517l;
import com.tencent.wxop.stat.p547b.C6522q;
import com.tencent.wxop.stat.p547b.C6523r;
import com.unionpay.tsmservice.data.Constant;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class C6544v {
    private static int f22785A = 1;
    private static String f22786B = null;
    private static String f22787C;
    private static String f22788D;
    private static String f22789E = "mta_channel";
    private static int f22790F = 180;
    private static int f22791G = 1024;
    private static long f22792H = 0;
    private static long f22793I = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
    private static volatile String f22794J = "http://pingma.qq.com:80/mstat/report";
    private static int f22795K = 0;
    private static volatile int f22796L = 0;
    private static int f22797M = 20;
    private static int f22798N = 0;
    private static boolean f22799O = false;
    private static int f22800P = 4096;
    private static boolean f22801Q = false;
    private static String f22802R = null;
    private static boolean f22803S = false;
    private static C6533j f22804T = null;
    static C6532i f22805a = new C6532i(2);
    static C6532i f22806b = new C6532i(1);
    static String f22807c = "__HIBERNATE__";
    static String f22808d = "__HIBERNATE__TIME";
    static String f22809e = "__MTA_KILL__";
    static String f22810f = "";
    static boolean f22811g = false;
    static int f22812h = 100;
    static long f22813i = 10000;
    static boolean f22814j = true;
    public static boolean f22815k = true;
    static volatile String f22816l = "pingma.qq.com:80";
    static boolean f22817m = true;
    static int f22818n = 0;
    static long f22819o = 10000;
    static int f22820p = 512;
    private static C6507b f22821q = C6517l.m29740c();
    private static C6545w f22822r = C6545w.APP_LAUNCH;
    private static boolean f22823s = false;
    private static boolean f22824t = true;
    private static int f22825u = 30000;
    private static int f22826v = 100000;
    private static int f22827w = 30;
    private static int f22828x = 10;
    private static int f22829y = 100;
    private static int f22830z = 30;

    public static C6545w m29815a() {
        return f22822r;
    }

    public static synchronized String m29816a(Context context) {
        String str;
        synchronized (C6544v.class) {
            if (f22787C != null) {
                str = f22787C;
            } else {
                if (context != null) {
                    if (f22787C == null) {
                        f22787C = C6517l.m29748f(context);
                    }
                }
                if (f22787C == null || f22787C.trim().length() == 0) {
                    f22821q.m29707d("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = f22787C;
            }
        }
        return str;
    }

    static String m29817a(String str) {
        try {
            String string = f22806b.f22755b.getString(str);
            if (string != null) {
                return string;
            }
        } catch (Throwable th) {
            f22821q.m29706c("can't find custom key:" + str);
        }
        return null;
    }

    private static void m29818a(long j) {
        C6522q.m29780a(C6534l.m29801a(), f22807c, j);
        C6544v.m29825a(false);
        f22821q.m29704b((Object) "MTA is disable for current SDK version");
    }

    static void m29819a(Context context, C6532i c6532i) {
        if (c6532i.f22754a == f22806b.f22754a) {
            f22806b = c6532i;
            C6544v.m29824a(c6532i.f22755b);
            if (!f22806b.f22755b.isNull("iplist")) {
                C6548z.m29898a(context).m29903a(f22806b.f22755b.getString("iplist"));
            }
        } else if (c6532i.f22754a == f22805a.f22754a) {
            f22805a = c6532i;
        }
    }

    private static void m29820a(Context context, C6532i c6532i, JSONObject jSONObject) {
        try {
            String str;
            Object obj;
            Iterator keys = jSONObject.keys();
            Object obj2 = null;
            while (keys.hasNext()) {
                str = (String) keys.next();
                if (str.equalsIgnoreCase(Constant.KEY_VERSION)) {
                    int i = jSONObject.getInt(str);
                    obj = c6532i.f22757d != i ? 1 : obj2;
                    c6532i.f22757d = i;
                    obj2 = obj;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        c6532i.f22755b = new JSONObject(str);
                    }
                } else {
                    try {
                        if (str.equalsIgnoreCase("m")) {
                            c6532i.f22756c = jSONObject.getString("m");
                        }
                    } catch (JSONException e) {
                        f22821q.m29710g("__HIBERNATE__ not found.");
                    } catch (Throwable th) {
                        f22821q.m29705b(th);
                    }
                }
            }
            if (obj2 == 1) {
                am a = am.m29668a(C6534l.m29801a());
                if (a != null) {
                    a.m29695a(c6532i);
                }
                if (c6532i.f22754a == f22806b.f22754a) {
                    C6544v.m29824a(c6532i.f22755b);
                    JSONObject jSONObject2 = c6532i.f22755b;
                    if (!(jSONObject2 == null || jSONObject2.length() == 0)) {
                        Context a2 = C6534l.m29801a();
                        try {
                            str = jSONObject2.optString(f22809e);
                            if (C6517l.m29742c(str)) {
                                JSONObject jSONObject3 = new JSONObject(str);
                                if (jSONObject3.length() != 0) {
                                    if (!jSONObject3.isNull("sm")) {
                                        obj = jSONObject3.get("sm");
                                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                                        if (intValue > 0) {
                                            if (f22823s) {
                                                f22821q.m29702a("match sleepTime:" + intValue + " minutes");
                                            }
                                            C6522q.m29780a(a2, f22808d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                                            C6544v.m29825a(false);
                                            f22821q.m29704b((Object) "MTA is disable for current SDK version");
                                        }
                                    }
                                    if (C6544v.m29826a(jSONObject3, "sv", "2.0.3")) {
                                        f22821q.m29702a((Object) "match sdk version:2.0.3");
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (C6544v.m29826a(jSONObject3, "md", Build.MODEL)) {
                                        f22821q.m29702a("match MODEL:" + Build.MODEL);
                                        obj = 1;
                                    }
                                    if (C6544v.m29826a(jSONObject3, "av", C6517l.m29756j(a2))) {
                                        f22821q.m29702a("match app version:" + C6517l.m29756j(a2));
                                        obj = 1;
                                    }
                                    if (C6544v.m29826a(jSONObject3, "mf", Build.MANUFACTURER)) {
                                        f22821q.m29702a("match MANUFACTURER:" + Build.MANUFACTURER);
                                        obj = 1;
                                    }
                                    if (C6544v.m29826a(jSONObject3, "osv", VERSION.SDK_INT)) {
                                        f22821q.m29702a("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (C6544v.m29826a(jSONObject3, "ov", VERSION.SDK_INT)) {
                                        f22821q.m29702a("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (C6544v.m29826a(jSONObject3, "ui", am.m29668a(a2).m29697b(a2).m29712a())) {
                                        f22821q.m29702a("match imei:" + am.m29668a(a2).m29697b(a2).m29712a());
                                        obj = 1;
                                    }
                                    if (C6544v.m29826a(jSONObject3, "mid", C6544v.m29838e(a2))) {
                                        f22821q.m29702a("match mid:" + C6544v.m29838e(a2));
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        C6544v.m29818a(C6517l.m29738b("2.0.3"));
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            f22821q.m29705b(th2);
                        }
                        str = jSONObject2.getString(f22807c);
                        if (f22823s) {
                            f22821q.m29710g("hibernateVer:" + str + ", current version:2.0.3");
                        }
                        long b = C6517l.m29738b(str);
                        if (C6517l.m29738b("2.0.3") <= b) {
                            C6544v.m29818a(b);
                        }
                    }
                }
            }
            C6544v.m29819a(context, c6532i);
        } catch (Throwable th22) {
            f22821q.m29705b(th22);
        } catch (Throwable th222) {
            f22821q.m29705b(th222);
        }
    }

    public static void m29821a(Context context, String str) {
        if (context == null) {
            f22821q.m29707d("ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            f22821q.m29707d("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (f22787C == null) {
                f22787C = C6523r.m29784a(C6522q.m29779a(context, "_mta_ky_tag_", null));
            }
            if ((C6544v.m29836d(str) | C6544v.m29836d(C6517l.m29748f(context))) != 0) {
                String str2 = f22787C;
                if (str2 != null) {
                    C6522q.m29782b(context, "_mta_ky_tag_", C6523r.m29788b(str2));
                }
            }
        }
    }

    static void m29822a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(f22806b.f22754a))) {
                    C6544v.m29820a(context, f22806b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(f22805a.f22754a))) {
                    C6544v.m29820a(context, f22805a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    C6545w a = C6545w.m29857a(jSONObject.getInt(str));
                    if (a != null) {
                        f22822r = a;
                        if (f22823s) {
                            f22821q.m29710g("Change to ReportStrategy:" + a.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            f22821q.m29705b(e);
        }
    }

    public static void m29823a(C6545w c6545w) {
        f22822r = c6545w;
        if (c6545w != C6545w.PERIOD) {
            C6546x.f22842c = 0;
        }
        if (f22823s) {
            f22821q.m29710g("Change to statSendStrategy: " + c6545w);
        }
    }

    private static void m29824a(JSONObject jSONObject) {
        try {
            C6545w a = C6545w.m29857a(jSONObject.getInt("rs"));
            if (a != null) {
                C6544v.m29823a(a);
            }
        } catch (JSONException e) {
            if (f22823s) {
                f22821q.m29702a((Object) "rs not found.");
            }
        }
    }

    public static void m29825a(boolean z) {
        f22824t = z;
        if (!z) {
            f22821q.m29704b((Object) "!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    private static boolean m29826a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (C6517l.m29742c(str2) && C6517l.m29742c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized String m29827b(Context context) {
        String str;
        synchronized (C6544v.class) {
            if (f22788D != null) {
                str = f22788D;
            } else {
                str = C6522q.m29779a(context, f22789E, "");
                f22788D = str;
                if (str == null || f22788D.trim().length() == 0) {
                    f22788D = C6517l.m29749g(context);
                }
                if (f22788D == null || f22788D.trim().length() == 0) {
                    f22821q.m29706c("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = f22788D;
            }
        }
        return str;
    }

    public static void m29828b(Context context, String str) {
        if (str.length() > 128) {
            f22821q.m29707d("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        f22788D = str;
        C6522q.m29782b(context, f22789E, str);
    }

    public static void m29829b(String str) {
        if (str.length() > 128) {
            f22821q.m29707d("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f22788D = str;
        }
    }

    public static boolean m29830b() {
        return f22823s;
    }

    public static String m29831c(Context context) {
        return C6522q.m29779a(context, "mta.acc.qq", f22810f);
    }

    public static void m29832c(String str) {
        if (str == null || str.length() == 0) {
            f22821q.m29707d("statReportUrl cannot be null or empty.");
            return;
        }
        f22794J = str;
        try {
            f22816l = new URI(f22794J).getHost();
        } catch (Exception e) {
            f22821q.m29706c(e);
        }
        if (f22823s) {
            f22821q.m29702a("url:" + f22794J + ", domain:" + f22816l);
        }
    }

    public static boolean m29833c() {
        return f22824t;
    }

    public static int m29834d() {
        return f22825u;
    }

    public static String m29835d(Context context) {
        if (context == null) {
            f22821q.m29707d("Context for getCustomUid is null.");
            return null;
        }
        if (f22802R == null) {
            f22802R = C6522q.m29779a(context, "MTA_CUSTOM_UID", "");
        }
        return f22802R;
    }

    private static boolean m29836d(String str) {
        if (str == null) {
            return false;
        }
        if (f22787C == null) {
            f22787C = str;
            return true;
        } else if (f22787C.contains(str)) {
            return false;
        } else {
            f22787C += "|" + str;
            return true;
        }
    }

    public static int m29837e() {
        return f22829y;
    }

    public static String m29838e(Context context) {
        return context != null ? C6242g.m28686a(context).m28687a().m28678a() : "0";
    }

    public static int m29839f() {
        return f22830z;
    }

    public static int m29840g() {
        return f22828x;
    }

    public static int m29841h() {
        return f22785A;
    }

    static int m29842i() {
        return f22827w;
    }

    public static int m29843j() {
        return f22826v;
    }

    public static void m29844k() {
        f22790F = 60;
    }

    public static int m29845l() {
        return f22790F;
    }

    public static int m29846m() {
        return f22791G;
    }

    public static void m29847n() {
        f22814j = true;
    }

    public static boolean m29848o() {
        return f22815k;
    }

    public static String m29849p() {
        return f22794J;
    }

    static synchronized void m29850q() {
        synchronized (C6544v.class) {
            f22796L = 0;
        }
    }

    public static int m29851r() {
        return f22797M;
    }

    static void m29852s() {
        f22798N++;
    }

    static void m29853t() {
        f22798N = 0;
    }

    static int m29854u() {
        return f22798N;
    }

    public static boolean m29855v() {
        return f22801Q;
    }

    public static C6533j m29856w() {
        return f22804T;
    }
}
