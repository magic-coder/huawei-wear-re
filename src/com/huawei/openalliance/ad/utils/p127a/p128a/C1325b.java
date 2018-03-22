package com.huawei.openalliance.ad.utils.p127a.p128a;

import com.huawei.openalliance.ad.utils.p127a.p128a.C1324a.C1323a;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.lang.reflect.Field;

public class C1325b {
    private static C1323a f2862a = C1323a.MODE_SUPPORT_UNKNOWN;
    private static C1324a f2863b;

    public static C1324a m5837a() {
        C1325b.m5838b();
        if (f2862a == C1323a.MODE_SUPPORT_MTK_GEMINI) {
            f2863b = C1327d.m5845b();
        } else {
            f2863b = C1326c.m5841b();
        }
        return f2863b;
    }

    public static boolean m5838b() {
        if (f2862a != C1323a.MODE_SUPPORT_UNKNOWN) {
            return f2862a == C1323a.MODE_SUPPORT_HW_GEMINI || f2862a == C1323a.MODE_SUPPORT_MTK_GEMINI;
        } else {
            if (C1325b.m5840d()) {
                f2862a = C1323a.MODE_SUPPORT_MTK_GEMINI;
                return true;
            } else if (C1325b.m5839c()) {
                f2862a = C1323a.MODE_SUPPORT_HW_GEMINI;
                return true;
            } else {
                f2862a = C1323a.MODE_NOT_SUPPORT_GEMINI;
                return false;
            }
        }
    }

    public static boolean m5839c() {
        boolean booleanValue;
        try {
            Object c = C1326c.m5842c();
            if (c != null) {
                booleanValue = ((Boolean) c.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(c, new Object[0])).booleanValue();
                C1336d.m5886b("mutiCardFactory", "isHwGeminiSupport1 ", String.valueOf(booleanValue));
                return booleanValue;
            }
        } catch (Exception e) {
            C1336d.m5888c("mutiCardFactory", "cannot find ext hwapi");
            booleanValue = false;
        } catch (Error e2) {
            C1336d.m5888c("mutiCardFactory", "NoClassDefFoundError");
        }
        booleanValue = false;
        C1336d.m5886b("mutiCardFactory", "isHwGeminiSupport1 ", String.valueOf(booleanValue));
        return booleanValue;
    }

    private static boolean m5840d() {
        boolean z;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(null);
        } catch (Exception e) {
            C1336d.m5888c("mutiCardFactory", "cannot find ext mtkapi");
            z = false;
        } catch (Error e2) {
            C1336d.m5888c("mutiCardFactory", "MTK NoClassDefFoundError");
            z = false;
        }
        C1336d.m5886b("mutiCardFactory", "isMtkGeminiSupport ", String.valueOf(z));
        return z;
    }
}
