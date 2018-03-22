package com.huawei.appmarket.sdk.foundation.p367e.p369b.p370a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

public class C4279d implements C4276a {
    private static C4279d f15957a;

    public static synchronized C4279d m20653b() {
        C4279d c4279d;
        synchronized (C4279d.class) {
            if (f15957a == null) {
                f15957a = new C4279d();
            }
            c4279d = f15957a;
        }
        return c4279d;
    }

    public static Object m20654c() {
        Object obj = null;
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            C4241a.m20532b("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + e.toString());
        }
        return obj;
    }

    public int mo4396a() {
        try {
            Object c = C4279d.m20654c();
            return c != null ? ((Integer) c.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(c, new Object[0])).intValue() : 0;
        } catch (Exception e) {
            C4241a.m20532b("MutiCardHwImpl", " getPreferredDataSubscription wrong " + e.toString());
            return -1;
        }
    }
}
