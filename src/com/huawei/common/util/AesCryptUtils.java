package com.huawei.common.util;

import android.content.Context;

public class AesCryptUtils {
    private static final Object LOCK = new Object();

    public static String encrypt(Context context, String str) {
        String str2;
        synchronized (LOCK) {
            str2 = null;
            if (!(context == null || str == null)) {
                str2 = CommonLibUtil.encrypt(str);
            }
        }
        return str2;
    }
}
