package com.huawei.hwid.update.p454e.p455a;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MultiCardHwImpl */
class C5307b extends C5306a {
    C5307b() {
    }

    public int mo4677b() {
        try {
            Object c = mo4678c();
            return ((Integer) c.getClass().getMethod("getDefaultSubscription", new Class[0]).invoke(c, new Object[0])).intValue();
        } catch (ClassNotFoundException e) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (NoSuchMethodException e2) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalAccessException e3) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalArgumentException e4) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (InvocationTargetException e5) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (ClassCastException e6) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        }
    }

    public String mo4676a(int i) {
        try {
            Object c = mo4678c();
            return (String) c.getClass().getMethod("getSimOperator", new Class[]{Integer.TYPE}).invoke(c, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (InvocationTargetException e5) {
        } catch (ClassCastException e6) {
        }
        C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].getSimOperator()");
        return "";
    }

    Object mo4678c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("android.telephony.MSimTelephonyManager");
        return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
    }

    public boolean mo4679d() {
        try {
            Object c = mo4678c();
            return ((Boolean) c.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(c, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (NoSuchMethodException e2) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (IllegalAccessException e3) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (IllegalArgumentException e4) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (InvocationTargetException e5) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        } catch (ClassCastException e6) {
            C5165e.m24908c("MultiCardHwImpl", "Failed to invoke [TelephonyManager].isMultiSimEnabled()");
            return false;
        }
    }
}
