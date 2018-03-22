package com.huawei.hwcommonmodel.p064d;

/* compiled from: CommandPackageUtil */
public class C4726c {
    public static String m22619a(byte b) {
        return "" + ((byte) ((b >> 7) & 1)) + ((byte) ((b >> 6) & 1)) + ((byte) ((b >> 5) & 1)) + ((byte) ((b >> 4) & 1)) + ((byte) ((b >> 3) & 1)) + ((byte) ((b >> 2) & 1)) + ((byte) ((b >> 1) & 1)) + ((byte) ((b >> 0) & 1));
    }

    public static int m22617a(String str) {
        int length = str.length();
        double d = 0.0d;
        for (int i = 0; i < length; i++) {
            d += ((double) Integer.parseInt(str.substring(i, i + 1))) * Math.pow(2.0d, (double) ((length - i) - 1));
        }
        return (int) d;
    }

    public static int m22618a(byte[] bArr) {
        return C4726c.m22617a(C4726c.m22619a(bArr[5]) + C4726c.m22619a(bArr[6]) + C4726c.m22619a(bArr[7]) + C4726c.m22619a(bArr[8]));
    }
}
