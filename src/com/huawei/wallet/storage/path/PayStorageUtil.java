package com.huawei.wallet.storage.path;

import android.content.Context;

public final class PayStorageUtil extends StorageUtil {
    private static String m28144e(Context context) {
        return StorageUtil.m28130e(context, "/pay/");
    }

    public static String m28140a(Context context) {
        return StorageUtil.m28131f(context, "/pay/");
    }

    public static String m28141b(Context context) {
        return m28140a(context) + "card/";
    }

    public static String m28142c(Context context) {
        return m28144e(context) + "logo/";
    }

    public static String m28143d(Context context) {
        return m28144e(context) + "download";
    }
}
