package com.huawei.nfc.carrera.util;

import android.app.Activity;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import com.huawei.nfc.carrera.logic.swipe.SwipeLogicManager;
import com.huawei.nfc.util.NFCFragmentUtil;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.wallet.utils.device.PhoneDeviceUtil;
import java.lang.reflect.InvocationTargetException;

public final class NfcUtil {
    static final long BUILD_TIME = 1479355200;
    public static final int SELECT_DEFAULT_CARD_EMULATION_SE = 1;
    public static final int SELECT_DEFAULT_CARD_EMULATION_UICC = -1;
    public static final int SELECT_DEFAULT_CARD_EMULATION_UNKNOWN = 0;

    public static boolean isEnabledNFC(Context context) {
        if (context == null) {
            return false;
        }
        NfcManager nfcManager = (NfcManager) context.getSystemService(SwipeLogicManager.NFC_PAYFORM);
        if (nfcManager == null) {
            return false;
        }
        NfcAdapter defaultAdapter = nfcManager.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static int isSelectSE(Context context) {
        return selectOrCheckSE(context, true);
    }

    public static void selectSE(Context context) {
        selectOrCheckSE(context, false);
    }

    private static int selectOrCheckSE(Context context, boolean z) {
        try {
            int i;
            Class cls = Class.forName("com.huawei.android.nfc.NfcAdapterCustEx");
            if (z) {
                if (2 == ((Integer) cls.getDeclaredMethod("getSelectedCardEmulation", new Class[]{Context.class}).invoke(cls, new Object[]{context})).intValue()) {
                    i = 1;
                } else {
                    i = -1;
                }
            } else {
                cls.getDeclaredMethod("selectCardEmulation", new Class[]{Context.class, Integer.TYPE}).invoke(cls, new Object[]{context, Integer.valueOf(2)});
                i = 0;
            }
            return i;
        } catch (Throwable e) {
            LogX.m5472e("isSelectSE ClassNotFoundException", e);
            return 0;
        } catch (Throwable e2) {
            LogX.m5472e("isSelectSE NoSuchMethodException", e2);
            return 0;
        } catch (Throwable e22) {
            LogX.m5472e("isSelectSE IllegalAccessException", e22);
            return 0;
        } catch (Throwable e222) {
            LogX.m5472e("isSelectSE IllegalArgumentException", e222);
            return 0;
        } catch (Throwable e2222) {
            LogX.m5472e("isSelectSE InvocationTargetException", e2222);
            return 0;
        }
    }

    public static boolean isMatchPayCondition(Context context) {
        if (2 != NFCFragmentUtil.getNFCShowPlan(context)) {
            LogX.m5475i("isMatchPayCondition not CARRERA plan");
            return false;
        } else if (!isEnabledNFC(context)) {
            LogX.m5475i("isMatchPayCondition nfc not support or not enabled");
            return false;
        } else if (1 != isSelectSE(context)) {
            LogX.m5475i("isMatchPayCondition not select SE");
            return false;
        } else if (isCurrentDefaultPayService(context)) {
            return true;
        } else {
            LogX.m5475i("isMatchPayCondition huawei pay not default pay service");
            return false;
        }
    }

    public static boolean enableNFC(Context context) {
        try {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
            if (defaultAdapter == null) {
                return false;
            }
            return ((Boolean) defaultAdapter.getClass().getDeclaredMethod(JoinConstants.ENABLE, (Class[]) null).invoke(defaultAdapter, (Object[]) null)).booleanValue();
        } catch (NoSuchMethodException e) {
            LogX.m5469e("enabledNFC NoSuchMethodException.");
            return false;
        } catch (IllegalAccessException e2) {
            LogX.m5469e("enabledNFC IllegalAccessException.");
            return false;
        } catch (IllegalArgumentException e3) {
            LogX.m5469e("enabledNFC IllegalArgumentException.");
            return false;
        } catch (InvocationTargetException e4) {
            LogX.m5469e("enabledNFC InvocationTargetException.");
            return false;
        }
    }

    public static boolean isSupportNFCSwipe(Context context) {
        boolean isEnabledNFC = isEnabledNFC(context);
        boolean isCurrentDefaultPayService = isCurrentDefaultPayService(context);
        int isSelectSE = isSelectSE(context);
        LogX.m5475i("isNFCOpen: " + isEnabledNFC + " ,isDefaultPayService: " + isCurrentDefaultPayService + " ,isSelectSE: " + isSelectSE);
        if (!isEnabledNFC || !isCurrentDefaultPayService || 1 != isSelectSE) {
            return false;
        }
        LogX.m5465d("NFCSwipe isSupported");
        return true;
    }

    public static boolean isDevicesNeedPowerOn() {
        String b = PhoneDeviceUtil.b();
        long j = Build.TIME / 1000;
        LogX.m5475i("isDevicesNeedPowerOn, deviceType and build time : deviceType  is :" + b + ",build time is :" + j);
        if ((b.contains("KNT") || b.contains("FRD")) && j < BUILD_TIME) {
            return false;
        }
        return true;
    }

    public static boolean isCurrentDefaultPayService(Context context) {
        return false;
    }

    public static void setDefaultPayService(Activity activity) {
        if (activity != null) {
        }
    }

    public static void enableNFCOffHostService(Context context) {
    }

    public static boolean hasFieldOffBroadcast() {
        String b = PhoneDeviceUtil.b();
        LogX.m5475i("hasFieldOffBroadcast, deviceType: " + b);
        if (b.contains("CRR")) {
            return false;
        }
        return true;
    }
}
