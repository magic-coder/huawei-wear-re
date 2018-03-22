package com.huawei.openalliance.ad.utils.p127a.p128a;

import com.huawei.openalliance.ad.utils.p129b.C1336d;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;

public final class C1327d implements C1324a {
    private static C1327d f2865a;

    private C1327d() {
    }

    public static synchronized C1327d m5845b() {
        C1327d c1327d;
        synchronized (C1327d.class) {
            if (f2865a == null) {
                f2865a = new C1327d();
            }
            c1327d = f2865a;
        }
        return c1327d;
    }

    @SuppressWarnings(justification = "h00193325/从系统进行反射，对各种异常处理方式都一致，所以使用Exception进行异常捕获", value = {"REC_CATCH_EXCEPTION"})
    private static Object m5846c() {
        Object obj = null;
        try {
            Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            C1336d.m5888c("mutiCardMTKImpl", "getDefaultTelephonyManagerEx wrong");
        }
        return obj;
    }

    @SuppressWarnings(justification = "h00193325/从系统进行反射，对各种异常处理方式都一致，所以使用Exception进行异常捕获", value = {"REC_CATCH_EXCEPTION"})
    public int mo2453a() {
        try {
            Object c = C1327d.m5846c();
            return c != null ? ((Integer) c.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(c, new Object[0])).intValue() : 0;
        } catch (Exception e) {
            C1336d.m5888c("mutiCardMTKImpl", "getPreferredDataSubscription wrong");
            return -1;
        }
    }

    @SuppressWarnings(justification = "h00193325/从系统进行反射，对各种异常处理方式都一致，所以使用Exception进行异常捕获", value = {"REC_CATCH_EXCEPTION"})
    public String mo2454a(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object c = C1327d.m5846c();
            if (c != null) {
                str = (String) c.getClass().getMethod("getDeviceId", clsArr).invoke(c, objArr);
                return str != null ? "" : str;
            }
        } catch (Exception e) {
            C1336d.m5888c("mutiCardMTKImpl", "getDeviceId exception");
        }
        str = str2;
        if (str != null) {
        }
    }
}
