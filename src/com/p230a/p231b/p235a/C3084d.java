package com.p230a.p231b.p235a;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.p230a.p231b.p237c.C3131d;
import com.p230a.p231b.p237c.C3132e;

public class C3084d {
    public static String f10347a;
    public static String f10348b = "DKKJ";
    public static String f10349c;
    public static String f10350d;
    public static String f10351e = "";
    public static String f10352f = "";
    public static String f10353g = "";
    public static String f10354h = "";
    public static String f10355i = "";
    public static String f10356j = "DKKJ";
    public static int f10357k = 0;
    public static int f10358l = 0;
    public static int f10359m = 0;
    public static int f10360n = 0;
    public static int f10361o = 0;
    public static String f10362p;
    public static float f10363q = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    public static int f10364r = 1;
    public static String f10365s = "";
    public static String f10366t = "com.citiccard.mobilebank";
    private static C3084d f10367u;

    public static C3084d m13793a() {
        return f10367u;
    }

    public static C3084d m13794a(Context context) {
        if (f10367u == null) {
            synchronized (C3131d.class) {
                f10367u = new C3084d();
                f10349c = C3131d.m13946g(context);
                f10352f = C3131d.m13944e(context);
                String f = C3131d.m13945f(context);
                f10351e = f;
                if (C3132e.m13953a(f)) {
                    f10347a = "AD_" + C3131d.m13940a(context);
                } else {
                    f10347a = "AD_" + f10351e;
                }
                f10353g = C3131d.m13941b(context);
                f10354h = C3131d.m13942c(context);
                f10355i = C3131d.m13939a();
                f10356j = "DKKJ";
                int i = context.getResources().getDisplayMetrics().widthPixels;
                f10357k = i;
                f10359m = i;
                i = context.getResources().getDisplayMetrics().heightPixels;
                f10358l = i;
                f10360n = i;
                f10362p = f10357k + "," + f10358l;
                f10361o = (int) (((double) f10360n) * 0.081d);
                f10363q = context.getResources().getDisplayMetrics().density;
                f10350d = C3131d.m13949j(context);
                f10365s = C3131d.m13946g(context);
                f10364r = C3131d.m13947h(context);
                f10366t = C3131d.m13948i(context);
            }
        }
        return f10367u;
    }
}
