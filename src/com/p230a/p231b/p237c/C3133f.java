package com.p230a.p231b.p237c;

public class C3133f {
    public static byte m13954a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static byte[] m13955a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String toUpperCase = str.toUpperCase();
        byte[] bArr = new byte[(toUpperCase.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i << 1;
            bArr[i] = (byte) (C3133f.m13954a(toUpperCase.charAt(i2 + 1)) | (C3133f.m13954a(toUpperCase.charAt(i2)) << 4));
        }
        return bArr;
    }

    public static String m13956b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = C3133f.m13955a(str).length;
        System.out.println(length);
        int i = length / 256;
        System.out.println(i);
        length %= 256;
        System.out.println(length);
        if (i < 16) {
            stringBuffer.append("0");
        }
        stringBuffer.append(Integer.toHexString(i).toString());
        if (length < 16) {
            stringBuffer.append("0");
        }
        stringBuffer.append(Integer.toHexString(length).toString());
        stringBuffer.append(str);
        return stringBuffer.toString().toUpperCase();
    }
}
