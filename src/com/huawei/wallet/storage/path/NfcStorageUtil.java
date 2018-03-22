package com.huawei.wallet.storage.path;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;

public final class NfcStorageUtil extends StorageUtil {
    public static String m28132a(Context context) {
        return StorageUtil.m28130e(context, "/nfc/");
    }

    public static String m28134b(Context context) {
        return StorageUtil.m28131f(context, "/nfc/");
    }

    public static String m28136c(Context context) {
        return m28134b(context) + "card/";
    }

    public static String m28133a(Context context, String str) {
        return m28136c(context) + str.replaceAll("\\*", HwAccountConstants.SPLIIT_UNDERLINE) + "_icon.png";
    }

    public static String m28135b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(m28132a(context)).append("logo/").append(str).append("_logo.png");
        return stringBuilder.toString();
    }

    public static String m28137c(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(m28132a(context)).append("apkicon/").append(str).append(".png");
        return stringBuilder.toString();
    }

    public static String m28138d(Context context) {
        return m28132a(context) + "rfconf/";
    }

    public static String m28139d(Context context, String str) {
        return m28138d(context) + str + ".conf";
    }
}
