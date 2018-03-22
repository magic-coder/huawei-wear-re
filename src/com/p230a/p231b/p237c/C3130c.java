package com.p230a.p231b.p237c;

public class C3130c {
    public static String m13936a(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length << 1)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr2[i << 1] = cArr[i2 >>> 4];
            cArr2[(i << 1) + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] m13937a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static int m13938b(String str) {
        int i = 0;
        if (!(str == null || str.trim().equals(""))) {
            try {
                i = Integer.valueOf(str, 16).intValue();
            } catch (Exception e) {
            }
        }
        return i;
    }
}
