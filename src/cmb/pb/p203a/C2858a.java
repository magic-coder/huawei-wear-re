package cmb.pb.p203a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

public final class C2858a {
    private static final char[] f9235a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] f9236b = new byte[128];
    private static final char[] f9237c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '-'};
    private static final byte[] f9238d = new byte[128];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < f9236b.length; i++) {
            f9236b[i] = TagName.ELECTRONIC_PUBLISH_START_TIME;
        }
        for (i = 0; i < f9235a.length; i++) {
            f9236b[f9235a[i]] = (byte) i;
        }
        for (i = 0; i < f9238d.length; i++) {
            f9238d[i] = TagName.ELECTRONIC_PUBLISH_START_TIME;
        }
        while (i2 < f9237c.length) {
            f9238d[f9237c[i2]] = (byte) i2;
            i2++;
        }
    }

    public static String m12948a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr = new char[(((length / 3) * 4) + 4)];
        int i = 0;
        int i2 = length + 0;
        length = 0;
        while (i2 >= 3) {
            int i3 = (((bArr[i] & 255) << 16) + ((bArr[i + 1] & 255) << 8)) + (bArr[i + 2] & 255);
            int i4 = length + 1;
            cArr[length] = f9235a[i3 >> 18];
            length = i4 + 1;
            cArr[i4] = f9235a[(i3 >> 12) & 63];
            i4 = length + 1;
            cArr[length] = f9235a[(i3 >> 6) & 63];
            length = i4 + 1;
            cArr[i4] = f9235a[i3 & 63];
            i += 3;
            i2 -= 3;
        }
        if (i2 == 1) {
            i = bArr[i] & 255;
            i2 = length + 1;
            cArr[length] = f9235a[i >> 2];
            length = i2 + 1;
            cArr[i2] = f9235a[(i << 4) & 63];
            i = length + 1;
            cArr[length] = '=';
            length = i + 1;
            cArr[i] = '=';
        } else if (i2 == 2) {
            i = (bArr[i + 1] & 255) + ((bArr[i] & 255) << 8);
            i2 = length + 1;
            cArr[length] = f9235a[i >> 10];
            length = i2 + 1;
            cArr[i2] = f9235a[(i >> 4) & 63];
            i2 = length + 1;
            cArr[length] = f9235a[(i << 2) & 63];
            length = i2 + 1;
            cArr[i2] = '=';
        }
        return new String(cArr, 0, length);
    }

    public static byte[] m12949a(String str) {
        char[] cArr = new char[4];
        Object obj = new byte[(((str.length() / 4) * 3) + 3)];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '=' || (charAt < f9236b.length && f9236b[charAt] != TagName.ELECTRONIC_PUBLISH_START_TIME)) {
                int i4 = i2 + 1;
                cArr[i2] = charAt;
                if (i4 == cArr.length) {
                    i2 = cArr[3] == '=' ? 2 : 3;
                    if (cArr[2] == '=') {
                        i2 = 1;
                    }
                    byte b = f9236b[cArr[0]];
                    byte b2 = f9236b[cArr[1]];
                    byte b3 = f9236b[cArr[2]];
                    byte b4 = f9236b[cArr[3]];
                    switch (i2) {
                        case 2:
                            i2 = i + 1;
                            obj[i] = (byte) (((b << 2) & 252) | ((b2 >> 4) & 3));
                            obj[i2] = (byte) (((b2 << 4) & 240) | ((b3 >> 2) & 15));
                            i2 = 2;
                            break;
                        case 3:
                            i2 = i + 1;
                            obj[i] = (byte) (((b << 2) & 252) | ((b2 >> 4) & 3));
                            i4 = i2 + 1;
                            obj[i2] = (byte) (((b2 << 4) & 240) | ((b3 >> 2) & 15));
                            obj[i4] = (byte) (((b3 << 6) & 192) | (b4 & 63));
                            i2 = 3;
                            break;
                        default:
                            obj[i] = (byte) (((b << 2) & 252) | ((b2 >> 4) & 3));
                            i2 = 1;
                            break;
                    }
                    i += i2;
                    i2 = 0;
                } else {
                    i2 = i4;
                }
            }
        }
        if (i == obj.length) {
            return obj;
        }
        Object obj2 = new byte[i];
        System.arraycopy(obj, 0, obj2, 0, i);
        return obj2;
    }

    public static String m12950b(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr = new char[(((length / 3) * 4) + 4)];
        int i = 0;
        int i2 = length + 0;
        length = 0;
        while (i2 >= 3) {
            int i3 = (((bArr[i] & 255) << 16) + ((bArr[i + 1] & 255) << 8)) + (bArr[i + 2] & 255);
            int i4 = length + 1;
            cArr[length] = f9237c[i3 >> 18];
            length = i4 + 1;
            cArr[i4] = f9237c[(i3 >> 12) & 63];
            i4 = length + 1;
            cArr[length] = f9237c[(i3 >> 6) & 63];
            length = i4 + 1;
            cArr[i4] = f9237c[i3 & 63];
            i += 3;
            i2 -= 3;
        }
        if (i2 == 1) {
            i = bArr[i] & 255;
            i2 = length + 1;
            cArr[length] = f9237c[i >> 2];
            length = i2 + 1;
            cArr[i2] = f9237c[(i << 4) & 63];
            i = length + 1;
            cArr[length] = '_';
            length = i + 1;
            cArr[i] = '_';
        } else if (i2 == 2) {
            i = (bArr[i + 1] & 255) + ((bArr[i] & 255) << 8);
            i2 = length + 1;
            cArr[length] = f9237c[i >> 10];
            length = i2 + 1;
            cArr[i2] = f9237c[(i >> 4) & 63];
            i2 = length + 1;
            cArr[length] = f9237c[(i << 2) & 63];
            length = i2 + 1;
            cArr[i2] = '_';
        }
        return new String(cArr, 0, length);
    }

    public static boolean m12951b(String str) {
        return str == null || str.length() <= 0;
    }
}
