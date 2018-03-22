package com.huawei.wallet.logic.multicard;

import com.huawei.wallet.utils.log.LogC;
import java.lang.reflect.InvocationTargetException;

public final class MultiCardMTKImpl implements MultiCard {
    private static volatile MultiCardMTKImpl f21279a;
    private static final byte[] f21280b = new byte[0];

    public static MultiCardMTKImpl m28069a() {
        if (f21279a == null) {
            synchronized (f21280b) {
                if (f21279a == null) {
                    f21279a = new MultiCardMTKImpl();
                }
            }
        }
        return f21279a;
    }

    private MultiCardMTKImpl() {
    }

    public String mo5146a(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object b = m28070b();
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

    private static Object m28070b() {
        Object obj = null;
        try {
            Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (ClassNotFoundException e) {
            LogC.m28531c("baselib", "getDefaultTelephonyManagerEx ClassNotFoundException has error", false);
        } catch (NoSuchMethodException e2) {
            LogC.m28531c("baselib", "getDefaultTelephonyManagerEx NoSuchMethodException", false);
        } catch (IllegalAccessException e3) {
            LogC.m28531c("baselib", "getDefaultTelephonyManagerEx IllegalAccessException", false);
        } catch (IllegalArgumentException e4) {
            LogC.m28531c("baselib", "getDefaultTelephonyManagerEx IllegalArgumentException", false);
        } catch (InvocationTargetException e5) {
            LogC.m28531c("baselib", "getDefaultTelephonyManagerEx InvocationTargetException", false);
        }
        return obj;
    }
}
