package com.huawei.hms.update.p051f.p052a;

import com.huawei.hms.support.log.C0887a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MultiCard */
public abstract class C0947a {
    public abstract int mo2285b();

    abstract Object mo2286c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public abstract boolean mo2287d();

    public static C0947a m3289a() {
        C0947a c0948b = new C0948b();
        if (c0948b.mo2287d()) {
            C0887a.m3094b("MultiCard", "Return HW instance.");
            return c0948b;
        }
        c0948b = new C0949c();
        if (!c0948b.mo2287d()) {
            return null;
        }
        C0887a.m3094b("MultiCard", "Return MTK instance.");
        return c0948b;
    }

    public String mo2284a(int i) {
        return "";
    }

    public int m3292b(int i) {
        try {
            Object c = mo2286c();
            return ((Integer) c.getClass().getDeclaredMethod("getSimState", new Class[]{Integer.TYPE}).invoke(c, new Object[]{Integer.valueOf(i)})).intValue();
        } catch (ClassNotFoundException e) {
            C0887a.m3096c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (NoSuchMethodException e2) {
            C0887a.m3096c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (IllegalAccessException e3) {
            C0887a.m3096c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (IllegalArgumentException e4) {
            C0887a.m3096c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (InvocationTargetException e5) {
            C0887a.m3096c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        } catch (ClassCastException e6) {
            C0887a.m3096c("MultiCard", "Failed to call [TelephonyManager].getSimState()");
            return 0;
        }
    }

    public String m3294c(int i) {
        try {
            Object c = mo2286c();
            return (String) c.getClass().getMethod("getSubscriberId", new Class[]{Integer.TYPE}).invoke(c, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (InvocationTargetException e5) {
        } catch (ClassCastException e6) {
        }
        C0887a.m3096c("MultiCard", "Failed to call [TelephonyManager].getSubscriberId()");
        return "";
    }
}
