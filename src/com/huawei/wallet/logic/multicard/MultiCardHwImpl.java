package com.huawei.wallet.logic.multicard;

import com.huawei.wallet.utils.log.LogC;
import java.lang.reflect.InvocationTargetException;

public class MultiCardHwImpl implements MultiCard {
    private static volatile MultiCardHwImpl f21277a;
    private static final byte[] f21278b = new byte[0];

    public static MultiCardHwImpl m28066a() {
        if (f21277a == null) {
            synchronized (f21278b) {
                if (f21277a == null) {
                    f21277a = new MultiCardHwImpl();
                }
            }
        }
        return f21277a;
    }

    public String mo5146a(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object b = m28067b();
            if (b != null) {
                str = (String) b.getClass().getMethod("getDeviceId", clsArr).invoke(b, objArr);
                if (str != null) {
                    return "";
                }
                return str;
            }
        } catch (NoSuchMethodException e) {
            LogC.m28531c("baselib", "getDeviceId NoSuchMethodException", false);
            str = str2;
        } catch (IllegalAccessException e2) {
            LogC.m28531c("baselib", "getDeviceId IllegalAccessException", false);
            str = str2;
        } catch (IllegalArgumentException e3) {
            LogC.m28531c("baselib", "getDeviceId IllegalArgumentException", false);
            str = str2;
        } catch (InvocationTargetException e4) {
            LogC.m28531c("baselib", "getDeviceId InvocationTargetException", false);
        }
        str = str2;
        if (str != null) {
            return str;
        }
        return "";
    }

    public static Object m28067b() {
        Object obj = null;
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (ClassNotFoundException e) {
            LogC.m28531c("baselib", "getDefaultMSimTelephonyManager ClassNotFoundException has error", false);
        } catch (NoSuchMethodException e2) {
            LogC.m28531c("baselib", "getDefaultMSimTelephonyManager NoSuchMethodException", false);
        } catch (IllegalAccessException e3) {
            LogC.m28531c("baselib", "getDefaultMSimTelephonyManager IllegalAccessException", false);
        } catch (IllegalArgumentException e4) {
            LogC.m28531c("baselib", "getDefaultMSimTelephonyManager IllegalArgumentException", false);
        } catch (InvocationTargetException e5) {
            LogC.m28531c("baselib", "getDefaultMSimTelephonyManager InvocationTargetException", false);
        } catch (Throwable e6) {
            LogC.m28523a("baselib", "getDefaultMSimTelephonyManager UnKnownException", e6, false);
        }
        return obj;
    }
}
