package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c;

public class C4262a {
    public static String m20626a(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return str;
        }
        int i2;
        int i3 = (C4262a.m20629c(str.charAt(0)) || C4262a.m20629c(str.charAt(str.length() - 1))) ? 1 : 0;
        if (i3 == 0) {
            for (i2 = 0; i2 < str.length(); i2++) {
                if (C4262a.m20627a(str.charAt(i2))) {
                    i2 = 1;
                    break;
                }
            }
        }
        i2 = i3;
        if (i2 == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length() + 5);
        stringBuilder.append('\"');
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (C4262a.m20628b(charAt)) {
                stringBuilder.append('^');
            }
            stringBuilder.append(charAt);
            i++;
        }
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }

    public static boolean m20627a(char c) {
        return c == ':' || c == '(' || c == ')' || c == '\'' || c == '*' || C4262a.m20628b(c);
    }

    public static boolean m20628b(char c) {
        return c == '\"' || c == '^';
    }

    public static boolean m20629c(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    public static boolean m20630d(char c) {
        return c > ' ' && c < '';
    }
}
