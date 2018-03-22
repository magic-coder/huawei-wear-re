package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwdatamigrate.common.C4799a;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

/* compiled from: BOneDBUtil */
public class C4775h {
    private static String f17622a = null;
    private static ba f17623b = null;

    public static void m22860a(String str) {
        f17622a = str;
    }

    public static bg m22858a(Context context, String str) {
        bg a = new bf(context).m22841a(str);
        if (a == null) {
            a = new bg();
            a.f17586w = -1;
            a.f17587x = str;
            a.a = str;
            a.b = 1;
            a.c = HiUserInfo.BIRTHDAY_DEFAULT;
            a.n = "";
            a.e = "";
            a.f = HiUserInfo.HEIGHT_DEFAULT;
            a.g = 67;
            a.h = 0;
            a.i = 60;
            a.j = 132;
            a.k = 0;
            a.l = Math.round(C4775h.m22857a(a.f));
            a.m = Math.round(C4775h.m22861b(a.f));
            a.o = "";
            a.p = "";
            a.q = "";
            a.s = 0;
            a.t = "";
            a.r = HiUserInfo.BIRTHDAY_DEFAULT;
            a.u = "";
            a.v = "";
            return a;
        }
        if (TextUtils.isEmpty(a.n)) {
            a.n = "";
        }
        if (TextUtils.isEmpty(a.o)) {
            a.o = "";
        }
        if (TextUtils.isEmpty(a.p)) {
            a.p = "";
        }
        if (TextUtils.isEmpty(a.q)) {
            a.q = "";
        }
        if (TextUtils.isEmpty(a.t)) {
            a.t = "";
        }
        if (TextUtils.isEmpty(a.u)) {
            a.u = "";
        }
        if (!TextUtils.isEmpty(a.v)) {
            return a;
        }
        a.v = "";
        return a;
    }

    public static ap m22862b(Context context, String str) {
        String a;
        if (TextUtils.isEmpty(str)) {
            a = C4775h.m22859a(context);
        } else {
            a = str;
        }
        ap a2 = new ao(context).m22815a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = new ap();
        a2.f17475a = -1;
        a2.f17476b = str;
        a2.f17477c = ap.f17474g;
        a2.f17478d = 10000;
        a2.f17479e = 333;
        a2.f17480f = 4800;
        return a2;
    }

    public static float m22857a(int i) {
        return ((float) i) * 0.42f;
    }

    public static float m22861b(int i) {
        return ((float) i) * 0.83f;
    }

    public static String m22859a(Context context) {
        String str = "default_userid";
        if (context == null) {
            C2538c.e("BOneDBUtil", new Object[]{"getUserIDFromDB() context=null so return default UserID"});
            return "default_userid";
        } else if (f17622a != null) {
            return f17622a;
        } else {
            bc bcVar = new bc(context);
            bd a = bcVar.m22834a();
            if (a == null) {
                C2538c.b("BOneDBUtil", new Object[]{"getUserIDFromDB() initUseridDB()"});
                bcVar.m22837c();
                return str;
            }
            str = a.f17557b;
            f17622a = str;
            return str;
        }
    }

    public static ArrayList<String> m22863b(Context context) {
        C2538c.b("BOneDBUtil", new Object[]{"get15HuidList() enter"});
        C2538c.b("BOneDBUtil", new Object[]{"get15HuidList() res:" + new bc(context).m22836b().toString()});
        return new bc(context).m22836b();
    }

    public static boolean m22865c(Context context) {
        if (context == null) {
            C2538c.c("BOneDBUtil", new Object[]{"getLoginState() context is null, return false"});
            return false;
        }
        boolean z;
        ba c = C4775h.m22864c(context, C4775h.m22859a(context));
        if (c != null) {
            z = c.f17539k;
        } else {
            z = false;
        }
        c.c("BOneDBUtil", new Object[]{"getLoginState:" + z});
        return z;
    }

    public static String m22866d(Context context) {
        String str = "";
        if (context == null) {
            C2538c.e("BOneDBUtil", new Object[]{"getCountryFromDB() context is null, return false"});
            return "";
        } else if (!context.getDatabasePath("SportDatas.db").exists()) {
            return "";
        } else {
            au c = new as(context).m22823c();
            if (c != null) {
                return c.e;
            }
            return str;
        }
    }

    public static ba m22864c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C2538c.e("BOneDBUtil", new Object[]{"getUserConfigTable() parameters is null"});
            return null;
        } else if (f17623b != null) {
            return f17623b;
        } else {
            ba a = new az(context).m22826a(str);
            f17623b = a;
            return a;
        }
    }

    public static String m22867d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return C4799a.m22980a(context, str);
    }

    public static String m22868e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return C4799a.m22981b(context, str);
    }
}
