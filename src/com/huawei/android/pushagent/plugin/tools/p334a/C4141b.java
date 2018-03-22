package com.huawei.android.pushagent.plugin.tools.p334a;

public class C4141b {
    private static final char[] f15547a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static int m20223a(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c + " at index " + i);
    }

    public static byte[] m20224a(char[] cArr) {
        int i = 0;
        int length = cArr.length;
        if ((length & 1) != 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(length >> 1)];
        int i2 = 0;
        while (i < length) {
            i++;
            i++;
            bArr[i2] = (byte) (((C4141b.m20223a(cArr[i], i) << 4) | C4141b.m20223a(cArr[i], i)) & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] m20225a(byte[] bArr) {
        return C4141b.m20226a(bArr, f15547a);
    }

    private static char[] m20226a(byte[] bArr, char[] cArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public static String m20227b(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : new String(C4141b.m20225a(bArr));
    }
}
