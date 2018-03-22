package com.p230a.p231b.p237c;

public class C3132e {
    public static String m13951a(String str, String str2) {
        return C3132e.m13953a(str) ? str2 : str;
    }

    public static String m13952a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static boolean m13953a(String str) {
        return str == null || "".equals(str);
    }
}
