package com.huawei.wallet.utils;

public final class StringUtil {
    private StringUtil() {
    }

    public static boolean m28479a(String str, boolean z) {
        if (str == null) {
            return true;
        }
        if (z) {
            if (str.trim().length() <= 0) {
                return true;
            }
        } else if (str.length() <= 0) {
            return true;
        }
        return false;
    }
}
