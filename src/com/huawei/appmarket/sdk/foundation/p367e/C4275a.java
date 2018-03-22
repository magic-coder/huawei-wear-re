package com.huawei.appmarket.sdk.foundation.p367e;

public class C4275a {
    public static String m20647a(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            i2 = i3 + 1;
            cArr2[i3] = cArr[b & 15];
            i++;
        }
        return new String(cArr2);
    }
}
