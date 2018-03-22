package com.huawei.pluginkidwatch.common.entity;

import android.content.Context;
import com.huawei.pluginkidwatch.common.entity.model.PositioningFrequency;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.common.p138a.C1388d;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: KWCache */
public class C1462f {
    private static boolean f3364A = false;
    private static boolean f3365B = false;
    private static Map<String, String> f3366C = new HashMap();
    private static int f3367D = 0;
    private static int f3368E = 1;
    private static boolean f3369F = false;
    private static Map<String, String> f3370G = new HashMap();
    private static Map<String, String> f3371H = new HashMap();
    public static String f3372a = "";
    public static String f3373b = "watch_status_of_last";
    public static boolean f3374c = false;
    public static String f3375d = "";
    private static String f3376e = "default value";
    private static String f3377f = "default value";
    private static String f3378g = "";
    private static String f3379h = "";
    private static String f3380i = "default value";
    private static boolean f3381j = false;
    private static boolean f3382k = false;
    private static boolean f3383l = false;
    private static String f3384m = "";
    private static String f3385n = "";
    private static Context f3386o;
    private static C1388d f3387p = null;
    private static List<UserInfo> f3388q = new ArrayList();
    private static boolean f3389r = false;
    private static List<PositioningFrequency> f3390s = null;
    private static String f3391t = "";
    private static String f3392u = "";
    private static String f3393v = "";
    private static String f3394w = "";
    private static boolean f3395x = false;
    private static String f3396y = "";
    private static C1395k f3397z;

    public static boolean m6723a() {
        return f3383l;
    }

    public static void m6722a(boolean z) {
        f3383l = z;
    }

    public static void m6716a(Context context) {
        f3386o = context;
    }

    public static Context m6724b() {
        return f3386o;
    }

    public static void m6721a(List<UserInfo> list) {
        f3388q.clear();
        f3388q.addAll(list);
    }

    public static List<UserInfo> m6728c() {
        return f3388q;
    }

    public static boolean m6733d() {
        return ((Boolean) C1489i.m6887a(Boolean.valueOf(f3395x))).booleanValue();
    }

    public static void m6727b(boolean z) {
        f3395x = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }

    public static int m6734e() {
        return f3367D;
    }

    public static void m6737f() {
        f3367D++;
    }

    public static void m6741g() {
        f3367D--;
        if (f3367D < 0) {
            f3367D = 0;
        }
    }

    public static void m6719a(String str) {
        f3376e = (String) C1489i.m6887a(str);
    }

    public static String m6742h() {
        return f3377f;
    }

    public static void m6725b(String str) {
        f3377f = str;
    }

    public static String m6744i() {
        return (String) C1489i.m6887a(f3378g);
    }

    public static void m6729c(String str) {
        f3378g = (String) C1489i.m6887a(str);
    }

    public static String m6746j() {
        return (String) C1489i.m6887a(f3379h);
    }

    public static void m6731d(String str) {
        f3379h = (String) C1489i.m6887a(str);
    }

    public static C1395k m6748k() {
        return (C1395k) C1489i.m6887a(f3397z);
    }

    public static void m6718a(C1395k c1395k) {
        f3397z = (C1395k) C1489i.m6887a(c1395k);
    }

    public static String m6750l() {
        return (String) C1489i.m6887a(f3396y);
    }

    public static void m6735e(String str) {
        f3396y = (String) C1489i.m6887a(str);
    }

    public static boolean m6753m() {
        return ((Boolean) C1489i.m6887a(Boolean.valueOf(f3364A))).booleanValue();
    }

    public static void m6730c(boolean z) {
        f3364A = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }

    public static void m6732d(boolean z) {
        f3381j = z;
    }

    public static boolean m6754n() {
        return f3389r;
    }

    public static void m6736e(boolean z) {
        f3389r = z;
    }

    public static boolean m6755o() {
        return f3365B;
    }

    public static void m6738f(String str) {
        f3380i = str;
    }

    public static String m6756p() {
        return f3380i;
    }

    public static void m6720a(String str, String str2) {
        if (f3366C != null) {
            f3366C.put(str, str2);
        }
    }

    public static String m6740g(String str) {
        String str2 = "";
        if (f3366C == null || !f3366C.containsKey(str)) {
            return str2;
        }
        return (String) f3366C.get(str);
    }

    public static void m6757q() {
        if (f3366C != null) {
            f3366C.clear();
        }
    }

    public static String m6758r() {
        return (String) C1489i.m6887a(f3385n);
    }

    public static void m6743h(String str) {
        f3385n = (String) C1489i.m6887a(str);
    }

    public static List<PositioningFrequency> m6759s() {
        return (List) C1489i.m6887a(f3390s);
    }

    public static void m6726b(List<PositioningFrequency> list) {
        f3390s = (List) C1489i.m6887a(list);
    }

    public static int m6760t() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(f3368E))).intValue();
    }

    public static void m6715a(int i) {
        f3368E = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public static String m6761u() {
        return (String) C1489i.m6887a(f3391t);
    }

    public static void m6745i(String str) {
        f3391t = (String) C1489i.m6887a(str);
    }

    public static String m6762v() {
        return (String) C1489i.m6887a(f3392u);
    }

    public static void m6747j(String str) {
        f3392u = (String) C1489i.m6887a(str);
    }

    public static String m6763w() {
        return (String) C1489i.m6887a(f3393v);
    }

    public static void m6749k(String str) {
        f3393v = (String) C1489i.m6887a(str);
    }

    public static String m6764x() {
        return (String) C1489i.m6887a(f3394w);
    }

    public static void m6751l(String str) {
        f3394w = (String) C1489i.m6887a(str);
    }

    public static String m6765y() {
        return f3384m;
    }

    public static void m6752m(String str) {
        f3384m = str;
    }

    public static C1388d m6766z() {
        return f3387p;
    }

    public static void m6717a(C1388d c1388d) {
        f3387p = c1388d;
    }

    public static Map<String, String> m6712A() {
        if (f3370G == null) {
            f3370G = new HashMap();
        }
        return f3370G;
    }

    public static Map<String, String> m6713B() {
        return f3371H;
    }

    public static boolean m6714C() {
        return f3369F;
    }

    public static void m6739f(boolean z) {
        f3369F = z;
    }
}
