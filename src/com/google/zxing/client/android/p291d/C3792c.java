package com.google.zxing.client.android.p291d;

import android.app.Activity;
import android.util.Log;
import com.google.zxing.C3934m;
import com.google.zxing.client.p285a.C3741u;
import com.google.zxing.client.p285a.C3743q;
import com.google.zxing.client.p285a.C3759r;

/* compiled from: ResultHandlerFactory */
public final class C3792c {
    private static /* synthetic */ int[] f14748a;

    static /* synthetic */ int[] m19025a() {
        int[] iArr = f14748a;
        if (iArr == null) {
            iArr = new int[C3759r.values().length];
            try {
                iArr[C3759r.ADDRESSBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C3759r.CALENDAR.ordinal()] = 9;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C3759r.EMAIL_ADDRESS.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C3759r.GEO.ordinal()] = 6;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C3759r.ISBN.ordinal()] = 11;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C3759r.PRODUCT.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[C3759r.SMS.ordinal()] = 8;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[C3759r.TEL.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[C3759r.TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[C3759r.URI.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[C3759r.WIFI.ordinal()] = 10;
            } catch (NoSuchFieldError e11) {
            }
            f14748a = iArr;
        }
        return iArr;
    }

    public static C3790a m19024a(Activity activity, C3934m c3934m) {
        C3743q a = C3792c.m19023a(c3934m);
        Log.d("ResultHandlerFactory", "result.getType()=" + a.m18843b());
        int i = C3792c.m19025a()[a.m18843b().ordinal()];
        return new C3793d(activity, a, c3934m);
    }

    public static C3743q m19023a(C3934m c3934m) {
        return C3741u.m18832d(c3934m);
    }
}
