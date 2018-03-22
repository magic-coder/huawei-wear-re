package com.huawei.android.pushagent.p018c.p330b;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p330b.C4108a.C4107a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.lang.reflect.Field;

public class C4109b {
    private static C4107a f15501a = C4107a.MODE_SUPPORT_UNKNOWN;
    private static C4108a f15502b;

    public static synchronized C4108a m20131a() {
        C4108a c4108a;
        synchronized (C4109b.class) {
            C4109b.m20133b();
            if (f15501a == C4107a.MODE_SUPPORT_MTK_GEMINI) {
                f15502b = C4111d.m20139a();
            } else {
                f15502b = C4110c.m20136a();
            }
            c4108a = f15502b;
        }
        return c4108a;
    }

    private static synchronized void m20132a(C4107a c4107a) {
        synchronized (C4109b.class) {
            f15501a = c4107a;
        }
    }

    public static synchronized boolean m20133b() {
        boolean z;
        boolean z2 = true;
        synchronized (C4109b.class) {
            z = false;
            if (f15501a == C4107a.MODE_SUPPORT_UNKNOWN) {
                try {
                    if (C4109b.m20135d()) {
                        C4109b.m20132a(C4107a.MODE_SUPPORT_MTK_GEMINI);
                    } else if (C4109b.m20134c()) {
                        C4109b.m20132a(C4107a.MODE_SUPPORT_HW_GEMINI);
                    } else {
                        C4109b.m20132a(C4107a.MODE_NOT_SUPPORT_GEMINI);
                        z2 = false;
                    }
                    z = z2;
                } catch (Exception e) {
                    e.d("mutiCardFactory", HwAccountConstants.BLANK + e.toString());
                } catch (Error e2) {
                    e.d("mutiCardFactory", "" + e2.toString());
                }
            } else if (f15501a == C4107a.MODE_SUPPORT_HW_GEMINI || f15501a == C4107a.MODE_SUPPORT_MTK_GEMINI) {
                z = true;
            }
        }
        return z;
    }

    public static boolean m20134c() {
        boolean z = false;
        try {
            Object b = C4110c.m20137b();
            z = b != null ? ((Boolean) b.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(b, new Object[0])).booleanValue() : false;
        } catch (Exception e) {
            e.d("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()?" + e.toString());
        } catch (Error e2) {
            e.d("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()" + e2.toString());
        }
        e.b("mutiCardFactory", "isHwGeminiSupport1 " + z);
        return z;
    }

    private static boolean m20135d() {
        boolean z = false;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(null);
        } catch (Exception e) {
            e.d("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + e.toString());
        } catch (Error e2) {
            e.d("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + e2.toString());
        }
        e.b("mutiCardFactory", "isMtkGeminiSupport " + z);
        return z;
    }
}
