package com.huawei.hwid.update.p454e.p455a;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MultiCard */
public abstract class C5306a {
    public abstract int mo4677b();

    abstract Object mo4678c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public abstract boolean mo4679d();

    public static C5306a m25651a() {
        C5306a c5307b = new C5307b();
        if (c5307b.mo4679d()) {
            C5165e.m24906b("MultiCard", "Return HW instance.");
            return c5307b;
        }
        c5307b = new C5308c();
        if (!c5307b.mo4679d()) {
            return null;
        }
        C5165e.m24906b("MultiCard", "Return MTK instance.");
        return c5307b;
    }

    public String mo4676a(int i) {
        return "";
    }

    public int m25654b(int i) {
        try {
            Object c = mo4678c();
            return ((Integer) c.getClass().getDeclaredMethod("getSimState", new Class[]{Integer.TYPE}).invoke(c, new Object[]{Integer.valueOf(i)})).intValue();
        } catch (ClassNotFoundException e) {
            C5165e.m24908c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (NoSuchMethodException e2) {
            C5165e.m24908c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (IllegalAccessException e3) {
            C5165e.m24908c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (IllegalArgumentException e4) {
            C5165e.m24908c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (InvocationTargetException e5) {
            C5165e.m24908c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (ClassCastException e6) {
            C5165e.m24908c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        }
    }

    public String m25656c(int i) {
        try {
            Object c = mo4678c();
            return (String) c.getClass().getMethod("getSubscriberId", new Class[]{Integer.TYPE}).invoke(c, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (InvocationTargetException e5) {
        } catch (ClassCastException e6) {
        }
        C5165e.m24908c("MultiCard", "Failed to call [TelephonyManager].getSubscriberId()");
        return "";
    }
}
