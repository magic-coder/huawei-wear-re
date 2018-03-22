package com.huawei.hwid.update.p454e.p455a;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MultiCardMTKImpl */
final class C5308c extends C5306a {
    C5308c() {
    }

    public int mo4677b() {
        try {
            return m25662e();
        } catch (ClassNotFoundException e) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (NoSuchMethodException e2) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalAccessException e3) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (IllegalArgumentException e4) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (InvocationTargetException e5) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        } catch (ClassCastException e6) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke [TelephonyManager].getDefaultSubscription()");
            return -1;
        }
    }

    private int m25662e() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("android.telephony.TelephonyManager");
        Object invoke = cls.getDeclaredMethod("getDefault", (Class[]) null).invoke(null, (Object[]) null);
        Method declaredMethod = cls.getDeclaredMethod("getDefaultSim", (Class[]) null);
        declaredMethod.setAccessible(true);
        return ((Integer) declaredMethod.invoke(invoke, (Object[]) null)).intValue();
    }

    Object mo4678c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
        return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
    }

    public boolean mo4679d() {
        try {
            return m25663f();
        } catch (ClassNotFoundException e) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (NoSuchFieldException e2) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (IllegalAccessException e3) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (IllegalArgumentException e4) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        } catch (ClassCastException e5) {
            C5165e.m24908c("MultiCardMTKImpl", "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT");
            return false;
        }
    }

    private boolean m25663f() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
        declaredField.setAccessible(true);
        return declaredField.getBoolean(null);
    }
}
