package com.huawei.openalliance.ad.utils.p129b;

public class C1335c {
    public static String m5881a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }
}
