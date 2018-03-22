package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.content.Context;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.hwdatamigrate.hihealth.p066a.C1001a;
import com.huawei.p190v.C2538c;

/* compiled from: HiSyncProcess */
public class C1016h {
    private static double f1815a = WeightedLatLng.DEFAULT_INTENSITY;
    private static double f1816b = WeightedLatLng.DEFAULT_INTENSITY;
    private static boolean f1817c = false;
    private static double f1818d = WeightedLatLng.DEFAULT_INTENSITY;

    public static void m3890a(Context context, double d, double d2, double d3) {
        if (f1817c) {
            C1016h.m3887a((d * d2) * d3);
            if (f1815a - f1818d >= WeightedLatLng.DEFAULT_INTENSITY) {
                f1818d = f1815a;
                C1001a.m3639a(context, f1815a);
            }
        }
    }

    private static void m3887a(double d) {
        if (d > 0.0d) {
            double d2 = f1815a + d;
            if (d2 >= f1816b) {
                d2 = f1816b;
            }
            f1815a = d2;
        }
    }

    public static void m3888a(double d, String str) {
        double d2 = 99.0d;
        if (d > 0.0d) {
            C2538c.m12677c("Debug_HiSyncProcess", "setCurrentMaxProcess tag is ", str);
            double d3 = f1816b + d;
            if (d3 < 99.0d) {
                d2 = d3;
            }
            f1816b = d2;
            C2538c.m12677c("Debug_HiSyncProcess", "setCurrentMaxProcess currentMaxProcess is ", Double.valueOf(f1816b));
        }
    }

    public static void m3889a(Context context) {
        if (f1817c) {
            C1001a.m3639a(context, f1816b);
            f1815a = f1816b;
        }
    }

    public static void m3892b(Context context) {
        if (f1817c) {
            C1001a.m3639a(context, f1815a);
        }
    }

    public static void m3893c(Context context) {
        C1001a.m3638a(context);
        C1001a.m3639a(context, (double) WeightedLatLng.DEFAULT_INTENSITY);
        C1016h.m3891a(true);
    }

    public static void m3894d(Context context) {
        if (f1817c) {
            C1001a.m3639a(context, 99.0d);
            C1001a.m3645c(context);
        }
        C1016h.m3891a(false);
        C1015e.m3858a(false);
    }

    public static void m3895e(Context context) {
        C1001a.m3646d(context);
        C1016h.m3891a(false);
        C1015e.m3858a(false);
    }

    private static void m3891a(boolean z) {
        f1815a = WeightedLatLng.DEFAULT_INTENSITY;
        f1816b = WeightedLatLng.DEFAULT_INTENSITY;
        f1818d = WeightedLatLng.DEFAULT_INTENSITY;
        f1817c = z;
    }
}
