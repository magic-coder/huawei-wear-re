package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.CoordUtil;
import com.autonavi.amap.mapcore.DPoint;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: OffsetUtil */
public class C3269a {
    static double f11374a = 3.141592653589793d;
    private static boolean f11375b = false;

    public static LatLng m15379a(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        String a = bu.m15773a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(a) && new File(a).exists()) {
            if (f11375b) {
                bf.m15627a("OffsetUtil", "group has loaded", 111);
            } else {
                try {
                    System.load(a);
                    f11375b = true;
                } catch (Throwable th) {
                }
            }
        }
        DPoint a2 = C3269a.m15383a(new DPoint(latLng.longitude, latLng.latitude), f11375b);
        return new LatLng(a2.f13251y, a2.f13250x, false);
    }

    private static DPoint m15383a(DPoint dPoint, boolean z) {
        double[] dArr;
        double[] dArr2;
        try {
            dArr2 = new double[2];
            if (z) {
                dArr = new double[]{dPoint.f13250x, dPoint.f13251y};
                bf.m15627a("OffsetUtil", "use group offset", 111);
                if (CoordUtil.convertToGcj(dArr, dArr2) != 0) {
                    dArr2 = dx.m16107a(dPoint.f13250x, dPoint.f13251y);
                }
                dArr = dArr2;
            } else {
                bf.m15627a("OffsetUtil", "use default offset", 111);
                dArr = dx.m16107a(dPoint.f13250x, dPoint.f13251y);
            }
        } catch (Throwable th) {
            return dPoint;
        }
        return new DPoint(dArr[0], dArr[1]);
    }

    public static LatLng m15386b(Context context, LatLng latLng) {
        try {
            DPoint c = C3269a.m15387c(latLng.longitude, latLng.latitude);
            latLng = C3269a.m15379a(context, new LatLng(c.f13251y, c.f13250x, false));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return latLng;
    }

    public static double m15377a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static double m15385b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static DPoint m15387c(double d, double d2) {
        double d3 = (double) (((long) (100000.0d * d)) % 36000000);
        double d4 = (double) (((long) (100000.0d * d2)) % 36000000);
        int i = (int) ((-C3269a.m15385b(d3, d4)) + d4);
        int i2 = (int) (((double) (d3 > 0.0d ? 1 : -1)) + ((-C3269a.m15377a((double) ((int) ((-C3269a.m15377a(d3, d4)) + d3)), (double) i)) + d3));
        return new DPoint(((double) i2) / 100000.0d, ((double) ((int) (((double) (d4 > 0.0d ? 1 : -1)) + ((-C3269a.m15385b((double) i2, (double) i)) + d4)))) / 100000.0d);
    }

    public static LatLng m15380a(LatLng latLng) {
        if (latLng != null) {
            try {
                DPoint a = C3269a.m15382a(new DPoint(latLng.longitude, latLng.latitude), 2);
                return new LatLng(a.f13251y, a.f13250x, false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static double m15376a(double d) {
        return Math.sin((3000.0d * d) * (f11374a / 180.0d)) * 2.0E-5d;
    }

    private static double m15384b(double d) {
        return Math.cos((3000.0d * d) * (f11374a / 180.0d)) * 3.0E-6d;
    }

    private static DPoint m15388d(double d, double d2) {
        DPoint dPoint = new DPoint();
        double sin = (Math.sin(C3269a.m15384b(d) + Math.atan2(d2, d)) * (C3269a.m15376a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.006d;
        dPoint.f13250x = C3269a.m15378a((Math.cos(C3269a.m15384b(d) + Math.atan2(d2, d)) * (C3269a.m15376a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.0065d, 8);
        dPoint.f13251y = C3269a.m15378a(sin, 8);
        return dPoint;
    }

    private static double m15378a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    private static DPoint m15382a(DPoint dPoint, int i) {
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        int i2 = 0;
        DPoint dPoint2 = null;
        while (i2 < i) {
            DPoint a = C3269a.m15381a(dPoint.f13250x, dPoint.f13251y, d, d2);
            d = dPoint.f13250x - a.f13250x;
            d2 = dPoint.f13251y - a.f13251y;
            i2++;
            dPoint2 = a;
        }
        return dPoint2;
    }

    private static DPoint m15381a(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint d7 = C3269a.m15388d(d5, d6);
        dPoint.f13250x = C3269a.m15378a((d5 + d) - d7.f13250x, 8);
        dPoint.f13251y = C3269a.m15378a((d2 + d6) - d7.f13251y, 8);
        return dPoint;
    }
}
