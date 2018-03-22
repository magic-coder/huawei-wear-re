package com.huawei.appmarket.sdk.foundation.p367e.p369b.p370a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import java.lang.reflect.Field;

public class C4278c {
    private static C4277b f15955a = C4277b.MODE_SUPPORT_UNKNOWN;
    private static C4276a f15956b;

    public static C4276a m20649a() {
        C4278c.m20650b();
        if (f15955a == C4277b.MODE_SUPPORT_MTK_GEMINI) {
            f15956b = C4280e.m20656b();
        } else {
            f15956b = C4279d.m20653b();
        }
        return f15956b;
    }

    public static boolean m20650b() {
        if (f15955a != C4277b.MODE_SUPPORT_UNKNOWN) {
            return f15955a == C4277b.MODE_SUPPORT_HW_GEMINI || f15955a == C4277b.MODE_SUPPORT_MTK_GEMINI;
        } else {
            if (C4278c.m20652d()) {
                f15955a = C4277b.MODE_SUPPORT_MTK_GEMINI;
                return true;
            } else if (C4278c.m20651c()) {
                f15955a = C4277b.MODE_SUPPORT_HW_GEMINI;
                return true;
            } else {
                f15955a = C4277b.MODE_NOT_SUPPORT_GEMINI;
                return false;
            }
        }
    }

    public static boolean m20651c() {
        boolean z = false;
        try {
            Object c = C4279d.m20654c();
            z = c != null ? ((Boolean) c.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(c, new Object[0])).booleanValue() : false;
        } catch (Exception e) {
            C4241a.m20532b("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()?" + e.toString());
        } catch (Error e2) {
            C4241a.m20532b("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()" + e2.toString());
        }
        C4241a.m20529a("mutiCardFactory", "isHwGeminiSupport1 " + z);
        return z;
    }

    private static boolean m20652d() {
        boolean z = false;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(null);
        } catch (Exception e) {
            C4241a.m20532b("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + e.toString());
        } catch (Error e2) {
            C4241a.m20532b("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + e2.toString());
        }
        C4241a.m20529a("mutiCardFactory", "isMtkGeminiSupport " + z);
        return z;
    }
}
