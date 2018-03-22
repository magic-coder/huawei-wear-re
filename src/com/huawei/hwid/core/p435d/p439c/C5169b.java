package com.huawei.hwid.core.p435d.p439c;

import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.core.p435d.p439c.C5168a.C5167a;
import java.lang.reflect.Field;

/* compiled from: MultiCardFactory */
public class C5169b {
    private static C5167a f18622a = C5167a.MODE_SUPPORT_UNKNOWN;
    private static C5168a f18623b;

    public static synchronized C5168a m24969a() {
        C5168a c5168a;
        synchronized (C5169b.class) {
            C5169b.m24971b();
            if (f18622a == C5167a.MODE_SUPPORT_MTK_GEMINI) {
                f18623b = C5171d.m24981b();
            } else {
                f18623b = C5170c.m24974b();
            }
            c5168a = f18623b;
        }
        return c5168a;
    }

    public static synchronized boolean m24971b() {
        boolean z;
        boolean z2 = true;
        synchronized (C5169b.class) {
            z = false;
            if (f18622a == C5167a.MODE_SUPPORT_UNKNOWN) {
                try {
                    if (C5169b.m24973d()) {
                        C5169b.m24970a(C5167a.MODE_SUPPORT_MTK_GEMINI);
                    } else if (C5169b.m24972c()) {
                        C5169b.m24970a(C5167a.MODE_SUPPORT_HW_GEMINI);
                    } else {
                        C5169b.m24970a(C5167a.MODE_NOT_SUPPORT_GEMINI);
                        z2 = false;
                    }
                    z = z2;
                } catch (Throwable e) {
                    C5165e.m24905a("mutiCardFactory", HwAccountConstants.BLANK + e.getMessage(), e);
                } catch (Throwable e2) {
                    C5165e.m24905a("mutiCardFactory", "" + e2.getMessage(), e2);
                }
            } else if (f18622a == C5167a.MODE_SUPPORT_HW_GEMINI || f18622a == C5167a.MODE_SUPPORT_MTK_GEMINI) {
                z = true;
            }
        }
        return z;
    }

    private static synchronized void m24970a(C5167a c5167a) {
        synchronized (C5169b.class) {
            f18622a = c5167a;
        }
    }

    public static boolean m24972c() {
        boolean z = false;
        try {
            boolean booleanValue;
            Object c = C5170c.m24975c();
            if (c != null) {
                booleanValue = ((Boolean) c.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(c, new Object[0])).booleanValue();
            } else {
                booleanValue = false;
            }
            z = booleanValue;
        } catch (Throwable e) {
            C5165e.m24905a("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()?" + e.getMessage(), e);
        } catch (Throwable e2) {
            C5165e.m24905a("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()" + e2.getMessage(), e2);
        }
        C5165e.m24906b("mutiCardFactory", "isHwGeminiSupport1 " + z);
        return z;
    }

    private static boolean m24973d() {
        boolean z = false;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(null);
        } catch (Throwable e) {
            C5165e.m24905a("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + e.getMessage(), e);
        } catch (Throwable e2) {
            C5165e.m24905a("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + e2.getMessage(), e2);
        }
        C5165e.m24906b("mutiCardFactory", "isMtkGeminiSupport " + z);
        return z;
    }
}
