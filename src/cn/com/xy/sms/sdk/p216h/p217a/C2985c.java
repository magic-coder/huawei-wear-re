package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.util.Arrays;

public final class C2985c {
    private static final char[] f10107a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] f10108b;

    static {
        int[] iArr = new int[256];
        f10108b = iArr;
        Arrays.fill(iArr, -1);
        int length = f10107a.length;
        for (int i = 0; i < length; i++) {
            f10108b[f10107a[i]] = i;
        }
        f10108b[61] = 0;
    }

    public static final byte[] m13420a(String str) {
        int length = str != null ? str.length() : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i;
        int i2 = 0;
        for (i = 0; i < length; i++) {
            if (f10108b[str.charAt(i)] < 0) {
                i2++;
            }
        }
        if ((length - i2) % 4 != 0) {
            return null;
        }
        i = length;
        int i3 = 0;
        while (i > 1) {
            i--;
            if (f10108b[str.charAt(i)] > 0) {
                break;
            } else if (str.charAt(i) == '=') {
                i3++;
            }
        }
        int i4 = (((length - i2) * 6) >> 3) - i3;
        byte[] bArr = new byte[i4];
        int i5 = 0;
        i2 = 0;
        while (i5 < i4) {
            i = 0;
            i3 = i2;
            i2 = 0;
            while (i2 < 4) {
                int i6 = i3 + 1;
                i3 = f10108b[str.charAt(i3)];
                if (i3 >= 0) {
                    i |= i3 << (18 - (i2 * 6));
                } else {
                    i2--;
                }
                i2++;
                i3 = i6;
            }
            i2 = i5 + 1;
            bArr[i5] = (byte) (i >> 16);
            if (i2 < i4) {
                i6 = i2 + 1;
                bArr[i2] = (byte) (i >> 8);
                if (i6 < i4) {
                    i2 = i6 + 1;
                    bArr[i6] = (byte) i;
                } else {
                    i5 = i6;
                    i2 = i3;
                }
            }
            i5 = i2;
            i2 = i3;
        }
        return bArr;
    }

    public static final byte[] m13421a(byte[] bArr) {
        int i = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i2 = (length / 3) * 3;
        int i3 = (((length - 1) / 3) + 1) << 2;
        int i4 = i3 + (((i3 - 1) / 76) << 1);
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i2) {
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            i8 = ((bArr[i8] & 255) << 8) | ((bArr[i7] & 255) << 16);
            i7 = i9 + 1;
            i8 |= bArr[i9] & 255;
            i9 = i6 + 1;
            bArr2[i6] = (byte) f10107a[(i8 >>> 18) & 63];
            i6 = i9 + 1;
            bArr2[i9] = (byte) f10107a[(i8 >>> 12) & 63];
            i9 = i6 + 1;
            bArr2[i6] = (byte) f10107a[(i8 >>> 6) & 63];
            i6 = i9 + 1;
            bArr2[i9] = (byte) f10107a[i8 & 63];
            i5++;
            if (i5 == 19 && i6 < i4 - 2) {
                i8 = i6 + 1;
                bArr2[i6] = TagName.PAY_CHANNEL;
                i5 = i8 + 1;
                bArr2[i8] = (byte) 10;
                i6 = i5;
                i5 = 0;
            }
        }
        i5 = length - i2;
        if (i5 > 0) {
            i6 = (bArr[i2] & 255) << 10;
            if (i5 == 2) {
                i = (bArr[length - 1] & 255) << 2;
            }
            i |= i6;
            bArr2[i4 - 4] = (byte) f10107a[i >> 12];
            bArr2[i4 - 3] = (byte) f10107a[(i >>> 6) & 63];
            bArr2[i4 - 2] = i5 == 2 ? (byte) f10107a[i & 63] : TagName.CARD_APP_VERSION;
            bArr2[i4 - 1] = TagName.CARD_APP_VERSION;
        }
        return bArr2;
    }

    public static final byte[] m13422b(byte[] bArr) {
        int i;
        int i2 = 0;
        for (byte b : bArr) {
            if (f10108b[b & 255] < 0) {
                i2++;
            }
        }
        if ((r2 - i2) % 4 != 0) {
            return null;
        }
        i = r2;
        int i3 = 0;
        while (i > 1) {
            i--;
            if (f10108b[bArr[i] & 255] > 0) {
                break;
            } else if (bArr[i] == TagName.CARD_APP_VERSION) {
                i3++;
            }
        }
        int i4 = (((r2 - i2) * 6) >> 3) - i3;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        i2 = 0;
        while (i5 < i4) {
            i = 0;
            i3 = i2;
            i2 = 0;
            while (i2 < 4) {
                int i6 = i3 + 1;
                i3 = f10108b[bArr[i3] & 255];
                if (i3 >= 0) {
                    i |= i3 << (18 - (i2 * 6));
                } else {
                    i2--;
                }
                i2++;
                i3 = i6;
            }
            i2 = i5 + 1;
            bArr2[i5] = (byte) (i >> 16);
            if (i2 < i4) {
                i6 = i2 + 1;
                bArr2[i2] = (byte) (i >> 8);
                if (i6 < i4) {
                    i2 = i6 + 1;
                    bArr2[i6] = (byte) i;
                } else {
                    i5 = i6;
                    i2 = i3;
                }
            }
            i5 = i2;
            i2 = i3;
        }
        return bArr2;
    }
}
