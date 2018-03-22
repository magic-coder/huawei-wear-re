package com.huawei.android.pushagent.p018c.p330b;

import com.huawei.android.pushagent.c.a.e;
import java.lang.reflect.InvocationTargetException;

public class C4111d implements C4108a {
    private static C4111d f15504a;

    private C4111d() {
    }

    public static synchronized C4111d m20139a() {
        C4111d c4111d;
        synchronized (C4111d.class) {
            if (f15504a == null) {
                f15504a = new C4111d();
            }
            c4111d = f15504a;
        }
        return c4111d;
    }

    private static Object m20140b() {
        Object obj = null;
        try {
            Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            e.e("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + e.toString());
        }
        return obj;
    }

    public String mo4379a(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object b = C4111d.m20140b();
            if (b != null) {
                str = (String) b.getClass().getMethod("getDeviceId", clsArr).invoke(b, objArr);
                return str != null ? "" : str;
            }
        } catch (NoSuchMethodException e) {
            e.e("mutiCardMTKImpl", "getDeviceId exception:" + e.toString());
            str = str2;
        } catch (IllegalAccessException e2) {
            e.e("mutiCardMTKImpl", "getDeviceId exception:" + e2.toString());
            str = str2;
        } catch (IllegalArgumentException e3) {
            e.e("mutiCardMTKImpl", "getDeviceId exception:" + e3.toString());
            str = str2;
        } catch (InvocationTargetException e4) {
            e.e("mutiCardMTKImpl", "getDeviceId exception:" + e4.toString());
        }
        str = str2;
        if (str != null) {
        }
    }
}
