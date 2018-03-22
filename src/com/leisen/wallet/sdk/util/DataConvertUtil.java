package com.leisen.wallet.sdk.util;

public class DataConvertUtil {
    public static String bytesToHexString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String toUpperCase = str.toUpperCase();
        int length = toUpperCase.length() / 2;
        char[] toCharArray = toUpperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(toCharArray[i2 + 1]) | (charToByte(toCharArray[i2]) << 4));
        }
        return bArr;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
