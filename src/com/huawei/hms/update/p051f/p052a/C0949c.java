package com.huawei.hms.update.p051f.p052a;

import com.huawei.hms.support.log.C0887a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MultiCardMTKImpl */
final class C0949c extends C0947a {
    C0949c() {
    }

    public int mo2285b() {
        try {
            return m3300e();
        } catch (ClassNotFoundException e) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (NoSuchMethodException e2) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalAccessException e3) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalArgumentException e4) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (InvocationTargetException e5) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (ClassCastException e6) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        }
    }

    private int m3300e() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("android.telephony.TelephonyManager");
        Object invoke = cls.getDeclaredMethod("getDefault", (Class[]) null).invoke(null, (Object[]) null);
        Method declaredMethod = cls.getDeclaredMethod("getDefaultSim", (Class[]) null);
        declaredMethod.setAccessible(true);
        return ((Integer) declaredMethod.invoke(invoke, (Object[]) null)).intValue();
    }

    Object mo2286c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
        return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
    }

    public boolean mo2287d() {
        try {
            return m3301f();
        } catch (ClassNotFoundException e) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (NoSuchFieldException e2) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (IllegalAccessException e3) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (IllegalArgumentException e4) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (ClassCastException e5) {
            C0887a.m3096c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        }
    }

    private boolean m3301f() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
        declaredField.setAccessible(true);
        return declaredField.getBoolean(null);
    }
}
