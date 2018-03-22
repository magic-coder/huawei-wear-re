package com.huawei.hwid.core.p435d.p439c;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MultiCardHwImpl */
public class C5170c implements C5168a {
    private static C5170c f18624a;

    public static synchronized C5170c m24974b() {
        C5170c c5170c;
        synchronized (C5170c.class) {
            if (f18624a == null) {
                f18624a = new C5170c();
            }
            c5170c = f18624a;
        }
        return c5170c;
    }

    public int mo4642a() {
        try {
            Object c = C5170c.m24975c();
            if (c != null) {
                return ((Integer) c.getClass().getMethod("getDefaultSubscription", new Class[0]).invoke(c, new Object[0])).intValue();
            }
            return 0;
        } catch (Throwable e) {
            C5165e.m24911d("MutiCardHwImpl", " NoSuchMethodException wrong " + e.getMessage(), e);
            return -1;
        } catch (Throwable e2) {
            C5165e.m24911d("MutiCardHwImpl", " IllegalArgumentException wrong " + e2.getMessage(), e2);
            return -1;
        } catch (Throwable e22) {
            C5165e.m24911d("MutiCardHwImpl", " InvocationTargetException wrong " + e22.getMessage(), e22);
            return -1;
        } catch (Throwable e222) {
            C5165e.m24911d("MutiCardHwImpl", " Exception wrong " + e222.getMessage(), e222);
            return -1;
        }
    }

    public String mo4643a(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object c = C5170c.m24975c();
            if (c != null) {
                str = (String) c.getClass().getMethod("getDeviceId", clsArr).invoke(c, objArr);
                if (str != null) {
                    return "";
                }
                return str;
            }
        } catch (NoSuchMethodException e) {
            C5165e.m24910d("MutiCardHwImpl", "getDeviceId exception:" + e.getMessage());
            str = str2;
        } catch (IllegalArgumentException e2) {
            C5165e.m24910d("MutiCardHwImpl", "getDeviceId exception:" + e2.getMessage());
            str = str2;
        } catch (InvocationTargetException e3) {
            C5165e.m24910d("MutiCardHwImpl", "getDeviceId exception:" + e3.getMessage());
            str = str2;
        } catch (Exception e4) {
            C5165e.m24910d("MutiCardHwImpl", "getDeviceId exception:" + e4.getMessage());
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
            Object c = C5170c.m24975c();
            if (c != null) {
                str = (String) c.getClass().getMethod("getSubscriberId", clsArr).invoke(c, objArr);
                if (str != null) {
                    return "";
                }
                return str;
            }
        } catch (Throwable e) {
            C5165e.m24911d("MutiCardHwImpl", "getSubscriberId exception:" + e.getMessage(), e);
            str = str2;
        } catch (Throwable e2) {
            C5165e.m24911d("MutiCardHwImpl", "getSubscriberId exception:" + e2.getMessage(), e2);
            str = str2;
        } catch (Throwable e22) {
            C5165e.m24911d("MutiCardHwImpl", "getSubscriberId exception:" + e22.getMessage(), e22);
            str = str2;
        } catch (Throwable e222) {
            C5165e.m24911d("MutiCardHwImpl", "getSubscriberId exception:" + e222.getMessage(), e222);
        }
        str = str2;
        if (str != null) {
            return str;
        }
        return "";
    }

    public int mo4645c(int i) {
        int i2;
        if (i == -1) {
            i2 = 5;
        } else {
            i2 = 0;
        }
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object c = C5170c.m24975c();
            if (c != null) {
                i2 = ((Integer) c.getClass().getDeclaredMethod("getSimState", clsArr).invoke(c, objArr)).intValue();
            }
        } catch (Throwable e) {
            C5165e.m24911d("MutiCardHwImpl", " IllegalAccessException wrong " + e.getMessage(), e);
        } catch (Throwable e2) {
            C5165e.m24911d("MutiCardHwImpl", " NoSuchMethodException wrong " + e2.getMessage(), e2);
        } catch (Throwable e22) {
            C5165e.m24911d("MutiCardHwImpl", " IllegalArgumentException wrong " + e22.getMessage(), e22);
        } catch (Throwable e222) {
            C5165e.m24911d("MutiCardHwImpl", " getSimState wrong " + e222.getMessage(), e222);
        }
        return i2;
    }

    public static Object m24975c() {
        Object obj = null;
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            obj = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable e) {
            C5165e.m24905a("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + e.getMessage(), e);
        }
        return obj;
    }

    public String mo4646d(int i) {
        String str;
        String str2 = "";
        Class[] clsArr = new Class[]{Integer.TYPE};
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        try {
            Object c = C5170c.m24975c();
            if (c != null) {
                str = (String) c.getClass().getMethod("getSimOperator", clsArr).invoke(c, objArr);
                if (str != null) {
                    return "";
                }
                return str;
            }
        } catch (Throwable e) {
            C5165e.m24911d("MutiCardHwImpl", "getSimOperator exception:" + e.getMessage(), e);
            str = str2;
        } catch (Throwable e2) {
            C5165e.m24911d("MutiCardHwImpl", "getSimOperator exception:" + e2.getMessage(), e2);
            str = str2;
        } catch (Throwable e22) {
            C5165e.m24911d("MutiCardHwImpl", "getSimOperator exception:" + e22.getMessage(), e22);
            str = str2;
        } catch (Throwable e222) {
            C5165e.m24911d("MutiCardHwImpl", "getSimOperator exception:" + e222.getMessage(), e222);
        }
        str = str2;
        if (str != null) {
            return str;
        }
        return "";
    }
}
