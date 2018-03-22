package com.huawei.appmarket.sdk.foundation.p367e.p369b.p370a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

public final class C4280e implements C4276a {
    private static C4280e f15958a;

    private C4280e() {
    }

    public static synchronized C4280e m20656b() {
        C4280e c4280e;
        synchronized (C4280e.class) {
            if (f15958a == null) {
                f15958a = new C4280e();
            }
            c4280e = f15958a;
        }
        return c4280e;
    }

    private static Object m20657c() {
        Object obj = null;
        try {
            Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            C4241a.m20532b("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + e.toString());
        }
        return obj;
    }

    public int mo4396a() {
        try {
            Object c = C4280e.m20657c();
            return c != null ? ((Integer) c.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(c, new Object[0])).intValue() : 0;
        } catch (Exception e) {
            C4241a.m20532b("mutiCardMTKImpl", " getPreferredDataSubscription wrong " + e.toString());
            return -1;
        }
    }
}
