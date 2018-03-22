package com.huawei.android.pushagent.p018c.p019a.p026a;

import android.text.TextUtils;

public class C0655e {
    private static String m2501a(char c, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    public static String m2502a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() < 2) {
            return str;
        }
        try {
            int ceil = (int) Math.ceil(((double) (str.length() * 25)) / 100.0d);
            int ceil2 = (int) Math.ceil(((double) (str.length() * 50)) / 100.0d);
            return str.substring(0, ceil) + C0655e.m2501a('*', ceil2) + str.substring(ceil + ceil2);
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }
}
