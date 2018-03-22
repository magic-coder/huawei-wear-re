package com.snowballtech.common.util;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.regex.Pattern;

public class ValueUtil {
    private static final int GB = 1073741824;
    private static final int KB = 1024;
    private static final int MG = 1048576;

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        String trim = str.replaceAll(HwAccountConstants.BLANK, "").trim();
        if (trim == null || "".equals(trim.trim())) {
            return true;
        }
        return false;
    }

    public static int parseInt(String str) {
        return parseInt(str, 10);
    }

    public static long parseLong(String str) {
        return parseLong(str, 10);
    }

    private static boolean match(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    public static String toHex(int i, int i2, String str) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(i));
        int length = i2 - stringBuilder.length();
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                stringBuilder.insert(0, str);
            }
        }
        return stringBuilder.toString();
    }

    public static String toBin(int i, int i2, String str) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(i));
        int length = i2 - stringBuilder.length();
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                stringBuilder.insert(0, str);
            }
        }
        return stringBuilder.toString();
    }

    public static int parseInt(String str, int i) {
        if (!isEmpty(str)) {
            try {
                return Integer.parseInt(str, i);
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public static long parseLong(String str, int i) {
        if (!isEmpty(str)) {
            try {
                return Long.parseLong(str, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static String toLV(String str) {
        String str2 = "";
        if (isEmpty(str)) {
            return str2;
        }
        return toHex(str.length() / 2, 2, "0") + str;
    }

    public static boolean matchZero(String str) {
        return Pattern.matches("[0]*", str);
    }
}
