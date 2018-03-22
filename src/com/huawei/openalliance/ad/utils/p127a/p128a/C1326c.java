package com.huawei.openalliance.ad.utils.p127a.p128a;

import com.huawei.openalliance.ad.utils.p129b.C1336d;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;

public class C1326c implements C1324a {
    private static C1326c f2864a;

    public static synchronized C1326c m5841b() {
        C1326c c1326c;
        synchronized (C1326c.class) {
            if (f2864a == null) {
                f2864a = new C1326c();
            }
            c1326c = f2864a;
        }
        return c1326c;
    }

    @SuppressWarnings(justification = "h00193325/从系统进行反射，对各种异常处理方式都一致，所以使用Exception进行异常捕获", value = {"REC_CATCH_EXCEPTION"})
    public static Object m5842c() {
        Object obj = null;
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            C1336d.m5888c("MutiCardHwImpl", "getDefaultMSimTelephonyManager wrong");
        }
        return obj;
    }

    @SuppressWarnings(justification = "h00193325/从系统进行反射，对各种异常处理方式都一致，所以使用Exception进行异常捕获", value = {"REC_CATCH_EXCEPTION"})
    public int mo2453a() {
        try {
            Object c = C1326c.m5842c();
            return c != null ? ((Integer) c.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(c, new Object[0])).intValue() : 0;
        } catch (Exception e) {
            C1336d.m5888c("MutiCardHwImpl", "getPreferredDataSubscription wrong");
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
            Object c = C1326c.m5842c();
            if (c != null) {
                str = (String) c.getClass().getMethod("getDeviceId", clsArr).invoke(c, objArr);
                return str != null ? "" : str;
            }
        } catch (Exception e) {
            C1336d.m5888c("MutiCardHwImpl", "getDeviceId exception:");
        }
        str = str2;
        if (str != null) {
        }
    }
}
