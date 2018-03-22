package com.huawei.nfc.util;

import android.content.Context;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.wallet.utils.ProductConfigUtil;

public class NFCFragmentUtil {
    public static final int NFC_SHOW_CARRERA = 2;
    public static final int NFC_SHOW_NOT_SUPPORT = 0;

    public static int getNFCShowPlan(Context context) {
        if (isPhoneSupportNFC(context)) {
            String[] a = ProductConfigUtil.a();
            if (a == null || a.length == 0) {
                LogX.m5465d("getNFCShowPlan, no product config exist.");
                return 0;
            }
            int i;
            if ("01".equals(a[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                LogX.m5465d("getNFCShowPlan, do not support ese.");
                return 0;
            } else if (a.length <= 4 || !"01".equals(a[3]) || !"02".equals(a[4])) {
                return 0;
            } else {
                LogX.m5465d("getNFCShowPlan, config fits carrera.");
                LogX.m5465d("getNFCShowPlan, carrera show plan.");
                NfcUtil.enableNFCOffHostService(context);
                return 2;
            }
        }
        LogX.m5465d("getNFCShowPlan, The phone is not support nfc.");
        return 0;
    }

    public static boolean isPhoneSupportNFC(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public static boolean isPhoneSupportShutdownSwipe() {
        return false;
    }
}
