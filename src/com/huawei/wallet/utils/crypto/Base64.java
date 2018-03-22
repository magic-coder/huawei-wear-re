package com.huawei.wallet.utils.crypto;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

public final class Base64 {
    private static final byte[] f21611a = new byte[128];
    private static final char[] f21612b = new char[64];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < 128; i++) {
            f21611a[i] = (byte) -1;
        }
        for (i = 90; i >= 65; i--) {
            f21611a[i] = (byte) (i - 65);
        }
        for (i = 122; i >= 97; i--) {
            f21611a[i] = (byte) ((i - 97) + 26);
        }
        for (i = 57; i >= 48; i--) {
            f21611a[i] = (byte) ((i - 48) + 52);
        }
        f21611a[43] = TagName.CARD_BUSINESS_ORDER_STATUS;
        f21611a[47] = TagName.CARD_APP_ACTIVATION_STATUS;
        for (i = 0; i <= 25; i++) {
            f21612b[i] = (char) (i + 65);
        }
        int i3 = 26;
        i = 0;
        while (i3 <= 51) {
            f21612b[i3] = (char) (i + 97);
            i3++;
            i++;
        }
        i = 52;
        while (i <= 61) {
            f21612b[i] = (char) (i2 + 48);
            i++;
            i2++;
        }
        f21612b[62] = '+';
        f21612b[63] = '/';
    }

    private static boolean m28511a(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private static boolean m28513b(char c) {
        return c == '=';
    }

    private static boolean m28514c(char c) {
        return c < '' && f21611a[c] != (byte) -1;
    }

    public static byte[] m28512a(String str) {
        if (str == null) {
            return new byte[0];
        }
        char[] toCharArray = str.toCharArray();
        int a = m28510a(toCharArray);
        if (a % 4 != 0) {
            return new byte[0];
        }
        int i = a / 4;
        if (i == 0) {
            return new byte[0];
        }
        int i2;
        char c;
        char c2;
        Object obj;
        int i3;
        char c3;
        byte b;
        byte b2;
        byte[] bArr;
        byte b3;
        Object obj2 = new byte[(i * 3)];
        int i4 = 0;
        char c4 = '\u0000';
        int i5 = 0;
        int i6 = 0;
        char c5 = '\u0000';
        int i7 = 0;
        while (i4 < i - 1) {
            i2 = i6 + 1;
            char c6 = toCharArray[i6];
            if (m28514c(c6)) {
                a = i2 + 1;
                c = toCharArray[i2];
                if (m28514c(c)) {
                    i2 = a + 1;
                    i5 = toCharArray[a];
                    if (m28514c(i5)) {
                        a = i2 + 1;
                        c2 = toCharArray[i2];
                        if (m28514c(c2)) {
                            c4 = c2;
                            i2 = a;
                            obj = null;
                            if (obj != null) {
                                return new byte[0];
                            }
                            byte b4 = f21611a[c6];
                            byte b5 = f21611a[c];
                            byte b6 = f21611a[i5];
                            byte b7 = f21611a[c4];
                            int i8 = i7 + 1;
                            obj2[i7] = (byte) ((b4 << 2) | (b5 >> 4));
                            i7 = i8 + 1;
                            obj2[i8] = (byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15));
                            a = i7 + 1;
                            obj2[i7] = (byte) ((b6 << 6) | b7);
                            i4++;
                            i7 = a;
                            c5 = c;
                            i6 = i2;
                        } else {
                            i3 = i5;
                            c3 = c;
                        }
                    } else {
                        a = i2;
                        c2 = c4;
                        i3 = i5;
                        c3 = c;
                    }
                } else {
                    c2 = c4;
                    i3 = i5;
                    c3 = c;
                }
            } else {
                int i9 = i2;
                c2 = c4;
                i3 = i5;
                c3 = c5;
                a = i9;
            }
            c = c3;
            i5 = i3;
            c4 = c2;
            i2 = a;
            obj = 1;
            if (obj != null) {
                return new byte[0];
            }
            byte b42 = f21611a[c6];
            byte b52 = f21611a[c];
            byte b62 = f21611a[i5];
            byte b72 = f21611a[c4];
            int i82 = i7 + 1;
            obj2[i7] = (byte) ((b42 << 2) | (b52 >> 4));
            i7 = i82 + 1;
            obj2[i82] = (byte) (((b52 & 15) << 4) | ((b62 >> 2) & 15));
            a = i7 + 1;
            obj2[i7] = (byte) ((b62 << 6) | b72);
            i4++;
            i7 = a;
            c5 = c;
            i6 = i2;
        }
        i2 = i6 + 1;
        c3 = toCharArray[i6];
        Object obj3;
        if (m28514c(c3)) {
            a = i2 + 1;
            c2 = toCharArray[i2];
            if (m28514c(c2)) {
                c4 = c2;
                i2 = a;
                obj = null;
                if (obj != null) {
                    return new byte[0];
                }
                b = f21611a[c3];
                b2 = f21611a[i3];
                a = i2 + 1;
                c = toCharArray[i2];
                i2 = a + 1;
                c2 = toCharArray[a];
                obj = (m28514c(c) || !m28514c(c2)) ? 1 : null;
                if (obj == null) {
                    obj = (m28513b(c) || !m28513b(c2)) ? null : 1;
                    obj3 = (m28513b(c) || !m28513b(c2)) ? null : 1;
                    if (obj == null) {
                        if ((b2 & 15) != 0) {
                            return new byte[0];
                        }
                        bArr = new byte[((i4 * 3) + 1)];
                        System.arraycopy(obj2, 0, bArr, 0, i4 * 3);
                        bArr[i7] = (byte) ((b << 2) | (b2 >> 4));
                        return bArr;
                    } else if (obj3 != null) {
                        return new byte[0];
                    } else {
                        b3 = f21611a[c];
                        if ((b3 & 3) != 0) {
                            return new byte[0];
                        }
                        bArr = new byte[((i4 * 3) + 2)];
                        System.arraycopy(obj2, 0, bArr, 0, i4 * 3);
                        i6 = i7 + 1;
                        bArr[i7] = (byte) ((b << 2) | (b2 >> 4));
                        bArr[i6] = (byte) (((b3 >> 2) & 15) | ((b2 & 15) << 4));
                        return bArr;
                    }
                }
                b42 = f21611a[c];
                b3 = f21611a[c2];
                i6 = i7 + 1;
                obj2[i7] = (byte) ((b << 2) | (b2 >> 4));
                i5 = i6 + 1;
                obj2[i6] = (byte) (((b2 & 15) << 4) | ((b42 >> 2) & 15));
                i3 = i5 + 1;
                obj2[i5] = (byte) ((b42 << 6) | b3);
                return obj2;
            }
        }
        i9 = i2;
        c2 = c5;
        a = i9;
        i3 = c2;
        i2 = a;
        obj = 1;
        if (obj != null) {
            return new byte[0];
        }
        b = f21611a[c3];
        b2 = f21611a[i3];
        a = i2 + 1;
        c = toCharArray[i2];
        i2 = a + 1;
        c2 = toCharArray[a];
        if (m28514c(c)) {
        }
        if (obj == null) {
            b42 = f21611a[c];
            b3 = f21611a[c2];
            i6 = i7 + 1;
            obj2[i7] = (byte) ((b << 2) | (b2 >> 4));
            i5 = i6 + 1;
            obj2[i6] = (byte) (((b2 & 15) << 4) | ((b42 >> 2) & 15));
            i3 = i5 + 1;
            obj2[i5] = (byte) ((b42 << 6) | b3);
            return obj2;
        }
        if (m28513b(c)) {
        }
        if (!m28513b(c)) {
        }
        if (obj == null) {
            if (obj3 != null) {
                return new byte[0];
            }
            b3 = f21611a[c];
            if ((b3 & 3) != 0) {
                return new byte[0];
            }
            bArr = new byte[((i4 * 3) + 2)];
            System.arraycopy(obj2, 0, bArr, 0, i4 * 3);
            i6 = i7 + 1;
            bArr[i7] = (byte) ((b << 2) | (b2 >> 4));
            bArr[i6] = (byte) (((b3 >> 2) & 15) | ((b2 & 15) << 4));
            return bArr;
        } else if ((b2 & 15) != 0) {
            return new byte[0];
        } else {
            bArr = new byte[((i4 * 3) + 1)];
            System.arraycopy(obj2, 0, bArr, 0, i4 * 3);
            bArr[i7] = (byte) ((b << 2) | (b2 >> 4));
            return bArr;
        }
    }

    private static int m28510a(char[] cArr) {
        int i = 0;
        if (cArr != null) {
            int length = cArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                if (m28511a(cArr[i2])) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                    cArr[i] = cArr[i2];
                }
                i2++;
                i = i3;
            }
        }
        return i;
    }
}
