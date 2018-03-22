package com.tencent.stat;

import android.content.Context;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6463m;
import com.tencent.stat.p545b.C6468r;
import com.unionpay.tsmservice.data.Constant;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

public class C6470c {
    private static boolean f22448A = false;
    private static int f22449B = 4096;
    private static boolean f22450C = false;
    private static String f22451D = null;
    static C6476i f22452a = new C6476i(2);
    static C6476i f22453b = new C6476i(1);
    static String f22454c = "__HIBERNATE__";
    static String f22455d = "";
    public static boolean f22456e = true;
    private static C6452b f22457f = C6463m.m29449b();
    private static C6473f f22458g = C6473f.APP_LAUNCH;
    private static boolean f22459h = true;
    private static int f22460i = 30000;
    private static int f22461j = 1024;
    private static int f22462k = 30;
    private static int f22463l = 3;
    private static int f22464m = 30;
    private static String f22465n = null;
    private static String f22466o;
    private static String f22467p;
    private static int f22468q = 1440;
    private static int f22469r = 1024;
    private static boolean f22470s = true;
    private static long f22471t = 0;
    private static long f22472u = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
    private static String f22473v = "http://pingma.qq.com:80/mstat/report";
    private static int f22474w = 0;
    private static volatile int f22475x = 0;
    private static int f22476y = 20;
    private static int f22477z = 0;

    public static C6473f m29503a() {
        return f22458g;
    }

    public static synchronized String m29504a(Context context) {
        String str;
        synchronized (C6470c.class) {
            if (f22466o != null) {
                str = f22466o;
            } else {
                if (context != null) {
                    if (f22466o == null) {
                        f22466o = C6463m.m29467i(context);
                    }
                }
                if (f22466o == null || f22466o.trim().length() == 0) {
                    f22457f.m29410e("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = f22466o;
            }
        }
        return str;
    }

    static String m29505a(String str, String str2) {
        try {
            String string = f22453b.f22513b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f22457f.m29409d(th);
            return str2;
        }
    }

    static synchronized void m29506a(int i) {
        synchronized (C6470c.class) {
            f22475x = i;
        }
    }

    public static void m29507a(C6473f c6473f) {
        f22458g = c6473f;
        f22457f.m29413h("Change to statSendStrategy: " + c6473f);
    }

    static void m29508a(C6476i c6476i) {
        if (c6476i.f22512a == f22453b.f22512a) {
            f22453b = c6476i;
            C6470c.m29514b(f22453b.f22513b);
        } else if (c6476i.f22512a == f22452a.f22512a) {
            f22452a = c6476i;
        }
    }

    static void m29509a(C6476i c6476i, JSONObject jSONObject) {
        Object obj = null;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                Object obj2;
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Constant.KEY_VERSION)) {
                    int i = jSONObject.getInt(str);
                    obj2 = c6476i.f22515d != i ? 1 : obj;
                    c6476i.f22515d = i;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        c6476i.f22513b = new JSONObject(str);
                    }
                    obj2 = obj;
                } else {
                    if (str.equalsIgnoreCase("m")) {
                        c6476i.f22514c = jSONObject.getString("m");
                    }
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj == 1) {
                C6487u a = C6487u.m29594a(C6477k.m29578a());
                if (a != null) {
                    a.m29615a(c6476i);
                }
                if (c6476i.f22512a == f22453b.f22512a) {
                    C6470c.m29514b(c6476i.f22513b);
                    C6470c.m29518c(c6476i.f22513b);
                }
            }
        } catch (Exception e) {
            f22457f.m29406b(e);
        } catch (Throwable th) {
            f22457f.m29411f(th);
        }
    }

    static void m29510a(JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(f22453b.f22512a))) {
                    C6470c.m29509a(f22453b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(f22452a.f22512a))) {
                    C6470c.m29509a(f22452a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    C6473f a = C6473f.m29550a(jSONObject.getInt(str));
                    if (a != null) {
                        f22458g = a;
                        f22457f.m29413h("Change to ReportStrategy:" + a.name());
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            f22457f.m29406b(e);
        }
    }

    public static void m29511a(boolean z) {
        f22459h = z;
        if (!z) {
            f22457f.m29408c("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static synchronized String m29512b(Context context) {
        String str;
        synchronized (C6470c.class) {
            if (f22467p != null) {
                str = f22467p;
            } else {
                f22467p = C6463m.m29468j(context);
                if (f22467p == null || f22467p.trim().length() == 0) {
                    f22457f.m29409d("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = f22467p;
            }
        }
        return str;
    }

    static void m29513b(int i) {
        if (i >= 0) {
            f22477z = i;
        }
    }

    static void m29514b(JSONObject jSONObject) {
        try {
            C6473f a = C6473f.m29550a(jSONObject.getInt("rs"));
            if (a != null) {
                C6470c.m29507a(a);
            }
        } catch (JSONException e) {
            f22457f.m29413h("rs not found.");
        }
    }

    public static boolean m29515b() {
        return f22459h;
    }

    public static int m29516c() {
        return f22460i;
    }

    public static String m29517c(Context context) {
        if (context == null) {
            f22457f.m29410e("Context for getCustomUid is null.");
            return null;
        }
        if (f22451D == null) {
            f22451D = C6468r.m29493a(context, "MTA_CUSTOM_UID", "");
        }
        return f22451D;
    }

    static void m29518c(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(f22454c);
            f22457f.m29413h("hibernateVer:" + string + ", current version:" + "1.6.2");
            long b = C6463m.m29448b(string);
            if (C6463m.m29448b("1.6.2") <= b) {
                C6468r.m29495b(C6477k.m29578a(), f22454c, b);
                C6470c.m29511a(false);
                f22457f.m29408c("MTA has disable for SDK version of " + string + " or lower.");
            }
        } catch (JSONException e) {
            f22457f.m29413h("__HIBERNATE__ not found.");
        }
    }

    public static int m29519d() {
        return f22464m;
    }

    public static String m29520d(Context context) {
        return C6471d.m29542a(context);
    }

    public static int m29521e() {
        return f22463l;
    }

    public static C6449a m29522e(Context context) {
        return C6471d.m29544b(context);
    }

    static int m29523f() {
        return f22462k;
    }

    public static int m29524g() {
        return f22461j;
    }

    static HttpHost m29525h() {
        if (f22465n == null || f22465n.length() <= 0) {
            return null;
        }
        String str = f22465n;
        String[] split = str.split(":");
        int i = 80;
        if (split.length == 2) {
            str = split[0];
            i = Integer.parseInt(split[1]);
        }
        return new HttpHost(str, i);
    }

    public static int m29526i() {
        return f22468q;
    }

    public static int m29527j() {
        return f22469r;
    }

    public static boolean m29528k() {
        return f22470s;
    }

    public static boolean m29529l() {
        return f22456e;
    }

    public static String m29530m() {
        return f22473v;
    }

    public static int m29531n() {
        return f22474w;
    }

    public static int m29532o() {
        return f22475x;
    }

    static synchronized void m29533p() {
        synchronized (C6470c.class) {
            f22475x++;
        }
    }

    public static int m29534q() {
        return f22476y;
    }

    static void m29535r() {
        f22477z++;
    }

    static int m29536s() {
        return f22477z;
    }

    public static int m29537t() {
        return f22449B;
    }

    public static boolean m29538u() {
        return f22450C;
    }
}
