package com.huawei.hwid.core.p435d.p439c;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MultiCardMTKImpl */
public final class C5171d implements C5168a {
    private static C5171d f18625a;

    public static synchronized C5171d m24981b() {
        C5171d c5171d;
        synchronized (C5171d.class) {
            if (f18625a == null) {
                f18625a = new C5171d();
            }
            c5171d = f18625a;
        }
        return c5171d;
    }

    private C5171d() {
    }

    public int mo4642a() {
        return C5171d.m24982c();
    }

    private static int m24982c() {
        try {
            Class cls = Class.forName("android.telephony.TelephonyManager");
            Method declaredMethod = cls.getDeclaredMethod("getDefaultSim", (Class[]) null);
            Object invoke = cls.getDeclaredMethod("getDefault", (Class[]) null).invoke(null, (Object[]) null);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(invoke, (Object[]) null)).intValue();
        } catch (Throwable e) {
            C5165e.m24905a("mutiCardMTKImpl", "" + e.getMessage(), e);
            return -1;
        } catch (Throwable e2) {
            C5165e.m24905a("mutiCardMTKImpl", "" + e2.getMessage(), e2);
            return -1;
        }
    }

    public String mo4643a(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object d = C5171d.m24983d();
            if (d != null) {
                str = (String) d.getClass().getMethod("getDeviceId", clsArr).invoke(d, objArr);
                if (str != null) {
                    return "";
                }
                return str;
            }
        } catch (NoSuchMethodException e) {
            C5165e.m24910d("mutiCardMTKImpl", "getDeviceId exception:" + e.getMessage());
            str = str2;
        } catch (IllegalArgumentException e2) {
            C5165e.m24910d("mutiCardMTKImpl", "getDeviceId exception:" + e2.getMessage());
            str = str2;
        } catch (InvocationTargetException e3) {
            C5165e.m24910d("mutiCardMTKImpl", "getDeviceId exception:" + e3.getMessage());
            str = str2;
        } catch (Exception e4) {
            C5165e.m24910d("mutiCardMTKImpl", "getDeviceId exception:" + e4.getMessage());
        }
        str = str2;
        if (str != null) {
            return str;
        }
        return "";
    }

    public String mo4644b(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object d = C5171d.m24983d();
            if (d != null) {
                str = (String) d.getClass().getMethod("getSubscriberId", clsArr).invoke(d, objArr);
                if (str != null) {
                    return "";
                }
                return str;
            }
        } catch (Throwable e) {
            C5165e.m24911d("mutiCardMTKImpl", "getSubscriberId exception:" + e.getMessage(), e);
            str = str2;
        } catch (Throwable e2) {
            C5165e.m24911d("mutiCardMTKImpl", "getSubscriberId exception:" + e2.getMessage(), e2);
            str = str2;
        } catch (Throwable e22) {
            C5165e.m24911d("mutiCardMTKImpl", "getSubscriberId exception:" + e22.getMessage(), e22);
            str = str2;
        } catch (Throwable e222) {
            C5165e.m24911d("mutiCardMTKImpl", "getSubscriberId exception:" + e222.getMessage(), e222);
        }
        str = str2;
        if (str != null) {
            return str;
        }
        return "";
    }

    public int mo4645c(int i) {
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            int intValue;
            Object d = C5171d.m24983d();
            if (d != null) {
                intValue = ((Integer) d.getClass().getDeclaredMethod("getSimState", clsArr).invoke(d, objArr)).intValue();
            } else {
                intValue = 0;
            }
            return intValue;
        } catch (Throwable e) {
            C5165e.m24911d("mutiCardMTKImpl", " getSimState wrong " + e.getMessage(), e);
            return 0;
        } catch (Throwable e2) {
            C5165e.m24911d("mutiCardMTKImpl", " getSimState wrong " + e2.getMessage(), e2);
            return 0;
        } catch (Throwable e22) {
            C5165e.m24911d("mutiCardMTKImpl", " getSimState wrong " + e22.getMessage(), e22);
            return 0;
        } catch (Throwable e222) {
            C5165e.m24911d("mutiCardMTKImpl", " getSimState wrong " + e222.getMessage(), e222);
            return 0;
        }
    }

    public String mo4646d(int i) {
        return "";
    }

    private static Object m24983d() {
        Object obj = null;
        try {
            Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable e) {
            C5165e.m24905a("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + e.getMessage(), e);
        }
        return obj;
    }
}
