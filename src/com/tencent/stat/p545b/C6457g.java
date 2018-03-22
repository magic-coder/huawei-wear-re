package com.tencent.stat.p545b;

public class C6457g {
    static final byte[] f22410a = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();

    public static byte[] m29419a(byte[] bArr) {
        return C6457g.m29420a(bArr, f22410a);
    }

    static byte[] m29420a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length < 1 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        for (i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        length = 0;
        for (i2 = 0; i2 < 256; i2++) {
            length = ((length + iArr[i2]) + iArr2[i2]) & 255;
            int i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            length = (length + 1) & 255;
            i2 = (i2 + iArr[length]) & 255;
            i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
            bArr3[i] = (byte) (iArr[(iArr[length] + iArr[i2]) & 255] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }

    public static byte[] m29421b(byte[] bArr) {
        return C6457g.m29422b(bArr, f22410a);
    }

    static byte[] m29422b(byte[] bArr, byte[] bArr2) {
        return C6457g.m29420a(bArr, bArr2);
    }
}
