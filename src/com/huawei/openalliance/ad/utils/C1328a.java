package com.huawei.openalliance.ad.utils;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

public class C1328a {
    private static final char[] f2866a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] f2867b = new byte[256];

    static {
        int i;
        for (i = 0; i < 256; i++) {
            f2867b[i] = (byte) -1;
        }
        for (i = 65; i <= 90; i++) {
            f2867b[i] = (byte) (i - 65);
        }
        for (i = 97; i <= 122; i++) {
            f2867b[i] = (byte) ((i + 26) - 97);
        }
        for (i = 48; i <= 57; i++) {
            f2867b[i] = (byte) ((i + 52) - 48);
        }
        f2867b[43] = TagName.CARD_BUSINESS_ORDER_STATUS;
        f2867b[47] = TagName.CARD_APP_ACTIVATION_STATUS;
    }

    public static String m5849a(byte[] bArr) {
        return C1328a.m5850a(bArr, bArr.length);
    }

    public static String m5850a(byte[] bArr, int i) {
        char[] cArr = new char[(((i + 2) / 3) * 4)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 3) {
            Object obj;
            Object obj2;
            int i4 = (bArr[i3] & 255) << 8;
            if (i3 + 1 < i) {
                i4 |= bArr[i3 + 1] & 255;
                obj = 1;
            } else {
                obj = null;
            }
            i4 <<= 8;
            if (i3 + 2 < i) {
                i4 |= bArr[i3 + 2] & 255;
                obj2 = 1;
            } else {
                obj2 = null;
            }
            cArr[i2 + 3] = f2866a[obj2 != null ? i4 & 63 : 64];
            int i5 = i4 >> 6;
            cArr[i2 + 2] = f2866a[obj != null ? i5 & 63 : 64];
            i4 = i5 >> 6;
            cArr[i2 + 1] = f2866a[i4 & 63];
            cArr[i2 + 0] = f2866a[(i4 >> 6) & 63];
            i2 += 4;
        }
        return new String(cArr);
    }
}
