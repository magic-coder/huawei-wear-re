package com.alipay.sdk.p245b;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

public final class C3170a {
    private static final byte[] f10573a = new byte[128];
    private static final char[] f10574b = new char[64];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < 128; i++) {
            f10573a[i] = (byte) -1;
        }
        for (i = 90; i >= 65; i--) {
            f10573a[i] = (byte) (i - 65);
        }
        for (i = 122; i >= 97; i--) {
            f10573a[i] = (byte) ((i - 97) + 26);
        }
        for (i = 57; i >= 48; i--) {
            f10573a[i] = (byte) ((i - 48) + 52);
        }
        f10573a[43] = TagName.CARD_BUSINESS_ORDER_STATUS;
        f10573a[47] = TagName.CARD_APP_ACTIVATION_STATUS;
        for (i = 0; i <= 25; i++) {
            f10574b[i] = (char) (i + 65);
        }
        int i3 = 26;
        i = 0;
        while (i3 <= 51) {
            f10574b[i3] = (char) (i + 97);
            i3++;
            i++;
        }
        i = 52;
        while (i <= 61) {
            f10574b[i] = (char) (i2 + 48);
            i++;
            i2++;
        }
        f10574b[62] = '+';
        f10574b[63] = '/';
    }

    private static boolean m14011a(char c) {
        return c == '=';
    }

    private static boolean m14013b(char c) {
        return c < '' && f10573a[c] != (byte) -1;
    }

    public static byte[] m14012a(String str) {
        if (str == null) {
            return null;
        }
        int i;
        int length;
        int i2;
        int i3;
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            i = 0;
        } else {
            length = toCharArray.length;
            i2 = 0;
            i = 0;
            while (i2 < length) {
                char c = toCharArray[i2];
                i3 = (c == ' ' || c == '\r' || c == '\n' || c == '\t') ? 1 : 0;
                if (i3 == 0) {
                    i3 = i + 1;
                    toCharArray[i] = toCharArray[i2];
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
        }
        if (i % 4 != 0) {
            return null;
        }
        int i4 = i / 4;
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(i4 * 3)];
        i = 0;
        i2 = 0;
        length = 0;
        while (length < i4 - 1) {
            char c2;
            int i5 = i + 1;
            char c3 = toCharArray[i];
            if (C3170a.m14013b(c3)) {
                i = i5 + 1;
                c2 = toCharArray[i5];
                if (C3170a.m14013b(c2)) {
                    int i6 = i + 1;
                    char c4 = toCharArray[i];
                    if (C3170a.m14013b(c4)) {
                        i = i6 + 1;
                        char c5 = toCharArray[i6];
                        if (C3170a.m14013b(c5)) {
                            byte b = f10573a[c3];
                            byte b2 = f10573a[c2];
                            byte b3 = f10573a[c4];
                            byte b4 = f10573a[c5];
                            int i7 = i2 + 1;
                            bArr[i2] = (byte) ((b << 2) | (b2 >> 4));
                            int i8 = i7 + 1;
                            bArr[i7] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i2 = i8 + 1;
                            bArr[i8] = (byte) ((b3 << 6) | b4);
                            length++;
                        }
                    }
                }
            }
            return null;
        }
        i4 = i + 1;
        char c6 = toCharArray[i];
        if (C3170a.m14013b(c6)) {
            i5 = i4 + 1;
            char c7 = toCharArray[i4];
            if (C3170a.m14013b(c7)) {
                b = f10573a[c6];
                byte b5 = f10573a[c7];
                i = i5 + 1;
                c2 = toCharArray[i5];
                c6 = toCharArray[i];
                if (C3170a.m14013b(c2) && C3170a.m14013b(c6)) {
                    byte b6 = f10573a[c2];
                    byte b7 = f10573a[c6];
                    int i9 = i2 + 1;
                    bArr[i2] = (byte) ((b << 2) | (b5 >> 4));
                    i2 = i9 + 1;
                    bArr[i9] = (byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15));
                    bArr[i2] = (byte) (b7 | (b6 << 6));
                    return bArr;
                } else if (C3170a.m14011a(c2) && C3170a.m14011a(c6)) {
                    if ((b5 & 15) != 0) {
                        return null;
                    }
                    r1 = new byte[((length * 3) + 1)];
                    System.arraycopy(bArr, 0, r1, 0, length * 3);
                    r1[i2] = (byte) ((b << 2) | (b5 >> 4));
                    return r1;
                } else if (C3170a.m14011a(c2) || !C3170a.m14011a(c6)) {
                    return null;
                } else {
                    byte b8 = f10573a[c2];
                    if ((b8 & 3) != 0) {
                        return null;
                    }
                    r1 = new byte[((length * 3) + 2)];
                    System.arraycopy(bArr, 0, r1, 0, length * 3);
                    i3 = i2 + 1;
                    r1[i2] = (byte) ((b << 2) | (b5 >> 4));
                    r1[i3] = (byte) (((b5 & 15) << 4) | ((b8 >> 2) & 15));
                    return r1;
                }
            }
        }
        return null;
    }
}
