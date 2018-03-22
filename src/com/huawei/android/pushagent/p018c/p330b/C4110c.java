package com.huawei.android.pushagent.p018c.p330b;

import com.huawei.android.pushagent.c.a.e;
import java.lang.reflect.InvocationTargetException;

public class C4110c implements C4108a {
    private static C4110c f15503a;

    public static synchronized C4110c m20136a() {
        C4110c c4110c;
        synchronized (C4110c.class) {
            if (f15503a == null) {
                f15503a = new C4110c();
            }
            c4110c = f15503a;
        }
        return c4110c;
    }

    public static Object m20137b() {
        Object obj = null;
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            e.e("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + e.toString());
        }
        return obj;
    }

    public String mo4379a(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object b = C4110c.m20137b();
            if (b != null) {
                str = (String) b.getClass().getMethod("getDeviceId", clsArr).invoke(b, objArr);
                return str != null ? "" : str;
            }
        } catch (NoSuchMethodException e) {
            e.e("MutiCardHwImpl", "getDeviceId exception:" + e.toString());
            str = str2;
        } catch (IllegalAccessException e2) {
            e.e("MutiCardHwImpl", "getDeviceId exception:" + e2.toString());
            str = str2;
        } catch (IllegalArgumentException e3) {
            e.e("MutiCardHwImpl", "getDeviceId exception:" + e3.toString());
            str = str2;
        } catch (InvocationTargetException e4) {
            e.e("MutiCardHwImpl", "getDeviceId exception:" + e4.toString());
        }
        str = str2;
        if (str != null) {
        }
    }
}
