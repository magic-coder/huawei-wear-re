package com.huawei.wallet.logic.multicard;

import com.huawei.wallet.logic.multicard.MultiCard.SupportMode;
import com.huawei.wallet.utils.log.LogC;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MultiCardFactory {
    private static SupportMode f21275a = SupportMode.MODE_SUPPORT_UNKNOWN;
    private static MultiCard f21276b;

    public static MultiCard m28062a() {
        m28063b();
        if (f21275a == SupportMode.MODE_SUPPORT_MTK_GEMINI) {
            f21276b = MultiCardMTKImpl.m28069a();
        } else {
            f21276b = MultiCardHwImpl.m28066a();
        }
        return f21276b;
    }

    public static boolean m28063b() {
        if (f21275a != SupportMode.MODE_SUPPORT_UNKNOWN) {
            if (f21275a == SupportMode.MODE_SUPPORT_HW_GEMINI || f21275a == SupportMode.MODE_SUPPORT_MTK_GEMINI) {
                return true;
            }
            return false;
        } else if (m28065d()) {
            f21275a = SupportMode.MODE_SUPPORT_MTK_GEMINI;
            return true;
        } else if (m28064c()) {
            f21275a = SupportMode.MODE_SUPPORT_HW_GEMINI;
            return true;
        } else {
            f21275a = SupportMode.MODE_NOT_SUPPORT_GEMINI;
            return false;
        }
    }

    public static boolean m28064c() {
        boolean booleanValue;
        try {
            Object b = MultiCardHwImpl.m28067b();
            if (b != null) {
                booleanValue = ((Boolean) b.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(b, new Object[0])).booleanValue();
                LogC.m28528b("baselib", "isHwGeminiSupport1 " + booleanValue, false);
                return booleanValue;
            }
        } catch (NoSuchMethodException e) {
            LogC.m28531c("baselib", "MSimTelephonyManager.getDefault().isMultiSimEnabled()? isHwGeminiSupport NoSuchMethodException", false);
            booleanValue = false;
        } catch (IllegalAccessException e2) {
            LogC.m28531c("baselib", "MSimTelephonyManager.getDefault().isMultiSimEnabled()? isHwGeminiSupport IllegalAccessException", false);
            booleanValue = false;
        } catch (IllegalArgumentException e3) {
            LogC.m28531c("baselib", "MSimTelephonyManager.getDefault().isMultiSimEnabled()? isHwGeminiSupport IllegalArgumentException", false);
            booleanValue = false;
        } catch (InvocationTargetException e4) {
            LogC.m28531c("baselib", "MSimTelephonyManager.getDefault().isMultiSimEnabled()? isHwGeminiSupport InvocationTargetException", false);
        }
        booleanValue = false;
        LogC.m28528b("baselib", "isHwGeminiSupport1 " + booleanValue, false);
        return booleanValue;
    }

    private static boolean m28065d() {
        boolean z;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(null);
        } catch (ClassNotFoundException e) {
            LogC.m28531c("baselib", "FeatureOption.MTK_GEMINI_SUPPORT ClassNotFoundException has error", false);
            z = false;
        } catch (NoSuchFieldException e2) {
            LogC.m28531c("baselib", "FeatureOption.MTK_GEMINI_SUPPORT NoSuchMethodException", false);
            z = false;
        } catch (IllegalAccessException e3) {
            LogC.m28531c("baselib", "FeatureOption.MTK_GEMINI_SUPPORT IllegalAccessException", false);
            z = false;
        } catch (IllegalArgumentException e4) {
            LogC.m28531c("baselib", "FeatureOption.MTK_GEMINI_SUPPORT IllegalArgumentException", false);
            z = false;
        } catch (Exception e5) {
            LogC.m28531c("baselib", "FeatureOption.MTK_GEMINI_SUPPORT UnKnownError", false);
            z = false;
        }
        LogC.m28528b("baselib", "isMtkGeminiSupport " + z, false);
        return z;
    }
}
