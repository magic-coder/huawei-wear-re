package com.huawei.hms.update.p051f.p052a;

import com.huawei.hms.support.log.C0887a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MultiCardHwImpl */
class C0948b extends C0947a {
    C0948b() {
    }

    public int mo2285b() {
        try {
            Object c = mo2286c();
            return ((Integer) c.getClass().getMethod("getDefaultSubscription", new Class[0]).invoke(c, new Object[0])).intValue();
        } catch (ClassNotFoundException e) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (NoSuchMethodException e2) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalAccessException e3) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalArgumentException e4) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (InvocationTargetException e5) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (ClassCastException e6) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        }
    }

    public String mo2284a(int i) {
        try {
            Object c = mo2286c();
            return (String) c.getClass().getMethod("getSimOperator", new Class[]{Integer.TYPE}).invoke(c, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (InvocationTargetException e5) {
        } catch (ClassCastException e6) {
        }
        C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getSimOperator()");
        return "";
    }

    Object mo2286c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("android.telephony.MSimTelephonyManager");
        return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
    }

    public boolean mo2287d() {
        try {
            Object c = mo2286c();
            return ((Boolean) c.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(c, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (NoSuchMethodException e2) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (IllegalAccessException e3) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (IllegalArgumentException e4) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (InvocationTargetException e5) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (ClassCastException e6) {
            C0887a.m3096c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        }
    }
}
